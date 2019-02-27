package ine5605g6.detran.iu.paineis.cadastrar;

import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import ine5605g6.detran.logica.Detran;
import ine5605g6.detran.logica.Veiculo;
import ine5605g6.detran.logica.excecoes.ExcecaoCPFInvalido;
import ine5605g6.detran.logica.excecoes.ExcecaoCondutoresInexistentes;
import ine5605g6.detran.logica.excecoes.ExcecaoObjetoCadastrado;
import ine5605g6.detran.logica.excecoes.ExcecaoPlacaInvalida;

public class PainelCadastrarVeiculoManual extends PainelAbstratoManual{

	private static final long serialVersionUID = 1L;
	
	MaskFormatter mask;

	public PainelCadastrarVeiculoManual (Detran detran) {
		super(detran, "Placa do veículo:", "Ano de fabricação:", "CPF do proprietário:");
	}
	
	@Override
	protected JFormattedTextField retorneCampo1() {
		try {
			mask = new MaskFormatter("AAA####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField jtf = new JFormattedTextField(mask);
		jtf.setColumns(5);
		return jtf;
	}
	
	@Override
	protected JFormattedTextField retorneCampo2() {
		try {
			mask = new MaskFormatter("####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField jtf = new JFormattedTextField(mask);
		jtf.setColumns(3);
		return jtf;
	}
	
	@Override
	protected JFormattedTextField retorneCampo3() {
		try {
			mask = new MaskFormatter("###########");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField jtf = new JFormattedTextField(mask);
		jtf.setColumns(8);
		return jtf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e1)  {
		if (e1.getSource() == btLimpar) {
			jtf1.setValue(null);
			jtf2.setValue(null);
			jtf3.setValue(null);
		} else {
			Veiculo veiculo = new Veiculo();
			String placa = jtf1.getText();
			int ano = jtf2.getColumns();
			Long cpfCondutor = 000l;
			try {
				cpfCondutor = Long.parseLong(jtf3.getText());	
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Campo CPF obrigatório");
			}
			try {
				veiculo.setPlaca(placa);
				veiculo.setAnoFabricacao(ano);
				veiculo.setCpfCondutor(cpfCondutor);
				detran.cadastreVeiculo(veiculo);
				JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso");
			} catch (ExcecaoPlacaInvalida e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			} catch (ExcecaoCPFInvalido e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} catch (ExcecaoObjetoCadastrado e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
			} catch (ExcecaoCondutoresInexistentes e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
