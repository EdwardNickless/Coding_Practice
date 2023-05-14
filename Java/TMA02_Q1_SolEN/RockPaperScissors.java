import java.util.Random;

/**
 * Question 1(a)
 * 
 * Plays the game "Rock, Paper, Scissors".
 * The user plays against the computer.
 * The winner is the first player to reach 3 rounds won.
 * If the user and computer choose the same word, the round is a draw.
 * Otherwise, Rock beats Scissors, Scissors beats Paper, Paper beats Rock.
 *
 * @author Edward Nickless
 * @version 1 March 2022
 */

public class RockPaperScissors
{
    //Question 1(b)
    private InputReader reader;

    private int yourScore,
    computerScore;

    private Random ran;

    /**
     * Question 1(c)
     * 
     * Constructor for objects of class RockPaperScissors.
     */
    public RockPaperScissors()
    {
        reader = new InputReader();
        yourScore = 0;
        computerScore = 0;
        ran = new Random(1);
    }

    /**
     * Question 1(d)
     * 
     * Prints two blank lines followed by
     * the prompt for the user to make their choice.
     */
    public void printPrompt()
    {
        System.out.println();
        System.out.println();
        System.out.print("Enter your choice, paper, rock or scissors > ");
    }

    /**
     * Question 1(e)
     * 
     * Return the user's input for a round of the game, in lower case,
     * with leading and trailing white space trimmed.
     * 
     * @return The user's input.
     */
    public String userChoice()
    {
        String input = reader.getInput();
        return input.toLowerCase().trim();
    }

    /**
     * Question 1(f)
     * 
     * Generates a random number between 0 and 2 (inclusive) and determines
     * which choice the computer will make from this number.
     * 0 represents "rock", 1 represents "paper", 2 represents "scissors".
     * 
     * @return The computers choice for a round.
     */
    public String computerChoice()
    {
        String computersChoice;

        //Generates the random number between 0 and 2 (inclusive)
        int choice = ran.nextInt(3);

        //Determines the value of computersChoice based on the random number
        switch(choice) {
            case 0:
                computersChoice = "rock";
                break;
            case 1:
                computersChoice = "paper";
                break;
            case 2:
                computersChoice = "scissors";
                break;
            default:
                computersChoice = "";
                break;
        }

        return computersChoice;
    }

    /**
     * Question 1(g)
     * 
     * Return the winner of the round and increment the winners score by 1.
     * If the round is a draw then this method returns "draw" and
     * neither score is incremented.
     * If the user inputs an invalid string the computer wins.
     * 
     * @param yourChoice The user's choice for this round
     * @param computerChoice The computer's choice for this round
     * @return The winner of the round or a "draw" result
     */
    public String findWinner(String yourChoice, String computerChoice)
    {
        if(yourChoice.equals(computerChoice)) {
            return "draw";
        }
        else {
            if(yourChoice.equals("rock") && computerChoice.equals("scissors")) {
                yourScore++;
                return "you";
            }
            if(yourChoice.equals("paper") && computerChoice.equals("rock")) {
                yourScore++;
                return "you";
            }
            if(yourChoice.equals("scissors") && computerChoice.equals("paper")) {
                yourScore++;
                return "you";
            }

            //Only reachable if the round is not a draw and
            //the user either entered an invalid string or lost the round.
            computerScore++;
            return "computer";
        }
    }

    /**
     * Question 1(h)
     * 
     * Plays one round of "Rock, Paper, Scissors".
     * This method uses the findWinner method of
     * this class to find the winner, prints the
     * result of this round and then prints the
     * current scores of each player.
     */
    public void playRound()
    {
        //Declare and initialise the local variables
        String yourChoice;
        String computerChoice;

        printPrompt();

        //Get the users choice and store it in yourChoice
        yourChoice = userChoice();
        //Generate the computers choice and store it in computerChoice
        computerChoice = computerChoice();

        System.out.println();
        System.out.println("You have chosen " + yourChoice
            + " and the computer has chosen "
            + computerChoice);

        String result = findWinner(yourChoice, computerChoice);

        switch(result) {
            case "draw":
                System.out.println("This game is a draw");
                break;
            case "you":
                System.out.println("You are the winner");
                break;
            case "computer":
                System.out.println("The computer is the winner");
                break;
        }
        System.out.println("You have " + yourScore
            + " and the computer has "
            + computerScore);
    }

    /**
     * Question 1(i)
     * 
     * Plays a game of "Rock, Paper, Scissors" until
     * either the user reaches a score of 3 or the computer
     * reaches a score of 3. Prints the overall winner of the game.
     */
    public void playGame()
    {
        while((yourScore < 3) && (computerScore < 3))  {
            playRound();
        }
        if(yourScore == 3) {
            System.out.println("The overall winner is you");
        }
        else {
            System.out.println("The overall winner is the computer");
        }
    }
}