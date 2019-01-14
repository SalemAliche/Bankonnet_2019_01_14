package hello;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;


    @JsonManagedReference
//    @JsonBackReference
    @OneToOne(  fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                mappedBy = "client", optional = false)
    private Compte_Courant compte_courant;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Compte_Courant getCompte_courant() {
        return compte_courant;
    }

    public void setCompte_courant(Compte_Courant compte_courant) {
        this.compte_courant = compte_courant;
    }
}
//    public Client() {
////
////    }
////
////       public Client(String identifiant, String nom, String prenom)
////       {
////
////        this();
////        this.identifiant = identifiant;
////        this.nom = nom;
////        this.prenom = prenom;
////
////     }
////
////    public String toString() {
////        return "Le client : " + this.nom + " " + this.prenom + " a pour numéro " + this.identifiant;
////
////    }
////}