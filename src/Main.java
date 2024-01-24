public class Main {
    public static void main(String[] args) {
        OrdinaryCalculator test = new OrdinaryCalculator("2*3*4+(1+2)"); //(1+2)*8*(4+6) не работает
        //Правильный ответ 1 2 + 8 * 4 6 + *
        System.out.println(test.makeInvertPolandNotation());

//((1+2) * (3+4)) + 10
    }
}
