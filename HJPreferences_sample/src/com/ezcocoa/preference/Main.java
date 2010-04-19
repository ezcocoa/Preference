package com.ezcocoa.preference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;


public class Main extends Activity {
	private static final String EDITTEXT_STATE = "EDITTEXT_STATE_KEY";    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        EditText myEditText = (EditText)findViewById(R.id.myEditText);
        String text = "";
        if (savedInstanceState != null && savedInstanceState.containsKey(EDITTEXT_STATE)) 	
        	text = savedInstanceState.getString(EDITTEXT_STATE);

    	Log.d("Tag","onCreate text = "+text);
    	myEditText.setText(text);
        
        savePreferences();
        loadPreferences();
    }
    
    private final String SHARED_PREFS = "SharedPreferences"; 
    
    protected void savePreferences() {
    	SharedPreferences sp = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    	SharedPreferences.Editor editor = sp.edit();
    	
    	editor.putBoolean("boolean", true);
   	    editor.putFloat("float", 1f);
   	    editor.putInt("int", 2);
   	    editor.putLong("long", 3l);
   	    editor.putString("string", "Empty");
   	    editor.commit();
    } 
    
    protected void loadPreferences() {
    	SharedPreferences sp = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    	Log.d("Tag","Start ******************");
    	boolean aBoolean = sp.getBoolean("boolean", false);
        Log.d("Tag","aBoolean = "+aBoolean);
        float aFloat = sp.getFloat("float", 0f);
        Log.d("Tag","aFloat = "+aFloat);
        int aInt = sp.getInt("int", 1);
        Log.d("Tag","aInt = "+aInt);
        long aLog = sp.getLong("long", 0);
        Log.d("Tag","aLog = "+aLog);
        String aString = sp.getString("string", "");
        Log.d("Tag","aString = "+aString);
        Log.d("Tag","End ********************");
    }    
    
    /*
     * Save / Restore Instance State Handlers 
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
    	EditText myEditText = (EditText)findViewById(R.id.myEditText);
    	String text = myEditText.getText().toString();
    	Log.d("Tag","onSaveInstanceState = "+text);
    	savedInstanceState.putString(EDITTEXT_STATE, text);
    	super.onSaveInstanceState(savedInstanceState);
    }
    
    @Override 
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    }
}


