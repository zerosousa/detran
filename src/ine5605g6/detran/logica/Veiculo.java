package ine5605g6.detran.logica;

import ine5605g6.detran.logica.excecoes.ExcecaoPlacaInvalida;
import ine5605g6.detran.logica.excecoes.ExcecaoCPFInvalido;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String placa;
	private int anoFabricacao;
	private long CpfCondutor;
	
	public Veiculo(){
		
	}

	public Veiculo(String placa, int anoFabricacao, long CpfCondutor) {
		this.placa = placa;
		this.anoFabricacao = anoFabricacao;
		this.CpfCondutor = CpfCondutor;
		}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) throws ExcecaoPlacaInvalida{
		if (!Pattern.matches("[a-zA-Z]{3}[0-9]{4}", placa)) // validacao da placa
			throw new ExcecaoPlacaInvalida();
		
		this.placa = placa;
	}

	public Long getCpfCondutor(){
		
		return CpfCondutor;
	}

	public void setCpfCondutor(long CpfCondutor) throws ExcecaoCPFInvalido {
		if (CpfCondutor <= 0)
			throw new ExcecaoCPFInvalido();
		
		this.CpfCondutor = CpfCondutor;
	}
	
	public Veiculo clone() {
		Veiculo clone = new Veiculo(placa, anoFabricacao, CpfCondutor);
		
		return clone;
	}
	
	@Override
	public String toString() {
		return "Placa: " + placa + " Ano de fabrica��o: " + anoFabricacao + " CPF do condutor: " + CpfCondutor;
	}
}
