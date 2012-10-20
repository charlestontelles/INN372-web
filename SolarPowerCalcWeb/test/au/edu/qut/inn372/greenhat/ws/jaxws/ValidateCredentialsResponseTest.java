package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.UserProfile;

public class ValidateCredentialsResponseTest {
	private ValidateCredentialsResponse validateCredentialsResponse;
	private UserProfile result;

	@Before
	public void setUp() throws Exception {
		validateCredentialsResponse = new ValidateCredentialsResponse();
		result = new UserProfile();
	}

	@Test
	public void testSetGetResult() {
		validateCredentialsResponse.setResult(result);
		assertEquals(validateCredentialsResponse.getResult(), result);
	}
}
