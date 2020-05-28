package paqueteControl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class claseTeclado implements KeyListener {
	private final static int numeroTeclas = 120;
	private final boolean[] teclas = new boolean [numeroTeclas];
	
	public boolean arb;
	public boolean abj;
	public boolean izq;
	public boolean dch;
	
	public void actualizar(){
		arb = teclas[KeyEvent.VK_W];
		abj = teclas[KeyEvent.VK_S];
		izq = teclas[KeyEvent.VK_A];
		dch = teclas[KeyEvent.VK_D];
		
	}

	public void keyPressed(KeyEvent arg0) {
		teclas[arg0.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent arg0) {
		teclas[arg0.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
}
