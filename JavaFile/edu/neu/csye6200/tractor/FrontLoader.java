package edu.neu.csye6200.tractor;

public class FrontLoader extends Tractor {
double width;
double cap;//capacity
	public FrontLoader(String make, String model, String fueltype, String OwnerId, double tractorpower,
			double fuelcapacity, double fuelload, double fuelefficiency, double tractorvalue,double w,double c) {
		super(make, model, fueltype, OwnerId, tractorpower, fuelcapacity, fuelload, fuelefficiency, tractorvalue);
		width = w;
		cap =c;
	}

	

}