package com.example.moveporto;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
 
import library.UserFunctions;
 
public class DashboardActivity extends Activity {
    UserFunctions userFunctions;
    Button btnLogout;
    TextView welcomeUserTextView;
    TextView fullNameTextView;
    TextView emailTextView;
    TextView currentPassTextView;
    TextView expirationDateTextView;
    static User user;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
         
        /**
         * Dashboard Screen for the application
         * */       
        // Check login status in database
        userFunctions = new UserFunctions();
        if(userFunctions.isUserLoggedIn(getApplicationContext())){
       // user already logged in, show dashboard        	
            setContentView(R.layout.activity_dashboard);
            welcomeUserTextView=(TextView) findViewById(R.id.textView2);        	
            welcomeUserTextView.append((CharSequence) user.fullName);
            
            fullNameTextView=(TextView) findViewById(R.id.textView1);
            fullNameTextView.append((CharSequence) user.fullName);
            
            emailTextView=(TextView) findViewById(R.id.textView3); 
            emailTextView.append((CharSequence) user.email);
            
            if(user.currentpass!=null){
            
            currentPassTextView=(TextView) findViewById(R.id.textView4); 
            currentPassTextView.append((CharSequence) user.currentpass.tipo.name());
            
            expirationDateTextView=(TextView) findViewById(R.id.textView5);
            expirationDateTextView.append((CharSequence) user.currentpass.dataExp.getTime().toString());
            }
            
            btnLogout = (Button) findViewById(R.id.btnLogout);
            
            btnLogout.setOnClickListener(new View.OnClickListener() {
                 
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    userFunctions.logoutUser(getApplicationContext());
                    Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                    login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(login);
                    // Closing dashboard screen
                    finish();
                }
            });
        	
        }else{
            // user is not logged in show login screen
            Intent login = new Intent(getApplicationContext(), LoginActivity.class);
            login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(login);
            // Closing dashboard screen
            finish();
        }        
    }
    
    public void logOut(View view) {
    	
    	userFunctions.logoutUser(getApplicationContext());
        Intent login = new Intent(getApplicationContext(), LoginActivity.class);
        login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(login);
        // Closing dashboard screen
        finish();
        
    }
    
    public void changePass(View view){
    	Intent changePass = new Intent(getApplicationContext(), BuyPassActivity.class);
    	startActivity(changePass);
    	finish();
    }

	public static void setUser(String username, String email) {
		if (user==null) {
			user= new User(username,email);
		}		
	}
	
	public User getUser(){
		return user;
	}
}
