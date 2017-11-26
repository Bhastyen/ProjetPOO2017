package dessin;



public class Point{
	
	private static final int MIN = -300;
	private static final int MAX = 300;
	
	protected static final int SAM = -1;  // sens des aiguilles d'une montre (sens anti-trigo)
	protected static final int SIAM = 1;   // sens inverse des aiguilles d une montre (sens trigo)
	protected static final int ALIGNES = 0;   
	
	private double x;
	private double y;
	
	
	
	public Point(){
		x = Math.random()*(MAX-MIN)+MIN;
		y = Math.random()*(MAX-MIN)+MIN;
	}
	
	
	public Point(Point p){
		this.x = p.x;
		this.y = p.y;
	}
	
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	
	public final double distance(){
	    
		return Math.sqrt(this.x*this.x+this.y*this.y);
		
		
	}
	
	
	public final double distance(Point p){
	    
		return Math.sqrt((p.x-this.x)*(p.x-this.x)+(p.y-this.y)*(p.y-this.y));
		
	}
	
	
	public int signeAngle(Point p2, Point p3){
		double det;
		Point p1 = this;
		
		double a = (p3.getX()-p1.getX());
		double b = (p2.getX()-p1.getX());
		double c = (p3.getY()-p1.getY());
		double d = (p2.getY()-p1.getY());
		
		det = a*d-b*c;
		
		if (det > 0.0){
			return Point.SIAM;
		}else if (det < 0.0){
			return Point.SAM;
		}else{
			return Point.ALIGNES;
		}
		
	}
	
	
	public String toString(){
		
		return "(x = "+x+", y = "+y+")";
		
	}
	
	
	public double getX(){
		
		return x; 
	}

	
	public double getY(){
		
		return y; 
	}
	
	
	public void setX(double x){
		
		this.x = x;
		
	}

	
	public void setY(double y){
		
		this.y = y;
		
	}
	
	
	public boolean equals(Point p){
		
		return (getX() == p.getX() && getY() == p.getY());
		
	}
	
	
}