import java.io.*;

public class FileWork {
    private Gamer gamer;

    public FileWork(Gamer gamer) {
        this.gamer = gamer;
    }

    public void setWinResult() {
        try {
            FileWriter writer = new FileWriter("history.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(gamer.getName() + "\n" + "hidden Word: " + gamer.getWord() + " " + "Tryes: " + gamer.getTryes() + "\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void setLoseResult() {
        try {
            FileWriter writer = new FileWriter("history.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(gamer.getName() + "\n" + "hidden Word: " + gamer.getWord() + " " + "Lose" + "\n");
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
}
