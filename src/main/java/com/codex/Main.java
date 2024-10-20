package com.codex;

import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    boolean quit = false;

    public static void main(String[] args) {

        System.out.println("Hello! Be welcome to my pre-qualification test." +
                "");
        Main main = new Main();
        while (!main.quit) {
            main.showOptions();
        }


    }

    public void showOptions() {
        System.out.println(
                "Please choose one of the following options:\n" +
                        "1 - CNPJ validator\n" +
                        "2 - Test if two rectangles intersect\n" +
                        "3 - Compute the area of intersection between two rectangles\n" +
                        "4 - Simple Todo List\n" +
                        "5 - Rest Client - World Clock\n" +
                        "6 - Rest Server - World Clock\n" +
                        "0 - Quit");
        String option = scan.next();
        switch (option) {
            case "1":
                CnpjValidator.validateCnpj(scan);
                break;
            case "2":
                RectangleIntersection.checkIfTwoRectanglesIntersect();
                break;
            case "3":
                RectangleIntersection.computeAreaOfIntersection();
                break;
            case "4":
                TodoList.showMenu();
                break;
            case "5":
                TimeQuery.checkCurrentDateTime();
                TimeQuery.displayCurrDayTimeLocUtc();
                break;
            case "6":
                TimeQuery.checkCurrentDateTime();
                TimeQuery.displayCurrDayTimeLocalInJsonFormat();
                break;
            case "0":
                quit = true;
                System.out.println("Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option\n");
        }


    }


}