package utils;

/**
 * Created by bunny on 19/06/17.
 */

public class CustomDate {
    int date;
    String event;
    String hinduMonth ;

    public CustomDate(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getHinduMonth() {
        return hinduMonth;
    }

    public void setHinduMonth(String hinduMonth) {
        this.hinduMonth = hinduMonth;
    }
}
