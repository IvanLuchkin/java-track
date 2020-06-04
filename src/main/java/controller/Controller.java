package controller;

import model.*;
import controller.exceptions.*;

import model.entities.Weekday;
import view.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Controller {

    private static final Logger LOGGER = LogManager.getLogger(Controller.class);
    private SearchService searchService;
    private InputController inputController;

    public Controller() {
        try {
            this.searchService = new SearchService();
        } catch (IOException | ClassNotFoundException exception) {
            Viewer.printUI(exception.getMessage());
            System.exit(1);
        }
        this.inputController = new InputController();
    }

    public void mainView() {

        getLocale();

        n:  while (true) {
            Viewer.printLocalizedUI(TextConstants.MAIN_UI);
            switch (inputController.inputValue()) {
                case "1" :
                    destinationCase();
                    break;
                case "2" :
                    weekdayCase();
                    break;
                case "3":
                    timeCase();
                    break;
                case "4":
                    Viewer.tableFlightView(searchService.getSet().getFlights());
                    break;
                case "0":
                    Viewer.printLocalizedUI(TextConstants.EXIT_MESSAGE);
                    LOGGER.info("EXIT");
                    break n;
                case "5":
                    writeToFileCase();
                    break;
                default :
                    LOGGER.error("incorrect menu operator");
                    Viewer.printLocalizedUI(TextConstants.WRONG_OPERATOR_MESSAGE);
                    break;
            }
        }
    }

    private void writeToFileCase() {
        Viewer.printLocalizedUI(TextConstants.ENTER_FILE_NAME);
        LOGGER.info("writing to file");
        try {
            DataManager.writeFlights(searchService.getSet().getFlights(), inputController.inputValue());
        } catch (IOException ioe) {
            LOGGER.error("i/o exception - {}", ioe.getMessage());
            Viewer.printUI(ioe.getMessage());
        }
    }

    private void timeCase() {
        try {
            Viewer.printLocalizedUI(TextConstants.ENTER_WEEKDAY);
            LOGGER.info("weekday and time search");
            String weekdayInput = inputController.inputValue();
            Validator.checkWeekday(weekdayInput);
            Weekday weekday = Weekday.valueOf(weekdayInput);

            Viewer.printLocalizedUI(TextConstants.ENTER_TIME);
            String timeInput = inputController.inputValue();
            Validator.checkTime(timeInput);
            LocalTime dTime = LocalTime.parse(timeInput);

            Viewer.tableFlightView(searchService.weekdayDTimeSearch(weekday, dTime));
        } catch (IncorrectWeekdayException incorrectWeekday) {
            LOGGER.error("incorrect weekday - {}", incorrectWeekday.getMessage());
            Viewer.printUI(incorrectWeekday.getMessage());
        } catch (IncorrectTimeException incorrectTime) {
            LOGGER.error("incorrect time - {}", incorrectTime.getMessage());
            Viewer.printUI(incorrectTime.getMessage());
        }
    }

    private void weekdayCase() {
        Viewer.printLocalizedUI(TextConstants.ENTER_WEEKDAY);
        LOGGER.info("weekday search");
        try {
            String data = inputController.inputValue();
            Validator.checkWeekday(data);
            Viewer.tableFlightView(searchService.weekdaySearch(Weekday.valueOf(data)));
        } catch (IncorrectWeekdayException incorrectWeekday) {
            LOGGER.error("incorrect weekday - {}", incorrectWeekday.getMessage());
            Viewer.printUI(incorrectWeekday.getMessage());
        }
    }

    private void destinationCase() {
        Viewer.printLocalizedUI(TextConstants.ENTER_DESTINATION);
        LOGGER.info("destination search");
        try {
            String data = inputController.inputValue();
            Validator.checkDestination(data);
            Viewer.tableFlightView(searchService.destinationSearch(data));
        } catch (IncorrectDestinationException incorrectDestination) {
            LOGGER.error("incorrect dest - {}", incorrectDestination.getMessage());
            Viewer.printUI(incorrectDestination.getMessage());
        }
    }

    private void getLocale() {
        Viewer.printUI("Type '1' to choose English language\nType '2' to choose Ukrainian language\n");
        switch (inputController.inputValue()) {
            case "1":
                LOGGER.info("english language chosen");
                Viewer.initLocaleManager(new Locale("en"));
                return;
            case "2":
                LOGGER.info("ukrainian language chosen");
                Viewer.initLocaleManager(new Locale ("ua"));
                return;
            default:
                Viewer.printLocalizedUI(TextConstants.WRONG_OPERATOR_MESSAGE);
        }
    }

}
