package paqueteGraficos;

public class claseSprite {
	private final int lado;
	
	private int pixelX;
	private int pixelY;
	
	private claseHojaSprites claseHojaSprites1;
	
	public final int[] pixeles;
	
	public static claseSprite personaje = new claseSprite(3, 0, 0, claseHojaSprites.hojaSprite1);
	
	public claseSprite(final int lado, final int spriteX, final int spriteY, final claseHojaSprites claseHojaSprites1 ) {
		this.lado = lado;
		this.claseHojaSprites1 = claseHojaSprites1;
		
		pixelX = lado * spriteX;
		pixelY = lado * spriteY;
		
		pixeles = new int [lado * lado];
		
		
		for (int j = 0; j < lado; j++) {
			for (int i =0; i < lado; i++) {
				pixeles[i + j * lado] = claseHojaSprites1.pixeles[(i + pixelX) + (j + pixelY) * claseHojaSprites1.getAncho()];
			}
		}
	}

}
