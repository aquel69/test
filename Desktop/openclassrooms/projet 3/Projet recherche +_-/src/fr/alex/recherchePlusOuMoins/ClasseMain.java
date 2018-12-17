package fr.alex.recherchePlusOuMoins;

import java.util.Random;
import java.util.Scanner;

public class ClasseMain {

	public static void main(String[] args) {
		
		String reponse, reponseInt = null, clavier, reponseSigne ;
		
		char carac = ' ';
		char nbRecup = ' ';
		int nbreRecherche[] = new int[4];
		int nbrePropose[] = new int [4];
		int nombreProp;
		int nombreRech;
		double nb;
		Scanner sc = new Scanner(System.in);
		Random random= new Random();
		
		for (int i = 0; i < nbreRecherche.length; i++) {
			nb  = random.nextInt(9);
			nombreRech = (int)nb;
			nbreRecherche[i] = nombreRech;
			System.out.println(nombreRech);
		}
		
		do {
			
			do {
				System.out.println("Veuillez entrer une combinaison à quatre chiffres");
				reponse = sc.nextLine();
				for (int i = 0; i < nbrePropose.length; i++) {
					nbRecup = reponse.charAt(i);
					reponseInt = String.valueOf(nbRecup); 
					//System.out.println("nombre" + i + "correspond à" + nbRecup);
					nombreProp = Integer.parseInt(reponseInt);
					nbrePropose[i] = nombreProp;
				}
				/*  for(int i = 0;i < nbrePropose.length; i++) {
					System.out.println("la case " + i + "et le chiffre est " + nbrePropose[i]);
				
				
				} */
				
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
				for (int i = 0; i < nbrePropose.length; i++)
					System.out.println("\n" +  nbrePropose[i]);
				for (int i = 0; i < nbrePropose.length; i++)
					System.out.println(nbreRecherche[i]);
			}while(!nbreRecherche.equals(nbrePropose));
			
			System.out.println("Vous avez trouvé la réponse est bien" + nbreRecherche[0] + nbreRecherche[1] + nbreRecherche[2] + nbreRecherche[3]);
			do { // boucle pour relancer le programme
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
