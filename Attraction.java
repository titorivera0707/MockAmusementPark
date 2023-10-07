import java.util.ArrayList;

public class Attraction{

    private int attractionCounter;
    private String attractionID;
    private int ratePerMinute;
    private double totalAverageNormal;
    private double totalAverageFast;
    private double totalAverage;
    private ArrayList<NormalRider> alNormalLine = new ArrayList<NormalRider>();
    private ArrayList<FastRider> alFastLine = new ArrayList<FastRider>();
    private ArrayList<Rider> alGotOnRide = new ArrayList<Rider>();

    public Attraction() {
        super();
        attractionID = "";
    }

    public Attraction(int ratePerMinute, int attractionCounter) {
        super();
        setRatePerMinute(ratePerMinute);
        setAttractionID(attractionCounter);
    }

    public String getAttractionID() {
        return attractionID;
    }

    public void setAttractionID(int attractionCounter) {
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
        totalAverage += tempName.getTimeOnline();
        totalAverageNormal += tempName.getTimeOnline();
        alNormalLine.remove(0);
        return tempName;
    }

    public FastRider removeFastRider(){
        FastRider tempName = alFastLine.get(0);
        totalAverage += tempName.getTimeOnline();
        totalAverageFast += tempName.getTimeOnline();
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
        if(any instanceof NormalRider){
            totalAverageNormal += any.getTimeOnline();
        }else{
            totalAverageFast += any.getTimeOnline();
        }
        totalAverage += any.getTimeOnline();
        alGotOnRide.add(any);
    }

    public Rider getGotOnRider(int index){
        return alGotOnRide.get(index);
    }

    public int getAlGotOnRiderSize(){
        return alGotOnRide.size();
    }

    public double getTotalAverage() {
        return totalAverage;
    }

    public double getTotalAverageNormal() {
        return totalAverageNormal;
    }

    public double getTotalAverageFast() {
        return totalAverageFast;
    }

    public int getTotalNormal(){
        int tempInt =0;
        for (int i = 0; i < alGotOnRide.size(); i++) {
            if(alGotOnRide.get(i) instanceof NormalRider){
                tempInt++;
            }
        }
        return tempInt;
    }

    public int getTotalFast(){
        int tempInt =0;
        for (int i = 0; i < alGotOnRide.size(); i++) {
            if(alGotOnRide.get(i) instanceof FastRider){
                tempInt++;
            }
        }
        return tempInt;
    }
}