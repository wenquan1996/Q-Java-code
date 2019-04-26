package edu.neu.csye6200.tractor;

import java.io.*;
import java.util.logging.*;

public class TractorIO {

	private static Logger log = Logger.getLogger(TractorIO.class.getName());
	
	public TractorIO() {
		// TODO Auto-generated constructor stub
		log.info("Constructing a TractorIO instance");
	}
	
	public void save(Tractor[] tr1,String filename){
		log.info(String.format("Save %d Tractor instance(s).", tr1.length));
		String path = "src/edu/neu/csye6200/tractor/" + filename;
		
		try {
			FileWriter fw= new FileWriter(path);
			for (int i = 0; i < tr1.length; i++) {
				Tractor tractor = tr1[i];
				save1(tractor,fw);	
			}
			fw.close();
		} catch(IOException var1) {
			log.severe("Save filed");
			var1.printStackTrace();
		}
		
		
	}
	
	private void save1(Tractor tr,FileWriter fw){
		log.info(String.format("Save a Tractor instance."));
		try {
			fw.write(tr.make+"#"+tr.model+"#"+tr.fueltype+"#"+String.valueOf(tr.tractorpower) + "#"+String.valueOf(tr.fuelcapacity)+ "#"+String.valueOf(tr.fuelload)+ "#"+String.valueOf(tr.fuelefficiency)+ "#"+String.valueOf(tr.range)+"#"+tr.OwnerId+"#"+String.valueOf(tr.tractorvalue));	
		} catch(IOException var2) {
			log.severe("Save filed");
			var2.printStackTrace();
		}
	}
	
	public void load(Tractor[] tr1,String st)throws IOException {
		log.info(String.format("Load a Tractor instance."));
	}
}
