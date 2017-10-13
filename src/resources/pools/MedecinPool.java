package resources.pools;

import java.util.ArrayList;

import resources.Medecin;

public class MedecinPool {
	
	private ArrayList<Medecin> listeMedecins;
	
	public MedecinPool() {
		this.listeMedecins = new ArrayList<Medecin>();
	}
	
	public void addMedecin(Medecin medecin) {
		listeMedecins.add(medecin);
	}
	
	public boolean medecinExists(String medecinName) {
		boolean result = false;
		for(Medecin medecin : listeMedecins) {
			if(medecin.getNomMedecin().equals(medecinName)) {
				result = true;
			}
		}
		return result;
	}
	
	public Medecin getMedecin(String medecinName) {
		for(Medecin medecin : listeMedecins) {
			if(medecin.getNomMedecin().equals(medecinName)) {
				return medecin;
			}
		}
		return null;
	}

}
