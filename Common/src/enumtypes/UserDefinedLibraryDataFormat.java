/**
 * 
 */
package enumtypes;

import common.Commons;

/**
 * @author Bur�ak Otlu
 * @date Nov 3, 2014
 * @project Common 
 *
 */
public enum UserDefinedLibraryDataFormat {
	
	USERDEFINEDLIBRARY_DATAFORMAT_0_BASED_START_ENDINCLUSIVE_COORDINATES(1),
	USERDEFINEDLIBRARY_DATAFORMAT_0_BASED_START_ENDEXCLUSIVE_COORDINATES(2),
	USERDEFINEDLIBRARY_DATAFORMAT_1_BASED_START_ENDINCLUSIVE_COORDINATES(3),
	USERDEFINEDLIBRARY_DATAFORMAT_1_BASED_START_ENDEXCLUSIVE_COORDINATES(4);
	
	private final int userDefinedLibraryDataFormat;
	
	public int getUserDefinedLibraryDataFormat() {
		return userDefinedLibraryDataFormat;
	}

	private UserDefinedLibraryDataFormat(int userDefinedLibraryDataFormat) {
    	this.userDefinedLibraryDataFormat = userDefinedLibraryDataFormat;
	}
	
	 public static UserDefinedLibraryDataFormat convertStringtoEnum(String userDefinedLibraryDataFormat){
	    	
	    	if (Commons.USERDEFINEDLIBRARY_DATAFORMAT_0_BASED_START_ENDINCLUSIVE_COORDINATES.equals(userDefinedLibraryDataFormat)){
	    		return USERDEFINEDLIBRARY_DATAFORMAT_0_BASED_START_ENDINCLUSIVE_COORDINATES;
	    	}else if  (Commons.USERDEFINEDLIBRARY_DATAFORMAT_0_BASED_START_ENDEXCLUSIVE_COORDINATES.equals(userDefinedLibraryDataFormat)){
	    		return USERDEFINEDLIBRARY_DATAFORMAT_0_BASED_START_ENDEXCLUSIVE_COORDINATES;
	    	}else if (Commons.USERDEFINEDLIBRARY_DATAFORMAT_1_BASED_START_ENDINCLUSIVE_COORDINATES.equals(userDefinedLibraryDataFormat)){
	    		return USERDEFINEDLIBRARY_DATAFORMAT_1_BASED_START_ENDINCLUSIVE_COORDINATES;	
	    	}else if (Commons.USERDEFINEDLIBRARY_DATAFORMAT_1_BASED_START_ENDEXCLUSIVE_COORDINATES.equals(userDefinedLibraryDataFormat)){
	    		return USERDEFINEDLIBRARY_DATAFORMAT_1_BASED_START_ENDEXCLUSIVE_COORDINATES;
	    	}else
	    		return null;
	 }
	
	 
	 public static String convertEnumtoString(UserDefinedLibraryDataFormat userDefinedLibraryDataFormat){
	    	
	    	if (USERDEFINEDLIBRARY_DATAFORMAT_0_BASED_START_ENDINCLUSIVE_COORDINATES.equals(userDefinedLibraryDataFormat)){
	    		return Commons.USERDEFINEDLIBRARY_DATAFORMAT_0_BASED_START_ENDINCLUSIVE_COORDINATES;
	    	}else if  (USERDEFINEDLIBRARY_DATAFORMAT_0_BASED_START_ENDEXCLUSIVE_COORDINATES.equals(userDefinedLibraryDataFormat)){
	    		return Commons.USERDEFINEDLIBRARY_DATAFORMAT_0_BASED_START_ENDEXCLUSIVE_COORDINATES;
	    	}else if (USERDEFINEDLIBRARY_DATAFORMAT_1_BASED_START_ENDINCLUSIVE_COORDINATES.equals(userDefinedLibraryDataFormat)){
	    		return Commons.USERDEFINEDLIBRARY_DATAFORMAT_1_BASED_START_ENDINCLUSIVE_COORDINATES;	
	    	}else if (USERDEFINEDLIBRARY_DATAFORMAT_1_BASED_START_ENDEXCLUSIVE_COORDINATES.equals(userDefinedLibraryDataFormat)){
	    		return Commons.USERDEFINEDLIBRARY_DATAFORMAT_1_BASED_START_ENDEXCLUSIVE_COORDINATES;
	    	}else
	    		return null;
	 }
	

}
