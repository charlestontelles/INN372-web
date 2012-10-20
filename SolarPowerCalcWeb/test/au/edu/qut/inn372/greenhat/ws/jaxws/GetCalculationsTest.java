package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.Calculator;
import au.edu.qut.inn372.greenhat.bean.UserProfile;;

public class GetCalculationsTest {
	
	private UserProfile userProfile;
	private GetCalculations getCalculations;

	@Before
	public void setUp() throws Exception {
		userProfile = new UserProfile();
		getCalculations = new GetCalculations();
	}

	@Test
	public void testSetGetCalculator() {
		getCalculations.setUserProfile(userProfile);
		assertEquals(getCalculations.getUserProfile(), userProfile);
	}

}
