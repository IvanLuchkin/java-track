package controller;

import model.SearchService;
import model.Weekday;
import view.Viewer;

import java.time.LocalTime;
import java.util.Scanner;

public class Controller {

    public SearchService search;
    public Scanner input;

    public Controller(SearchService search) {
        this.search = search;
        input = new Scanner(System.in);
    }

    public void mainView() {

        n:  while (true) {
            Viewer.printUI("Type '1' to search by destination\nType '2' to search by weekday\nType '3' to search by weekday & time\nType '0' to exit.\n");
            switch (this.input.nextLine()) {
                case "1" :
                    Viewer.printUI("Enter destination: ");
                    Viewer.tableFlightView(this.search.destinationSearch(this.input.nextLine()));
                    break;
                case "2" :
                    Viewer.printUI("Enter weekday: ");
                    Viewer.tableFlightView(this.search.weekdaySearch(Weekday.valueOf(this.input.nextLine())));
                    break;
                case "3":
                    Viewer.printUI("Enter weekday: ");
                    Weekday weekday = Weekday.valueOf(this.input.nextLine());
                    Viewer.printUI("Enter departure time: ");
                    LocalTime dTime = LocalTime.parse(this.input.nextLine());
                    Viewer.tableFlightView(this.search.weekdayDTimeSearch(weekday, dTime));
                    break;
                case "0":
                    break n;
            }
        }

    }

}
