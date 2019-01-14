package hello;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity

public class Compte_Courant {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String decouvert;
    private String intitule;
    private Integer numero;
    private Integer solde;

    @JsonBackReference
//    @JsonManagedReference
//    @JsonIgnoreProperties("compte_courant")
    @OneToOne(  fetch = FetchType.LAZY,
                optional = false)
    @JoinColumn(name="id_client",
                nullable = false)
    private Client client;


    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(String decouvert) {
        this.decouvert = decouvert;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
