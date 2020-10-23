import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Gamer gamer = new Gamer();
    private FileWork fileWork = new FileWork(gamer);
    private Login login = new Login(gamer, fileWork);
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

    public void gameStart() {
        login.loginGamer();
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
                        fileWork.setWinResult();
                        break;
                    }
                }
                System.out.println("Trial " + gamer.getTryes() + ":" + unhiddenWord);
                gamer.addTryes();
            } else {
                if (hiddenWord.equals(wordOrLetter)) {
                    System.out.println("Congratulation!");
                    System.out.println("You got in " + gamer.getTryes() + " trials");
                    fileWork.setWinResult();
                } else {
                    System.out.println("Word was :" + hiddenWord);
                    System.out.println("You lose!");
                    fileWork.setLoseResult();
                }
                break;
            }
        }


    }
}
