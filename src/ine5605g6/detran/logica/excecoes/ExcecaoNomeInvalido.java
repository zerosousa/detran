package ine5605g6.detran.logica.excecoes;

public class ExcecaoNomeInvalido extends Exception {

	private static final long serialVersionUID = 1L;

	public ExcecaoNomeInvalido() {
		super("Nome não pode ser null ou formado apenas por espaços em branco!");
	}
}
