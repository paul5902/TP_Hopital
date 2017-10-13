package resources;

import java.util.Date;

public class CompteRendu {
	
	private String dateConsultation;
	private String contenu;
	private String nomSpecialiste;
	
	public CompteRendu(String dateConsultation, String contenu, String nomSpecialiste) {
		this.dateConsultation = dateConsultation;
		this.contenu = contenu;
		this.nomSpecialiste = nomSpecialiste;
	}

	public String getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(String dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getNomSpecialiste() {
		return nomSpecialiste;
	}

	public void setNomSpecialiste(String nomSpecialiste) {
		this.nomSpecialiste = nomSpecialiste;
	}
	
	public void displayInfo() {
		System.out.println("Date consultation :" +dateConsultation+"\n Spécialiste concerné : "+nomSpecialiste+"\n Contenu du CR : "+contenu);
	}

}
