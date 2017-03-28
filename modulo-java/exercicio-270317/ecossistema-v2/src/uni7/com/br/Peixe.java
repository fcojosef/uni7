package uni7.com.br;

public class Peixe extends Animal {

	public static int total;

	public Peixe() {
		total++;
	}

	public String getEspecie() {
		return "Peixe";
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
