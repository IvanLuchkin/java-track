package Controller;

import Model.SearchService;
import Model.Weekday;
import java.time.LocalTime;
import java.util.Scanner;

public class Controller {

    public static void ui(SearchService search) {

        Scanner input = new Scanner(System.in);

        n:  while (true) {
            System.out.print("Type '1' to search by destination\nType '2' to search by weekday\nType '3' to search by weekday & time\nType '0' to exit.\n");
            switch (input.nextLine()) {
                case "1" :
                    System.out.println("Enter destination: ");
                    View.Viewer.tableFlightView(search.destinationSearch(input.nextLine()));
                    break;
                case "2" :
                    System.out.println("Enter weekday: ");
                    View.Viewer.tableFlightView(search.weekdaySearch(Weekday.valueOf(input.nextLine())));
                    break;
                case "3":
                    System.out.println("Enter weekday: ");
                    Weekday weekday = Weekday.valueOf(input.nextLine());
                    System.out.println("Enter departure time: ");
                    LocalTime dTime = LocalTime.parse(input.nextLine());
                    View.Viewer.tableFlightView(search.weekdayDTimeSearch(weekday, dTime));
                    break;
                case "0":
                    break n;
            }
        }

    }

}
