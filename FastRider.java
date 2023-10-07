import java.util.Random;

public class FastRider extends Rider implements TicketPrice{

    private double ticketPrice;
    private int type;

    public FastRider() {
        super();
    }

    public FastRider(int onlineTime) {
        super(onlineTime);
        setType();
        setTicketPrice();
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice() {
        ticketPrice = (BASEPRICE * 1.2);
    }

    public int getType() {
        return type;
    }

    public void setType() {
        Random randy = new Random(7);
        type = randy.nextInt(1, 10);
    }

    

}