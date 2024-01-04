package org.example.salarie;

public class Salaire {

    private long id;
    private double tauxHoraire;

    /**
     * Constante du nombre d'heures payé normalement (sans heures supplémentaires)
     */
    final double HEURES_NORMALES = 151.67;

    /**
     * Fournit le salaire en fonction des heures supplémentaires (> 151.67)
     * @param heure nombre d'heures travaillées (int)
     * @return salaire (double)
     */
    public double payer(double heure){

        //Vérification que l'heure est bien positive
        verifierHeurePositive(heure);

        //Calcule des heures supplémentaires
        double heureSup = heure - HEURES_NORMALES;

        //Retour du salaire calculé en fonction des heures travaillées
        //et de la présence d'heures supplémentaires
        return calculeSalaire(heure, heureSup);
    }

    /**
     * Vérifie si l'heure est bien positive, si non retourne IllegalArgumentException
     * @param heure heures travaillées (int)
     */
    private void verifierHeurePositive(double heure){
        if (heure < 0)
            throw new IllegalArgumentException("ATTENTION : Le nombre d'heure doit être positif !");
    }

    /**
     * Calcule du salaire, en fonction des heures supplémentaires
     *
     * @param heure heures travaillées (int)
     * @param heureSup heures supplémentaires (double)
     * @return salaire (double)
     */
    private double calculeSalaire(double heure, double heureSup) {

        //Si heureSup positif = présence d'heures supplémentaires
        //Calcul du salaire en heures normales < 151.67, + calcul du salaire en heures supplémentaires
        //Et ici on les paye parce qu'on n'est pas des chiens
        if (heureSup > 0.0){
            return (HEURES_NORMALES * tauxHoraire) + (heureSup * (tauxHoraire * 1.25));
        }
        //Si heuresSup négatif = pas d'heures supplémentaires
        else {
            return heure * tauxHoraire;
        }
    }

    public Salaire() {
    }

    public Salaire(long id, double tauxHoraire) {
        this.id = id;
        this.tauxHoraire = tauxHoraire;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    @Override
    public String toString() {
        return "Salaire{" +
                "id=" + id +
                ", tauxHoraire=" + tauxHoraire +
                '}';
    }
}
