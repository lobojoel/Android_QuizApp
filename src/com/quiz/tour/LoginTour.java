package com.quiz.tour;
import com.quiz.tour.R;

import  android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginTour extends Activity{

	// Declare our Views, so we can access them later
	private EditText username;
	private Button btnLogin;
	private TextView lblUsername;
	private Bundle bundle;
	
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logintour);
        
  		 // Get the EditText and Button References
	    username = (EditText)findViewById(R.id.editText1);
	   
	    btnLogin = (Button)findViewById(R.id.button1);
	    lblUsername = (TextView)findViewById(R.id.textView1);
	    
	      // Set Click Listener
	      btnLogin.setOnClickListener(new OnClickListener() {
			    	//@Override
			    	  public void onClick(View v) {
					bundle= new Bundle();
					// Check Login
					String user = username.getText().toString();
					bundle.putString("username", user);
					Intent i = new Intent(LoginTour.this,
							Menu.class);
			
					i.putExtras(bundle);
					startActivity(i);
					LoginTour.this.finish();
					System.exit(0);
				}
			    	  
			});
	     
}
}