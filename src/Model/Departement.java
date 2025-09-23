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
