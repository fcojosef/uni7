package uni7.com.br;

import java.util.Random;

public class Animal {

	private Animal[][] rio = new Animal[10][10];
	private int lin, col;
	private int total;

	public void populaRio() {
		System.out.println("... INÍCIO ..." + "\n");
		Random random = new Random();
		int l = 0, c = 0;

		while (l == 0 || c == 0) {
			l = random.nextInt(9);
			c = random.nextInt(9);
		}

		nasceUrso(l, c);

		for (int i = 0; i < 3; i++) {
			l = random.nextInt(9);
			c = random.nextInt(9);
			if (l == 0 || c == 0) {
				l++;
				c++;
				nascePeixe(l, c);
			} else {
				nascePeixe(l, c);
			}
		}
		System.out.println("... o rio está populado de ursos e peixes" + "\n");

		buscaUrso();
		buscaPeixe();
		movimenta();
	}

	private void nasceUrso(int l, int c) {
		if (nulo(l, c)) {
			rio[l][c] = new Urso();
			System.out.println("... Tem um urso na posição " + l + ", " + c + "\n");
		}
	}

	private void nascePeixe(int l, int c) {
		if (nulo(l, c)) {
			rio[l][c] = new Peixe();
			System.out.println("... Nasceu um peixe na posição " + l + ", " + c + "\n");
		}
	}

	private boolean nulo(int l, int c) {
		if (l >= 0 && c >= 0) {
			if (rio[l][c] == null) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	private void buscaUrso() {
		for (int l = 0; l < rio.length; l++) {
			for (int c = 0; c < rio.length; c++) {
				if (rio[l][c] instanceof Urso) {
					lin = l;
					col = c;
					buscaAdjacente();
				}
			}
		}
	}

	private void buscaPeixe() {
		for (int l = 0; l < rio.length; l++) {
			for (int c = 0; c < rio.length; c++) {
				if (rio[l][c] instanceof Peixe) {
					lin = l;
					col = c;
					buscaAdjacente();
				}
			}
		}
	}

	private void buscaPosicaoVazia() {
		for (int l = 0; l < rio.length; l++) {
			if (rio[l][0] == null) {
				lin = l;
				col = 0;
			}
		}
	}

	private boolean direcao(int l, int c) {
		if (!nulo(l, c)) {
			return true;
		} else {
			return false;
		}
	}

	private void buscaAdjacente() {
		int l = lin, c = col;
		Random random = new Random();
		int j = 0, k = 0;

		if (rio[l][c] instanceof Peixe) {
			if (rio[l - 1][c] instanceof Peixe) {
				while (j == 0 || k == 0) {
					j = random.nextInt(9);
					k = random.nextInt(9);
				}
				nascePeixe(j, k);
				// System.out.println("... Nasceu um peixe na posição " + (l -
				// 1) + ", " + c + "\n");
			}

			if (rio[l + 1][c] instanceof Peixe) {
				while (j == 0 || k == 0) {
					j = random.nextInt(9);
					k = random.nextInt(9);
				}
				nascePeixe(j, k);
				// System.out.println("... Nasceu um peixe na posição " + (l +
				// 1) + ", " + c + "\n");
			}

			if (rio[l][c - 1] instanceof Peixe) {
				while (j == 0 || k == 0) {
					j = random.nextInt(8);
					k = random.nextInt(8);
				}
				nascePeixe(j, k);
				// System.out.println("... Nasceu um peixe na posição " + l + ",
				// " + (c - 1) + "\n");
			}

			if (rio[l][c + 1] instanceof Peixe) {
				while (j == 0 || k == 0) {
					j = random.nextInt(8);
					k = random.nextInt(8);
				}
				nascePeixe(j, k);
				// System.out.println("... Nasceu um peixe na posição " + l + ",
				// " + (c + 1) + "\n");
			}
		}

		if (rio[l][c] instanceof Urso) {
			if (rio[l - 1][c] instanceof Peixe) {
				rio[l - 1][c] = null;
				System.out.println("... Morreu um peixe na posição " + (l - 1) + ", " + c + "\n");
			}

			if (rio[l + 1][c] instanceof Peixe) {
				rio[l + 1][c] = null;
				System.out.println("... Morreu um peixe na posição " + (l + 1) + ", " + c + "\n");
			}

			if (rio[l][c - 1] instanceof Peixe) {
				rio[l][c - 1] = null;
				System.out.println("... Morreu um peixe na posição " + l + ", " + (c - 1) + "\n");
			}

			if (rio[l][c + 1] instanceof Peixe) {
				rio[l][c + 1] = null;
				System.out.println("... Morreu um peixe na posição " + l + ", " + (c + 1) + "\n");
			}
		}
	}

	private void movimenta() {
		System.out.println("... Eles começaram a se mover...\n");

		int l = lin, c = col;
		Random random = new Random();
		int aleatorio = random.nextInt(4);

		if (aleatorio == 0) {
			direcao(l - 1, c);// anda para cima
			System.out.println("... O " + rio[l][c] + " moveu-se para cima\n");
		} else if (aleatorio == 1) {
			direcao(l + 1, c);// anda para baixo
			System.out.println("... O " + rio[l][c] + " moveu-se para baixo\n");
		} else if (aleatorio == 2) {
			direcao(l, c - 1);// anda para esquerda
			System.out.println("... O " + rio[l][c] + " moveu-se para esquerda\n");
		} else if (aleatorio == 3) {// anda para direita
			System.out.println("... O " + rio[l][c] + " moveu-se para direta\n");
		} else {
		}
		imprimeResumo();
	}

	private void imprimeResumo() {
		System.out.println("==========RESUMO DA EXECUÇÃO==========");
		System.out.println("URSOS: " + Urso.total);
		System.out.println("PEIXES: " + Peixe.total);
		total = Urso.total + Peixe.total;
		System.out.println("TOTAL: " + total);
		// System.out.println(rio[lin][col] + ": posição " + lin + ", " + col);
		System.out.println("=============FIM DO RESUMO============");
	}

/*	public void imprime() {
		for (int l = 0; l < rio.length; l++) {
			for (int c = 0; c < rio.length; c++) {
				System.out.println("[" + l + "][" + c + "]: " + rio[l][c]);
			}
		}
	}*/
}
