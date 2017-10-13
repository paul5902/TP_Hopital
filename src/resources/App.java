package resources;

import java.util.Scanner;

import resources.pools.MedecinPool;
import resources.pools.PatientPool;

public class App {

	public static PatientPool pp;
	public static MedecinPool mp;

	public static void init() {
		pp = new PatientPool();
		mp = new MedecinPool();
		mp.addMedecin(new Medecin("Olivier", Specialite.Allergologie));
		Patient patient1 = new Patient("Letailleur", "rue d'aguesseau", 22, 11703315);
		FicheSuivi ficheSuiv1 = new FicheSuivi(patient1);
		CompteRendu cr0 = new CompteRendu("11 mai", "Allergie pollen", "Jamie");
		ficheSuiv1.addCompteRendu(cr0, Specialite.Allergologie);
		patient1.setFicheSuivi(ficheSuiv1);
		FicheSejour fiche1 = new FicheSejour(patient1, "22 Juin");
		fiche1.addSpecialiteToSejour(Specialite.Allergologie);
		fiche1.addSpecialiteToSejour(Specialite.Cardiologie);
		CompteRendu cr1 = new CompteRendu("23 juin", "Rien à signaler.", "Toto");
		fiche1.addCompteRenduToSejour(cr1);
		patient1.setFicheSejour(fiche1);
		pp.addPatient(patient1);

	}

	// TODO créer une classe qui gère les différents choix plutot qu'utiliser le
	// main
	public static void main(String[] args) {
		init();
		System.out.println("Que voulez-vous faire?");
		System.out.println("1 - Entrée d'un patient");
		System.out.println("2 - Visualisation d'un séjour");
		System.out.println("3 - Consultation");
		System.out.print("5 - Quitter");
		Scanner sc = new Scanner(System.in);
		int choix = Integer.parseInt(sc.nextLine());

		while (choix != 5) {

			if (choix == 1) {
				System.out.println("Veuillez saisir le nom du patient.");
				String nom = sc.nextLine();
				if (pp.patientExists(nom)) {
					System.out.println("Le patient existe déjà.");
				} else {
					System.out.println("Saisir son numéro de sécu");
					int numeroSecu = Integer.parseInt(sc.nextLine());
					System.out.println("Saisir son age");
					int age = Integer.parseInt(sc.nextLine());
					System.out.println("Saisir son adresse");
					String adresse = sc.nextLine();
					Patient p = new Patient(nom, adresse, age, numeroSecu);
					System.out.println("Saisir la date d'entrée du patient");
					String dateEntree = sc.nextLine();
					FicheSejour ficheSej = new FicheSejour(p, dateEntree);
					System.out.println("Quelle spécialités doit-il consulter?");
					String spec = "";
					while (!spec.equals("q")) {
						// TODO supprimer la spécialité lorsqu'elle a déjà été
						// saisie
						System.out.println("1 - Cardiologie");
						System.out.println("2 - Psychiatre");
						System.out.println("3 - Allergologie");
						System.out.println("4 - Chirurgie");
						System.out.println("5 - Hématologie");
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
							ficheSej.addSpecialiteToSejour(Specialite.Hématologie);
						}

					}

					p.setFicheSejour(ficheSej);
					pp.addPatient(p);

				}
				System.out.println("Que voulez-vous faire?");
				System.out.println("1 - Entrée d'un patient");
				System.out.println("2 - Visualisation d'un séjour");
				System.out.println("3 - Consultation");
				System.out.print("5 - Quitter");
				choix = Integer.parseInt(sc.nextLine());;
			}

			else if (choix == 2) {

				System.out.println("Saisir le nom du patient dont vous voulez visualiser le séjour.");
				String nom = sc.nextLine();
				if (!pp.patientExists(nom)) {
					System.out.println("Le patient n'existe pas!");
				} else {
					Patient p = pp.getPatient(nom);
					FicheSejour ficheSej = p.getFicheSejour();
					System.out.println("Le patient a débuté son séjour le " + ficheSej.getDateEntree());

					if (ficheSej.getSpecialitesSejour().isEmpty()) {
						System.out.println("Pas de spécialité dans le séjour.");
					} else {
						System.out.println("Liste des spécialités du séjour:");
						ficheSej.displaySpecialites();
					}

					if (ficheSej.getListeCompteRendus().isEmpty()) {
						System.out.println("Pas encore de compte rendu saisi.");
					} else {
						System.out.println("Liste des comptes rendus saisis :");
						ficheSej.displayComptesRendus();
					}
				}
				System.out.println("Que voulez-vous faire?");
				System.out.println("1 - Entrée d'un patient");
				System.out.println("2 - Visualisation d'un séjour");
				System.out.println("3 - Consultation");
				System.out.print("5 - Quitter");
				choix = Integer.parseInt(sc.nextLine());
			}

			else if (choix == 3) {

				System.out.println("Saisissez votre nom de médecin");
				String nomMedecin = sc.nextLine();
				if (!mp.medecinExists(nomMedecin)) {
					System.out.println("Aucune médecin ne correspond à ce nom.");
				} else {
					Medecin medecin = mp.getMedecin(nomMedecin);
					
					System.out.println("Veuillez saisir le nom du patient");
					String nomPatient = sc.nextLine();
					Patient p = pp.getPatient(nomPatient);
					
					if ((!pp.patientExists(nomPatient)) || (!p.getFicheSejour().findSpecialite(medecin.getSpecialite()))) {
						System.out.println("Le patient n'existe pas, ou votre spécialité n'existe pas pour le séjour du patient.");
					}
					else {
						System.out.println("Liste des comptes rendus pour la spécialité "+medecin.getSpecialite());
						p.getFicheSuivi().displayCompteRendusForSpecialite(medecin.getSpecialite());
						System.out.println("Veuillez saisir votre compte rendu :");
						System.out.println("Date de la consultation :");
						String dateConsultation = sc.nextLine();
						System.out.println("Contenu de la consultation : ");
						String contenuConsultation = sc.nextLine();
						System.out.println("Nom du spécialiste : ");
						String nomSpecialiste = sc.nextLine();
						CompteRendu compteRendu = new CompteRendu(dateConsultation, contenuConsultation, nomSpecialiste);
						p.getFicheSejour().addCompteRenduToSejour(compteRendu);
						p.getFicheSuivi().addCompteRendu(compteRendu, medecin.getSpecialite());
						
						
					}
					
					
				}
				
				System.out.println("Que voulez-vous faire?");
				System.out.println("1 - Entrée d'un patient");
				System.out.println("2 - Visualisation d'un séjour");
				System.out.println("3 - Consultation");
				System.out.print("5 - Quitter");
				choix = Integer.parseInt(sc.nextLine());

			}

		}
	}

}
