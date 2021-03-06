package library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.example.moveporto.DashboardActivity;
import com.example.moveporto.TipoPasse;
import com.example.moveporto.User;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UserFunctions {

	private JSONParser jsonParser;

	// Testing in localhost using wamp or xampp
	// use http://10.0.2.2/ to connect to your localhost ie http://localhost/
	private static String loginURL = "http://moveporto.comeze.com/api_php/";
	private static String registerURL = "http://moveporto.comeze.com/api_php/";

	private static String login_tag = "login";
	private static String register_tag = "register";
	private static String storepass_tag = "storepass";

	private static User user;

	// constructor
	public UserFunctions() {
		jsonParser = new JSONParser();
	}

	/**
	 * function make Login Request
	 * 
	 * @param email
	 * @param password
	 * */
	public JSONObject loginUser(String email, String password) {
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", login_tag));
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));
		JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
		return json;
	}

	/**
	 * function make Login Request
	 * 
	 * @param name
	 * @param email
	 * @param password
	 * */
	public JSONObject registerUser(String name, String email, String password) {
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		int pin=newPin();
		params.add(new BasicNameValuePair("tag", register_tag));
		params.add(new BasicNameValuePair("name", name));
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("pin", ""+pin));
		params.add(new BasicNameValuePair("password", password));
		

		// getting JSON Object
		JSONObject json = jsonParser.getJSONFromUrl(registerURL, params);
		// return json
		return json;
		
	}
	
	private int newPin() {
		List<Integer> numbers = new ArrayList<Integer>();
	    for(int i = 1; i < 10; i++){
	        numbers.add(i);
	    }
	    Collections.shuffle(numbers);

	    int pin = (numbers.get(0)*1000)+(numbers.get(1)*100)+(numbers.get(2)*10)+(numbers.get(3));
	    Log.d("stop here","");
		return pin;
	}

	public JSONObject storePass(String type, String username) {
		// Building Parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("tag", storepass_tag));
		params.add(new BasicNameValuePair("type", type));
		params.add(new BasicNameValuePair("user", username));
		
		// getting JSON Object
		JSONObject json = jsonParser.getJSONFromUrl(registerURL, params);
		// return json
		return json;
	}

	/**
	 * Function get Login status
	 * */
	public boolean isUserLoggedIn(Context context) {
		DatabaseHandler db = new DatabaseHandler(context);
		int count = db.getRowCount();

		if (count > 0) {
			HashMap<String, String> user = new HashMap<String, String>();
			user = db.getUserDetails();
			String username = user.get("name");
			String email = user.get("email");
			String pin = user.get("pin");
			User u = new User(username,email,pin);
			DashboardActivity.setUser(u);

			return true;
		}
		return false;
	}

	/**
	 * Function to logout user Reset Database
	 * */
	public boolean logoutUser(Context context) {
		DatabaseHandler db = new DatabaseHandler(context);
		db.resetTables();
		User user = null;
		DashboardActivity.setUser(user);
		return true;
	}

}
