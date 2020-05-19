import java.time.LocalTime;

public class Model {

    private static Flight[] flights = new Flight[10];

    Model() {
        flights[0] = new Flight ("Kyiv", 1111, PlaneType.AIRBUS_A320, LocalTime.of(15, 0), Weekday.FRIDAY, 103);
        flights[1] = new Flight ("Kyiv", 1112, PlaneType.BOEING_737_400, LocalTime.of(15,30), Weekday.TUESDAY, 102);
        flights[2] = new Flight ("Odesa", 1113, PlaneType.BOEING_737_400, LocalTime.of(16, 0), Weekday.SATURDAY, 103);
        flights[3] = new Flight ("Kharkiv", 1114, PlaneType.AIRBUS_A320, LocalTime.of(17, 05), Weekday.MONDAY, 101);
        flights[4] = new Flight ("Krakow", 2123, PlaneType.BOEING_737_400, LocalTime.of(9, 0), Weekday.THURSDAY, 204);
        flights[5] = new Flight ("Berlin", 5562, PlaneType.BOEING_737_400, LocalTime.of(10, 25), Weekday.FRIDAY, 205);
        flights[6] = new Flight ("London", 3271, PlaneType.AIRBUS_A320, LocalTime.of(5, 50), Weekday.SUNDAY, 206);
        flights[7] = new Flight ("Sydney", 4486, PlaneType.AIRBUS_A320, LocalTime.of(0, 0), Weekday.SUNDAY, 207);
        flights[8] = new Flight ("Tokyo", 9937, PlaneType.AIRBUS_A320, LocalTime.of(23, 10), Weekday.WEDNESDAY, 208);
        flights[9] = new Flight ("San-Diego", 6112, PlaneType.BOEING_737_400, LocalTime.of(12, 45), Weekday.WEDNESDAY, 209);
    }

    public Flight[] getFlights() {
        return flights;
    }

    public Flight[] destinationSearch(String dest) {
        int arrSize = 0;
        for (Flight flight : getFlights()) {
            if(flight.getDestination().equals(dest)) arrSize++;
        }
        Flight[] result = new Flight[arrSize];
        int iterator = 0;
        for (Flight flight : flights) {
            if (flight.getDestination().equals(dest)) {
                result[iterator] = flight;
                iterator++;
            }
        }
        return result;
    }

    public Flight[] weekdaySearch(Weekday day) {
        int arrSize = 0;
        for (Flight flight : getFlights()) {
            if(flight.getWeekday().equals(day)) arrSize++;
        }
        Flight[] result = new Flight[arrSize];
        int iterator = 0;
        for (Flight flight : flights) {
            if (flight.getWeekday().equals(day)) {
                result[iterator] = flight;
                iterator++;
            }
        }
        return result;
    }

    public Flight[] weekdayDTimeSearch(Weekday day, LocalTime dTime) {
        int arrSize = 0;
        for (Flight flight : getFlights()) {
            if(flight.getWeekday().equals(day) && (flight.getDepartureTime().compareTo(dTime) >= 0)) arrSize++;
        }
        Flight[] result = new Flight[arrSize];
        int iterator = 0;
        for (Flight flight : flights) {
            if (flight.getWeekday().equals(day) && (flight.getDepartureTime().compareTo(dTime) >= 0)) {
                result[iterator] = flight;
                iterator++;
            }
        }
        return result;
    }


}
