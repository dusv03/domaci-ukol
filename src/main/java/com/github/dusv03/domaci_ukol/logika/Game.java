package com.github.dusv03.domaci_ukol.logika;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.dusv03.domaci_ukol.logika.Word;

public class Game {
	private boolean konecHry = false;
	private List<Word> Words;
	private String hadane;
	private int dobre = 0;
	private int spatne = 0;


	public Game() {
		Words = new ArrayList<Word>();
		Word deer = new Word("deer", "jelen", "/com/github/dusv03/domaci_ukol/ui/jelen.png");
		Words.add(deer);
		Word wolf = new Word("wolf", "vlk", "/com/github/dusv03/domaci_ukol/ui/vlk.png");
		Words.add(wolf);
		Word tiger = new Word("tiger", "tygr", "/com/github/dusv03/domaci_ukol/ui/tygr.png");
		Words.add(tiger);
		Word bear = new Word("bear", "medvěd", "/com/github/dusv03/domaci_ukol/ui/medvěd.png");
		Words.add(bear);
		Word giraffe = new Word("giraffe", "žirafa", "/com/github/dusv03/domaci_ukol/ui/žirafa.png");
		Words.add(giraffe);
		Word crocodile = new Word("crocodile", "krokodýl", "/com/github/dusv03/domaci_ukol/ui/krokodýl.png");
		Words.add(crocodile);
		
	}
	
	public List<Word> getSlovicka(){
		return Words;
	}
	
    public boolean konecHry() {
        return konecHry;
    }
    
    public void vyberSlovo() {
    	Random nahodneSlovo = new Random();
    	hadane = Words.get(nahodneSlovo.nextInt(Words.size())).getEN();
    }
    public String getHadane() {
    	return hadane;
    }
    
    public int getDobre(){
    	return dobre;
    }
    public int getSpatne() {
    	return spatne;
    	
    }
    public boolean overit(String slovo) {
    	if (slovo.equals(hadane)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public void setSkore(String slovo) {
    	if (overit(slovo))  {
    		dobre = dobre + 1;
    	}
    	else
    	{
    		spatne = spatne + 1;
    	}
    }
}
