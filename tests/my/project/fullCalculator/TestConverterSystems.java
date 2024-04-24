package my.project.fullCalculator;

import my.project.fullCalculator.calculators.ConvertToDifferentSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestConverterSystems {


    @Test
    public void shouldConvertFrom2SystemTo10System() {
        int systemFrom = 2;
        Assertions.assertEquals(10, ConvertToDifferentSystem.convertFromDiffSystemTo10("1010", systemFrom));
        Assertions.assertEquals(0, ConvertToDifferentSystem.convertFromDiffSystemTo10("0", systemFrom));
        Assertions.assertEquals(4, ConvertToDifferentSystem.convertFromDiffSystemTo10("100", systemFrom));
        Assertions.assertEquals(-4, ConvertToDifferentSystem.convertFromDiffSystemTo10("-100", systemFrom));
        Assertions.assertEquals(713493, ConvertToDifferentSystem.convertFromDiffSystemTo10("10101110001100010101", systemFrom));
        Assertions.assertEquals(128, ConvertToDifferentSystem.convertFromDiffSystemTo10("10000000", systemFrom));
        Assertions.assertEquals(0, ConvertToDifferentSystem.convertFromDiffSystemTo10("00000000", systemFrom));
    }

    @Test
    public void shouldConvertFrom3SystemTo10System() {
        int systemFrom = 3;
        Assertions.assertEquals(5, ConvertToDifferentSystem.convertFromDiffSystemTo10("012", systemFrom));
        Assertions.assertEquals(0, ConvertToDifferentSystem.convertFromDiffSystemTo10("0", systemFrom));
        Assertions.assertEquals(12196, ConvertToDifferentSystem.convertFromDiffSystemTo10("121201201", systemFrom));
        Assertions.assertEquals(21, ConvertToDifferentSystem.convertFromDiffSystemTo10("210", systemFrom));
        Assertions.assertEquals(1395009, ConvertToDifferentSystem.convertFromDiffSystemTo10("2121212121000", systemFrom));
        Assertions.assertEquals(0, ConvertToDifferentSystem.convertFromDiffSystemTo10("00000000", systemFrom));
    }

    @Test
    public void shouldConvertFrom10SystemTo10System() {
        int systemFrom = 10;
        Assertions.assertEquals(55, ConvertToDifferentSystem.convertFromDiffSystemTo10("55", systemFrom));
        Assertions.assertEquals(0, ConvertToDifferentSystem.convertFromDiffSystemTo10("0", systemFrom));
        Assertions.assertEquals(45165415, ConvertToDifferentSystem.convertFromDiffSystemTo10("45165415", systemFrom));
        Assertions.assertEquals(212121000, ConvertToDifferentSystem.convertFromDiffSystemTo10("212121000", systemFrom));
        Assertions.assertEquals(0, ConvertToDifferentSystem.convertFromDiffSystemTo10("00000000", systemFrom));
        Assertions.assertEquals(-101, ConvertToDifferentSystem.convertFromDiffSystemTo10("-101", systemFrom));
    }

    @Test
    public void shouldConvertFrom16SystemTo10System() {
        int systemFrom = 16;
        Assertions.assertEquals(587, ConvertToDifferentSystem.convertFromDiffSystemTo10("24B", systemFrom));
        Assertions.assertEquals(0, ConvertToDifferentSystem.convertFromDiffSystemTo10("0", systemFrom));
        Assertions.assertEquals(150474, ConvertToDifferentSystem.convertFromDiffSystemTo10("24BCA", systemFrom));
        Assertions.assertEquals(1715004, ConvertToDifferentSystem.convertFromDiffSystemTo10("1A2B3C", systemFrom));
        Assertions.assertEquals(26, ConvertToDifferentSystem.convertFromDiffSystemTo10("1A", systemFrom));
    }

    @Test
    public void shouldConvertFrom26SystemTo10System() {
        int systemFrom = 26;
        Assertions.assertEquals(-1467, ConvertToDifferentSystem.convertFromDiffSystemTo10("-24B", systemFrom));
        Assertions.assertEquals(0, ConvertToDifferentSystem.convertFromDiffSystemTo10("0", systemFrom));
        Assertions.assertEquals(992014, ConvertToDifferentSystem.convertFromDiffSystemTo10("24BCA", systemFrom));
        Assertions.assertEquals(238358, ConvertToDifferentSystem.convertFromDiffSystemTo10("DEFG", systemFrom));
        Assertions.assertEquals(36, ConvertToDifferentSystem.convertFromDiffSystemTo10("1A", systemFrom));
        Assertions.assertEquals(3_225_574_966L, ConvertToDifferentSystem.convertFromDiffSystemTo10("ABCDEFG", systemFrom));
    }

    @Test
    public void shouldConvertFrom10SystemTo2System() {
        int systemTo = 2;
        Assertions.assertEquals("-1010", ConvertToDifferentSystem.convertToDiffSystemFrom10(-10, systemTo));
        Assertions.assertEquals("0", ConvertToDifferentSystem.convertToDiffSystemFrom10(0, systemTo));
        Assertions.assertEquals("100011011100100000", ConvertToDifferentSystem.convertToDiffSystemFrom10(145184, systemTo));
        Assertions.assertEquals("1010110110011", ConvertToDifferentSystem.convertToDiffSystemFrom10(5555, systemTo));
    }

    @Test
    public void shouldConvertFrom10SystemTo7System() {
        int systemTo = 7;
        Assertions.assertEquals("13", ConvertToDifferentSystem.convertToDiffSystemFrom10(10, systemTo));
        Assertions.assertEquals("0", ConvertToDifferentSystem.convertToDiffSystemFrom10(0, systemTo));
        Assertions.assertEquals("1143164", ConvertToDifferentSystem.convertToDiffSystemFrom10(145184, systemTo));
        Assertions.assertEquals("22124", ConvertToDifferentSystem.convertToDiffSystemFrom10(5555, systemTo));
    }

    @Test
    public void shouldConvertFrom10SystemTo16System() {
        int systemTo = 16;
        Assertions.assertEquals("A", ConvertToDifferentSystem.convertToDiffSystemFrom10(10, systemTo));
        Assertions.assertEquals("0", ConvertToDifferentSystem.convertToDiffSystemFrom10(0, systemTo));
        Assertions.assertEquals("23720", ConvertToDifferentSystem.convertToDiffSystemFrom10(145184, systemTo));
        Assertions.assertEquals("15B3", ConvertToDifferentSystem.convertToDiffSystemFrom10(5555, systemTo));
    }

    @Test
    public void shouldConvertFrom10SystemTo26System() {
        int systemTo = 26;
        Assertions.assertEquals("A", ConvertToDifferentSystem.convertToDiffSystemFrom10(10, systemTo));
        Assertions.assertEquals("0", ConvertToDifferentSystem.convertToDiffSystemFrom10(0, systemTo));
        Assertions.assertEquals("86K0", ConvertToDifferentSystem.convertToDiffSystemFrom10(145184, systemTo));
        Assertions.assertEquals("85H", ConvertToDifferentSystem.convertToDiffSystemFrom10(5555, systemTo));
    }



}
