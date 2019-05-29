package aed2.model.enumeration;

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