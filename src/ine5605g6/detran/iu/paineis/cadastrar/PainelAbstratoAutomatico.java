package ine5605g6.detran.iu.paineis.cadastrar;

import ine5605g6.detran.logica.Detran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

public abstract class PainelAbstratoAutomatico extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	Detran detran;
	
	JLabel jl;
	JTextField jtf;
	
	JButton btCadastrar;
	JButton btLimpar;
	
	public PainelAbstratoAutomatico(Detran detran, String label){
		this.detran = detran;
		definaComponentes(label);
		posicioneComponentes();
	}
	
	public void definaComponentes(String label) {
		jl = new JLabel(label);
		jtf = new JTextField(5);
		jtf.setMaximumSize(jtf.getPreferredSize());
				
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(this);
		
		btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(this);
	}
	
	public void posicioneComponentes() {
		GroupLayout gl = new GroupLayout(this);
		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		setLayout(gl);
		
		// horizontal
		{
			gl.setHorizontalGroup(gl.createSequentialGroup()
					.addComponent(jl)
					.addGroup(gl.createParallelGroup(Alignment.LEADING)
							.addComponent(jtf)
							.addGroup(gl.createSequentialGroup()
									.addComponent(btCadastrar)
									.addComponent(btLimpar))));
		}

		// vertical
		{
			gl.setVerticalGroup(gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(jl)
							.addComponent(jtf))
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(btCadastrar)
							.addComponent(btLimpar)));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)  {
		if (e.getSource() == btLimpar) {
			jtf.setText("");
		} else {
			valide(jtf);
		}
	}	
	
	protected abstract void valide(JTextField jtf1);
}
