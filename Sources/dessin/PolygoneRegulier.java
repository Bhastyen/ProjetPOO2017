package dessin;



public class PolygoneRegulier extends Polygone implements Zoomable{
    private static int nb_regulier = 0;
    private Point centre;

	
	public PolygoneRegulier(int nb_cote, Point p, Point c){
		super(nb_cote);
		
		int i;
		
		double xi = 0.0;
		double yi = 0.0;
		
		double dx = p.getX() - c.getX();
		double dy = p.getY() - c.getY();
		double r = Math.sqrt(dx*dx+dy*dy);
		
		double a = Math.atan2(dy, dx);
		
		changePoint(0, p);
		for (i=1; i<nb_cote; i++){
			xi = c.getX()+r*Math.cos(a+i*2*(Math.PI/nb_cote));
			yi = c.getY()+r*Math.sin(a+i*2*(Math.PI/nb_cote));
		    changePoint(i, xi, yi);
		}

    	nb_poly --;
		NUMERO = nb_regulier++;

		centre = new Point(c);
	
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
	

	public int getNumeroReg(){
		
		return NUMERO;
	}

	public Point getCentre(){

		return centre;
	}

}