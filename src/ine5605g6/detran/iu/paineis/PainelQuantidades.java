package ine5605g6.detran.iu.paineis;

import ine5605g6.detran.logica.Detran;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelQuantidades extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Detran detran;

	JLabel texto;
	
	public PainelQuantidades(Detran detran) {
		texto = new JLabel();
		
		int qtdCondutores = detran.retorneQtdeCondutores();
		int qtdInfracoes = detran.retorneQtdeInfracoes();
		int qtdVeiculos = detran.retorneQtdeVeiculos();
		atualizeTexto(qtdCondutores, qtdInfracoes,qtdVeiculos);
		texto.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 16));
		add(texto);
		setVisible(true);
	}
	
	public void atualizeTexto(int condutores, int infracoes, int veiculos) {
		texto.setText("Condutores " + condutores + " Veiculos " + veiculos + " Infracoes " + infracoes);
	}

}
