import java.util.*;

public class Game {

    static Scanner scan = new Scanner(System.in);
    static String name = "";
    static int numberOfCards = 0;

    static String[] suits = {"♥", "♣", "♦", "♠"};
    static String[] ranks = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};

    static ArrayList<Card> cards = new ArrayList<>();
    static ArrayList<Card> handCards = new ArrayList<>();
    static ArrayList<Card> enemyHandCards = new ArrayList<>();



    public static void Deck() {
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public static void typeWriter(String narration) {
        try {
            for (char letter : narration.toCharArray()) {
                System.out.print(letter);
                Thread.sleep(25);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void cardWar() {
        Deck();
        Collections.shuffle(cards);
        numberOfCards = 5;

        for (int i = 0; i < numberOfCards; i++) {
            handCards.add(cards.remove(0));
        }

        for (int i = 0; i < numberOfCards; i++) {
            enemyHandCards.add(cards.remove(0));
        }



        int points = 0;
        int enemyPoints = 0;


        while (!handCards.isEmpty() && !enemyHandCards.isEmpty()) {

            Collections.shuffle(enemyHandCards);

            try {
                System.out.println("""
                Which one will you choose? Select the number.
                Points: You: %d | Director: %d
                """.formatted(
                        points,
                        enemyPoints

                ));

                System.out.println("\nYour hand:");
                for (int i = 0; i < handCards.size(); i++) {
                    System.out.println(i + 1 + ": " + handCards.get(i));
                }

                int input = scan.nextInt();

                if (input < 1 || input > handCards.size()) {
                    System.out.println("Invalid choice!");
                    continue;
                }
               Card card = handCards.remove(input - 1);
               Card enemyCard = enemyHandCards.remove(0);

               if (card.value < enemyCard.value) {
                   enemyPoints += 1;
                   System.out.println("You lose. Director played: " + enemyCard);
               }
               else if (card.value > enemyCard.value) {
                   points += 1;
                   System.out.println("You win. Director played: " + enemyCard);
               }
               else {
                   points += 0;
                   System.out.println("Tie!");
               }


            } catch (InputMismatchException e) {
                System.err.println("Invalid input");
            }
        }

        if (points < enemyPoints) {
            System.out.println("You lose!");
        }

        else if (points > enemyPoints) {
            System.out.println("You win!");
        }

        else  {
            System.out.println("Tie!");
        }
    }

    public static void Prologue() {
        String Narration = """
                Welcome to this game! This is a visual novel set in the world where
                school status is greatly influenced by your money... and gambling
                ability. (Inspired by the anime Kakegurui). After this message, you will
                proceed directly to the story. There will be a tutorial match so don't worry.
                """;
        typeWriter(Narration);

        String Narration3 = """ 
                Shortly after graduating High School, you decided to enter a well-known school, Seikan Academy. Because of your intelligence,
                you managed to had a scholarship that would grant you access to this very
                expensive school. Although you know that there would be so many rich students here,
                you still decided to go and grab the opportunity.
                
                This is the day appointed by the school board. You're now in your way to the board room of Seikan 
                Academy where the directors will interview you. 
                """;

        typeWriter(Narration3);

        String Narration4 = """ 
        You arrived at the room. YOu noticed three men wearing expensive suit sitting on th sofa.
        They gestured you to sit in front of them.
        """;

        System.out.println("\nDirector: Can you tell us your name?");
        System.out.print("My name is: ");
        name = scan.nextLine();

        String Narration5 = """
                Very well, %s. You managed to pique our curiosity with your intelligence,
                so now you'll be given the privilege to enter our academy...
                
                However...
                
                You have to pass our "simple test".
                
                You thought of what kind of test they are talking about. Of course you thought it would be written,
                but you were surprised when they took out a deck of playing card instead.
                """.formatted(name);

        typeWriter(Narration5);

        String Narration6 = """
                "Prove your worth and use you brain to defeat me in a card war game."
                
                HINT: Card war game is a card game where both sides will draw five
                cards and will draw one and compare it to each other.
                This game will test how you manage your cards. One point will be given
                if you showed a higher card. First to reach three points will win.
                """;

        typeWriter(Narration6);

        String Narration7 = """
                You caught off guard by the sudden weird test, but you have no choice but to comply.
                
                Cards begun shuffling and the director's assistant gave you and the director 5 card each.
                HINT: Defeat him to progress the story.
                """;

        typeWriter(Narration7);

        cardWar();
    }

    public static void main(String[] args) {
        Prologue();
    }
}