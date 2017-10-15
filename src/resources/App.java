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
		CompteRendu cr1 = new CompteRendu("23 juin", "Rien a  signaler.", "Toto");
		fiche1.addCompteRenduToSejour(cr1);
		patient1.setFicheSejour(fiche1);
		pp.addPatient(patient1);

	}

	public static void main(String[] args) {
		init();
		HopitalManager manager = new HopitalManager();

		int choix = manager.displayMenu();

		while (choix != 5) {

			if (choix == 1) {

				manager.entreePatient(pp);
				choix = manager.displayMenu();
			}

			else if (choix == 2) {

				manager.visualiserSejour(pp);
				choix = manager.displayMenu();
			}

			else if (choix == 3) {

				manager.consultation(pp, mp);
				choix = manager.displayMenu();

			}

			else if (choix == 4) {

			}

		}
	}

}
