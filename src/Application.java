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

      switch(opt) {
        case 1:
          System.out.println("This is a game");

          // Implement Character Creation

          // ask for name, with the option to chose random name

          System.out.print("Do you want to input a name (1) or get a random name (2)?\n::NUMB::> ");

          int nameChoice = scan.nextInt();
          scan.nextLine();
          String name = "";
          if(nameChoice == 1) {
            System.out.print("Please enter your name:\n::NAME::>");
            name = scan.nextLine();
          } else {
            String vokale = "aeiou";
            String konsonanten = "bpkglmnrts";

            int length = 1 + (int)(Math.random() * 5);
            int vokIndex = (int)(Math.random() * 5);
            if(Math.random() > 0.5) {
              char vokal = vokale.charAt(vokIndex);
              name = name + vokal;
            }
            for(int i = 0; i < length; i++){
              vokIndex = (int)(Math.random() * 5);
              char vokal = vokale.charAt(vokIndex);
              int konIndex = (int)(Math.random() * konsonanten.length());
              char konsonant = konsonanten.charAt(konIndex);
              name = name + konsonant + vokal;
            }
          }

          System.out.println("Your name is " + name);






          // ask for age

          // ask for anything else


          // show saved properties


          /***********************************************/
          /* let user know that the game is now starting *
          /***********************************************/

          // declare variables
          int correct = 0;
          long start = System.currentTimeMillis();

          // loop 10 times
          for(int i = 0; i < 10; i++) {
            int x = (int)(Math.random() * 100);
            int y = (int)(Math.random() * 100);
            int ergebnis = x + y;

            // question to user
            System.out.println("Frage " + i + ": " + x + " + " + y);

            // input from user
            int input = scan.nextInt();

            // check if input is correct
            if(input == ergebnis) {
              System.out.println("CORRECT");
              correct++;
            } else {
              System.out.println("FALSE");
            }
          }

          long end = System.currentTimeMillis();
          long duration = (end - start) / 1000;

          // check if won
          if(duration < 60 && correct >= 7) {
            System.out.println("YOU WON");
          } else {
            System.out.println("YOU LOST");
          }
          break;
        case 2:
          System.out.println("This is loading");
          break;
        case 3:
          System.out.println("This is options");
          break;
        case 4:
          running = false;
          break;
        default:
          System.out.println("THIS IS NOT AN OPTION, YOU FOOL!");
      }
    }
    System.out.println("Goodbye, it seems that this is all for now!");
  }
}
