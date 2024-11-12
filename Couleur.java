package Package_BC;
public class Couleur {
		// Séquences d'échappement ANSI pour les couleurs du texte
		public static final String RESET = "\u001B[0m"; // Arrêt duchangement de couleur du texte
		public static final String NOIR = "\u001B[30m";// Changement decouleur du texte en NOIR
		public static final String ROUGE = "\u001B[31m"; // Changement decouleur du texte en ROUGE
		public static final String VERT = "\u001B[32m"; // Changement decouleur du texte en VERT
		public static final String JAUNE = "\u001B[33m"; // Changement decouleur du texte en JAUNE
		public static final String BLEU = "\u001B[34m"; // Changement decouleur du texte en BLEU
		public static final String VIOLET = "\u001B[35m"; // Changement decouleur du texte en VIOLERT
		public static final String CYAN = "\u001B[36m"; // Changement decouleur du texte en CYAN
		public static final String BLANC = "\u001B[37m"; // Changement decouleur du texte en BLANC
		
		public static String couleur(String text, String color) {
			return color + text + RESET; // Composition de la déclarationde changement de couleur
		}
	}