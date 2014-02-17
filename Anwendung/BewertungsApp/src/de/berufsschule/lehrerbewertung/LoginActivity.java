package de.berufsschule.lehrerbewertung;

import helper.Constants;
import controller.EventHandler;
import de.berufsschule.bewertungsApp.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private Button btnLogin;
	private TextView txtViewUsername;
	private TextView txtViewPassword;

	private OnClickListener onClickHandler = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == btnLogin)
				EventHandler.getInstance().btnLoginClick(
						txtViewPassword.getText().toString(),
						txtViewUsername.getText().toString(),
						(Activity) v.getContext());
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		this.setViewControls();
		this.addEvents();

		if (this.getIntent().getExtras().containsKey(Constants.ErrorKey))
			Toast.makeText(getBaseContext(),
					this.getIntent().getExtras().getString(Constants.ErrorKey),
					Toast.LENGTH_LONG).show();
	}

	private void addEvents() {
		btnLogin.setOnClickListener(this.onClickHandler);
	}

	private void setViewControls() {
		btnLogin = (Button) findViewById(R.id.btnLogin);
		txtViewUsername = (TextView) findViewById(R.id.txtViewUsername);
		txtViewPassword = (TextView) findViewById(R.id.txtViewPassword);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
