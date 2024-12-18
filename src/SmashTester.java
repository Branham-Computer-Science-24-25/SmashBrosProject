import java.util.Scanner;
import java.util.Random;

/**
* Class that runs the Smash game. This game simulates a battle between two characters, JudoChop and TheMachine.
* Players take turns selecting actions, and the game continues until one or both players' health reaches zero.
* A winner is then declared based on the outcomes of the battle.
*
* @author jIngraffia
* @author dKeane
*/

public class SmashTester {

    /**
    * The main method that runs the game loop, collects user input, displays information, and determines the outcome.
    *
    * @param args Command-line arguments (not used in this program).
    */
    
    public static void main(String[] args) {
        // create new scanner object (in)
        Scanner in = new Scanner(System.in);

        /* Have players (users) enter info
         * Player Name
         */

        // Create local variable for names
        String nameOne = "";
        String nameTwo = "";

        // collect player one name
        // make sure name is valid

        System.out.println("-----------------------------------");
        System.out.print("\033[0;1mPlayer 1 - Enter your name: ");
        while (in.hasNext()) {
            nameOne = in.next();
            break;
        }

        // collect player two name
        // make sure name is valid

        System.out.println("-----------------------------------");
        System.out.print("\033[0;1mPlayer 2 - Enter your name: \033[0;0m");
        while (in.hasNext()) {
            nameTwo = in.next();
            break;
        }

        // assign characters to players
        // display to users their character

        System.out.println();
        JudoChop PlayerOne = new JudoChop(nameTwo);
        System.out.println(nameOne + " is JudoChop");


        TheMachine PlayerTwo = new TheMachine(nameTwo);
        System.out.println(nameTwo + " is TheMachine");
        System.out.println();

        // Display Rules and game loop

        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println("\033[0;1mHOW THE GAME WORKS:\033[0;0m");
        System.out.println("Each player has 20 health");
        System.out.println("Both players will make their actions (1 action per player)");
        System.out.println("Then the actions will execute");
        System.out.println("These steps will then repeat until one player has fallen");
        System.out.println("The other player will be crowned a winner!");
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("\033[0;1mHERE ARE THE ACTIONS EACH CHARACTER CAN TAKE\033[0;0m");
        System.out.println();

        // create loop boolean to determine when to end game

        boolean gameEnd = false;

        // create counters for each player's wins

        int twoCounter = 0;
        int oneCounter = 0;

        // Begin fighting game loop (turn based)

        while (!gameEnd) {

            // List out character actions
            // use void methods from each class to list actions

            System.out.println("\033[0;1mJUDOCHOP\033[0;0m");
            System.out.println("-----------------------------------");
            JudoChop.attackInfo();
            System.out.println("-----------------------------------");
            System.out.println();
            System.out.println("\033[0;1mTHEMACHINE\033[0;0m");
            System.out.println("-----------------------------------");
            TheMachine.attackInfo();
            System.out.println("-----------------------------------");
            System.out.println();

            // Create boolean to determine if player is dead

            boolean playerDead = false;

            // Display starting health

            System.out.println();
            System.out.println("\033[0;1mJUDOCHOP HEALTH: \033[0;0m" + PlayerOne.getHealth());
            System.out.println("\033[0;1mTHEMACHINE HEALTH: \033[0;0m" + PlayerTwo.getHealth());
            System.out.println();

            // start the attack loop.

            while (true) {

                // collect action from player one

                System.out.print(nameOne + " - Enter your action (action name): ");
                String actionOne = "";
                while (true) {
                    actionOne = in.next();
                    if (actionOne.equals("jab") || actionOne.equals("uppercut") || actionOne.equals("deflect")) {
                        break;
                    }
                    else {
                        actionOne = null;
                        System.out.println("Try Again");
                        System.out.print(nameOne + " - Enter your action (action name): ");
                    }
                }

                // collect action from player two

                System.out.print(nameTwo + " - Enter your action (action name): ");
                String actionTwo = "";
                while (true) {
                    actionTwo = in.next();
                    if (actionTwo.equals("smack") || actionTwo.equals("blast") || actionTwo.equals("deflect")) {
                        break;
                    }
                    else {
                        actionTwo = null;
                        System.out.println("Try Again");
                        System.out.print(nameTwo + " - Enter your action (action name): ");
                    }
                }

                System.out.println();

                // check player one action
                // collect number values (damage) or booleans for player one

                int num1 = 0;
                boolean deflectOne = false;

                // jab

                if (actionOne.equals("jab")) {
                    num1 = PlayerOne.jab();
                    if (num1 == 0) {
                        System.out.println("jab missed");
                    } else {
                        System.out.println("jab hit");
                    }
                }

                // uppercut

                else if (actionOne.equals("uppercut")) {
                    num1 = PlayerOne.uppercut();
                    if (num1 == 0) {
                        System.out.println("uppercut missed");
                    } else {
                        System.out.println("uppercut hit");
                    }
                }

                // deflect

                else {
                    deflectOne = PlayerOne.deflect();
                    if (!deflectOne) {
                        System.out.println("deflect missed");
                    }
                    else {
                        System.out.println("DEFLECTED");
                    }
                }

                // check player two action
                // collect number values (damage) or booleans for player two

                int num2 = 0;
                boolean deflectTwo = false;

                // smack

                if (actionTwo.equals("smack")) {
                    num2 = PlayerTwo.smack();
                    if (num2 == 0) {
                        System.out.println("smack missed");
                    }
                    else {
                        System.out.println("smack hit");
                    }
                }

                // blast

                else if (actionTwo.equals("blast")) {
                    num2 = PlayerTwo.blast();
                    if (num2 == 0) {
                        System.out.println("blast missed");
                    }
                    else {
                        System.out.println("blast hit");
                    }
                }

                // deflect

                else {
                    deflectTwo = PlayerTwo.deflect();
                    if (!deflectTwo) {
                        System.out.println("deflect missed");
                    }
                    else {
                        System.out.println("DEFLECTED");
                    }
                }

                System.out.println();

                // execute actions for player one
                // check if player two deflected
                // if so inflict the damage onto player one

                // execute actions for player two
                // check if player one deflected
                // if so inflict the damage onto player two

                if (actionTwo.equals(actionOne)) {
                    System.out.println("Nothing happens :)");
                }

                else if (deflectTwo) {
                    PlayerOne.setHealth(PlayerOne.getHealth() - num1);
                    System.out.println("TheMachine deflected the attack");
                    System.out.println("JudoChop takes " + num1 + " damage");
                }

                else if (deflectOne) {
                    PlayerTwo.setHealth(PlayerTwo.getHealth() - num2);
                    System.out.println("JudoChop deflected the attack");
                    System.out.println("TheMachine takes " + num2 + " damage");
                }

                else {
                    PlayerTwo.setHealth(PlayerTwo.getHealth() - num1);
                    System.out.println("TheMachine takes " + num1 + " damage");
                    PlayerOne.setHealth(PlayerOne.getHealth() - num2);
                    System.out.println("JudoChop takes " + num2 + " damage");
                }

                if (PlayerOne.getHealth() <= 0) {
                    PlayerOne.setHealth(0);
                }


                if (PlayerTwo.getHealth() <= 0) {
                    PlayerTwo.setHealth(0);
                }

                // Display health after attacks

                System.out.println();
                System.out.println("JUDOCHOP HEALTH: " + PlayerOne.getHealth());
                System.out.println("THEMACHINE HEALTH: " + PlayerTwo.getHealth());
                System.out.println();


                if (PlayerOne.getHealth() <= 0 || PlayerTwo.getHealth() <= 0) {
                    playerDead = true;
                }

                // when player dies determine winner
                // in case of tie, both are dead and a random winner is chosen

                if (playerDead) {
                    if (PlayerOne.getHealth() <= 0 && PlayerTwo.getHealth() <= 0) {
                        System.out.println("its a tie!");
                        System.out.println("So we're dead! lets pick a random winner");
                        Random rn = new Random();
                        int rand = rn.nextInt(2);
                        rn = null;
                        if (rand == 0) {
                            System.out.println("TheMachine is the dead champion");
                            twoCounter++;
                        }
                        else {
                            System.out.println("JudoChop is the dead champion");
                            oneCounter++;
                        }
                    }
                    else if (PlayerOne.getHealth() <= 0) {
                        System.out.println("TheMachine is the champion!");
                        twoCounter++;
                    }
                    else {
                        System.out.println("JudoChop is the champion!");
                        oneCounter++;
                    }

                    // display number of wins

                    System.out.println();
                    System.out.println(nameOne + " has " + oneCounter + " wins!");
                    System.out.println(nameTwo + " has " + twoCounter + " wins!");
                    System.out.println();

                    // ask players if they wish to continue

                    System.out.println("Do you wish to play again? (Y/N)");
                    String doYou = in.next();
                    if (doYou.equals("N")) {
                        break;
                    }
                    else {

                        // reset health to 20

                        PlayerOne.setHealth(20);
                        PlayerTwo.setHealth(20);

                        // reset playerDead

                        playerDead = false;

                        // List out character actions
                        // use void methods from each class to list actions

                        System.out.println();
                        System.out.println("-----------------------------------");
                        System.out.println("HERE ARE THE ACTIONS EACH CHARACTER CAN TAKE");
                        System.out.println();
                        System.out.println("JUDOCHOP");
                        System.out.println("-----------------------------------");
                        JudoChop.attackInfo();
                        System.out.println("-----------------------------------");
                        System.out.println();
                        System.out.println("THEMACHINE");
                        System.out.println("-----------------------------------");
                        TheMachine.attackInfo();
                        System.out.println("-----------------------------------");
                        System.out.println();

                        // Display starting health

                        System.out.println();
                        System.out.println("JUDOCHOP HEALTH: " + PlayerOne.getHealth());
                        System.out.println("THEMACHINE HEALTH: " + PlayerTwo.getHealth());
                        System.out.println();
                    }
                }

            }
            break;
        }
    }
}

