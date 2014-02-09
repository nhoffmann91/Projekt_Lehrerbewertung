package controller;

import de.berufsschule.lehrerbewertung.RankingActivity;
import de.berufsschule.lehrerbewertung.TeacherChoiceActivity;
import android.app.Activity;
import android.content.Intent;

public class EventHandler {	
	
	private static EventHandler eventHandler = null;
	
	public EventHandler(){}
	
	public static EventHandler getInstance(){
		if(eventHandler == null)
			eventHandler = new EventHandler();
		return eventHandler;
	}

	public void btnLoginClick(String username, String password, Activity context) {		
		MySqlAdapter mySqlAdapter = new MySqlAdapter();
		
		if(mySqlAdapter.isConnected()){
			// Neues Intent anlegen
            Intent ranking = new Intent(context.getApplicationContext(), RankingActivity.class);

            // Intent mit den Daten füllen
            // nextScreen.putExtra("Vorname", inputVorname.getText().toString());
            // nextScreen.putExtra("Nachname", inputNachname.getText().toString());

            // Intent starten und zur zweiten Activity wechseln
            context.startActivity(ranking);
        }
		else{
			
		}
	}

	public void btnRateOtherTeacherClick(Activity context) {
		// TODO Auto-generated method stub
		// Neues Intent anlegen
        Intent otherTeacher = new Intent(context.getApplicationContext(), TeacherChoiceActivity.class);

        // Intent mit den Daten füllen
        // nextScreen.putExtra("Vorname", inputVorname.getText().toString());
        // nextScreen.putExtra("Nachname", inputNachname.getText().toString());

        // Intent starten und zur zweiten Activity wechseln
        context.startActivity(otherTeacher);
	}

	public void btnSubmit(String teacher, String subject, Activity context) {
	}
}
