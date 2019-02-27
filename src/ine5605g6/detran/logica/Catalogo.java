package ine5605g6.detran.logica;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Catalogo {
	
	Random r = new Random();
	
	// ------------[ CONDUTOR ]------------ 
	
	public String[] nomes = {"RONAN","MARCIA","ALFREDO","FLORIANO","ILAN","REGIS","LENZ","RICARDO","ROSANGELA","SIRRONI","MAIRA",
			"ANITA","GRACA","DJALMA","ROSANA","IVANOV","GUILHERME","LEONARDO","ROLF","IRIO","SILVIO","ARMANDO","BRUNO",
			"ORLANDO","SAULO","SIDNEI","VOLMAR","FREDERIK","JANDRE","ALEXANDRE","CONCEICAO","MARCO","CARLOS","INACIO","ROBERTO",
			"VIANEI","FABIANO","IVAN","SASKIA","ERMANN","CIDNEI","VANESSA","JULIANA","FLORENCIO","ALINE","FRANCIELE",
			"LEONEL","ANA","MARIA","JULIO","DIEGO","RUDI","BRUNELLA","HUGO","OSORIO","ALESSANDRA","MARIO","JANAINA",
			"LUIZ","ANDRE","CAROLINA","AKIRA","EDNEY","MICHELLE","ANDERSON","EDGAR","ANTONIO","MOHAMED","JULIANO",
			"MARTINA","ALEXANDRO","HELENE","THOME","MAGNO","CRISTINA","EDUARDO","CLAUDIO","APARECIDA","RAPHAEL",
			"FERNANDA","KARIN","JUNIOR","JOAO","RODRIGO","ANDIARA","LAUS","ELAINE","HAROLDO","LEO","HENRIQUES",
			"FERNANDO","PAULO","GERMANO","KLAUS","ANTONIUTTI","DECIO","JONATHAN","BEATE","RAFAEL","RAFAELA"
			};
	
	String[] sobrenomes = {"PEREIRA","SCHUBERT","LENZ","MAY","MAAS","IVANOV","JUNKES","HORNBURG","BOAVENTURA","ALMAGUER",
			"OTTE","JENNRICH","PICKLER","MARTINS","BERTOLI","SANTOS","BECKHAUSER","SCARAMAL","SAMPAIO","FEIJO","KOPSCH",
			"CASTILHO","SILVA","AMAL","DOS","SIEWERT","BORGES","VENDRAMI","PARTH","FRARE","WATTE","ZIMMERMANN","CARDOSO",
			"WACHHOLZ","PIRES","KRAETZER","ALVES","LAUS","SOUZA","FONTAO","CRUZ","FELIPONI","ESTEVAM","IMME","CASCAES",
			"KESSLER","BAPTISTA","GLATZ","DI GIORGIO","DROLSHAGEN","DOMINGUEZ","IGNACIO","ANGUELOV","MAURICI","TREVIZANI",
			"WERNCKE","FAHT","COLOMBI","MOELLER","LONGHI","ARAGAO","PLAUTZ","SALVADOR","FERREIRA","BENDER","OLINGER",
			"CANCIAN","VARGAS","CASTRO"
			}; 
	
	public Long gereCpf() {
		Long cpf = Long.parseLong(String.format("%011d", (long)(Math.random()*1000000000)));
		return cpf;	
	}
		
	public Long retorneCpf(Condutor[] condutores) {
		Long cpf = condutores[r.nextInt(condutores.length)].getCpf();
		return cpf;	
	}	

	public String gereNome(){	
		String nome = this.nomes[(int)(Math.random()*10)];
		String SobreNome = this.sobrenomes[(int)(Math.random()*69)];
		String nomeCompleto = nome + " " + SobreNome;
		return nomeCompleto;
	}
		
	public Date gereDatas() {
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(1900 + r.nextInt(110), 1 + r.nextInt(12), 1 + r.nextInt(31));
		return new Date(dataNascimento.getTimeInMillis());
	}
	
	// ------------[ VEICULO ]------------ 

	public String gerePlaca(){	
		int r = (int)(Math.random()*25) + 65;
		int s = (int)(Math.random()*25) + 65;
		int t = (int)(Math.random()*25) + 65;

		String l1 = String.valueOf((char)(r));
		String l2 = String.valueOf((char)(s));
		String l3 = String.valueOf((char)(t));		

		//numeros da placa
		int numeros = (int)(Math.random()*10000);
			
		String placa = "";
		placa = placa.concat(l1+l2+l3+numeros);
			
		return placa;
	}
		
	public int gereAno(){
		//ano do veiculo
		int anoFabricacao = 1900 + (int)(Math.random()*110);
		return anoFabricacao;
	}
		
	public String retornePlaca(Veiculo[] veiculos) {
		String placa = veiculos[r.nextInt(veiculos.length)].getPlaca();
		return placa;
	}
		
	// ------------[ INFAÇÃO ]------------ 
	
	public int gereCodigo(int qtdeInfracoes) {
		int codigo = 1 + qtdeInfracoes;
		return codigo;
	}
	
}
