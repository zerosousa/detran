package ine5605g6.detran.iu.paineis;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class PainelBoasVindas extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JLabel texto;
	
	public PainelBoasVindas() {
		texto = new JLabel();		
		texto.setText("Bem Vindo ao Programa");
		texto.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 16));
		add(texto);
		setVisible(true);
	}
}