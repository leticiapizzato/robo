import static org.junit.Assert.*;

import javax.ws.rs.BadRequestException;
import javax.xml.ws.Response;

import org.junit.Test;

import model.Robo;
import model.Terreno;

public class RoboRESTServiceTest {	
	
	final String BASE_URL = "http://localhost:8080/Robo/rest/mars/";
	
	//Teste: Resultado de rotacoes para direita
	@Test
	public void testeMMRMMRMM() {
		Terreno t = new Terreno(5);
		Robo r = new Robo(0, 0, 'N', t);
		r.andar("MMRMMRMM");
		assertEquals("(2, 0, S)", r.posToString());
	} 
	
	//Teste: Resultado de rotacao para esquerda
	@Test
	public void testeMML() {
		Terreno t = new Terreno(5);
		Robo r = new Robo(0, 0, 'N', t);
		r.andar("MML");
		assertEquals("(0, 2, W)", r.posToString());
	}
	
	//Teste: Resultado de repeticao rotacao para esquerda
	@Test
	public void testeRepeticaoMML() {
		Terreno t = new Terreno(5);
		Robo r = new Robo(0, 0, 'N', t);
		r.andar("MML");
		assertEquals("(0, 2, W)", r.posToString());
	}
	
	//Teste: Resultado de comando invalido
	@Test(expected=RuntimeException.class)
	public void testeAAA() {
		Terreno t = new Terreno(5);
		Robo r = new Robo(0, 0, 'N', t);
		r.andar("AAA");
		//assertNotEquals("HTTP 400 Bad Exception", r.posToString());
		
	}

	//Teste: Resultado de posicao invalida
	@Test(expected=RuntimeException.class)
	public void testeMMMMMMMMMMMMMMMMMMMMMMMM() {
		Terreno t = new Terreno(5);
		Robo r = new Robo(0, 0, 'N', t);
		r.andar("MMMMMMMMMMMMMMMMMMMMMMMM");
		//assertNotEquals("HTTP 400 Bad Exception", r.posToString());
	}
}