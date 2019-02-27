package ine5605g6.detran.iu.paineis.pesquisar;

import java.text.ParseException;
import java.util.List;

import ine5605g6.detran.iu.InfracaoTableModel;
import ine5605g6.detran.logica.Detran;
import ine5605g6.detran.logica.Infracao;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class PainelInfracoesVeiculo extends PainelAbstratoPesquisar {

	private static final long serialVersionUID = 1L;
	
	MaskFormatter mask;
	
	public PainelInfracoesVeiculo(Detran detran, InfracaoTableModel tableModel) {
		super(detran, tableModel, "Informe a placa do veiculo:");
	}
	
	@Override
	protected JTextField retorneCampo() {
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
	public void valide(JTextField jtfPlaca) {
		String placa = jtfPlaca.getText();
		List<Infracao> i = detran.pesquiseInfracoesVeiculo(placa);
		
		tableModel.setInfracoes(i);
		janela.setContentPane(scrollPane);
		janela.pack();
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}
}

