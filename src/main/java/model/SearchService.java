package model;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;

import model.entities.Flight;
import model.entities.Weekday;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchService {

    DataManager dataSet;
    private static final Logger LOGGER = LogManager.getLogger(SearchService.class);

    public SearchService() throws IOException, ClassNotFoundException {
        this.dataSet = new DataManager();
    }

    public DataManager getSet() {
        return this.dataSet;
    }

    public Flight[] destinationSearch(String dest) {
        LOGGER.info("searched dest - {}", dest);
        int arrSize = 0;
        Flight[] result = new Flight[dataSet.getFlights().length];
        for (Flight flight : dataSet.getFlights()) {
            if(flight.getDestination().equals(dest)) result[arrSize++] = flight;
        }
        return Arrays.copyOf(result, arrSize);
    }

    public Flight[] weekdaySearch(Weekday day) {
        LOGGER.info("searched day - {}", day);
        int arrSize = 0;
        Flight[] result = new Flight[dataSet.getFlights().length];
        for (Flight flight : dataSet.getFlights()) {
            if(flight.getWeekday().equals(day)) result[arrSize++] = flight;
        }
        return Arrays.copyOf(result, arrSize);
    }

    public Flight[] weekdayDTimeSearch(Weekday day, LocalTime dTime) {
        LOGGER.info("searched weekday - {}, searched time - {}", day, dTime);
        int arrSize = 0;
        Flight[] result = new Flight[dataSet.getFlights().length];
        for(Flight flight : dataSet.getFlights()) {
            if (flight.getWeekday().equals(day) && (flight.getDepartureTime().compareTo(dTime) >= 0)) {
                result[arrSize++] = flight;
            }
        }
        return Arrays.copyOf(result, arrSize);
    }
    public Flight[] destinationSearchV1(String dest) {
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

    public Flight[] weekdaySearchV1(Weekday day) {
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

    public Flight[] weekdayDTimeSearchV1(Weekday day, LocalTime dTime) {
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
