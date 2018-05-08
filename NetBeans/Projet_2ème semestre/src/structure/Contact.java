package structure;

import java.io.Serializable;

public class Contact extends AppContact implements Serializable{

	String nom;
	String prenom;
	int numero;
	String email;
	String adresse;
	int anniversaire;
	String groupe;
	
	public Contact(String nom, String prenom, int numero, String email,
			String adresse, int anniversaire, String groupe) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.email = email;
		this.adresse = adresse;
		this.anniversaire = anniversaire;
		this.groupe = groupe;
		
	}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getAnniversaire() {
        return anniversaire;
    }

    public void setAnniversaire(int anniversaire) {
        this.anniversaire = anniversaire;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
	
}
