package resources;

public class Medecin {
	
	private String nomMedecin;
	private Specialite specialite;
	
	public Medecin(String nomMedecin,Specialite specialite) {
		this.nomMedecin = nomMedecin;
		this.specialite = specialite;
	}

	public String getNomMedecin() {
		return nomMedecin;
	}

	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

}
