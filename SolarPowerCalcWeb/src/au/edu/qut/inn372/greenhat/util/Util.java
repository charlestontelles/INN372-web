package au.edu.qut.inn372.greenhat.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * Utility class to be used by the Calculator
 * 
 * @author Charleston Telles
 *
 */
public class Util implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5607009759279346346L;
	/**
	 * Given a Serializable bean return a byte array representation
	 * @param object
	 * @return String
	 */
	public static String serialize(Serializable o) {
		try{
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ObjectOutputStream oos = new ObjectOutputStream( baos );
	        oos.writeObject( o );
	        oos.close();
	        return new String( Base64Coder.encode( baos.toByteArray() ) );
		} catch (Exception e){
			return "";
		}
	}
	/**
	 * Give a byte array representation retrieves a bean
	 * @param string - byte array representation
	 * @return bean object
	 */
	public static Object unserialize(String s) {
		try{
	       byte [] data = Base64Coder.decode( s );
	        ObjectInputStream ois = new ObjectInputStream( 
	                                        new ByteArrayInputStream(  data ) );
	        Object o  = ois.readObject();
	        ois.close();
	        return o;
		}catch (Exception e){
			return new Object();
		}
	}
}
