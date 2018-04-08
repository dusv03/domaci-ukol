package com.github.dusv03.domaci_ukol.logika;

public class Word {
	private String wordCZ;
	private String wordEN;
	private String URL;
	
	public Word(String EN, String CZ, String URL) {
		this.wordCZ = CZ;
		this.wordEN = EN;
		this.URL = URL;
	}
	
	public String getCZ() {
		return this.wordCZ;
	}
	
	public String getEN() {
		return this.wordEN;
	}
	
	public String getURL() {
		return this.URL;
	}
}
