import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.event.*;

public class MyPanelControles extends  JPanel  implements ActionListener, ChangeListener, MouseListener{

	private JButton btnRojo,
	btnMorado,
	btnRosa,
	btnVerde,
	btnAzul,
	btnAmarillo,
	btnReinicio,
	btnAtras;

	private JRadioButton centro;

	private JLabel lbNivel,
	lbNivelNum,
	lbScore,
	lbScoreNum,
	lbTurno,
	lbTurnoNum,
	lbTiempo,
	lbTiempoNum;

	private byte milisegundos = 0;
	private byte segundos = 0;
	private short minutos = 10;
	private DecimalFormat formatoTiempo;
	private Timer timer;

	private MyPanelDibujo pd; //unir archivos 

	public MyPanelControles(MyPanelDibujo pd){
		super();
		this.pd = pd;
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(240,600));

		//Boton Rojo
		this.btnRojo=new JButton();
		this.btnRojo.setBackground(new Color(250,0,47));
		this.btnRojo.setBounds(15,15,60,60);
		this.btnRojo.addActionListener(this);

		//Boton Morado
		this.btnMorado =new JButton();
		this.btnMorado.setBounds(90,15,60,60);
		this.btnMorado.setBackground(Color.MAGENTA);
		this.btnMorado.addActionListener(this);

		//Boton Rosa
		this.btnRosa=new JButton();
		this.btnRosa.setBounds(165,15,60,60);
		this.btnRosa.setBackground(new Color(255, 13, 154));
		this.btnRosa.addActionListener(this);

		//Boton Verde
		this.btnVerde=new JButton();
		this.btnVerde.setBounds(15,90,60,60);
		this.btnVerde.setBackground(Color.GREEN);
		this.btnVerde.addActionListener(this);

		//Boton Azul
		this.btnAzul=new JButton();
		this.btnAzul.setBounds(90,90,60,60);
		this.btnAzul.setBackground(Color.BLUE);
		this.btnAzul.addActionListener(this);

		//Boton Amarillo
		this.btnAmarillo=new JButton();
		this.btnAmarillo.setBounds(165,90,60,60);
		this.btnAmarillo.setBackground(Color.YELLOW);
		this.btnAmarillo.addActionListener(this);

		//Boton Reinicio
		this.btnReinicio=new JButton("Reiniciar");
		this.btnReinicio.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnReinicio.setFont(new Font("arial", Font.PLAIN, 20));
		this.btnReinicio.setBounds(30,185,180,40);
		this.btnReinicio.setBackground(Color.GRAY);
		this.btnReinicio.addActionListener(this);

		//Niveles
		this.lbNivel = new JLabel("Nivel");
		this.lbNivel.setOpaque(true);
		this.lbNivel.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbNivel.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbNivel.setBounds(70,240,100,50);

		this.lbNivelNum = new JLabel("1");
		this.lbNivelNum.setOpaque(true);
		this.lbNivelNum.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbNivelNum.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbNivelNum.setBounds(70,310,100,50);

		//Score
		this.lbScore = new JLabel("Score");
		this.lbScore.setOpaque(true);
		this.lbScore.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScore.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbScore.setBounds(70,380,100,50);

		this.lbScoreNum = new JLabel("0");
		this.lbScoreNum.setOpaque(true);
		this.lbScoreNum.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbScoreNum.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbScoreNum.setBounds(70,450,100,50);

		//Movimientos
		this.lbTurno = new JLabel("Turnos");
		this.lbTurno.setOpaque(true);
		this.lbTurno.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbTurno.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbTurno.setBounds(70,520,100,50);

		this.lbTurnoNum = new JLabel(""+ pd.getMovimientos());
		this.lbTurnoNum.setOpaque(true);
		this.lbTurnoNum.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbTurnoNum.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbTurnoNum.setBounds(70,590,100,50);

		//Tiempo
		this.lbTiempo = new JLabel("Tiempo");
		this.lbTiempo.setOpaque(true);
		this.lbTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbTiempo.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbTiempo.setBounds(70,660,100,50);

