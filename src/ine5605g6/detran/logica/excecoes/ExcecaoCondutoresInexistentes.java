package ine5605g6.detran.logica.excecoes;

public class ExcecaoCondutoresInexistentes extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ExcecaoCondutoresInexistentes() {
		super("Não existe condutores na base de dados!");
	}

}
