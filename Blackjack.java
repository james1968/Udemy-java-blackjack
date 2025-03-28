import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // Game intro
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        // Wait for the user to press enter.
        scan.nextLine();
        
        // Get two random cards.
        System.out.println("You get\n");
        int yourNumber1 = drawRandomCard();
        String yourCard1 = cardNumber(yourNumber1);
        int yourNumber2 = drawRandomCard();
        String yourCard2 = cardNumber(yourNumber2);

        System.out.println(yourCard1 + " " + yourCard2);
        if (yourNumber1 > 10) {
            yourNumber1 = 10;
        }
        if (yourNumber2 > 10) {
            yourNumber2 = 10;
        }

        int totalDealtCards = yourNumber1 + yourNumber2;

        //Prints the sum of your hand value.
        System.out.println("Your cards total " +  totalDealtCards);

        
        //Get two random cards for the dealer.
        System.out.println("Dealer gets\n");
        int dealerNumber1 = drawRandomCard();
        String dealerCard1 = cardNumber(dealerNumber1);
        int dealerNumber2 = drawRandomCard();
        String dealerCard2 = cardNumber(dealerNumber2);
        
        System.out.println(dealerCard1 + " " + faceDown());
        if (dealerNumber1 > 10) {
            dealerNumber1 = 10;
        }
        if (dealerNumber2 > 10) {
            dealerNumber2 = 10;
        }

        int totalDealerDealtCards = dealerNumber1 + dealerNumber2;
        System.out.println("Total dealer cards " + totalDealerDealtCards);

        // Keep asking the player to hit or stay (while loop)

        boolean hitOrStay = true;
        int totalCards = 0;
        int totalHitCards = 0;
        while(hitOrStay) {
            int newNumber = 0;
            
            if (hitOrStick()) {
                newNumber = drawRandomCard();
                String newCard = cardNumber(newNumber);
                System.out.println(newCard);
                if (newNumber > 10) {
                    newNumber = 10;
                }
                totalHitCards = totalHitCards + newNumber;
            } else {
                hitOrStay = false;
            }   
            totalCards = totalHitCards + totalDealtCards;
            System.out.println("Player cards " + totalCards);
            if (totalCards > 21) {
                System.out.println("You bust.  End of game");
                hitOrStay = false;
                System.exit(0);
            }
        }

        //  Dealers turn.  Sticks at 17 or more.  Hits at under 17.

        System.out.println("Dealers turn, press enter");
        scan.nextLine();
        int totalDealerCards = 0;
        if (totalDealerDealtCards >= 17) {
            System.out.println("Dealer sticks");
            totalDealerCards = totalDealerDealtCards;
        } else {
            boolean dealerHit = true;
            int totalDealerHitCards = 0;
            while(dealerHit) {
                int newDealerNumber = 0;
                newDealerNumber = drawRandomCard();
                String newDealerCard = cardNumber(newDealerNumber);
                System.out.println(newDealerCard);
                if (newDealerNumber > 10) {
                    newDealerNumber = 10;
                }
                totalDealerHitCards = totalDealerHitCards + newDealerNumber;
                totalDealerCards = totalDealerDealtCards + totalDealerHitCards;
                if (totalDealerCards > 21) {
                    System.out.println("Dealers bust, you win");
                    dealerHit = false;
                    System.exit(0);
                }
                if (totalDealerCards >= 17) {
                    System.out.println("Dealers sticks");
                    dealerHit = false;
                }
            }
        }
        // Total for end of game

        System.out.println("Your cards total: " + totalCards);
        System.out.println("Dealer cards total: " + totalDealerCards);

        // Result

        if(totalCards > totalDealerCards) {
            System.out.println("You win");
        } else {
            System.out.println("You lose");
        }

        scan.close();

    }

    // Function hit or stick

    public static boolean hitOrStick() {
        System.out.println("Hit or stick");
        String response = scan.nextLine();
        if (response.equals("hit")) {
            return true;
        } else {
            return false;
        }
    }

    // Function that returns a random number between 1 and 13
    
    public static int drawRandomCard() {
        int randNum =  (int) (Math.random() * 13) + 1;
        return randNum;
    }

    // Function that returns a String drawing of the card.

    public static String cardNumber(int num) {
        String card = "";
        switch (num) {  
            case 1:
                card =  ("   _____\n"+
                        "  |A _  |\n"+ 
                        "  | ( ) |\n"+
                        "  |(_'_)|\n"+
                        "  |  |  |\n"+
                        "  |____V|\n");
                return card;
            case 2:
                card =  ("   _____\n"+              
                        "  |2    |\n"+ 
                        "  |  o  |\n"+
                        "  |     |\n"+
                        "  |  o  |\n"+
                        "  |____Z|\n");
                return card;

            case 3:
                card =  ("   _____\n" +
                        "  |3    |\n"+
                        "  | o o |\n"+
                        "  |     |\n"+
                        "  |  o  |\n"+
                        "  |____E|\n");
                return card;

            case 4:
                card =  ("   _____\n" +
                        "  |4    |\n"+
                        "  | o o |\n"+
                        "  |     |\n"+
                        "  | o o |\n"+
                        "  |____h|\n");
                return card;

            case 5:
                card =  ("   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n");
                return card;
            
            case 6:
                card =  ("   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n");
                return card;
            
            case 7:
                card =  ("   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n");
                return card;

            case 8:
                card =  ("   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n");
                return card;

            case 9:
                card = ("   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n");
                return card;

            case 10:
                card =  ("   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n");
                return card;

            case 11:
                card =  ("   _____\n" +
                        "  |J  ww|\n"+ 
                        "  | o {)|\n"+ 
                        "  |o o% |\n"+ 
                        "  | | % |\n"+ 
                        "  |__%%[|\n");
                return card;

            case 12:
                card =  ("   _____\n" +
                        "  |Q  ww|\n"+ 
                        "  | o {(|\n"+ 
                        "  |o o%%|\n"+ 
                        "  | |%%%|\n"+ 
                        "  |_%%%O|\n");
                return card;
            
            case 13:
                card =  ("   _____\n" +
                        "  |K  WW|\n"+ 
                        "  | o {)|\n"+ 
                        "  |o o%%|\n"+ 
                        "  | |%%%|\n"+ 
                        "  |_%%%>|\n");      
                return card;      

            default:
                String err = "This won't happen";
                return err;
        }
    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    }

