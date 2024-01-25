import org.junit.jupiter.api.*;

public class TestReversePolandNotation {
    OrdinaryCalculator test1;
    OrdinaryCalculator test2;
    OrdinaryCalculator test3;
    OrdinaryCalculator test4;
    OrdinaryCalculator test5;
    OrdinaryCalculator test6;
    OrdinaryCalculator test7;
    OrdinaryCalculator test8;
    OrdinaryCalculator test9;
    OrdinaryCalculator test10;
    OrdinaryCalculator test11;
    OrdinaryCalculator test12;
    OrdinaryCalculator test13;
    OrdinaryCalculator test14;
    OrdinaryCalculator test15;
    OrdinaryCalculator test16;
    OrdinaryCalculator test17;
    OrdinaryCalculator test18;
    OrdinaryCalculator test19;
    OrdinaryCalculator test20;
    OrdinaryCalculator test21;
    OrdinaryCalculator test22;

    @BeforeEach
    public void createCalculatorForNumbersLessThen10() {
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
        String expression7 = "1+2+2+2+3-1-1-2";
        test7 = new OrdinaryCalculator(expression7);
        String expression8 = "1*2*3*4*5*6/3";
        test8 = new OrdinaryCalculator(expression8);
        String expression9 = "2*1+(2*(1+2)/3)/3*9";
        test9 = new OrdinaryCalculator(expression9);
        String expression10 = "(2*1)/(2+1)/(2/1)*(2*3/3)";
        test10 = new OrdinaryCalculator(expression10);
        String expression11 = "2*1+(2*(1+2)/3)/3*9*((1+2)*3/1)";
        test11 = new OrdinaryCalculator(expression11);
    }



    @Test
    public void shouldReturnCorrectPolishNotationForNumbersLessThen10() {
        Assertions.assertEquals("1 2 + 3 4 + * 10 +", test1.makeInvertPolandNotation());
        Assertions.assertEquals("1 2 + 8 * 4 6 + *", test2.makeInvertPolandNotation());
        Assertions.assertEquals("2 1 + 3 1 + * 2 + 3 +", test3.makeInvertPolandNotation());
        Assertions.assertEquals("2 3 * 4 * 1 2 + +", test4.makeInvertPolandNotation());
        Assertions.assertEquals("2 3 * 4 * 5 * 6 *", test5.makeInvertPolandNotation());
        Assertions.assertEquals("2 3 * 1 3 2 5 * + * +", test6.makeInvertPolandNotation());
        Assertions.assertEquals("1 2 + 2 + 2 + 3 + 1 - 1 - 2 -", test7.makeInvertPolandNotation());
        Assertions.assertEquals("1 2 * 3 * 4 * 5 * 6 * 3 /", test8.makeInvertPolandNotation());
        Assertions.assertEquals("2 1 * 2 1 2 + * 3 / 3 / 9 * +", test9.makeInvertPolandNotation());
        Assertions.assertEquals("2 1 * 2 1 + / 2 1 / / 2 3 * 3 / *", test10.makeInvertPolandNotation());
        Assertions.assertEquals("2 1 * 2 1 2 + * 3 / 3 / 9 * 1 2 + 3 * 1 / * +", test11.makeInvertPolandNotation());
    }
    @BeforeEach
    public void createCalculatorForNumbersMoreThen10() {
        String expression1 = "((10+20)*(30+40))+10";
        test12 = new OrdinaryCalculator(expression1);
        String expression2 = "(15+24)*81*(40+66)";
        test13 = new OrdinaryCalculator(expression2);
        String expression3 = "(2+1)*(3+1)+2+3";
        test14 = new OrdinaryCalculator(expression3);
        String expression4 = "2*3*4+(1+2)";
        test15 = new OrdinaryCalculator(expression4);
        String expression5 = "2*3*4*5*6";
        test16 = new OrdinaryCalculator(expression5);
        String expression6 = "(2*3)+1*(3+2*5)";
        test17 = new OrdinaryCalculator(expression6);
        String expression7 = "1+2+2+2+3-1-1-2";
        test18 = new OrdinaryCalculator(expression7);
        String expression8 = "1*2*3*4*5*6/3";
        test19 = new OrdinaryCalculator(expression8);
        String expression9 = "2*1+(2*(1+2)/3)/3*9";
        test20 = new OrdinaryCalculator(expression9);
        String expression10 = "(2*1)/(2+1)/(2/1)*(2*3/3)";
        test21 = new OrdinaryCalculator(expression10);
        String expression11 = "2*1+(2*(1+2)/3)/3*9*((1+2)*3/1)";
        test22 = new OrdinaryCalculator(expression11);
    }
    @Test
    public void shouldReturnCorrectPolishNotationForNumbersMoreThen10() {
/*        Assertions.assertEquals("1020+3040+*10+", test12.makeInvertPolandNotation());
        Assertions.assertEquals("1524+81*4066+*", test13.makeInvertPolandNotation());
        Assertions.assertEquals("21+31+*2+3+", test14.makeInvertPolandNotation());
        Assertions.assertEquals("23*4*12++", test15.makeInvertPolandNotation());
        Assertions.assertEquals("23*4*5*6*", test16.makeInvertPolandNotation());
        Assertions.assertEquals("23*1325*+*+", test17.makeInvertPolandNotation());
        Assertions.assertEquals("12+2+2+3+1-1-2-", test18.makeInvertPolandNotation());
        Assertions.assertEquals("12*3*4*5*6*3/", test19.makeInvertPolandNotation());
        Assertions.assertEquals("21*212+*3/3/9*+", test20.makeInvertPolandNotation());
        Assertions.assertEquals("21*21+/21//23*3/*", test21.makeInvertPolandNotation());
        Assertions.assertEquals("21*212+*3/3/9*12+3*1/*+", test22.makeInvertPolandNotation());*/
    }

}
