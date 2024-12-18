import java.util.Scanner;
import java.util.Random;

/**
 * Class that contains action methods, setter/getter methods to return events to the SmashTester Class
 * @author jIngraffia
 * @author dKeane
 */

public class JudoChop {

    // instance variables

    private String name;
    private int health;

    /**
     * sets JudoChop's name to the name of the player
     * Set health to 20
     * @param name name of the Player
     */

    public JudoChop(String name) {
        this.name = name;
        health = 20;
    }

    // getter / setter methods

    /**
     * updates JudoChop's name to the name of the player
     * @param name name of the JudoChop player
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns JudoChop's current health
     * @return health of JudoChop character
     */

    public int getHealth() {
        return health;
    }

    /**
     * updates JudoChop's health
     * @param health health of JudoChop Character
     */

    public void setHealth(int health) {
        this.health = health;
    }

    // character action methods

    /**
     * Simulates a jab attack with a random damage and small chance to miss
     * The damage dealt is a random number between 4 and 2
     * There is a small chance(10%) that this attack will miss
     *
     * @return rand which is the damage dealt by the jab
     */

    public int jab() {
        Random rn = new Random();
        int rand = rn.nextInt(4 - 2 + 1) + 2;
        int chance = rn.nextInt(100) + 1;
        rn = null;
        if (chance > 90) {
            return 0;
        }
        else {
            return rand;
        }
    }

    /**
     * Simulates an uppercut attack with a random damage and with a big chance to miss
     * The damage dealt is a random number between 7 and 5
     * There is an 20% chance that it wil miss
     * @return rand which is the damage dealt by the uppercut
     */

    public int uppercut() {
        Random rn = new Random();
        int rand = rn.nextInt(7 - 5 + 1) + 5;
        int chance = rn.nextInt(100) + 1;
        rn = null;
        if (chance > 80) {
            return 0;
        }
        else {
            return rand;
        }
    }

    /**
     * Determines if an attack is successfully deflected
     * There is a 70% chance that it will be deflected and a 30% chance it won't
     *
     * @return {@code true} if attack is successfully deflected
     *         {@code false} if attack is not deflected
     */

    public boolean deflect() {
        Random rn = new Random();
        int chance = rn.nextInt(100) + 1;
        rn = null;
        if (chance > 70) {
            return false;
        }
        else {
            return true;
        }
    }

    // toString ish method

    /**
     * Prints out information about each Actions of Character
     */

    public static void attackInfo() {
        System.out.println("JAB: ");
        System.out.println("Deals 2-4 damage to opponent");
        System.out.println("Has a 10% chance of dealing no damage");
        System.out.println("-----------------------------------");
        System.out.println("UPPERCUT: ");
        System.out.println("Deals 5-7 damage to opponent");
        System.out.println("Has a 20% chance of dealing no damage");
        System.out.println("-----------------------------------");
        System.out.println("DEFLECT: ");
        System.out.println("Deflects all incoming damage");
        System.out.println("Has a 30% chance of not blocking");
    }
}

