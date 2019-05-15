package aed2.trabalho;

public enum CivilStatus {
	
	SINGLE("Single"), 
	MARRIED("Married"), 
	DIVORCED("Divorced"), 
	WIDOW("Widow");
	
	public String status;
	
	CivilStatus(String status) {
		this.status = status;
	}
}