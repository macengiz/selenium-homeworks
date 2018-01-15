package homeworks;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertionTest {

	@Test

	public static void test() {

		SoftAssert softAssert = new SoftAssert();
		System.out.println("run the first verification");
		softAssert.assertTrue(true);
		System.out.println("run the second verification");
		softAssert.assertTrue(false);
		System.out.println("done");
		softAssert.assertAll();
	}

}
