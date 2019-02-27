package ine5605g6.detran.iu.paineis.pesquisar;

import ine5605g6.detran.iu.InfracaoTableModel;
import ine5605g6.detran.logica.Detran;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PainelPesquisar extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Detran detran;
	InfracaoTableModel tableModel;
	
	JTable tabela;
	JScrollPane scrollPane;
	JDialog janela;
	
	JButton btPesquisar;
	JButton btLimpar;
	
	public PainelPesquisar(Detran detran, InfracaoTableModel tableModel) {
		this.detran = detran;
		this.tableModel = tableModel;
		tabela = new JTable(tableModel);
		scrollPane = new JScrollPane(tabela);
		janela = new JDialog();
		btPesquisar = new JButton("Pesquisar");
		btLimpar = new JButton("Limpar");
	}

}
