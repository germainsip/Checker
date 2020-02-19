package com.afpa.checker;

import android.icu.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;

public class Prenom {
    private String prenom;
    private String prenomNorm;
    private int nombre;

    public int getNombre() {
        return nombre;
    }

    public Prenom() {

    }

    public Prenom(String prenom) {
        this.prenom = prenom;
        normalise();
        calculNombre();

    }

    public void calculNombre() {
        for (int i = 0; i < prenomNorm.length(); i++) {
            if (Constantes.alphabet.indexOf(prenomNorm.charAt(i)) >= 0)
                nombre += (Constantes.alphabet.indexOf(prenomNorm.charAt(i)) + 1);
        }

        while (nombre > 9) {
            nombre = nombre / 10 + nombre % 10;
        }

    }

    public void normalise() {
        this.prenomNorm = prenom.toLowerCase();
        this.prenomNorm = StringUtils.stripAccents(this.prenomNorm);


    }

    public Double checkMatch(Prenom prenom) {
        //Mesure l'écart entre deux valeurs le renvoie sous forme de pourcentage
        Double match = ((9.0d - Math.abs(this.nombre - prenom.getNombre())) / 9d) * 100d;
        DecimalFormat format = new DecimalFormat("#.00");

        return match;
    }
}
