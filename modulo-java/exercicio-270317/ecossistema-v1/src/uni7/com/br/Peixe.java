package uni7.com.br;

public class Peixe extends Animal {

	public void buscaPeixe() {
		for (int lin = 0; lin < array.length; lin++) {
			for (int col = 0; col < array.length; col++) {
				if (equals(urso)) {
					System.out.println("PEIXE ENCONTRADO");
				}
			}
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

	@Override
	public boolean equals(Object urso) {
		if (getClass().getSimpleName() == null) {
			return false;
		}
		return true; 
	}
}
