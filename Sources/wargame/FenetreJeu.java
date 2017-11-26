package wargame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;




public class FenetreJeu {

    public static void main(String[] args) {
        JFrame j = new JFrame("Wargame");
        PanneauJeu p = new PanneauJeu();
        
        j.setLocation(100, 100);
        j.setContentPane(p);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        p.setOpaque(true);
        p.setBackground(new Color(200,200,200));
        p.setPreferredSize(new Dimension(1000, 800));
        
        j.pack();
        j.setVisible(true);
    }
    
}
