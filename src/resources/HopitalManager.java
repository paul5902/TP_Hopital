package resources;

import java.util.Scanner;

import resources.pools.MedecinPool;
import resources.pools.PatientPool;

public class HopitalManager {
	private Scanner sc;
		
	public HopitalManager() {
		sc = new Scanner(System.in);
	}
	
	public void text() {
		System.out.println("*********** Que voulez-vous faire? ***********");
		System.out.println("1 - Entree d'un patient");
		System.out.println("2 - Visualisation d'un sejour");
		System.out.println("3 - Consultation");
		System.out.println("4 - Sortie d'un patient.");
		System.out.print("5 - Quitter");
	}
	
	public int displayMenu() {
		text();
		int choix;
		while (!sc.hasNextInt()) {
		       text();
		       sc.nextLine(); 
		}
		choix = Integer.parseInt(sc.nextLine());
		return choix;
	}
	
	public void entreePatient(PatientPool pp) {
		System.out.println("Veuillez saisir le nom du patient.");
		String nom = sc.nextLine();
		if (pp.patientExists(nom)) {
			System.out.println("Le patient existe deja†.");
		} else {
			System.out.println("Saisir son numero de secu");
			int numeroSecu;
			while (!sc.hasNextInt()) {
			       System.out.println("Erreur. Merci d'entrer un nombre correct. \n ");
			       sc.nextLine(); 
			}
			numeroSecu = Integer.parseInt(sc.nextLine());
			System.out.println("Saisir son age");
			int age;
			while (!sc.hasNextInt()) {
			       System.out.println("Erreur. Merci d'entrer un nombre correct. \n ");
			       sc.nextLine(); 
			}
			age = Integer.parseInt(sc.nextLine());
			System.out.println("Saisir son adresse");
			String adresse = sc.nextLine();
			Patient p = new Patient(nom, adresse, age, numeroSecu);
			System.out.println("Saisir la date d'entree du patient");
			String dateEntree = sc.nextLine();
			FicheSejour ficheSej = new FicheSejour(p, dateEntree);
			System.out.println("Quelle specialite(s) doit-il consulter?");
			String spec = "";
			while (!spec.equals("q")) {
				System.out.println("\n\n\n\n");
				System.out.println("1 - Cardiologie");
				System.out.println("2 - Psychiatre");
				System.out.println("3 - Allergologie");
				System.out.println("4 - Chirurgie");
				System.out.println("5 - Hematologie");
				System.out.println("q - Quitter menu");
				spec = sc.nextLine();
				if (spec.equals("1")) {
					ficheSej.addSpecialiteToSejour(Specialite.Cardiologie);
				} else if (spec.equals("2")) {
					ficheSej.addSpecialiteToSejour(Specialite.Psychiatrie);
				} else if (spec.equals("3")) {
					ficheSej.addSpecialiteToSejour(Specialite.Allergologie);
				} else if (spec.equals("4")) {
					ficheSej.addSpecialiteToSejour(Specialite.Chirurgie);
				} else if (spec.equals("5")) {
					ficheSej.addSpecialiteToSejour(Specialite.Hematologie);
				}

			}

			p.setFicheSejour(ficheSej);
			FicheSuivi ficheSuiv = new FicheSuivi();
			p.setFicheSuivi(ficheSuiv);
			pp.addPatient(p);

		}
	}
	
	public void visualiserSejour(PatientPool pp) {
		System.out.println("Saisir le nom du patient dont vous voulez visualiser le sejour.");
		String nom = sc.nextLine();
		if (!pp.patientExists(nom)) {
			System.out.println("Le patient n'existe pas!");
		} else {
			Patient p = pp.getPatient(nom);
			FicheSejour ficheSej = p.getFicheSejour();
			System.out.println("Le patient a debute son sejour le " + ficheSej.getDateEntree());

			if (ficheSej.getSpecialitesSejour().isEmpty()) {
				System.out.println("Pas de specialite dans le s√©jour.");
			} else {
				System.out.println("Liste des specialites du s√©jour:");
				ficheSej.displaySpecialites();
			}

			if (ficheSej.getListeCompteRendus().isEmpty()) {
				System.out.println("Pas encore de compte rendu saisi.");
			} else {
				System.out.println("Liste des comptes rendus saisis :");
				ficheSej.displayComptesRendus();
			}
		}
	}
	
	public void consultation(PatientPool pp, MedecinPool mp) {
		System.out.println("Saisissez votre nom de medecin");
		String nomMedecin = sc.nextLine();
		if (!mp.medecinExists(nomMedecin)) {
			System.out.println("Aucune medecin ne correspond √† ce nom.");
		} else {
			Medecin medecin = mp.getMedecin(nomMedecin);
			
			System.out.println("Veuillez saisir le nom du patient");
			String nomPatient = sc.nextLine();
			Patient p = pp.getPatient(nomPatient);
			
			if ((!pp.patientExists(nomPatient)) || (!p.getFicheSejour().findSpecialite(medecin.getSpecialite()))) {
				System.out.println("Le patient n'existe pas, ou votre specialite n'existe pas pour le sejour du patient.");
			}
			else {
				System.out.println("Liste des comptes rendus pour la specialite : \n"+medecin.getSpecialite());
				p.getFicheSuivi().displayCompteRendusForSpecialite(medecin.getSpecialite());
				System.out.println("Veuillez saisir votre compte rendu :");
				System.out.println("Date de la consultation :");
				String dateConsultation = sc.nextLine();
				System.out.println("Contenu de la consultation : ");
				String contenuConsultation = sc.nextLine();
				System.out.println("Nom du specialiste : ");
				String nomSpecialiste = sc.nextLine();
				CompteRendu compteRendu = new CompteRendu(dateConsultation, contenuConsultation, nomSpecialiste);
				p.getFicheSejour().addCompteRenduToSejour(compteRendu);
				p.getFicheSuivi().addCompteRendu(compteRendu, medecin.getSpecialite());
				
				
			}
			
			
		}
	}
	
	public void sortirPatient(PatientPool pp) {
		System.out.println("Saisissez le nom du patient");
		String nomPatient = sc.nextLine();
		if(!pp.patientExists(nomPatient)) {
			System.out.println("Le patient n'existe pas. ");
		}
		else {
			Patient patient = pp.getPatient(nomPatient);
			pp.removePatient(patient);
			patient.removeFicheSejour();
			System.out.println("Le patient est bien sorti du systËme de gestion de l'hopital.");
		}
	}

}
