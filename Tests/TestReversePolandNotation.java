import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestReversePolandNotation {
    OrdinaryCalculator test1;
    OrdinaryCalculator test2;
    OrdinaryCalculator test3;
    OrdinaryCalculator test4;
    OrdinaryCalculator test5;
    OrdinaryCalculator test6;

    @BeforeEach
    public void createCalculator() {
        String expression1 = "((1+2)*(3+4))+10";
        test1 = new OrdinaryCalculator(expression1);
        String expression2 = "(1+2)*8*(4+6)";
        test2 = new OrdinaryCalculator(expression2);
        String expression3 = "(2+1)*(3+1)+2+3";
        test3 = new OrdinaryCalculator(expression3);
        String expression4 = "2*3*4+(1+2)";
        test4 = new OrdinaryCalculator(expression4);
        String expression5 = "2*3*4*5*6";
        test5 = new OrdinaryCalculator(expression5);
        String expression6 = "(2*3)+1*(3+2*5)";
        test6 = new OrdinaryCalculator(expression6);
    }

    @Test
    public void shouldReturnCorrectPolishNotationForNumbersLessThen10() {
        Assertions.assertEquals("12+34+*10+", test1.makeInvertPolandNotation());
        Assertions.assertEquals("12+8*46+*", test2.makeInvertPolandNotation());
        Assertions.assertEquals("21+31+*2+3+", test3.makeInvertPolandNotation());
        Assertions.assertEquals("23*4*12++", test4.makeInvertPolandNotation());
        Assertions.assertEquals("23*4*5*6*", test5.makeInvertPolandNotation());
        Assertions.assertEquals("23*1325*+*+", test6.makeInvertPolandNotation());
    }

}
