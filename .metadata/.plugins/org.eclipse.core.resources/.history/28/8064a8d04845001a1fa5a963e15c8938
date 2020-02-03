import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BolitaGrafica {
	private int radio,
				px,
				py;
	private Color colorFondo,
				colorLinea;
	
	public BolitaGrafica(int radio, Color colorFondo, Color colorLinea, int px, int py){
		this.radio = radio;
		this.colorFondo = colorFondo;
		this.colorLinea = colorLinea;
		this.px = px;
		this.py = py;
	}
	
	public BolitaGrafica(){
		Random ran = new Random();
		this.px = ran.nextInt(800);
		this.py = ran.nextInt(800);
		this.radio = 50 + ran.nextInt(150);
		this.colorFondo = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
		this.colorLinea = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
		
	}
	
	public void pinta(Graphics g ){
		g.setColor(this.colorFondo);
		g.fillOval(this.px, this.py, this.radio*2, this.radio*2);
		g.setColor(this.colorLinea);
		g.drawOval(this.px, this.py , this.radio * 2, this.radio*2);
		
	}
}