import java.io.*;
import java.util.Base64;
import java.util.Scanner;

public class decoderFile {
    Scanner input = new Scanner(System.in);
    public static String username;

    void setUserName(String name) {
        decoderFile.username = name;
    }

    public void decoderFileInTXT() {
        try {
            BufferedReader Reader = new BufferedReader(new FileReader("DECODER FOLDER/En.txt"));
            BufferedWriter Writer = new BufferedWriter(new FileWriter("DECODER FOLDER/De.txt"));
            String line;
            while(true){
                if ((line = Reader.readLine()) == null) {break;}
                else {
                    byte[] decodedBytes = Base64.getDecoder().decode(line);
                    String decodedText = new String(decodedBytes);
                    Writer.write(decodedText);
                    Writer.newLine();
                }
            }
            Writer.close();
            Reader.close();
            for (int i = 0; i <= 5; i++) {
                mainFile.cleaner();
                String[] star={"*","* *","* * *","* * * *","* * * * *","* * * * * *"};
                System.out.println("\n\n\n\t\t\t\t\t\t\t\t\tWait DECODING Your File "+star[i]);
                mainFile.delayTime(3000);
            }
            mainFile.cleaner();
            System.out.println("\n\t\t\t\t\t\t\t\t\t ----COMPLETED----");
        }
        catch (FileNotFoundException e) {
            System.out.println("error reading encoder file....");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
    public void decoderFileInline(){
            mainFile.cleaner();
            String ch = "y";
            while(true) {
                mainFile.cleaner();
                if(ch.equals("n") || ch.equals("N")) break;
                System.out.println("\n\t\t\t\t\t\t\t\t\tENTER YOUR TEXT HERE ");
                System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t ---->  ");
                String line = input.nextLine();
                byte[] decodedBytes = Base64.getDecoder().decode(line);
                String decodedText = new String(decodedBytes);
                System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t ----> " + decodedText);
                System.out.print("\n\n\n\t\t\t\t\t\t\t\t\t(Enter n or N to exit)AGAIN???---> ");
                ch=input.nextLine();
            }
    }


}
