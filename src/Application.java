/**
* This is the main class for the project "placeholder"
*
* @author Raphael Stoerk
*/
public class Application {

  UI ui;

  /**
  * This is the main method of our class, the application will
  * start here when run in a command line with the command "java Application"
  *
  * @param args input values from the command line
  */
  public static void main(String[] args) {
    Application app = new Application();
    app.start();
  }

  public Application() {
    ui = new UI();
  }

  public void start() {
    ui.clear();
    ui.title("PLACEHOLDER");
    boolean running = true;
    // The menu loop
    while(running) {
      running = menu(running);
    }
    System.out.println("Goodbye, it seems that this is all for now!");
  }

  public boolean menu(boolean running) {
    String menu = ui.getAnswer("You have the following options:", "(1) Start Game", "(2) Load Game", "(3) Options", "(4) Exit");
    int opt = Integer.parseInt(menu);
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
        ui.print("THIS IS NOT AN OPTION, YOU FOOL!");
    }
    return running;
  }

  // the method where the game logic is implemented
  public void playGame() {
    Character main = Character.create(this);
    ui.print("Game will start soon...");
    ui.pause(1000);
    Game game = new Game(this, main);
    game.run();
  }

  public void options() {
    System.out.println("This is options");
  }

  public static void loadGame() {
    System.out.println("This is loading");
  }
}
