package za.co.wethinkcode.mastermind;


import java.util.ArrayList;
import java.util.Collections;


public class Mastermind {
    private final String code;
    private final Player player;
    public String guess;


    public Mastermind(CodeGenerator generator, Player player){
        this.code = generator.generateCode();
//        this.code = "6178";
//        System.out.println("This is the" + code);
        this.player = player;
    }
    public Mastermind(){
        this(new CodeGenerator(), new Player());
    }

    public void runGame() {
        //TODO: implement the main run loop logic
        System.out.println("4-digit Code has been set. " +
                "Digits in range 1 to 8. You have 12 turns to break it.");

        while(!isExactMatch( code)){

            if (player.wantsToQuit()){
                System.out.println("Bye!");
                break;
            }
            if(player.getChances() > 0){
                System.out.println( "Number of correct digits in correct place: "+ areCorrectAndCorrectPlace(guess,code));

                int correctWrongPlace =
                        Math.abs(((areCorrectAndCorrectPlace(guess,code)-areInCode(guess,code))));
                System.out.println( "Number of correct digits not in correct place: "+ correctWrongPlace
                );

                player.lostChance();
                if (player.getChances() > 0) {
                    System.out.println("Turns left: " + player.getChances());
                }
            }
            if(player.getChances() == 0){
                System.out.println("No more turns left.\n" +
                        "The code was: " + code);
                break;
            }

    }
        if(isExactMatch(code)){
            System.out.println("Number of correct digits in correct place: 4\n" +
                    "Number of correct digits not in correct place: 0\n" +
                    "Congratulations! You are a codebreaker!\n" +
                    "The code was: " + code);
        }

    }


    public int areCorrectAndCorrectPlace(String guess, String code) {
        ArrayList <String> listCode = new ArrayList<String>();
        ArrayList <String> listGuess = new ArrayList<String>();
        ArrayList <Boolean> listCorrectPosition = new ArrayList<Boolean>();

        for (String numberCode : code.split("")) {
            listCode.add(numberCode);
        }

        for (String numberGuess : guess.split("")) {
            listGuess.add(numberGuess);
        }
        for(int i = 0; i <listGuess.size();i++){
            Integer atGuessIndex = Integer.valueOf(listGuess.get(i));
            Integer atCodeIndex = Integer.valueOf(listCode.get(i));
//            System.out.println((atCodeIndex==atGuessIndex) + "correct index");
            listCorrectPosition.add((atCodeIndex==atGuessIndex));
        }

//        System.out.println(listCorrectPosition + "true or false list of those in correct position");
        int isTrue = Collections.frequency(listCorrectPosition,true);
        return isTrue;
    }


    public int areInCode(String guess, String code){
        ArrayList <String> listCode = new ArrayList<String>();
        ArrayList <String> listGuess = new ArrayList<String>();
        ArrayList <Boolean> listCorrectNumberOrderNotImportant = new ArrayList<Boolean>();
        for (String numberCode : code.split("")) {
            listCode.add(numberCode);
        }
        for (String numberGuess : guess.split("")) {
            listGuess.add(numberGuess);
        }
        boolean codeIndex1 = listCode.contains(listGuess.get(0));
//        System.out.println(codeIndex1 + " 1contains");
        listCorrectNumberOrderNotImportant.add((codeIndex1));

        boolean codeIndex2 = listCode.contains(listGuess.get(1));
        listCorrectNumberOrderNotImportant.add((codeIndex2));

        boolean codeIndex3 = listCode.contains(listGuess.get(2));
        listCorrectNumberOrderNotImportant.add((codeIndex3));

        boolean codeIndex4 = listCode.contains(listGuess.get(3));
        listCorrectNumberOrderNotImportant.add((codeIndex4));




        int isTrue= Collections.frequency(listCorrectNumberOrderNotImportant,true);

        return isTrue;
    }

    public boolean isExactMatch(String code) {
        guess = player.getGuess();
        boolean isEqual = guess.equals(code);
//        System.out.println("is exact match result" + isEqual);
        return isEqual;
    }


    public static void main(String[] args){
        Mastermind game = new Mastermind();
        game.runGame();

    }
}
