package uni7.com.br;

import java.util.Random;

public class Animal {

	private Animal[][] rio = new Animal[10][10];
	private int lin, col;
	public int total;

	private boolean isVazio(int lin, int col) {// valida posição livre
		if (lin >= 0 && col >= 0) {
			if (rio[lin][col] == null) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public boolean isUrso(int l, int c) {
		if (rio[l][c] instanceof Urso) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPeixe(int l, int c) {
		if (rio[l][c] instanceof Peixe) {
			return true;
		} else {
			return false;
		}
	}

	public void buscaAdjacente() {
	}

	public void popula() {// sempre nascerá em posição aleatória
		Random sorteio = new Random();

		lin = sorteio.nextInt(2);// nasce cercado
		col = sorteio.nextInt(3);// nasce cercado

		rio[lin][col] = new Urso();
		System.out.println("Nasceu um " + rio[lin][col].getClass().getSimpleName());

		for (int i = 0; i <= 1; i++) {
			lin = sorteio.nextInt(10);
			col = sorteio.nextInt(10);

			if (isVazio(lin, col)) {// valida se posição está vazia
				rio[lin][col] = new Peixe();
				System.out.println("Nasceu um " + rio[lin][col].getClass().getSimpleName());
			}
		}
		System.out.println("TOTAL DE URSOS: " + Urso.total);
		System.out.println("TOTAL DE PEIXES: " + Peixe.total);
		total = Urso.total + Peixe.total;
		System.out.println("TOTAL DE ANIMAIS: " + total);
	}// fim_popula

	public void mata() {
	}

	public void morre() {
		if (!isVazio(lin - 1, col)) {// acima
			if (isPeixe(lin - 1, col)) {
				rio[lin - 1][col] = null;
				Peixe.total--;
			}
		}

		if (!isVazio(lin + 1, col)) {// baixo
			if (isPeixe(lin + 1, col)){
				Peixe.total--;
				rio[lin + 1][col] = null;
			}
		}

		if (!isVazio(lin, col - 1)) {// esquerda
			if (isPeixe(lin, col - 1)){
				Peixe.total--;
				rio[lin][col - 1] = null;
			}
		}

		if (!isVazio(lin, col + 1)) {// direita
			if (isPeixe(lin, col + 1)){
				Peixe.total--;
				rio[lin][col + 1] = null;
			}
		}
		System.out.println("Um peixe morreu!");
		System.out.println("TOTAL DE PEIXES: " + Peixe.total);
	}

	public void reproduz() {
	}

	public void movimenta(Animal animal) {
		paraCima(animal);
		paraBaixo(animal);
		paraDireita(animal);
		paraEsquerda(animal);
	}

	private void paraCima(Animal animal) {
		rio[lin][col] = rio[lin--][col];
		System.out.println(animal + " andou para cima");
	}

	private void paraBaixo(Animal animal) {
		rio[lin][col] = rio[lin++][col];
		System.out.println(animal + " andou para baixo!");
	}

	private void paraDireita(Animal animal) {
		rio[lin][col] = rio[lin][col++];
		System.out.println(animal + " andou para direita!");
	}

	private void paraEsquerda(Animal animal) {
		rio[lin][col] = rio[lin--][col];
		System.out.println(animal + " andou para esquerda!");
	}

	public void imprime() {
		for (int l = 0; l < rio.length; l++) {
			for (int c = 0; c < rio.length; c++) {
				System.out.println("[" + l + "][" + c + "]: " + rio[l][c]);
				/*
				 * if(rio[l][c] instanceof Urso || rio[l][c] instanceof Peixe){
				 * System.out.println("Encontrei: " + "[" + l + "][" + c + "]: "
				 * + rio[l][c]); }
				 */
			}
		}
	}
}
