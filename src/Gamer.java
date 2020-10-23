import java.io.*;
import java.util.Scanner;

public class Gamer {
    private String name;
    private int tryes;
    private String word;

    public void setName(String name) {
        this.name = name;
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
