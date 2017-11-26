package wargame;





public class Elements{
	Position pos;
	
	Unite unite;
	Obstacle obstacle;
	
	
	
	Elements(){
		
		pos = new Position();
		
	}
	
	
	Elements(int x, int y){
		
		pos.setX(x);
		pos.setY(y);
		
		unite = null;
		obstacle = null;
		
	}
	
	
	Elements(Position pos){
		
		this(pos.getX(), pos.getY());
		
	}
	
	
	Elements(Position pos, Unite u){
		
		this(pos);
		unite = u;
	
	}
	
	
	Elements(Position pos, Unite u, Obstacle o){
	
		this(pos, u);
		obstacle = o;
		
	}
	
	
	Elements(Unite u, Obstacle o){
	
		this();
		
		unite = u;
		obstacle = o;
		
	}
	
	
	Elements(Unite u){
	
		this();
		
		unite = u;
		
	}
	
	
	Elements(Obstacle o){
	
		this();
		
		obstacle = o;
		
	}
	
	
	public Position getPosition() {
		
		return pos;
	
	}
	
	
	public Obstacle getObstacle() {
		
		return obstacle;
		
	}
	
	
	public Unite getUnite() {
		
		return unite;
		
	}
	
	
	public void setUnite(Unite u) {
		
		unite = u;
		
	}
	
	
	public int getTypeObstacle() {
		
		return obstacle.getType();
		
	}
	
	
	
}


