import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyPanelMenu extends  JPanel  implements ActionListener, ChangeListener, MouseListener{

	private JButton btnJuegoNuevo,
	btnOpciones,
	btnComojugar,
	btnScores;
	

	public MyPanelMenu(){
		super();
		this.setPreferredSize(new Dimension(1000,800));
		this.setBackground(Color.WHITE);
		this.setLayout(null);

		this.btnJuegoNuevo=new JButton("Juego Nuevo");
		this.btnJuegoNuevo.setBounds(350,420,300,60);
		this.btnJuegoNuevo.setBackground(Color.RED);
		this.btnJuegoNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnJuegoNuevo.setFont(new Font("arial", Font.PLAIN, 30));
		this.btnJuegoNuevo.addActionListener(this);

		this.btnOpciones =new JButton("Opciones");
		this.btnOpciones.setBounds(350,500,300,60);
		this.btnOpciones.setBackground(Color.MAGENTA);
		this.btnOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnOpciones.setFont(new Font("arial", Font.PLAIN, 30));
		this.btnOpciones.addActionListener(this);

		this.btnComojugar=new JButton("Como Jugar");
		this.btnComojugar.setBounds(350,580,300,60);
		this.btnComojugar.setBackground(new Color(255, 13, 154));
		this.btnComojugar.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnComojugar.setFont(new Font("arial", Font.PLAIN, 30));
		this.btnComojugar.addActionListener(this);

		this.btnScores=new JButton("Mejores Puntuaciones");
		this.btnScores.setBounds(350,660,300,60);
		this.btnScores.setBackground(new Color(255, 13, 154));
		this.btnScores.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnScores.setFont(new Font("arial", Font.PLAIN, 30));
		this.btnScores.addActionListener(this);

		this.add(this.btnJuegoNuevo);
		this.add(this.btnOpciones);
		this.add(this.btnComojugar);
		this.add(this.btnScores);

	}



	public void paintComponent(Graphics g ){
		super.paintComponent(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnJuegoNuevo) {
			MyVentanaDibujo vd = new MyVentanaDibujo();
			vd.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == btnOpciones) {
			MyVentanaOpciones vo = new MyVentanaOpciones();
			vo.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == btnComojugar) {
			MyVentanaInstrucciones vi = new MyVentanaInstrucciones();
			vi.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == btnScores) {
			MyVentanaScores vs= new MyVentanaScores();
			vs.setVisible(true);
			this.setVisible(false);

		}
		
		

	}

}