import java.io.*;
import java.util.*;

public class SimulatePark{

    public static void main(String[] args) throws IOException{
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Please enter the name of the Amusement Park: ");
        String amuseName = keyboard.nextLine();
        System.out.println("Please enter the number of attractions\nNumber must be between 3 and 10 inclusively, excluding 7");
        int attNumber = keyboard.nextInt();
        AmusementPark newPark = new AmusementPark(amuseName, attNumber);
        System.out.println("Please enter the duration of the simulation in minutes\nMust enter 60 minutes or greater: ");
        int simTime = keyboard.nextInt();
        newPark.runThePark(simTime);
        keyboard.nextLine();
        System.out.println("Please enter the name of the output file: ");
        String fileName = keyboard.nextLine();
        PrintWriter newPrint = new PrintWriter(fileName);
        newPark.printParkStatistics(newPrint);

        newPrint.close();

    }

}