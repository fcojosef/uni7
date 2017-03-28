package uni7.com.br;

public class Urso extends Animal {
	
	public static int total;

	public Urso() {
		total++;
	}

	public String getEspecie() {
		return "Urso";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName();
	}

}