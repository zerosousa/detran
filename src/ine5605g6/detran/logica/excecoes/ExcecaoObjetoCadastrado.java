package ine5605g6.detran.logica.excecoes;

public class ExcecaoObjetoCadastrado extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ExcecaoObjetoCadastrado() {
		super("Entidade ja existe na base de dados");
	}

}
