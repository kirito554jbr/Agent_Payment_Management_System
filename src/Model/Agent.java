package Model;

import java.util.ArrayList;

public class Agent extends Personne {
    private int idAgent;
    private TypeAgent typeAgent;
    private Departement departement;
    private ArrayList<Paiment> paiments;



    public Agent(String typeAgent, Departement departement, String nom, String prenom, String email, String motDePasse) {
        super(nom,prenom,email,motDePasse);
        if(typeAgent == null) {
            this.typeAgent = null;
        }else {
            this.typeAgent = TypeAgent.valueOf(typeAgent.toUpperCase());
        }
        this.departement = departement;
    }

     public Agent(int idAgent,String typeAgent, Departement departement, String nom, String prenom, String email, String motDePasse) {
        super(nom,prenom,email,motDePasse);
        this.idAgent = idAgent;
//        this.typeAgent = typeAgent;
        this.typeAgent = TypeAgent.valueOf(typeAgent.toUpperCase());
        this.departement = departement;
    }


    public Agent(){}



    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public String getTypeAgent() {
        return typeAgent.toString();
    }

    public void setTypeAgent(String typeAgent) {
        this.typeAgent = TypeAgent.valueOf(typeAgent.toUpperCase());
    }

    public Departement getDepartement() {
        return departement;
    }

    public int getDepartementId(){
        return departement.getIdDepartement();
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "idAgent=" + idAgent +
                ", typeAgent=" + typeAgent +
                ", departement=" + departement +
                ", paiments=" + paiments +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}
