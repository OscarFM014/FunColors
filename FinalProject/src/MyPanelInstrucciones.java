import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyPanelInstrucciones extends JPanel implements ActionListener{
	
	private JButton btnAtras;
	

	private JLabel lbTitulo,
				   lbTexto;
	
	
	public MyPanelInstrucciones(){
		super();
		this.setPreferredSize(new Dimension(1000, 800));
		this.setBackground(Color.PINK);
		this.setLayout(null);
		
		
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
		
		this.add(this.lbTitulo);
		this.add(this.lbTexto);
		this.add(this.btnAtras);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAtras) {
			MyVentanaMenu fm = new MyVentanaMenu();
			fm.setVisible(true);
			this.setVisible(false);
		}
		
	}

	


}