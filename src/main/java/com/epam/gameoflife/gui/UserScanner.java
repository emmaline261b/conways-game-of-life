package com.epam.gameoflife.gui;

import java.util.Scanner;

public final class UserScanner {

    public int getUsersChoice() {
        int result = 1;
        try (Scanner scanner = new Scanner(System.in)) {
            result = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 1;
        }
        return result;
    }
}
