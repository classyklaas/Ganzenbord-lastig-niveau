package GanzenbordPackage;

import java.util.Random;

public class SpelersToevoegen {

    private String naamVanSpeler;
    private int positieVanSpeler;
    public boolean spelerInHerberg;
    private boolean spelerInPut;
    private boolean spelerInGevangenis;

    public SpelersToevoegen(String naamVanSpeler, int positieVanSpeler, boolean spelerInHerberg, boolean spelerInPut, boolean spelerInGevangenis) {
        this.naamVanSpeler = naamVanSpeler;
        this.positieVanSpeler = positieVanSpeler;
        this.spelerInHerberg = spelerInHerberg;
        this.spelerInPut = spelerInPut;
        this.spelerInGevangenis = spelerInGevangenis;
    }
    public String getNaamVanSpeler() {
        return naamVanSpeler;
    }
    public int getPositieVanSpeler() {
        return positieVanSpeler;
    }
    public int updatePositieVanSpeler() {

        Random dobbelsteen = new Random();
        int nummer = 1 + dobbelsteen.nextInt(6);
        positieVanSpeler = nummer + positieVanSpeler;

        if (positieVanSpeler == 6) {
            positieVanSpeler = 12;
            System.out.println("Het leven lacht je toe! Je staat op de brug en mag daarom verder naar vakje 12.");
        }
        if (positieVanSpeler == 25 || positieVanSpeler == 45) {
            System.out.println("Let wel: bij 25 en 45 moet je terug naar het startpunt. Je begint dus nu vanaf het begin.");
            positieVanSpeler = positieVanSpeler - positieVanSpeler;
        }
        if (positieVanSpeler % 10 == 0 && positieVanSpeler != 0) {
            positieVanSpeler = positieVanSpeler + nummer;
            System.out.println("Dat is een tiental. Je loopt nu het geworpen aantal nogmaals. Je staat nu dus op vakje nummer " + positieVanSpeler + ".");
        }
        if (positieVanSpeler == 42) {
            positieVanSpeler = 39;
            System.out.println(this.naamVanSpeler + ", hoe leuk is dit?! Je bevindt je in het doolhof! Dit betekent echter wel dat je 3 plaatsen terug moet. Je staat op nu vakje 39.");
        }
        if (positieVanSpeler == 58) {
            positieVanSpeler = positieVanSpeler - positieVanSpeler;
            System.out.println("Je staat op vakje 58. Dit betekent helaas dat je opnieuw moet beginnen.");
        }
        if (positieVanSpeler > 63) {
            positieVanSpeler = 63 - (positieVanSpeler - 63);
            System.out.println("Echter: je mag niet hoger dan 63 gooien. Je moet nu het aantal teveel geworpen ogen terug vanaf vakje 63. Je staat nu dus op vakje " + positieVanSpeler + ".");
        }
        else {
            System.out.println("Je hebt " + nummer + " gegooid. Je staat nu dus op vakje " + positieVanSpeler + ".");
        }
        return positieVanSpeler;
    }
    public boolean getZitDeSpelerInDeHerberg(){
        return spelerInHerberg;
    }
    public boolean haalUitDeHerberg(){
        spelerInHerberg = false;
        return false;
    }
    public boolean gooiDeSpelerInDeHerberg(){
        spelerInHerberg = true;
        return true;
    }
    public boolean getZitDeSpelerInDePut(){
        return spelerInPut;
    }

    public boolean haalDeSpelerUitDePut() {
        spelerInPut = false;
        return false;
    }
    public boolean gooiDeSpelerInDePut(){
        spelerInPut = true;
        return true;
    }
    public boolean getZitDeSpelerInDeGevangenis(){
        return spelerInGevangenis;
    }
    public boolean haalDeSpelerUitDeGevangenis() {
        spelerInGevangenis = false;
        return false;
    }
    public boolean gooiDeSpelerInDeGevangenis(){
        spelerInGevangenis = true;
        return true;
    }

}


