package resources;

public class Patient {
	
	private String nom;
	private String adresse;
	private int age;
	private int numeroSecu;
	private FicheSejour ficheSejour;
	private FicheSuivi ficheSuivi;
	
	public Patient(String nom, String adresse, int age, int numeroSecu) {
		
		this.nom = nom;
		this.adresse = adresse;
		this.age = age;
		this.numeroSecu = numeroSecu;
		this.ficheSejour = null;
		this.ficheSuivi = null;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumeroSecu() {
		return numeroSecu;
	}

	public void setNumeroSecu(int numeroSecu) {
		this.numeroSecu = numeroSecu;
	}

	public FicheSejour getFicheSejour() {
		return ficheSejour;
	}

	public void setFicheSejour(FicheSejour ficheSejour) {
		this.ficheSejour = ficheSejour;
	}
	
	public void setFicheSuivi(FicheSuivi ficheSuivi) {
		this.ficheSuivi = ficheSuivi;
	}

	public FicheSuivi getFicheSuivi() {
		return ficheSuivi;
	}
	


}
