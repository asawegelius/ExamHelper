package model;

public enum Chapter {
	THE FUNDAMENTALS OF TESTING(1), LIFE CYCLES(2), STATIC TESTING(3), TEST DESIGN TECHNIQUES(4),
	TEST MANAGEMENT(5),TOOL SUPPORT FOR TESTING(6), THE EXAMINATION (7);
	
    private final int chapter;

    Level(int chapter) {
        this.chapter = chapter;
    }
    
    public int getChapter() {
        return this.chapter;
    }
}
