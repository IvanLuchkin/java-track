import model.*;
import controller.*;
import view.*;

public class Main {

    public static void main(String...args) {
        DataSource dataSet = new DataSource();
        SearchService search = new SearchService(dataSet);
        Controller ui = new Controller(search);
        Viewer view = new Viewer(ui);
        view.mainView();
    }

}