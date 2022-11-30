import java.util.Random; //allows you to generate a random number
import java.util.Scanner; // allows you to use the scanner to read user input

public class Guess {

    private static final int EASY = 2;
    private static final int MEDIUM = 50;
    private static final int HARD = 100;

    public static void main(String[] args) { 
      
      String answer = "";
      String question = "";
      int totalnumTries = 0;
      int numTries = 0;
      int gameCount = 0;
      int totalGuessCount = 0;
      int bestGuess = 10000000;
      int limit = 0;
      boolean firstgame = true; // determines pathway if it is their first game

      guessingGame(answer, question, totalnumTries, numTries, gameCount, totalGuessCount, bestGuess, limit, firstgame);
    } // ends main


      // GUESSING GAME METHOD, based on the user's input either play the game or print results
      public static void guessingGame(String answer, String question, int totalnumTries, int numTries,
      int gameCount, int totalGuessCount, int bestGuess, int limit, boolean firstgame) {
    
      int loop = 0;
      while (loop != 1) {
      
         answer = firstGame(firstgame, question, answer);
      
         if (answer.equalsIgnoreCase("Y")) { // ignores if y (the first character) is uppercase or lowercase
            
            limit = answerYes(limit, firstgame);
            numTries = playGame(limit,0); // returns numTries after the game has been played
         
            if (numTries < bestGuess) { 
               bestGuess = numTries; // changes best guess to number of tries
            }
            else {
            }
            totalnumTries += numTries; // adds the numtries to the total
            gameCount++;
            firstgame = false; // since this would be the first game played.
         } 
         else if (answer.equalsIgnoreCase("N")) {
           loop = answerNo(firstgame, gameCount, totalnumTries, bestGuess, loop);
         }
         else {
         invalid();
         wait(1500); // wait 1.5 seconds
         }
        } // end while loop
       } // ends main



      //FIRST GAME METHOD
      public static String firstGame(Boolean firstgame, String question, String answer) {

         Scanner game = new Scanner(System.in);  

         if (firstgame == true) {
            mainMenu();
            question = game.next();
            answer = question.substring(0,1); // finds the first character
         }
         else {
            question = game.next();
            answer = question.substring(0,1); // finds the first character
         }      
         return answer;
      }

      // ANSWER YES METHOD
      // if their answer starts with "y" print loading screen, instructions, and difficulty screen.
      public static int answerYes(int limit, boolean firstgame) {

         if(firstgame == true) { // if its their first game, print the loading screen.
            loadingScreen();
            wait(2000); // waits 2000 miliseconds or 2 seconds
            limit = difficulty(0);// returns limit
            instructions(limit); // uses the limit returned, in the instructions.
            wait(5000); // waits 5000 miliseconds or 4 seconds
         }
         else {
            limit = difficulty(0);
            instructions(limit);
            wait(5000); // waits 5 seconds before starting the game
         }
         return limit;
         }
      

      // ANSWER NO METHOD
      // If their answer starts with "n" print results or goodbye menu, and ends the loop
      public static int answerNo(boolean firstgame, int gameCount, int totalnumTries, int bestGuess, int loop) {
       
      if (firstgame == false) {  
      average(gameCount, totalnumTries, bestGuess);
      }
      else { 
      goodBye();
      }
      loop++; 
      return loop;
      }
       
      // MAIN MENU METHOD
      public static void mainMenu() {
    
         for (int topDashes = 1; topDashes < 47; topDashes++) {
            System.out.print("~");
         }
            System.out.print("\n|                                            |");
            System.out.print("\n|                                            |");
            System.out.print("\n|               Guessing Game                |");
            System.out.print("\n|                  1 2 3...                  |");
            System.out.print("\n|                                            |");
            System.out.print("\n|                                            |");
            System.out.print("\n|                                            |");
            System.out.print("\n| Enter Yes to Start or No to Close The Game |\n");
         for (int bottomDashes = 1; bottomDashes < 47; bottomDashes++) {
         System.out.print("~");
         }
         System.out.println();
      } // end mainMenu
     
      

