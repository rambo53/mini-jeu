package fr.noz;

import java.util.ArrayList;
import java.util.Scanner;



public class main {

	public static void main(String... args) {
		
		Acheteur yann=new Acheteur("Yann",false, false,8);
		
		Acheteur paul=new Acheteur("Paul", true, true,12);
		
		Acheteur laura=new Acheteur("Laura", true, false,10);
		
		Acheteur victoire=new Acheteur("Victoire", true, true,12);
		
		boolean acheteurChoisit=false;
		
		ArrayList<Integer> lotsDuJour = new ArrayList<>();

		
		do {
		System.out.println("Quel acheteur voulez vous utiliser : Yann, Paul, Laura, Victoire?");
		Scanner sc=new Scanner(System.in);
		String acheteurSelectionne=sc.nextLine();

		Acheteur acheteur = null;	
	
		switch(acheteurSelectionne) {
		
		case "Yann":
			acheteur=yann;
			acheteurChoisit=true;
			break;
			
		case "Paul":
			acheteur=paul;
			acheteurChoisit=true;
			break;
			
		case "Laura":
			acheteur=laura;
			acheteurChoisit=true;
			break;	
			
		case "Victoire":
			acheteur=victoire;
			acheteurChoisit=true;
			break;
			
		default :
			acheteurChoisit=false;
			System.out.println("Cet acheteur n'existe pas.");
			
		}

		
		if(acheteurChoisit==true) {
			System.out.println("Vous avez choisit l'acheteur "+acheteurSelectionne);
			
			
			int days = 1;	
			
			System.out.println("Bienvenue au sein de l'univers NOZ "+acheteurSelectionne+".");
			LotsDetectesTotal lotsDetectesSemaine=new LotsDetectesTotal();
		do {
			
			acheteur.lotsDetectesDuJour=0;

			if(days%6!=0) {
				
				int actionsDeLaJournee=1;
				
				do {
					
			if(actionsDeLaJournee==1) {	
			System.out.println("Quelle première action voulez vous faire aujourd'hui, appels, café, travailler dossier?");
			}
			
			if(actionsDeLaJournee==2) {	
				System.out.println("Quelle deuxième action voulez vous faire aujourd'hui, appels, café, travailler dossier?");
				}
			
			if(actionsDeLaJournee==3) {	
				System.out.println("Quelle troisième action voulez vous faire aujourd'hui, appels, café, travailler dossier?");
				}
			
			Scanner sc1=new Scanner(System.in);
			String actionSelectionne=sc1.nextLine();
			
			if(actionSelectionne.equalsIgnoreCase("appels") && acheteur.energie>1) {
				acheteur.appels(acheteurSelectionne);
			}
			else if(actionSelectionne.equalsIgnoreCase("café")) {
				acheteur.cafe(acheteurSelectionne);
			
			}
			else if(actionSelectionne.equalsIgnoreCase("travailler dossier")&& acheteur.energie>1) {
				acheteur.travaillerDossier(acheteurSelectionne,lotsDetectesSemaine);
			}
			else {
				System.out.println(acheteurSelectionne+" vous êtes trop fatigué, rechargez votre énergie.");
			
			}
			actionsDeLaJournee++;
			lotsDetectesSemaine.lotsDetectes.add(acheteur.lotsDetectesDuJour);
			lotsDuJour.add(acheteur.lotsDetectesDuJour);
			acheteur.lotsDetectesDuJour=0;
			}				
				while (actionsDeLaJournee<=3);
				
			int sommeLot=0;
			for(int lot:lotsDetectesSemaine.lotsDetectes) {
			sommeLot=sommeLot+lot;
			}
			
			int lotsJournaliers=0;
			for (Integer integer : lotsDuJour) {
				lotsJournaliers+=integer;
			}
			System.out.println(acheteurSelectionne+" aujourd'hui vous avez détecté "+lotsJournaliers/*acheteur.lotsDetectesDuJour*/+" lots, il vous reste encore "+acheteur.energie+" points d'énergie.");
			System.out.println(acheteurSelectionne+" vous avez détecté "+sommeLot+" lots depuis le début de la semaine.");
			System.out.println();
			
			lotsDuJour.clear();
			acheteur.energie++;	
			days++;
			
			if (days!=6) {
			System.out.println("Nous sommes le jour "+days+","+" il vous reste "+acheteur.energie+" points d'énergie." );
				}
		
			}		
				else {
					System.out.println("C'est le week end.");
					acheteur.energie+=2;
					days++;				
					}
			
				}
			while(days!=7);		
		}	
		} 
		while(acheteurChoisit==false);
		
	}
}
