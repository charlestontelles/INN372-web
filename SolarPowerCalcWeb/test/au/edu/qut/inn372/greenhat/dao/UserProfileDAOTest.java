package au.edu.qut.inn372.greenhat.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

//import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
//import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import au.edu.qut.inn372.greenhat.bean.UserProfile;
import au.edu.qut.inn372.greenhat.dao.gae.UserProfileDAOImpl;
/**
 * UserProfile Test Suite
 * 
 * @author Charleston Telles
 *
 */
public class UserProfileDAOTest {
	UserProfileDAO dao;
	UserProfile userProfile;

	
	private final LocalServiceTestHelper helper =
		    new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	@After
	public void tearDown() {
		    helper.tearDown();
	}
	
	@Before
	public void setUp() throws Exception {
		 helper.setUp();
		dao = new UserProfileDAOImpl();
		userProfile = new UserProfile();
		userProfile.setName("Charles");
		userProfile.setEmail("charles@greenhat.com");
		userProfile.setPassword("1234");
		userProfile.setType(1);		
	}
	
	@Test
	public void testSave() {
		dao.save(userProfile);
		userProfile.setKey(null);
		userProfile.setName("juca");
		dao.save(userProfile);
		List<UserProfile> userProfiles = dao.getAll();
		assertEquals(userProfiles.size(), 2);
		
	}
	
	@Test
	public void testGetAll() {
		dao.save(userProfile);
		userProfile.setKey(null);
		userProfile.setName("juca");
		dao.save(userProfile);
		List<UserProfile> userProfiles = dao.getAll();
		assertEquals(userProfiles.size(), 2);
		
	}
	
	@Test
	public void testGetByEmail() {
		dao.save(userProfile);
		userProfile.setKey(null);
		userProfile.setEmail("juca@greenhat.com");
		dao.save(userProfile);
		List<UserProfile> userProfiles = dao.getAll();
		UserProfile userProfile = dao.getByEmail("charles@greenhat.com");
		assertEquals(userProfile.getName(), "Charles");
		
	}
	
	@Test
	public void testValidateCredential() {
		dao.save(userProfile);
		userProfile.setKey(null);
		userProfile.setEmail("juca@greenhat.com");
		dao.save(userProfile);
		List<UserProfile> userProfiles = dao.getAll();
		UserProfile userProfile = dao.getByEmail("charles@greenhat.com");
		UserProfile result = dao.validateCredential("charles@greenhat.com", "1234");
		assertEquals(result.getKey()!=null, true);
		
	}
	
	@Test
	public void testRemove() {
		dao.save(userProfile);
		userProfile.setKey(null);
		userProfile.setEmail("juca@greenhat.com");
		dao.save(userProfile);
		List<UserProfile> userProfiles = dao.getAll();
		dao.remove(userProfile);
		userProfiles = dao.getAll();
		assertEquals(userProfiles.size(), 1);
		
	}
	
}
