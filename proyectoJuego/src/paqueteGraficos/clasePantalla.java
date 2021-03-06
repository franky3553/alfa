package paqueteGraficos;

public class clasePantalla {
	public final int ancho;
	public final int alto;
	
	public final int[] pixeles;
	
	private final static int LADO_SPRITE = 3;
	private final static int MASCARA_SPRITE = LADO_SPRITE -1;
	
	public clasePantalla(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;
		
		pixeles = new int[ancho * alto];
	}
	
	public void limpiar(){
		for(int i = 0; i > pixeles.length; i++) {
			pixeles[i] = 0;
		}
	}
	
	public void mostrar(final int compensacionX, final int compensacionY){
		for (int y = 0; y < alto; y++){
			int posicionY = y + compensacionY;
			if (posicionY < 0 || posicionY >= alto){
				continue;
			}
										
			for (int x = 0; x < ancho; x++){
				int posicionX = x + compensacionX;
				if (posicionX < 0 || posicionX >= ancho){
					continue;
				}
				
				pixeles[posicionX + posicionY * ancho] = claseSprite.personaje.pixeles[(x & MASCARA_SPRITE) + (y & MASCARA_SPRITE) * LADO_SPRITE];
			}
		}
	}
	
}
