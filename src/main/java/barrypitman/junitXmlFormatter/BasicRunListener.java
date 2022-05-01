package barrypitman.junitXmlFormatter;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;


/**
 * The {@code BasicRunListener} reports only the test summary to stdout.
 *
 * @author Barry Pitman
 * @since 2013/06/17 5:30 PM
 */
public class BasicRunListener extends RunListener {

    @Override
    public void testRunStarted(Description description) throws Exception {
        System.out.println("Starting test run: " + description.getDisplayName() + ", " + description.testCount() + " tests");
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        float elapsed = Math.round(result.getRunTime() / 100000) * 100;

        System.out.println("Finished test run: " + result.getFailureCount() + " failures, " +
                result.getIgnoreCount() + " ignored, " +
                (result.getRunCount() + result.getIgnoreCount())+ " total. " +
                "Elapsed: " + elapsed + " seconds");

        System.out.println("Failed tests: \n");
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            failure.getException().printStackTrace(System.out);
            System.out.println();
            System.out.println();
        }
    }
}