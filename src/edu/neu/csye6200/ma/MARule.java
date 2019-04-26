package edu.neu.csye6200.ma;
/**
 * @author Quan Wen
 * NUID:001497206
 */
public class MARule {
	MARegion c;
	String ruleName;
	public MARule() {
		// TODO Auto-generated constructor stub
		ruleName="default";
	}
	public MARule( String name ) {
		ruleName = name;
	}
	public void setRule( String name ) {
		ruleName = name;
	}
	public String getRule() {
		return ruleName;
	}
	public MARegion run(MARegion cell) {
		MARegion ret;
		if(ruleName.equals("rule1")) {
			ret = rule1(cell);
		} else if( ruleName.equals("rule2")) {
			ret = rule2(cell);
		} else if(ruleName.equals("rule3")) {
			ret = rule3(cell);
		} else if(ruleName.equals("default")) {
			ret = default1(cell);
		} else {
			ret = reset(cell);
		}
		return ret;
	}
	public MARegion rule1(MARegion cell) {
		c=new MARegion();
		for(int i=0;i<500;i++) {
			for(int j=0;j<500;j++) {
				int count=0;
				for(int a=i-1;a<=i+1;a++) {
					for(int b=j-1;b<=j+1;b++) {
						if(a<0||b<0||a>=500||b>=500||(a==i&&b==j))continue;
						if(cell.getTable(a, b)==1)count++;
						
					}
				}
				if(count>=3) c.setTable(i, j, 1);
				else c.setTable(i, j, 0);
			}
		}
		return c;
	}
	
	public MARegion rule2(MARegion cell) {
		c=new MARegion();
		int a;
		for (int i = 0; i < 500; i++) {
			for (int j = 0; j < 500; j++) {
		        cell.getNeighborCells(i, j);
		        if (cell.getTable(i, j) == 1) {
		            if ((cell.getNeighborCells(i, j) < 2) || (cell.getNeighborCells(i, j)> 3)) {
		            	c.setTable(i, j, 0); //loneliness or overpopulation
		            } else {
		            	c.setTable(i, j, 1);  //stay alive
		            }
		        }
		        if (cell.getTable(i, j) == 0) {
		        	if( cell.getNeighborCells(i, j) == 3) {
		        		c.setTable(i, j, 1);    //give birth to new cell
		        	} else {
		        		c.setTable(i, j, a= (int)(10*Math.random()%2));
		        	}
		        }
		    }
		}
		return c;
	}
	public MARegion rule3(MARegion cell) {
		c=new MARegion();
		int b;
		for (int i = 0; i < 500; i++) {
			for (int j = 0; j < 500; j++) {
		        cell.getNeighborCells(i, j);
		        
		        if (cell.getTable(i, j) == 1) {
		            if ((cell.getNeighborCells(i, j) < 2) || (cell.getNeighborCells(i, j)> 3)) {
		            	c.setTable(i, j, 0); //loneliness or overpopulation
		            }
		            if ((cell.getNeighborCells(i, j) == 2) || (cell.getNeighborCells(i, j)== 3)) {
		            	c.setTable(i, j, 1); //stay alive
		            }
		        }
		        
		        
		        
		        if (cell.getTable(i, j) == 0) {
		        	if( cell.getNeighborCells(i, j) == 3) {
		        		c.setTable(i, j, 1);    //give birth to new cell
		        	}
		        	if( cell.getNeighborCells(i, j) == 3&&cell.getNeighborCells(i, j)==0) {
		        		c.setTable(i, j, 1);    //give birth to new cell
		        	}
		        	
		        	else {
		        		c.setTable(i, j, 1);
		        	}
		        }
		        
		    }
		}
		return c;
	}
	public MARegion reset(MARegion cell) {
		c=new MARegion();
		for(int i=0;i<500;i++) {
			for(int j=0;j<500;j++) {
				if(j%2==0&&i%2==0) {
					c.setTable(i, j, 0);
					}
				else if(j%2==1&&j%2==1) { 
					c.setTable(i, j, 0);
					}
				else {
					c.setTable(i, j, 1);
				}
			}
		}
		return c;
	}
	public MARegion default1(MARegion cell) {
		c=new MARegion();
		for(int i=0;i<500;i++) {
			for(int j=0;j<500;j++) {
				if(j%2==0&&i%2==0) {
					c.setTable(i, j, 0);
					}
				else if(j%2==1&&j%2==1) { 
					c.setTable(i, j, 0);
					}
				else {
					c.setTable(i, j, 1);
				}
			}
		}
		return c;
	}
}
