package au.edu.qut.inn372.greenhat.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Bean that represents a UserProfile
 * 
 * @author Charleston Telles
 * @version 1.0
 */
@ManagedBean
@SessionScoped
public class UserProfile implements Serializable {
	/**
	 * Unique Identifier
	 */
	private static final long serialVersionUID = 4599421625243305561L;
	private String key;
	private String name;
	private String email;
	private String password;
	private int type; //1=customer, 2=seller, 3=admin
	/**
	 * Gets user profile key
	 * @return key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * Sets user profile key
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * Gets User profile name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets User profile name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets user profile email
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Sets user profile email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Sets user profile Password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Sets User profile Password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Sets user profile Type.
	 * 1=customer
	 * 2=seller
	 * 3=admin
	 * @return type
	 */
	public int getType() {
		return type;
	}
	/**
	 * Gets user profile type
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}
	
}
