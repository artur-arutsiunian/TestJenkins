package tests.CRM;

import lib.CoreTestCase;
import lib.ui.CRMPageObject.assets.EditAsset;
import lib.ui.LoginPageObject.Login;
import org.junit.Test;

public class EditAssetTest extends CoreTestCase {

    @Test
    public void testEditAsset() throws InterruptedException {
        Login Login = new Login(driver);
        Login.loginMethod();

        EditAsset EditAsset = new EditAsset(driver);
        EditAsset.editAssetMethod();
    }
}
