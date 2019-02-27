package ine5605g6.detran.iu.paineis.cadastrar;

import ine5605g6.detran.logica.Detran;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PainelCadastrarCondutorAutomatico extends PainelAbstratoAutomatico {
	private static final long serialVersionUID = 1L;

	public PainelCadastrarCondutorAutomatico(Detran detran) {
		super(detran, "Número de Condutores:");
	}

	@Override
	public void valide(JTextField jtfNumCondutores) {
		int numCondutores = 0;
		try{
			numCondutores = (int) Integer.parseInt(jtfNumCondutores.getText());
			detran.cadastreCondutores(numCondutores);
			JOptionPane.showMessageDialog(null, "Condutores cadastrados com sucesso");
		}catch (NumberFormatException e2){
			JOptionPane.showMessageDialog(null, "Insira apenas números.");
		}
	}
}


