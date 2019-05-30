package aed2.model;

import aed2.model.enumeration.*;

/**
 * Define uma pessoa.
 */
public class Person {
	/**
	 * Identificador de pessoa.
	 */
	private long id; 
	/**
	 * Nome de pessoa.
	 */
	private String name; 
	/**
	 * Sexo de pessoa.
	 */
	private Sex sex;
	/**
	 * Idade de pessoa.
	 */
	private int age;
	/**
	 * Área (Rural ou Urbana) de pessoa.
	 */
	private Area area; 
	/**
	 * Estado civil de pessoa.
	 */
	private CivilStatus civilStatus;
	/**
	 * Etnia de pessoa.
	 */
	private Race race;
	
	public Person(long id, String name, String sex, int age, String area, String civilStatus, String race) {
		this.id = id;
		this.name = name;
		this.sex = new Sex(sex);
		this.area = new Area(area);
		this.civilStatus = new CivilStatus(civilStatus);
		this.race = new Race(race);
	}

	public long id() {
		return id; 
	} 

	public String name() {
		return name; 
	} 

	public Sex sex() {
		return sex;
	}

	public int age() {
		return age;
	}

	public Area area() {
		return area; 
	} 

	public CivilStatus civilStatus() {
		return civilStatus;
	}

	public Race race() {
		return race;
	}

	/**
	 * Formata "Person" para salvar no arquivo.
	 */
	public String toData() {
		return id + ";" + name + ";" + sex + ";" + age + ";" + civilStatus + ";" + race;
	}

	/**
	 * Formata "Person" para impressão.
	 */
	public String toString() {
		return "ID: " + id + ", NAME: " + name + ", SEX: " + sex + ", AGE: " + age + ", CIVIL STATUS: " + civilStatus + ", RACE: " + race;
	}
}
