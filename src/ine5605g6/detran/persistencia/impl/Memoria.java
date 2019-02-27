package ine5605g6.detran.persistencia.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ine5605g6.detran.logica.Condutor;
import ine5605g6.detran.logica.Infracao;
import ine5605g6.detran.logica.Veiculo;
import ine5605g6.detran.persistencia.Armazenador;

public class Memoria implements Armazenador{
	
	Map<Long, Condutor> condutores;
	Map<String, Veiculo> veiculos;
	Map<Integer, Infracao> infracoes;
	
	int numCondutores;
	int numVeiculos;
	int numInfracoes;
	
	public Memoria() {
		condutores = new HashMap<Long, Condutor>();
		veiculos = new HashMap<String, Veiculo>();
		infracoes = new HashMap<Integer, Infracao>();
	}
	
	/**
	 * ---------------------------------------- 
	 *  aqui começa o cadastramento de condutores
	 * ---------------------------------------- 
	 **/
	
	@Override
	public boolean verifiqueCondutorCadastrado(long cpf) {
		boolean existe = true;
		if (condutores.containsKey(cpf))
			existe = true;
		else
			existe = false;
		return existe;
	}

	// cadastrador:	
	@Override
	public void armazeneCondutor(Condutor novoCondutor) { 		
		condutores.put(novoCondutor.getCpf(), novoCondutor);
	}	
	
	//retorna array para o Catalogo para gerar cpf
	@Override
	public Condutor[] retorneCondutores() {
		Condutor[] arrayCondutor = (Condutor[])condutores.values().toArray(new Condutor[0]);
		return arrayCondutor;
	}

	@Override
	public int retorneQtdeCondutores() {
		return condutores.size();
	}
	
 /**
 * ---------------------------------------- 
 *  aqui começa o cadastramento de veiculos
 * ---------------------------------------- 
 **/
	
	@Override
	public boolean verifiqueVeiculoCadastrado(String placa) {
		boolean existe = true;
		if (veiculos.containsKey(placa))
			existe = true;
		else
			existe = false;
		return existe;
	}
	
	@Override
	public boolean verifiqueExisteCondutores() {
		return condutores.isEmpty();
	}
	
	@Override
	public void armazeneVeiculo(Veiculo novoVeiculo) {
		veiculos.put(novoVeiculo.getPlaca(), novoVeiculo);
	}
	
	@Override
	public Veiculo[] retorneVeiculos() {
		Veiculo[] arrayVeiculo = (Veiculo[])veiculos.values().toArray(new Veiculo[0]);
		return arrayVeiculo;
	}

	@Override
	public int retorneQtdeVeiculos() {
		return veiculos.size();
	}

 /**
 *  -----------------------------------------
 *  aqui começa o cadastramento de infracoes
 *  -----------------------------------------  
 **/
	
	@Override
	public boolean verifiqueInfracaoCadastrada(int codigo) {
		boolean existe = true;
		if (infracoes.containsKey(codigo))
			existe = true;
		else
			existe = false;
		return existe;
	}
	
	@Override
	public boolean verifiqueExisteVeiculos() {
		return veiculos.isEmpty();
	}
	
	@Override
	public void armazeneInfracao(Infracao novaInfracao) {
		infracoes.put(novaInfracao.getCodigo(), novaInfracao);	
	}

	@Override
	public int retorneQtdeInfracoes() {
		return infracoes.size();
	}
		
 /**
 * ---------------------------------------- 
 *  Pesquisa
 * ---------------------------------------- 
 **/
	
	//Metodo utilizado pela pequisa de infraçoes do condutor
	@Override
	public List<Veiculo> retorneVeiculosComCpf(long cpf) {
		List<Veiculo> veiculo = new ArrayList<Veiculo>();
		for (Veiculo v : veiculos.values()) {
			if (v.getCpfCondutor() == cpf){
				veiculo.add(v.clone());
			}	
		}
		return veiculo;
	}
	
	//Metodo utilizado pela pequisa de infraçoes do condutor
	@Override
	public List<Infracao> retorneInfracoesDosVeiculos(List<Veiculo> veiculo) {
		List<Infracao> infracao = new ArrayList<Infracao>();
		for (Infracao i : infracoes.values())
			for (Veiculo v : veiculo)
				if (v.getPlaca().equalsIgnoreCase(i.getPlaca()))
					infracao.add(i.clone());
		return infracao;
	}
	
	//Metodo utilizado pela pequisa de infraçoes do veiculo
	@Override
	public List<Infracao> retorneInfracoesComPlaca(String placa) {
		List<Infracao> infracao = new ArrayList<Infracao>();
		for (Infracao i : infracoes.values()) {
			if (i.getPlaca().equalsIgnoreCase(placa)){
				infracao.add(i.clone());
			}	
		}
		return infracao;
	}	
	
	@Override
	public List<Infracao> retorneInfracoesPeriodo(Date dataInicial, Date dataFinal) {
		List<Infracao> infracao = new ArrayList<Infracao>();
		for (Infracao i : infracoes.values())
			if ((i.getDataInfracao()).compareTo(dataInicial)>= 0 && 
				(i.getDataInfracao()).compareTo(dataFinal) <= 0)
					infracao.add(i.clone());
		return infracao;
	}
}
