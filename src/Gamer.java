import java.io.*;
import java.util.Scanner;

public class Gamer {
    private String name;
    private int tryes;
    private String word;

    public void EnterName() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Your Name:");
        this.name = sc1.next();
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

    public void setWinResult() {
        try {
            FileWriter writer = new FileWriter("history.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(name + "\n" + "hidden Word: " + word + " " + "Tryes: " + getTryes() + "\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void setLoseResult() {
        try {
            FileWriter writer = new FileWriter("history.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(name + "\n" + "hidden Word: " + word + " " + "Lose" + "\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void getGamerHistory() {
        try {
            File file = new File("history.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = "";
            boolean check = true;
            while (true) {

                line = reader.readLine();
                if (line == null) break;
                if (line.equals(getName())) {
                    line = reader.readLine();
                    System.out.println(line);
                    check = false;
                }


            }
            if (check) System.out.println("This gamer have not history уet");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
