import java.io.IOException;
import java.util.Scanner;


public class mainFile {
    static Scanner input = new Scanner(System.in);

    public static void delayTime(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException exception) {
            System.out.println("errors ");
        }
    }



    public static void cleaner(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("error occur");
        }
    }

    public void listIn() {

        System.out.println("\n\t\t\t\t\t\t--------------------------------------");
        System.out.println("\t\t\t\t\t\t| 1. SING-IN");
        System.out.println("\t\t\t\t\t\t| 2. LOG-IN");
        System.out.println("\t\t\t\t\t\t| 3. EXIT");
        System.out.println("\t\t\t\t\t\t--------------------------------------");
        System.out.print("\n\t\tENTER HERE\t\t-->\t");

        caller(input.nextByte());
    }

    public void caller(byte ch){
        singIn sing = new singIn();
        logIn log = new logIn();

        if (ch==1){sing.forUserNewName();}
        else if (ch==2){log.userLogin();}
        else if (ch==3){System.exit(0);}
        else{listIn();}

    }

    public static void main(String[] args) {
        mainFile obj = new mainFile();
        obj.listIn();
        System.exit(0);
    }

}
