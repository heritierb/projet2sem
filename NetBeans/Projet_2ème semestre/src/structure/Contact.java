package structure;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //

import java.io.Serializable;
import javax.swing.ImageIcon;

// **** DEFINITION D'UN CONTACT **** //
public class Contact implements Serializable {

    // **** COMPOSANTS D'UN CONTACT **** //
    String prenom;
    String nom;
    String numero;
    String email;
    String adresse;
    String anniversaire;
    String groupe;
    ImageIcon imageContact;

    // **** CONSTRUCTEUR **** //
    public Contact(String prenom, String nom, String numero, String email,
            String adresse, String anniversaire, String groupe, ImageIcon imageContact) {
        this.prenom = prenom;
        this.nom = nom;
        this.numero = numero;
        this.email = email;
        this.adresse = adresse;
        this.anniversaire = anniversaire;
        this.groupe = groupe;
        this.imageContact = imageContact;
    }

    // **** GETTERS&SETTERS **** //
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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

    public String getAnniversaire() {
        return anniversaire;
    }

    public void setAnniversaire(String anniversaire) {
        this.anniversaire = anniversaire;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public ImageIcon getImageContact() {
        return imageContact;
    }

    public void setImageContact(ImageIcon imageContact) {
        this.imageContact = imageContact;
    }

}
