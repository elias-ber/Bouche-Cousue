package Package_BC;

public class Clear {
	public static void main(String[] args){
		// Appel de la commande pour "effacer" la console
		clearConsole();
		}
	
	public static void clearConsole()
	{
		// Utilisez une boucle pour imprimer des lignes vides
		for (int i = 1500; i > 0; i--) {
			System.out.println();
			}
		}
	}