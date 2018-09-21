package com.local.ysf.MockitoForControllersTest;

public class Books {

	private String title;
	private String Auteur;
	
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Books(String title, String auteur) {
		super();
		this.title = title;
		Auteur = auteur;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuteur() {
		return Auteur;
	}

	public void setAuteur(String auteur) {
		Auteur = auteur;
	}

	@Override
	public String toString() {
		return "Books [title=" + title + ", Auteur=" + Auteur + "]";
	}
	
	
	
}
