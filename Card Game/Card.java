// Programmer: James Chen & Nam Le
// Date: 10/09/22
// Class: CS 145
// Lab 4 Deck Of Cards
// Purpose: Create BlackJack
// Extra Credit: Switch/Case, User interface thats crash resistant,
//               Enum, 

public class Card {
    private final String face; // face or card ("Ace","Deuce",...)
    private final String suit; // suit of card ("Hearts", "Diamonds",...)

    // two-argument constructor initializes card's afce and suit
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace; // initializes face of card
        this.suit = cardSuit; // initialize suit of card
    } // end of Card Constructor 

    // return String representation of Card
    public String toString() {
        return face + " of " + suit;
    } // end of toString method

} // End of Card