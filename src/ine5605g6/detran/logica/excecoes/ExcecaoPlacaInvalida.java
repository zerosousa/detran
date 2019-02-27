package ine5605g6.detran.logica.excecoes;

public class ExcecaoPlacaInvalida extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ExcecaoPlacaInvalida() {
		super("Placa precisa ser composta de 3 letras e 4 algarismos");
	}

	

}
