package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("ABC");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestM() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMM");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestMix() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MM123");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestC() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CCC");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestX() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("XXX");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestI() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("III");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestD() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DDD");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestE() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("EEE");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestY() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("YY");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestZ() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("ZZ");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestJ() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("JJ");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestK() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("KK");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestEDC() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("EDC");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestZYX() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("ZYX");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestKJI() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("KJI");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestRightOrder() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("DMM");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTestRightOrder2() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("XED");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberlowercase() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("mmd");
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("CDE");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("3000");
    }

    @Test
    public void SampleTestToArabic() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("M");
        assertEquals(converter.toArabic(), 1000);
    }

    @Test
    public void SampleTestToArabic2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MMK");
        assertEquals(converter.toArabic(), 2006);
    }

    @Test
    public void SampleTestToArabic3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("XXKJ");
        assertEquals(converter.toArabic(), 29);
    }

    @Test
    public void SampleTestToElbonian() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("60");
        assertEquals(converter.toElbonian(), "Z");
    }

    @Test
    public void SampleTestToElbonian2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("903");
        assertEquals(converter.toElbonian(), "EDJ");
    }

    @Test
    public void SampleTestElbonian3() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("2999");
        assertEquals(converter.toElbonian(), "MMEDZYKJ");
    }

    @Test
    public void SampleTestElbonian4() throws MalformedNumberException, ValueOutOfBoundsException{
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1234");
        assertEquals(converter.toElbonian(), "MCCYJI");
    }


    // TODO Add more test cases
}
