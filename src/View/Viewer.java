package View;

import Model.Flight;

public class Viewer {

    private static String printFormat = "%-15s%-12s%-15s%-17s%-12s%-9s%n";

    public static void tableFlightView(Flight flight) {
        System.out.printf(printFormat, "Destination", "Model.Flight ID", "Plane", "Departure time", "Model.Weekday", "Plane ID");
        System.out.printf(printFormat, flight.getDestination(), flight.getFlightID(), flight.getPlaneType(), flight.getDepartureTime(), flight.getWeekday(), flight.getPlaneID());
    }

    public static void tableFlightView(Flight[] arr) {
        if (arr.length == 0) {
            System.out.println("No data.");
        } else {
            System.out.printf(printFormat, "Destination", "Model.Flight ID", "Plane", "Departure time", "Model.Weekday", "Plane ID");
            for (Flight flight : arr) {
                System.out.printf(printFormat, flight.getDestination(), flight.getFlightID(), flight.getPlaneType(), flight.getDepartureTime(), flight.getWeekday(), flight.getPlaneID());
            }
        }
    }

}
