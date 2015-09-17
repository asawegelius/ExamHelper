package model;

public class Choice {
	   private int c_num;
	   private int cq_num;
	   private String c_desc;
	   
	   public Choice(int c_num,int cq_num,String c_desc){
		   this.c_num = c_num;
		   this.cq_num = cq_num;
		   this.c_desc = c_desc;
	   }
	   
	   public int getC_NUM(){
			  return this.c_num;
	   }
	   public void setC_NUM(int x){
			  this.c_num=x;
	   }
	   public int getCQ_NUM(){
			  return this.cq_num;
	   }
	   public void setCQ_NUM(int x){
			  this.cq_num=x;
	   }
	   public String getC_Desc(){
			  return this.c_desc;
	   }
	   public void setC_Desc(String x){
			  this.c_desc=x;
	   }
}
