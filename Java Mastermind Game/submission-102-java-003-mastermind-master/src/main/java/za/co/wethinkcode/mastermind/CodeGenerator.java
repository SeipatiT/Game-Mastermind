package za.co.wethinkcode.mastermind;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CodeGenerator {
    private Random random;

    public CodeGenerator(){
        this.random = new Random();
    }

    public CodeGenerator(Random random){
        this.random = random;
    }

    /**
     * Generates a random 4 digit code, using this.random, where each digit is in the range 1 to 8 only.
     * Duplicated digits are allowed.
     * @return the generated 4-digit code
     */
    public String generateCode(){
        //TODO: implement using this.random
        StringBuilder codeString = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            int number = this.random.nextInt(8)
                    +1;
            codeString.append(number);
        }
        String code = codeString.toString();
//        System.out.println(code);
        return code;
    }


}
//     old generate code   List<Integer>ArrayOfCode = new ArrayList<Integer>();
//            ArrayOfCode.add(number);
////            System.out.println("num" + number);
//        String createdCode = String.join(stringList);