package au.edu.qut.inn372.greenhat.dao.gae;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;

import au.edu.qut.inn372.greenhat.bean.UserProfile;
import au.edu.qut.inn372.greenhat.dao.UserProfileDAO;
import au.edu.qut.inn372.greenhat.util.Util;

/**
 * Data Access Object using Google Data Store.
 * For each operation the Bean must be converted to Entity.
 * 
 * ATTENTION: we are using some deprecated methods due to 
 * Google documentation is still using the old methods. That
 * can be re-factored as soon as google provide new documentation.
 * 
 * @author Charleston Telles
 *
 */
public class UserProfileDAOImpl implements Serializable, UserProfileDAO {
	/**
	 * Unique identifier
	 */
	private static final long serialVersionUID = 8892093927010701287L;
	/**
	 * Google Data store Entity.
	 * UserProfile bean must be converted to entity before executing
	 * DS operations
	 */
	private Entity entity;
	/**
	 * Google Data store must be a local STATIC variable otherwise
	 * won't work in the GAE server
	 */
	private static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	/**
	 * see interface documentation
	 */
	@Override
	public String save(UserProfile userProfile) {
		if (userProfile.getKey() != null) {
			entity = new Entity("UserProfile", userProfile.getKey());
		} else {
			userProfile.setKey("UserProfile_" + (countEntities() + 1));
			entity = new Entity("UserProfile", userProfile.getKey());
		}
		entity.setProperty("name", userProfile.getName());
		entity.setProperty("email", userProfile.getEmail());
		entity.setProperty("password", userProfile.getPassword());
		entity.setProperty("type", userProfile.getType());
		entity.setProperty("bean", new Blob(Util.serialize(userProfile).getBytes()));
		
		datastore.put(entity);
		return "";
	}
	/**
	 * see interface documentation
	 */
	@Override
	public List<UserProfile> getAll() {
		List<UserProfile> list = new ArrayList<UserProfile>();
		Query query = new Query("UserProfile");
		Iterator<Entity> records = datastore.prepare(query).asIterable().iterator();
		Blob bean;
		UserProfile userProfile;
		while(records.hasNext()){
			bean = (Blob)records.next().getProperty("bean");
			userProfile = (UserProfile)Util.unserialize(new String(bean.getBytes()));
			list.add(userProfile);
		}

		return list;
	}

	/**
	 * see interface documentation
	 */
	@Override
	public UserProfile getByEmail(String email) {
		@SuppressWarnings("deprecation")
		Query query = new Query("UserProfile").addFilter("email",
				Query.FilterOperator.EQUAL, email);
		Iterator<Entity> records = datastore.prepare(query).asIterable().iterator();
		Blob bean;
		UserProfile userProfile = null;
		if(records.hasNext()){
			bean = (Blob)records.next().getProperty("bean");
			userProfile = (UserProfile)Util.unserialize(new String(bean.getBytes()));
		}
		return userProfile;
	}
	
	/**
	 * see interface documentation
	 */
	@Override
	public UserProfile validateCredential(String email, String password) {
		UserProfile userProfile = getByEmail(email);
		if (userProfile == null){
			return new UserProfile();
		} else {
			if (userProfile.getPassword().equalsIgnoreCase(password))
				return userProfile;
			else
				return new UserProfile();
		}
	}

	/**
	 * see interface documentation
	 */
	@Override
	public String remove(UserProfile userProfile) {
		@SuppressWarnings("deprecation")
		Query query = new Query("UserProfile").addFilter("email",
				Query.FilterOperator.EQUAL, userProfile.getEmail());
		Iterator<Entity> records = datastore.prepare(query).asIterable().iterator();
	
		if(records.hasNext()){
			Key key = records.next().getKey();
			datastore.delete(key);
		}
		return "";
	}
	
	/**
	 * Gets the number of entities in database.
	 * This will be used to generate the key number.
	 * @return number of Entities
	 */
	@SuppressWarnings("deprecation")
	private int countEntities(){
		Query query = new Query("UserProfile");
		return datastore.prepare(query).countEntities();
	}

}
