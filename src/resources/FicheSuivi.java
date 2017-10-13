package resources;

import java.util.HashMap;
import java.util.Map;

public class FicheSuivi {
	
	private Patient patient;
	private HashMap<CompteRendu, Specialite> listeCompteRendus;
	
	public FicheSuivi(Patient patient) {
		this.patient = patient;
		listeCompteRendus = new HashMap<CompteRendu, Specialite>();
	}
	
	public void addCompteRendu(CompteRendu compteRendu, Specialite specialite) {
		listeCompteRendus.put(compteRendu, specialite);
	}
	
	public void displayCompteRendusForSpecialite(Specialite specialite) {
		for (Map.Entry<CompteRendu, Specialite> entry : listeCompteRendus.entrySet()) {
		    if(entry.getValue() == specialite) {
		    	entry.getKey().displayInfo();
		    }
		}
	}

}
