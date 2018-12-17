package fr.alex.recherchePlusOuMoins;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class ClasseMain {

	public static void main(String[] args) {
		
		/** d�claration des variables du programme
		 */
		String reponse,  clavier, reponseSigne ;
		char carac = ' ';
		char nbRecup = ' ';
		int nombreProp, nombreRech;
		double nb;
		int nbreRecherche[] = new int[4];
		int nbrePropose[] = new int [4];
		
		
		/** d�claration des classes
		 */
		Scanner sc = new Scanner(System.in);
		Random random= new Random();
		
		/** boucle permettant le remplissage du tableau, contenant les chiffres al�atoires
		 */
		for (int i = 0; i < nbreRecherche.length; i++) {
			nb  = random.nextInt(9);
			nombreRech = (int)nb;
			nbreRecherche[i] = nombreRech;
			System.out.println(nombreRech);
		}
		
		/** Boucle permettant de recommencer une partie
		 */
		do {
			/** Boucle permettant de comparer les valeurs des deux tableaux
			 */
			do {
				System.out.println("\nVeuillez entrer une combinaison � quatre chiffres");
				reponse = sc.nextLine();
				
				/**  Boucle permettant le remplissage du tableau, contenant les chiffres entr�es
				 * 	 La variable char 'nbRecup' r�cup�re un chiffre � chaque tour de la boucle
				 *   int nombreProp r�cup�re et change de type la valeur de char nbRecup
				 *   mise en place de la variable nombreProp dans le tableau correspondant � l'index i
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
				
			}while(!Arrays.equals(nbrePropose,nbreRecherche));
					
			
			System.out.println("Vous avez trouv� la r�ponse est bien " + nbreRecherche[0] + nbreRecherche[1] + nbreRecherche[2] + nbreRecherche[3]);
			
			/** boucle pour relancer le programme
			 * 	demande d'entrer 'O' ou 'N' dans le Scanner
			 * 	try pour �viter le crash si aucune valeur est entr�e dans le Scanner
			 */
			do { 
				System.out.println("Voulez vous faire une autre partie ?(O pour 'oui' / N pour 'non')");
				
				clavier = sc.nextLine();
				try {
					carac = clavier.charAt(0);
				} catch(StringIndexOutOfBoundsException siobe){
				    
				}
				
			}while(carac != 'O' && carac != 'N');
		}while(carac == 'O');
		System.out.println("fin de programme");
		
		sc.close();
	}	
	
}
