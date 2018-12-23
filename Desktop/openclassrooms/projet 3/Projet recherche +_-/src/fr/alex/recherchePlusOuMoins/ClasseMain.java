package fr.alex.recherchePlusOuMoins;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class ClasseMain {

	public static void main(String[] args) {
		
		/** déclaration des variables du programme
		 */
		String reponse = " ",  clavier = "  ", reponse1 = " " ;
		char carac = ' ';
		char nbRecup = ' ';
		int nombreProp = 0, nombreRech = 0;
		double nb = 0.0;
		int nbreRecherche[] = new int[4];
		int nbrePropose[] = new int [4];
		int nbDeCoups = 0;
		
		/** déclaration des classes
		 */
		Scanner sc = new Scanner(System.in);
		Random random= new Random();
		
		presentation();
		nombreMystere(nbreRecherche,nb,nombreRech,random);
				
		
		/** Boucle permettant de recommencer une partie
		 */
		do {
			/** Boucle permettant de comparer les valeurs des deux tableaux
			 */
			do {
				/**Boucle permettant de s'assurer du nombre de caractère saisie					
				 */
				do {
					reponse = nombreRentre(reponse1, sc);
				}while (reponse.length() != 4);
								
				conversionChaineEnEntier(nbrePropose, nombreProp, nbRecup, reponse);
								
				comparaisonTableau(nbrePropose, nbreRecherche);
				
				//ajout à chaque tour d'un coup joué
				nbDeCoups++;
			}while(!Arrays.equals(nbrePropose,nbreRecherche));
					
			resultatFinal(nbreRecherche, nbDeCoups);
			
			/** boucle pour relancer le programme, on entre un 'O' pour recommence et un 'N' pour quitter le programme
			 * 	demande d'entrer 'O' ou 'N' dans le Scanner
			 */
			do {
				/**
				 * boucle permettant d'eviter une erreur en s'assurant qu'il n y est qu'un seul caractère
				 */
				do {
					clavier = saisieRelancePartie(clavier, sc);
				}while(clavier.length() != 1);
					carac = clavier.charAt(0);
			
			}while(carac != 'O' && carac != 'N');
		
		}while(carac == 'O');
		
		System.out.println("fin de programme");
		
		sc.close();
	}
	
	public static void presentation(){
		System.out.println("-----------------------------------------------");
		System.out.println("------------- Jeu de Recherche +/- ------------");
		System.out.println("-----------------------------------------------");
		System.out.println("\n  Trouvez la combinaison en un minimum de coup");
		System.out.println("\n-----------------------------------------------");	
	}
	
	
	public static int[] nombreMystere(int[]nbProp, double pNb, int pNombreRech, Random random1) {
				
		/** boucle permettant le remplissage du tableau, contenant les chiffres aléatoires
		 */
		for (int i = 0; i < nbProp.length; i++) {
			pNb = random1.nextInt(10);
			pNombreRech = (int)pNb;
			nbProp[i] = pNombreRech;
			System.out.println(pNombreRech);
		}
		return nbProp;
	}	
	
	public static String nombreRentre(String pReponse, Scanner pSc) {
		/**entrée par l'utilisateur de son choix d'une combinaison
		 * 
		 */
		System.out.println("\nVeuillez entrer une combinaison à quatre chiffres");
		pSc = new Scanner(System.in);
		pReponse = pSc.nextLine();
		System.out.println(pReponse);
		return pReponse;
	}
	
	public static int[] conversionChaineEnEntier(int pNbrePropose[], int pNombreProp, char pNbRecup, String reponse ) {
		/**  Boucle permettant le remplissage du tableau, contenant les chiffres entrées
		 * 	 La variable char 'nbRecup' récupère un chiffre à chaque tour de la boucle
		 *   int nombreProp récupère et change de type la valeur de char nbRecup
		 *   mise en place de la variable nombreProp dans le tableau correspondant à l'index i
		 */	
		
		for (int i = 0; i < pNbrePropose.length; i++) {
			pNbRecup = reponse.charAt(i);
			pNombreProp = Character.getNumericValue(pNbRecup); 
			pNbrePropose[i] = pNombreProp;
			}
		return pNbrePropose;
	}
	
	public static String comparaisonTableau(int pNbrePropose[], int pNbreRecherche[] ) {
		/** boucle permettant la comparaison des index identiques, entre les 2 tableaux
		 *  suivant la comparaison, attribution d'un signe
		 */
		String signe = " ";
		for (int i = 0; i < pNbrePropose.length; i++) {
			
			if (pNbrePropose[i] < pNbreRecherche[i]) {
				signe = "+";
			}else if (pNbrePropose[i] > pNbreRecherche[i]){
				signe = "-";
			}else {
				signe = "=";
			}
			System.out.print(signe);
		
		}
		return signe;
	}
	
	public static String saisieRelancePartie(String pClavier, Scanner pSc) {
		pSc = new Scanner(System.in);
		System.out.println("Voulez vous faire une autre partie ?\n(O pour 'oui' / N pour 'non')");
		pClavier = pSc.nextLine();
		
		return pClavier;
	}
	
	public static void resultatFinal(int pNbreRecherche[], int pNbDeCoups) {
		System.out.println("\n\n-----------------------------------------");
		System.out.println("Vous avez trouvé la réponse est bien " + pNbreRecherche[0] + pNbreRecherche[1] + pNbreRecherche[2] + pNbreRecherche[3]);
		System.out.println("Vous l'avez réussi en " + pNbDeCoups + " coups");
		System.out.println("-----------------------------------------");
	}
	
}