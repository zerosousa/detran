package ine5605g6.detran.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ine5605g6.detran.logica.excecoes.ExcecaoCondutoresInexistentes;
import ine5605g6.detran.logica.excecoes.ExcecaoObjetoCadastrado;
import ine5605g6.detran.logica.excecoes.ExcecaoVeiculosInexistentes;
import ine5605g6.detran.persistencia.Armazenador;

public class Detran {
	
	Armazenador memoria;
	
	public Detran (Armazenador memoria) {
		this.memoria = memoria;
	}
	
	public void cadastreCondutor (Condutor condutor) throws ExcecaoObjetoCadastrado {
		if (memoria.verifiqueCondutorCadastrado(condutor.getCpf())) {
			throw new ExcecaoObjetoCadastrado();
		} else
			memoria.armazeneCondutor(condutor);	
	}
	
	public void cadastreCondutores(int numCondutores) {
		Catalogo cat = new Catalogo();
		for (int i = 0; i < numCondutores; i++) {
			String nome = cat.gereNome();	
			long CPF = cat.gereCpf();
			Date dataNascimento = cat.gereDatas();
			Condutor condutor = new Condutor(CPF, nome, dataNascimento);
			memoria.armazeneCondutor(condutor);
		}	
	}
	
	public int retorneQtdeCondutores() {
		return memoria.retorneQtdeCondutores();
	}
	
	public void cadastreVeiculo (Veiculo veiculo) throws ExcecaoObjetoCadastrado, ExcecaoCondutoresInexistentes {
		if (memoria.verifiqueVeiculoCadastrado(veiculo.getPlaca()))
			throw new ExcecaoObjetoCadastrado();
		if (memoria.verifiqueExisteCondutores())
			throw new ExcecaoCondutoresInexistentes();
		else 
			memoria.armazeneVeiculo(veiculo);
	}
	
	public void cadastreVeiculos(int numVeiculos) throws ExcecaoCondutoresInexistentes {
		if (memoria.verifiqueExisteCondutores())
			throw new ExcecaoCondutoresInexistentes();
		else {
			Catalogo cat = new Catalogo();
			for (int i = 0; i < numVeiculos; i++) {
				String placa = cat.gerePlaca();
				int anoFabricacao = cat.gereAno();
				long cpfCondutor = cat.retorneCpf(memoria.retorneCondutores());
				Veiculo veiculo = new Veiculo(placa, anoFabricacao, cpfCondutor);
				memoria.armazeneVeiculo(veiculo);
			}
		}	
	}
	
	public int retorneQtdeVeiculos() {
		return memoria.retorneQtdeVeiculos();
	}
	
	public void cadastreInfracao (Infracao infracao) throws ExcecaoObjetoCadastrado, ExcecaoVeiculosInexistentes {
		if (memoria.verifiqueInfracaoCadastrada(infracao.getCodigo())) 
			throw new ExcecaoObjetoCadastrado();
		if (memoria.verifiqueExisteVeiculos())
			throw new ExcecaoVeiculosInexistentes();
		else
			memoria.armazeneInfracao(infracao);
	}
	
	public void cadastreInfracoes(int numInfracoes) throws ExcecaoVeiculosInexistentes {
		if (memoria.verifiqueExisteCondutores()) 
			throw new ExcecaoVeiculosInexistentes();
		else {
			Catalogo cat = new Catalogo();
			for (int i = 0; i < numInfracoes; i++) {
				int codigo = cat.gereCodigo(memoria.retorneQtdeInfracoes());
				Date dataInfracao = cat.gereDatas();
				String placa = cat.retornePlaca(memoria.retorneVeiculos());				
				Infracao infracao = new Infracao(codigo, dataInfracao, placa);
				memoria.armazeneInfracao(infracao);
			}
		}	
	}

	public int retorneQtdeInfracoes() {
		return memoria.retorneQtdeInfracoes();
	}

	public List<Infracao> pesquiseInfracoesCondutor(long cpf){
		List<Veiculo> v = memoria.retorneVeiculosComCpf(cpf);	
		return memoria.retorneInfracoesDosVeiculos(v);	 
	}
	
	public List<Infracao> pesquiseInfracoesVeiculo(String placa){	
		return memoria.retorneInfracoesComPlaca(placa);	 
	}
	
	public List<Infracao> pesquiseInfracoesPeriodo(String dataInicio, String dataFim) {
		Date dataI = null;
		Date dataF = null;
		try {
			dataI = dataString(dataInicio);
			dataF = dataString(dataFim);
		} catch (ParseException e) {
			
		}
		return memoria.retorneInfracoesPeriodo(dataI, dataF);
	}
	
	private Date dataString(String data) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false); 
		return sdf.parse(data);
	}
}
