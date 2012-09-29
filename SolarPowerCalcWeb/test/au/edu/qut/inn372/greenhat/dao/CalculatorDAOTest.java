package au.edu.qut.inn372.greenhat.dao;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import au.edu.qut.inn372.greenhat.bean.Calculator;
import au.edu.qut.inn372.greenhat.bean.Customer;
import au.edu.qut.inn372.greenhat.bean.Equipment;
import au.edu.qut.inn372.greenhat.bean.UserProfile;
import au.edu.qut.inn372.greenhat.dao.gae.CalculatorDAOImpl;
import au.edu.qut.inn372.greenhat.dao.gae.EquipmentDAOImpl;
import au.edu.qut.inn372.greenhat.dao.gae.LocationDAOImpl;
import au.edu.qut.inn372.greenhat.dao.gae.UserProfileDAOImpl;

/**
 * CalculatorDAO TestSuite
 * 
 * ATENTION: to run GAE DS unit tests we must add 2 libs
 * FROM: 
 * C:\apps\eclipse\plugins\com.google.appengine.eclipse.sdkbundle_1.7.0\appengine-java-sdk-1.7.0\lib\testing
 * and
 * C:\apps\eclipse\plugins\com.google.appengine.eclipse.sdkbundle_1.7.0\appengine-java-sdk-1.7.0\lib\impl
 * TO:
 * C:\Users\Charleston\git\INN372-web\SolarPowerCalcWeb\war\WEB-INF\lib
 * LIBS:
 * appengine-api-stubs.jar
 * appengine-testing.jar
 * 
 * @author Charleston Telles
 *
 */
public class CalculatorDAOTest {
	CalculatorDAO dao;
	Calculator calculator;
	UserProfileDAO userProfileDAO;
	EquipmentDAO equipmentDAO;
	LocationDAO locationDAO;
	
	

	private final LocalServiceTestHelper helper =
		    new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	@After
	public void tearDown() {
		    helper.tearDown();
	}
	
	@Before
	public void setUp() throws Exception {
		helper.setUp();
		dao = new CalculatorDAOImpl();
		userProfileDAO = new UserProfileDAOImpl();
		equipmentDAO = new EquipmentDAOImpl();
		locationDAO = new LocationDAOImpl();
		UserProfile userProfile = new UserProfile();
		userProfile.setName("Charles");
		userProfile.setKey(null);
		userProfile.setEmail("charles@greenhat.com");
		userProfile.setPassword("1234");
		userProfileDAO.save(userProfile);
		userProfile = userProfileDAO.getByEmail("charles@greenhat.com");
		Equipment equipment = equipmentDAO.getEquipments().get(1);
		Customer customer = new Customer();
		customer.setUserProfile(userProfile);
				
		calculator = new Calculator();
		calculator.setName("Calc_Test");
		calculator.setStatus(0);
		calculator.setDatetime(Calendar.getInstance().getTime());
		calculator.setEquipment(equipment);
		calculator.setCustomer(customer);
	}
	
	@Test
	public void testSave() {
		Calculator newCalculator;
		dao.save(calculator);
		newCalculator = dao.getByName(calculator.getName());
		
		assertEquals(calculator.getDatetime(), newCalculator.getDatetime());
		
	}
	
	@Test
	public void testGetByName() {
		Calculator newCalculator;
		dao.save(calculator);
		newCalculator = dao.getByName(calculator.getName());
		
		assertEquals(calculator.getDatetime(), newCalculator.getDatetime());
		
	}
	
}
