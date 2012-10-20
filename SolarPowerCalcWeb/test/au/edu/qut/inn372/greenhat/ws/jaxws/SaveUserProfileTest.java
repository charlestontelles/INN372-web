package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.UserProfile;

public class SaveUserProfileTest {

	private SaveUserProfile saveUserProfile;
	private au.edu.qut.inn372.greenhat.bean.UserProfile userProfile;

	@Before
	public void setUp() throws Exception {
		saveUserProfile = new SaveUserProfile();
		userProfile = new UserProfile(); 
	}

	@Test
	public void testSetGetCalculator() {
		saveUserProfile.setUserProfile(userProfile);
		assertEquals(saveUserProfile.getUserProfile(), userProfile);
	}

}
