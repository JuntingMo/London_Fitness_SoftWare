import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class for account and the corresponding password
 * @author  Jingxuan Wang
 * @version 1.0
 */ 

public class ReadTxtTest {

	@Test
	public void test() {
		assertEquals(ReadTxt.check("UsersTest.txt", "123@bupt.edu.cn", "A12345"), true);
		assertEquals(ReadTxt.check("UsersTest.txt", "123@bupt.edu.cn", "B123456"), false);
		assertEquals(ReadTxt.check("UsersTest.txt", "234@bupt.edu.cn", "B123456"), true);
		assertEquals(ReadTxt.check("UsersTest.txt", "456@bupt.edu.cn", "C1234567"), false);
		assertEquals(ReadTxt.check("UsersTest.txt", "", "B123456"), false);
		assertEquals(ReadTxt.check("UsersTest.txt", "234@bupt.edu.cn", ""), false);
		assertEquals(ReadTxt.check("", "345@qmul.ac.uk", "C1234567"), false);
	}

}
