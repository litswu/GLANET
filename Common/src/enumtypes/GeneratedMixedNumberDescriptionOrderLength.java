/**
 * @author burcakotlu
 * @date May 15, 2014 
 * @time 9:43:28 AM
 */
package enumtypes;

/**
 * 	//Long.MAX_VALUE	 9223372_0368_5477_5807 19 digits
 *  //Int.MAX_VALUE		 214748_3647 10 digitds
 *  
 */
public enum GeneratedMixedNumberDescriptionOrderLength {
	
	
	//WITH ZSCORES starts
	INT_4DIGIT_DNASECELLLINENUMBER(1),
	INT_4DIGIT_TFNUMBER_4DIGIT_CELLLINENUMBER(2), 
	INT_4DIGIT_HISTONENUMBER_4DIGIT_CELLLINENUMBER(3),
	INT_4DIGIT_KEGGPATHWAYNUMBER(4),
	
	INT_4DIGIT_TFNUMBER_4DIGIT_KEGGPATHWAYNUMBER(5),
	LONG_4DIGIT_TFNUMBER_4DIGIT_CELLLINENUMBER_4DIGIT_KEGGPATHWAYNUMBER(6),
	INT_4DIGITS_ELEMENTNUMBER_3DIGITS_CELLLINENUMBER_3DIGITS_KEGGPATHWAYNUMBER(7),
	
	INT_10DIGIT_USERDEFINEDGENESETNUMBER(8), 
	
	INT_6DIGITS_PERMUTATIONNUMBER_4DIGITS_KEGGPATHWAYNUMBER(9), 
	INT_6DIGITS_PERMUTATIONNUMBER_4DIGITS_CELLLINENUMBER(10),
	//Modified 23 July 2015
	LONG_7DIGITS_PERMUTATIONNUMBER_10DIGITS_USERDEFINEDGENESETNUMBER(11),	
	LONG_7DIGITS_PERMUTATIONNUMBER_4DIGITS_ELEMENTNUMBER_4DIGITS_CELLLINENUMBER_4DIGITS_KEGGPATHWAYNUMBER(12),
	
	//USERDEFINED LIBRARY
	//WITHZSCORES and WITHOUTZSCORES commonly used
	INT_6DIGIT_ELEMENTNUMBER( 13), 
	INT_4DIGIT_ELEMENTTYPENUMBER_6DIGIT_ELEMENTNUMBER( 14),
	LONG_7DIGIT_PERMUTATIONNUMBER_4DIGIT_ELEMENTTYPENUMBER_6DIGIT_ELEMENTNUMBER( 15),
	
	//GENES
	//WITHZSCORES and WITHOUTZSCORES commonly used
	INT_10DIGIT_GENENUMBER(16), 
	LONG_7DIGIT_PERMUTATIONNUMBER_10DIGIT_GENENUMBER(17),
	//WITH ZSCORES ends

	//WITHOT ZSCORES starts
	//14 SEPTEMBER 2015
	INT_10DIGIT_DNASECELLLINENUMBER(18), 
	INT_10DIGIT_KEGGPATHWAYNUMBER(19), 
	
	//3 July 2015
	INT_5DIGITS_ELEMENTNUMBER_5DIGITS_CELLLINENUMBER(20),
	//10 July 2015
	INT_5DIGITS_ELEMENTNUMBER_5DIGITS_KEGGPATHWAYNUMBER(21),	
	LONG_5DIGITS_ELEMENTNUMBER_5DIGITS_CELLLINENUMBER_5DIGITS_KEGGPATHWAYNUMBER(22);
	//WITHOT ZSCORES ends
	
	private final int generatedMixedNumberDescriptionOrderLength;

	/*
	 * This constructor is private.
	 * Legal to declare a non-private constructor, but not legal
	 * to use such a constructor outside the enum.
	 * Can never use "new" with any enum, even inside the enum
	 * class itself.
	 */
	private GeneratedMixedNumberDescriptionOrderLength( int generatedMixedNumberDescriptionOrderLength) {

		this.generatedMixedNumberDescriptionOrderLength = generatedMixedNumberDescriptionOrderLength;
	}

	public int getGeneratedMixedNumberDescriptionOrderLength() {

		return generatedMixedNumberDescriptionOrderLength;
	}

	public boolean is_INT_4DIGIT_DNASECELLLINENUMBER() {

		return this == INT_4DIGIT_DNASECELLLINENUMBER;
	}

	/** An added method.  */
	public boolean is_INT_10DIGIT_USERDEFINEDGENESETNUMBER() {

		return this == INT_10DIGIT_USERDEFINEDGENESETNUMBER;
	}

