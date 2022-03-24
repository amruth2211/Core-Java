package Constructer;

import java.util.Scanner;

class Event {
    String name;
    String detail;
    String type;
    String organiser;
    int attendeesCount;
    double projectExpenses;

    public Event() {
    }

    public Event(String name, String detail, String type, String organiser, int attendeesCount,
            double projectExpenses) {
        this.name = name;
        this.detail = detail;
        this.type = type;
        this.organiser = organiser;
        this.attendeesCount = attendeesCount;
        this.projectExpenses = projectExpenses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public int getAttendeesCount() {
        return attendeesCount;
    }

    public void setAttendeesCount(int attendeesCount) {
        this.attendeesCount = attendeesCount;
    }

    public double getProjectExpenses() {
        return projectExpenses;
    }

    public void setProjectExpenses(double projectExpenses) {
        this.projectExpenses = projectExpenses;
    }

    @Override
    public String toString() {
        return "Name:" + name + "\nDetail:" + detail + "\nType:" + type + "\nOrganiser:" + organiser
                + "\nAttendees Count:" + attendeesCount +
                "\nProjected Expense:" + projectExpenses;
    }

}

public class Constructer {
    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        String name = scr.nextLine();
        String detail = scr.nextLine();
        String type = scr.nextLine();
        String organiser = scr.nextLine();
        int attendeesCount = scr.nextInt();
        double projectExpenses = scr.nextDouble();
        Event e = new Event(name, detail, type, organiser, attendeesCount, projectExpenses);
        System.out.println(e);
        scr.close();
    }
}
