package resources;

import java.util.ArrayList;
import java.util.Date;

public class FicheSejour {
	
	private ArrayList<Specialite> specialitesSejour;
	private String dateEntree;
	private ArrayList<CompteRendu> listeCompteRendus;
	
	
	public FicheSejour(Patient patient,String dateEntree) {
		specialitesSejour = new ArrayList<Specialite>();
		this.dateEntree = dateEntree;
		this.listeCompteRendus = new ArrayList<CompteRendu>();
	}
	
	public ArrayList<CompteRendu> getListeCompteRendus() {
		return listeCompteRendus;
	}

	public void setListeCompteRendus(ArrayList<CompteRendu> listeCompteRendus) {
		this.listeCompteRendus = listeCompteRendus;
	}

	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}
	
	public ArrayList<Specialite> getSpecialitesSejour() {
		return specialitesSejour;
	}
	
	public void addSpecialiteToSejour(Specialite specialite) {
		if(specialitesSejour.contains(specialite)) {
			System.out.println("La specialite est deja  prevue dans le sejour.");
		}
		else {
			specialitesSejour.add(specialite);
		}
	}
	
	public void addCompteRenduToSejour(CompteRendu compteRend) {
		listeCompteRendus.add(compteRend);
	}
	
	public void displaySpecialites() {
		for(Specialite spec : specialitesSejour) {
			System.out.println(spec);
		}
	}
	
	public void displayComptesRendus() {
		for(CompteRendu compteRend : listeCompteRendus) {
			compteRend.displayInfo();
			System.out.println("\n");
		}
	}
	
	public boolean findSpecialite(Specialite specialite) {
		if(specialitesSejour.contains(specialite)) {
			return true;
		}
		return false;
	}

	
	

}
