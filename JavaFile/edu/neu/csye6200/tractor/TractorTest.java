package edu.neu.csye6200.tractor;
import java.io.*;
import java.util.logging.*;

public class TractorTest {
	String sep = File.separator;
	String logPath = "src" + sep + "edu" + sep + "neu" + sep + "csye6200" + sep + "tractor" + sep + "Tractor.log";

	public TractorTest() {
		// TODO Auto-generated constructor stub
	}
	public void run() {
		try {
			File logDirFile = new File(logPath);
			if (!logDirFile.exists()) // If this log folder doesn't exist, create it
				logDirFile.createNewFile();
			// Create a rotating logfile handler and add it to our logger
			Handler handler = new FileHandler(logPath);
			Logger.getLogger("").addHandler(handler);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Tractor hatchback = new Tractor("Renault Kwid", "5FTD456", "gasoline", "w.quan", 54,28,18,25.17,4353.21);		
		Tractor Sedan = new Tractor("Hyundai Elantra","70DCH80","gasoline","l.yh",128,50,40,14.68,2110.62);		
		Tractor MPV = new Tractor("Datsun GO+","VMN987","gasoline","z.siwei",68,35,25,19.83,6365.40);		
		Tractor SUV = new Tractor("Land Rover","9FUT469","gasoline","j.yijin",237,65,55,14.12,69134.20);
		Tractor SUV1 = new Tractor("Nissan Rogue","9XOT669","gasoline","s.man",170,54,45,15.30,9486.36);
		Tractor SUV2 = new Tractor("Dodge Journey","8GLQ587","gasoline","k.man",150,65,44,16.80,9437.24);
		Tractor SUV3 = new Tractor("Kia Sorento","7HMR796","gasoline","f.man",144,65,55,17.80,7334.57);
		Tractor SUV4 = new Tractor("Ford Explorer","6INS805","gasoline","l.lord",163,65,54,18.50,8235.44);
		Tractor SUV5 = new Tractor("Jeep Cherokee","5JOT914","gasoline","d.lige",167,65,51,16.10,8833.35);
		Tractor SUV6 = new Tractor("Ford Escape","4KPU323","gasoline","m.zd",165,65,49,13.20,7731.17);
		
		
		System.out.println(hatchback);		
		System.out.println(Sedan);
		System.out.println(MPV);
		System.out.println(SUV);
		System.out.println(SUV1);
		System.out.println(SUV2);
		System.out.println(SUV3);
		System.out.println(SUV4);
		System.out.println(SUV5);
		System.out.println(SUV6);
		
		
		
		TractorTaxation a = TractorTaxation.getInstance();
		a.addlist(hatchback);
		a.addlist(Sedan);
		a.addlist(MPV);
		a.addlist(SUV);
		a.addlist(SUV1);
		a.addlist(SUV2);
		a.addlist(SUV3);
		a.addlist(SUV4);
		a.addlist(SUV5);
		a.addlist(SUV6);
		a.printlist();
		a.sortTractors();
		a.printlist();
		
		
		TractorIO b = new TractorIO();
		Tractor[] ww=new Tractor[4];
		ww[0]= hatchback;
		ww[1]=Sedan;
		ww[2]=MPV;
		ww[3]=SUV;
		
		b.save(ww, "wenquan.txt");
	}

	public static void main(String[] args) {
		TractorTest test = new TractorTest();
		test.run();
	}

}