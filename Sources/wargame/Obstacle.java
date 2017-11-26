package wargame;


import java.awt.Color;
import java.awt.Graphics;



public class Obstacle implements IConfig{
	
	private TypeObstacle TYPE;
	
	public enum TypeObstacle {
		
		ROCHER (COULEUR_ROCHER), FORET (COULEUR_FORET), EAU (COULEUR_EAU);
		
		private final Color COULEUR;
		
		TypeObstacle(Color couleur) { 
			COULEUR = couleur; 
		}
		
		public static TypeObstacle getObstacleAlea() {
			
			return values()[(int)(Math.random()*values().length)];
			
		}
		
		
	}
	
	
	Obstacle(TypeObstacle type) { 
		
		TYPE = type;
		
	}
	
	
	public int getType() {
		
		if (TYPE.equals(TypeObstacle.EAU))
			return EAU;
		else if (TYPE.equals(TypeObstacle.FORET))
			return FORET;
		else if (TYPE.equals(TypeObstacle.ROCHER))
			return ROCHER;
		else
			return VIDE;
		
	}
	
	
	public String toString() { 
		
		return ""+TYPE; 
	
	}
	
}