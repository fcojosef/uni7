package uni7.com.br;

import java.util.HashSet;
import java.util.Set;

public class Globo {
	int capacidade;
	
	Set<Integer> sorteaveis = new HashSet<>();
	
	public void criaSorteaveis(){
		for (Integer i : sorteaveis) {
			sorteaveis.add(i++);
		}
		System.out.println(sorteaveis);
	}
}
