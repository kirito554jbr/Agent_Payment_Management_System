package Model;

import java.util.ArrayList;

public class Departement {



    private int idDepartement;
    private String nom;
    private Agent responsable;
    public ArrayList<Agent> agents;

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
