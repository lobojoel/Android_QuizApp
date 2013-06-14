package com.quiz.tour;

import com.quiz.tour.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Quiz_Main extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Thread thread = new Thread() {

			public void run() {
				try {
					sleep(2000);

					startActivity(new Intent("Quiz.app.CLEARSCREEN"));
					finish();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}
}