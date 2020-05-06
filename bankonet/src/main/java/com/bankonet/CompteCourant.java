package com.bankonet;

public class CompteCourant {

	private String numero;
	private String intitule;
	private double solde;
	private double montantDecouvertAutorise;
	private static int nbComptesCourants = 0;

	public CompteCourant(String numero, String intitule, double solde, double montantDecouvertAutorise) {
		this.numero = numero;
		this.intitule = intitule;
		this.solde = solde;
		this.numero = numero;
		CompteCourant.nbComptesCourants++;
		System.out.println("Compte créé : " + this.toString());
	}

	public double getSolde() {
		return this.solde;
	}

	public void crediter(double montant) {
		this.solde += montant;
	}

	public void debiter(double montant) {
		this.solde -= montant;
	}

	public static int getNbComptesCourants() {
		return CompteCourant.nbComptesCourants;
	}

	public String toString() {
		return "[" + this.numero + "] " + this.intitule + " : " + this.solde + "€";
	}
}
