package ine5605g6.detran.logica.excecoes;

public class ExcecaoCPFInvalido extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ExcecaoCPFInvalido() {
		super("CPF nao pode ser zero ou ter menos que 11 digitos");
	}

}
