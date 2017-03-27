package uni7.com.br;

import java.util.Random;

public class Animal {

	Animal[][] array = new Animal[10][10];

	Urso urso;
	Peixe peixe;

	int linha, coluna;

	public void nasceUrso() {
		urso = new Urso();
		posicaoAleatoria();
		array[linha][coluna] = urso;
	}

	public void nascePeixe() {
		peixe = new Peixe();
		posicaoAleatoria();
		array[linha][coluna] = peixe;
	}
	
	public void posicaoAleatoria() {
		Random r = new Random();
		linha = r.nextInt(5);
		coluna = r.nextInt(5);
	}

	public void imprimeMatriz() {
		for (int lin = 0; lin < array.length; lin++) {
			for (int col = 0; col < array.length; col++) {
				System.out.println("[" + lin + "][" + col + "]: " + array[lin][col]);
			}
		}
	}

}
