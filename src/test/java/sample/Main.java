package sample;

import com.google.common.collect.Lists;
import org.testng.TestNG;

import java.util.List;

public class Main {
    public static boolean isDocker = false;
    public static void main(String[] args) {
        isDocker = true;
        System.out.println("Args[0] = " + args[0]);
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add(System.getProperty("user.dir")+ args[0]);
        testng.setTestSuites(suites);
        testng.run();

    }
}
