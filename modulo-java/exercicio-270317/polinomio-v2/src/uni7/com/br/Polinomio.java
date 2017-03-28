package uni7.com.br;

public class Polinomio {
	/**
	 * @attribute polinomio Array na qual será armazenado o polinomio
	 * @attribute expoente Variável do tipo inteiro que armazena os expoentes do
	 *            polinomio
	 */
	int[] polinomio;
	int expoente;

	/**
	 * @param Connstrutor que recebe um Array como parâmetro
	 */
	Polinomio(int... array) {
		this.polinomio = array;
	}

	/**
	 * @method Método responsável por imprimir a expressão algébrica
	 * @attribute expressao Variável do tipo String que armazena a expressão algébrica
	 */
	public void imprimePolinomio() {
		this.expoente = this.polinomio.length - 1;
		String expressao = "";
		for (int i = 0; i < this.polinomio.length; i++) {
			if (this.expoente > 0) {
				expressao += this.polinomio[i] + "X^" + this.expoente;
				expressao += this.sinal(i);
			} else {
				expressao += polinomio[i];
			}
			this.expoente--;
		}
		System.out.println("Polinômio P(x) = " + expressao);
	}

	/**
	 * @method Método responsável por calcular primeira derivada do polinômio
	 * @attribute derivada Array na qual será armazenada a derivada do polinomio
	 */
	public void calculaderivada() {
		int[] derivada = new int[this.polinomio.length - 1];
		this.expoente = derivada.length;
		for (int i = 0; i < derivada.length; i++) {
			derivada[i] = this.polinomio[i] * this.expoente;
			this.expoente--;
		}
		this.polinomio = derivada;

		this.imprimePolinomio();
	}

	/**
	 * @method Metdodo responsável por acrescentar o sinal de adição, caso o próximo elemento seja positivo
	 * @param Variável do tipo inteiro que indica o índice da Array correspondente
	 * @return sinal de adição "+"
	 */
	public String sinal(int posicao) {
		if (this.polinomio[posicao + 1] > 0) {
			return " + ";
		} else {
			return " ";
		}
	}

}
