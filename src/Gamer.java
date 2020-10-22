import java.io.*;
import java.util.Scanner;

public class Gamer {
    private String name;
    private int tryes;
    private String word;

    public void enterName() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Your Name:");
        this.name = sc1.next();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setTryes(int tryes) {
        this.tryes = tryes;
    }

    public int getTryes() {
        return this.tryes;
    }

    public String getName() {
        return this.name;
    }

    public void addTryes() {
        this.tryes += 1;
    }

}
