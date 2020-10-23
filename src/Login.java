import java.util.Scanner;

public class Login {
    private Gamer gamer;
    private FileWork fileWork;

    public Login(Gamer gamer, FileWork fileWork) {
        this.gamer = gamer;
        this.fileWork = fileWork;
    }

    public void enterName() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Your Name:");
        gamer.setName(sc1.next());
    }

    public void loginGamer() {
        enterName();
        System.out.println("SOUT Gamer History? Y/N:");
        Scanner scan = new Scanner(System.in);
        String answer = scan.next().toUpperCase();
        if (answer.equals("Y")) fileWork.getGamerHistory();
    }
}
