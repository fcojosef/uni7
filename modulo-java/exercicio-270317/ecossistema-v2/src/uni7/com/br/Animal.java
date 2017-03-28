package uni7.com.br;

import java.util.Random;

public class Animal {

	Animal[][] rio = new Animal[10][10];

	Urso urso;
	Peixe peixe;

	int linha, coluna;

	public void nasceUrso() {
		urso = new Urso();
		posicaoAleatoria();
		rio[linha][coluna] = urso;
	}

	public void nascePeixe() {
		peixe = new Peixe();
		posicaoAleatoria();
		rio[linha][coluna] = peixe;
	}

	public void posicaoAleatoria() {
		Random r = new Random();
		linha = r.nextInt(5);
		coluna = r.nextInt(5);
	}

	public void buscaUrso() {
		for (int lin = 0; lin < rio.length; lin++) {
			for (int col = 0; col < rio.length; col++) {
				if (rio[lin][col].equals(urso)) {
					System.out.println(rio[lin][col]);
				}
			}
		}
	}

	public void imprimeMatriz() {
		for (int lin = 0; lin < rio.length; lin++) {
			for (int col = 0; col < rio.length; col++) {
				System.out.println("[" + lin + "][" + col + "]: " + rio[lin][col]);
			}
		}
	}

/*	@Override
	public String toString() {
		return getClass().getSimpleName();
	}*/

	@Override
	public boolean equals(Object o) {
		if (urso == (Urso) o) {
			return true;
		}
		return false;
	}

}
