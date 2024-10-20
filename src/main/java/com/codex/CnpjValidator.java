package com.codex;

import java.util.*;
public class CnpjValidator {

    public static void validateCnpj(Scanner scan) {
        System.out.println("Please enter a CNPJ number to validate:");
        String cnpj = scan.next();
        boolean isValid = isValidCNPJ(cnpj)  ;
        if (isValid) {

            System.out.println(cnpj + " is a valid CNPJ number");
        } else {
            System.out.println(cnpj + " is an invalid CNPJ number");
        }
        System.out.println();
    }

    public static boolean isValidCNPJ(String cnpj) {
        // Remove special characters (dots, slashes, hyphens)

        cnpj = cnpj.replaceAll("\\D", "");

        // Check if it has 14 digits
        if (cnpj.length() != 14) {
            return false;
        }

        // Check if it's a sequence of repeated numbers
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        try {
            // Calculation of check digits
            char dig13, dig14;
            int sum, i, r, num, weight;

            // Calculation of the 1st check digit
            sum = 0;
            weight = 5;
            for (i = 0; i < 12; i++) {
                num = (int) (cnpj.charAt(i) - 48);
                sum = sum + (num * weight);
                weight = (weight == 2) ? 9 : weight - 1;
            }
            r = sum % 11;
            dig13 = (r < 2) ? '0' : (char) ((11 - r) + 48);

            // Calculation of the 2nd check digit
            sum = 0;
            weight = 6;
            for (i = 0; i < 13; i++) {
                num = (int) (cnpj.charAt(i) - 48);
                sum = sum + (num * weight);
                weight = (weight == 2) ? 9 : weight - 1;
            }
            r = sum % 11;
            dig14 = (r < 2) ? '0' : (char) ((11 - r) + 48);

            // Check if the calculated digits match the provided digits
            return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));
        } catch (InputMismatchException e) {
            return false;
        }
    }
}

