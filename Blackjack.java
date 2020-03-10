import java.util.Scanner;
import java.util.Random;

public class Blackjack {

    public static void displayMenu() {
        System.out.println("1. Get another card ");
        System.out.println("2. Hold hand ");
        System.out.println("3. Print statistics ");
        System.out.println("4. Exit ");
        System.out.println();
        System.out.print("Choose an option: ");
        System.out.println();

    } // card menu
    public static int begin(int myNumber){
        int total = 0;
        if (myNumber == 11) {
            System.out.println("Your card is a JACK!");
            total += 10;
            //System.out.println("Your hand is: " + total);

        }
        else if (myNumber == 12) {
            System.out.println("Your card is a QUEEN!");
            total += 10;
            //System.out.println("Your hand is: " + total);

        }
        else if (myNumber == 13) {
            System.out.println("Your card is a KING!");
            total += 10;
            //System.out.println("Your hand is: " + total);

        }
        else if (myNumber == 1) {
            System.out.println("Your card is a ACE!");
            total = total + myNumber;
           // System.out.println("Your hand is: " + total);
            //Make sure the 1 prints as a ACE

        } else {
            System.out.println("Your card is a " + myNumber + "!");
            total = total + myNumber;
            //System.out.println("Your hand is: " + total);
        }

        return total;
    } // card classification
    //new git hub comment

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        P1Random rng = new P1Random();

        int king = 13;
        int queen = 12;
        int jack = 11;
        int ace = 1;
        int myNumber;
        int dealerHand = 0;
        int total = 0;
        int totalGames = 0;

        ace = 1;
        jack = 10;
        queen = 10;
        king = 10;
        myNumber = 0;
        int game = 1;
        int x = 0;
        int win = 0;
        int lose = 0;
        int tie = 0;


        while (x != 4) {
            System.out.println("START GAME #" + game);
            game++;
            myNumber = rng.nextInt(13) + 1;

            System.out.println();
           total = total + begin(myNumber);
           // rule set for the number names are in function
            System.out.println("Your hand is: " + total);
            System.out.println();

            while ((myNumber <= 21) && (x != 4)) {

                if (total == 21) {
                    System.out.println("BLACKJACK! You win!");
                    System.out.println();
                    total = 0;
                    win++;
                    totalGames++;
                    break;
                }
                if (total > 21) {
                    System.out.println("You exceeded 21! You lose.");
                    System.out.println();
                    total = 0;
                    lose++;
                    totalGames++;
                    break;
                }

                displayMenu();
                //function for display menu


                x = scan.nextInt();

                if (x == 1) {
                    myNumber = rng.nextInt(13) + 1;

                    total = total + begin(myNumber);
                    System.out.println("Your hand is: " + total);
                    System.out.println();
                }

                if (x == 2) {
                    dealerHand = rng.nextInt(11) + 16;
                    if ((dealerHand > total) && (dealerHand <= 21)){
                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + total);
                    System.out.println();
                    System.out.println("Dealer wins!");
                    System.out.println();
                    total = 0;
                    lose++;
                    totalGames++;
                    break;
                    } else if (dealerHand == total){
                        System.out.println("Dealer's hand: " + dealerHand);
                        System.out.println("Your hand is: " + total);
                        System.out.println();
                        System.out.println("It's a tie! No one wins!");
                        System.out.println();
                        tie++;
                        total =0;
                        totalGames++;
                        break;
                        // add dealer hand to each if branch
                        // when dealers hand is larger than yours than they win
                    } else {
                        System.out.println("Dealer's hand: " + dealerHand);
                        System.out.println("Your hand is: " + total);
                        System.out.println();
                        System.out.println("You win!");
                        System.out.println();
                        total = 0;
                        win++;
                        totalGames++;
                        break;
                        //when your and is larger than the dealers hand then you win
                    }
                }
                if (x == 3) {
                    System.out.println("Number of Player wins: " + win);
                    System.out.println("Number of Dealer wins: " + lose);
                    System.out.println(("Number of tie games: ") + tie);
                    System.out.println("Total # of games played is: " + totalGames);
                    System.out.println("Percentage of Player wins: " + (((double)win *10) / totalGames) *10 +"%");
                    System.out.println();// use game variable for percentage of player wins

                }
                if (x ==4){
                    System.exit(x);
                }
                if ((x <= 0)||(x > 4)){
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                    System.out.println();
                } // use or not and for condition

            }



        }
    }

}







