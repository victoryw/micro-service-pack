package org.victoryw;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestContextManager;

/**
 * Created by victoryw on 1/16/17.
 */
@RunWith(PactRunner.class)
@Provider("test_provider")
@PactFolder("pacts")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProviderPactMainTest {
    //CHECKSTYLE:OFF
    @TestTarget
    public final Target target = new HttpTarget(9000);
    //CHECKSTYLE:ON

    @State("test state")
    public final void toDefaultState() {
        System.out.println("Now service in default state");
    }


    private static TestContextManager testContextManager;

    @BeforeClass
    public static void beforeClass() throws Exception {
        testContextManager = new TestContextManager(ProviderPactMainTest.class);
        testContextManager.beforeTestClass();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        testContextManager.afterTestClass();
    }

    @Before
    public final void setUp() throws Throwable {
        testContextManager.prepareTestInstance(this);
    }
}
