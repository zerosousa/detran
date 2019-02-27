package ine5605g6.detran.logica.excecoes;

public class ExcecaoVeiculosInexistentes extends Exception {
	private static final long serialVersionUID = 1L;

	public ExcecaoVeiculosInexistentes() {
		super("Não existe veiculos na base de dados!");
	}

}
