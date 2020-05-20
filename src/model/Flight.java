package model;

import java.time.LocalTime;

public class Flight {
    private String destination;
    private int flightID;
    private PlaneType plane;
    private LocalTime departureTime;
    private Weekday day;
    private int planeID;

    public Flight (String dest, int fID, PlaneType p, LocalTime dTime, Weekday day, int pID) {
        destination = dest;
        flightID = fID;
        plane = p;
        this.day = day;
        departureTime = dTime;
        planeID = pID;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setPlaneType(PlaneType plane) {
        this.plane = plane;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setPlaneID(int planeID) {
        this.planeID = planeID;
    }

    public void setWeekday(Weekday day) {
        this.day = day;
    }

    public Weekday getWeekday() {
        return this.day;
    }

    public String getDestination() {
        return this.destination;
    }

    public int getFlightID() {
        return this.flightID;
    }

    public PlaneType getPlaneType() {
        return this.plane;
    }

    public LocalTime getDepartureTime() {
        return this.departureTime;
    }

    public int getPlaneID() {
        return this.planeID;
    }

    /*public String toString() {
        return this.getDestination() + ' ' + this.getFlightID() + ' ' + this.getPlaneType() + ' ' + this.getDepartureTime() + ' ' + this.getWeekday() + ' ' + this.getPlaneID();
    }*/

    public String toString() {
        return "Destination: " + this.destination + '\n' +
                "Model.Flight ID: " + this.flightID + '\n' +
                "Plane type: " + this.plane + '\n' +
                "Departure time: " + this.departureTime + '\n' +
                "Departure day: " + this.day + '\n' +
                "Plane ID: " + this.planeID;
    }

}