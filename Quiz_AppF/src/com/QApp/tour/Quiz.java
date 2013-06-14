package com.cmh.tour;



import com.cmh.tour.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends Activity implements OnClickListener {
	ViewGroup parentGroup;
	TextView parent;
	Integer count = 0;
	RadioButton answer11;
	RadioButton answer12;
	RadioButton answer13;
	Integer score = 0;
	Integer noOfattempts = 1;
	Button submit;
	Button quitBtn;
	Bundle bundle;
	String username = null;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz);
		if (this.getIntent().getExtras() != null) {
			bundle = this.getIntent().getExtras();
			if (bundle.getInt("themeId") == R.string.theme1) {
				getWindow().setBackgroundDrawableResource(R.drawable.background_theme1);
			}else if (bundle.getInt("themeId") == R.string.theme2) {
				getWindow().setBackgroundDrawableResource(R.drawable.background);
			}else if (bundle.getInt("themeId") == R.string.theme3) {
				getWindow().setBackgroundDrawableResource(R.drawable.background);
			}
			username = bundle.getString("username");
			if (bundle.getString("count") != null) {
				String count1 = bundle.getString("count");
				count = Integer.parseInt(count1);
				noOfattempts = Integer.parseInt(bundle
						.getString("NoOfattempts"));
				score = Integer.parseInt(bundle.getString("score"));
			}
		}//if close
		else
			bundle = new Bundle();
		init();
		quitBtn.setOnClickListener(this);
		submit.setOnClickListener(this);
	}// public void onCreate

	TextView countText;

	public void init() {
		Resources res = getResources();
		String[] questions = null;
		String[] answers = null;
		if (bundle.getInt("themeId") == R.string.theme1) {
			if (bundle.getInt("levelId") == R.string.level1) {
				questions = res.getStringArray(R.array.question_theme1_easy);
				answers = res.getStringArray(R.array.answer_theme1_easy);
			} else if (bundle.getInt("levelId") == R.string.level2) {
				questions = res.getStringArray(R.array.question_theme1_medium);
				answers = res.getStringArray(R.array.answer_theme1_medium);
			} else if (bundle.getInt("levelId") == R.string.level3) {
				questions = res.getStringArray(R.array.question_theme1_hard);
				answers = res.getStringArray(R.array.answer_theme1_hard);
			}
		} else if (bundle.getInt("themeId") == R.string.theme2) {
			if (bundle.getInt("levelId") == R.string.level1) {
				questions = res.getStringArray(R.array.question_theme2_easy);
				answers = res.getStringArray(R.array.answer_theme2_easy);
			} else if (bundle.getInt("levelId") == R.string.level2) {
				questions = res.getStringArray(R.array.question_theme2_medium);
				answers = res.getStringArray(R.array.answer_theme2_medium);
			} else if (bundle.getInt("levelId") == R.string.level3) {
				questions = res.getStringArray(R.array.question_theme2_hard);
				answers = res.getStringArray(R.array.answer_theme2_hard);
			}
		}
		  else if(bundle.getInt("themeId")==R.string.theme3){
		  if(bundle.getInt("levelId")==R.string.level1){ 
			  questions = res.getStringArray(R.array.question_theme3_easy); 
			  answers = res.getStringArray(R.array.answer_theme3_easy); }
		  else if(bundle.getInt("levelId")==R.string.level2){ 
			  questions = res.getStringArray(R.array.question_theme3_medium); 
			  answers = res.getStringArray(R.array.answer_theme3_medium); }else
		  if(bundle.getInt("levelId")==R.string.level3){ 
			  questions = res.getStringArray(R.array.question_theme3_hard); 
			  answers =  res.getStringArray(R.array.answer_theme3_hard); } }
		 
		parentGroup = (ViewGroup) findViewById(R.id.parent);
		parent = (TextView) findViewById(R.id.textview01);

		answer11 = (RadioButton) findViewById(R.id.answer11);
		answer12 = (RadioButton) findViewById(R.id.answer12);
		answer13 = (RadioButton) findViewById(R.id.answer13);
		countText = (TextView) findViewById(R.id.textview02);
		submit = (Button) findViewById(R.id.submit);
		quitBtn = (Button) findViewById(R.id.quit);
		/*
		 * switch (count) { case 0: questionNo = R.string.question1;
		 * answer11.setText(R.string.answer11); break; case 1: questionNo =
		 * R.string.question2; submit.setText("Submit"); break;
		 * 
		 * }
		 */
		parent.setText(questions[count]);
		answer11.setText(answers[(count * 3)]);
		answer12.setText(answers[(count * 3) + 1]);
		answer13.setText(answers[(count * 3) + 2]);
		if ((count + 1) == questions.length) {
			submit.setText("Submit");
		}

	}
	CharSequence text = null;
	  PopupWindow pw=null;
	//@Override
	public void onClick(View v) {
		Intent i = null;
		switch (v.getId()) {
		case R.id.submit:
			String[] solutions = null;
			String[] hints = null;
			Resources res = getResources();
			if (bundle.getInt("themeId") == R.string.theme1) {
				if (bundle.getInt("levelId") == R.string.level1) {
					solutions = res
							.getStringArray(R.array.solution_theme1_easy);
					hints = res.getStringArray(R.array.hints_theme1_easy);
				} else if (bundle.getInt("levelId") == R.string.level2) {
					solutions = res
							.getStringArray(R.array.solution_theme1_medium);
					hints = res.getStringArray(R.array.hints_theme1_medium);
				} else if (bundle.getInt("levelId") == R.string.level3) {
					solutions = res
							.getStringArray(R.array.solution_theme1_hard);
					hints = res.getStringArray(R.array.hints_theme1_hard);
				}
			}else if (bundle.getInt("themeId") == R.string.theme2) {
				if (bundle.getInt("levelId") == R.string.level1) {
					solutions = res
							.getStringArray(R.array.solution_theme2_easy);
					hints = res.getStringArray(R.array.hints_theme2_easy);
				} else if (bundle.getInt("levelId") == R.string.level2) {
					solutions = res
							.getStringArray(R.array.solution_theme2_medium);
					hints = res.getStringArray(R.array.hints_theme2_medium);
				} else if (bundle.getInt("levelId") == R.string.level3) {
					solutions = res
							.getStringArray(R.array.solution_theme2_hard);
					hints = res.getStringArray(R.array.hints_theme2_hard);
				}
			}
			else if (bundle.getInt("themeId") == R.string.theme3) {
				if (bundle.getInt("levelId") == R.string.level1) {
					solutions = res
							.getStringArray(R.array.solution_theme3_easy);
					hints = res.getStringArray(R.array.hints_theme3_easy);
				} else if (bundle.getInt("levelId") == R.string.level2) {
					solutions = res
							.getStringArray(R.array.solution_theme3_medium);
					hints = res.getStringArray(R.array.hints_theme3_medium);
				} else if (bundle.getInt("levelId") == R.string.level3) {
					solutions = res
							.getStringArray(R.array.solution_theme3_hard);
					hints = res.getStringArray(R.array.hints_theme3_hard);
				}
			}
			String answer = null;

			if (answer11.isChecked()) {
				answer = answer11.getText().toString();

			}
			if (answer12.isChecked()) {
				answer = answer12.getText().toString();
			}
			if (answer13.isChecked()) {
				answer = answer13.getText().toString();
			}
			if (answer.equalsIgnoreCase(solutions[count])) {
				if (noOfattempts == 1)
					score += 4;
				else if (noOfattempts == 2)
					score += 2;
				else
					score += 0;
				count++;
				noOfattempts = 1;
				if (submit.getText().equals("Submit")) {
					i = new Intent(Quiz.this, Scores.class);
					bundle.putString("count", count.toString());
					bundle.putString("score", score.toString());
					bundle.putString("NoOfattempts", noOfattempts.toString());
					bundle.putString("username", username);
					i.putExtras(bundle);
					startActivity(i);
				} else
					i = new Intent(Quiz.this, Quiz.class);
				bundle.putString("count", count.toString());
				bundle.putString("score", score.toString());
				bundle.putString("NoOfattempts", noOfattempts.toString());
				bundle.putString("username", username);
				i.putExtras(bundle);
				startActivity(i);
			} else {
				noOfattempts += 1;
				
				// Context context = getApplicationContext();
				if (noOfattempts == 2)
					text = hints[(count * 2)];
				else if (noOfattempts == 3)
					text = hints[(count * 2) + 1];
				/*int duration = Toast.LENGTH_SHORT	Toast toast = Toast.makeText(this, text, duration);
				toast.show();*/
				LayoutInflater inflater = (LayoutInflater) Quiz.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View layouts = inflater.inflate(R.layout.popup,
		                (ViewGroup) findViewById(R.id.widget));
				
				//Here x is the name of the xml which contains the popup components
				pw = new PopupWindow(layouts, 300, 470, true);

				pw.showAtLocation(layouts, Gravity.CENTER, 0,0);
				TextView tv = (TextView)layouts.findViewById(R.id.poptext);
				tv.setText(text);
				 Button cancelButton = (Button) layouts.findViewById(R.id.btnHint);
			        //makeBlack(cancelButton);
			        cancelButton.setOnClickListener(cancel_button_click_listener);
				//i=new Intent(QuizQuestions.this, QuizQuestions.class);
			}
			
	
		/*	bundle.putString("count", count.toString());
			bundle.putString("score", score.toString());
			bundle.putString("NoOfattempts", noOfattempts.toString());
			bundle.putString("username", username);
			i.putExtras(bundle);
			startActivity(i);*/

			break;

		case R.id.quit:
			i = new Intent(Quiz.this, Menu.class);
			bundle = new Bundle();
			bundle.putString("username", username);
			i.putExtras(bundle);
			startActivity(i);
			break;
		}
	}
	private OnClickListener cancel_button_click_listener = new OnClickListener() {
	    public void onClick(View v) {
	        pw.dismiss();
	        Intent i=new Intent(Quiz.this, Quiz.class);
	        bundle.putString("count", count.toString());
			bundle.putString("score", score.toString());
			bundle.putString("NoOfattempts", noOfattempts.toString());
			bundle.putString("username", username);
			i.putExtras(bundle);
			startActivity(i);
	    }
	};
}

