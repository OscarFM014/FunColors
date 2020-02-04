import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MyVentanaScores extends JFrame{

	public MyVentanaScores(){
		super("PIXELATED");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		MyPanelScores ps = new MyPanelScores();	
		this.setSize(1000, 800);
		this.add(ps);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true); 

	}

}