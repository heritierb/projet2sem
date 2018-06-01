package structure;
// ****                        **** //
// **** AUTEUR BENOIT HERITIER **** //
// ****                        **** //
import java.io.Serializable;
import java.util.UUID;

public class Contact implements Serializable {
    
    // **** COMPOSANTS D'UN CONTACT **** //
    UUID ID;
    String prenom;
    String nom;
    String numero;
    String email;
    String adresse;
    String anniversaire;
    String groupe;
    
    // **** CONSTRUCTEUR **** //
    public Contact(UUID ID, String prenom, String nom, String numero, String email,
            String adresse, String anniversaire, String groupe) {
        this.ID = ID;
        this.prenom = prenom;
        this.nom = nom;
        this.numero = numero;
        this.email = email;
        this.adresse = adresse;
        this.anniversaire = anniversaire;
        this.groupe = groupe;
    }
    // **** GETTERS&SETTERS **** //
    public UUID getID() {
        return ID;
    }
    public void setID(UUID ID) {
        this.ID = ID;
    }
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
}
