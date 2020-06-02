package controller;

import model.*;
import model.exceptions.*;
import util.FileUtil;
import view.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Locale;
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

        Viewer.printUI("Type '1' to choose English language\nType '2' to choose Ukrainian language\n");
        l: while (true) {
            switch (this.input.nextLine()) {
                case "1":
                    log.info("english language chosen");
                    Viewer.initLocaleManager(new Locale ("en"));
                    break l;
                case "2":
                    log.info("ukrainian language chosen");
                    Viewer.initLocaleManager(new Locale ("ua"));
                    break l;
                default:
                    Viewer.printLocalizedUI(TextConstants.wrongOperatorMessage);
                    break l;
            }
        }

        n:  while (true) {
            Viewer.printLocalizedUI(TextConstants.mainUI);
            switch (this.input.nextLine()) {
                case "1" :
                    Viewer.printLocalizedUI(TextConstants.eDestination);
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
                    Viewer.printLocalizedUI(TextConstants.eWeekday);
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
                        Viewer.printLocalizedUI(TextConstants.eWeekday);
                        log.info("weekday and time search");
                        String weekdayInput = this.input.nextLine();
                        validator.checkWeekday(weekdayInput);
                        Weekday weekday = Weekday.valueOf(weekdayInput);

                        Viewer.printLocalizedUI(TextConstants.eTime);
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
                    Viewer.printLocalizedUI(TextConstants.exitMessage);
                    log.info("EXIT");
                    break n;
                case "5":
                    Viewer.printLocalizedUI(TextConstants.eFileName);
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
                    Viewer.printLocalizedUI(TextConstants.wrongOperatorMessage);
                    break;
            }
        }

    }

}
