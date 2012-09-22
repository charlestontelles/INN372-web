package au.edu.qut.inn372.greenhat.bean;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import au.edu.qut.inn372.greenhat.util.Util;

public class UserProfileTest {
	UserProfile userProfile;
	@Before
	public void setUp() throws Exception {
		userProfile = new UserProfile();
		userProfile.setKey(null);
		userProfile.setName("Charles");
		userProfile.setEmail("charles@greenhat.com");
		userProfile.setPassword("1234");
		userProfile.setType(1);
	}
	
	@Test
	public void testSerialize() throws IOException, ClassNotFoundException {
		UserProfile user2;
		String data1 = Util.serialize(userProfile);
		user2 = (UserProfile)Util.unserialize(data1);
		assertEquals(user2.getName(), "Charles");
	}
}
