package fr.noz;

import java.util.Random;

public class Acheteur{

	
	String prenom;
	int appels;
	int lotsDetectesDuJour;
	int energie;
	boolean tapeDesMains;
	boolean coGerant;
	int lotDetecte; 
	
	
	Acheteur(String prenom,boolean tapeDesMains,boolean coGerant,int energie) {
		// TODO Auto-generated constructor stub
		this.energie=energie;
		this.prenom=prenom;
		this.tapeDesMains=tapeDesMains;
		this.coGerant=coGerant;
	}

	public int appels(String acheteurSelectionne) {// permet d'attribuer ou non un lot détecté par l'acheteur
		// TODO Auto-generated method stub
		
		 Random r = new Random();
	        int appelsEmis = r.nextInt(3);
	        
	        if(appelsEmis==1) {
	        	System.out.println(acheteurSelectionne+" a détecté un lot!");
	        	lotDetecte=1;	        	
	        	}
	        else if(appelsEmis==2) {
	        		if(tapeDesMains) {
	        		System.out.println("Erwann intervient alors "+acheteurSelectionne+" tape des mains.");
	        		}
	        		else { 
	        		System.out.println(acheteurSelectionne+" a détecté un lot!");
	        		lotDetecte=1;	
	        		}	        		
	        	}
	        else {
	        	System.out.println(acheteurSelectionne+" a la flemme.");
	        	lotDetecte=0;
	        }
	        energie-=2;
	      lotsDetectesDuJour+=lotDetecte;
	        return lotsDetectesDuJour;
	}
	
	

	public void cafe(String acheteurSelectionne) {
		energie+=2;
		System.out.println(acheteurSelectionne+" a maintenant "+energie+" points d'énergie.");
	}
	
	
	public void travaillerDossier(String acheteurSelectionne,LotsDetectesTotal lotsDetectesSemaine) {//me permet d'attribuer un montant de commande en fonction des lots détectés par l'acheteur, plus il a de lots plus il a de chance de commander
		int montantCommande = 0;
		int sommeLot=0;
		for(int lot:lotsDetectesSemaine.lotsDetectes) {//for each qui additione le total de lots détectés enregistré dans ma liste
			
			sommeLot=sommeLot+lot;}
		
		if(sommeLot==0) {
			montantCommande=0;
			System.out.println("Vous passez une commande de "+montantCommande+" €");
		}
		else if(sommeLot==1) {// 1 chance sur 4 de passer commande
			 Random r = new Random();
		        int dossierValide = r.nextInt(4);
		        
		        if(dossierValide==2) {
		        	Random r1 = new Random();
			        montantCommande = r1.nextInt(10000);
			        System.out.println("Vous passez une commande de "+montantCommande+" €");
		        }
		        else {
		        	montantCommande=0;
		        	System.out.println("Vous passez une commande de "+montantCommande+" €");
		        }
		}
		else if(sommeLot==2) {// 1 chance sur 3
			 Random r = new Random();
		        int dossierValide = r.nextInt(3);
		        
		        if(dossierValide==2) {
		        	Random r1 = new Random();
			        montantCommande = r1.nextInt(10000);
			        System.out.println("Vous passez une commande de "+montantCommande+" €");
		        }
		        else {
		            montantCommande=0;
		            System.out.println("Vous passez une commande de "+montantCommande+" €");
		        }
		}
		else if(sommeLot==3) {// 1 chance sur 2
			 Random r = new Random();
		        int dossierValide = r.nextInt(2);
		        
		        if(dossierValide==2) {
		        	Random r1 = new Random();
			        montantCommande = r1.nextInt(10000);
			        System.out.println("Vous passez une commande de "+montantCommande+" €");
		        }
		        else {
		        	montantCommande=0;
		        	System.out.println("Vous passez une commande de "+montantCommande+" €");
		        }
		}
		else {
			Random r1 = new Random();
	        montantCommande = r1.nextInt(10000);
	        System.out.println("Vous passez une commande de "+montantCommande+" €");
		}
		lotsDetectesSemaine.lotsDetectes.clear();//remet le nombre de lots détectés de ma liste a zero
		energie-=2;
		
	}
	

}
