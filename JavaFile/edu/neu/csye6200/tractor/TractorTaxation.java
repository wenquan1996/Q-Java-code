package edu.neu.csye6200.tractor;
import java.util.Collections;
import java.util.logging.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;
import java.lang.Math;
public class TractorTaxation {
	private ArrayList<Tractor> tractorList;
	private HashMap<String,Tractor> tractorMap;
	private static Logger log;

	private static TractorTaxation tractorTaxation = new TractorTaxation();
	
	public static TractorTaxation getInstance() {
		return tractorTaxation;
	}
	
	private TractorTaxation() {
		log = Logger.getLogger(TractorTaxation.class.getName());
		log.info("Constructing a TractorTaxation instance");
		tractorList = new ArrayList<Tractor>();
		tractorMap  = new HashMap<String,Tractor>();
	}
	
	public void sortTractors() {
		Collections.sort( tractorList );
	}
	
	public void addlist(Tractor tractor) {
		tractorList.add(tractor);
	}
	
	public Tractor getlist(int index) {
		return tractorList.get(index);
		}
	
	public void removelist(int index) {
		tractorList.remove(index);
		}
	
	public void printlist() {
		System.out.println("Make\t\tModel\t\tFueltype\ttractorpower\tfuelcapacity\tfuel load    \tfuelefficiency\trange\ttractorvalue\tOwnerID\t\tannualtax");
		
		
		for(int i = 0; i<tractorList.size();i++) {
		System.out.println(getlist(i).make+"\t"+ getlist(i).model +"\t\t"+getlist(i).fueltype+"\t"+getlist(i).tractorpower+"HP"+"\t\t"+getlist(i).fuelcapacity+"L"+"\t\t"+getlist(i).fuelload+"L"+"\t\t"+getlist(i).fuelefficiency+"Kmpl"+"\t"+getlist(i).range()+"\t"+getlist(i).tractorvalue+"\t\t"+getlist(i).OwnerId+"\t\t"+annualtax(getlist(i)));
		}
	}
	
	
	
	public void putmap(Tractor tractor) {
		tractorMap.put(tractor.OwnerId, tractor);
	}
	public Tractor getmap(String OwnerId) {
		return tractorMap.get(OwnerId);
	}
	public double annualtax(Tractor tractor) {
		double taxrate=1;
		double annualtax = taxrate*tractor.tractorvalue/1000;
		return annualtax = ((double)Math.round(annualtax * 100)) / 100;
	}
}