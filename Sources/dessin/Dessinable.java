package dessin;


import java.awt.Color;
import java.awt.Graphics;


public interface Dessinable {
	int TAILLE_MAX = 750;
	int WIDTH_MAX = 1920;
	int HEIGHT_MAX = 1080;
	static final java.awt.Color COLOR_DEFAULT = Color.BLACK;
	
	abstract void setColor(Color c);
	abstract void seDessiner(Graphics g);
	
}
