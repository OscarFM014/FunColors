import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MyVentanaMenu extends JFrame{
	
	public MyVentanaMenu(){
		super("PIXELATED");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		MyPanelMenu po = new MyPanelMenu();	
		this.setSize(1000, 800);
		this.add(po);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true); 
		
	}
	
	
	public static void main(String[] args) {
		MyVentanaMenu mvm = new MyVentanaMenu();
	}
}