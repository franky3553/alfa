package paqueteGraficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class claseHojaSprites {
	private final int ancho;
	private final int alto;
	
	public final int[] pixeles;
	
	public static claseHojaSprites hojaSprite1 = new claseHojaSprites(30, 30, "/texturas/hoja-sprite1.png");
	
	public claseHojaSprites(final int ancho, final int alto, final String ruta) {
		this.ancho = ancho;
		this.alto = alto;
		
		pixeles = new int [ancho * alto];
		
		BufferedImage imagen;
		
		try {
			
			imagen = ImageIO.read(claseHojaSprites.class.getResource(ruta));
			
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getAncho() {
		return ancho;
	}

}
