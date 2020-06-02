package paqueteJuego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import paqueteControl.claseTeclado;
import paqueteGraficos.clasePantalla;

public class claseJuego extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	private static JFrame ventana;
	
	private static final int ANCHO = 600;
	private static final int ALTO = 600;
	
	private static final String NOMBRE = "Juego";
	
	private static Thread thread2;
	
	private static volatile boolean Funcionamiento = false;
	
	private static int iniciosEstado = 0;
	
	private static claseTeclado claseTeclado1;
	
	private static int x = 0;
	private static int y = 0;
	
	private static clasePantalla pantalla1;
	
	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	
	private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
	
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
		
		claseTeclado1 = new claseTeclado();
		addKeyListener(claseTeclado1);
		
		pantalla1 = new clasePantalla(ANCHO, ALTO); 
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
	
	private void estado() {
		iniciosEstado++;
		
		claseTeclado1.actualizar();
		
		if (claseTeclado1.arb) {
		System.out.println("puslada tecla w");
		}

		if (claseTeclado1.abj) {
		System.out.println("puslada tecla s");
		}
		
		if (claseTeclado1.izq) {
		System.out.println("puslada tecla a");
		}
		
		if (claseTeclado1.dch) {
		System.out.println("puslada tecla d");
		}
	}
	
	private void dibujado() {
		BufferStrategy estrategia = getBufferStrategy();
		
		if (estrategia == null){
			createBufferStrategy(3);
			return;
		}
		
		pantalla1.limpiar();
		pantalla1.mostrar(x, y);
		
		System.arraycopy(pantalla1.pixeles, 0, pixeles, 0, pixeles.length);
		
		
		Graphics g = estrategia.getDrawGraphics();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		estrategia.show();
	}
	
	public static void main(String[] args) {
		claseJuego juego = new claseJuego();
		juego.iniciar();
	}

	public void run() {
		long tiempo1 = System.nanoTime();
		
		final int nanosegundos = 1000000000;
		final byte actualizacionesSegundo = 60;
		final double NA = nanosegundos / actualizacionesSegundo;

		long nanoTiempo1 = System.nanoTime();
		double diferenciaNanoTiempo;
		double delta = 0;
		
		requestFocus();
		
		while(Funcionamiento) {	
			final long nanoTiempo2 = System.nanoTime();
			diferenciaNanoTiempo = nanoTiempo2 - nanoTiempo1;
			nanoTiempo1 = nanoTiempo2;
			
			delta+= diferenciaNanoTiempo;
			
			if(delta >= NA) {
				estado();
				delta = 0;
			}
			
			if (System.nanoTime() - tiempo1 > nanosegundos) {
				tiempo1 = System.nanoTime();
				
				ventana.setTitle("resultado: " + iniciosEstado);
				iniciosEstado = 0;
			}
		}
		
	}

}


