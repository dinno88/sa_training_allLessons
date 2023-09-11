package edu.satraining.lesson11.map.exam1.case1.client;

import edu.satraining.lesson11.map.exam1.case1.model.Book;
import edu.satraining.lesson11.map.exam1.case1.model.BookStore;
import edu.satraining.lesson11.map.exam1.case1.controller.Controller;


import java.util.Scanner;

public class Executor {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readData();
        controller.sortingData();
        controller.showData();
    }
}