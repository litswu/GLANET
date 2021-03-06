/**
 * @author Burcak Otlu
 * Aug 8, 2013
 * 11:06:24 PM
 * 2013
 *
 *
 *	This class will calculate the gc of an given interval
 * 
 */
package gc;

import gnu.trove.iterator.TIntIntIterator;
import gnu.trove.list.TByteList;
import gnu.trove.map.TIntIntMap;
import gnu.trove.map.hash.TIntIntHashMap;
import intervaltree.GCIsochoreIntervalTreeHitNode;
import intervaltree.Interval;
import intervaltree.IntervalTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import ui.GlanetRunner;

import common.Commons;

import enrichment.GCCharArray;
import enrichment.InputLine;
import enumtypes.CalculateGC;
import enumtypes.ChromosomeName;
import enumtypes.CommandLineArguments;
import enumtypes.IsochoreFamily;

public class GC {

	final static Logger logger = Logger.getLogger(GC.class);

	static GCCharArray gcCharArray;

	public static GCCharArray getGcCharArray() {

		return gcCharArray;
	}

	public static void setGcCharArray( GCCharArray gcCharArray) {

		GC.gcCharArray = gcCharArray;
	}

	public GC() {

		super();
		// TODO Auto-generated constructor stub
	}

	
	//Simple Way
	public static IsochoreFamily calculateIsochoreFamily( float gcPercentage) {

		IsochoreFamily isochoreFamily = null;

		// L1, L2, H1, H2 and H3, with GC contents of
		// <38%, (>=38%,<42%) , (>=42%,<47%), (>=47%,<52%), (>=52%)  respectively

		if( gcPercentage < 0.38f){
			isochoreFamily = IsochoreFamily.L1;
		}else if( gcPercentage >= 0.38f && gcPercentage < 0.42f){
			isochoreFamily = IsochoreFamily.L2;
		}else if( gcPercentage >= 0.42f && gcPercentage < 0.47f){
			isochoreFamily = IsochoreFamily.H1;
		}else if( gcPercentage >= 0.47f && gcPercentage < 0.52f){
			isochoreFamily = IsochoreFamily.H2;
		}else if( gcPercentage >= 0.52f){
			isochoreFamily = IsochoreFamily.H3;
		}

		return isochoreFamily;
	}
	
	
	// Complex way
	// Right now complex way is not called.
	// Each hit also has numberofOverlappingBases starts
	// Analyze each hit
	// Accumulate the numberofOverlappingBases for each isochoreFamily
	// Then return the isochoreFamily with the maximum numberofOverlappingBases as the isochoreFamily of related interval
	// Long story in short: return the isochoreFamily with the highest vote!!! 
	public static IsochoreFamily calculateIsochoreFamily( List<GCIsochoreIntervalTreeHitNode> hits) {

		GCIsochoreIntervalTreeHitNode gcIsochoreIntervalTreeHitNode = null;
		IsochoreFamily isochoreFamilyofInputLine = null;
		IsochoreFamily isochoreFamilyofHit = null;
		int isochoreFamilyNumberofHit;
		int numberofOverlappingBasesofHit;
		TIntIntMap isochoreFamily2NumberofOverlappingBases = null;

		int maximumNumberofHits = Integer.MIN_VALUE;
		int isochoreFamilyNumberWithMaximumNumberofHits = 0;

		if( hits.size() == 0){
			if( GlanetRunner.shouldLog())logger.error( "There is a situation. Number of hits is 0");
		}

		// There is only one hit case
		else if( hits.size() == 1){
			isochoreFamilyofInputLine = hits.get(0).getIsochoreFamily();
		}

		// There is more than one hit case
		else{

			isochoreFamily2NumberofOverlappingBases = new TIntIntHashMap();

			for( int i = 0; i < hits.size(); i++){

				gcIsochoreIntervalTreeHitNode = hits.get(i);

				isochoreFamilyofHit = gcIsochoreIntervalTreeHitNode.getIsochoreFamily();
				isochoreFamilyNumberofHit = isochoreFamilyofHit.getIsochoreFamily();

				numberofOverlappingBasesofHit = gcIsochoreIntervalTreeHitNode.getNumberofOverlappingBases();
				// Accumulate
				if( !isochoreFamily2NumberofOverlappingBases.containsKey( isochoreFamilyNumberofHit)){
					isochoreFamily2NumberofOverlappingBases.put( isochoreFamilyNumberofHit,numberofOverlappingBasesofHit);
				}else{
					isochoreFamily2NumberofOverlappingBases.put(
							isochoreFamilyNumberofHit,
							isochoreFamily2NumberofOverlappingBases.get(isochoreFamilyNumberofHit) + numberofOverlappingBasesofHit);
				}

			}// End of for Each Hit

			// Choose the isochoreFamilyNumber with the maximum number of overlapping Bases
			for( TIntIntIterator itr = isochoreFamily2NumberofOverlappingBases.iterator(); itr.hasNext();){
				
				itr.advance();

				if( itr.value() > maximumNumberofHits){
					maximumNumberofHits = itr.value();
					isochoreFamilyNumberWithMaximumNumberofHits = itr.key();
				}

			}// End of For Finding isochoreFamilyWithMaximumNumberofHits

			// Convert int to IsochoreFamily
			isochoreFamilyofInputLine = IsochoreFamily.convertInttoEnum(isochoreFamilyNumberWithMaximumNumberofHits);

		}// End of ELSE Part

		return isochoreFamilyofInputLine;

	}
	// ends


