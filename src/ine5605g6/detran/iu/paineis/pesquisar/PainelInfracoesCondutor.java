package ine5605g6.detran.iu.paineis.pesquisar;

import ine5605g6.detran.iu.InfracaoTableModel;
import ine5605g6.detran.logica.Detran;
import ine5605g6.detran.logica.Infracao;

import java.text.ParseException;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class PainelInfracoesCondutor extends PainelAbstratoPesquisar {
	private static final long serialVersionUID = 1L;
	
	MaskFormatter mask;
	
	public PainelInfracoesCondutor(Detran detran, InfracaoTableModel tableModel){
		super(detran, tableModel, "Informe um nº de CPF:");
	}

	@Override
	protected JTextField retorneCampo() {
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
	public void valide(JTextField jtfCPF) {
		Long cpf = 000l;
		try {
			cpf = Long.parseLong(jtfCPF.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"CPF nao pode ser zero ou ter menos que 11 digitos");
		}
		
		List<Infracao> i = detran.pesquiseInfracoesCondutor(cpf);
		
		tableModel.setInfracoes(i);
		janela.setContentPane(scrollPane);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
}
