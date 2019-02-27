package ine5605g6.detran.logica;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ine5605g6.detran.logica.excecoes.ExcecaoCPFInvalido;
import ine5605g6.detran.logica.excecoes.ExcecaoNomeInvalido;

public class Condutor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long cpf;
	private String nome;
	private Date dataNascimento;
	
	public Condutor(){		
	}
	
	public Condutor(long cpf, String nome, Date dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;	
	}
	
	public long getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCpf(long cpf) throws ExcecaoCPFInvalido {
		if (cpf <= 0)
			throw new ExcecaoCPFInvalido();	
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setNome(String nome) throws ExcecaoNomeInvalido {
		if (nome == null || nome.trim().length() == 0)
			throw new ExcecaoNomeInvalido();
		this.nome = nome;
	}
	
	public void setDataNascimento(String dataNascimento) throws ParseException {
		Date data = dataString(dataNascimento);
		this.dataNascimento = data;  
	}
	// criando datas
	private Date dataString(String data) throws  ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false); // impede a geração de datas inválidas
			
		return sdf.parse(data);
	}
	
	public Condutor clone() {
		Condutor clone = new Condutor(cpf, nome, dataNascimento);	
		return clone;
	}
	
	@Override
	public String toString() {
		return "Nome : " + nome + " CPF: " + cpf + " Data de Nascimento: " + dataNascimento;
	}
}
