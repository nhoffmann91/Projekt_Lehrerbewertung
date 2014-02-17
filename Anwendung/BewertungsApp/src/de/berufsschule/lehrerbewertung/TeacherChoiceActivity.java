package de.berufsschule.lehrerbewertung;

import controller.EventHandler;
import de.berufsschule.bewertungsApp.R;
import android.os.Bundle;
import android.app.Activity;
import android.database.DataSetObserver;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class TeacherChoiceActivity extends Activity {
	private Spinner spnTeacher;
	private Spinner spnSubject;
	private Button btnSubmit;
	private OnClickListener onClickHandler = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == btnSubmit)
				EventHandler.getInstance().btnSubmit(
						spnTeacher.getSelectedItem().toString(),
						spnSubject.getSelectedItem().toString(),
						(Activity) v.getContext());
		}
	};
	private OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			if (arg1 == spnTeacher) {
				EventHandler.getInstance().spnTeacherItemChange();
			} else if (arg1 == spnSubject) {
				EventHandler.getInstance().spnSubjectItemChange();
			}

		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacherchoice);

		this.addEvents();
		this.setViewControls();
		this.bindData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.teacher_choice, menu);
		return true;
	}

	private void addEvents() {
		this.btnSubmit.setOnClickListener(this.onClickHandler);
		this.spnTeacher.setOnItemSelectedListener(this.onItemSelectedListener);
		this.spnSubject.setOnItemSelectedListener(this.onItemSelectedListener);
	}

	private void setViewControls() {
		this.btnSubmit = (Button) findViewById(R.id.btnSubmit);
		this.spnTeacher = (Spinner) findViewById(R.id.spinnerTeacher);
		this.spnSubject = (Spinner) findViewById(R.id.spinnerSubject);
	}

	private void bindData() {
		Arra
	}
}
