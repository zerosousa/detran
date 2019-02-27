package ine5605g6.detran.iu.paineis.cadastrar;

import ine5605g6.detran.logica.Detran;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;

public abstract class PainelAbstratoManual extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	Detran detran;
	
	JLabel jl1;
	JLabel jl2;
	JLabel jl3;
	
	JFormattedTextField jtf1;
	JFormattedTextField jtf2;
	JFormattedTextField jtf3;
	
	JButton btCadastrar;
	JButton btLimpar;
	
	public PainelAbstratoManual(Detran detran, String label1, String label2, String label3){
		this.detran = detran;
		definaComponentes(label1,label2,label3);
		posicioneComponentes();
	}
	
	public void definaComponentes(String label1, String label2, String label3) {
		jl1 = new JLabel(label1);
		jl2 = new JLabel(label2);
		jl3 = new JLabel(label3);
		
		jtf1 = retorneCampo1();
		jtf2 = retorneCampo2();
		jtf3 = retorneCampo3();

		jtf1.setMaximumSize(jtf1.getPreferredSize());
		jtf2.setMaximumSize(jtf2.getPreferredSize());
		jtf3.setMaximumSize(jtf3.getPreferredSize());
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(this);
		
		btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(this);
	}
	
	protected abstract JFormattedTextField retorneCampo3();

	protected abstract JFormattedTextField retorneCampo2();

	protected abstract JFormattedTextField retorneCampo1();

	public void posicioneComponentes() {
		GroupLayout gl = new GroupLayout(this);
		
		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		setLayout(gl);
		
		// horizontal
		{
			gl.setHorizontalGroup(gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup(Alignment.TRAILING)
							.addComponent(jl1)
							.addComponent(jl2)
							.addComponent(jl3))
					.addGroup(gl.createParallelGroup(Alignment.LEADING)
							.addComponent(jtf1)
							.addComponent(jtf2)
							.addComponent(jtf3)
							.addGroup(gl.createSequentialGroup()
									.addComponent(btCadastrar)
									.addComponent(btLimpar))));
		}

		// vertical
		{
			gl.setVerticalGroup(gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(jl1)
							.addComponent(jtf1))
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(jl2)
							.addComponent(jtf2))
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(jl3)
							.addComponent(jtf3))
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(btCadastrar)
							.addComponent(btLimpar)));
		}
	}
}
