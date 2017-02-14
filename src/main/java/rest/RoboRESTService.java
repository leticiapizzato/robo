package rest;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Robo;
import model.Terreno;

@Path("/mars")
public class RoboRESTService {
	private Robo rob;
	private Terreno t;
	
	@GET
	@Path("/{pos:[A-Z]*}")
	@Produces("text/plain")
	public String moveRobo(@PathParam("pos") String pos) {
		t = new Terreno(5);
		rob = new Robo(0, 0, 'N', t);
		
		try {
			rob.andar(pos);
		} catch (BadRequestException bd) {
			return bd.getMessage();
		}
		
		return rob.posToString();
    }
	
	@POST
	@Path("/{pos:[A-Z]*}")
	@Produces("text/plain")
	public String moverRobo(@PathParam("pos") String pos) {
		t = new Terreno(5);
		rob = new Robo(0, 0, 'N', t);
		
		try {
			rob.andar(pos);
		} catch (BadRequestException bd) {
			return bd.getMessage();
		}
		
		return rob.posToString();
    }
}
