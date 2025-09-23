package Model;

import java.time.LocalDate;

public class Paiment {

    private int idPaiement;
    private TypePaiement type;
    private double montant;
    private LocalDate date;
    private String motif;
    private Agent agent;
}
