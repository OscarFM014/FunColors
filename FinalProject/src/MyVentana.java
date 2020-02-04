

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;


public class MyVentana implements ActionListener{
	JFrame ventana;
	JPanel menu,ins,dibujo,controles;
	private JButton btnJuegoNuevo,
	btnComojugar,
	btnScores;

	private JButton btnAtras;


	private JLabel lbTitulo,
	lbTexto;

	private Backtracking btk;
	private JLabel[][] cuadros;


	private JButton btnRojo,
	btnMorado,
	btnRosa,
	btnVerde,
	btnAzul,
	btnAmarillo,
	btnMenu;


	private JLabel lbNivel,
	lbNivelNum,
	lbScore,
	lbScoreNum,
	lbTurno,
	lbTurnoNum,
	lbTiempo,
	lbTiempoNum;
	private JRadioButton rbtnCentro,
	rbtnEsquina;

	private byte milisegundos = 0;
	private byte segundos = 0;
	private short minutos = 10;
	private DecimalFormat formatoTiempo;
	private Timer timer;

	public void crearVentana(){
		ventana = new JFrame("Fun Colors");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		ventana.setSize(1000, 800);
		this.crearMenu();
		ventana.add(menu); 
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(false);
		ventana.setVisible(true);
	}

	public void crearMenu(){
		this.menu = new JPanel();
		menu.setPreferredSize(new Dimension(1000,800));
		menu.setBackground(Color.WHITE);
		menu.setLayout(null);

		this.btnJuegoNuevo=new JButton("Juego Nuevo");
		this.btnJuegoNuevo.setBounds(350,500,300,60);
		this.btnJuegoNuevo.setBackground(Color.RED);
		this.btnJuegoNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnJuegoNuevo.setFont(new Font("arial", Font.PLAIN, 30));
		this.btnJuegoNuevo.addActionListener(this);

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

		menu.add(this.btnJuegoNuevo);
		menu.add(this.btnComojugar);
		menu.add(this.btnScores);
		menu.setVisible(true);
	}

	public void crearIns(){
		this.ins = new JPanel();
		ins.setPreferredSize(new Dimension(1000, 800));
		ins.setBackground(Color.PINK);
		ins.setLayout(null);


		this.lbTitulo = new JLabel("Cómo jugar");
		this.lbTitulo.setOpaque(true);
		this.lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbTitulo.setFont(new Font("arial", Font.PLAIN, 50));
		this.lbTitulo.setBounds(350,25,300,60);

		String texto = "<html><body>Un color es sufuciente! <br>  <br>Su objetivo es ordenar <br>la pantalla, dejando  "
				+ "<br> solo un color. <br> Expanda \"su idea\" a <br> los píxeles vecinos, <br> eligiendo el color "
				+ "de <br> los píxeles que se  <br> capturarán.</body></html>";
		this.lbTexto = new JLabel(texto);
		this.lbTexto.setOpaque(true);
		this.lbTexto.setHorizontalAlignment(SwingConstants.CENTER);
		this.lbTexto.setFont(new Font("arial", Font.PLAIN, 40));
		this.lbTexto.setBounds(200,95,600,590);

		this.btnAtras=new JButton("Atrás");
		this.btnAtras.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnAtras.setFont(new Font("arial", Font.PLAIN, 50));
		this.btnAtras.setBounds(400,695,200,50);
		this.btnAtras.setBackground(Color.RED);
		this.btnAtras.addActionListener(this);

		ins.add(this.lbTitulo);
		ins.add(this.lbTexto);
		ins.add(this.btnAtras);
		ins.setVisible(false);
	}
	//MY PANEL DIBUJO __________________________________________________________________________________________________________________________________________
	public void crearDibujo(){
		this.dibujo = new JPanel();
		dibujo.setPreferredSize(new Dimension(1000, 800));
		this.btk = new Backtracking();
		this.btk.crearTablero();
		dibujo.setLayout(new GridLayout(14,14));
		this.cuadros=new JLabel[14][14];
		JLabel cuadro;
		for(int i = 0; i< 14; i ++){
			for(int j = 0; j< 14; j++){
				int color = this.btk.matriz[i][j];
				cuadro = new JLabel();
				this.cuadros[i][j]=cuadro;
				cuadro.setOpaque(true);
				if(color == 1){
					cuadro.setBackground(Color.decode("#ff2700"));

				}else if(color == 2){
					cuadro.setBackground(Color.decode("#a32ce8"));

				}else if(color == 3){
					cuadro.setBackground(Color.decode("#ffa700"));

				}else if(color == 4){
					cuadro.setBackground(Color.decode("#63ff00"));

				}else if(color == 5){
					cuadro.setBackground(Color.decode("#3ea3ff"));

				}else if(color == 6){
					cuadro.setBackground(Color.decode("#eaff41"));

				}
				this.dibujo.add(cuadro);
			}
		}
		this.dibujo.setVisible(false);
	}

