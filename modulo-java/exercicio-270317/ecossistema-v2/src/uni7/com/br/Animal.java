package uni7.com.br;

import java.util.Random;

public class Animal {
	
	private Animal[][] rio = new Animal[10][10];
	private String especie;
	private int lin, col;
	
	public String getEspecie() {
		return especie;
	}
	
	private boolean isVazio(int lin, int col){//retorna true se posição está livre
		if(rio[lin][col] == null){
			return true;
		} else {
			return false;
		}
	}

	public void popula(){//sempre nascerá em posição aleatória
		Random sorteio = new Random();
		
		lin = sorteio.nextInt(2);//nasce cercado
		col = sorteio.nextInt(3);//nasce cercado
		
		rio[lin][col] = new Urso();
		System.out.println("Nasceu um " + rio[lin][col].getEspecie());
		
		for(int i = 0; i <= 1; i++){
			lin = sorteio.nextInt(10);
			col = sorteio.nextInt(10);
			
			if(isVazio(lin, col)){//valida se posição está vazia
				rio[lin][col] = new Peixe();
				System.out.println("Nasceu um " + rio[lin][col].getEspecie());
			}
/*				if( col <= 1 ){
					rio[lin][col] = new Urso();
					System.out.println("Nasceu um: " + rio[lin][col].getEspecie());
				} else if( col > 7){
					rio[lin][col] = new Peixe();
					//rio[lin + 1][col + 2] = new Peixe();
					System.out.println("Nasceu um: " + rio[lin][col].getEspecie());
					
				} else {
					rio[lin][col] = new Peixe();
					System.out.println("Nasceu um: " + rio[lin][col].getEspecie());
				}
			}*/
		}		
	}
	
	public void mata(){
	}
	
	public void morre(){
	}
	
	public void reproduz(){
	}
	
	public void movimenta(Animal animal){
		paraCima(animal);
		paraBaixo(animal);
		paraDireita(animal);
		paraEsquerda(animal);
	}
	
	private void paraCima(Animal animal){
		rio[lin][col] = rio[lin][col--];
		System.out.println(animal + " andou para cima");
	}
	
	private void paraBaixo(Animal animal){
		rio[lin][col] = rio[lin++][col];
		System.out.println(animal + " andou para baixo!");
	}
	
	private void paraDireita(Animal animal){
		rio[lin][col] = rio[lin][col++];
		System.out.println(animal + " andou para direita!");
	}
	
	private void paraEsquerda(Animal animal){
		rio[lin][col] = rio[lin--][col];
		System.out.println(animal + " andou para esquerda!");
	}
	
	public void imprime(){
		for( int l = 0; l < rio.length; l++) {
		    for( int c = 0; c < rio.length; c++ ) {
		    	System.out.println("[" + l + "][" + c + "]: " + rio[l][c]);
		    }
		}
	}
}
