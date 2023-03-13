package za.co.wethinkcode.mastermind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CodeGeneratorTest {
    @Test
    /* this tests length */
    public void lengthIsFourDigits(){
        CodeGenerator codeGenerator = new CodeGenerator();
        String code = codeGenerator.generateCode();
        int codeLength = code.length();
        assertEquals(4, codeLength);
    }
}
