import java.util.*;
import java.io.*;

public class NormalRider extends Rider implements TicketPrice{

    private double ticketPrice;
    private int type;

    public NormalRider() {
        super();
    }

    public NormalRider(int onlineTime) {
        super(onlineTime);
        setType();
        setTicketPrice();
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice() {
        ticketPrice = BASEPRICE;
    }

    public int getType() {
        return type;
    }

    public void setType() {
        Random randy = new Random(4);
        type = randy.nextInt(1, 5);
    }

    

}