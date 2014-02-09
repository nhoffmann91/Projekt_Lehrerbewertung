package de.berufsschule.lehrerbewertung;

import controller.EventHandler;
import de.berufsschule.bewertungsApp.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RankingActivity extends Activity {
	private Button btnRateOtherTeacher;
	
private OnClickListener onClickHandler = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(v == btnRateOtherTeacher)
				EventHandler.getInstance().btnRateOtherTeacherClick((Activity)v.getContext());
		}
	};
	
	private void addEvents() {
		btnRateOtherTeacher.setOnClickListener(this.onClickHandler);
	}

	private void setViewControls() {
		btnRateOtherTeacher = (Button)findViewById(R.id.btnRateOtherTeacher);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ranking);
		
		this.setViewControls();
		this.addEvents();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ranking, menu);
		return true;
	}

}
