package model;


public class Answer {
   private int a_num;
   private int ac_num;
   private int aq_num;
   private String a_desc;
   
   public Answer(int a_num,int ac_num,int aq_num,String a_desc){
	   this.a_num = a_num;
	   this.ac_num = ac_num;
	   this.aq_num = aq_num;
	   this.a_desc = a_desc;
   }
   
   public int getA_NUM(){
		  return this.a_num;
   }
   public void setA_NUM(int x){
		  this.a_num=x;
   }
   public int getAC_NUM(){
		  return this.ac_num;
   }
   public void setAC_NUM(int x){
		  this.ac_num=x;
   }
   public int getAQ_NUM(){
		  return this.aq_num;
   }
   public void setAQ_NUM(int x){
		  this.aq_num=x;
   }
   public String getA_Desc(){
		  return this.a_desc;
   }
   public void setA_Desc(String x){
		  this.a_desc=x;
   }
}
