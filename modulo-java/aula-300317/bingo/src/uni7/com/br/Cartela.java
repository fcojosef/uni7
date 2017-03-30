package uni7.com.br;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Cartela {
	private int valor, intervalo = 99;

	Set<Integer> cartela = new HashSet<>();

	private int geraNumeroAleatorio(int intervalo) {
		Random r = new Random();
		valor = r.nextInt(intervalo);
		return valor;
	}

	public void geraAlgarismos(int capacidade) {
		int temp = 0;
		for (Integer i : cartela) {
			cartela.add(geraNumeroAleatorio(intervalo));
			temp = i;
		}
		System.out.println("[" + temp + "]:" + cartela);
	}
}