	/** An added method.  */
	public boolean is_INT_4DIGIT_KEGGPATHWAYNUMBER() {

		return this == INT_4DIGIT_KEGGPATHWAYNUMBER;
	}
	
	
	/** An added method.  */
	public boolean is_INT_10DIGIT_KEGGPATHWAYNUMBER() {
		return this == INT_10DIGIT_KEGGPATHWAYNUMBER;
	}
	
	
	/** An added method.  */
	public boolean is_INT_5DIGITS_ELEMENTNUMBER_5DIGITS_KEGGPATHWAYNUMBER() {
		return this == INT_5DIGITS_ELEMENTNUMBER_5DIGITS_KEGGPATHWAYNUMBER;
	}
	

	/** An added method.  */
	public boolean is_LONG_5DIGITS_ELEMENTNUMBER_5DIGITS_CELLLINENUMBER_5DIGITS_KEGGPATHWAYNUMBER() {
		return this == LONG_5DIGITS_ELEMENTNUMBER_5DIGITS_CELLLINENUMBER_5DIGITS_KEGGPATHWAYNUMBER;
	}

	/** An added method.  */
	public boolean is_INT_4DIGIT_TFNUMBER_4DIGIT_CELLLINENUMBER() {

		return this == INT_4DIGIT_TFNUMBER_4DIGIT_CELLLINENUMBER;
	}

	/** An added method.  */
	public boolean is_INT_4DIGIT_HISTONENUMBER_4DIGIT_CELLLINENUMBER() {

		return this == INT_4DIGIT_HISTONENUMBER_4DIGIT_CELLLINENUMBER;
	}

	/** An added method.  */
	public boolean is_INT_4DIGIT_TFNUMBER_4DIGIT_KEGGPATHWAYNUMBER() {

		return this == INT_4DIGIT_TFNUMBER_4DIGIT_KEGGPATHWAYNUMBER;
	}

	/** An added method.  */
	public boolean is_LONG_4DIGIT_TFNUMBER_4DIGIT_CELLLINENUMBER_4DIGIT_KEGGPATHWAYNUMBER() {

		return this == LONG_4DIGIT_TFNUMBER_4DIGIT_CELLLINENUMBER_4DIGIT_KEGGPATHWAYNUMBER;
	}

	public boolean is_INT_4DIGITS_ELEMENTNUMBER_3DIGITS_CELLLINENUMBER_3DIGITS_KEGGPATHWAYNUMBER() {

		return this == INT_4DIGITS_ELEMENTNUMBER_3DIGITS_CELLLINENUMBER_3DIGITS_KEGGPATHWAYNUMBER;
	}

	public boolean is_LONG_7DIGITS_PERMUTATIONNUMBER_10DIGITS_USERDEFINEDGENESETNUMBER() {

		return this == LONG_7DIGITS_PERMUTATIONNUMBER_10DIGITS_USERDEFINEDGENESETNUMBER;
	}

	public boolean is_INT_6DIGITS_PERMUTATIONNUMBER_4DIGITS_KEGGPATHWAYNUMBER() {

		return this == INT_6DIGITS_PERMUTATIONNUMBER_4DIGITS_KEGGPATHWAYNUMBER;
	}

	public boolean is_INT_6DIGITS_PERMUTATIONNUMBER_4DIGITS_CELLLINENUMBER() {

		return this == INT_6DIGITS_PERMUTATIONNUMBER_4DIGITS_CELLLINENUMBER;
	}

	public boolean is_LONG_7DIGITS_PERMUTATIONNUMBER_4DIGITS_ELEMENTNUMBER_4DIGITS_CELLLINENUMBER_4DIGITS_KEGGPATHWAYNUMBER() {

		return this == LONG_7DIGITS_PERMUTATIONNUMBER_4DIGITS_ELEMENTNUMBER_4DIGITS_CELLLINENUMBER_4DIGITS_KEGGPATHWAYNUMBER;
	}

	public boolean is_LONG_7DIGIT_PERMUTATIONNUMBER_4DIGIT_ELEMENTTYPENUMBER_6DIGIT_ELEMENTNUMBER() {

		return this == LONG_7DIGIT_PERMUTATIONNUMBER_4DIGIT_ELEMENTTYPENUMBER_6DIGIT_ELEMENTNUMBER;
	}

	public boolean is_INT_4DIGIT_ELEMENTTYPENUMBER_6DIGIT_ELEMENTNUMBER() {

		return this == INT_4DIGIT_ELEMENTTYPENUMBER_6DIGIT_ELEMENTNUMBER;
	}

}
