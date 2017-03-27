package uni7.com.br;

public class TestaPolinomio {
	public static void main(String[] args) {
		
		Polinomio p = new Polinomio(new int[] {4, 3, -2, 1});
		p.imprimePolinomio();
		p.calculaderivada();
	}
}
