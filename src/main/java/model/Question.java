package model;

public class Question {
	   private int q_num;
	   private int qc_num;
	   private String name;
	   private String q_desc;
	   
	   public Question(int q_num,int qc_num,String name,String q_desc){
		   this.q_num = q_num;
		   this.qc_num = qc_num;
		   this.name = name;
		   this.q_desc = q_desc;
	   }
	   
	   public int getQ_NUM(){
			  return this.q_num;
	   }
	   public void setQ_NUM(int x){
			  this.q_num=x;
	   }
	   public int getQC_NUM(){
			  return this.qc_num;
	   }
	   public void setQC_NUM(int x){
			  this.qc_num=x;
	   }
	   public String getName(){
			  return this.name;
	   }
	   public void setName(String x){
			  this.name=x;
	   }
	   public String getQ_Desc(){
			  return this.q_desc;
	   }
	   public void setQ_Desc(String x){
			  this.q_desc=x;
	   }

}
