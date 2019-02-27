package ine5605g6.detran.iu.paineis.cadastrar;

import ine5605g6.detran.logica.Detran;
import ine5605g6.detran.logica.Infracao;
import ine5605g6.detran.logica.excecoes.ExcecaoObjetoCadastrado;
import ine5605g6.detran.logica.excecoes.ExcecaoPlacaInvalida;
import ine5605g6.detran.logica.excecoes.ExcecaoVeiculosInexistentes;

import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class PainelCadastrarInfracaoManual extends PainelAbstratoManual {

	private static final long serialVersionUID = 1L;
	
	int codigo;
	
	MaskFormatter mask1;
	MaskFormatter mask2;
	
	public PainelCadastrarInfracaoManual (Detran detran) {
		super(detran, "identificação da infração:", "Data da infração:", "Placa do veículo:");
		
	}
	
	@Override
	protected JFormattedTextField retorneCampo1() {
		codigo = 1 + detran.retorneQtdeInfracoes();
		JFormattedTextField jtfIdentificacao = new JFormattedTextField(codigo);
		jtfIdentificacao.setColumns(2);
		jtfIdentificacao.setEditable(false);
		return jtfIdentificacao;
	}

	@Override
	protected JFormattedTextField retorneCampo2() {
		try {
			mask1 = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField jtf = new JFormattedTextField(mask1);
		jtf.setColumns(6);
		return jtf;
	}
	
	@Override
	protected JFormattedTextField retorneCampo3() {
		try {
			mask2 = new MaskFormatter("AAA####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField jtf = new JFormattedTextField(mask2);
		jtf.setColumns(5);
		return jtf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e1)  {
		if (e1.getSource() == btLimpar) {
			jtf2.setValue(null);
			jtf3.setValue(null);
		} else {
			Infracao infracao = new Infracao(codigo);
			int identificacao = Integer.parseInt(jtf1.getText());
			String data = jtf2.getText();
			String placa = jtf3.getText();
			try {
				infracao.setCodigo(identificacao);
				infracao.setPlaca(placa);
				infracao.setDataInfracao(data);	
				detran.cadastreInfracao(infracao);
				codigo++;
				jtf1.setValue(codigo);
				JOptionPane.showMessageDialog(null, "Infração cadastrada com sucesso");
			} catch (ExcecaoPlacaInvalida e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "A Data de Nascimento não pode ser nula ou formada por espaços em branco.");
			} catch (ExcecaoObjetoCadastrado e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
			} catch (ExcecaoVeiculosInexistentes e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}

