package com.quiz.tour;
import com.quiz.tour.R;

import  android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Scores extends Activity implements OnClickListener{
	Bundle bundle;
	TextView score;
	TextView scoreLabel;
	TextView summaryLabel;
	TextView userLabel;
	TextView rankLabel;
	TextView ranking;
	Button quitBtn;
	String name=null;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scores);

		bundle = this.getIntent().getExtras();
		if (bundle.getInt("themeId") == R.string.theme1) {
			getWindow().setBackgroundDrawableResource(R.drawable.background_theme1);
		}else if (bundle.getInt("themeId") == R.string.theme2) {
			getWindow().setBackgroundDrawableResource(R.drawable.background);
		}else if (bundle.getInt("themeId") == R.string.theme3) {
			getWindow().setBackgroundDrawableResource(R.drawable.background);
		
		}
		String rank=null;
		Integer userScore = Integer.parseInt(bundle.getString("score"));
		summaryLabel=(TextView) findViewById(R.id.summarylabel);
		userLabel=(TextView) findViewById(R.id.userlabel);
		scoreLabel=(TextView) findViewById(R.id.scorelabel);
		rankLabel=(TextView) findViewById(R.id.ranklabel);
		ranking=(TextView) findViewById(R.id.rank);
		quitBtn=(Button) findViewById(R.id.quitApp);
		quitBtn.setOnClickListener(this);
		
		name = bundle.getString("username");
		userLabel.setText(name);
		score=(TextView) findViewById(R.id.score);
		score.setText(userScore.toString());
		Resources res = getResources();
		String[] ranks=null;
		if (bundle.getInt("themeId") == R.string.theme1) {
			ranks=res.getStringArray(R.array.rank_theme1);
		}else if (bundle.getInt("themeId") == R.string.theme2) {
			ranks=res.getStringArray(R.array.rank_theme2);
		}else if (bundle.getInt("themeId") == R.string.theme3) {
			ranks=res.getStringArray(R.array.rank_theme3);
		}
		if(userScore > 15)
			rank = ranks[2];
		else if(userScore > 10)
			rank = ranks[1];
		else
			rank = ranks[0];
		
		ranking.setText(rank);
	}
	
	public void onClick(View v) {
				
			Intent i = new Intent(Scores.this, Menu.class);
			bundle = new Bundle();
			bundle.putString("username", name);
			i.putExtras(bundle);
			startActivity(i);
			finish();
		
	}
}
