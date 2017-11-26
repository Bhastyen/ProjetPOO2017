package wargame;



import java.util.Random;



public class Position implements IConfig {
	
	private int x, y;
	
	
	
	
	Position(){
		Random r = new Random();
		
		x = r.nextInt(LARGEUR_CARTE);
		y = r.nextInt(HAUTEUR_CARTE);
		
	}
	
	
	Position(int x, int y) { 
		this.x = x; this.y = y; 
	}
	
	
	public int getX() { 
		return x; 
	}
	
	
	public int getY() { 
		return y; 
	}
	
	
	public void setX(int x) { 
		this.x = x; 
	}
	
	
	public void setY(int y) { 
		this.y = y; 
	}
	
	
	public boolean estValide() {
		
		if (x<0 || x>=LARGEUR_CARTE || y<0 || y>=HAUTEUR_CARTE) return false; else return true;
		
	}
	
	
	public String toString() { 
		
		return "("+x+","+y+")"; 
		
	}
	
	
	public boolean estVoisine(Position pos) {
		
		return ((Math.abs(x-pos.x)<=1) && (Math.abs(y-pos.y)<=1));
		
	}
	
	
	public boolean equals(Object o) {
		
		return (x == ((Position)o).getX() && y == ((Position)o).getY());
		
	}
	
	
}
