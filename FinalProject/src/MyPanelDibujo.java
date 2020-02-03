import java.awt.*;
import javax.swing.*;

import org.w3c.dom.events.*;
import java.awt.event.*;
import java.awt.event.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;

public class MyPanelDibujo extends JPanel implements Runnable, MouseListener, MouseMotionListener {
	private JLabel cuadro;
	private Backtracking btk;
	private JLabel gano;
	public MyPanelDibujo(){
		super();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setPreferredSize(new Dimension(1000, 800));
		this.btk = new Backtracking();
		this.pintaColores();
		this.setLayout(new GridLayout(14,14));
	}

	//Paint
	public void paintComponent(Graphics g ){
		super.paintComponent(g);
	}

	//Getters y Setters

	public int getPuntos(){
		return this.btk.getPuntos();
	}

	public int getMovimientos(){
		return this.btk.getMovimientos();
	}

	public int getNivel(){
		return this.btk.getNivel();
	}

	public void setNivel(int nivel){
		this.btk.setNivel(nivel);
	}

	//Pinta Tablero
	public void pintaColores(){
		this.removeAll();
		this.btk.crearTablero();
		for(int i = 0; i< 14; i ++){
			for(int j = 0; j< 14; j++){
				int color = this.btk.matriz[i][j];
				this.cuadro = new JLabel();
				cuadro.setOpaque(true);
				if(color == 1){
					this.cuadro.setBackground(Color.decode("#DB0720"));

				}else if(color == 2){
					this.cuadro.setBackground(Color.decode("#9579E8"));

				}else if(color == 3){
					this.cuadro.setBackground(Color.decode("#ff9fcf"));

				}else if(color == 4){
					this.cuadro.setBackground(Color.decode("#58b12e"));

				}else if(color == 5){
					this.cuadro.setBackground(Color.decode("#2f9cc9"));

				}else if(color == 6){
					this.cuadro.setBackground(Color.decode("#FFCC27"));

				}
				this.add(cuadro);
			}
		}
		this.revalidate();
		this.repaint();
		btk.imprimeTablero();
		System.out.println();


	}

	//Actualiza Tablero Centros
	public void pintarCentros(int nuevoColor){
		this.removeAll();
		this.btk.pintaTableroCentro(this.btk.matriz, nuevoColor);
		this.btk.setMovimientos(this.btk.getMovimientos()-1);
		for(int i = 0; i< 14; i ++){
			for(int j = 0; j< 14; j++){
				int color = this.btk.matriz[i][j];
				this.cuadro = new JLabel();
				cuadro.setOpaque(true);
				if(color == 1){
					this.cuadro.setBackground(new Color(250,0,47));

				}else if(color == 2){
					this.cuadro.setBackground(new Color(134, 13, 93));

				}else if(color == 3){
					this.cuadro.setBackground(new Color(251, 126, 179));

				}else if(color == 4){
					this.cuadro.setBackground(Color.GREEN);

				}else if(color == 5){
					this.cuadro.setBackground(new Color(54,214,212));

				}else if(color == 6){
					this.cuadro.setBackground(new Color(251,233,73));

				}
				this.add(cuadro);
			}
		}
		this.revalidate();
		this.repaint();

		btk.imprimeTablero();
		this.ganador();
		this.perdedor();
		System.out.println();
	}



	//Actualiza Tablero
	public void pintarEsquinas(int nuevoColor){
		this.removeAll();
		this.btk.pintaTableroEsquina(this.btk.matriz, nuevoColor);
		this.btk.setMovimientos(this.btk.getMovimientos()-1);
		for(int i = 0; i< 14; i ++){
			for(int j = 0; j< 14; j++){
				int color = this.btk.matriz[i][j];
				this.cuadro = new JLabel();
				cuadro.setOpaque(true);
				if(color == 1){
					this.cuadro.setBackground(Color.RED);

				}else if(color == 2){
					this.cuadro.setBackground(Color.MAGENTA);

				}else if(color == 3){
					this.cuadro.setBackground(Color.PINK);

				}else if(color == 4){
					this.cuadro.setBackground(Color.GREEN);

				}else if(color == 5){
					this.cuadro.setBackground(Color.BLUE);

				}else if(color == 6){
					this.cuadro.setBackground(Color.YELLOW);

				}
				this.add(cuadro);
			}
		}
		this.revalidate();
		this.repaint();

		btk.imprimeTablero();
		this.ganador();
		this.perdedor();
		System.out.println();
	}

	//Ganador
	public void ganador(){
		if (this.btk.ganar()){
			System.out.println("ERES UN GANADOR");
			this.pintaColores();
			this.btk.setMovimientos(50 - (this.getNivel()* 10));
			this.setNivel(this.getNivel() + 1);

		}
	}

	//Perdedor
	public void perdedor(){
		if(this.btk.getMovimientos() == 0){
			System.out.println("ERES UN PERDEDOR");
		}
	}










	// mOuse listener
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {

	}


	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {


	}


	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {


	}


	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {


	}


	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {


	}


	//Mouse Motion listener
	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {

	}


	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}



}