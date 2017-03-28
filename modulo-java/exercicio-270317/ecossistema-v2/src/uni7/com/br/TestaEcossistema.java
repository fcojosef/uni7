package uni7.com.br;

public class TestaEcossistema {
	public static void main(String[] args) {

		Ecossistema eco = new Ecossistema(10, 10);
		Animal animal = new Animal();
		//eco.rio[0][0] = urso;
		animal.popula();
		animal.imprime();
	}

}