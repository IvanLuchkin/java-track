package view;

import model.Flight;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Viewer {

    private static LocaleManager localeManager;

    private static final String printFormat = "%-20s%-12s%-15s%-17s%-12s%-9s%n";

    public static void tableFlightView(Flight flight) {
        System.out.printf(printFormat, localeManager.getString(TextConstants.destination), localeManager.getString(TextConstants.flightId), localeManager.getString(TextConstants.plane), localeManager.getString(TextConstants.departureTime), localeManager.getString(TextConstants.weekd), localeManager.getString(TextConstants.planeId));
        System.out.printf(printFormat, flight.getDestination(), flight.getFlightID(), flight.getPlaneType(), flight.getDepartureTime(), flight.getWeekday(), flight.getPlaneID());
    }

    public static void tableFlightView(Flight[] arr) {
        if (arr.length == 0) {
            printLocalizedUI(TextConstants.noData);
        } else {
            System.out.printf(printFormat, localeManager.getString(TextConstants.destination), localeManager.getString(TextConstants.flightId), localeManager.getString(TextConstants.plane), localeManager.getString(TextConstants.departureTime), localeManager.getString(TextConstants.weekd), localeManager.getString(TextConstants.planeId));
            for (Flight flight : arr) {
                System.out.printf(printFormat, flight.getDestination(), flight.getFlightID(), flight.getPlaneType(), flight.getDepartureTime(), flight.getWeekday(), flight.getPlaneID());
            }
        }
    }

    public static void initLocaleManager(Locale locale) {
        localeManager = new LocaleManager(locale);
    }

    public static void printUI(String element) {
        System.out.println(element);
    }

    public static void printLocalizedUI(String element) {
        String value = localeManager.getString(element);
        new PrintStream(System.out, true, StandardCharsets.UTF_8).println(value);
    }

}
