package uni7.com.br;

import java.util.HashSet;
import java.util.Set;

public class Bingo {
	int qtdCartela;

	Cartela cartela = new Cartela();
	Set<Cartela> lista = new HashSet<>();

	public void defineCartelas() {
		for (Cartela i : lista) {
			cartela.geraAlgarismos(15);
			lista.add(cartela);
		}
		System.out.println(lista);
	}

}
