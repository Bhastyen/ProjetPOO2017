package dessin;



public class Triangle extends Polygone{
    private static int nb_tri = 0;
	
	
	public Triangle(){
		super(3);
    	
		nb_poly --;
		NUMERO = nb_tri++;
	}
	
	
	public Triangle(Point p1, Point p2, Point p3){
		this();
		
		changePoint(0, p1);
		changePoint(1, p2);
		changePoint(2, p3);
		
	}
	
	
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
		
		this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
		
	}
	
	

	
	public int getNumeroTri(){
		
		return NUMERO;
	}
	
	
	public void setSommet(int numero_sommet, Point p){
		
		changePoint(numero_sommet, p);
		
	}
	
	
	public double surface(){
		double s = perimetre()/2.0;
		
		double base = this.getPoint(1).distance(getPoint(2));
		double c1 = this.getPoint(0).distance(getPoint(1));
		double c2 = this.getPoint(0).distance(getPoint(2));
		
		double hauteur = Math.sqrt(s*(Math.abs(s-c1))*(Math.abs(s-base))*(Math.abs(s-c2)))/(base/2.0);
		
		return (base*hauteur)/2.0;
	}
	
	
}