package fr.alex.recherchePlusOuMoins;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class ClasseMain {

	public static void main(String[] args) {
		
		/** déclaration des variables du programme
		 */
		String reponse,  clavier, reponseSigne ;
		char carac = ' ';
		char nbRecup = ' ';
		int nombreProp, nombreRech;
		double nb;
		int nbreRecherche[] = new int[4];
		int nbrePropose[] = new int [4];
		int nbDeCoups = 0;
		
		/** déclaration des classes
		 */
		Scanner sc = new Scanner(System.in);
		Random random= new Random();
		
		System.out.println("-----------------------------------------------");
		System.out.println("------------- Jeu de Recherche +/- ------------");
		System.out.println("-----------------------------------------------");
		System.out.println("\n  Trouvez la combinaison en un minimum de coup");
		System.out.println("\n-----------------------------------------------");
		
		
		
		/** boucle permettant le remplissage du tableau, contenant les chiffres aléatoires
		 */
		for (int i = 0; i < nbreRecherche.length; i++) {
			nb  = random.nextInt(9);
			nombreRech = (int)nb;
			nbreRecherche[i] = nombreRech;
			//System.out.println(nombreRech);
		}
		
		/** Boucle permettant de recommencer une partie
		 */
		do {
			/** Boucle permettant de comparer les valeurs des deux tableaux
			 */
			do {
				
									
				do {
					System.out.println("\nVeuillez entrer une combinaison à quatre chiffres");
					reponse = sc.nextLine();
				}while (reponse.length() != 4);
				/**  Boucle permettant le remplissage du tableau, contenant les chiffres entrées
				 * 	 La variable char 'nbRecup' récupère un chiffre à chaque tour de la boucle
				 *   int nombreProp récupère et change de type la valeur de char nbRecup
				 *   mise en place de la variable nombreProp dans le tableau correspondant à l'index i
				 */
				for (int i = 0; i < nbrePropose.length; i++) {
					nbRecup = reponse.charAt(i);
					nombreProp = Character.getNumericValue(nbRecup); 
					nbrePropose[i] = nombreProp;
				}
				
				/** boucle permettant la comparaison des index identiques, entre les 2 tableaux
				 *  suivant la comparaison, attribution d'un signe
				 */
				for (int i = 0; i < nbrePropose.length; i++) {
					
					if (nbrePropose[i] < nbreRecherche[i]) {
						reponseSigne = "+";
					}else if(nbrePropose[i] > nbreRecherche[i])	{
						reponseSigne = "-";
					}else {
						reponseSigne = "=";
					}
					System.out.print(reponseSigne);
					
				}
				nbDeCoups++;
			}while(!Arrays.equals(nbrePropose,nbreRecherche));
					
			System.out.println("\n\n-----------------------------------------");
			System.out.println("Vous avez trouvé la réponse est bien " + nbreRecherche[0] + nbreRecherche[1] + nbreRecherche[2] + nbreRecherche[3]);
			System.out.println("Vous l'avez réussi en " + nbDeCoups + " coups");
			System.out.println("-----------------------------------------");
			/** boucle pour relancer le programme, on entre un 'O' pour recommence et un 'N' pour quitter le programme
			 * 	demande d'entrer 'O' ou 'N' dans le Scanner
			 * 	try pour éviter le crash si aucune valeur est entrée dans le Scanner
			 */
			do {
				/**
				 * boucle permettant d'eviter une erreur en s'assurant qu'il n y est qu'un seul caractère
				 */
				do {
					System.out.println("Voulez vous faire une autre partie ?\n(O pour 'oui' / N pour 'non')");
					clavier = sc.nextLine();
					System.out.println(clavier.length());
				}while(clavier.length() != 1);
					
				carac = clavier.charAt(0);
				
				
			}while(carac != 'O' && carac != 'N');
		}while(carac == 'O');
		System.out.println("fin de programme");
		
		sc.close();
	}	
		
}
