package com.mycompany.app;

import java.util.ArrayList;

public class Intents extends Thread{
	private String TYPE;
	private String ID;
	private String APP_ID;
	private String STATE;
	private ArrayList<String> PAIRS;
	private int AGE;//Minute 1440 representa 24 horas

	public int getAGE() {
		return AGE;
	}
	public void setAGE(int aGE) {
		AGE = aGE;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getAPP_ID() {
		return APP_ID;
	}
	public void setAPP_ID(String aPP_ID) {
		APP_ID = aPP_ID;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public ArrayList<String> getPAIRS() {
		return PAIRS;
	}
	public void setPAIRS(ArrayList<String> pAIRS) {
		PAIRS = pAIRS;
	}
	
	public void intentAnalyzer(){
		OnosControllerAgent oca = new OnosControllerAgent();
		JSONProcessor jsonProcessor = new JSONProcessor();
		
		ArrayList<Intents> intentsListTemp =  jsonProcessor.getIntentList(oca.getIntents());
		ArrayList<Intents> intentsList = new ArrayList<Intents>();
		
		if(intentsList.size() == 0){
			intentsList = intentsListTemp;
		}

		boolean found = false;
		int index = -1;
		
		while(true){
			
			
		}
	}
	
	public void run(){
		this.intentAnalyzer();
	}
}
