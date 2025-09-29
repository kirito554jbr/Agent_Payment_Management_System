package Model;

import java.util.*;

public class Departement {

    private int idDepartement;
    private String nom;
    private Agent responsable;
    public List<Agent> agents;

    public Departement(int idDepartement, String nom) {
        this.idDepartement = idDepartement;
        this.nom = nom;
//        this.responsable = null;
    }

    public Departement(){
        this.idDepartement = 0;
        this.nom = null;
    }

    public Departement(String nom){
        this.nom = nom;
    }

    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Agent getResponsable() {
        return responsable;
    }

    public void setResponsable(Agent responsable) {
        this.responsable = responsable;
    }

    public void setAgents(Agent agent) {
        if (this.agents == null) {
            this.agents = new ArrayList<>();
        }
        this.agents.add(agent);
    }

    @Override
    public String toString() {
        return "Departement{" +
                "idDepartement=" + idDepartement +
                ", nom='" + nom + '\'' +
                ", responsable=" + responsable +
                ", agents=" + agents +
                '}';
    }
}
