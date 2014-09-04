package com.example.moveporto;

import library.UserFunctions;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends ActionBarActivity {

	// Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    UserFunctions userFunctions;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
 
        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
            	
            	userFunctions = new UserFunctions();
                if(userFunctions.isUserLoggedIn(getApplicationContext())){
               // user already logged in show databoard
                	Intent dashboard = new Intent(getApplicationContext(), DashboardActivity.class);
                	dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(dashboard);
                    // Closing dashboard screen
                    finish();                   
                     
                }else{
                    // user is not logged in show login screen
                    Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                    login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(login);
                    // Closing dashboard screen
                    finish();
                }        
            }
        }, SPLASH_TIME_OUT);
    }
 
}