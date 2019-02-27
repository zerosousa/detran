package ine5605g6.detran.iu.menu;

import ine5605g6.detran.iu.menu.Opcao;
import ine5605g6.detran.iu.InterfaceComUsuario;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarraDeMenu extends JMenuBar {
	
	private static final long serialVersionUID = 1L;

	public BarraDeMenu(InterfaceComUsuario iu) {
		JMenu menu;
		JMenuItem item;
		
		menu = new JMenu("Armazenamento");
		item = new JMenuItem("Em memoria");
		item.setActionCommand(Opcao.MEMORIA.name());
		item.addActionListener(iu);
		menu.add(item);
		item = new JMenuItem("Em arquivo");
		item.setActionCommand(Opcao.ARQUIVO.name());
		item.addActionListener(iu);
		menu.add(item);
		item = new JMenuItem("Mostrar Quantidades");
		item.setActionCommand(Opcao.MOSTRAR_QTD.name());
		item.addActionListener(iu);
		menu.add(item);
		item = new JMenuItem("Sair");
		item.setActionCommand(Opcao.SAIR.name());
		item.addActionListener(iu);
		menu.add(item);
		add(menu);
		
		menu = new JMenu("Condutores");
		item = new JMenuItem("Cadastrar Manualmente");
		item.setActionCommand(Opcao.C_CONDUTOR_MANUAL.name());
		item.addActionListener(iu);
		menu.add(item);
		item = new JMenuItem("Cadastrar Automaticamente");
		item.setActionCommand(Opcao.C_CONDUTOR_AUTO.name());
		item.addActionListener(iu);
		menu.add(item);
		add(menu);
		
		menu = new JMenu("Veiculos");
		item = new JMenuItem("Cadastrar Manualmente");
		item.setActionCommand(Opcao.C_VEICULO_MANUAL.name());
		item.addActionListener(iu);
		menu.add(item);
		item = new JMenuItem("Cadastrar Automaticamente");
		item.setActionCommand(Opcao.C_VEICULO_AUTO.name());
		item.addActionListener(iu);
		menu.add(item);
		add(menu);
		
		menu = new JMenu("Infrações");
		item = new JMenuItem("Cadastrar Manualmente");
		item.setActionCommand(Opcao.C_INFRACAO_MANUAL.name());
		item.addActionListener(iu);
		menu.add(item);
		item = new JMenuItem("Cadastrar Automaticamente");
		item.setActionCommand(Opcao.C_INFRACAO_AUTO.name());
		item.addActionListener(iu);
		menu.add(item);
		add(menu);
		
		menu = new JMenu("Pesquisar");
		item = new JMenuItem("Infrações de um condutor");
		item.setActionCommand(Opcao.PESQUISAR_CONDUTOR.name());
		item.addActionListener(iu);
		menu.add(item);
		item = new JMenuItem("Infrações de um veículo");
		item.setActionCommand(Opcao.PESQUISAR_VEICULO.name());
		item.addActionListener(iu);
		menu.add(item);
		item = new JMenuItem("Infrações de um período");
		item.setActionCommand(Opcao.PESQUISAR_PERIODO.name());
		item.addActionListener(iu);
		menu.add(item);
		item = new JMenuItem("Maiores infratores");
		item.setActionCommand(Opcao.PESQUISAR_MAIORES.name());
		item.addActionListener(iu);
		menu.add(item);
		add(menu);
	}

}
