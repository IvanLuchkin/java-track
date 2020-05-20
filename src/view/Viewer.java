package view;

import controller.Controller;
import model.Flight;
import model.SearchService;
import model.Weekday;

import java.time.LocalTime;
import java.util.Scanner;

public class Viewer {

    Controller ui;

    public Viewer(Controller ui) {
        this.ui = ui;
    }

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

    public void mainView() {

        n:  while (true) {
            System.out.print("Type '1' to search by destination\nType '2' to search by weekday\nType '3' to search by weekday & time\nType '0' to exit.\n");
            switch (ui.input.nextLine()) {
                case "1" :
                    System.out.println("Enter destination: ");
                    tableFlightView(ui.search.destinationSearch(ui.input.nextLine()));
                    break;
                case "2" :
                    System.out.println("Enter weekday: ");
                    tableFlightView(ui.search.weekdaySearch(Weekday.valueOf(ui.input.nextLine())));
                    break;
                case "3":
                    System.out.println("Enter weekday: ");
                    Weekday weekday = Weekday.valueOf(ui.input.nextLine());
                    System.out.println("Enter departure time: ");
                    LocalTime dTime = LocalTime.parse(ui.input.nextLine());
                    tableFlightView(ui.search.weekdayDTimeSearch(weekday, dTime));
                    break;
                case "0":
                    break n;
            }
        }

    }

}
