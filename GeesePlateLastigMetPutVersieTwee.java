package GanzenbordPackage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class GeesePlateLastigMetPutVersieTwee {

    public static void main(String[] args) {
        AtomicInteger winnerGeesePlate = new AtomicInteger();
        var ref1 = new Object() {
            int indexGevangenis = 0;
        };
        var ref2 = new Object() {
            int indexPut = 0;
        };
        var ref3 = new Object() {
            int indexHerberg = 0;
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hoi! Jullie gaan Ganzenbord spelen! Geef alsjeblieft aan met hoeveel personen jullie het spel willen spelen. ");
        int hoeveelheidPersonen = Integer.valueOf(scanner.nextLine());
        ArrayList<GanzenbordPackage.SpelersToevoegen> namen = new ArrayList<>();

        System.out.println("Vul nu alsjeblieft jullie " + hoeveelheidPersonen + " voornamen in. Druk op Enter na elke naam. ");

        while (namen.size() < hoeveelheidPersonen) {
            String naamVanSpeler = scanner.nextLine();
            namen.add(new GanzenbordPackage.SpelersToevoegen(naamVanSpeler, 0, false, false, false));
        }

        System.out.println("Jullie hebben een perfecte dag uitgekozen op Ganzenbord te spelen!");

        while (winnerGeesePlate.get() == 0) {
            namen.forEach(SpelersToevoegen -> {

                if (SpelersToevoegen.getZitDeSpelerInDePut() == true && ref2.indexPut == 2) {
                    SpelersToevoegen.haalDeSpelerUitDePut();
                    ref2.indexPut--;
                }
                if (SpelersToevoegen.getZitDeSpelerInDeHerberg() == false && SpelersToevoegen.getZitDeSpelerInDePut() == false && SpelersToevoegen.getZitDeSpelerInDeGevangenis() == false) {

                    System.out.println("");
                    System.out.println(SpelersToevoegen.getNaamVanSpeler() + ", jij bent aan de beurt. Druk op g om de dobbelsteen te gooien.");
                    char gIngedrukt = scanner.next().charAt(0);
                    if (gIngedrukt == 'g') {
                        SpelersToevoegen.updatePositieVanSpeler();
                    }
                    if (SpelersToevoegen.getPositieVanSpeler() == 19) {
                        SpelersToevoegen.gooiDeSpelerInDeHerberg();
                        System.out.println("Het is er lekker warm, maar helaas bevind je je nu in de herberg. Je moet nu 1 beurt overslaan");
                    }
                    if (SpelersToevoegen.getPositieVanSpeler() == 31) {
                        SpelersToevoegen.gooiDeSpelerInDePut();
                        ref2.indexPut++;
                        System.out.println("Helaas pindakaas, je bevindt je nu in de put. Je moet nu wachten totdat er een andere speler komt.");
                    }
                    if (SpelersToevoegen.getPositieVanSpeler() == 52) {
                        SpelersToevoegen.gooiDeSpelerInDeGevangenis();
                        System.out.println("Je bevindt je nu in de gevangenis. Je moet nu 3 beurten overslaan.");
                    }
                }
                if (SpelersToevoegen.getZitDeSpelerInDeGevangenis() == true){
                    ref1.indexGevangenis++;
                }
                if (ref1.indexGevangenis == 3) {
                    SpelersToevoegen.haalDeSpelerUitDeGevangenis();
                }
                if (SpelersToevoegen.getPositieVanSpeler() == 63) {
                    winnerGeesePlate.getAndIncrement();
                    System.out.println(SpelersToevoegen.getNaamVanSpeler() + ", je hebt gewonnen! Het spel is nu voorbij.");}

                if (SpelersToevoegen.getZitDeSpelerInDeHerberg() == true){
                    ref3.indexHerberg++;
                }
                if (ref3.indexHerberg == 2) {
                    SpelersToevoegen.haalUitDeHerberg();
                }
            });
        } scanner.close();
    }
}