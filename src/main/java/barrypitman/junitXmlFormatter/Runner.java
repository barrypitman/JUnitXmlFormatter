package barrypitman.junitXmlFormatter;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Use JUnitCore to run our tests, attaching {@link AntXmlRunListener} and {@link BasicRunListener}
 *
 * @author barry pitman
 * @since 2013/06/17 5:30 PM
 */
public class Runner {

    public static void main(String... args) {
        Result result = runTests(args);
        System.exit(result.wasSuccessful() ? 0 : 1);
    }

    public static Result runTests(String... args) {
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.addListener(new AntXmlRunListener());
        jUnitCore.addListener(new BasicRunListener());
        Class[] classes = toClasses(args);
        return jUnitCore.run(classes);
    }

    private static Class[] toClasses(String[] args) {
        List<Class> classes = new ArrayList<Class>(args.length);
        for (String arg : args) {
            try {
                classes.add(Class.forName(arg));
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return classes.toArray(new Class[classes.size()]);
    }
}
