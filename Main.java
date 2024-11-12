package Package_BC;

public class Main {

	public static void main(String[] args) {
		String Joueur1, Joueur2, Mot, Proposition, Relancer;
		int i, j, k, l, iGenerale, N, Taille, TentativeRestante, Tentative, PositionProposition, PositionMot;
		String TabMot[], TabProposition[], TabAvancement[], TabLettre[], Position, Resultat[][];

		System.out.println("		┌──────────────────────────────────────────────────────────────┐");
		System.out.println("		│    ___                __ MOTUS & _____                       │");
		System.out.println("		│   / _ )___  __ ______/ /  ___   / ___/__  __ _____ __ _____  │");
		System.out.println("		│  / _  / _ \\/ // / __/ _ \\/ -_) / /__/ _ \\/ // (_-</ // / -_) │");
		System.out.println("		│ /____/\\___/\\_,_/\\__/_//_/\\__/  \\___/\\___/\\_,_/___/\\_,_/\\__/  │");
		System.out.println("		│                                                              │");
		System.out.println("		└──────────────────────────────────────────────────────────────┘");
		System.out.println();
		System.out.println("			       LE MOT SECRET PAR ELIAS");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println();

		do
		{
			// Choix du pseudonyme du joueur 1
			System.out.println(Couleur.couleur("Joueur 1", Couleur.CYAN) + ", vous choisirez le mot à deviner.");
			Joueur1 = Couleur.couleur(Saisie.lire_String("Veuillez entrer votre pseudonyme:"), Couleur.CYAN);
			System.out.println();
			
			// Choix du pseudonyme du joueur 2
			System.out.println(Couleur.couleur("Joueur 2", Couleur.ROUGE) + ", vous devinerez lenombre mystère.");
			Joueur2 = Couleur.couleur(Saisie.lire_String("Veuillez entrer votre pseudonyme:"), Couleur.ROUGE);
			System.out.println();
			
			// Choix du mot à deviner
			Mot = Saisie.lire_String(Joueur1 + ", choisissez le mot que " + Joueur2 + " devra deviner, votre mot doit comprendre au moins 5 caractères :").toUpperCase();
			System.out.println();
			Taille = Mot.length();
			
			// Contrôle de la taille du mot à deviner (>=5)
			while (Taille<5) {
				System.out.println(Joueur1 + ", le mot que vous avez choisi ne comporte pas 5 caractères !");
				Mot = Saisie.lire_String("Veuillez rentrer un nouveau mot à deviner :").toUpperCase();
				System.out.println();
				Taille = Mot.length();
			}
			
			// Affecte la taille du mot à l'ordre des Vecteurs
			N = Taille;
			// Affecte le nombre de tentative
			Tentative = Taille-2;
			
			// On instancie les vecteurs et la matrice
			TabMot = new String [N];
			TabProposition = new String [N];
			TabAvancement = new String [N];
			TabLettre = new String [24];
			Resultat = new String [Tentative][N];
			
			// On transfert le mot à deviner dans la table TabMot  et on affecte "_" aux N cases des autres Tables
			for (i=0; i<N; i++) {
				TabMot[i] = Mot.substring(i,i+1);
				TabAvancement[i] = "_";
				TabLettre[i] = "_";
			}
			
			// On affecte "_" aux cases de la matrice
			for (i=0; i<Tentative; i++) {
				for (j=0; j<N; j++) {
					Resultat[i][j] = "_";
				}
			}
			
			// On affecte "_" aux 24 cases du vecteur
			for (i=0; i<24; i++) {
				TabLettre[i] = "_";
			}
			
			Proposition = " ";
			TentativeRestante = 1;

			// Boucle pour deviner le mot à deviner
			for(iGenerale=0; iGenerale<Tentative && !Proposition.equals(Mot) && !Proposition.equals("SOL") && TentativeRestante != 0; iGenerale++) {
				TentativeRestante = Tentative-iGenerale;
				Proposition = Saisie.lire_String(Joueur2 +", proposez un mot. Vous avez " + TentativeRestante + " tentative(s) :").toUpperCase();
				System.out.println();
				
				if(Proposition.equals("SOL")) {
					System.out.println("Vous avez abandonner...");
					System.out.println("Le mot à deviner était : " + Couleur.couleur(String.valueOf(Mot).toUpperCase(), Couleur.JAUNE) + ".");
				} else {
					Taille = Proposition.length();
					while (Taille<5||Taille>N) {
						System.out.println("Erreur de saisie");
						Proposition = Saisie.lire_String(Joueur1 + ", proposez un mot à deviner. Vous avez " + TentativeRestante + "  tentative(s) :").toUpperCase();
						System.out.println();
						Taille = Proposition.length();
					}
					
					// On transfert Proposition dans TabProposition
					for (i=0; i<N; i++) {
						TabProposition[i] = Proposition.substring(i,i+1);
					}
					
					// Boucle pour comparer la Proposition et le mot à deviner
					for (j = 0; j < N; j++)
					{
					    for (k = 0; k < N; k++)
					    {
					        // Si la lettre est identique et à la bonne place
					        if (TabProposition[j].equals(TabMot[k]) && j == k)
					        {
					        	TabAvancement[k] = TabProposition[j];
					        }
					        else if (TabProposition[j].equals(TabMot[k]))
					        {
					        	for (l = 0; l<24; l++)
					        	{
					        		if (TabLettre[l].equals(TabProposition[j]))
					        		{
					        			TabLettre[l] = "_";
					        		}			                
					        	}
					        	TabLettre[j] = TabProposition[j];
					        }
					    }
					}

				for (i=0; i<N; i++)
				{
					Resultat[iGenerale][i] = TabProposition[i];
				}
							
					System.out.print("Voici l'avancement du mot : ");
					
					for (j=0; j<N; j++) {
						System.out.print(TabAvancement[j]);
					}	
					System.out.println();
					
					System.out.print("Et les lettres présentes mais mal placées sont : ");
					for (j=0; j<24; j++) {
						if (!TabLettre[j].equals("_")){
						System.out.print(TabLettre[j] + ", ");
						}	
					}
					System.out.println();
				}
			
			}
			
			if (Proposition.equals(Mot)) {
				System.out.println(Couleur.couleur("Gagné ! ", Couleur.VERT) + "Le mot à deviner était : " + Couleur.couleur(String.valueOf(Mot).toUpperCase(), Couleur.JAUNE) + ".");
				System.out.println("Il vous aura fallu " + (iGenerale+1) + " tentative(s).");
			}
			else if (TentativeRestante == 0) {
				System.out.println(Couleur.couleur("Perdu ! ", Couleur.ROUGE) + "Le mot à deviner était : " + Couleur.couleur(String.valueOf(Mot).toUpperCase(), Couleur.JAUNE) + ".");
			}
			
			// Demande au joueur de rejouer ou non ?
			Relancer = Saisie.lire_String("Voulez-vous relancer une partie ? Oui ? Non ?");

			// Contrôle de la saisie de la réponse des joueurs
			while((Relancer.toUpperCase().equals("OUI") == false) && (Relancer.toUpperCase().equals("NON") == false)) {
				Relancer = Saisie.lire_String("Voulez-vous relancer une partie ? Oui ? Non ?"); // Redemande la réponse aux joueurs
			}
			
			// Fait appelle à la class Clear
			if (Relancer.toUpperCase().equals("OUI")) Clear.clearConsole();
		
		} while (Relancer.toUpperCase().equals("OUI") == true);
		
		// Bas de page
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("			MERCI D'AVOIR JOUÉ");
	}
}

