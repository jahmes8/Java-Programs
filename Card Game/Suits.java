
// Programmer: James Chen & Nam Le
// Date: 10/09/22
// Class: CS 145
// Lab 4 Deck Of Cards
// Purpose: Create BlackJack
// Extra Credit: Switch/Case, User interface thats crash resistant,
//               Enum, 


public enum Suits {
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    SPADES("Spades");

    final String string;

    //changes the value of string by using the
    // constant's parameter
    Suits(String face) {
    this.string = face;
    }
} // end enum Suits
