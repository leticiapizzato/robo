package model;

import javax.ws.rs.BadRequestException;

public class Posicao {
	public static final char NORTE = 'N';
	public static final char OESTE = 'W';
	public static final char SUL = 'S';
	public static final char LESTE = 'E';
	
	//locomocao eixo x
	private int x;
	
	//locomocao eixo y
	private int y;
	
	//orinetacao do robo North West South East
	private char orient;
	
	public Posicao (int x, int y, char o) {
		this.x = x;
		this.y = y;
		this.orient = o;
	}
	
	public int getX () { return this.x; }
	
	public void setX (int x) { this.x = x; }
	
	public int getY () { return this.y;	}
	
	public void setY (int y) { this.y = y;	}
	
	public char getOrientacao () { return this.orient;	}
	
	public void setOrientacao (char o) { this.orient = o; }
	
	public String getPosicao() { return	"(" + x + ", " + y + ", " + orient + ")"; }
	
	public void setPosicao(String p, int tamanho) {
		//pega valores da posicao atual
		int x_aux = this.getX();
		int y_aux = this.getY();
		for (int i = 0; i < p.length(); i++) {
			switch(p.charAt(i)) {
			case 'M':
				if (this.orient == NORTE) x_aux--;
				else if (this.orient == SUL) x_aux++;
				else if (this.orient == LESTE) y_aux++;
				else if (this.orient == OESTE) y_aux--;
				break;
		    case 'L':
		    	if (this.orient == NORTE) this.orient = OESTE;
		    	else if (this.orient == OESTE) this.orient = SUL;
		    	else if (this.orient == SUL) this.orient = LESTE;
		    	else if (this.orient == LESTE) this.orient = NORTE;
		    	break;
		    case 'R':
		    	if (this.orient == NORTE) this.orient = LESTE;
		    	else if (this.orient == LESTE) this.orient = SUL;
		    	else if (this.orient == SUL) this.orient = OESTE;
		    	else if (this.orient == OESTE) this.orient = NORTE;
		      break;
		    default:
		    	x_aux = tamanho;
		    	i = p.length();
		    	break;
		    }
		}

		//seta valores da nova posicao
		if (x_aux >= tamanho || x_aux < 0  || y_aux < 0 || y_aux >= tamanho) {
			throw new BadRequestException();
		} else {
			this.setX(x_aux);
			this.setY(y_aux);
		}
	}
}
