package dessin;


import java.awt.Color;
import java.awt.Graphics;


public class EnsembleForme{
	
	private final int NB_ELEMENT;
	private Forme[] elements;
	
	
	
	// Constructeurs
	public EnsembleForme(){
		NB_ELEMENT = 3;
		elements = new Forme[NB_ELEMENT];
	}
	
	public EnsembleForme(int nb_element){
		NB_ELEMENT = nb_element;
		elements = new Forme[NB_ELEMENT];
	}
	
	
	
	// accesseurs et mutateurs
	public int getNb_element(){
		
		return NB_ELEMENT;
	}
	
	
	public Forme getForme(int numero){
		
		return elements[numero];
	}
	
	
	public void setForme(int numero, Forme f){
		
		elements[numero] = f;
	}
	
	
	public void changeCouleur() {
		int i;
		Color[] couleur = new Color[7];
		couleur[0] = Color.BLUE;
		couleur[1] = Color.CYAN;
		couleur[2] = Color.RED;
		couleur[3] = Color.GREEN;
		couleur[4] = Color.MAGENTA;
		couleur[5] = Color.ORANGE;
		couleur[6] = Color.YELLOW;
		
		for (i = 0; i < getNb_element(); i++) {
			((Dessinable) getForme(i)).setColor(couleur[i%7]);
		}
		
	}
	
	
	// methode
	public double sommePerimetres(){
		double somme = 0.0;
		int i;
		
		
		for (i=0; i<getNb_element(); i++){
			somme += getForme(i).perimetre();
		}
		
		return somme;
		
	}
	
	
	public void ajouterForme(Forme f){
		int i = 0;
		
		while (i<getNb_element() && getForme(i) != null){
			i ++;
		}
		
		if (i == getNb_element()){
			System.out.println("Elements non rajoute: ensemble de polygones complet.");
		}else{
			setForme(i, f);
		}
		
	}
	
	
	public double somme_surface(){
		int i = 0;
		double surfaces = 0.0;
		
		while (i<getNb_element() && getForme(i) != null){
			
			if (getForme(i).est_convexe()){
				surfaces += getForme(i).surface();
			}
			
			i ++;
		}
		
		
		return surfaces;
		
	}
	
	
	public void affiche(){
		int i;
		
		System.out.println("\tL'ensemble contient les polygones suivants:\n");
		for (i=0; i<getNb_element(); i++){
		    if (getForme(i) != null){
		    	System.out.println("\tPolygone "+i+": "+getForme(i));
				System.out.println("");
		    }
		}
		System.out.println("");
		
		
	}
	
	
	public void zoomZoomable(double zoomX){
		int i;
		
		for (i=0; i<getNb_element(); i++){
		    if (getForme(i) != null){
		    	getForme(i).zoom(zoomX);
		    }
		}
		
		
	}
	
	
	public void toutDessiner(Graphics g) {
		int i;
		
		for (i = 0; i < getNb_element(); i++) {
			if (getForme(i) != null)
				((Dessinable) getForme(i)).seDessiner(g);
		}
		
		
	}
	
	
}
