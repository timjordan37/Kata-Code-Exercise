import org.junit.Assert;
import org.junit.Test;

public class PayCalculatorTest {

    //valid user entry check
    @Test
    public void validUserInputReturnTrue () {
        PayCalculator calc = new PayCalculator(17, 23, 20);
        boolean valid = calc.isValidUserInput();
        Assert.assertTrue(valid);
    }

    //valid work hours check
    @Test
    public void validHours() {
        PayCalculator calc = new PayCalculator(18, 26, 19);
        boolean valid = calc.isValidShiftTime();
        Assert.assertTrue("Valid Hours", valid);
    }

    //Paycheck tests for all different rates combined
    @Test
    public void paycheckFor10HoursTotal() {
        PayCalculator calc = new PayCalculator(17, 3, 20);
        int pay = calc.payCalculations();
        Assert.assertEquals("$116 paycheck", 116, pay);
    }

    @Test
    public void oneHourBeforeAndAfterBedtime() {
        PayCalculator calc = new PayCalculator(17, 19, 18);
        int pay = calc.payCalculations();
        Assert.assertEquals("$20 paycheck", 20, pay);
    }

    //Testing pay rate calculation accuracy
    @Test
    public void oneHourOfPayBeforeBedtime() {
        PayCalculator calc = new PayCalculator(17, 18, 20);
        int pay = calc.payCalculations();
        Assert.assertEquals("$12 paycheck", 12, pay);
    }

    @Test
    public void returnsZero() {
        PayCalculator calc = new PayCalculator(13, 19, 20);
        int pay = calc.payCalculations();
        Assert.assertEquals("Invalid Hours", 0, pay);
    }

    @Test
    public void OneHourOfPayAfterBedtime() {
        PayCalculator calc = new PayCalculator(19, 20, 19);
        int pay = calc.payCalculations();
        Assert.assertEquals("$8 paycheck", 8, pay);
    }
}