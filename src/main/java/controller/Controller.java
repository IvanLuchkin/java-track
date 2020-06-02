package controller;

import model.*;
import model.exceptions.*;
import util.FileUtil;
import view.Viewer;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Controller {

    private static final Logger log = LogManager.getLogger(Controller.class);
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
            Viewer.printUI("Type '1' to search by destination\nType '2' to search by weekday\nType '3' to search by weekday & time\nType '4' to print everything\nType '5' to save to the file.\nType '0' to exit.\n");
            switch (this.input.nextLine()) {
                case "1" :
                    Viewer.printUI("Enter destination: ");
                    log.info("destination search");
                    try {
                        String data = this.input.nextLine();
                        validator.checkDestination(data);
                        Viewer.tableFlightView(this.search.destinationSearch(data));
                    } catch (IncorrectDestinationException incorrectDestination) {
                        log.error("incorrect dest - {}", incorrectDestination.getMessage());
                        Viewer.printUI(incorrectDestination.getMessage());
                    }
                    break;
                case "2" :
                    Viewer.printUI("Enter weekday: ");
                    log.info("weekday search");
                    try {
                        String data = this.input.nextLine();
                        validator.checkWeekday(data);
                        Viewer.tableFlightView(this.search.weekdaySearch(Weekday.valueOf(data)));
                    } catch (IncorrectWeekdayException incorrectWeekday) {
                        log.error("incorrect weekday - {}", incorrectWeekday.getMessage());
                        Viewer.printUI(incorrectWeekday.getMessage());
                    }
                    break;
                case "3":
                    try {
                        Viewer.printUI("Enter weekday: ");
                        log.info("weekday and time search");
                        String weekdayInput = this.input.nextLine();
                        validator.checkWeekday(weekdayInput);
                        Weekday weekday = Weekday.valueOf(weekdayInput);

                        Viewer.printUI("Enter departure time: ");
                        String timeInput = this.input.nextLine();
                        validator.checkTime(timeInput);
                        LocalTime dTime = LocalTime.parse(timeInput);

                        Viewer.tableFlightView(this.search.weekdayDTimeSearch(weekday, dTime));
                    } catch (IncorrectWeekdayException incorrectWeekday) {
                        log.error("incorrect weekday - {}", incorrectWeekday.getMessage());
                        Viewer.printUI(incorrectWeekday.getMessage());
                    } catch (IncorrectTimeException incorrectTime) {
                        log.error("incorrect time - {}", incorrectTime.getMessage());
                        Viewer.printUI(incorrectTime.getMessage());
                    }
                    break;
                case "4":
                    Viewer.tableFlightView(this.search.getSet().getFlights());
                    break;
                case "0":
                    log.info("EXIT");
                    break n;
                case "5":
                    Viewer.printUI("Enter filename: ");
                    log.info("writing to file");
                    try {
                        FileUtil.writeTeachers(this.search.getSet().getFlights(), this.input.nextLine());
                    } catch (IOException ioe) {
                        log.error("i/o exception - {}", ioe.getMessage());
                        Viewer.printUI(ioe.getMessage());
                    }
                    break;
                default :
                    log.error("incorrect menu operator");
                    Viewer.printUI("Wrong menu operator.\n");
                    break;
            }
        }

    }

}
