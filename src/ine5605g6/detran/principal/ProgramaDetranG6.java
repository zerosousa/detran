package ine5605g6.detran.principal;

import ine5605g6.detran.iu.InterfaceComUsuario;
import ine5605g6.detran.logica.Detran;
import ine5605g6.detran.persistencia.Armazenador;
import ine5605g6.detran.persistencia.impl.Memoria;

public class ProgramaDetranG6 {
	
	public static void main(String[] args) {
		Armazenador memoria = new Memoria();
		Detran detran = new Detran(memoria);
		InterfaceComUsuario iu = new InterfaceComUsuario(detran);
		
		iu.setVisible(true);

	}

}
