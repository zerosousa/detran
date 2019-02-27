package ine5605g6.detran.persistencia;

import java.util.Date;
import java.util.List;

import ine5605g6.detran.logica.Condutor;
import ine5605g6.detran.logica.Infracao;
import ine5605g6.detran.logica.Veiculo;

public interface Armazenador {
	
	public boolean verifiqueCondutorCadastrado(long cpf);
	public void armazeneCondutor(Condutor novoCondutor);
	public int retorneQtdeCondutores();
	
	public boolean verifiqueVeiculoCadastrado(String placa);
	public boolean verifiqueExisteCondutores();
	public void armazeneVeiculo(Veiculo novoVeiculo);
	public int retorneQtdeVeiculos();
	public Condutor[] retorneCondutores();
	
	public boolean verifiqueInfracaoCadastrada(int codigo);
	public boolean verifiqueExisteVeiculos();
	public void armazeneInfracao(Infracao novaInfracao);
	public int retorneQtdeInfracoes();
	public Veiculo[] retorneVeiculos();
	
	public List<Veiculo> retorneVeiculosComCpf(long cpf);
	public List<Infracao> retorneInfracoesDosVeiculos(List<Veiculo> veiculo);

	public List<Infracao> retorneInfracoesComPlaca(String placa);

	public List<Infracao> retorneInfracoesPeriodo(Date dataInicial, Date dataFinal);

}
