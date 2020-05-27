package paqueteJuego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class claseJuego extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	private static JFrame ventana;
	
	private static final int ANCHO = 600;
	
	private static final int ALTO = 600;
	
	private static final String NOMBRE = "Juego";
	
	private static Thread thread2;
	
	private static volatile boolean Funcionamiento = false;
	
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
	
	private synchronized void iniciar() {
		Funcionamiento = true;
		
		thread2 = new Thread(this, "Graficos");
		thread2.start();
	}
	
	private synchronized void detener() {
		Funcionamiento = false;
		
		try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		claseJuego juego = new claseJuego();
		juego.iniciar();
		juego.detener();
	}

	public void run() {
		while(Funcionamiento) {
			
		}
	}

}


