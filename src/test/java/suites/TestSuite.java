package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.CRM.EditAssetTest;
import tests.CRM.MoveToInfoTabInAssetTest;

@RunWith(Suite.class)

@Suite.SuiteClasses(value = {
        EditAssetTest.class,
        MoveToInfoTabInAssetTest.class,
})

public class TestSuite {}
