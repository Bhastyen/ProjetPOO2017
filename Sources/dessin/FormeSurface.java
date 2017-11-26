package dessin;


public abstract class FormeSurface implements Forme,Comparable<Object>{
	protected static int nb_forme = 0;
	protected int NUMERO;
	protected int NUM_FORME;
	
	
	public boolean plusGrand(FormeSurface f){
		
		return (this.surface() > f.surface());
		
	}
	
	
    public int compareTo(Object o){
		
    	if (this.surface() > ((Forme) o).surface()){
    		return 1;
    	}else if (this.surface() == ((Forme) o).surface()){
    		return 0;
    	}else{
    		return -1;
    	}
    	
	}
	
	
	public String toString(){
		
		return "Forme (n°"+NUM_FORME+")"+", "+getClass().getSimpleName()+" (n° "+NUMERO+"): ";
	}
	
}