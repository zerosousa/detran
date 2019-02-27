package ine5605g6.detran.iu.paineis.cadastrar;

import ine5605g6.detran.logica.Detran;
import ine5605g6.detran.logica.excecoes.ExcecaoVeiculosInexistentes;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PainelCadastrarInfracaoAutomatico extends PainelAbstratoAutomatico {
	private static final long serialVersionUID = 1L;
	
	public PainelCadastrarInfracaoAutomatico(Detran detran) {
		super(detran, "Número de infrações:");
	}

	@Override
	public void valide(JTextField jtfNumInfracoes) {
		int numInfracoes = 0;
		try {
			numInfracoes = (int) Integer.parseInt(jtfNumInfracoes.getText());
			detran.cadastreInfracoes(numInfracoes);
			JOptionPane.showMessageDialog(null, "Infrações cadastradas com sucesso");
		} catch (NumberFormatException e2){
			JOptionPane.showMessageDialog(null, "Insira apenas números.");
		} catch (ExcecaoVeiculosInexistentes e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
		}
		
	}
}

