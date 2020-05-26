package paqueteJuego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class claseJuego extends Canvas {
	private static final long serialVersionUID = 1L;
	
	private static JFrame ventana;
	
	private static final int ANCHO = 600;
	
	private static final int ALTO = 600;
	
	private static final String NOMBRE = "Juego";
	
	private claseJuego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));
		
		ventana = new JFrame(NOMBRE);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
	
	public static void main(String[] args) {
		claseJuego juego = new claseJuego();
	}

}


