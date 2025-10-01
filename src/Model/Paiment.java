package Model;

import java.time.LocalDate;

public class Paiment {

    private int idPaiement;
    private TypePaiement typePaiement;
    private double montant;
    private LocalDate date;
    private String motif;
    private Agent agent;
    private boolean isValide;


    public Paiment(int idPaiement, String typePaiement, double montant, String motif, Agent agent, boolean isValide) {
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
        this.isValide = isValide;
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
        this.isValide = false;
    }

    public Paiment(){


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

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = TypePaiement.valueOf(typePaiement.toUpperCase());
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

    public boolean isValide() {
        return isValide;
    }

    public void setValide(boolean valide) {
        isValide = valide;
    }



    @Override
    public String toString() {
        return "Paiment{" +
                "idPaiement=" + idPaiement +
                ", typePaiement=" + typePaiement +
                ", montant=" + montant +
                ", date=" + date +
                ", motif='" + motif + '\'' +
                ", agent=" + agent +
                ", isValide=" + isValide +
                '}';
    }
}
