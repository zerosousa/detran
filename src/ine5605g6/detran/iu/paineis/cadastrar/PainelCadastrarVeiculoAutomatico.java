package ine5605g6.detran.iu.paineis.cadastrar;

import ine5605g6.detran.logica.Detran;
import ine5605g6.detran.logica.excecoes.ExcecaoCondutoresInexistentes;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PainelCadastrarVeiculoAutomatico extends PainelAbstratoAutomatico{
	private static final long serialVersionUID = 1L;

	public PainelCadastrarVeiculoAutomatico (Detran detran) {
		super(detran, "Numero de Veiculos:");
	}

	@Override
	public void valide(JTextField jtfNumVeiculos) {
		int numVeiculos = 0;	
		try {
			numVeiculos = Integer.parseInt(jtfNumVeiculos.getText());
			detran.cadastreVeiculos(numVeiculos);
			JOptionPane.showMessageDialog(null, "Veículos cadastrados com sucesso");	
		} catch (NumberFormatException e2){
			JOptionPane.showMessageDialog(null, "Insira apenas números.");
		} catch (ExcecaoCondutoresInexistentes e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
		}
	}
}
