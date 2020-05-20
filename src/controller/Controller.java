package controller;

import model.SearchService;
import java.util.Scanner;

public class Controller {

    public SearchService search;
    public Scanner input;

    public Controller(SearchService search) {
        this.search = search;
        input = new Scanner(System.in);
    }

}
