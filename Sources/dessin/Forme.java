package dessin;


public interface Forme{
	
    abstract double perimetre();
	
	abstract double surface();
	
	abstract boolean dedans(Point p);

	abstract void translater(double dx, double dy);
	
	abstract void zoom(double zoomX);
	
	abstract boolean est_convexe();
	
}
