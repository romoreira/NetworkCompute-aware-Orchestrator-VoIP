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
		
		ArrayList<Intents> intentsListTemp =  null;//jsonProcessor.getIntentList(oca.getIntents());
		ArrayList<Intents> intentsList = new ArrayList<Intents>();
		
		int intentsListSize = intentsList.size();
		int listIndex = 0;
		
		while(true){
			
			intentsListTemp =  jsonProcessor.getIntentList(oca.getIntents());
			
			if(intentsListTemp.size() > intentsList.size()){
				
				if(intentsList.size() == 0){
					for(int i = 0; i < intentsListTemp.size(); i++){
						intentsListTemp.get(i).setAGE(1440);
						intentsList.add(intentsListTemp.get(i));
					}
				
				}
				else{
				
					for(int i = 0; i < intentsListTemp.size(); i++){
						while(listIndex < intentsListSize){
							if(intentsListTemp.get(i).getID().equals(intentsList.get(listIndex).getId())){
								break;
							}
							else{
								if(listIndex < intentsListSize){
									listIndex++;
								}
								else{
									intentsListTemp.get(i).setAGE(1440);
									intentsList.add(intentsListTemp.get(i));
								}
							}
						}
						listIndex = 0;
					}
				}	
			}
			try{Thread.sleep(60000);}catch(Exception e){System.out.println("Erro ao colocar a Thread intentsAnalyzer para dormir");}
			for(int i =0; i < intentsList.size(); i++){
				int idadeAnterior= intentsList.get(i).getAGE();
				intentsList.get(i).setAGE(idadeAnterior - 1); 
			}
		}
	}
	
	public void run(){
		this.intentAnalyzer();
	}
}