      // LOADING SCREEN METHOD
      public static void loadingScreen() {
      
         for (int topDashes = 1; topDashes < 32; topDashes++) {
               System.out.print("~");
         }
               System.out.print("\n|                             |");
               System.out.print("\n|                             |");
               System.out.print("\n|           Loading           |");
               System.out.print("\n|            Game...          |");
               System.out.print("\n|                             |");
               System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
               System.out.print("~");
         }
         System.out.println();
       } // end loadingScreen
        
        
      // DIFFICULTY SCREEN METHOD
      public static void difficultyScreen() {
         
         for (int topDashes = 1; topDashes < 32; topDashes++) {
               System.out.print("~");
         }
               System.out.print("\n|                             |");
               System.out.print("\n|                             |");
               System.out.print("\n| Please Select a Difficulty! |");
               System.out.print("\n|    Easy, Medium or Hard!    |");
               System.out.print("\n|                             |");
               System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
               System.out.print("~");
         }
         System.out.println();
      } // end difficulty screen
      
      
      
      // GOODBYE SCREEN METHOD
      public static void goodBye() {
      
         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
            }
            System.out.print("\n|                             |");
            System.out.print("\n|           Good              |");
            System.out.print("\n|             Bye!            |");
            System.out.print("\n|                             |");
            System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
      } // end goodBye
      
      
      // INVALID SCREEN METHOD
      public static void invalid() {
         
         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
         }
            System.out.print("\n|                             |");
            System.out.print("\n|     Please Enter Either     |");
            System.out.print("\n|          Yes Or No          |");
            System.out.print("\n|             ...             |");
            System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
         System.out.println(); 
      } // ends invalid

      
      // INSTRUCTION METHOD
      public static int instructions(int limit) {
         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
         }
         if (limit > 99) {
          System.out.print("\n|                             |");
            System.out.print("\n|  I Will Think Of A Number   |");
            System.out.print("\n|      Between 1 And " + limit + "         |");
            System.out.print("\n|   Guess The Number To Win!  |");
            System.out.print("\n|            ...              |");
            System.out.print("\n|                             |\n");
         }
         else {
            System.out.print("\n|                             |");
            System.out.print("\n|  I Will Think Of A Number   |");
            System.out.print("\n|      Between 1 And " + limit + "        |");
            System.out.print("\n|            ...              |");
            System.out.print("\n|                             |\n");
         }

         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
         return limit;
         } // ends instruction
    

    // DIFFICULT METHOD
    // determines difficulty based on user's input
    public static int difficulty(int limit) {
      
      Scanner game = new Scanner(System.in); 
      String difficultyAnswer;
      String difficulty;
      int difficultyLoop = 1;

      while (difficultyLoop == 1) {
      
         difficultyScreen();
         difficultyAnswer = game.next();
         difficulty = difficultyAnswer.substring(0,1);
                  
         if (difficulty.equalsIgnoreCase("E")) {
            limit = EASY;
            difficultyLoop++;
         }   
         else if (difficulty.equalsIgnoreCase("M")) {
            limit = MEDIUM;
            difficultyLoop++;
         }    
         else if (difficulty.equalsIgnoreCase("H")) {
            limit = HARD;
            difficultyLoop++;
         }
         else {
         }
    }
    return limit;
    }
    
    // playGame method
    public static int playGame(int limit, int numTries) {
    
      Scanner game = new Scanner(System.in); 
      int random = 0;
      random = numberChosen(limit, random);

      int guess = 0;
      guess = game.nextInt(); // guess is the next integer typed
      
      // initializes 2 values that is 5 more and 5 less than the random generated number
      int closeLower = random - 5; 
      int closeHigher = random + 5;

      while (random != guess) { // while loop if the guess does not equal to the random number
      
         if (guess <= closeHigher && guess >= random) { 
            guess = closeMenuLower(guess);
            numTries++;
         } // ends if
 
         else if (guess > random) { // if the guess is higher than the random generated number
            guess = lowerMenu(guess);
            numTries++;
         }
            
         else if (guess <= random && guess >= closeLower) {
            guess = closeMenuHigher(guess);
            numTries++;
         }
            
         else { //  if the guess is lower than the random generated number
            guess = higherMenu(guess);
            numTries++;
         }
      }
      numTries++;      

         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
         }
               System.out.print("\n|                             |");
               System.out.print("\n|       * You got it! *       |");
               System.out.print("\n|     It Took You " + numTries  + " Tries!    |");
               System.out.print("\n|     Want to play again?     |");
               System.out.print("\n|                             |\n");
               for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
                  System.out.print("~");
               }
      System.out.println();    
      return numTries;
      } // ends playgame method
      
      
      // NUMBER CHOSEN METHOD
      public static int numberChosen(int limit, int random) {

         Random number = new Random();
         int maximum = limit;
         random = number.nextInt(maximum);
         random += 1;

         System.out.println();
         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
         }
            System.out.print("\n|                             |");
            System.out.print("\n|                             |");
            System.out.print("\n|   I Have Chosen A Number!   |");
            System.out.print("\n|          Guess It!          |");
            System.out.print("\n|                             |");
            System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
         System.out.println();
         return random;
      }

      // CLOSE MENU LOWER METHOD
      public static int closeMenuLower(int guess) {

         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
            }
            System.out.print("\n|                             |");
            System.out.print("\n|        You're Close!        |");
            System.out.print("\n|     But It's a bit lower!   |");
            System.out.print("\n|         Guess Again!        |");
            System.out.print("\n|                             |\n");
         for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
         }
         System.out.println();

         Scanner game = new Scanner(System.in); 
         guess = game.nextInt();
         return guess;
      }

      // LOWER MENU METHOD
      public static int lowerMenu(int guess) {

         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
            }
            System.out.print("\n|                             |");
            System.out.print("\n|        It's lower!          |");
            System.out.print("\n|          Guess Again!       |");
            System.out.print("\n|                             |");
            System.out.print("\n|                             |\n");
            for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
            }
            System.out.println();

            Scanner game = new Scanner(System.in); 
            guess = game.nextInt();
            return guess;
      }

      // CLOSE MENU HIGHER METHOD
      public static int closeMenuHigher(int guess) {

         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
            }
            System.out.print("\n|                             |");
            System.out.print("\n|        You're Close!        |");
            System.out.print("\n|      It's A Bit Higher!     |");
            System.out.print("\n|         Guess Again!        |");
            System.out.print("\n|                             |\n");
            for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
            }
         System.out.println();

         Scanner game = new Scanner(System.in); 
         guess = game.nextInt();   
         return guess;
      }

      // HIGHER MENU METHOD
      public static int higherMenu(int guess) {

         for (int topDashes = 1; topDashes < 32; topDashes++) {
            System.out.print("~");
            }
            System.out.print("\n|                             |");
            System.out.print("\n|       It's Higher!          |");
            System.out.print("\n|          Guess Again!       |");
            System.out.print("\n|                             |");
            System.out.print("\n|                             |\n");
            for (int bottomDashes = 1; bottomDashes < 32; bottomDashes++) {
            System.out.print("~");
            }
            System.out.println();

            Scanner game = new Scanner(System.in); 
            guess = game.nextInt();
            return guess;
      }

      // RESULTS METHOD
      // calculates the average, and prints the gameCount, totalnumTries, and bestGuess
      public static int average(double gameCount, double totalnumTries, int bestGuess) {
      
         double average = totalnumTries/gameCount; 
      
         for (int topDashes = 1; topDashes <30; topDashes++) {
         System.out.print("~");
         }
         System.out.print("\n|\t   RESULTS:         |");
         System.out.print("\n|                           |");
      
         // game count
         if (gameCount < 9) {
         System.out.printf("%n| Total Games: %.0f", gameCount);
         System.out.print("            |");
         } 
         else if (gameCount > 99) { // if gameCount is greater than 99 print the following.
         System.out.printf("%n| Total Games: %.0f", gameCount);
         System.out.print("          |");
         } 
         else {
         System.out.printf("%n| Total Games: %.0f", gameCount);
         System.out.print("           |");
         }
      }
      
      public static int totalGusses(double gameCount, double totalnumTries, int bestGuess) {   
         // total guesses
         if (totalnumTries < 9) {
         System.out.printf("%n| Total Guesses: %.0f", totalnumTries);
         System.out.print("          |");
         }
         else if (totalnumTries > 99) {
         System.out.printf("%n| Total Guesses: %.0f", totalnumTries);
         System.out.print("        |");
         }
         else {
         System.out.printf("%n| Total Guesses: %.0f", totalnumTries);
         System.out.print("         |");
         }
      
         // best game
         if (bestGuess < 9) {
         System.out.print("\n| Best Game: " + bestGuess);
         System.out.print("              |");
         }
         else if (bestGuess > 99) {
         System.out.print("\n| Best Game: " + bestGuess);
         System.out.print("            |");
         }
         else {
         System.out.print("\n| Best Game: " + bestGuess);
         System.out.print("             |");
         }
      }

         // average guesses
         public static int averageGusses(double gameCount, double totalnumTries, int bestGuess) {
         if (average < 9) {
         System.out.printf("%n| Average Guesses: %.2f", average);
         System.out.print("     |");
         }
         else if (average > 99) {
         System.out.printf("%n| Average Guesses: %.2f", average);
         System.out.print("   |");
         }
         else {
         System.out.printf("%n| Average Guesses: %.2f", average);
         System.out.print("    |");
         }
      
         // bottom dashes
         System.out.print("\n|                           |\n");
         for (int bottomDashes = 1; bottomDashes <30; bottomDashes++) {
         System.out.print("~");
         }

      return bestGuess;
      }
   
 
      // wait method, interupts and suspends the execution
   public static void wait(int ms) {

      try
      {
        Thread.sleep(ms); 
      }
      catch(InterruptedException ex)
      {
        Thread.currentThread().interrupt();
      }
} // ends wait method
      
      } // ends class