	// for variance calculation among functional elements' gc values
	public static float calculateGC( int low, int high, GCCharArray gcCharArray) {

		float gcContent = 0;

		int value;
		int length = high - low + 1;

		for( int i = low; i <= high; i++){
			// ascii 0 = 48 decimal
			// ascii 1 = 49 decimal
			value = gcCharArray.getGcArray()[i] - 48;
			gcContent = gcContent + value;
		}//End of FOR
		
		gcContent = gcContent / length;

		return gcContent;
	}

	// There can be gaps in the intervals of GC Interval Tree
	public static float calculateGCofIntervalUsingIntervalTree(Interval givenInputLine,IntervalTree gcIntervalTree, CalculateGC calculateGC) {

		Float gcContent = 0f;

		gcContent = gcIntervalTree.findAllOverlappingGCIntervals( gcIntervalTree.getRoot(), givenInputLine, calculateGC);

		gcContent = gcContent / ( givenInputLine.getHigh() - givenInputLine.getLow() + 1);

		return gcContent;
	}

	//Not called anymore
	// Calculate the GC of the given interval using GCIsochoreIntervalTree
	// In case of length of the given interval is greater than 100KB
//	public static GCIsochoreIntervalTreeFindAllOverlapsResult calculateGCofIntervalUsingIsochoreIntervalTree(
//			InputLineMinimal givenInputLine, 
//			IntervalTree gcIsochoreIntervalTree) {
//
//		GCIsochoreIntervalTreeFindAllOverlapsResult result = new GCIsochoreIntervalTreeFindAllOverlapsResult();
//
//		gcIsochoreIntervalTree.findAllOverlappingGCIsochoreIntervals( gcIsochoreIntervalTree.getRoot(), givenInputLine,result);
//		// gcContent = gcIsochoreIntervalTree.findAllOverlappingGCIntervals(gcIsochoreIntervalTree.getRoot(),
//		// givenInputLine,calculateGC);
//
//		result.setGc(result.getNumberofGCs() / (givenInputLine.getHigh() - givenInputLine.getLow() + 1));
//		result.setIsochoreFamily(calculateIsochoreFamily(result.getGc()));
//		
//		// This is a complex way of deciding on isochoreFamily
//		// Why don't we just look at the result.getGc() and classify the isochoreFamily of interval accordingly
//		//result.setIsochoreFamily(calculateIsochoreFamily( result.getHits()));
//
//		return result;
//	}

