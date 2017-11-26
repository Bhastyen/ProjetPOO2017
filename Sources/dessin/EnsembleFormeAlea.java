package dessin;
import java.util.Random;



public class EnsembleFormeAlea extends EnsembleForme{
	
	public EnsembleFormeAlea(int nbPoly){
		super(nbPoly);
		Random r = new Random();
		
		
		int type;
		int nb_cote;
		int i = 0;
		
		double rayon;
		
		Point c,p;
		
		while (i<nbPoly){
			type = r.nextInt(6);
		    switch(type){
				case 0:
					nb_cote = r.nextInt(20-5) + 5;
					ajouterForme(new Polygone(nb_cote));
					break;
				case 1:
					ajouterForme(new Triangle());
					break;
				case 2:
					ajouterForme(new Quadrilatere());
					break;
				case 3:
					ajouterForme(new Rectangle());
					break;
				case 4:
					nb_cote = r.nextInt(20-5) + 5;
					c = new Point();
					p = new Point();
					ajouterForme(new PolygoneRegulier(nb_cote, c, p));
					break;
				case 5:
					rayon = Math.random()*(35.0-10.0)+10.0;
					ajouterForme(new Cercle(rayon));
					break;
				default:
					ajouterForme(new Triangle());
					break;
		    }
		    
		    i ++;
		}
	
    }
	
	
	public void ajouterFormeAlea(){
		
        Random r = new Random();
		
		int type;
		int nb_cote;
		
		double rayon;
		
		Point c,p;
		
		
		type = r.nextInt(6);
		switch(type){
			case 0:
				nb_cote = r.nextInt(20-5) + 5;
				setForme(r.nextInt(getNb_element()), new Polygone(nb_cote));
				break;
			case 1:
				setForme(r.nextInt(getNb_element()), new Triangle());
				break;
			case 2:
				setForme(r.nextInt(getNb_element()), new Quadrilatere());
				break;
			case 3:
				setForme(r.nextInt(getNb_element()), new Rectangle());
				break;
			case 4:
				nb_cote = r.nextInt(20-5) + 5;
				c = new Point();
				p = new Point();
				setForme(r.nextInt(getNb_element()), new PolygoneRegulier(nb_cote, c, p));
				break;
			case 5:
				rayon = Math.random()*(35.0-10.0)+10.0;
				setForme(r.nextInt(getNb_element()), new Cercle(rayon));
				break;
			default:
				setForme(r.nextInt(getNb_element()), new Triangle());
				break;
		}
		
	}
		
	

}