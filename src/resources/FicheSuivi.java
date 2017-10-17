package resources;

import java.util.HashMap;
import java.util.Map;

public class FicheSuivi {
	
	private HashMap<CompteRendu, Specialite> listeCompteRendus;
	
	public FicheSuivi() {
		listeCompteRendus = new HashMap<CompteRendu, Specialite>();
	}
	
	public void addCompteRendu(CompteRendu compteRendu, Specialite specialite) {
		listeCompteRendus.put(compteRendu, specialite);
	}
	
	public void displayCompteRendusForSpecialite(Specialite specialite) {
		if(!listeCompteRendus.isEmpty()) {
			for (Map.Entry<CompteRendu, Specialite> entry : listeCompteRendus.entrySet()) {
				if(entry.getValue() == specialite) {
					entry.getKey().displayInfo();
				}
			}
		}
	}

}
