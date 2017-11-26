package dessin;



public class Rectangle extends Quadrilatere implements Zoomable{
    private static int nb_rect = 0;
	
	public Rectangle(){
		super();
		this.construit(getPoint(0), getPoint(2));
    	
		nb_poly --;
		NUMERO = nb_rect++;
	} 
	
	
	public Rectangle(Point p1, Point p2){
		
		super();
		this.construit(p1, p2);

		nb_poly --;
		NUMERO = nb_rect++;
		
	}
	
	
	public void construit(Point p1, Point p2){
		
		setSommet(0,p1);
		setSommet(2,p2);
		
		setSommet(1,new Point(p2.getX(), p1.getY()));
		setSommet(3,new Point(p1.getX(), p2.getY()));
		
	}


	public void zoom(double zoomX){
		int i;
        double dx = 0-getCentre().getX();
        double dy = 0-getCentre().getY();

        translater(dx, dy);

        for (i=0; i<nb_cotes(); i++){
        	changePoint(i, getPoint(i).getX()*zoomX, getPoint(i).getY()*zoomX);
        }

        translater(-dx, -dy);

	}
	
	
	public double hauteur(){
		
		return Math.abs(getPoint(0).getY() - getPoint(2).getY());
	}
	
	
	public double largeur(){
		
		return Math.abs(getPoint(0).getX() - getPoint(1).getX());
	}
	
	
	public double surface(){
		
		return largeur()*hauteur();
	}
	

	public int getNumeroRect(){
		
		return NUMERO;
	}

	public Point getCentre(){

		return new Point(largeur()/2.0 , hauteur()/2.0);
	}
	
	
}