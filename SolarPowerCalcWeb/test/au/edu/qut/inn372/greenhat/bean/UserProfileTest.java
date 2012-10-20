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
	
	@Test
	public void testSetGetKey(){
		assertEquals(null, userProfile.getKey());
		userProfile.setKey("userKey");
		assertEquals("userKey", userProfile.getKey());
	}
	
	@Test
	public void testSetGetName(){
		assertEquals("Charles", userProfile.getName());
		userProfile.setName("Martin");
		assertEquals("Martin", userProfile.getName());
	}
	
	@Test
	public void testSetGetEmail(){
		assertEquals("charles@greenhat.com", userProfile.getEmail());
		userProfile.setEmail("martin@greenhat.com");
		assertEquals("martin@greenhat.com", userProfile.getEmail());
	}
	
	@Test
	public void testSetGetPassword(){
		assertEquals("1234", userProfile.getPassword());
		userProfile.setPassword("4321");
		assertEquals("4321", userProfile.getPassword());
	}
	
	@Test
	public void testSetGetType(){
		assertEquals(1, userProfile.getType());
		userProfile.setType(2);
		assertEquals(2, userProfile.getType());
	}
}
