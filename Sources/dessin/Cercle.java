package dessin;

import java.awt.Color;
import java.awt.Graphics;

public class Cercle extends FormeSurface implements Zoomable, Dessinable{
	private static int nb_cercle = 0;
	private Point centre;
	private java.awt.Color couleur = Dessinable.COLOR_DEFAULT;
	private double rayon;
	
	
	public Cercle(){
		centre = new Point();
		rayon = 5.0;

    	NUM_FORME = ++nb_forme;
		NUMERO = nb_cercle++;
	}
	
	
	public Cercle(double rayon){
		centre = new Point();
		this.rayon = rayon;

    	NUM_FORME = ++nb_forme;
		NUMERO = nb_cercle++;
	}
	

	public Cercle(Point p, double rayon){
		centre = new Point(p);
		this.rayon = rayon;

    	NUM_FORME = ++nb_forme;
		NUMERO = nb_cercle++;
	}
	
	
	public Cercle(double x, double y, double rayon){
		centre = new Point(x, y);
		this.rayon = rayon;

    	NUM_FORME = ++nb_forme;
		NUMERO = nb_cercle++;
	}
	
	
	
	public double perimetre(){
		
		return 2*rayon*Math.PI;
		
	}
	
	
	public double surface(){
		
		return rayon*rayon*Math.PI;
		
	}
	
	
	public boolean dedans(Point p){
		
		return (p.distance(this.centre) < rayon);
		
	}
	
	
	public void translater(double dx, double dy){
		
		centre.setX(centre.getX()+dx);
		centre.setY(centre.getY()+dy);
		
	}
	
	
	public void zoom(double zoomX){
		
		rayon *= zoomX;
		
	}
	
	
	public boolean est_convexe(){
		
		return true;
	}
	
	
	public void seDessiner(Graphics g) {
		
		g.setColor(couleur);
		g.drawOval((int) centre.getX(), (int) centre.getY(), (int) rayon, (int) rayon);
		
	}
	
	
	public String toString(){
		
		return super.toString()+"rayon = "+rayon+"  centre = "+centre+"  surface: "+surface()+".";
		
	}
	
	
	public Point getCentre(){
		
		return new Point(centre.getX(), centre.getY());
	}
	
	
	public double getRayon(){
		
		return rayon;
	}
	
	
	public void setColor(Color c) {
		
		couleur = c;
		
	}
	
	
	public void setRayon(double r){
		
		rayon = r;
		
	}
	
	
	
	
	
	
}