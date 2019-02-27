package ine5605g6.detran.iu.paineis.pesquisar;

import ine5605g6.detran.iu.InfracaoTableModel;
import ine5605g6.detran.logica.Detran;
import ine5605g6.detran.logica.Infracao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.MaskFormatter;

public class PainelInfracoesPeriodo extends PainelPesquisar implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	MaskFormatter mask1;
	MaskFormatter mask2;
	JLabel jlTitulo;
	JLabel jlInicio;
	JLabel jlFim;
	JFormattedTextField jtfData1;
	JFormattedTextField jtfData2;

	public PainelInfracoesPeriodo(Detran detran, InfracaoTableModel tableModel) {
		super(detran, tableModel);
		definaComponentes();
		posicioneComponentes();
	}
	
	public void definaComponentes() {
		jlTitulo = new JLabel("Informe o perído:");
		jlInicio = new JLabel("Inicio:");
		jlFim = new JLabel("Fim:");
		
		try {
			mask1 = new MaskFormatter("##/##/####");
			mask2 = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		jtfData1 = new JFormattedTextField(mask1);
		jtfData2 = new JFormattedTextField(mask2);
		jtfData1.setColumns(6);
		jtfData2.setColumns(6);
		jtfData1.setMaximumSize(jtfData1.getPreferredSize());
		jtfData2.setMaximumSize(jtfData2.getPreferredSize());
				
		btPesquisar.addActionListener(this);
		btLimpar.addActionListener(this);
	}
	
	public void posicioneComponentes() {
		GroupLayout gl = new GroupLayout(this);
		
		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		setLayout(gl);
		
		// horizontal
		{
			gl.setHorizontalGroup(gl.createParallelGroup(Alignment.LEADING)
					//.addGroup(gl.createParallelGroup(Alignment.TRAILING)
							.addComponent(jlTitulo)
							.addGroup(gl.createSequentialGroup()
									.addComponent(jlInicio)
									.addComponent(jtfData1)
									.addComponent(jlFim)
									.addComponent(jtfData2))
							.addGroup(gl.createSequentialGroup()
									.addComponent(btPesquisar)
									.addComponent(btLimpar)));
		}

		// vertical
		{
			gl.setVerticalGroup(gl.createSequentialGroup()
					.addComponent(jlTitulo)
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(jlInicio)
							.addComponent(jtfData1)
							.addComponent(jlFim)
							.addComponent(jtfData2))
					.addGroup(gl.createParallelGroup(Alignment.BASELINE)
							.addComponent(btPesquisar)
							.addComponent(btLimpar)));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)  {
		if (e.getSource() == btLimpar) {
			jtfData1.setText("");
			jtfData2.setText("");
		} else {
			String data1 = jtfData1.getText();
			String data2 = jtfData2.getText();
			List<Infracao> i = detran.pesquiseInfracoesPeriodo(data1, data2);
				
			tableModel.setInfracoes(i);
			janela.setContentPane(scrollPane);
			janela.pack();
			janela.setLocationRelativeTo(null);
			janela.setVisible(true);
		}
	}	
}
