package uni7.com.br;

public class TestaEcossistema {
	public static void main(String[] args) {

		Ecossistema ecossistema = new Ecossistema();

		ecossistema.animal.nasceUrso();
		ecossistema.animal.nascePeixe();
		ecossistema.animal.nascePeixe();

		//ecossistema.animal.urso.buscaUrso();
		ecossistema.animal.peixe.buscaPeixe();

		ecossistema.animal.imprimeMatriz();
	}

}