import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class AmusementPark{

    private String parkName;
    private int numAttractions;
    private ArrayList<Attraction> alAttraction = new ArrayList<>();

    public AmusementPark() {
        super();
        setParkName("");
        setNumAttractions(0);
        createAttractions(0);
    }

    public AmusementPark(String name, int numAttractions) {
        super();
        setParkName(name);
        setNumAttractions(numAttractions);
        createAttractions(numAttractions);
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public int getNumAttractions() {
        return numAttractions;
    }

    public void setNumAttractions(int numAttractions) {
        this.numAttractions = numAttractions;
    }
    
    public void createAttractions(int totalAttractions){
        Random randy = new Random(2);
        for (int i = 0; i < totalAttractions; i++) {
            int ratePerMinute = randy.nextInt(15, 20);
            Attraction newAttraction = new Attraction(ratePerMinute, i+1);
            alAttraction.add(newAttraction);
        }
    }

    public void runThePark(int duration){
        int initialRiders = 29*numAttractions;
        int newRiders = 29*numAttractions;

        for (int i = 0; i < initialRiders; i++) {
            int tempI = i;
            while(tempI >= numAttractions){
                tempI -= numAttractions;
            }
            Attraction tempAtt = alAttraction.get(tempI);
            if(i%3==0 || i%7==0){
                FastRider tempFast = new FastRider(0);
                tempAtt.addRiderFastLine(tempFast);
            }else{
                NormalRider tempNorm = new NormalRider(0);
                tempAtt.addRiderNormalLine(tempNorm);
            }
            
        }

        for (int i = 0; i < duration; i++) {
            for (int j = 0; j < newRiders; j++) {
                int tempI = j;
                while(tempI >= numAttractions){
                    tempI -= numAttractions;
                }
                Attraction tempAtt = alAttraction.get(tempI);
                if(i%3==0 || i%7==0){
                    FastRider tempFast = new FastRider(i);
                    tempAtt.addRiderFastLine(tempFast);
                }else{
                    NormalRider tempNorm = new NormalRider(i);
                    tempAtt.addRiderNormalLine(tempNorm);
                }
            }

            for (int j = 0; j < numAttractions; j++) {
                Attraction tempAttraction = alAttraction.get(j);
                int toBeProcessed = tempAttraction.getRatePerMinute();
                while(toBeProcessed > 0){
                    if(tempAttraction.getAlFastLineSize() > 0 && !(toBeProcessed%3==0)){
                        FastRider tempRider = tempAttraction.removeFastRider();
                        tempRider.setEndOnlineTime(i);
                        tempAttraction.addGotOnRide(tempRider);
                        toBeProcessed -= 1;
                    }else if(tempAttraction.getAlNormalLineSize()>0){
                        NormalRider tempRider = tempAttraction.removeNormalRider();
                        tempRider.setEndOnlineTime(i);
                        tempAttraction.addGotOnRide(tempRider);
                        toBeProcessed -= 1;
                    }else {
                        toBeProcessed = 0;
                    }
                }
                tempAttraction.getTotalAverage();
            }
        }


    }

    public void printParkStatistics(PrintWriter printwrtr)throws IOException{
        printwrtr.println("The statistics for " + parkName + "\n\n");
        for (int i = 0; i < numAttractions; i++) {
            Attraction tempAttraction = alAttraction.get(i);
            printwrtr.println(String.format("Statistics for Attraction %s", tempAttraction.getAttractionID()));
            printwrtr.println(String.format("The total number that got onto the ride is %d", tempAttraction.getAlGotOnRiderSize()));
            printwrtr.println(String.format("There were %d Fast Riders who got on waiting an average of %.2f minutes", tempAttraction.getTotalFast(), (double)(tempAttraction.getTotalAverageFast()/tempAttraction.getTotalFast())));
            printwrtr.println(String.format("There were %d Normal Riders who got on waiting an average of %.2f minutes", tempAttraction.getTotalNormal(),(double)(tempAttraction.getTotalAverageNormal()/tempAttraction.getTotalNormal())));
            printwrtr.println(String.format("There were %d Total Riders who got on waiting an average of %.2f minutes\n\n", tempAttraction.getAlGotOnRiderSize(),tempAttraction.getTotalAverage()/tempAttraction.getAlGotOnRiderSize()));

        }
    }


}