import java.io.*;
import java.util.Base64;
import java.util.Scanner;


public class encoderFile {
    Scanner input = new Scanner(System.in);
    public static String username ;

    void setUserName(String name) {
        encoderFile.username = name;
    }


    public void encoderFileInput() {
        mainFile.cleaner();
        try {
            BufferedWriter Writer = new BufferedWriter(new FileWriter(encoderFile.username+"/encoderFile.txt"));
            System.out.println("\n\t\t\t\t\t\t\t\t\tENTER YOUR TEXT HERE ");

            for (int i = 0; i < 5; i++) {

                System.out.print("\n\t\t\t\t\t\t\t\t\t ---->  ");
                String line= input.nextLine();
                String encodedText = Base64.getEncoder().encodeToString(line.getBytes());
                Writer.write(encodedText);
                Writer.newLine();
            }
            Writer.close();
                
        } catch (IOException e) {
            System.out.println("error occur encoderFile");

        }
        for (int i = 0; i <= 5; i++) {
            mainFile.cleaner();
            String[] star={"*","* *","* * *","* * * *","* * * * *","* * * * * *"};
            System.out.println("\n\n\n\t\t\t\t\t\t\t\t\tWait Encoding Your File "+star[i]);
            mainFile.delayTime(3000);
        }
        System.out.println("\n\n\n\n\t\t\t\t\t\t\t\t\t-----COMPLETED-----\n\n");
        System.out.print("\n\n\n\n\t\t\t\t\t\t\t\t\tDO YOU WANT SEE ENCODED FILE --->");
        String ch = input.nextLine();
        if(ch.equals("yes") || ch.equals("Yes") || ch.equals("YES"))encoderFileReader();
        mainFile.delayTime(4000);
    }


    public void encoderFileReader(){
        try {
            mainFile.cleaner();
            BufferedReader reader = new BufferedReader(new FileReader(encoderFile.username+"/encoderFile.txt"));
            String line;
            System.out.println("\n\t\t\t\t\t\t\t\t\tYour ENCODED TEXT\n\n");
            while((line = reader.readLine())!=null) {
                System.out.println(line);
            }
            reader.close();

        } catch ( IOException e) {
            System.out.println("\n\t\t\t\t\t\t\tCan't Read File ");
        }
        System.out.println("\n\n");
        String ch =input.nextLine();
    }
}

