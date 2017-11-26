package wargame;



import java.util.Random;
import java.awt.Graphics;
import dessin.*;
import wargame.Obstacle.TypeObstacle;





public class Carte implements ICarte, IConfig{
    private Elements[] elements;
    private int nb_elements = 0;
    
    private int largeur_carte;
    private int hauteur_carte;
    private int taille_case;
    
    private int nb_heros; private int nb_monstres; private int nb_obstacles;
    private EnsembleForme carte;     // tableau de polygone regulier pour l'affichage
    
    
    
    
    Carte(int largeur_carte, int hauteur_carte, int taille_case, int nb_heros, int nb_monstres, int nb_obstacles){
        int i, j, obstacles = 0, heros = 0, monstres = 0;
        int type_elem;
	    PolygoneRegulier polyReg;
	    Elements elem;
	    
	    carte = new EnsembleForme(largeur_carte*hauteur_carte);
	    elements = new Elements[nb_heros+nb_monstres+nb_obstacles];
	    
	    
	    Point p1 = new Point(30, 50);
	    Point p2 = new Point(p1.getX()+taille_case/2, p1.getY()+taille_case/2);
	    
	    Point c1 = new Point(p1.getX()+taille_case/2-2, p1.getY()+taille_case/2-5);
	    Point c2 = new Point(p2.getX()+taille_case/2-2, p2.getY()+taille_case/2-5);
	    
	    
	    this.largeur_carte = largeur_carte;
	    this.hauteur_carte = hauteur_carte;
	    this.taille_case = taille_case/2;
	    this.nb_heros = nb_heros;
	    this.nb_monstres = nb_monstres;
	    this.nb_obstacles = nb_obstacles;
	    
	    
	    // generer les elements de la carte
	    
	    for(i = 0; i < (nb_heros+nb_monstres+nb_obstacles); i++) {
	    	
	    	if (obstacles < nb_obstacles)
	    		elements[i] = new Elements(new Obstacle(TypeObstacle.getObstacleAlea()));
	    	/*else if (heros < nb_heros)
	    		elements[i] = new Elements(new Unite());
	    	else if (monstres < nb_monstres)
	    		elements[i] = new Elements(new Unite());
	    	else
	    	    elements[i] = null;  */
	    		
	    }
	    
	    
	    // tracer la carte
	    for (i = 0; i<hauteur_carte; i++){
	        for (j = 0; j<largeur_carte; j++){
	             
	             if (i%2 == 0) {
	                 polyReg = new PolygoneRegulier(6, new Point(p1.getX()+(2*j)*getTailleCase(), p1.getY()+(2*i*getTailleCase())), new Point(c1.getX()+(2*j)*getTailleCase(), c1.getY()+(2*i*getTailleCase())));
	             }else {
	                 polyReg = new PolygoneRegulier(6, new Point(p2.getX()+(2*j)*getTailleCase(), p2.getY()+(2*i*getTailleCase())), new Point(c2.getX()+(2*j)*getTailleCase(), c2.getY()+(2*i*getTailleCase())));
	             }
	             
	             elem = getElement(i, j);
	             if (elem != null){
	                  type_elem = elem.getTypeObstacle();
	                  switch (type_elem){
	                      case EAU:
	                           polyReg.setColor(COULEUR_EAU);
	                           break;
	                      case FORET:
	                           polyReg.setColor(COULEUR_FORET);
	                           break;
	                      case ROCHER:
	                           polyReg.setColor(COULEUR_ROCHER);
	                           break;
	                      default:
	                           polyReg.setColor(COULEUR_VIDE);
	                  }
	                      
	             
	             }else{
	                 polyReg.setColor(COULEUR_VIDE);
	             }

                 carte.ajouterForme(polyReg);
	        }
	    }
	    
    
    
    }
    
    
    public Elements getElement(int indice){
        
        if (indice >= 0 && indice < getNbElements())
            return elements[indice];
        
        
        return null;
    
    }


