package view;

import controller.Controller;
import model.Flight;
import model.Weekday;

import java.time.LocalTime;

public class Viewer {

    private static String printFormat = "%-15s%-12s%-15s%-17s%-12s%-9s%n";

    public static void tableFlightView(Flight flight) {
        System.out.printf(printFormat, "Destination", "Flight ID", "Plane", "Departure time", "Weekday", "Plane ID");
        System.out.printf(printFormat, flight.getDestination(), flight.getFlightID(), flight.getPlaneType(), flight.getDepartureTime(), flight.getWeekday(), flight.getPlaneID());
    }

    public static void tableFlightView(Flight[] arr) {
        if (arr.length == 0) {
            System.out.println("No data.");
        } else {
            System.out.printf(printFormat, "Destination", "Flight ID", "Plane", "Departure time", "Weekday", "Plane ID");
            for (Flight flight : arr) {
                System.out.printf(printFormat, flight.getDestination(), flight.getFlightID(), flight.getPlaneType(), flight.getDepartureTime(), flight.getWeekday(), flight.getPlaneID());
            }
        }
    }

    public static void printUI(String element) {
        System.out.println(element);
    }



}
