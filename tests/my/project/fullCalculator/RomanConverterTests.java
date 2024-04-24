package my.project.fullCalculator;

import my.project.fullCalculator.calculators.ConverterRomanSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanConverterTests {

    @Test
    public void shouldConvertToRomanNumbers() {
        Assertions.assertEquals("DXLVII", ConverterRomanSystem.numberToRoman(547));
        Assertions.assertEquals("CMXXXV", ConverterRomanSystem.numberToRoman(935));
        Assertions.assertEquals("DCCCLXXI", ConverterRomanSystem.numberToRoman(871));
        Assertions.assertEquals("MMMCMXCIX", ConverterRomanSystem.numberToRoman(3999));
        Assertions.assertEquals("LV", ConverterRomanSystem.numberToRoman(55));
        Assertions.assertEquals("V", ConverterRomanSystem.numberToRoman(5));
    }

    @Test
    public void shouldConvertToArabicNumbers() {
        Assertions.assertEquals(547, ConverterRomanSystem.romanToInt("DXLVII"));
        Assertions.assertEquals(935,ConverterRomanSystem.romanToInt("CMXXXV"));
        Assertions.assertEquals(871,ConverterRomanSystem.romanToInt("DCCCLXXI"));
        Assertions.assertEquals(3999,ConverterRomanSystem.romanToInt("MMMCMXCIX"));
        Assertions.assertEquals(55,ConverterRomanSystem.romanToInt("LV"));
        Assertions.assertEquals(5,ConverterRomanSystem.romanToInt("V"));
    }


}
