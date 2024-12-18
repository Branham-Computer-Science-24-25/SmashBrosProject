import java.util.Random;

/**
 * Class that contains action methods, setter/getter methods to return events to the SmashTester Class
 * @author jIngraffia
 * @author dKeane
 */

public class TheMachine {

    //Instance variables

    private String name;
    private int health;

    /**
     * sets machine's name to the name of the player
     * Set health to 20
     * @param name name of the Player
     */

    public TheMachine(String name){
        this.name = name;
        health = 20;
    }

    // getter / setter methods

    /**
     * updates machine's name to the name of the player
     * @param name name of TheMachine Player
     */

    public void setName(String name){
        this.name = name;
    }

    /**
     * returns machine's current health
     * @return health of TheMachine Character
     */

    public int getHealth(){
        return health;
    }

    /**
     * updates machine's health
     * @param health health of TheMachine
     */

    public void setHealth(int health){
        this.health = health;
    }

    // character action methods

    /**
     * Simulates an attack called Smack with a random damage and a chance to miss
     * Damage is between 2 and 3
     * Chance to miss is 5%
     * @return rand which is the Damage dealt by The Smack attack
     */

    public int smack() {
        Random rn = new Random();
        int rand = rn.nextInt(3 - 2 + 1) + 2;
        int chance = rn.nextInt(100) + 1;
        rn = null;
        if (chance > 95) {
            return 0;
        }
        else {
            return rand;
        }
    }

    /**
     * Simulates an attack called Blast with a random damage and a chance that it misses
     * damage is between 9 or 10
     * Chance to miss is 80%
     * @return rand which is the damage dealt by the Blast attack
     */

    public int blast() {
        Random rn = new Random();
        int rand = rn.nextInt(10 - 9 + 1) + 9;
        int chance = rn.nextInt(100) + 1;
        rn = null;
        if (chance > 40) {
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
     * Prints out the information about each attack that the Character has
     */

    public static void attackInfo() {
        System.out.println("SMACK: ");
        System.out.println("Deals 2-3 damage to opponent");
        System.out.println("Has a 5% chance of dealing no damage");
        System.out.println("-----------------------------------");
        System.out.println("BLAST: ");
        System.out.println("Deals 9-10 damage to opponent");
        System.out.println("Has a 60% chance of dealing no damage");
        System.out.println("-----------------------------------");
        System.out.println("DEFLECT: ");
        System.out.println("Deflects all incoming damage");
        System.out.println("Has a 30% chance of not blocking");
    }
}

