import java.util.Scanner;

/**
* This is the main class for the project "placeholder"
*
* @author Raphael Stoerk
*/
public class Application {

  static Scanner scan;
  static Character mainCharacter;
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_CYAN = "\u001B[36m";

  /**
  * This is the main method of our class, the application will
  * start here when run in a command line with the command "java Application"
  *
  * @param args input values from the command line
  */
  public static void main(String[] args) {

    // create a new Scanner that lets us read in input from the user
    scan = new Scanner(System.in);
    clear();
    title("PLACEHOLDER");
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
      scan.nextLine(); // flush scan input
      System.out.println("You have entered option: " + opt);

      switch(opt) {
        case 1:
          playGame();
          break;
        case 2:
          loadGame();
          break;
        case 3:
          options();
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


  // the method where the game logic is implemented
  public static void playGame() {

    characterCreation();

    clear();
    title("START GAME");
    pause(2000);
    clear();
    title("PLACEHOLDER");
    pause(2000);
    clear();
    title("AND NOW THE STORY BEGINS...");
    System.out.println();
    pause(2000);

    // Preparing Gameplay Parameters
    // items
    String[] items = new String[]{"Crowbar", "Schere", "Stift", "Fackel", "Buch"};
    // Inventar
    String[] inventory = new String[10];

    for(int i = 0; i < inventory.length; i++) {
      inventory[i] = "empty";
    }

    // the game loop
    while(true) {
      clear();
      title("ITEM FOUND");
      // TODO: design interaction window

      String foundItem = items[(int)(Math.random() * items.length)];
      print(mainCharacter.name + " found " + foundItem);
      pause(1000);
      String q = "Pick up?";
      String yesOption = "y";
      String noOption = "n";
      String answer = getAnswer(q, yesOption, noOption);

      if(answer.equals(yesOption)) {
        for(int i = 0; i < inventory.length; i++) {
          if(inventory[i].equals("empty")) {
            inventory[i] = foundItem;
            break;
          }
        }
        System.out.println(mainCharacter.name + " picked up " + foundItem);
      } else {
        System.out.println("Nothing was picked up");
      }
      pause(1000);
    }

  }

  // prints a given String as a title
  public static void title(String text) {
    int linelength = text.length() + 6;
    for(int i = 0; i < linelength; i++) {
      System.out.print("*");
    }
    System.out.print("\n** " + ANSI_CYAN + text + ANSI_RESET + " **\n");
    for(int i = 0; i < linelength; i++) {
      System.out.print("*");
    }
  }

  // prints a given String as a line narrated by the system
  public static void print(String text) {
    System.out.println("\n::SYST::> " + text);
  }

  // clears the console
  public static void clear() {
    System.out.print("\033[H\033[2J");
  }

  // waits "millisec" ms before continuing to operate
  public static void pause(int millisec) {
    try {
      Thread.sleep(millisec);
    } catch (InterruptedException e) {
      return;
    }
  }

  // asks the user for an answer, can prompt possible options
  public static String getAnswer(String question, String... options) {
    System.out.println("::SYST::> " + question);
    if(options != null && options.length > 0) {
      for(String s : options) {
        System.out.println("\t(" + s + ") ");
      }
    }
    System.out.print("::ANSW::> ");
    String ans = scan.nextLine();
    return ans;
  }

  // shows content of an array maybe with a title for that content
  public static void show(String[] array, String title) {
    if(title != null && title.length() != 0) {
      System.out.println(title + ":");
    }
    System.out.print("[");
    for(String s : array) {
      System.out.print(s + ",");
    }
    System.out.println("]");
  }

  public static void options() {
    System.out.println("This is options");
  }

  public static void loadGame() {
    System.out.println("This is loading");
  }

  public static void characterCreation() {
    // Character Creation
    System.out.println("\nFirst let's create your character:");
    String get = getAnswer("Do you want to input a name or get a random name?", "1: name", "2: random");
    int nameChoice = Integer.parseInt(get);
    String name = "";
    if(nameChoice == 1) {
      System.out.print("Please enter your name:\n::NAME::>");
      name = scan.nextLine();
    } else {
      // prepare variables to generate a random name
      String vokale = "aeiou";
      String konsonanten = "bdfghklmnprstyz";
      int length = 1 + (int)(Math.random() * 5);
      char vokal;
      char konsonant;
      int konIndex;
      int vokIndex;

      // maybe add a vocal to start of name
      if(Math.random() > 0.5) {
        vokIndex = (int)(Math.random() * vokale.length());
        vokal = vokale.charAt(vokIndex);
        name = name + vokal;
      }

      // generate a few syllables
      for(int i = 0; i < length; i++){
        vokIndex = (int)(Math.random() * vokale.length());
        vokal = vokale.charAt(vokIndex);
        konIndex = (int)(Math.random() * konsonanten.length());
        konsonant = konsonanten.charAt(konIndex);
        name = name + konsonant + vokal;
      }
    }

    System.out.println("Your name is " + name + "\n");
    mainCharacter = new Character(20, name);
  }

}
