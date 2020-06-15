import model.*;
import controller.*;

public class Main {

    public static void main(String...args) {
        DataSource dataSet = new DataSource();
        SearchService search = new SearchService(dataSet);
        Controller ui = new Controller(search);
        ui.mainView();
    }

}