
public abstract class Rider{

    private int startOnlineTime;
    private int endOnlineTime;
    private int timeOnline;

    public Rider() {
        super();
    }

    public Rider(int startOnlineTime) {
        super();
        setStartOnlineTime(startOnlineTime);
    }

    public int getStartOnlineTime() {
        return startOnlineTime;
    }

    public void setStartOnlineTime(int startOnlineTime) {
        this.startOnlineTime = startOnlineTime;
    }

    public int getEndOnlineTime() {
        return endOnlineTime;
    }

    public void setEndOnlineTime(int endOnlineTime) {
        timeOnline += endOnlineTime - startOnlineTime;
        this.endOnlineTime = endOnlineTime;
    }

    public int getTimeOnline() {
        return timeOnline;
    }

    public abstract void setType();
    public abstract int getType();

}