


public class ConvertToDifferentSystem {
    int number;
    int system;

    public ConvertToDifferentSystem(int number, int system) {
        this.number = number;
        this.system = system;
    }

    public String convertToDiffSystem() {
        String result = "";
        int surplus;

        while (number > 1) {
            surplus = number % system;
            number = number / system;
            result += surplus;
        }

        StringBuilder revResult = new StringBuilder(result).reverse();
        return number + revResult.toString();
    }





}
