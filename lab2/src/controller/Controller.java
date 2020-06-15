package controller;

import model.*;
import model.exceptions.IncorrectDestinationException;
import model.exceptions.IncorrectTimeException;
import model.exceptions.IncorrectWeekdayException;
import view.Viewer;

import java.time.LocalTime;
import java.util.Scanner;

public class Controller {

    public SearchService search;
    public Scanner input;
    private Validator validator;

    public Controller(SearchService search) {
        this.search = search;
        input = new Scanner(System.in);
        validator = new Validator();
    }

    public void mainView() {

        n:  while (true) {
            Viewer.printUI("Type '1' to search by destination\nType '2' to search by weekday\nType '3' to search by weekday & time\nType '4' to print everything\nType '0' to exit.\n");
            switch (this.input.nextLine()) {
                case "1" :
                    Viewer.printUI("Enter destination: ");
                    try {
                        String data = this.input.nextLine();
                        validator.checkDestination(data);
                        Viewer.tableFlightView(this.search.destinationSearch(data));
                    } catch (IncorrectDestinationException incorrectDestination) {
                        Viewer.printUI(incorrectDestination.getMessage());
                    }
                    break;
                case "2" :
                    Viewer.printUI("Enter weekday: ");
                    try {
                        String data = this.input.nextLine();
                        validator.checkWeekday(data);
                        Viewer.tableFlightView(this.search.weekdaySearch(Weekday.valueOf(data)));
                    } catch (IncorrectWeekdayException incorrectWeekday) {
                        Viewer.printUI(incorrectWeekday.getMessage());
                    }
                    break;
                case "3":
                    try {
                        Viewer.printUI("Enter weekday: ");
                        String weekdayInput = this.input.nextLine();
                        validator.checkWeekday(weekdayInput);
                        Weekday weekday = Weekday.valueOf(weekdayInput);
                        Viewer.printUI("Enter departure time: ");
                        String timeInput = this.input.nextLine();
                        validator.checkTime(timeInput);
                        LocalTime dTime = LocalTime.parse(timeInput);
                        Viewer.tableFlightView(this.search.weekdayDTimeSearch(weekday, dTime));
                    } catch (IncorrectWeekdayException incorrectWeekday) {
                        Viewer.printUI(incorrectWeekday.getMessage());
                    } catch (IncorrectTimeException incorrectTime) {
                        Viewer.printUI(incorrectTime.getMessage());
                    }
                    break;
                case "4":
                    Viewer.tableFlightView(this.search.getSet().getFlights());
                    break;
                case "0":
                    break n;
                default :
                    Viewer.printUI("Wrong menu operator.\n");
                    break;
            }
        }

    }

}
