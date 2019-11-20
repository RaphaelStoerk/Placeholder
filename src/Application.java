import java.util.Scanner;

/**
* This is the main class for the project "placeholder"
*
* @author Raphael Stoerk
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
    System.out.print("Welcome to <placeholder>\nPlease enter your name\n\t::NAME::> ");
    String name = scan.nextLine();
    System.out.println("Hello " + name + ", have fun playing this game!");

    boolean running = true;

    // The menu loop
    while(running) {
      System.out.println("\nYou have the following options:");
      System.out.println("\t(1) Start Game");
      System.out.println("\t(2) Load Game");
      System.out.println("\t(3) Options");
      System.out.println("\t(4) Exit");
      System.out.print("\n::MENU::> ");
      int opt = scan.nextInt();
      System.out.println("You have entered option: " + opt);

      // TODO: consider using a switch statement
      if(opt == 1) {
        // TODO: implement minigame
        System.out.println("This is a game");



      } else if(opt == 2) {
        System.out.println("This is loading");
      } else if(opt == 3) {
        System.out.println("This is options");
      } else if(opt == 4) {
        running = false;
      } else {
        System.out.println("THIS IS NOT AN OPTION, YOU FOOL!");
      }
    }

    System.out.println("Goodbye " + name + ", it seems that this is all for now!");
  }
}
