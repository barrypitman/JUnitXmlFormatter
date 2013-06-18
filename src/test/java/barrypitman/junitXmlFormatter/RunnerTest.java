package barrypitman.junitXmlFormatter;

import org.junit.Test;
import org.junit.runner.Result;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author barry pitman
 * @since 2013/06/17 5:03 PM
 */
public class RunnerTest {

    @Test
    public void testRunnerWithSampleTests() throws Exception {
        System.setProperty("org.schmant.task.junit4.target", "junit_report.xml");
        Result result = Runner.runTests(SampleTests.class.getName());
        assertThat(result.getFailureCount(), equalTo(2));
        assertThat(result.getIgnoreCount(), equalTo(1));
        assertThat(result.getRunCount(), equalTo(3));
    }
}
