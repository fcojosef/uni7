package uni7.com.br;

public class Polinomio {
	/**
	 * @attribute polinomio Array na qual ser� armazenado o polinomio
	 * @attribute expoente Vari�vel do tipo inteiro que armazena os expoentes do
	 *            polinomio
	 */
	int[] polinomio;
	int expoente;

	/**
	 * @param Connstrutor que recebe um Array como par�metro
	 */
	Polinomio(int... array) {
		this.polinomio = array;
	}

	/**
	 * @method M�todo respons�vel por imprimir a express�o alg�brica
	 * @attribute expressao Vari�vel do tipo String que armazena a express�o alg�brica
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
		System.out.println("Polin�mio P(x) = " + expressao);
	}

	/**
	 * @method M�todo respons�vel por calcular primeira derivada do polin�mio
	 * @attribute derivada Array na qual ser� armazenada a derivada do polinomio
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
	 * @method Metdodo respons�vel por acrescentar o sinal de adi��o, caso o pr�ximo elemento seja positivo
	 * @param Vari�vel do tipo inteiro que indica o �ndice da Array correspondente
	 * @return sinal de adi��o "+"
	 */
	public String sinal(int posicao) {
		if (this.polinomio[posicao + 1] > 0) {
			return " + ";
		} else {
			return " ";
		}
	}

}
