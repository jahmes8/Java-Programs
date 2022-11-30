import java.util.*;

public class JCRPS {
    private static String player;
    private static String[] choices = new String[]{"Rock","Paper","Scissors"}; // Array of the Choices
    private static int playerScore = 0;
    private static int cpuScore = 0;

    public static void main (String[] args) {
        intro introObject = new intro(); // Grabs the Intro Class
        introObject.printIntro(); // printIntro from the Intro Class
        directions();
        game();
    } // End of Main Method

    public static void directions(){ 
        System.out.printf("%nType 'R' for Rock, 'P' for Paper, 'S' for Scissors or 'Q' to Quit the Game:");
        System.out.println();
    } // End of descrption 

    public static void game(){
        Scanner scan = new Scanner(System.in);
        while (true){
            player = scan.nextLine();
            if (player.equalsIgnoreCase("r")){
                rock();
            }
            else if (player.equalsIgnoreCase("p")){
                paper();
            }
            else if (player.equalsIgnoreCase("s")){
                scissors();
            }
            else if (player.equalsIgnoreCase("q")){
                quit();
                break;
            }
            else {
                System.out.println(player + " is not the correct input.");
                directions();
            }
        } // End of while loop
        scan.close(); // Closes the Scanner
    } // End of game

    public static void rock(){ // Outcomes for Rock
        String cpu = choices[new Random().nextInt(choices.length)]; // Randomizes the choices for the computer
        if (cpu == "Rock") {
            System.out.printf("%nDraw!");
            System.out.printf("%nYou Both Picked " + cpu);
        }
        else if (cpu == "Paper") {
            System.out.printf("%nCPU Wins!");
            System.out.printf("%nYou Picked: Rock, CPU Picked: " + cpu);
            cpuScore+=1;
        }
        else if (cpu == "Scissors") {
            System.out.printf("%nYou Win!");
            System.out.printf("%nYou Picked: Rock, CPU Picked: " + cpu);
            playerScore+=1;
        }
        score();
        directions();
    } // End of rock

    public static void paper(){ // Outcomes for Paper
        String cpu = choices[new Random().nextInt(choices.length)];
        if (cpu == "Paper") {
            System.out.printf("%nDraw!");
            System.out.printf("%nYou Both Picked " + cpu);
        }
        else if (cpu == "Scissors") {
            System.out.printf("%nCPU Wins!");
            System.out.printf("%nYou Picked: Paper, CPU Picked: " + cpu);
            cpuScore+=1;
        }
        else if (cpu == "Rock") {
            System.out.printf("%nYou Win!");
            System.out.printf("%nYou Picked: Rock, CPU Picked: " + cpu);
            playerScore+=1;
        }
        score();
        directions();
    } // End of paper 

    public static void scissors(){ // Outcomes for Scissors
        String cpu = choices[new Random().nextInt(choices.length)];
        if (cpu == "Scissors") {
            System.out.printf("%nDraw!");
            System.out.printf("%nYou Both Picked " + cpu);
        }
        else if (cpu == "Rock") {
            System.out.printf("%nCPU Wins!");
            System.out.printf("%nYou Picked: Scissors, CPU Picked: " + cpu);
            cpuScore+=1;
        }
        else if (cpu == "Paper") {
            System.out.printf("%nYou Win!");
            System.out.printf("%nYou Picked: Scissors, CPU Picked: " + cpu);
            playerScore+=1;
        }
        score();
        directions();
    } // End of scissors

    public static void score(){ // Keeps Track of Score
        System.out.printf("%nPlayer Score: " + playerScore + " CPU Score: " + cpuScore);
        System.out.println();
    } // End of score

    public static void quit(){ // When the User Quits
        System.out.printf("%nThanks For Playing!");
        System.out.printf("%nFinal Score: " );
        System.out.printf("%nPlayer: " + playerScore + " CPU: " + cpuScore);
        if (playerScore > cpuScore) {
            System.out.printf("%n%nYou Won Against a Computer! You Saved Humanity! :)");
        }
        else {
            System.out.printf("%n%nYou Lost Against a Computer! Robots are Taking Over! :(");
        }
    } // End of quit
} // End of JCRPS
