public class Game {

  Application root;
  UI ui;
  Character main;
  String[] items = new String[]{"Crowbar", "Schere", "Stift", "Fackel", "Buch"};

  public Game(Application root, Character main) {
    this.root = root;
    this.ui = root.ui;
    this.main = main;
  }

  public void run() {
    startSequence();

    // the game loop
    while(true) {

    }

  }

  private void startSequence() {
    ui.clear();
    ui.title("START GAME");
    ui.pause(2000);
    ui.clear();
    ui.title("PLACEHOLDER");
    ui.pause(2000);
    ui.clear();
    ui.title("AND NOW THE STORY BEGINS...");
    ui.pause(2000);
  }

  private void itemFound() {
    ui.clear();
    ui.title("ITEM FOUND");
    // TODO: design interaction window

    String foundItem = items[(int)(Math.random() * items.length)];
    ui.print(main.name + " found " + foundItem);
    ui.pause(1000);
    String q = "Pick up?";
    String yesOption = "y";
    String noOption = "n";
    String answer = ui.getAnswer(q, yesOption, noOption);
    if(answer.equals(yesOption)) {
      main.pickUp(foundItem);
      System.out.println(main.name + " picked up " + foundItem);
    } else {
      System.out.println("Nothing was picked up");
    }
    ui.pause(1000);
  }
}
