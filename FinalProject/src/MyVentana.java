
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MyVentana extends JFrame{

	public MyVentana(){
		super("FUN COLORS");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		MyPanelMenu pm = new MyPanelMenu();	
		this.add(pm);
		this.pack();
		setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

	}


	public static void main(String[] args) {
		MyVentana v = new MyVentana();
	}
}

