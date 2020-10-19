import org.junit.Assert;
import org.junit.Test;

public class PayCalculatorTest {

    //valid user entry check
    @Test
    public void validUserInputReturnTrue () {
        PayCalculator sitter = new PayCalculator(17, 23, 20);
        boolean valid = sitter.isValidUserInput();
        Assert.assertEquals(true, valid);
    }

    //valid work hours check
    @Test
    public void validHours() {
        PayCalculator sitter = new PayCalculator(18, 26, 19);
        boolean valid = sitter.isValidShiftTime();
        Assert.assertEquals("Valid Hours" , true, valid);
    }

    //Paycheck tests for all different rates combined
    @Test
    public void paycheckFor10HoursTotal() {
        PayCalculator sitter = new PayCalculator(17, 3, 20);
        int pay = sitter.payCalculations();
        Assert.assertEquals("$116 paycheck", 116, pay);
    }

    @Test
    public void oneHourBeforeAndAfterBedtime() {
        PayCalculator sitter = new PayCalculator(17, 19, 18);
        int pay = sitter.payCalculations();
        Assert.assertEquals("$20 paycheck", 20, pay);
    }

    //Testing pay rate calculation accuracy
    @Test
    public void oneHourOfPayBeforeBedtime() {
        PayCalculator sitter = new PayCalculator(17, 18, 20);
        int pay = sitter.payCalculations();
        Assert.assertEquals("$12 paycheck", 12, pay);
    }

    @Test
    public void returnsZero() {
        PayCalculator sitter = new PayCalculator(13, 19, 20);
        int pay = sitter.payCalculations();
        Assert.assertEquals("Invalid Hours", 0, pay);
    }

    @Test
    public void OneHourOfPayAfterBedtime() {
        PayCalculator sitter = new PayCalculator(19, 20, 19);
        int pay = sitter.payCalculations();
        Assert.assertEquals("$8 paycheck", 8, pay);
    }
}