package dessin;



public class Quadrilatere extends Polygone{
    protected static int nb_quadrilatere = 0;
	
	
	public Quadrilatere(){
		super(4);

    	nb_poly --;
		NUMERO = nb_quadrilatere++;
	}
	
	
	public Quadrilatere(Point p1, Point p2, Point p3, Point p4){
		this();
		
		changePoint(0, p1);
		changePoint(1, p2);
		changePoint(2, p3);
		changePoint(3, p4);
		
	}
	
	
	public Quadrilatere(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
		
		this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), new Point(x4, y4));
		
	}
	
	
	public void setSommet(int numero_sommet, Point p){
		
		changePoint(numero_sommet, p);
		
	}
	
	
	public double surface(){
		
		return Math.abs((getPoint(0).getX()-getPoint(2).getX())*(getPoint(1).getY()-getPoint(3).getY()))+Math.abs((getPoint(1).getX()-getPoint(3).getX())*(getPoint(0).getY()-getPoint(2).getY()));
	}
	
	
	public int getNumeroQuad(){
		
		return NUMERO;
	}
	
	
}