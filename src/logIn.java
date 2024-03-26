import java.io.*;
import java.util.Scanner;

public class logIn {
    Scanner input = new Scanner(System.in);

    public void userLogin(){
        encoderFile obj= new encoderFile();
        decoderFile obj1 = new decoderFile();
        mainFile.cleaner();
        System.out.println("\n\t\t\t\t\t\t****************************************");
        System.out.println("\n\n\t\t\t\t\t\t\t\tLOG-IN PAGE");
        System.out.print("\n\t\t\t\t\t\tENTER YOUR USER NAME HERE ---->  ");
        String userName = input.next();
        obj.setUserName(userName);
        obj1.setUserName(userName);

        // Create a File object with the folder path
        File folder = new File(userName);

        // Check if the folder exists
        if (folder.exists() && folder.isDirectory()) {
            System.out.print("\n\t\t\t\t\t\tENTER YOUR USER PASSWORD HERE ---->  ");
            String userPassword = input.next();
            passwordCheck(userPassword,userName);

        } else {
            mainFile.cleaner();
            System.out.println("\n\t\t\t\t\t\tUser does not exist.");
            System.out.println("\n\n\t\t\t\t\t\t--------------------------------------");
            System.out.println("\t\t\t\t\t\t| 1. SING-IN");
            System.out.println("\t\t\t\t\t\t| 2. TRY AGAIN");
            System.out.println("\t\t\t\t\t\t--------------------------------------");
            System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t ---->  ");
            byte in = input.nextByte();
            if(in==1){
                singIn obj2 =new singIn();
                obj2.forUserNewName();
                userLogin();
            }
            else {userLogin();}
        }

    }
    public void passwordCheck(String password,String name){
        encoderFile obj = new encoderFile();
        decoderFile obj1= new decoderFile();
        mainFile obj2 = new mainFile();
        try{
            BufferedReader passWordTxt = new BufferedReader(new FileReader(name+"/password.txt"));
            String line=passWordTxt.readLine();
            passWordTxt.close();
            if(line.equals(password)){
                System.out.println("\n\t\t\t\t\t\t--------------------------------------");
                System.out.println("\t\t\t\t\t\t| 1. NEW ENCODE FILE");
                System.out.println("\t\t\t\t\t\t| 2. GET ENCODE FILE");
                System.out.println("\t\t\t\t\t\t| 3. DECODE LINE ");
                System.out.println("\t\t\t\t\t\t| 4. DECODE STORE FILE");
                System.out.println("\t\t\t\t\t\t--------------------------------------");
                System.out.print("\n\t\tENTER HERE\t\t-->\t");
                byte ch = input.nextByte();

                if (ch==1){obj.encoderFileInput();}
                else if (ch==2){obj.encoderFileReader();}
                else if (ch==3){obj1.decoderFileInline();}
                else if (ch==4){obj1.decoderFileInTXT();}
                else{ obj2.listIn();}

            }
            else{
                System.out.println("\n\t\t\t\t\t\tUSER AND PASSWORD DOESN'T MATCH");
                mainFile.delayTime(3000);
                userLogin();
            }
        }
        catch (Exception e) {
            System.out.println("\n\t\t\t\t\t\tPASSWORD NOT FOUND IN DATABASE");
        }

    }
}
