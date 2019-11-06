public class Example {

  // Start Algorithmus
  public static void main(String[] args) {

    // gegeben: p, c, s als positive Ganzzahlen
    int points = 10;
    int coins = 15;
    int stars = 8;

    // addiere p / 10 zu c hinzu
    coins = coins + points / 10;

    // solange c > 1
    while(coins > 1) {

      // falls c gerade
      if(coins % 2 == 0) {

        // addiere 1 zu s hinzu
        stars = stars + 1;
        // halbiere c
        coins = coins / 2;
      // ansonsten
      } else {
        // beende wiederholung
        break;
      } // end if

    } // end loop

    // falls s > 10
    if(stars > 10) {

      // Spieler hat gewonnen
      System.out.println("the player has won");

    // Ansonsten
    } else {

      // Spieler hat verloren
      System.out.println("the player has lost");

    }
  }
  // Ende Algorithmus
}
