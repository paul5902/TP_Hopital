package resources.pools;


import java.util.ArrayList;

import resources.Patient;

public class PatientPool {
	
	private ArrayList<Patient> patientPool;
	
	public PatientPool() {
		this.patientPool = new ArrayList<Patient>();
	}
	
	public void addPatient(Patient patient) {
		patientPool.add(patient);
	}
	
	public void removePatient(Patient patient) {
		if(patientPool.contains(patient)) {
			patientPool.remove(patient);
		}
	}
	
	public boolean patientExists(String nomPatient) {
		boolean result = false;
		
		for (Patient p : patientPool) {
			if(nomPatient.equals(p.getNom())) {
				result = true;
			}
		}
		return result;
	}
	
	public Patient getPatient(String nomPatient) {
		for (Patient p : patientPool) {
			if(nomPatient.equals(p.getNom())) {
				return p;
			}
		}
		return null;
	}
	

}
