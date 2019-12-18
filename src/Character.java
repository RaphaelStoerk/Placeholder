public class Character {

  int alter;
  String name;
  String backstory;
  String[] inventar;

  public Character(int alter, String name) {
    this.alter = alter;
    this.name = name;
    inventar = new String[10];

    for(int i = 0; i < inventar.length; i++) {
      inventar[i] = "empty";
    }
  }

  public void pickUp(String item) {
    for(int i = 0; i < inventar.length; i++) {
      if(inventar[i].equals("empty")) {
        inventar[i] = item;
        break;
      }
    }
  }

  public static Character create(Application root) {
    // Character Creation
    root.ui.print("\nFirst let's create your character:");
    String get = root.ui.getAnswer("Do you want to input a name or get a random name?", "1: name", "2: random");
    int nameChoice = Integer.parseInt(get);
    String name = "";
    if(nameChoice == 1) {
      name = root.ui.getAnswer("Please enter your name:");
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

    String ageString = root.ui.getAnswer("How old are you?", "(0 - 999)");
    int age = Integer.parseInt(ageString);

    Character created = new Character(age, name);
    return created;
  }
}
