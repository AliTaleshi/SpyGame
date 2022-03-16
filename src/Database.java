import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Word> words;
    private List<Player> players;

    public Database() {
        words = new ArrayList<>();
        players = new ArrayList<>();
        generateWords();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void addWord(Word word) {
        this.words.add(word);
    }

    public ArrayList<Player> getPlayers() {
        return (ArrayList<Player>) players;
    }

    public ArrayList<Word> getWords() {
        return (ArrayList<Word>) words;
    }

    public void generateWords() {
        words.add(new Word("کاهو", "سبز"));
        words.add(new Word("فرودگاه", "چمدان"));
        words.add(new Word("سیب زمینی", "خاک"));
        words.add(new Word("پفک", "ذرت"));
        words.add(new Word("پفیلا", "ذرت"));
        words.add(new Word("لپتاپ", "شارژ"));
        words.add(new Word("فلش(USB)", "تکنولوژی"));
        words.add(new Word("قاضی", "دستبند"));
        words.add(new Word("مکانیک", "آچار"));
    }
}
