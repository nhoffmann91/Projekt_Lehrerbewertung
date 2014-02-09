package de.berufsschule.lehrerbewertung;

import controller.EventHandler;
import de.berufsschule.bewertungsApp.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class TeacherChoiceActivity extends Activity {
	private Spinner spnTeacher;
	private Spinner spnSubject;
	private Button btnSubmit;
	private OnClickListener onClickHandler = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(v == btnSubmit)
				EventHandler.getInstance().btnSubmit(spnTeacher.getSelectedItem().toString(), 
						spnSubject.getSelectedItem().toString(), (Activity)v.getContext());
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacherchoice);
		
		this.addEvents();
		this.setViewControls();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.teacher_choice, menu);
		return true;
	}
	
	private void addEvents() {
		btnSubmit.setOnClickListener(this.onClickHandler);
	}

	private void setViewControls() {
		btnSubmit = (Button)findViewById(R.id.btnSubmit);
		spnTeacher = (Spinner)findViewById(R.id.spinnerTeacher);
		spnSubject = (Spinner)findViewById(R.id.spinnerSubject);
	}
}
