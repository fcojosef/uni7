package uni7.com.br;

import java.util.Random;

public class Animal {

	private Animal[][] rio = new Animal[10][10];
	private int lin, col;
	private int total;

	// metodo que insere urso e peixes na matriz
	public void popula() {
		System.out.println("... Início do método popula()");
		Random random = new Random();
		int l = random.nextInt(9);
		int c = random.nextInt(9);

		nasceUrso(l, c); // chama método nasceUrso()

		for (int i = 0; i <= 4; i++) {
			l = random.nextInt(9);
			c = random.nextInt(9);
			nascePeixe(l, c); // chama método nasce peixe
		}
		
		buscaUrso();
		buscaAdjacente();
		movimenta();
		
		System.out.println("... Término do método popula()");
	}// fim popula()

	// instancia objeto do tipo urso
	private void nasceUrso(int l, int c) {
		System.out.println("... Início do método nasceUrso()");
		if (nulo(l, c)) {
			rio[l][c] = new Urso();
		}
		System.out.println("... Término do método nasceUrso()");
	}// fim nasceUrso

	// instancia objeto do tipo peixe
	private void nascePeixe(int l, int c) {
		System.out.println("... Início do método nascePeixe()");
		if (nulo(l, c)) {
			rio[l][c] = new Peixe();
		}
		System.out.println("... Término do método nascePeixe()");
	}// fim nascePeixe

	// busca posição livre e seta varável global
	private void posicaoLivre() {
		System.out.println("... Início do método posicaoLivre()");
		int l, c;
		for (l = 0; l < rio.length; l++) {
			for (c = 0; c < rio.length; c++) {
				if (nulo(l, c)) {
					lin = l;
					col = c;
				}
			}
		}
		System.out.println("... Término do método posicaoLivre()");
	}// fim posicaoLivre

	// valida se há conteúdo na posição da natriz
	private boolean nulo(int l, int c) {
		System.out.println("... Início do método nulo()");
		if (l >= 0 && c >= 0) {
			if (rio[l][c] == null) {
				return true;
			} else {
				return false;
			}
		}
		System.out.println("... Término do método nulo()");
		return true;
	}// fim nulo()

	// busca objeto do tipo urso na matriz
	private void buscaUrso() {
		System.out.println("... Início do método buscaUrso()");
		for (int l = 0; l < rio.length; l++) {
			for (int c = 0; c < rio.length; c++) {
				if (rio[l][c] instanceof Urso) {
					lin = l;
					col = c;
					// buscaAdjacente();
				}
			}
		}
		System.out.println("... Término do método buscaUrso()");
	}// fim buscaUrso()

	// varre toda a matriz para encontrar todos os animais
	private void buscaTodosAnimais() {
		for (int l = 0; l < rio.length; l++) {
			for (int c = 0; c < rio.length; c++) {
				if (rio[l][c] instanceof Animal) {
					
				}
			}
		}
	}// fim buscaTodosAnimais

	// valida se a direção usada é ou não nula
	private boolean direcao(int l, int c) {
		System.out.println("... Início do método direcao()");
		if (!nulo(l, c)) {
			System.out.println("... Término do método direcao()");
			return true;
		} else {
			System.out.println("... Término do método direcao()");
			return false;
		}
		
	}// fim direcao()

	// busca posição adjacente do objeto urso
	private void buscaAdjacente() {
		System.out.println("... Início do método buscaAdjacente()");
		int l = lin, c = col;
		Animal acima = rio[l - 1][c];
		Animal abaixo = rio[l + 1][c];
		Animal esquerda = rio[l][c - 1];
		Animal direita = rio[l][c + 1];

		if (direcao(l - 1, c) && acima instanceof Peixe) {
			acima = null;
		} else if (acima instanceof Urso) {
			posicaoLivre();
			nasceUrso(lin, col);
		} else {
		}

		if (direcao(l + 1, c) && rio[l + 1][c] instanceof Peixe) {
			abaixo = null;
		} else if (abaixo instanceof Urso) {
			posicaoLivre();
			nasceUrso(lin, col);
		} else {
		}

		if (direcao(l, c - 1) && rio[l][c - 1] instanceof Peixe) {
			esquerda = null;
		} else if (esquerda instanceof Urso) {
			posicaoLivre();
			nasceUrso(lin, col);
		} else {
		}

		if (direcao(l, c + 1) && rio[l][c + 1] instanceof Peixe) {
			direita = null;
		} else if (direita instanceof Urso) {
			posicaoLivre();
			nasceUrso(lin, col);
		} else {
		}
		System.out.println("... Término do método buscaAdjacente()");
	}// fim buscaAdjacente

	// reliza movimentação aleatório dos animais
	private void movimenta() {
		System.out.println("... Início do método movimenta()");
		int l = lin, c = col;
		Random random = new Random();
		int aleatorio = random.nextInt(4);

		if (aleatorio == 0) {
			direcao(l - 1, c);// anda para cima
			System.out.println();
		} else if (aleatorio == 1) {
			direcao(l + 1, c);// anda para baixo
		} else if (aleatorio == 2) {
			direcao(l, c - 1);// anda para esquerda
		} else {
			direcao(l, c + 1);// anda para direita
		}
		System.out.println("... Término do método movimenta()");
		imprimeResumo();
	}// fim movimenta()

	// imprime resumo de execução
	private void imprimeResumo() {
		System.out.println("==========RESUMO DA EXECUÇÃO==========");
		System.out.println("URSOS: " + Urso.total);
		System.out.println("PEIXES: " + Peixe.total);
		total = Urso.total + Peixe.total;
		System.out.println("TOTAL: " + total);
		System.out.println("=============FIM DO RESUMO============");
	}// fim imprimeResumo()

	public void imprime() {
		for (int l = 0; l < rio.length; l++) {
			for (int c = 0; c < rio.length; c++) {
				System.out.println("[" + l + "][" + c + "]: " + rio[l][c]);
			}
		}
	}

}
