/**
 * @author burcakotlu
 * @date May 6, 2014 
 * @time 11:21:39 AM
 */
package intervaltree;

import common.Commons;

/**
 * 
 */
public enum ChromosomeName {
	
	
	
	CHR0MOSOME1(1),
	CHR0MOSOME2(2),
	CHR0MOSOME3(3),
	CHR0MOSOME4(4),
	CHR0MOSOME5(5),
	CHR0MOSOME6(6),
	CHR0MOSOME7(7),
	CHR0MOSOME8(8),
	CHR0MOSOME9(9),
	CHR0MOSOME10(10),
	CHR0MOSOME11(11),
	CHR0MOSOME12(12),
	CHR0MOSOME13(13),
	CHR0MOSOME14(14),
	CHR0MOSOME15(15),
	CHR0MOSOME16(16),
	CHR0MOSOME17(17),
	CHR0MOSOME18(18),
	CHR0MOSOME19(19),
	CHR0MOSOME20(20),
	CHR0MOSOME21(21),
	CHR0MOSOME22(22),
	CHR0MOSOMEX(23),
	CHR0MOSOMEY(24);

	
	 private final int chromosomeName;
	 
	/* 
    * This constructor is private.
    * Legal to declare a non-private constructor, but not legal
    * to use such a constructor outside the enum.
    * Can never use "new" with any enum, even inside the enum 
    * class itself.
    */
    private ChromosomeName(int chromosomeName) {
    	this.chromosomeName = chromosomeName;
	}
	   
    
    public static ChromosomeName convert(String chrName){
    	
    	if (Commons.CHROMOSOME1.equals(chrName)){
    		return CHR0MOSOME1;
    	}else if  (Commons.CHROMOSOME2.equals(chrName)){
    		return CHR0MOSOME2;
    	}else if  (Commons.CHROMOSOME3.equals(chrName)){
    		return CHR0MOSOME3;
    	}else if  (Commons.CHROMOSOME4.equals(chrName)){
    		return CHR0MOSOME4;
    	}else if  (Commons.CHROMOSOME5.equals(chrName)){
    		return CHR0MOSOME5;
    	}else if  (Commons.CHROMOSOME6.equals(chrName)){
    		return CHR0MOSOME6;
    	}else if  (Commons.CHROMOSOME7.equals(chrName)){
    		return CHR0MOSOME7;
    	}else if  (Commons.CHROMOSOME8.equals(chrName)){
    		return CHR0MOSOME8;
    	}else if  (Commons.CHROMOSOME9.equals(chrName)){
    		return CHR0MOSOME9;
    	}else if  (Commons.CHROMOSOME10.equals(chrName)){
    		return CHR0MOSOME10;
    	}else if  (Commons.CHROMOSOME11.equals(chrName)){
    		return CHR0MOSOME11;
    	}else if  (Commons.CHROMOSOME12.equals(chrName)){
    		return CHR0MOSOME12;
    	}else if  (Commons.CHROMOSOME13.equals(chrName)){
    		return CHR0MOSOME13;
    	}else if  (Commons.CHROMOSOME14.equals(chrName)){
    		return CHR0MOSOME14;
    	}else if  (Commons.CHROMOSOME15.equals(chrName)){
    		return CHR0MOSOME15;
    	}else if  (Commons.CHROMOSOME16.equals(chrName)){
    		return CHR0MOSOME16;
    	}else if  (Commons.CHROMOSOME17.equals(chrName)){
    		return CHR0MOSOME17;
    	}else if  (Commons.CHROMOSOME18.equals(chrName)){
    		return CHR0MOSOME18;
    	}else if  (Commons.CHROMOSOME19.equals(chrName)){
    		return CHR0MOSOME19;
    	}else if  (Commons.CHROMOSOME20.equals(chrName)){
    		return CHR0MOSOME20;
    	}else if  (Commons.CHROMOSOME21.equals(chrName)){
    		return CHR0MOSOME21;
    	}else if  (Commons.CHROMOSOME22.equals(chrName)){
    		return CHR0MOSOME22;
    	}else if  (Commons.CHROMOSOMEX.equals(chrName)){
    		return CHR0MOSOMEX;
    	}else if  (Commons.CHROMOSOMEY.equals(chrName)){
    		return CHR0MOSOMEY;
    	}else
    		return null;
    }
	

}