    public Elements getElement(Position pos){
        int i = 0;
    	
        if (pos.estValide()){
        	
        	while (getElement(i) != null && !pos.equals(getElement(i).getPosition()))
                i ++;
            
            
            return getElement(i);
        }
        
        return null;
    
    }


    public Elements getElement(int x, int y){
    	int i = 0;
        
        if (new Position(x, y).estValide()){
        	
        	while (getElement(i) != null && !new Position(x, y).equals(getElement(i).getPosition()))
        		i ++;
        	
            return getElement(i);
        }
        
        return null;
    
    }
    
    
    public int getNbElements(){
    
        return elements.length;
    
    } 
    
    
    public int getTailleCase(){
    
        return taille_case;
    
    }
	
	
	public Position trouvePositionVide(){      // Trouve aleatoirement une position vide sur la carte
	    Random r = new Random();
	    int x = r.nextInt(getNbElements()), y = r.nextInt(getNbElements());
	    int compteur = 0;
	    
	    while (getElement(x, y) != null && compteur < getNbElements()){ 
	         x = r.nextInt(getNbElements()); y = r.nextInt(getNbElements());
	         compteur ++;
	    }
	    
	    if (compteur == getNbElements())
	        return new Position(x, y);
	    return null;
	
	}
	
	
	public Position trouvePositionVide(Position pos){     // Trouve une position vide choisie
	    int i = 0;                                               // aléatoirement parmi les 8 positions adjacentes de pos
	    
	    int[] decalage = new int[12];    // tableau contenant les positions successives (sans tenir compte de pos) a verifier autour de la case
	    decalage[0] = 1;                   // depend de la represantation du terrain: ici en hexagone donc 6 cases limitrophes donc 6 dx,dy
	    decalage[1] = 0;
	    decalage[2] = 1;
	    decalage[3] = 0;
	    decalage[4] = 1;
	    decalage[5] = 0;
	    decalage[6] = 1;
	    decalage[7] = 0;
	    decalage[8] = 1;
	    decalage[9] = 0;
	    decalage[10] = 1;
	    decalage[11] = 0;
	    
	    
	    while(getElement(new Position(pos.getX()+decalage[i], pos.getY()+decalage[i+1])) != null){
	        i += 2;
	    }
	    
	    
	    return new Position(pos.getX()+decalage[i], pos.getY()+decalage[i+1]);
	                                     
	}
	
	
	public boolean actionHeros(Position pos, Position pos2){   
	    Elements elem;
	    Obstacle obstacle;
	    Unite unite1;
	    Unite unite2;
	    
	    unite1 = getElement(pos).getUnite();
	    elem = getElement(pos2);
	    if (elem == null){
	        /*if (unite1.getType() != MAGE)
	            return deplaceSoldat(pos2, unite1);
	        if (unite1.sortActive())
	            return unite1.excecuteSort(pos2);
	        return deplaceSoldat(pos2, unite1);*/
	    }
	    
	    unite2 = elem.getUnite();
	    if (unite2 != null){
	        /*if (unite2.getType() == HEROS)
	            return false;
	        if (unite1.getType() == MAGE){
	            if (unite1.sortActive())
	                return unite1.excecuteSort(pos2);
	            return false;
	        }
	        return combatUnite(Unite u1, Unite u2);*/
	    }
	    
	    
	    obstacle = elem.getObstacle();
	    /*if (obstacle != null){
	        if (!obstacle.bloquant())
	            return deplaceSoldat(pos2, unite1);
	        return false;
	    }*/
	    
	    return false;   // ne devrait jamais etre atteint
	
	}
	
	
	public Heros trouveHeros() {
		
		return null;
		
	} 
	
	
	public Heros trouveHeros(Position pos) {
		
		return null;
		
	} 
	
	
    public boolean deplaceSoldat(Position pos, Soldat soldat){
    
    	return true;
    
    }
	
    public void mort(Soldat perso) {
    	
    }
    
	public void jouerSoldats(PanneauJeu pj) {
		
	}
	
	
	public void toutDessiner(Graphics g){
	
		carte.toutDessiner(g);
	
	}

}





