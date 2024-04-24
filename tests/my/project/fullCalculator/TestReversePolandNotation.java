package my.project.fullCalculator;

import my.project.fullCalculator.calculators.OrdinaryCalculator;
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
    OrdinaryCalculator test23;
    OrdinaryCalculator test24;
    OrdinaryCalculator test25;
    OrdinaryCalculator test26;
    OrdinaryCalculator test27;
    OrdinaryCalculator test28;
    OrdinaryCalculator test29;
    OrdinaryCalculator test30;
    OrdinaryCalculator test31;
    OrdinaryCalculator test32;
    OrdinaryCalculator test33;



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
        String expression9 = "2*1+(2*(1+2)/3)/(3*9)";
        test9 = new OrdinaryCalculator(expression9);
        String expression10 = "(2*1)/(2+1)/(2/1)*(2*3/3)";
        test10 = new OrdinaryCalculator(expression10);
        String expression11 = "2*1+(2*(1+8)/3)/3*9*((1+2)*3/1)";
        test11 = new OrdinaryCalculator(expression11);
        String expression31 = "(-2.1)+(-2.2)+(-8.5)+(-7.3)-(-12.2)*15.2";
        test31 = new OrdinaryCalculator(expression31);
        String expression32 = "((2.5+2.5)*(2.5+2.5)/2.5)";
        test32 = new OrdinaryCalculator(expression32);
        String expression33 = "(1.2)+(2.1)-(-3.2)*15.1+(-2.2)";
        test33 = new OrdinaryCalculator(expression33);
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
        Assertions.assertEquals("2 1 * 2 1 2 + * 3 / 3 9 * / +", test9.makeInvertPolandNotation());
        Assertions.assertEquals("2 1 * 2 1 + / 2 1 / / 2 3 * 3 / *", test10.makeInvertPolandNotation());
        Assertions.assertEquals("2 1 * 2 1 8 + * 3 / 3 / 9 * 1 2 + 3 * 1 / * +", test11.makeInvertPolandNotation());
        Assertions.assertEquals("2.1 - 2.2 - + 8.5 - + 7.3 - + 12.2 - 15.2 * -", test31.makeInvertPolandNotation());
        Assertions.assertEquals("2.5 2.5 + 2.5 2.5 + * 2.5 /", test32.makeInvertPolandNotation());
        Assertions.assertEquals("1.2 2.1 + 3.2 - 15.1 * - 2.2 - +", test33.makeInvertPolandNotation());
    }

    @BeforeEach
    public void createCalculatorForNumbersMoreThen10() {
        String expression1 = "((10+20)*(30+40))+10";
        test12 = new OrdinaryCalculator(expression1);
        String expression2 = "(15+24)*81*(40+66)";
        test13 = new OrdinaryCalculator(expression2);
        String expression3 = "10+20+30*40/50";
        test14 = new OrdinaryCalculator(expression3);
        String expression4 = "100/100+1154+1000*(10000-5000)*4532";
        test15 = new OrdinaryCalculator(expression4);
        String expression5 = "94-((54*32)*(2901+12))*(23-1)*(8+3)*(12+12)";
        test16 = new OrdinaryCalculator(expression5);
        String expression6 = "(132+(42+5+265)-3)+(63+81)";
        test17 = new OrdinaryCalculator(expression6);
        String expression7 = "15/(7-(1+1))*3-(2+(1+1))*15/(7-(200+1))*3-(2+(1+1))*(15/(7-(1+1)))*3-(2+(1+1))+15/(7-(1+1))*3-(2+(1+1))"; //NO
        test18 = new OrdinaryCalculator(expression7);
        String expression8 = "3-(2+(1+1))*(15/(7-(1+1)))*3-(2+(1+1))+15/(7-(1+1))*3-(2+(1+1))";
        test19 = new OrdinaryCalculator(expression8);
        String expression9 = "3-(2+(1+1))";
        test20 = new OrdinaryCalculator(expression9);
        String expression10 = "(2^3)^4";
        test21 = new OrdinaryCalculator(expression10);
        String expression11 = "(2*3)+~8-2";
        test22 = new OrdinaryCalculator(expression11);
        String expression12 = "~8-~3";
        test23 = new OrdinaryCalculator(expression12);
    }

    @Test
    public void shouldReturnCorrectPolishNotationForNumbersMoreThen10() {
        Assertions.assertEquals("10 20 + 30 40 + * 10 +", test12.makeInvertPolandNotation());
        Assertions.assertEquals("15 24 + 81 * 40 66 + *", test13.makeInvertPolandNotation());
        Assertions.assertEquals("10 20 + 30 40 * 50 / +", test14.makeInvertPolandNotation());
        Assertions.assertEquals("100 100 / 1154 + 1000 10000 5000 - * 4532 * +", test15.makeInvertPolandNotation());
        Assertions.assertEquals("94 54 32 * 2901 12 + * 23 1 - * 8 3 + * 12 12 + * -", test16.makeInvertPolandNotation());
        Assertions.assertEquals("132 42 5 + 265 + + 3 - 63 81 + +", test17.makeInvertPolandNotation());
        Assertions.assertEquals("15 7 1 1 + - / 3 * 2 1 1 + + 15 * 7 200 1 + - / 3 * - 2 1 1 + + 15 7 1 1 + - / * 3 * - 2 1 1 + + - 15 7 1 1 + - / 3 * + 2 1 1 + + -", test18.makeInvertPolandNotation());
        Assertions.assertEquals("3 2 1 1 + + 15 7 1 1 + - / * 3 * - 2 1 1 + + - 15 7 1 1 + - / 3 * + 2 1 1 + + -", test19.makeInvertPolandNotation());
        Assertions.assertEquals("3 2 1 1 + + -", test20.makeInvertPolandNotation());
        Assertions.assertEquals("2 3 ^ 4 ^", test21.makeInvertPolandNotation());
        Assertions.assertEquals("2 3 * ~8 + 2 -", test22.makeInvertPolandNotation());
        Assertions.assertEquals("~8 ~3 -", test23.makeInvertPolandNotation());

    }


    @Test
    public void shouldSolveExpression() {
        Assertions.assertEquals(31, test1.solvePolandNotation());
        Assertions.assertEquals(240, test2.solvePolandNotation());
        Assertions.assertEquals(17, test3.solvePolandNotation());
        Assertions.assertEquals(27, test4.solvePolandNotation());
        Assertions.assertEquals(720, test5.solvePolandNotation());
        Assertions.assertEquals(19, test6.solvePolandNotation());
        Assertions.assertEquals(6, test7.solvePolandNotation());
        Assertions.assertEquals(240, test8.solvePolandNotation());
        Assertions.assertEquals(2.074074074074074, test9.solvePolandNotation());
        Assertions.assertEquals(0.6666666666666666, test10.solvePolandNotation());
        Assertions.assertEquals(164, test11.solvePolandNotation());
        Assertions.assertEquals(2110, test12.solvePolandNotation());
        Assertions.assertEquals(334854, test13.solvePolandNotation());
        Assertions.assertEquals(54, test14.solvePolandNotation());
        Assertions.assertEquals(22_660_001_155L, test15.solvePolandNotation());
        Assertions.assertEquals(-29_235_520_418L, test16.solvePolandNotation());
        Assertions.assertEquals(585, test17.solvePolandNotation());
        Assertions.assertEquals(-32, test19.solvePolandNotation());
        Assertions.assertEquals(-1, test20.solvePolandNotation());
        Assertions.assertEquals(4096, test21.solvePolandNotation());
        Assertions.assertEquals(-4, test22.solvePolandNotation());
        Assertions.assertEquals(-5, test23.solvePolandNotation());
    }

    @BeforeEach
    public void createCalculatorForFloatNumbers() {
        String expression24 = "1.2+1.2";
        test24 = new OrdinaryCalculator(expression24);
        String expression25 = "(1.2+2.123)+3*2.5-51.2";
        test25 = new OrdinaryCalculator(expression25);
        String expression26 = "43.3/21.1+23.12^3.3";
        test26 = new OrdinaryCalculator(expression26);
        String expression27 = "1.0^1^1^1.0";
        test27 = new OrdinaryCalculator(expression27);
        String expression28 = "-30.23-65.32";
        test28 = new OrdinaryCalculator(expression28);
        String expression29 = "(1.2)+(2.1)-(~3.2)*15.1+(~2.2)";
        test29 = new OrdinaryCalculator(expression29);
        String expression30 = "0.0+0.0+900/23.12";
        test30 = new OrdinaryCalculator(expression30);
    }

    @Test
    public void shouldSolveFloatExpression() {
        Assertions.assertEquals(2.4, test24.solvePolandNotation());
        Assertions.assertEquals(-40.377, test25.solvePolandNotation());
        Assertions.assertEquals(31709.394217448433, test26.solvePolandNotation());
        Assertions.assertEquals(1.0, test27.solvePolandNotation());
        Assertions.assertEquals(-95.55, test28.solvePolandNotation());
        Assertions.assertEquals(49.419999999999995, test29.solvePolandNotation());
        Assertions.assertEquals(38.92733564013841, test30.solvePolandNotation());

    }

}
