import java.util.Random;

public class Deck {

    private Card[] data;
    private int top;

    // This methods creates a deck of cards
    public Deck() {

        String suits = "♥♦♠♣";
        String ranks = "A23456789TJQK";
        data = new Card[52];
        top = 0;

        int count = 0;
        Card C1;
        for (int s = 0; s < suits.length(); s++) {
            for (int r = 0; r < ranks.length(); r++) {
                C1 = new Card(ranks.charAt(r), suits.charAt(s));
                data[count++] = C1;
            }
        }
    }

    // This method displays the deck of cards
    public void display() {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            Card card = data[i];
            if (card.getRank() == 'T'){
                System.out.printf("[10%c] ", card.getSuit());
            } else {
                System.out.printf("[%c%c] ", card.getRank(), card.getSuit());
            }

            count++;
            if (count % 13 == 0) {
                System.out.print("\n");
            }
        }
    }

    // This method shuffles the deck of card
    public void shuffle() {

        Random random = new Random();
        int x, y;
        Card temp;

        for (int k = 0; k < 1000; k++) {
            x = random.nextInt(52);
            y = random.nextInt(52);
            temp = data[x];
            data[x] = data[y];
            data[y] = temp;
        }
    }

    // This method deals the top card from the deck
    public Card deal() {
        if (top == 52) {
            top = 0;
        }
        return data[top++];
    }
}
