package com.company;

import java.util.Random;

public class Terninger {

        private final int[] terninger = new int[5];
        private static final Random random = new Random();

        public int[] getTerninger() {
            return terninger;
        }

        public void trillAlleTerningene() {
            for (int i = 0; i < terninger.length; i++) {
                terninger[i] = random.nextInt(6) + 1;
            }
        }

        public void trillTerning(int index) {
            terninger[index] = random.nextInt(6) + 1;
        }

        public String toString() {
            StringBuilder output = new StringBuilder("\n Terninger = ");
            for (int terning : terninger) {
                output.append(terning).append(" ");
            }
            return output + "\n";
        }
}
