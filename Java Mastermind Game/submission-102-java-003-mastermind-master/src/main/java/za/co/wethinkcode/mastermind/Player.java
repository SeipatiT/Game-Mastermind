package za.co.wethinkcode.mastermind;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player {
    //    private static String userInput;
    private final Scanner inputScanner;
    private static boolean isValid = false;
    private int chances =12;
    private boolean quitting;
    private static String userInput;

    public Player(){
        this.inputScanner = new Scanner(System.in);
    }

    public Player(InputStream inputStream){
        this.inputScanner = new Scanner(inputStream);
    }

    /**
     * Gets a guess from user via text console.
     * This must prompt the user to re-enter a guess until a valid 4-digit string is entered, or until the user enters `exit` or `quit`.
     *
     * @return the value entered by the user
     */
    public String getGuess() {

        while (inputScanner.hasNextLine()) {
            System.out.println("Input 4 digit code:");
            userInput = inputScanner.nextLine();
//            System.out.println(wantsToQuit()+"this is quit");
            if (userInput.length() != 4 || validInput() == false) {
                System.out.println("Please enter exactly 4 digits (each from 1 to 8).");
                getGuess();
            }
            if (userInput.length() == 4 || validInput() == true) {
                break;
            }
        }


//        if(wantsToQuit()){
//            boolean quit = true;
//        }
        return userInput;
    }

    private static boolean validInput(){
        ArrayList<Boolean> listIsValid = new ArrayList<Boolean>();
        for (String number : userInput.split("")) {
            try{
                int num = Integer.parseInt(number);
//            System.out.println(num);
//            System.out.println(num + "oop");
                if ((num > 0) && (num <= 8)){
                    listIsValid.add(true);
                }
                else {
//                    System.out.println("TRUE");
                    listIsValid.add(false);
                    isValid = false;
                }
            } catch (NumberFormatException numberFormatException){
                if (userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("quit")){
                    isValid = true;
                } else{
                    isValid = false;
                }
            }
        }
//        System.out.println("checking" + isValid);
//        System.out.println(listIsValid+ "list");
        int isTrue= Collections.frequency(listIsValid,true);
        if (isTrue == 4){
            isValid = true;
        } else{
            isValid = false;
        }

        return isValid;
    }


    public int getChances() {
        return chances;
    }

    public void lostChance() {
        if (!this.hasNoChances()) {
            this.chances--;

        }
        if (this.hasNoChances()){

        }
    }

    public boolean hasNoChances() {
        return this.getChances() == 0;
    }
    public boolean wantsToQuit() {
        if (userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("quit")) {
            quitting = true;
        }

        return quitting;
    }

//    public void vv() {
//
//        do {
//            System.out.println("Input 4 digit code: ");
//            userInput = this.inputScanner.nextLine();
//            if (userInput.length() != 4 || validInput() == false) {
//                System.out.println("Please enter exactly 4 digits (each from 1 to 8).");
//        }} while (userInput.length() != 4 || validInput() == false);
//    }





//    public static void main(String[] args){
//        Player game = new Player();
//        game.vv();
//    }






}
