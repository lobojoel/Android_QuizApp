package com.cmh.tour;

import com.cmh.tour.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends Activity implements OnClickListener {

	Bundle bundle;
	Intent i;
	Button buttonTheme1;
	Button buttonTheme2;
	Button buttonTheme3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		bundle = this.getIntent().getExtras();
		buttonTheme1 = (Button) findViewById(R.id.buttonTheme1);
		buttonTheme2 = (Button) findViewById(R.id.buttonTheme2);
		buttonTheme3 = (Button) findViewById(R.id.buttonTheme3);
		if (bundle.containsKey("themeId")) {
			buttonTheme1.setText(R.string.level1);
			buttonTheme2.setText(R.string.level2);
			buttonTheme3.setText(R.string.level3);
		} else {

			CharSequence text = " Choose your Skill...Brain Teaser...Logic...Math";
			int duration = Toast.LENGTH_LONG;

			Toast toast = Toast.makeText(this, text, duration);
			toast.show();
		}
		buttonTheme1.setOnClickListener(this);

		buttonTheme2.setOnClickListener(this);

		buttonTheme3.setOnClickListener(this);

	}// onCreate

	//@Override
	public void onClick(View v) {
		Button button = (Button) v;
		Intent i = null;

		if (button.getText().equals(getString(R.string.theme1))) {
			bundle.putInt("themeId", R.string.theme1);
		} else if (button.getText().equals(getString(R.string.theme2))) {
			bundle.putInt("themeId", R.string.theme2);
		} else if (button.getText().equals(getString(R.string.theme3))) {
			bundle.putInt("themeId", R.string.theme3);
		} else if (button.getText().equals(getString(R.string.level1))) {
			bundle.putInt("levelId", R.string.level1);
		} else if (button.getText().equals(getString(R.string.level2))) {
			bundle.putInt("levelId", R.string.level2);
		} else if (button.getText().equals(getString(R.string.level3))) {
			bundle.putInt("levelId", R.string.level3);
		}
		if (bundle.containsKey("levelId")) {
			i = new Intent(Menu.this, Quiz.class);
		} else
			i = new Intent(Menu.this, Menu.class);
		i.putExtras(bundle);
		startActivity(i);
	}
}
