package org.example.salarie;

public abstract class Salarie {

    //Nombre d'heures de travail par défaut (sans heures supplémentaires)
    final static double HEURE_NORMALES = 151.67;

    private Salaire salaire;
    private Identite identite;

    /**
     * Permet d'actualiser l'adresse du salarié par une nouvelle
     * @param adresse nouvelle adresse
     */
    public void demenager(Adresse adresse){

        try {
            if (adresse.getId() != 0) {
                identite.getAdresse().setId(adresse.getId());
            }
            if (adresse.getCp() != 0) {
                identite.getAdresse().setCp(adresse.getCp());
            }
            if (adresse.getPays() != null) {
                identite.getAdresse().setPays(adresse.getPays());
            }
            if (adresse.getRue() != null) {
                identite.getAdresse().setRue(adresse.getRue());
            }
            if (adresse.getVoie() != null) {
                identite.getAdresse().setVoie(adresse.getVoie());
            }
            if (adresse.getVille() != null) {
                identite.getAdresse().setVille(adresse.getVille());
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Il ne doit pas y avoir de 0 ou de null dans l'adresse !", e);
        }
    }

    /**
     * Permet de faire travailler le salarié pour un nombre d'heures par défaut
     * Appelle la méthode payer de la classe Salaire, avec comme paramètre le nombre d'heures par défaut
     */
    public void travailler(){
        double salaireCalcule = salaire.payer(HEURE_NORMALES);
        System.out.println("Le salarié " + identite.getPrenom() + " " + identite.getNom() + " a travaillé " + HEURE_NORMALES + " heures et a perçu " + salaireCalcule + " euros");
    }

    /**
     * Permet de faire travailler le salarié pour un nombre d'heure définit par l'utilisateur
     * Appelle la méthode payer de la classe Salaire, avec comme paramètre le nombre d'heures définit par l'utilisateur
     * @param heure nombre d'heures travaillées
     */
    public void travailler(double heure){
        double salaireCalcule = salaire.payer(heure);
        System.out.println("Le salarié " + identite.getPrenom() + " " + identite.getNom() + " a travaillé " + HEURE_NORMALES + " heures et a perçu " + salaireCalcule + " euros");
    }

    /**
     * Permet d'augmenter le salaire du salarié, en indiquant le pourcentage
     * @param pourcentage pourcentage en décimale
     */
    public void augmenter(int pourcentage){
        salaire.setTauxHoraire(salaire.getTauxHoraire() * (1 + pourcentage));
    }

    public Salarie(Salaire salaire, Identite identite) {
        this.salaire = salaire;
        this.identite = identite;
    }

    public Salaire getSalaire() {
        return salaire;
    }

    public void setSalaire(Salaire salaire) {
        this.salaire = salaire;
    }

    public Identite getIdentite() {
        return identite;
    }

    public void setIdentite(Identite identite) {
        this.identite = identite;
    }

    @Override
    public String toString() {
        return "Salarie{" +
                "salaire=" + salaire +
                ", identite=" + identite +
                '}';
    }
}
