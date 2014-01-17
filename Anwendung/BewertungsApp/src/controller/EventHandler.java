package controller;

import android.widget.TextView;

public class EventHandler {
	private static EventHandler eventHandler = null;
	
	public EventHandler(){}
	
	public static EventHandler getInstance(){
		if(eventHandler == null)
			eventHandler = new EventHandler();
		return eventHandler;
	}

	public void btnLoginClick(TextView txtViewPassword, TextView txtViewUsername) {
		String username = (String)txtViewUsername.getText();
		String password = (String)txtViewPassword.getText();
		
		MySqlAdapter mySqlAdapter = new MySqlAdapter();
		
		if(mySqlAdapter.isConnected()){
			bool
		}
	}
}
