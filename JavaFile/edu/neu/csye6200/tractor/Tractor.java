package edu.neu.csye6200.tractor;

import java.lang.Math;
public class Tractor implements Comparable<Tractor>{
	String make;
	String model;
	String fueltype;
	double tractorpower;
	double fuelcapacity;
	double fuelload;
	double fuelefficiency;
	double range;
	String OwnerId;
	double tractorvalue;
	

	
	public Tractor(String make, String model, String fueltype, String OwnerId, double tractorpower,double fuelcapacity,double fuelload,double fuelefficiency,double tractorvalue) {
		this.make = make;
		this.model = model;
		this.fueltype = fueltype;
		this.OwnerId = OwnerId;
		this.tractorpower = tractorpower;
		this.fuelcapacity = fuelcapacity;
		this.fuelload = fuelload;
		this.fuelefficiency = fuelefficiency;
		this.tractorvalue = tractorvalue;
		
	}
	double range() {
		range= fuelload * fuelefficiency;
		return range = ((double)Math.round(range * 100)) / 100;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String toString() {
		String formm= String.format(">>>make:%1$-16s model:%2$-16s fueltype:%3$-16s OwnerId:%4$-16s tractorpower:%5$-16f fuelcapacity:%6$-16f fuelload:%7$-16f fuelefficiency:%7$-16f tractorvalue:%8$-16f range:%9$-16f",make,model,fueltype,OwnerId,tractorpower,fuelcapacity,fuelload,fuelefficiency,tractorvalue,OwnerId,range());
		return formm;
	}
	
	@Override
	public int compareTo(Tractor o) {
		// TODO Auto-generated method stub
		return this.OwnerId.compareTo( o.OwnerId );
	}
}
