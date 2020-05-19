package Model;

import java.time.LocalTime;

public class SearchService {

    Model dataSet;

    public SearchService(Model dataSet) {
        this.dataSet = dataSet;
    }

    public  Flight[] destinationSearch(String dest) {
        int arrSize = 0;
        for (Flight flight : dataSet.getFlights()) {
            if(flight.getDestination().equals(dest)) arrSize++;
        }
        Flight[] result = new Flight[arrSize];
        int iterator = 0;
        for (Flight flight : dataSet.getFlights()) {
            if (flight.getDestination().equals(dest)) {
                result[iterator] = flight;
                iterator++;
            }
        }
        return result;
    }

    public Flight[] weekdaySearch(Weekday day) {
        int arrSize = 0;
        for (Flight flight : dataSet.getFlights()) {
            if(flight.getWeekday().equals(day)) arrSize++;
        }
        Flight[] result = new Flight[arrSize];
        int iterator = 0;
        for (Flight flight : dataSet.getFlights()) {
            if (flight.getWeekday().equals(day)) {
                result[iterator] = flight;
                iterator++;
            }
        }
        return result;
    }

    public Flight[] weekdayDTimeSearch(Weekday day, LocalTime dTime) {
        int arrSize = 0;
        for (Flight flight : dataSet.getFlights()) {
            if(flight.getWeekday().equals(day) && (flight.getDepartureTime().compareTo(dTime) >= 0)) arrSize++;
        }
        Flight[] result = new Flight[arrSize];
        int iterator = 0;
        for (Flight flight : dataSet.getFlights()) {
            if (flight.getWeekday().equals(day) && (flight.getDepartureTime().compareTo(dTime) >= 0)) {
                result[iterator] = flight;
                iterator++;
            }
        }
        return result;
    }

}
