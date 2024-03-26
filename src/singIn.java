import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class singIn {
    Scanner input = new Scanner(System.in);

    public void forUserNewName() {
        mainFile.cleaner();

        System.out.println("\n\t\t\t\t\t\tSING-IN PAGE");

        //name
        System.out.print("\t\t\t\tENTER YOUR NAME ----->>  ");
        String name = input.nextLine();

        //Number
        System.out.print("\t\t\t\tENTER YOUR NUMBER ----->>  ");
        String number = input.nextLine();

        //Gmail
        System.out.print("\t\t\t\tENTER YOUR GMAIL ----->>  ");
        String gmail = input.nextLine();
        gmail += "@gmail.com";

        mainFile.cleaner();
        //password
        System.out.print("\t\t\t\tCreate YOUR PASSWORD ----->>  ");
        String password = input.nextLine();


        mainFile.cleaner();
        System.out.print("\t\t\t\tCreate YOUR PASSWORD ----->>********");
        //con-password
        System.out.print("\n\t\t\t\tENTER YOUR PASSWORD AGAIN ----->>  ");
        String com_password = input.nextLine();

        if (com_password.equals(password)){
            userFolderCreate(name,password,number,gmail);
        }
        else {
            System.out.println("\t\t\t\tPASSWORD DID NOT MATCH");
            String in=input.next();
            forUserNewName();
        }

    }

    public void userFolderCreate(String Name,String password,String number,String gmail) {
        File f = new File(Name);//folder name
        if (f.mkdir()) {
            System.out.println("\n\n\t\t\tNEW USER IS CREATED...");
        }else {
            System.out.println("\n\n\t\t\tUSER NAME IS INVADE");
            String in=input.next();
            forUserNewName();
        }

        //for password.txt inside folder
        String pathPassword= Name+"/password.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathPassword));
            writer.write(password+"\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("error in password.txt file saurav check again");
        }

        //for detail.txt inside folder
        String pathDetail= Name+"/detail.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathDetail));
            writer.write(gmail+"\n");
            writer.write(number+"\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("error in password.txt file saurav check again");
        }
        logIn obj = new logIn();
        obj.userLogin();
    }
}