		this.lbTiempoNum = new JLabel();
		this.lbTiempoNum.setOpaque(true);
		this.lbTiempoNum.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbTiempoNum.setFont(new Font("arial", Font.PLAIN, 20));
		this.lbTiempoNum.setBounds(70,730,100,50);
		formatoTiempo = new DecimalFormat("00");
		
		//Boton atras
		this.btnAtras=new JButton("Atrás");
		this.btnAtras.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnAtras.setFont(new Font("arial", Font.PLAIN, 50));
		this.btnAtras.setBounds(70,660,100,50);
		this.btnAtras.setBackground(Color.RED);
		this.btnAtras.addActionListener(this);

		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (milisegundos > 0) {
					milisegundos--;
				} else {
					if (segundos == 0 && minutos == 0) {
						timer.stop();
						pd.perdedor();
					} else if (segundos > 0) {
						segundos--;
						milisegundos = 99;
					} else if (minutos > 0) {
						minutos--;
						segundos = 59;
						milisegundos = 99;
					}
				}
				lbTiempoNum.setText(formatoTiempo.format(minutos) + ":"
						+ formatoTiempo.format(segundos) + "."
						+ formatoTiempo.format(milisegundos));
			}
		});

		lbTiempoNum.setText(formatoTiempo.format(minutos) + ":"
				+ formatoTiempo.format(segundos) + "."
				+ formatoTiempo.format(milisegundos));

		//Add 
		this.add(this.btnRojo);
		this.add(this.btnMorado);
		this.add(this.btnRosa);
		this.add(this.btnVerde);
		this.add(this.btnAzul);
		this.add(this.btnAmarillo);
		this.add(this.btnReinicio);

		this.add(this.lbNivel);
		this.add(this.lbNivelNum);
		this.add(this.lbScore);
		this.add(this.lbScoreNum);
		this.add(this.lbTurno);
		this.add(this.lbTurnoNum);
		this.add(this.lbTiempo);
		this.add(this.lbTiempoNum);
		this.add(btnAtras);
	}


	@Override
	public void mouseClicked(MouseEvent e) {

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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnRojo){
			pd.pintarEsquinas(1);
			this.lbScoreNum.setText(""+pd.getPuntos());
			this.lbTurnoNum.setText(""+pd.getMovimientos());
			this.lbNivelNum.setText(""+pd.getNivel());
			timer.start();
		}
		if(e.getSource() == this.btnMorado){
			pd.pintarEsquinas(2);
			this.lbScoreNum.setText(""+pd.getPuntos());
			this.lbTurnoNum.setText(""+pd.getMovimientos());
			this.lbNivelNum.setText(""+pd.getNivel());
			timer.start();
		}

		if(e.getSource() == this.btnRosa){
			pd.pintarEsquinas(3);
			this.lbScoreNum.setText(""+pd.getPuntos());
			this.lbTurnoNum.setText(""+pd.getMovimientos());
			this.lbNivelNum.setText(""+pd.getNivel());
			timer.start();
		}

		if(e.getSource() == this.btnVerde){
			pd.pintarEsquinas(4);
			this.lbScoreNum.setText(""+pd.getPuntos());
			this.lbTurnoNum.setText(""+pd.getMovimientos());
			this.lbNivelNum.setText(""+pd.getNivel());
			timer.start();
		}

		if(e.getSource() == this.btnAzul){
			pd.pintarEsquinas(5);
			this.lbScoreNum.setText(""+pd.getPuntos());
			this.lbTurnoNum.setText(""+pd.getMovimientos());
			this.lbNivelNum.setText(""+pd.getNivel());
			timer.start();
		}

		if(e.getSource() == this.btnAmarillo){
			pd.pintarEsquinas(6);
			this.lbScoreNum.setText(""+pd.getPuntos());
			this.lbTurnoNum.setText(""+pd.getMovimientos());
			this.lbNivelNum.setText(""+pd.getNivel());
			timer.start();
		}

		if(e.getSource() == this.btnReinicio){
			pd.pintaColores();
			this.lbScoreNum.setText(""+pd.getPuntos());
			this.lbTurnoNum.setText(""+pd.getMovimientos());
			this.lbNivelNum.setText(""+pd.getNivel());
			timer.start();
		}
	}
}