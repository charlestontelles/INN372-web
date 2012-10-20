package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ValidateCredentialsTest {

	private ValidateCredentials validateCredentials;

	@Before
	public void setUp() throws Exception {
		validateCredentials = new ValidateCredentials();
	}

	@Test
	public void testSetGetEmail() {
		String email = "jay@greenhat.com";
		validateCredentials.setEmail(email);
		assertEquals(validateCredentials.getEmail(), email);
	}
	
	@Test
	public void testSetGetPassword() {
		String password = "1234";
		validateCredentials.setPassword(password);
		assertEquals(validateCredentials.getPassword(), password);
	}

}