	// new starts
	public static float calculateGCofIntervalUsingTroveList( Interval givenInputLine, TByteList gcByteList) {

		// new gcByteList is 0-based
		// old gcCharArray is 0-based
		// GLANET uses 0-based coordinates
		// Genome Browser uses is 1-based coordinates.

		// General Information
		// One byte has 8 bits.
		// Starting from index 0 to 7
		// Bit at index 0 a dummy bit which is always 0

		// I have only used last seven bits of a byte
		// Which guarantees a positive byte
		// By taking mod w.r.t. 7 I got 0 to 6
		// ith bit is in fact i+1 th bit of the byte

		// Now Let's look into gcByteList
		// 0th byte corresponds to 0..6 of old gcCharArray
		// 1th byte corresponds to 7..13 of old gcCharArray
		// 2th byte corresponds to 14..20 of old gcCharArray
		// 3th byte corresponds to 21..27 of old gcCharArray
		// ...
		// nth byte of new gcByteList corresponds to n*7..n*7+6th chrachter of old gcCharArray

		// Dividing 0-based chromosome position by 7 we got the corresponding byte in gcByteList
		// Taking mod of 0-based chromosome position w.r.t. 7 we got the corresponding bit position within a byte.
		// which is between 0 and 6.
		//Since we have dummy 0 at the 0th index of gcByte
		//we must add by 1 in order to get the real index of base pair in gcByte.
		//which means that ith bit is in (i+1)th index of  the gcByte

		int zeroBasedStart = givenInputLine.getLow();
		int zeroBasedEnd = givenInputLine.getHigh();
		int length = zeroBasedEnd - zeroBasedStart + 1;

		float gcContent = 0;
		byte gcByte = 0x00;
		int numberofRightShifts = 0;

		// Get the start byte
		int byteListStartByte = zeroBasedStart / 7;

		// Get the starting bit in start byte
		int byteListStartBit = zeroBasedStart % 7;

		// Get the last byte
		int byteListEndByte = zeroBasedEnd / 7;

		// Get the last bit of last byte
		int byteListEndBit = zeroBasedEnd % 7;

		// Debug purposes starts
		if( ( byteListStartByte > byteListEndByte) || ( ( byteListStartByte == byteListEndByte) && ( byteListStartBit > byteListEndBit))){

			if( GlanetRunner.shouldLog())logger.error( "There is a situation");
		}
		// Debug purposes ends

		// Valid Input
		if( byteListStartByte < gcByteList.size() && byteListEndByte < gcByteList.size()){

			// First Byte case
			// start reading from starting Byte
			gcByte = gcByteList.get( byteListStartByte);

			// SNP case
			if( byteListStartByte == byteListEndByte && byteListStartBit == byteListEndBit){

				numberofRightShifts = 6 - byteListStartBit;
				gcContent = gcContent + ( ( gcByte >> numberofRightShifts) & 0x01);

			}
			// Interval Case In the Same Byte
			else if( byteListStartByte == byteListEndByte && byteListStartBit != byteListEndBit){

				for( int i = byteListStartBit; i <= byteListEndBit; i++){
					numberofRightShifts = 6 - i;
					gcContent = gcContent + ( ( gcByte >> numberofRightShifts) & 0x01);
				}// End of for

			}
			// Interval Case At Least Two Bytes
			else if( byteListStartByte != byteListEndByte){

				// First Byte
				for( int i = byteListStartBit; i <= 6; i++){
					numberofRightShifts = 6 - i;
					gcContent = gcContent + ( ( gcByte >> numberofRightShifts) & 0x01);
				}

				// Middle Byte cases
				// start reading from bit 1 to 7
				for( int byteIndex = byteListStartByte + 1; byteIndex < byteListEndByte; byteIndex++){

					// get GC Byte
					gcByte = gcByteList.get( byteIndex);

					// middle cases
					// start reading from bit 1 to 7
					for( int i = 0; i <= 6; i++){
						numberofRightShifts = 6 - i;
						gcContent = gcContent + ( ( gcByte >> numberofRightShifts) & 0x01);
					}

				}// End of for

				// Last Byte
				// start reading from bit 1 to ending bit
				gcByte = gcByteList.get( byteListEndByte);

				for( int i = 0; i <= byteListEndBit; i++){
					numberofRightShifts = 6 - i;
					gcContent = gcContent + ( ( gcByte >> numberofRightShifts) & 0x01);
				}

			}

			gcContent = gcContent / length;

		}
		// Not a valid input
		else{
			if( GlanetRunner.shouldLog())logger.error( "byteListStartByte: " + byteListStartByte + "\t" + "byteListEndByte: " + byteListEndByte + "\t" + "gcByteList.size(): " + gcByteList.size());
			if( GlanetRunner.shouldLog())logger.error( "Input line's high exceeds hg19 chromsome size");
		}

		return gcContent;

	}

	// new ends

	public static float calculateGCofInterval( InputLine givenInputLine, GCCharArray gcArray) {

		int low = givenInputLine.getLow();
		int high = givenInputLine.getHigh();
		int length = high - low + 1;
		int value;
		float gcContent = 0;

		if( high < gcArray.getGcArray().length){
			for( int i = low; i <= high; i++){
				// ascii 0 = 48 decimal
				// ascii 1 = 49 decimal
				value = gcArray.getGcArray()[i] - 48;
				gcContent = gcContent + value;
			}
			gcContent = gcContent / length;
		}else{
			System.out.println("input line's high exceeds hg19 chromsome size");
		}

		return gcContent;

	}

