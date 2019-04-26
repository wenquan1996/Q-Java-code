package edu.neu.csye6200.ma;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JPanel;

/**
 * @author Quan Wen
 * NUID:001497206
 */

public class MARegion extends JPanel {
	private static final long serialVersionUID = 1L;
	private MAcell cell[][];
	private final int CELLSIZE = 5;
	int neighbors = 0;

	public MARegion() {
		// TODO Auto-generated constructor stub
		this.cell=new MAcell[500][500];
	}
	public void setTable(int x,int y,int z) {
		if( this.cell[x][y] == null ) {
			this.cell[x][y] = new MAcell();
		}
		this.cell[x][y].setA(z);
		
	}
	public int getTable(int x,int y) {
		return this.cell[x][y].getA();	
	}
	
	
	public int getNeighborCells(int x, int y) {
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if(i<0||j<0||i>=500||j>=500||(i==x&&i==y))continue;
		        if (cell[i][j].getA() == 1 && (x != i || y != j))
		            neighbors += 1;
			}
		}
		return neighbors;
	}
	
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    for (int i = 0; i <cell.length; i++) {
	        for (int j = 0; j < cell.length; j++) {
	            if (cell[i][j].getA() == 1) {
	                g.setColor(Color.RED);
	                g.fillRect(j * CELLSIZE, i * CELLSIZE, CELLSIZE, CELLSIZE);
	            }
	            else {
	                g.setColor(Color.YELLOW);
	                g.fillRect(j * CELLSIZE, i * CELLSIZE, CELLSIZE, CELLSIZE);
	            }
	        }
	    }
	}

}
