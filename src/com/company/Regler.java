package com.company;
import java.util.Arrays;

public class Regler {

    public static int totalSum(int[] terninger, int value) {
        int sum = 0;
        for (int terning : terninger){
            if (terning == value) sum += terning;
        }
        return sum;
    }


    public static int ettPar(int[] terninger) {
        int[] countingSortList = {0,0,0,0,0,0};
        for (int terning : terninger) {
            countingSortList[terning - 1] += 1;
        }
        for (int i = 5; i >= 0; i--){
            if(countingSortList[i] > 1) return i+i+2;
        }
        return 0;
    }

    public static int toPar(int[] terninger) {
        Arrays.sort(terninger);
        int sum = 0;

        for (int i = terninger.length - 1; i > 0; i--) {
            if (fireLike(terninger) == 0) {
                if (terninger[i] == terninger[i - 1]) {
                    sum = terninger[i] + terninger[i - 1];
                    if (i > 2) {
                        for (int j = i - 2; j > 0; j--) {
                            if (terninger[j] == terninger[j - 1]) {
                                return sum + terninger[j] + terninger[j - 1];
                            }
                        }
                    }

                }
            }
        }
        return 0;
    }

    public static int treLike(int[] terninger) {
        int[] countingSortList = {0,0,0,0,0,0};
        for (int terning : terninger) {
            countingSortList[terning - 1] += 1;
        }
        for (int i = 5; i >= 0; i--){
            if(countingSortList[i] > 2) return i*3+3;
        }
        return 0;
    }

    public static int fireLike(int[] terninger) {
        int[] countingSortList = {0,0,0,0,0,0};
        for (int terning : terninger) {
            countingSortList[terning - 1] += 1;
        }
        for (int i = 5; i >= 0; i--){
            if(countingSortList[i] > 3) return i*4+4;
        }
        return 0;
    }

    public static int litenStraight(int[] terninger) {
        Arrays.sort(terninger);
        int[] test = { 1, 2, 3, 4, 5 };
        boolean erLik = true;
        for (int i = 0; i < test.length; i++) {
            if (test[i] != terninger[i]) {
                erLik = false;
                break;
            }
        }

        return erLik ? 20 : 0;
    }

    public static int storStraight(int[] terninger) {
        Arrays.sort(terninger);
        int[] test = { 2, 3, 4, 5, 6 };
        boolean match = true;
        for (int i = 0; i < test.length; i++) {
            if (test[i] != terninger[i]) {
                match = false;
                break;
            }
        }

        return match ? 20 : 0;
    }

    public static int fullHus(int[] terninger) {
        return treLike(terninger) > 0 && ettPar(terninger)> 0 ? treLike(terninger) + ettPar(terninger): 0;
    }

    public static int sjanse(int[] terninger) {
        int sum = 0;
        for (int terning : terninger) {
            sum += terning;
        }
        return sum;
    }

    public static int yatze(int[] terninger) {
        Arrays.sort(terninger);
        return terninger[0] == terninger[4] ? 100 : 0;
    }

    public static String sjanse(Spiller spiller, int[] terninger) {
        StringBuilder tekst = new StringBuilder();

        String[] valg = { "Enere", "Toere", "Treere", "Firere", "Femmere", "Seksere", "Ett par", "To par", "Tre like", "Fire like", "Liten straight", "Stor straight", "Fullt hus", "Sjanse", "Yatzy" };

        int[] poeng = { totalSum(terninger,1), totalSum(terninger, 2),
                totalSum(terninger,3), totalSum(terninger,4),
                totalSum(terninger,5), totalSum(terninger,6),
                ettPar(terninger), toPar(terninger), treLike(terninger),
                fireLike(terninger), litenStraight(terninger), storStraight(terninger),
                fullHus(terninger), sjanse(terninger), yatze(terninger)
        };

        for (int i = 0; i < poeng.length; i++) {
            if (spiller.getResultatListe()[i] == null) {
                tekst.append(i + 1).append("\t legg til ").append(poeng[i]).append(" poeng til ").append(valg[i]).append("\n");
            }
        }
        return tekst.toString();
    }
}