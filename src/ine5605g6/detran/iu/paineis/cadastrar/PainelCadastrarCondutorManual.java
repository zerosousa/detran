package ine5605g6.detran.iu.paineis.cadastrar;

import ine5605g6.detran.logica.Condutor;
import ine5605g6.detran.logica.Detran;
import ine5605g6.detran.logica.excecoes.ExcecaoCPFInvalido;
import ine5605g6.detran.logica.excecoes.ExcecaoNomeInvalido;
import ine5605g6.detran.logica.excecoes.ExcecaoObjetoCadastrado;

import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class PainelCadastrarCondutorManual extends PainelAbstratoManual {
	private static final long serialVersionUID = 1L;
	
	MaskFormatter mask1;
	MaskFormatter mask2;

	public PainelCadastrarCondutorManual(Detran detran) {
		super(detran, "Nome completo:", "CPF:", "Data de nascimento:");
	}
	
	@Override
	protected JFormattedTextField retorneCampo1() {
		JFormattedTextField jtf = new JFormattedTextField("");
		jtf.setColumns(30);
		return jtf;
	}
	
	@Override
	protected JFormattedTextField retorneCampo2() {
		try {
			mask1 = new MaskFormatter("###########");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField jtf = new JFormattedTextField(mask1);
		jtf.setColumns(8);
		return jtf;
	}

	@Override
	protected JFormattedTextField retorneCampo3() {
		try {
			mask2 = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField jtf = new JFormattedTextField(mask2);
		jtf.setColumns(6);
		return jtf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e1)  {
		if (e1.getSource() == btLimpar) {
			jtf1.setValue(null);
			jtf2.setValue(null);
			jtf3.setValue(null);
		} else {
	
			Condutor condutor = new Condutor();
			String nome = jtf2.getText();
			Long CPF = 000l;
			try {
				CPF = Long.parseLong(jtf2.getText());	
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Campo CPF é de preenchimento obrigatório");
			}
			String data = jtf3.getText();
			try {
				condutor.setNome(nome);
				condutor.setCpf(CPF);
				condutor.setDataNascimento(data);
				detran.cadastreCondutor(condutor);
				JOptionPane.showMessageDialog(null, "Condutor cadastrado com sucesso");
			} catch (ExcecaoNomeInvalido e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			} catch (ExcecaoCPFInvalido e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "A Data de Nascimento não pode ser nula ou formada por espaços em branco.");
			} catch (ExcecaoObjetoCadastrado e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		}
	}	
}


