package wargame;



import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;





public class PanneauJeu extends JPanel implements IConfig{
	
	private static final long serialVersionUID = 6844291169442749659L;    // servira pour serialiser les objets de type Panneau
	
	Carte carte;
	
    JButton b1;
    JButton b2;

    
	PanneauJeu(){
		super(new BorderLayout());
		
		carte = new Carte(LARGEUR_CARTE, HAUTEUR_CARTE, NB_PIX_CASE, NB_HEROS, NB_MONSTRES, NB_OBSTACLES);
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		carte.toutDessiner(g);
		
	}


	
	
	
}


