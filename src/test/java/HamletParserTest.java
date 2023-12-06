import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String output = hamletParser.changeHamletToLeon(hamletText);
        Assert.assertTrue(hamletParser.findHamlet(output) == 0);
        System.out.println(output);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String output = hamletParser.changeHoratioToTariq(hamletText);
        Assert.assertTrue(hamletParser.findHoratio(output) == 0);
    }

    @Test
    public void testFindHoratio() {
        String horatioExample = "Horatio. Horatio? Horatio: Horatio! Horatio's Horatio, HORATIO HORATIO:";
        Assert.assertEquals(8, hamletParser.findHoratio(horatioExample));
    }

    @Test
    public void testFindHamlet() {
        String hamletExample = "Hamlet. Hamlet? Hamlet: Hamlet! Hamlet's Hamlet, HAMLET HAMLET:";
        Assert.assertEquals(8, hamletParser.findHamlet(hamletExample));
    }
}