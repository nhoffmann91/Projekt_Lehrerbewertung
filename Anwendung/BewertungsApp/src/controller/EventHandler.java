package controller;

import de.berufsschule.bewertungsApp.LoginActivity;
import de.berufsschule.bewertungsApp.MainActivity;
import android.R;
import android.view.View;

public class EventHandler {
	private static EventHandler eventHandler = null;
	
	public EventHandler(){}
	
	public static EventHandler getInstance(){
		if(eventHandler == null)
			eventHandler = new EventHandler();
		return eventHandler;
	}

	public void btnLoginClick(LoginActivity loginActivity, Class<MainActivity> class1) {
		//String username = loginActivity.
	}
}
