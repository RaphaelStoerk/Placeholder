import java.util.Scanner;

/**
* This is the main class for the project "placeholder"
*
* @author Raphael Stoerk, while also representing all members of the wednesday
* tut, 16-18
*/
public class Application {

  /**
  * This is the main method of our class, the application will
  * start here when run in a command line with the command "java Application"
  *
  * @param args input values from the command line
  */
  public static void main(String[] args) {
    // create a new Scanner that lets us read in input from the user
    Scanner scan = new Scanner(System.in);

    // ask the user to input his/her name
    System.out.print("Welcome to <placeholder>\nPlease enter your name\n> ");

    // read in the name of the user
    String name = scan.nextLine();

    // greet the user
    System.out.println("Hello " + name + ", have fun playing this game!");

    // say goodbye to the user
    System.out.println("Goodbye " + name + ", it seems that this is all for now!");
  }
}
