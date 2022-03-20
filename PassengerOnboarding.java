
//package Week4;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class AirTicket {
    String passenger;
    String source;
    String destination;

    public AirTicket(String passenger, String source, String destination) {
        this.passenger = passenger;
        this.source = source;
        this.destination = destination;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "destination: " + destination + ", passenger: " + passenger + ", source: " + source;
    }

}

public class PassengerOnboarding {
    public static void main(String[] args) throws ParseException {
        AirTicket ticket = new AirTicket("Amruth", "Hyderabad", "Banglore");
        System.out.println("The details of your ticket are: ");
        System.out.println(ticket);
        SimpleDateFormat dateofJourney = new SimpleDateFormat("dd MM yyyy");
        Date d = dateofJourney.parse(args[0] + " " + args[1] + " " + args[2]);
        System.out.println("Date of journey: " + d);

    }

}
