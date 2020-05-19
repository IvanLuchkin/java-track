import Model.*;
import Controller.*;

public class Main {

    public static void main(String...args) {
        Model dataSet = new Model();
        SearchService search = new SearchService(dataSet);
        Controller.ui(search);

    }

}