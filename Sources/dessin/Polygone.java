package dessin;


import java.awt.Color;
import java.awt.Graphics;


public class Polygone extends FormeSurface implements Dessinable{
    private final int NB_COTES;
    protected static int nb_poly = 0;
	private java.awt.Color couleur = Dessinable.COLOR_DEFAULT;
    private Point[] sommets;
    
    
    public Polygone(){
    	int i;
    	
    	NB_COTES = 5;
    	sommets = new Point[NB_COTES];
    	
    	for (i=0; i<NB_COTES; i++){
    	    sommets[i] = new Point();
    	}
    	
    	while (this.perimetre() < 600){  //  && !est_convexe()  ne fonctionne pas
    		i = (int) Math.random()*NB_COTES;
    		sommets[i] = new Point();
    	}
    	
    	NUM_FORME = ++nb_forme;
    	NUMERO = ++nb_poly;
    	
    }
	
	public Polygone(int nb_cotes){
		int i;
		
    	NB_COTES = nb_cotes;
    	sommets = new Point[NB_COTES];
    	
    	for (i=0; i<NB_COTES; i++){
    	    sommets[i] = new Point();
    	}
    	
    	while (this.perimetre() < 600){  //  && !est_convexe()  ne fonctionne pas
    		i = (int) Math.random()*NB_COTES;
    		sommets[i] = new Point();
    	}

    	NUM_FORME = ++nb_forme;
    	NUMERO = nb_poly++;
	
	}
	
	
	public Polygone(Point[] ensemblePoint, int nb_cotes){
		int i;
		
    	NB_COTES = nb_cotes;
    	sommets = new Point[NB_COTES];
    	
    	for (i=0; i<NB_COTES; i++){
    	    sommets[i] = ensemblePoint[i];
    	}

    	NUM_FORME = ++nb_forme;
    	NUMERO = nb_poly++;
	
	}
	
	
	
