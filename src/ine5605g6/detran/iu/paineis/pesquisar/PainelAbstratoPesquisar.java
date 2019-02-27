package ine5605g6.detran.iu.paineis.pesquisar;

import ine5605g6.detran.iu.InfracaoTableModel;
import ine5605g6.detran.logica.Detran;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

public abstract class PainelAbstratoPesquisar extends PainelPesquisar implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	
	
	JLabel jl;
	JTextField jtf;
	
	
	
	public PainelAbstratoPesquisar(Detran detran, InfracaoTableModel tableModel, String label) {
		super(detran, tableModel);
		definaComponentes(label);
		posicioneComponentes();
	}
	
	public void definaComponentes(String label) {
		jl = new JLabel(label);
		jtf = retorneCampo();
		jtf.setMaximumSize(jtf.getPreferredSize());
		btPesquisar.addActionListener(this);
		btLimpar.addActionListener(this);
		
	}
	
	protected abstract JTextField retorneCampo();
	
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
									.addComponent(btPesquisar)
									.addComponent(btLimpar))));
		}

		// vertical
		{
			gl.setVerticalGroup(gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(jl)
							.addComponent(jtf))
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(btPesquisar)
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
	
	protected abstract void valide(JTextField jtf);

}
