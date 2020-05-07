package com.bankonet;

public class CompteCourant {

	private String numero;
	private String intitule;
	private double solde;
	private double montantDecouvertAutorise;
	private static int nbComptesCourants = 0;

	public CompteCourant() {
		CompteCourant.nbComptesCourants++;
	}

	public CompteCourant(String numero, String intitule, double solde, double montantDecouvertAutorise) {
		this();
		this.numero = numero;
		this.intitule = intitule;
		this.solde = solde;
		this.numero = numero;
		System.out.println("Compte créé : " + this.toString());
	}

	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double montant) {
		if (montant < this.montantDecouvertAutorise) {
			throw new ArithmeticException("Le solde ne peut être inférieur au découvert max. autorisé.");
		} else {
			this.solde = montant;
		}
	}

	public void crediter(double montant) {
		if (montant < 0) {
			throw new ArithmeticException("Le montant doit être positif.");
		} else {
			this.solde += montant;
		}
	}

	public void debiter(double montant) {
		if (montant < 0) {
			throw new ArithmeticException("Le montant doit être positif.");
		} else {
			double newSolde = this.solde - montant;
			if (newSolde < this.montantDecouvertAutorise) {
				throw new ArithmeticException("Ce compte ne peut être débité davantage.");
			} else {
				this.solde -= montant;
			}
		}
	}

	public static int getNbComptesCourants() {
		return CompteCourant.nbComptesCourants;
	}

	public String toString() {
		return "[" + this.numero + "] " + this.intitule + " : " + this.solde + "€";
	}
}
