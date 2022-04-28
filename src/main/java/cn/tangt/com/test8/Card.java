package cn.tangt.com.test8;

/**
 * @author tan
 * @date 2022/04/28 14:08
 */
public class Card {
    int[] deck = new int[52];
    String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public void Initialize() {
        for (int i = 0; i < deck.length; i++)
            deck[i] = i;
    }

    public void Shuffle() {
        for (int i = 0; i < deck.length; i++) {
            int index = (int) (Math.random() * deck.length);
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
    }

    public void Display() {
        for (int i = 0; i < 4; i++) {
            String suit = suits[deck[i] / 13];
            String rank = ranks[deck[i] % 13];
            System.out.println("Card number " + deck[i] + ": "
                    + rank + " of " + suit);
        }
    }

    public static void main(String[] args) {
        Card c = new Card();
        c.Initialize();
        c.Shuffle();
        c.Display();
    }
}
