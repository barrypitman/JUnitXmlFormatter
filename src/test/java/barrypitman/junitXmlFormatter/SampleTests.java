package barrypitman.junitXmlFormatter;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test which exercises the different possible outcomes of a jUnit test.
 *
 * @author barry pitman
 * @since 2013/06/17 5:36 PM
 */
public class SampleTests {

    @Test
    public void testSuccess() throws Exception {
       // successful
    }

    @Test
    public void testAssertionError() throws Exception {
        Assert.assertTrue(false);
    }

    @Test
    public void testException() throws Exception {
        throw new IllegalArgumentException();
    }

    @Test
    @Ignore
    public void testIgnored() throws Exception {
        // ignored
    }
}
