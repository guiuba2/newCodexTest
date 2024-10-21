package com.codex;

import java.util.List;
import java.util.Scanner;

/**
 * This class is subdivided into the functionalities check if there is
 * an intersection between two rectangles and  compute the area
 * of intersection of two rectangles.
 *
 * @author Guilherme de Magalhaes Andrade
 */
public class RectangleIntersection {

    // Define a Rectangle class to represent a rectangle by its two corners
    static class Rectangle {
        int x1, y1, x2, y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    /**
     * Method to check if there is intersection between two rectangles
     */
    static void checkIfTwoRectanglesIntersect() {
        //capture rectangles from input
        List<Rectangle> rectanglesList = captureRectangleCoordinates();
        Rectangle rect1 = rectanglesList.get(0);
        Rectangle rect2 = rectanglesList.get(1);
        // Print the result
        System.out.println("Result: " + intersects(rect1, rect2) + "\n");
    }

    /**
     * Method to calculate the area of intersection between two rectangles
     */
    static void computeAreaOfIntersection() {

        //capture rectangles from input
        List<Rectangle> rectanglesList = captureRectangleCoordinates();
        Rectangle rect1 = rectanglesList.get(0);
        Rectangle rect2 = rectanglesList.get(1);
        int result;
        // Check if they don't intersect
        if (!intersects(rect1, rect2)) {
            result = 0;
        } else {
            // Find the coordinates of the overlapping region
            int xOverlapLeft = Math.max(rect1.x1, rect2.x1);  // leftmost x of the overlap
            int xOverlapRight = Math.min(rect1.x2, rect2.x2); // rightmost x of the overlap
            int yOverlapBottom = Math.max(rect1.y1, rect2.y1); // bottommost y of the overlap
            int yOverlapTop = Math.min(rect1.y2, rect2.y2);    // topmost y of the overlap

            // Calculate the width and height of the overlapping region
            int overlapWidth = xOverlapRight - xOverlapLeft + 1;  // +1 to include both endpoints
            int overlapHeight = yOverlapTop - yOverlapBottom + 1; // +1 to include both endpoints

            // Calculate the area of the overlap
            result = overlapWidth * overlapHeight;
        }
        // Print the result
        System.out.println("Result: " + result + "\n");
    }


    //Method to capture rectangles from input
    public static List<Rectangle> captureRectangleCoordinates() {
        Scanner scan = new Scanner(System.in);
        Rectangle rect1;
        Rectangle rect2;
        try {
            System.out.println("As for rectangle 1, please enter bottom-left " +
                    "and top-right corner coordinates, separated by space:");
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            // Define first rectangle
            rect1 = new Rectangle(x1, y1, x2, y2); //
            System.out.println("Now, for rectangle 2, please enter bottom-left " +
                    "and top-right corner coordinates, separated by space:");
            int x3 = scan.nextInt();
            int y3 = scan.nextInt();
            int x4 = scan.nextInt();
            int y4 = scan.nextInt();
            // Define second rectangle
            rect2 = new Rectangle(x3, y3, x4, y4); //
            // return a list with these rectangles
            return List.of(rect1, rect2);
            //catch clause to check if input is invalid and prevent the program from crashing
        } catch (Exception e) {
            System.out.println("Invalid input, insert only numbers only please.\n");
            new Main().showOptions();
        }
        return null;
    }

    /**
     * Method to check if two rectangles intersect
     * @param rect1
     * @param rect2
     * @return
     */
    public static boolean intersects(Rectangle rect1, Rectangle rect2) {
        // Check if one rectangle is completely to the left or right of the other
        if (rect1.x2 < rect2.x1 || rect2.x2 < rect1.x1) {
            return false;
        }
        // Check if one rectangle is completely above or below the other
        // Otherwise, the rectangles intersect
        return rect1.y2 >= rect2.y1 && rect2.y2 >= rect1.y1;
    }
}
