package Model;

import java.time.LocalDate;

public class Paiment {

    private int idPaiement;
    private TypePaiement typePaiement;
    private double montant;
    private LocalDate date;
    private String motif;
    private Agent agent;


    public Paiment(int idPaiement, String typePaiement, double montant, String motif, Agent agent) {
        this.idPaiement = idPaiement;
        if(typePaiement == null) {
            this.typePaiement = null;
        }else {
            this.typePaiement = TypePaiement.valueOf(typePaiement.toUpperCase());
        }
        this.montant = montant;
        this.date = LocalDate.now();
        this.motif = motif;
        this.agent = agent;
    }

    public Paiment(String typePaiement, double montant, String motif, Agent agent) {
        if(typePaiement == null) {
            this.typePaiement = null;
        }else {
            this.typePaiement = TypePaiement.valueOf(typePaiement.toUpperCase());
        }
        this.montant = montant;
        this.date = LocalDate.now();
        this.motif = motif;
        this.agent = agent;
    }

    public int getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(int idPaiement) {
        this.idPaiement = idPaiement;
    }

    public String getTypePaiement() {
        return typePaiement.toString();
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Agent getAgent() {
        return agent;
    }

    public int getAgentId(){
        return agent.getIdAgent();
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
