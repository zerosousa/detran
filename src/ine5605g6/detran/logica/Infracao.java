package ine5605g6.detran.logica;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import ine5605g6.detran.logica.excecoes.ExcecaoPlacaInvalida;

public class Infracao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	
	private Date dataInfracao;
	private String placa;
	
	public Infracao(int codigo){
		this.codigo = codigo;
	}
	public Infracao(int codigo, Date dataInfracao, String placa) {
		this.codigo = codigo;
		this.dataInfracao = dataInfracao;
		this.placa = placa;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getDataInfracao() {
		return dataInfracao;
	}
	
	//VERIFICAR TIPO E EXCECOES DO METODO DATAINFRACAO
	
	public void setDataInfracao(String dataInfracao) throws ParseException {
		Date data = dataString(dataInfracao);
		this.dataInfracao = data;  
	}
	// criando datas
	private Date dataString(String data) throws  ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false); // impede a geração de datas inválidas
			
		return sdf.parse(data);
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) throws ExcecaoPlacaInvalida {
		if (!Pattern.matches("[a-zA-Z]{3}[0-9]{4}", placa))
			throw new ExcecaoPlacaInvalida();
				
		this.placa = placa;
	}
	
	public Infracao clone() {
		Infracao clone = new Infracao(codigo, dataInfracao, placa);
		return clone;
	}
	
	@Override
	public String toString() {
		return "Codigo : " +  codigo +  " Data: " + dataInfracao + " Placa: " + placa;
	}
}
