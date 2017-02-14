package model;

public class Robo {
	private Terreno t;
	
	//pr -> posicao robo
	//pm -> posicao real na matriz
	private Posicao pr, pm;
	
	public Robo (int x, int y, char o, Terreno t) {
		//posicao inicial do robo no terreno (0,0,N); 
		
		pr = new Posicao(x, y, o);
		pm = new Posicao(x, y, o);
		
		this.t = t;
		
		//posicao equivalente na matriz
		realToMat();
		
		//coloca robo na posicao inicial no terreno
		t.moveRobo(pm);
	}

	//public boolean andar(String pos) {
	public void andar(String pos) {
		//remove o robo da posicao 'velha'
		t.limpaTerreno(pm);
		
		//calcula nova posicao no terreno
		pm.setPosicao(pos, t.getTamanho());
		
		//converte para posicao real do robo
		matToReal();
		
		//coloca robo na 'nova' posicao
		t.moveRobo(pm);
	}
	
	public String posToString() {
		//retorna padrao (x, y, 'N')
		return pr.getPosicao();
	}

	public void realToMat() {
		pm.setX(Math.abs(pr.getX() - (t.getTamanho()-1)));
		pm.setY(pr.getY());
		pm.setOrientacao(pr.getOrientacao());		
	}

	public void matToReal() {
		pr.setX(Math.abs(pm.getY()));
		pr.setY(Math.abs(pm.getX() - (t.getTamanho()-1)));
		pr.setOrientacao(pm.getOrientacao());
	}
}
