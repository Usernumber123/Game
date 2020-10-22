import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Gamer gamer = new Gamer();
    private String hiddenWord;

    private void generateRandomWord() {
        try {
            File file = new File("lib.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            ArrayList<String> ar = new ArrayList<String>();
            ar.add(line);
            while (line != null) {
                line = reader.readLine();
                ar.add(line);
            }

            int random_number1 = 0 + (int) (Math.random() * ar.size() - 1);
            this.hiddenWord = ar.get(random_number1).toLowerCase();
            gamer.setWord(hiddenWord);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void gameLogin() {
        gamer.enterName();
        System.out.println("SOUT Gamer History? Y/N:");
        Scanner scan = new Scanner(System.in);
        String answer = scan.next().toUpperCase();
        if (answer.equals("Y")) getGamerHistory();
    }



    private void setWinResult() {
        try {
            FileWriter writer = new FileWriter("history.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(gamer.getName() + "\n" + "hidden Word: " + gamer.getWord() + " " + "Tryes: " + gamer.getTryes() + "\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void setLoseResult() {
        try {
            FileWriter writer = new FileWriter("history.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(gamer.getName() + "\n" + "hidden Word: " + gamer.getWord() + " " + "Lose" + "\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    private void getGamerHistory() {
        try {
            File file = new File("history.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = "";
            boolean check = true;
            while (true) {

                line = reader.readLine();
                if (line == null) break;
                if (line.equals(gamer.getName())) {
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
    public void gameStart() {
        gameLogin();
        generateRandomWord();

        String unhiddenWord = "";
        for (int i = 0; i < hiddenWord.length(); i++) {
            unhiddenWord += '_';
        }

        gamer.setTryes(1);
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Key in one character or your guess word:");
            String wordOrLetter = sc.next().toLowerCase();
            if (wordOrLetter.length() == 1) {
                if (hiddenWord.contains(wordOrLetter)) {
                    String C1 = "";
                    for (int i = 0; i < hiddenWord.length(); i++) {

                        if (hiddenWord.charAt(i) != wordOrLetter.charAt(0)) C1 += unhiddenWord.charAt(i);
                        else C1 += wordOrLetter;
                    }
                    unhiddenWord = C1;
                    if (unhiddenWord.equals(hiddenWord)) {
                        System.out.println("Congratulation!");
                        System.out.println("You got in " + gamer.getTryes() + " " + " trials" + "\n");
                        setWinResult();
                        break;
                    }
                }
                System.out.println("Trial " + gamer.getTryes() + ":" + unhiddenWord);
                gamer.addTryes();
            } else {
                if (hiddenWord.equals(wordOrLetter)) {
                    System.out.println("Congratulation!");
                    System.out.println("You got in " + gamer.getTryes() + " trials");
                    setWinResult();
                } else {
                    System.out.println("Word was :" + hiddenWord);
                    System.out.println("You lose!");
                    setLoseResult();
                }
                break;
            }
        }


    }
}
