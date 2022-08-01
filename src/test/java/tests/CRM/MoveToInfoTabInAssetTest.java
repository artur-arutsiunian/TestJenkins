package tests.CRM;

import lib.CoreTestCase;
import lib.ui.CRMPageObject.assets.MoveToInfoTabInAsset;
import lib.ui.LoginPageObject.Login;
import org.junit.Test;

public class MoveToInfoTabInAssetTest extends CoreTestCase {

    @Test
    public void testMoveToInfoTabInAsset() throws InterruptedException {
        Login Login = new Login(driver);
        Login.loginMethod();

        MoveToInfoTabInAsset MoveToInfoTabInAsset = new MoveToInfoTabInAsset(driver);
        MoveToInfoTabInAsset.moveToInfoTabInAssetMethod();
    }
}
