import java.util.ArrayList;

public class Attraction{

    private int attractionCounter;
    private String attractionID;
    private int ratePerMinute;
    private ArrayList<NormalRider> alNormalLine;
    private ArrayList<FastRider> alFastLine;
    private ArrayList<Rider> alGotOnRide;

    public Attraction() {
        super();
        attractionID = "";
    }

    public Attraction(int ratePerMinute) {
        super();
        setRatePerMinute(ratePerMinute);
        setAttractionID();
    }

    public String getAttractionID() {
        return attractionID;
    }

    public void setAttractionID() {
        attractionCounter += 1;
        attractionID = "RIDE " + attractionCounter;
    }

    public int getRatePerMinute() {
        return ratePerMinute;
    }

    public void setRatePerMinute(int ratePerMinute) {
        this.ratePerMinute = ratePerMinute;
    }

    public void addRiderNormalLine(NormalRider normRider){
        alNormalLine.add(normRider);
    }    

    public void addRiderFastLine(FastRider fastRider){
        alFastLine.add(fastRider);
    }

    public NormalRider removeNormalRider(){
        NormalRider tempName = alNormalLine.get(0);
        alNormalLine.remove(0);
        return tempName;
    }

    public FastRider removeFastRider(){
        FastRider tempName = alFastLine.get(0);
        alFastLine.remove(0);
        return tempName;
    }

    public int getAlNormalLineSize(){
        return alNormalLine.size();
    }

    public int getAlFastLineSize(){
        return alFastLine.size();
    }

    public void addGotOnRide(Rider any){
        alGotOnRide.add(any);
    }

    public Rider getGotOnRider(int index){
        return alGotOnRide.get(index);
    }

    public int getAlGotOnRiderSize(){
        return alGotOnRide.size();
    }

}