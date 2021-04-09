package com.company;

public class Spiller {
    
    public String navn;
    
    private final Integer[] resultatListe = new Integer[15];

    public Spiller(String navn) {
        this.navn = navn;
    }
    
    public void printSpiller() {
        System.out.println("\n-------");
        System.out.println(navn + "`s turn");
        System.out.println("--------");
    }
    
    public Integer[] getResultatListe() {
        return resultatListe;
    }

    public void setResultat(int i, int resultat){
        if (resultatListe[i] == null) {
            resultatListe[i] = resultat;
        } else {
            System.out.println("resultat allerede satt for denne kategorien");
        }
    }

    public int getTotalResultatAvDeFemFørste() {
        int totalResultat = 0;
        for (int i = 0; i < 6; i++) {
            totalResultat += resultatListe[i];
        }
        return totalResultat;
    }

    public int getEkstraPoeng() {
        return getTotalResultatAvDeFemFørste() >= 63 ? 100 : 0;
    }

    public int getResultat() {
        int resultat = 0;
        for (int poeng: resultatListe) {
            resultat += poeng;
        }
        return resultat + getEkstraPoeng();
    }

}