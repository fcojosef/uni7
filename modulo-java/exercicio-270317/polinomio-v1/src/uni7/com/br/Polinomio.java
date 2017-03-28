package uni7.com.br;

public class Polinomio {

	protected int[] arrayPolinomio;

	// constutor
	Polinomio(int... array) {
		this.arrayPolinomio = array;
		this.escrevePolinomio();
	}

	// imprime resultado em tela
	public void escrevePolinomio() {
		int[] array = this.arrayPolinomio;

		for (int j = 1; j <= 2; j++) { // uma passagem para cada polinomio
			int potencia = array.length - j;
			String polinomio = "Polinomio: P(x) = ";
			for (int i = 0; i < array.length; i++) { //repetição de acordo com o tamanho do polinomio
				// mostra polinomia
				if (potencia != 1 && potencia != 0) { //calcula e imprime as primeiras variáveis de termo da lista
					switch (j) {
					case 1:
						polinomio += array[i] + "X" + "^";
						break;
					case 2:
						polinomio += (array[i] * (potencia + 1)) + "X" + "^";
						break;
					}
					polinomio += potencia--;
					polinomio += this.sinal(i);
				} else if (potencia == 1) { //calcula e imprime variável com expoente 1
					switch (j) {
					case 1:
						polinomio += array[i] + "X";
						break;
					case 2:
						polinomio += (array[i] * (potencia + 1)) + "X";
						break;
					}
					potencia--;
					polinomio += this.sinal(i);
				} else if (potencia == 0) { //calcula e imprime variável com expoente 0
					switch (j) {
					case 1:
						polinomio += array[i];
						break;
					case 2:
						polinomio += array[i] + " (primeira derivada)";
						j++;
						break;
					}
				}
			}// fim FOR j
			System.out.println(polinomio); //saída dos doi polinomios
		} //fim FOR i
	}// fim do método
	
	//método para acrescentar os sinais aritméticos no polinomio
	public String sinal(int posicao) {
		int[] polinomio = this.arrayPolinomio;

		if (polinomio[posicao + 1] > 0) {
			return " + ";
		} else {
			return " ";
		}
	}//fim do método
}
