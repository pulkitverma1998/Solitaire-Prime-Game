public class Card {

    private char suit;
    private char rank;

    // This method creates a card with rank and suit
    public Card(char r, char s) {
        rank = r;
        suit = s;
    }

    // This method displays the card on the screen
    public void display() {
        if (rank == 'T') {
            System.out.printf("[10%c]", suit);
        } else {
            System.out.printf("[%c%c]", rank, suit);
        }

    }

    // This method returns the integer value of the card
//    public int getValue() {
//        if (rank == 'A') {
//            return 1;
//        } else if (rank == 'T' || rank == 'J' || rank == 'Q' || rank == 'K') {
//            return 10;
//        } else {
//            return Character.getNumericValue(rank);
//        }
//    }

    public int getValue() {
        int current_value = 0;

        char[] ranks = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
        int[] values = {1,2,3,4,5,6,7,8,9,10,10,10,10};

        for (int i = 0; i < 13; i++) {
            if (rank == ranks[i]) {
                current_value = values[i];
            }
        }

        return current_value;
    }

    // This method returns the rank of the card
    public char getRank() {
        return rank;
    }

    // This method returns the suit of the card
    public char getSuit() {
        return suit;
    }
}
