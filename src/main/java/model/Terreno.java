package model;

public class Terreno {
	//tamanho do terreno
	private int tamanho;

	private char[][] terreno;
	
	public Terreno (int t) {
		this.tamanho = t;
		
		terreno = new char[this.tamanho][this.tamanho];
		
		for (int i = 0; i < this.tamanho; i++) {
			for (int j = 0; j < this.tamanho; j++) {
				terreno[i][j] = '_';
			}
		}
	}
	
	public void moveRobo(Posicao pos) {
		char c = pos.getOrientacao();
		terreno[pos.getX()][pos.getY()] = (c == 'N' ? '^' : 
												(c  == 'W' ? '<' : 
												(c == 'S' ? 'v' :
												(c == 'E' ? '>' : '?'))));
	}
	
	public void limpaTerreno(Posicao pos) {
		terreno[pos.getX()][pos.getY()] = '_';
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
}
