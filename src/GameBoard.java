import java.util.Scanner;

public class GameBoard {

    public static void givePlayerRole(Database database, int numberOfSpies) {
        int randomNumber = 0;
        for (int i = 0; i < numberOfSpies; i++) {
            randomNumber = (int) (Math.random() * (database.getPlayers().size() - 1 + 1) + 1);
            database.getPlayers().get(randomNumber).setRole(Role.SPY);
        }
    }

    public static void showRole(Role role) {
        if (role.equals(Role.CITY)) {
            System.out.println("شهروند");
        } else {
            System.out.println("جاسوس");
        }
    }

    public static void showWordOrGuideWord(Player player) {

        System.out.println(player.getName());

        if (player.getRole().equals(Role.SPY)) {
            System.out.println(" راهنما: " + player.getWord().getGuide());
        } else {
            System.out.println(" کلمه اصلی: " + player.getWord().getWord());
        }
     }

     public static void multipleNextLines() {
        for (int i = 0; i < 30; i++) {
            System.out.println("\n");
        }
     }

     public static void generateRandomWord(Database database) {
        int randomNumber = (int) (Math.random() * (database.getWords().size() - 1 + 1) + 1);
        setWordsToPlayers(database, database.getWords().get(randomNumber));
     }

     public static void setWordsToPlayers(Database database, Word word) {
        for (int i = 0; i < database.getPlayers().size(); i++) {
            database.getPlayers().get(i).setWord(word);
        }
     }

    public static void main(String[] args) {

        System.out.println("Enter the number of players:");
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = scanner.nextInt();
        System.out.println("Enter the number of spies:");
        int numberOfSpies = scanner.nextInt();

        scanner.skip("\n");

        Database database = new Database();

        for (int i = 0; i < numberOfPlayers; i++) {

            System.out.println("Enter the name of the player " + (i+1));
            Player player = new Player();
            player.setName(scanner.nextLine());
            player.setRole(Role.CITY);
            database.addPlayer(player);
        }

        givePlayerRole(database, numberOfSpies);
        generateRandomWord(database);

        for (int i = 0; i < numberOfPlayers; i++) {
            showRole(database.getPlayers().get(i).getRole());
            showWordOrGuideWord(database.getPlayers().get(i));
            multipleNextLines();
        }


    }
}
