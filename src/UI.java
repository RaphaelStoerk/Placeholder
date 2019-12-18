import java.util.Scanner;

public class UI {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_CYAN = "\u001B[36m";
  private Scanner scan;

  // TODO: implement ui functions
  public UI() {
    // create a new Scanner that lets us read in input from the user
    scan = new Scanner(System.in);
  }

  // prints a given String as a title
  public void title(String text) {
    int linelength = text.length() + 6;
    for(int i = 0; i < linelength; i++) {
      System.out.print("*");
    }
    System.out.print("\n** " + ANSI_CYAN + text + ANSI_RESET + " **\n");
    for(int i = 0; i < linelength; i++) {
      System.out.print("*");
    }
    System.out.println();
  }

  // prints a given String as a line narrated by the system
  public void print(String text) {
    System.out.println("\n::SYST::> " + text);
  }

  // clears the console
  public void clear() {
    System.out.print("\033[H\033[2J");
  }

  // waits "millisec" ms before continuing to operate
  public void pause(int millisec) {
    try {
      Thread.sleep(millisec);
    } catch (InterruptedException e) {
      return;
    }
  }

  // asks the user for an answer, can prompt possible options
  public String getAnswer(String question, String... options) {
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
  public void show(String[] array, String title) {
    if(title != null && title.length() != 0) {
      System.out.println(title + ":");
    }
    System.out.print("[");
    for(String s : array) {
      System.out.print(s + ",");
    }
    System.out.println("]");
  }
}
