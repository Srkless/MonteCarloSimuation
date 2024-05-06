package Main;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static double monteCarlo(long value, boolean option) {
        int count = 0;

        if (option) {
            for (int i = 0; i < value; i++) {
                double u1 = Math.pow(new Random().nextDouble(), 2);
                double u2 = Math.pow(new Random().nextDouble(), 2);
                double result = Math.sqrt(u1 + u2);
                if (result <= 1) {
                    count++;
                }
            }
            return 4.0 * count / value;
        } else {
            final double pi = Math.PI;
            double calculatedPi = 0;
            double p = 0;
            while (true) {
                double u1 = Math.pow(new Random().nextDouble(), 2);
                double u2 = Math.pow(new Random().nextDouble(), 2);
                double result = Math.sqrt(u1 + u2);
                p++;

                if (result <= 1) {
                    count++;
                }

                calculatedPi = 4.0 * count / p;

                if ((calculatedPi + "").split("\\.")[1].length() < (int) value)
                    continue;
                String calculatedDecimalsPi = (calculatedPi + "").split("\\.")[1].substring(0, (int) value);
                String realDecimalsPi = (pi + "").split("\\.")[1].substring(0, (int) value);

                if (calculatedDecimalsPi.equals(realDecimalsPi))
                    break;
            }
            return calculatedPi;
        }
    }

    public static void main(String[] agrs) {
        System.out.println("1) Unesite broj slucajno generisanih vrijednosti");
        System.out.println("2) Unesite broj decimala koje treba da se poklope sa pravom vrijednoscu");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.print("Unesite broj slucajno generisanih vrijednosti: ");
                long points = scanner.nextInt();
                System.out.println("Izracunata vrijednost PI je: " + monteCarlo(points, true));
                break;
            case 2:
                System.out.print("Unesite broj decimala koje treba da se poklope sa pravom vrijednoscu: ");
                int decimals = scanner.nextInt();
                System.out.println("Izracunata vrijednost PI je: " + monteCarlo(decimals, false));
                break;
        }
        System.out.println("Prava vrijednost PI je: " + Math.PI);

        scanner.close();
    }
}
