/*
 * Programación interactiva
 * Autor: Joshua Sebastian Chicame Muñoz -202074121
 * Caso 1: Juego Craps
 */
package craps;

import java.awt.EventQueue;

// TODO: Auto-generated Javadoc
/**
 * The Class PrincipalCraps. Clase que contiene el método Main e inica el programa
 */
public class PrincipalCraps {

	/**
	 * The main method. Método principal de Java
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				//vistaGUICraps myVista = new VistaGUICraps();
				VistaGUIGridBagLayout myVista = new VistaGUIGridBagLayout();
			}
		});
		
		
	}

}
