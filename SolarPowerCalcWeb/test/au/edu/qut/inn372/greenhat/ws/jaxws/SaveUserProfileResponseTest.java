package au.edu.qut.inn372.greenhat.ws.jaxws;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.bean.UserProfile;;

public class SaveUserProfileResponseTest {
	private SaveUserProfileResponse saveUserProfileResponse;
	private UserProfile userProfile;

	@Before
	public void setUp() throws Exception {
		saveUserProfileResponse = new SaveUserProfileResponse();
		userProfile = new UserProfile();
	}

	@Test
	public void testSetGetUserProfile() {
		saveUserProfileResponse.setUserProfile(userProfile);
		assertEquals(saveUserProfileResponse.getUserProfile(), userProfile);
	}
}
