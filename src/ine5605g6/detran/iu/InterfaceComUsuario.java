package ine5605g6.detran.iu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ine5605g6.detran.iu.menu.Opcao;
import ine5605g6.detran.iu.paineis.PainelBoasVindas;
import ine5605g6.detran.iu.paineis.PainelQuantidades;
import ine5605g6.detran.iu.paineis.cadastrar.PainelAbstratoAutomatico;
import ine5605g6.detran.iu.paineis.cadastrar.PainelAbstratoManual;
import ine5605g6.detran.iu.paineis.cadastrar.PainelCadastrarCondutorAutomatico;
import ine5605g6.detran.iu.paineis.cadastrar.PainelCadastrarCondutorManual;
import ine5605g6.detran.iu.paineis.cadastrar.PainelCadastrarInfracaoAutomatico;
import ine5605g6.detran.iu.paineis.cadastrar.PainelCadastrarInfracaoManual;
import ine5605g6.detran.iu.paineis.cadastrar.PainelCadastrarVeiculoAutomatico;
import ine5605g6.detran.iu.paineis.cadastrar.PainelCadastrarVeiculoManual;
import ine5605g6.detran.iu.paineis.pesquisar.PainelInfracoesCondutor;
import ine5605g6.detran.iu.paineis.pesquisar.PainelInfracoesPeriodo;
import ine5605g6.detran.iu.paineis.pesquisar.PainelInfracoesVeiculo;
import ine5605g6.detran.iu.paineis.pesquisar.PainelPesquisar;
import ine5605g6.detran.iu.menu.BarraDeMenu;
import ine5605g6.detran.logica.Detran;
import javax.swing.JFrame;

public class InterfaceComUsuario extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	Detran detran;
	InfracaoTableModel tableModel;
	PainelAbstratoManual painelManual;
	PainelAbstratoAutomatico painelAuto;
	PainelPesquisar painelPesquisar;
	PainelQuantidades painelQtds;
	
	public InterfaceComUsuario(Detran detran) {
		super("INE5605 - Programa Detran G6");
		this.detran = detran;
		tableModel = new InfracaoTableModel();		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(new BarraDeMenu(this));
		setContentPane(new PainelBoasVindas());
		configureAparencia();
	}

	private void configureAparencia() {
		setPreferredSize(new Dimension(500, 300));
		pack(); 						
		setLocationRelativeTo(null);   
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Opcao opcao = Opcao.valueOf(e.getActionCommand());
				
		switch (opcao) {
		case MEMORIA:
			
		case ARQUIVO:
			
		case C_CONDUTOR_MANUAL: 
		case C_VEICULO_MANUAL: 
		case C_INFRACAO_MANUAL: 
			cadastreManual(opcao);
			break;
		case C_CONDUTOR_AUTO: 
		case C_VEICULO_AUTO:
		case C_INFRACAO_AUTO:
			cadastreAuto(opcao);
			break;
		case PESQUISAR_CONDUTOR:
		case PESQUISAR_VEICULO:
		case PESQUISAR_PERIODO:
		case PESQUISAR_MAIORES:
			pesquise(opcao);
			break;
		case MOSTRAR_QTD:
			painelQtds = new PainelQuantidades(detran);
			setContentPane(painelQtds);
			setVisible(true);
			break;
		case SAIR:
			System.exit(0);
		}
	}
	
	public void cadastreManual(Opcao opcao) {
		switch (opcao) {
		case C_CONDUTOR_MANUAL: 
			painelManual = new PainelCadastrarCondutorManual(detran);
			break;	
		case C_VEICULO_MANUAL: 
			painelManual = new PainelCadastrarVeiculoManual(detran);
			break;
		case C_INFRACAO_MANUAL: 
			painelManual = new PainelCadastrarInfracaoManual(detran);
		}
		setContentPane(painelManual);
		setVisible(true);
	}
	
	public void cadastreAuto(Opcao opcao) {
		switch (opcao) {
		case C_CONDUTOR_AUTO: 
			painelAuto = new PainelCadastrarCondutorAutomatico(detran);
			break;	
		case C_VEICULO_AUTO: 
			painelAuto = new PainelCadastrarVeiculoAutomatico(detran);
			break;
		case C_INFRACAO_AUTO:
			painelAuto = new PainelCadastrarInfracaoAutomatico(detran);
		}
		setContentPane(painelAuto);
		setVisible(true);
	}
	
	private void pesquise(Opcao opcao) {
		switch (opcao) {
		case PESQUISAR_CONDUTOR: 
			painelPesquisar = new PainelInfracoesCondutor(detran, tableModel);
			break;	
		case PESQUISAR_VEICULO: 
			painelPesquisar = new PainelInfracoesVeiculo(detran, tableModel);
			break;
		case PESQUISAR_PERIODO:
			painelPesquisar = new PainelInfracoesPeriodo(detran, tableModel);
			break;
		case PESQUISAR_MAIORES:
		}
		setContentPane(painelPesquisar);
		setVisible(true);
	}
}