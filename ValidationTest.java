import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class for account and password validation.
 * @author  Jingxuan Wang
 * @version 1.0
 */ 
public class ValidationTest {

	@Test
	public void test() {
		Check c = new Check();
		
		//Check the validation of user's email address
		assertEquals(c.checkEmail("abc123"), false);
		assertEquals(c.checkEmail("abc123@"), false);
		assertEquals(c.checkEmail("abc123@gmail"), false);
		assertEquals(c.checkEmail("@gmail"), false);
		assertEquals(c.checkEmail("@gmail.com"), false);
		assertEquals(c.checkEmail("abc123@gmail.com"), true);
		assertEquals(c.checkEmail("12345@qmul.ac.uk"), true);
		
		//Check the validation of user's password
		assertEquals(c.checkPassword("123456"), false);
		assertEquals(c.checkPassword("Aabcde"), false);
		assertEquals(c.checkPassword("123456"), false);
		assertEquals(c.checkPassword("A1234"), false);
		assertEquals(c.checkPassword("A1234567890"), false);
		assertEquals(c.checkPassword("A123456"), true);
	}
}