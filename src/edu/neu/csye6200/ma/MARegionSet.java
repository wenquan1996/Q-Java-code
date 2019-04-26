package edu.neu.csye6200.ma;
/**
 * @author Quan Wen
 * NUID:001497206
 */
import javax.swing.*;
import uia5.MAApp;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class MARegionSet extends MAApp{
	static private String selectedString(ItemSelectable is) { 
	    Object selected[] = is.getSelectedObjects(); 
	    return ((selected.length == 0) ? "null" : (String) selected[0]); 
	  }
	
	private JPanel panel;
	MARegion g=new MARegion();
	MARule h=new MARule("default");
	MARegion m;
	protected JButton stop  = new JButton("stop");
	protected JTextField text = new JTextField(5);
	protected JButton start = new JButton("Start");	
	int executeRule =0;

	public MARegionSet(){
		super();
		// TODO Auto-generated constructor stub
		super.frame.setSize(800, 800);

		String labels[] = { "rule1", "rule2", "rule3"};
		JComboBox comboBox = new JComboBox(labels);
		comboBox.setEditable(false);
		
		start.addActionListener(this);
		getMainPanel().add(start);
		
		stop.addActionListener(this);
		getMainPanel().add(stop);
		
		text.addActionListener(this);
		text.setEditable(true);
		
		getMainPanel().add(text);
		text.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				executeRule=Integer.valueOf(((JTextField)e.getSource()).getText());
//				System.out.println("Iteration times "+executeRule);
			}
		});
		super.frame.add(getMainPanel(), BorderLayout.SOUTH);
		super.frame.setVisible(true);
		super.frame.setTitle("Quan Cellular automation");
		
		
		comboBox.addActionListener(new ActionListener() { 

			public void actionPerformed(ActionEvent e) {
				int val = ((JComboBox)e.getSource()).getSelectedIndex();
				System.out.println( val );				
				if(val==0) {
					h.setRule("rule1");
				}
				if(val==1) {
					h.setRule("rule2");
				}
				if(val==2) {
					h.setRule("rule3");
				}

				System.out.println( h.getRule() );
			}
		});
		
		super.frame.add(comboBox, BorderLayout.NORTH);
	}
	
	//Button section
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==stop) {
			executeRule=0;
//			System.exit(0);
		}
		if(obj==start) {
			executeRule=Integer.valueOf(text.getText());
			System.out.println("Iteration times "+executeRule);
		}
	}

	public void exacution() {	
		for(int i=0;i<500;i++) {
			for(int j=0;j<500;j++) {
				if(Math.random() > 0.9) {
					g.setTable(i, j,1);
				} else {
					g.setTable(i, j,0);
				}
			}
		}
		frame.add(g);
		frame.setVisible(true);
		while( executeRule == 0 ) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while( executeRule > 0 ) {
			m=this.h.run(g);
			frame.remove(g);
			g = m;
			frame.add(g);
			frame.setVisible(true);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			executeRule -= 1;
		}
	}
	public static void main(String[]args) {
		MARegionSet f=new MARegionSet();
	    f.exacution();
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public JPanel getMainPanel() {
		// TODO Auto-generated method stub
		if( panel == null ) {
			panel = new JPanel();
		}
		return panel;
	}
}
