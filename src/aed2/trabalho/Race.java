package aed2.trabalho;

public enum Race {
	
	BLACK("Black"), 
	WHITE("White"), 
	ASIAN("Asian"), 
	NATIVE("Native"), 
	BROWN("Brown");
	
	public String race;
	
	Race(String race) {
		this.race = race;
	}
}