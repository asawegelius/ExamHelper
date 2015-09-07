package model;

public enum Chapter {
	THE_FUNDAMENTALS_OF_TESTING(1), LIFE_CYCLES(2), STATIC_TESTING(3), TEST_DESIGN_TECHNIQUES(4),
	TEST_MANAGEMENT(5),TOOL_SUPPORT_FOR_TESTING(6), THE_EXAMINATION (7);
	
    private final int no;
    
    private Chapter(int no) {
        this.no = no;
}

    private final String[] heading = {"THE FUNDAMENTALS OF TESTING", "LIFE CYCLES", "STATIC TESTING", 
    		"TEST DESIGN TECHNIQUES", "TEST MANAGEMENT", "TOOL SUPPORT FOR TESTING", "THE EXAMINATION"};

    
    public int getChapterNo() {
        return this.no;
    }
    
    public String getHeader(){
    	return this.heading[this.no + 1];
    }
  
}