	public void pintarCentros(int nuevoColor){
		this.btk.pintaTableroCentro(this.btk.matriz, nuevoColor);
		this.btk.setMovimientos(this.btk.getMovimientos()-1);
		for(int i = 0; i< 14; i ++){
			for(int j = 0; j< 14; j++){
				int color = this.btk.matriz[i][j];
				if(color == 1){
					this.cuadros[i][j].setBackground(Color.decode("#ff2700"));

				}else if(color == 2){
					this.cuadros[i][j].setBackground(Color.decode("#a32ce8"));

				}else if(color == 3){
					this.cuadros[i][j].setBackground(Color.decode("#ffa700"));

				}else if(color == 4){
					this.cuadros[i][j].setBackground(Color.decode("#63ff00"));

				}else if(color == 5){
					this.cuadros[i][j].setBackground(Color.decode("#3ea3ff"));

				}else if(color == 6){
					this.cuadros[i][j].setBackground(Color.decode("#eaff41"));

				}
			}
		}
		this.dibujo.repaint();
		this.btk.imprimeTablero();
		System.out.println();
	}


	public void pintarEsquinas(int nuevoColor){
		this.btk.pintaTableroEsquina(this.btk.matriz, nuevoColor);
		this.btk.setMovimientos(this.btk.getMovimientos()-1);
		for(int i = 0; i< 14; i ++){
			for(int j = 0; j< 14; j++){
				int color = this.btk.matriz[i][j];
				if(color == 1){
					this.cuadros[i][j].setBackground(Color.decode("#ff2700"));

				}else if(color == 2){
					this.cuadros[i][j].setBackground(Color.decode("#a32ce8"));

				}else if(color == 3){
					this.cuadros[i][j].setBackground(Color.decode("#ffa700"));

				}else if(color == 4){
					this.cuadros[i][j].setBackground(Color.decode("#63ff00"));

				}else if(color == 5){
					this.cuadros[i][j].setBackground(Color.decode("#3ea3ff"));

				}else if(color == 6){
					this.cuadros[i][j].setBackground(Color.decode("#eaff41"));

				}
			}
		}
		this.dibujo.repaint();
		this.btk.imprimeTablero();
		System.out.println();
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

	//Ganador
	public void ganador(){
		if (this.btk.ganar()){
			System.out.println("ERES UN GANADOR");
			//this.pintaColores();
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



	//MY PANEL CONTROLES__________________________________________________________________________________________________________________________________-

	public void crearControles(){
		this.controles = new JPanel();
		controles.setBackground(Color.WHITE);
		controles.setLayout(null);
		controles.setPreferredSize(new Dimension(240,600));
		//Boton Rojo
		this.btnRojo=new JButton();
		this.btnRojo.setBackground(Color.RED);
		this.btnRojo.setForeground(Color.RED);
		this.btnRojo.setBounds(15,15,60,60);
		this.btnRojo.addActionListener(this);

		//Boton Morado
		this.btnMorado =new JButton();
		this.btnMorado.setBounds(90,15,60,60);
		this.btnMorado.setBackground(Color.decode("#a32ce8"));
		this.btnMorado.addActionListener(this);

		//Boton Rosa
		this.btnRosa=new JButton();
		this.btnRosa.setBounds(165,15,60,60);
		this.btnRosa.setBackground(Color.decode("#ffa700"));
		this.btnRosa.addActionListener(this);

		//Boton Verde
		this.btnVerde=new JButton();
		this.btnVerde.setBounds(15,90,60,60);
		this.btnVerde.setBackground(Color.decode("#63ff00"));
		this.btnVerde.addActionListener(this);

		//Boton Azul
		this.btnAzul=new JButton();
		this.btnAzul.setBounds(90,90,60,60);
		this.btnAzul.setBackground(Color.decode("#3ea3ff"));
		this.btnAzul.addActionListener(this);

		//Boton Amarillo
		this.btnAmarillo=new JButton();
		this.btnAmarillo.setBounds(165,90,60,60);
		this.btnAmarillo.setBackground(Color.decode("#eaff41"));
		this.btnAmarillo.addActionListener(this);

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

		this.lbTurnoNum = new JLabel(""+ this.getMovimientos());
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

		//Boton Menu
		this.btnMenu=new JButton("Menú");
		this.btnMenu.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnMenu.setFont(new Font("arial", Font.PLAIN, 10));
		this.btnMenu.setBounds(10,730,50,50);
		this.btnMenu.setBackground(Color.RED);
		this.btnMenu.addActionListener(this);

		//Esquina o Centro
		this.rbtnCentro =new JRadioButton("Centro");
		this.rbtnCentro.setFont(new Font("arial", Font.PLAIN, 20));
		this.rbtnCentro.setBounds(20,170,100,50);

		this.rbtnEsquina  = new JRadioButton("Esquina",true);
		this.rbtnEsquina.setFont(new Font("arial", Font.PLAIN, 20));
		this.rbtnEsquina.setBounds(120,170,100,50);

		ButtonGroup grupoR = new ButtonGroup();
		grupoR.add(this.rbtnEsquina);
		grupoR.add(this.rbtnCentro);

		timer = new Timer(10, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (milisegundos > 0) {
					milisegundos--;
				} else {
					if (segundos == 0 && minutos == 0) {
						timer.stop();

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
		controles.add(this.btnRojo);
		controles.add(this.btnMorado);
		controles.add(this.btnRosa);
		controles.add(this.btnVerde);
		controles.add(this.btnAzul);
		controles.add(this.btnAmarillo);

		controles.add(this.lbNivel);
		controles.add(this.lbNivelNum);
		controles.add(this.lbScore);
		controles.add(this.lbScoreNum);
		controles.add(this.lbTurno);
		controles.add(this.lbTurnoNum);
		controles.add(this.lbTiempo);
		controles.add(this.lbTiempoNum);
		controles.add(this.btnMenu);
		controles.add(this.rbtnEsquina);
		controles.add(this.rbtnCentro);
		this.controles.setVisible(false);
	}














	public static void main(String[] args) {
		MyVentana v = new MyVentana();
		v.crearVentana();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == this.btnComojugar){
			this.menu.setVisible(false);
			this.crearIns();
			ventana.add(this.ins);
			this.ins.setVisible(true);
		}

		if(e.getSource() == this.btnAtras){
			this.ins.setVisible(false);
			this.menu.setVisible(true);
		}

		if(e.getSource() == this.btnJuegoNuevo){

			this.menu.setVisible(false);
			this.crearDibujo();
			this.crearControles();

			ventana.add(dibujo);
			ventana.add(controles, BorderLayout.WEST);
			dibujo.setVisible(true);
			controles.setVisible(true);
		}

		if(e.getSource() == this.btnMenu){
			dibujo.setVisible(false);
			controles.setVisible(false);
			this.menu.setVisible(true);
		}
		if(this.rbtnCentro.isSelected()){
			if(e.getSource() == this.btnRojo){
				this.pintarCentros(1);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}
			if(e.getSource() == this.btnMorado){
				this.pintarCentros(2);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnRosa){
				this.pintarCentros(3);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnVerde){
				this.pintarCentros(4);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnAzul){
				this.pintarCentros(5);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnAmarillo){
				this.pintarCentros(6);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}
		}else{
			if(e.getSource() == this.btnRojo){
				this.pintarEsquinas(1);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}
			if(e.getSource() == this.btnMorado){
				this.pintarEsquinas(2);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnRosa){
				this.pintarEsquinas(3);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnVerde){
				this.pintarEsquinas(4);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnAzul){
				this.pintarEsquinas(5);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}

			if(e.getSource() == this.btnAmarillo){
				this.pintarEsquinas(6);
				this.lbScoreNum.setText(""+this.getPuntos());
				this.lbTurnoNum.setText(""+this.getMovimientos());
				this.lbNivelNum.setText(""+this.getNivel());
				timer.start();
			}
		}






	}
}