	public static void fillChromBasedGCArrayfromFastaFile( String dataFolder, String gcFastaFileName,
			GCCharArray gcArray) {

		FileReader fileReader;
		BufferedReader bufferedReader;
		int numberofCharactersRead;

		char[] cbuf = new char[10000];
		char ch;
		int nthBase = 0;
		String strLine;

		try{
			fileReader = new FileReader( dataFolder + gcFastaFileName);
			bufferedReader = new BufferedReader( fileReader);

			// skip first informative line of fasta file
			strLine = bufferedReader.readLine();

			// check whether fasta file starts with > greater character
			if( !strLine.startsWith( ">")){
				System.out.println( "Fasta file does not start with > character.");
			}

			while( ( numberofCharactersRead = bufferedReader.read( cbuf)) != -1){

				// GlanetRunner.appendLog("number of characters read: " + numberofCharactersRead);

				for( int i = 0; i < numberofCharactersRead; i++){
					ch = cbuf[i];

					if( ( ( ch == Commons.NUCLEIC_ACID_UPPER_CASE_A) || ( ch == Commons.NUCLEIC_ACID_LOWER_CASE_A)) || ( ( ch == Commons.NUCLEIC_ACID_UPPER_CASE_T) || ( ch == Commons.NUCLEIC_ACID_LOWER_CASE_T)) || ( ( ch == Commons.NUCLEIC_ACID_UPPER_CASE_N) || ( ch == Commons.NUCLEIC_ACID_LOWER_CASE_N))){

						gcArray.getGcArray()[nthBase++] = '0';
						// gcArray[nthBase++] = '0';

					}else if( ( ( ch == Commons.NUCLEIC_ACID_UPPER_CASE_G) || ( ch == Commons.NUCLEIC_ACID_LOWER_CASE_G)) || ( ( ch == Commons.NUCLEIC_ACID_UPPER_CASE_C) || ( ch == Commons.NUCLEIC_ACID_LOWER_CASE_C))){

						gcArray.getGcArray()[nthBase++] = '1';
						// gcArray[nthBase++] = '1';
					}

				}// end of for
			}// end of while

			System.out.println("nthBase must be written once: " + nthBase + " gcCharArray construction has ended.");

		}catch( FileNotFoundException e){
			e.printStackTrace();
		}catch( IOException e){
			e.printStackTrace();
		}

	}

	public static void fillChromBasedGCArray( String dataFolder, ChromosomeName chromName, GCCharArray gcArray) {

		switch( chromName){
		case CHROMOSOME1:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR1_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME2:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR2_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME3:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR3_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME4:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR4_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME5:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR5_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME6:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR6_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME7:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR7_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME8:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR8_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME9:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR9_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME10:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR10_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME11:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR11_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME12:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR12_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME13:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR13_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME14:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR14_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME15:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR15_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME16:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR16_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME17:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR17_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME18:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR18_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME19:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR19_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME20:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR20_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME21:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR21_FASTA_FILE, gcArray);
			break;
		case CHROMOSOME22:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHR22_FASTA_FILE, gcArray);
			break;
		case CHROMOSOMEX:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHRX_FASTA_FILE, gcArray);
			break;
		case CHROMOSOMEY:
			fillChromBasedGCArrayfromFastaFile( dataFolder, Commons.GC_HG19_CHRY_FASTA_FILE, gcArray);
			break;

		}

	}

	// args[0] must have input file name with folder
	// args[1] must have GLANET installation folder with "\\" at the end. This
	// folder will be used for outputFolder and dataFolder.
	// args[2] must have Input File Format
	// args[3] must have Number of Permutations
	// args[4] must have False Discovery Rate (ex: 0.05)
	// args[5] must have Generate Random Data Mode (with GC and
	// Mapability/without GC and Mapability)
	// args[6] must have writeGeneratedRandomDataMode checkBox
	// args[7] must have
	// writePermutationBasedandParametricBasedAnnotationResultMode checkBox
	// args[8] must have writePermutationBasedAnnotationResultMode checkBox
	public static void main( String[] args) {

		String glanetFolder = args[CommandLineArguments.GlanetFolder.value()];
		String dataFolder = glanetFolder + Commons.DATA + System.getProperty( "file.separator");

		InputLine givenInputLine = new InputLine( ChromosomeName.CHROMOSOME1, 3500000, 4000000);
		ChromosomeName chromName = ChromosomeName.CHROMOSOME1;

		GCCharArray gcArray = new GCCharArray( 250000000);

		fillChromBasedGCArray( dataFolder, chromName, gcArray);

		System.out.println("Given input line's gc content: " + calculateGCofInterval( givenInputLine, gcArray));
	}

}