	public int getNumeroPoly(){
		
		return NUMERO;
	}
	
	
	public int nb_cotes(){
		
		return NB_COTES;
		
	}
	
	
	public Point getPoint(int cote){
		
		if (cote >= 0 && cote < NB_COTES){
		    return sommets[cote];
		}else{
			return new Point(0.0,0.0);
		}
		
	}
	
	
	public void changePoint(int n, Point p){
		
		sommets[n] = p;
		
	}
	
	
	public void changePoint(int n, double x, double y){
		
		changePoint(n, new Point(x, y));
		
	}
	
	
	public void setColor(Color c) {
		
		couleur = c;
		
	}
	
	
	public double perimetre(){
		double perimetre = 0.0;
		int i;
		
		for (i=0; i<NB_COTES; i++){
			if (i < NB_COTES-1){
		        perimetre += sommets[i].distance(sommets[i+1]);	
			}else{
				perimetre += sommets[i].distance(sommets[0]);	
			}
	    }
		
		
		return perimetre;
		
	}
	
	
	public double surface(){
		double s = 0.0;
		double c1 = 0.0;
		double c2 = 0.0;
		double c3 = 0.0;
		
		double cx = baryCentre().getX(), cy = baryCentre().getY();
		double aire = 0.0;
		int i;
		
		if (est_convexe()){
			
			for (i=0;i<nb_cotes();i++){
				if (i < nb_cotes()-1){
					c1 = getPoint(i).distance(getPoint(i+1));
					c2 = getPoint(i).distance(new Point(cx, cy));
					c3 = getPoint(i+1).distance(new Point(cx, cy));
				}else{
					c1 = getPoint(i).distance(getPoint(0));
					c2 = getPoint(i).distance(new Point(cx, cy));
					c3 = getPoint(0).distance(new Point(cx, cy));
				}
				
				s = (c1 + c2 + c3)/2.0;
				aire += Math.sqrt(Math.abs(s*(s-c1)*(s-c2)*(s-c3)));
			}
			
			return aire;
		
		}else{
			return -1.0;
		}
	}
	
	
	public boolean est_convexe(){
		int i, compteur = 0;
		int signe;
		int n = nb_cotes();
		
		for (i=0;i<n;i++){
		    signe = getPoint(i).signeAngle(getPoint((i+1)%n),getPoint((i+2)%n));
			if (signe == Point.ALIGNES){
				return false;
			}else if (signe/Math.abs(signe) == Point.SAM){
				compteur ++;
			}
		}
		
		if (compteur == n){
			return true;
		}else if (compteur == 0){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	public boolean dedans(Point p){
		int i, compteur = 0;
		int signe;
		int n = nb_cotes();
		
		for (i=0;i<n;i++){
		    signe = getPoint(i).signeAngle(getPoint((i+1)%n),p);
			if (signe == Point.ALIGNES){
				return false;
			}else if (signe/Math.abs(signe) == Point.SAM){
				compteur ++;
			}
		}
		
		if (compteur == n){
			return true;
		}else if (compteur == 0){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	public Point baryCentre(){
		int i;
		double cx = 0.0, cy = 0.0;

        for (i=0;i<nb_cotes();i++){
			cx += getPoint(i).getX();
			cy += getPoint(i).getY();
		}
			
		cx /= nb_cotes();
		cy /= nb_cotes();


		return new Point(cx, cy);

	}
	
	
	public void translater(double dx, double dy){
		int i;
		
		for (i = 0; i<nb_cotes(); i++){
			changePoint(i, getPoint(i).getX()+dx, getPoint(i).getY()+dy);
		}
		
	}
	
	
	public void zoom(double zoomX){  /* Non teste */
		int i;
		double dx, dy;

        dx = 0 - baryCentre().getX();
		dy = 0 - baryCentre().getY();

		translater(dx, dy);

		for (i = 0; i<nb_cotes(); i++){
			changePoint(i, getPoint(i).getX()*zoomX, getPoint(i).getY()*zoomX);
		}

		translater(-dx, -dy);
		
	}
	
	
	public void seDessiner(Graphics g) {
		int i;
		int x;
		int y;
		
		
		g.setColor(couleur);
		for (i=0; i<nb_cotes(); i++) {
			x = (int) baryCentre().getX() - (toString().length()/2)*10;      // deplacer de la moitie de la longueur de la chaine vers le gauche
			y = (int) baryCentre().getY();
			
			g.drawLine((int) getPoint(i).getX(), (int) getPoint(i).getY(), (int) getPoint((i+1)%nb_cotes()).getX(), (int) getPoint((i+1)%nb_cotes()).getY());
		}
		
		
	}
	
	
	public String toString(){
		String ch = super.toString();
		int i;
		
		for (i=0; i < NB_COTES; i++){
			if (i < NB_COTES-1){
				ch += sommets[i]+", ";
			}else{
				ch += sommets[i];
			}
		}
		
		ch += "\n\tSurface: "+surface();
		
		return ch;
		
	}
	
	
	public boolean equals(Polygone p){
		int i, j, k;
		int nb_vrai;
		double dx = 0.0;
		double dy = 0.0;
		Point p1, p2;
		
		if (this.nb_cotes() != p.nb_cotes()){
			return false;
		}
		
		
		for (i=0; i<p.nb_cotes(); i++){
			nb_vrai = 0;
			dx =  this.getPoint(0).getX() - p.getPoint(i).getX();
			dy =  this.getPoint(0).getY() - p.getPoint(i).getY();
			
		    for (j=i, k=0; j<i+this.nb_cotes(); j++, k++){
			    p1 = new Point(this.getPoint(k).getX(), this.getPoint(k).getY());
			    p2 = new Point(p.getPoint(j%this.nb_cotes()).getX() + dx, p.getPoint(j%this.nb_cotes()).getY() + dy);
			    
			    if (p1.equals(p2)){
			    	nb_vrai ++;
			    }
		    }
		    
			if (nb_vrai == p.nb_cotes()){
				return true;
		 	}
		}
		
		return false;
		
	}
	
	
}