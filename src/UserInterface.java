import java.time.LocalTime;
import java.util.Scanner;

public class UserInterface {

    public static void main(String...args) {
        Model dataSet = new Model();


        Scanner input = new Scanner(System.in);

   n:   while(true) {
            System.out.print("Type '1' to search by destination\nType '2' to search by weekday\nType '3' to search by weekday & time\nType '0' to exit.\n");
            switch (input.nextLine()) {
                case "1" :
                    System.out.println("Enter destination: ");
                    Viewer.tableFlightView(dataSet.destinationSearch(input.nextLine()));
                    break;
                case "2" :
                    System.out.println("Enter weekday: ");
                    Viewer.tableFlightView(dataSet.weekdaySearch(Weekday.valueOf(input.nextLine())));
                    break;
                case "3":
                    System.out.println("Enter weekday: ");
                    Weekday weekday = Weekday.valueOf(input.nextLine());
                    System.out.println("Enter departure time: ");
                    LocalTime dTime = LocalTime.parse(input.nextLine());
                    Viewer.tableFlightView(dataSet.weekdayDTimeSearch(weekday, dTime));
                    break;
                case "0":
                    break n;
           }
       }

    }

}