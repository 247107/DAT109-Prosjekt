package com.company;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    protected static Terninger terninger = new Terninger();

    public static void main(String[] args) {
        Spiller[] spillere = lagSpillere(getAntallSpillere());
        int runde = 1;

        while (runde <= 15) {
            for (Spiller spiller :spillere) {
                spiller.printSpiller();

                terninger.trillAlleTerningene();
                System.out.println(terninger.toString());

                trillPåNytt();

                while (!velgRegel(spiller, terninger.getTerninger()));
            }
            runde++;
        }

        for (Spiller spiller :spillere) {
            System.out.println(spiller.navn + " got " + spiller.getResultat() + " points.");
        }
        Main.scanner.close();
    }

    /**
     * Ask how many Spillere the user want.
     */
    public static int getAntallSpillere() {
        int Spillere;
        while (true) {
            try {
                System.out.println("Hvor mange Spillere?");
                Spillere = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (NumberFormatException ignored) { }
        }
        return Spillere;
    }


    public static Spiller[] lagSpillere(int quantity) {
        Spiller[] Spillere = new Spiller[quantity];

        for (int i = 0; i < Spillere.length; i++) {
            System.out.print("Skriv navn på spiller " + (i + 1) + ": ");
            String spillerNavn = scanner.nextLine().trim();
            Spillere[i] = new Spiller(spillerNavn);
        }
        return Spillere;
    }


    public static void trillPåNytt() {
        int nyeTrillinger = 2;

        while (nyeTrillinger > 0) {
            System.out.print("hva er posisjonen til terningen du vil trille?");
            String trillPåNyttTerningerStr = scanner.nextLine().trim();

            if (trillPåNyttTerningerStr.length() < 1) {
                break;
            }

            String[] trillPåNyttTerninger = trillPåNyttTerningerStr.split(" ");

            for (String trill : trillPåNyttTerninger) {
                try {
                    terninger.trillTerning(Integer.parseInt(trill) - 1);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("posisjonen fantes ikke");
                }
            }

            System.out.println(terninger.toString());
            nyeTrillinger--;
        }
    }

    public static boolean velgRegel(Spiller aspiller, int [] terninger) {
        try {
            System.out.println(Regler.sjanse(aspiller, terninger));
            System.out.println("Velg hvilke regel");
            try {
                int intChoice = Integer.parseInt(scanner.nextLine()) - 1;
                switch (intChoice) {
                    case 0:
                        aspiller.setResultat(intChoice, Regler.totalSum(terninger,1));
                        break;
                    case 1:
                        aspiller.setResultat(intChoice, Regler.totalSum(terninger, 2));
                        break;
                    case 2:
                        aspiller.setResultat(intChoice, Regler.totalSum(terninger,3));
                        break;
                    case 3:
                        aspiller.setResultat(intChoice, Regler.totalSum(terninger,4));
                        break;
                    case 4:
                        aspiller.setResultat(intChoice, Regler.totalSum(terninger,5));
                        break;
                    case 5:
                        aspiller.setResultat(intChoice, Regler.totalSum(terninger,6));
                        break;
                    case 6:
                        aspiller.setResultat(intChoice, Regler.ettPar(terninger));
                        break;
                    case 7:
                        aspiller.setResultat(intChoice, Regler.toPar(terninger));
                        break;
                    case 8:
                        aspiller.setResultat(intChoice, Regler.treLike(terninger));
                        break;
                    case 9:
                        aspiller.setResultat(intChoice, Regler.fireLike(terninger));
                        break;
                    case 10:
                        aspiller.setResultat(intChoice, Regler.litenStraight(terninger));
                        break;
                    case 11:
                        aspiller.setResultat(intChoice, Regler.storStraight(terninger));
                        break;
                    case 12:
                        aspiller.setResultat(intChoice, Regler.fullHus(terninger));
                        break;
                    case 13:
                        aspiller.setResultat(intChoice, Regler.sjanse(terninger));
                        break;
                    case 14:
                        aspiller.setResultat(intChoice, Regler.yatze(terninger));
                        break;
                    default:
                        System.out.println("for høy regel");
                        return false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ugyldig regel.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}