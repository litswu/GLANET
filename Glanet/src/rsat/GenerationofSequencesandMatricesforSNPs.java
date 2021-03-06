/**
 * @author burcakotlu
 * @date Apr 2, 2014 
 * @time 5:01:25 PM
 */
package rsat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jaxbxjctool.AugmentationofGivenIntervalwithRsIds;
import jaxbxjctool.AugmentationofGivenRsIdwithInformation;
import jaxbxjctool.NCBIEutils;
import jaxbxjctool.RsInformation;

import org.apache.log4j.Logger;

import remap.Remap;
import ui.GlanetRunner;
import auxiliary.FileOperations;

import common.Commons;

import enumtypes.AnnotationType;
import enumtypes.ChromosomeName;
import enumtypes.CommandLineArguments;

/**
 * 
 */
public class GenerationofSequencesandMatricesforSNPs {

	final static Logger logger = Logger.getLogger(GenerationofSequencesandMatricesforSNPs.class);

	
	public static String getTfNamewithoutNumber( String tfName) {

		int n = tfName.length();
		char c;
		int i;

		for( i = 0; i < n; i++){
			c = tfName.charAt( i);
			if( Character.isDigit( c)){
				break;
			}
		}

		return tfName.substring( 0, i);
	}

	public static String getTfNameWithFirstNumberWithNextCharacter( String tfName) {

		int n = tfName.length();
		char c;
		int i;

		for( i = 0; i < n; i++){
			c = tfName.charAt( i);
			if( Character.isDigit( c)){
				if( ( i + 1) < n){
					return tfName.substring( 0, i + 2);

				}else{
					return tfName.substring( 0, i + 1);

				}
			}
		}

		return tfName.substring( 0, i);
	}

	public static String removeLastCharacter( String tfName) {

		int n = tfName.length();

		if( n >= 6){
			return tfName.substring( 0, n - 1);

		}else{
			return tfName;

		}
	}

	//12 DEC 2016
	public static void writeOverlappingTFsFile( 
			String snpDirectory,
			List<String> tfNamesList){
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		String tfName = null;
		
		try {
			fileWriter = FileOperations.createFileWriter( snpDirectory + System.getProperty( "file.separator") + Commons.OVERLAPPING_TFS + ".txt");
			bufferedWriter = new BufferedWriter( fileWriter);
			
			for(Iterator<String>  itr=tfNamesList.iterator();itr.hasNext();){
				tfName = itr.next();
				bufferedWriter.write(tfName + System.getProperty("line.separator")); 
			}

			//close
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
			
	
	//12 DEC 2016
	public static void writeTFExtendedPeakSequenceFile( 
			String snpDirectory, 
			int snpOneBasedStart,
			int snpOneBasedEnd,			
			String snpChrNameWithoutPreceedingChr, 
			Map<String, String> chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap){
		
				
			writeSequenceFile(snpDirectory, 
					Commons.TF_EXTENDED_PEAK_SEQUENCE,
					Commons.TF_EXTENDED_PEAK_SEQUENCE,
					getDNASequence( 
							snpChrNameWithoutPreceedingChr,
							snpOneBasedStart-200, 
							snpOneBasedEnd+200,
							chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap));
								
	}
	
	public static void writeTFBasedTFOverlapsFileAndTFPeakSequenceFile(
			String snpDirectory,
			Map<String, TFOverlaps> tfName2TFOverlapMap, 
			String chrNameWithoutPreceedingChr,
			Map<String, String> chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap) {

		String tfName;
		TFOverlaps tfOverlap;
		TFCellLineOverlap tfCellLineOverlap;

		FileWriter TFNameBasedTFOverlapsFileWriter = null;
		BufferedWriter TFNameBasedTFOverlapsBufferedWriter = null;

		try{

			for( Map.Entry<String, TFOverlaps> tfEntry : tfName2TFOverlapMap.entrySet()){

				tfName = tfEntry.getKey();
				tfOverlap = tfEntry.getValue();

				TFNameBasedTFOverlapsFileWriter = FileOperations.createFileWriter( snpDirectory + System.getProperty( "file.separator") + Commons.TF_OVERLAPS + Commons.UNDERSCORE + tfName + ".txt");
				TFNameBasedTFOverlapsBufferedWriter = new BufferedWriter( TFNameBasedTFOverlapsFileWriter);

				Iterator<TFCellLineOverlap> iterator = tfOverlap.getTfCellLineOverlaps().iterator();

				// Write TF Based TFCellLineOverlaps into a file
				while( iterator.hasNext()){
					tfCellLineOverlap = iterator.next();

					// Write TF CellLine Based TFOverlap File
					// write snp based tf Intervals file
					TFNameBasedTFOverlapsBufferedWriter.write( ChromosomeName.convertEnumtoString( tfOverlap.getChrNameWithPreceedingChr()) + "\t" + tfCellLineOverlap.getOneBasedStart() + "\t" + tfCellLineOverlap.getOneBasedEnd() + "\t" + tfCellLineOverlap.getTfName() + "\t" + tfCellLineOverlap.getCellLineName() + "\t" + tfCellLineOverlap.getFileName() + System.getProperty( "line.separator"));

					// Set TFOverlap Minimum One Based Start
					if( tfOverlap.getMinimumOneBasedStart() > tfCellLineOverlap.getOneBasedStart()){
						tfOverlap.setMinimumOneBasedStart( tfCellLineOverlap.getOneBasedStart());
					}// End of IF

					// Set TFOverlap Maximum One Based End
					if( tfOverlap.getMaximumOneBasedEnd() < tfCellLineOverlap.getOneBasedEnd()){
						tfOverlap.setMaximumOneBasedEnd( tfCellLineOverlap.getOneBasedEnd());
					}// End of IF

				}// End of WHILE

				// Close bufferedWriter
				TFNameBasedTFOverlapsBufferedWriter.close();

				// Get TF Name Based TFOverlap Peak Sequence
				tfOverlap.setPeakSequence( getDNASequence( 
						chrNameWithoutPreceedingChr,
						tfOverlap.getMinimumOneBasedStart(), 
						tfOverlap.getMaximumOneBasedEnd(),
						chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap));

				// Write TF Name Based TFOverlap Peak Sequence
				writeSequenceFile( 
						snpDirectory, 
						Commons.TF_EXTENDED_PEAK_SEQUENCE + Commons.UNDERSCORE + tfName,
						Commons.TF_EXTENDED_PEAK_SEQUENCE + Commons.UNDERSCORE + tfName,
						tfOverlap.getPeakSequence());

			}// End of FOR TF Name Based TF CellLine Overlaps

		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeSequenceFile(
			String snpDirectory, 
			String fileName, 
			String informationToBeWrittenInTheFile, 
			String sequence) {

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		int indexofLineSeparator;
		String firstLineofFastaFile;

		try{
			fileWriter = FileOperations.createFileWriter( snpDirectory + System.getProperty( "file.separator") + fileName + ".txt");
			bufferedWriter = new BufferedWriter( fileWriter);

			indexofLineSeparator = sequence.indexOf( System.getProperty( "line.separator"));

			// fastaFile is sent
			if( indexofLineSeparator != -1){
				firstLineofFastaFile = sequence.substring( 0, indexofLineSeparator);

				bufferedWriter.write( firstLineofFastaFile + "\t" + informationToBeWrittenInTheFile + System.getProperty( "line.separator"));
				bufferedWriter.write( sequence.substring( indexofLineSeparator + 1).trim());

			}
			// only sequence is sent
			// so add '>' character to make it in fasta format
			else{
				bufferedWriter.write( ">" + informationToBeWrittenInTheFile + System.getProperty( "line.separator"));
				bufferedWriter.write( sequence);

			}

			bufferedWriter.close();

		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String takeComplementforeachAllele( String allele) {

		String complementedAllele = "";

		for( char nucleotide : allele.toCharArray()){
			switch( nucleotide){
			case 'A':
			case 'a':
				complementedAllele = complementedAllele + "T";
				break;

			case 'C':
			case 'c':
				complementedAllele = complementedAllele + "G";
				break;

			case 'G':
			case 'g':
				complementedAllele = complementedAllele + "C";
				break;

			case 'T':
			case 't':
				complementedAllele = complementedAllele + "A";
				break;

			case '-':
				complementedAllele = complementedAllele + "-";
				break;

			default:
				return null;

			}// End of switch
		}// End of for

		return complementedAllele;
	}

	public static List<String> takeComplement( List<String> observedAllelesList) {

		String complementedAllele = null;
		List<String> complementedAlleles = new ArrayList<String>();

		for( String allele : observedAllelesList){
			complementedAllele = takeComplementforeachAllele( allele);
			if( complementedAllele != null){
				complementedAlleles.add( complementedAllele);
			}

		}// End of for each observed Allele

		return complementedAlleles;

	}
	
	
	//17 DEC 2016
	public static String getAllele(String observedAllele){
		
		//Skip the plus
		//Read the digits, get the number
		//Read char as many as number indicates
		int i = 0;
//		int savedStartofFirstDigit = -1;
//		int savedEndofLastDigit = -1;
//		int savedStartOfAllele = -1;
		
		for(i=0;i<observedAllele.length();i++){
			if (Character.isDigit(observedAllele.charAt(i))){
//				savedStartofFirstDigit = i;
				break;
			}//End of IF					
		}//End of FOR
		
		for(;i<observedAllele.length();i++){
			if (Character.isLetter(observedAllele.charAt(i))){
//				savedEndofLastDigit = i-1;
//				savedStartOfAllele = i;
				break;
			}//End of IF					
		}//End of FOR
		
		return observedAllele.substring(i);
		
		//Check 
//		if (Integer.parseInt(observedAllele.substring(savedStartofFirstDigit, savedEndofLastDigit+1)).equals(allele.length())){			
//		}
		
	}

	
	//17 DEC 2016
	public static void createSNPAlteredSequencesUsingUserDefinedObservedAlleles(
			SNPInformation snpInformation,
			List<String> observedAllelesList,
			Map<String, String> chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap){
		
		String snpForwardReferenceSequence =snpInformation.getSnpReferenceSequence(); 

		String formerSNPReferenceSequence = null;
		String latterSNPReferenceSequence = null;
		String alteredSNPSequence = null;

		int lengthOfObservedAllele;
		String SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele = null;
		
		String fastaFile = null;

		Boolean insertion;
		Boolean deletion;
		
		for(String observedAllele : observedAllelesList){	
			
		
			//Initialize
			insertion = false;
			deletion = false;
			
			//Means insertion +2TG
			if (observedAllele.startsWith("+")){				
				observedAllele = getAllele(observedAllele);		
				insertion = true;
			}			
			//Means deletion -3CAC -11TCTGCTCCTGA
			else if (!observedAllele.equalsIgnoreCase("-") && observedAllele.startsWith("-")){
				observedAllele = getAllele(observedAllele);		
				deletion = true;
			}
			
			//Length of observed allele can be longer than snpForwardReferenceSequence or it can be longer than latterSNPReferenceSequence
			//In that case we need to get longer reference snp sequence using ncbi eutils
			lengthOfObservedAllele = observedAllele.length();
			
			//This can be the cases for some rsIDs with snpClass in-del or multinucleotide-polymorphism
			//Then we need to update snpReferencesequence using ncbi eutils
			//Get more reference sequence 20bpBeforeSNPStartPosition + lengthofObservedAllele + 20bpAfterSNPStartPosition
			//if(lengthOfObservedAllele>Commons.NUMBER_OF_BASES_AFTER_SNP_POSITION) {
			if(lengthOfObservedAllele>1) {
						
				fastaFile = getDNASequence(
						snpInformation.getChrNameWithoutPreceedingChr(),
						snpInformation.getOneBasedStart() - Commons.NUMBER_OF_BASES_BEFORE_SNP_POSITION,
						snpInformation.getOneBasedEnd() + Commons.NUMBER_OF_BASES_AFTER_SNP_POSITION + lengthOfObservedAllele,
						chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap);
				
				snpForwardReferenceSequence = getDNASequenceFromFastaFile(fastaFile);
				
				//Update snpInformation.getSnpReferenceSequence()
				snpInformation.setSnpReferenceSequence(snpForwardReferenceSequence);
			}
			
			try{
				
				formerSNPReferenceSequence = snpForwardReferenceSequence.substring(0,Commons.ZERO_BASED_SNP_POSITION);
				latterSNPReferenceSequence = snpForwardReferenceSequence.substring(Commons.ZERO_BASED_SNP_POSITION + lengthOfObservedAllele);
				
				SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele = snpForwardReferenceSequence.substring(Commons.ZERO_BASED_SNP_POSITION, Commons.ZERO_BASED_SNP_POSITION + lengthOfObservedAllele);

			}catch(StringIndexOutOfBoundsException e){
				if( GlanetRunner.shouldLog())logger.error( "Exception Message:" + e.getMessage());
				if( GlanetRunner.shouldLog())logger.error( "Exception toString:" + e.toString());
				if( GlanetRunner.shouldLog())logger.error( "snpForwardReferenceSequence: " + snpForwardReferenceSequence);
				if( GlanetRunner.shouldLog())logger.error( "observedAllele: " + observedAllele);
				if( GlanetRunner.shouldLog())logger.error( "lengthOfObservedAllele: " + lengthOfObservedAllele);
			}
			
			if (insertion){
				alteredSNPSequence = formerSNPReferenceSequence + observedAllele + SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele +latterSNPReferenceSequence;
				snpInformation.getAlteredSequenceName2SequenceMap().put(observedAllele + "_inserted",alteredSNPSequence);
			}else if (deletion){
				alteredSNPSequence = formerSNPReferenceSequence + latterSNPReferenceSequence;
				snpInformation.getAlteredSequenceName2SequenceMap().put(observedAllele + "_deleted",alteredSNPSequence);
			}else if (observedAllele.equalsIgnoreCase("-")){
				alteredSNPSequence = formerSNPReferenceSequence  + latterSNPReferenceSequence;
				snpInformation.getAlteredSequenceName2SequenceMap().put("Minus" + "_deleted",alteredSNPSequence);
			}else if (!SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele.equalsIgnoreCase(observedAllele)){
				alteredSNPSequence = formerSNPReferenceSequence  + observedAllele + latterSNPReferenceSequence;
				snpInformation.getAlteredSequenceName2SequenceMap().put(observedAllele + "_substituded",alteredSNPSequence);
			}
	
			
		}//End of for each observed allele
				
		
	}

	public static void createSNPAlteredSequences(
			SNPInformation snpInformation,
			int rsId, 
			String snpClass,
			List<String> observedAllelesList,
			Map<String, String> chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap) {
				
		String snpForwardReferenceSequence =snpInformation.getSnpReferenceSequence(); 

		String formerSNPReferenceSequence = null;
		String latterSNPReferenceSequence = null;
		String alteredSNPSequence = null;

		int lengthOfObservedAllele;
		String SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele = null;
		
		String fastaFile = null;

		for(String observedAllele : observedAllelesList){
			
			//Let's skip this observed allele
			//Just use it if SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele is equals to observedAllele(other than "-") at this position
			//In order to delete that observedAllele(other than "-")
			if (!observedAllele.equalsIgnoreCase("-")){
	
				//Length of observed allele can be longer than snpForwardReferenceSequence or it can be longer than latterSNPReferenceSequence
				//In that case we need to get longer reference snp sequence using ncbi eutils
				lengthOfObservedAllele = observedAllele.length();
				
				//This can be the cases for some rsIDs with snpClass in-del or multinucleotide-polymorphism
				//Then we need to update snpReferencesequence using ncbi eutils
				//Get more reference sequence 20bpBeforeSNPStartPosition + lengthofObservedAllele + 20bpAfterSNPStartPosition
				//if(lengthOfObservedAllele>Commons.NUMBER_OF_BASES_AFTER_SNP_POSITION) {
				if(lengthOfObservedAllele>1) {
							
					fastaFile = getDNASequence(
							snpInformation.getChrNameWithoutPreceedingChr(),
							snpInformation.getOneBasedStart() - Commons.NUMBER_OF_BASES_BEFORE_SNP_POSITION,
							snpInformation.getOneBasedEnd() + Commons.NUMBER_OF_BASES_AFTER_SNP_POSITION + lengthOfObservedAllele,
							chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap);
					
					snpForwardReferenceSequence = getDNASequenceFromFastaFile(fastaFile);
					
					//Update snpInformation.getSnpReferenceSequence()
					snpInformation.setSnpReferenceSequence(snpForwardReferenceSequence);
				}
				
				try{
					
					formerSNPReferenceSequence = snpForwardReferenceSequence.substring(0,Commons.ZERO_BASED_SNP_POSITION);
					latterSNPReferenceSequence = snpForwardReferenceSequence.substring(Commons.ZERO_BASED_SNP_POSITION + lengthOfObservedAllele);
					
					SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele = snpForwardReferenceSequence.substring(Commons.ZERO_BASED_SNP_POSITION, Commons.ZERO_BASED_SNP_POSITION + lengthOfObservedAllele);
	
				}catch(StringIndexOutOfBoundsException e){
					if( GlanetRunner.shouldLog())logger.error( "Exception Message:" + e.getMessage());
					if( GlanetRunner.shouldLog())logger.error( "Exception toString:" + e.toString());
					if( GlanetRunner.shouldLog())logger.error( "snpForwardReferenceSequence: " + snpForwardReferenceSequence);
					if( GlanetRunner.shouldLog())logger.error( "observedAllele: " + observedAllele);
					if( GlanetRunner.shouldLog())logger.error( "lengthOfObservedAllele: " + lengthOfObservedAllele);
				}


				
				//snpClass snp case starts
				if (snpClass.equalsIgnoreCase("snp")){
					
					if (SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele.equalsIgnoreCase(observedAllele) && observedAllelesList.contains("-") ){
						alteredSNPSequence = formerSNPReferenceSequence + latterSNPReferenceSequence;
						snpInformation.getAlteredSequenceName2SequenceMap().put(Commons.RS + rsId + Commons.UNDERSCORE + observedAllele + "_deleted", alteredSNPSequence);
					}
					else if(!SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele.equalsIgnoreCase(observedAllele)){
						alteredSNPSequence = formerSNPReferenceSequence + observedAllele + latterSNPReferenceSequence;
						snpInformation.getAlteredSequenceName2SequenceMap().put(Commons.RS + rsId + Commons.UNDERSCORE + observedAllele + "_copied",alteredSNPSequence);
					}					
				}//End of IF snpClass case ends
				
				//snpClass multinucleotide-polymorphism case starts
				else if (snpClass.equalsIgnoreCase("multinucleotide-polymorphism")){
					//This means delete
					if(SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele.equalsIgnoreCase(observedAllele) && observedAllelesList.contains("-")){
						alteredSNPSequence = formerSNPReferenceSequence + latterSNPReferenceSequence;	
						snpInformation.getAlteredSequenceName2SequenceMap().put(Commons.RS + rsId + Commons.UNDERSCORE + observedAllele +  "_deleted",alteredSNPSequence);
					}else if(!SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele.equalsIgnoreCase(observedAllele)){				
						//This means copy paste
						alteredSNPSequence = formerSNPReferenceSequence + observedAllele + latterSNPReferenceSequence;	
						snpInformation.getAlteredSequenceName2SequenceMap().put(Commons.RS + rsId + Commons.UNDERSCORE + observedAllele + "_copied",alteredSNPSequence);						
					}
					
				}
				//End of IF snpClass multinucleotide-polymorphism case ends
				
				//snpClass in-del case starts
				else if(snpClass.equalsIgnoreCase("in-del")){				
					
					if(SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele.equalsIgnoreCase(observedAllele)){
						//This means that this is deletion
						alteredSNPSequence = formerSNPReferenceSequence + latterSNPReferenceSequence;
						snpInformation.getAlteredSequenceName2SequenceMap().put(Commons.RS + rsId + Commons.UNDERSCORE + observedAllele + "_deleted",alteredSNPSequence);
					}else{ 
						//This means that this is insertion Question how will be the order? Will observedAllele become before or after?
						//Decision observedAllele will be inserted before
						alteredSNPSequence = formerSNPReferenceSequence + observedAllele + SNPReferenceSequenceStartingAtSNPPositionOfLengthObservedAllele +latterSNPReferenceSequence;
						snpInformation.getAlteredSequenceName2SequenceMap().put(Commons.RS + rsId + Commons.UNDERSCORE + observedAllele + "_inserted",alteredSNPSequence);
					}
					
				}//End of IF snpClass in-del case ends
				
				else{
					//check whether there is any case we are not handling?
					//debug delete later
					System.out.println("rsID: " + rsId);
					System.out.println("snpClass: " +  snpClass);
					System.out.println("observedAllele: " +observedAllele);
					//debug delete later
				}
				
				

			}//End of IF observedAllele is not "-"

		}// End of for each observed allele

	}



	//This also handles if there is only one observed allele such as  +1ACC or -3TCT
	public static List<String> convertSlashSeparatedObservedAllelesIntoAStringList( String slashSeparatedObservedAlleles) {

		List<String> observedAllelesList = new ArrayList<String>();

		int indexofFormerSlash;
		int indexofLatterSlash;
		String allele;

		indexofFormerSlash = slashSeparatedObservedAlleles.indexOf( Commons.SLASH);

		/*****************************************************************/
		/************* For the first allele starts ***********************/
		/*****************************************************************/
		if (indexofFormerSlash>-1){
			allele = slashSeparatedObservedAlleles.substring( 0, indexofFormerSlash);
			observedAllelesList.add( allele);
		}
		/*****************************************************************/
		/************* For the first allele ends *************************/
		/*****************************************************************/

		indexofLatterSlash = slashSeparatedObservedAlleles.indexOf( Commons.SLASH, indexofFormerSlash + 1);

		/*****************************************************************/
		/************* For the middle allele starts **********************/
		/*****************************************************************/
		while( indexofFormerSlash != -1 && indexofLatterSlash != -1){
			allele = slashSeparatedObservedAlleles.substring( indexofFormerSlash + 1, indexofLatterSlash);
			observedAllelesList.add( allele);

			indexofFormerSlash = indexofLatterSlash;
			indexofLatterSlash = slashSeparatedObservedAlleles.indexOf( Commons.SLASH, indexofFormerSlash + 1);
		}
		/*****************************************************************/
		/************* For the middle allele ends ************************/
		/*****************************************************************/

		/*****************************************************************/
		/************* For the last allele starts ************************/
		/*****************************************************************/
		allele = slashSeparatedObservedAlleles.substring( indexofFormerSlash + 1);
		observedAllelesList.add( allele);
		/*****************************************************************/
		/************* For the last allele ends **************************/
		/*****************************************************************/

		return observedAllelesList;
	}
	
	//17 DEC 2016
	public static void createSNPAlteredSequencesUsingUserDefinedObservedAlleles(
			SNPInformation snpInformation,
			String slashSeparatedUserDefinedObservedAlleles,
			Map<String, String> chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap){
		
		List<String> observedAllelesList = convertSlashSeparatedObservedAllelesIntoAStringList(slashSeparatedUserDefinedObservedAlleles);

		 createSNPAlteredSequencesUsingUserDefinedObservedAlleles(
				 snpInformation,
				 observedAllelesList,
				 chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap);
	}


	public static void createSNPAlteredSequences(
			SNPInformation snpInformation, 
			RsInformation rsInformation,
			Map<String, String> chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap) {

		List<String> observedAllelesList = convertSlashSeparatedObservedAllelesIntoAStringList( rsInformation.getSlashSeparatedObservedAlleles());

		List<String> complementedObservedAllelesList = null;

		// rsID Orient is Forward
		if( rsInformation.getOrient().isForward()){
			createSNPAlteredSequences(snpInformation,rsInformation.getRsId(),rsInformation.getSnpClass(),observedAllelesList,chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap);
		}
		// rsID Orient is Reverse
		else{
			// Take Complement of slashSeparatedObservedAlleles
			complementedObservedAllelesList = takeComplement( observedAllelesList);
			createSNPAlteredSequences(snpInformation, rsInformation.getRsId(),rsInformation.getSnpClass(),complementedObservedAllelesList,chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap);
		}

	}

	public static void writeObservedAllelesFile( String snpDirectory, String fileName, String observedAlleles) {

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try{
			fileWriter = FileOperations.createFileWriter( snpDirectory + System.getProperty( "file.separator") + fileName + ".txt");
			bufferedWriter = new BufferedWriter( fileWriter);

			bufferedWriter.write( observedAlleles + System.getProperty( "line.separator"));

			bufferedWriter.close();

		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createPeakSequencesFile( String outputFolder, String directoryBase,
			String sequenceFileDirectory, String fileName, String peakName, String peakSequence) {

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		int indexofFirstLineSeparator;
		String firstLineofFastaFile;

		try{
			fileWriter = FileOperations.createFileWriter(
					outputFolder + directoryBase + sequenceFileDirectory + System.getProperty( "file.separator") + fileName + ".txt",
					true);
			bufferedWriter = new BufferedWriter( fileWriter);

			indexofFirstLineSeparator = peakSequence.indexOf( System.getProperty( "line.separator"));
			firstLineofFastaFile = peakSequence.substring( 0, indexofFirstLineSeparator);

			bufferedWriter.write( firstLineofFastaFile + "\t" + peakName + System.getProperty( "line.separator"));
			bufferedWriter.write( peakSequence.substring( indexofFirstLineSeparator + 1).trim());

			bufferedWriter.close();

		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	// Requires chrName without preceeding "chr" string
	// Requires oneBased coordinates
	public static String getDNASequence( 
			String chrNamewithoutPreceedingChr, 
			int oneBasedStart, 
			int oneBasedEnd,
			Map<String, String> chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap) {

		String sourceHTML = null;
		String refSeqId;

		refSeqId = chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap.get( chrNamewithoutPreceedingChr);

		// GlanetRunner.appendLog("EFETCH RESULT:");
		// Read from the URL
		try{
			String eFetchString = "https://www.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=nucleotide&id=" + refSeqId + "&strand=1" + "&seq_start=" + oneBasedStart + "&seq_stop=" + oneBasedEnd + "&rettype=fasta&retmode=text";
			URL url = new URL( eFetchString);

			BufferedReader in = new BufferedReader( new InputStreamReader( url.openStream()));
			String inputLine; // one line of the result, as it is read line by
								// line
			sourceHTML = ""; // will eventually contain the whole result
			// Continue to read lines while there are still some left to read

			// Pay attention
			// Each line including last line has new line character at the end.
			while( ( inputLine = in.readLine()) != null) // read one line of the
															// input stream
			{
				sourceHTML += inputLine + System.getProperty( "line.separator"); // add
																					// this
																					// line
																					// to
																					// end
																					// of
																					// the
																					// whole
																					// shebang
				// ++lineCount; // count the number of lines read
			}

			// Close the connection
			in.close();
		}catch( Exception e){
			if( GlanetRunner.shouldLog())logger.error( "Error reading from the URL:");
			if( GlanetRunner.shouldLog())logger.error( e);
		}

		return sourceHTML;
	}

	public static String getDNASequenceFromFastaFile(String fastaFile) {

		String referenceSequence;
		int indexofFirstLineSeparator;
		int indexofLineSeparator;

		indexofFirstLineSeparator = fastaFile.indexOf(System.getProperty("line.separator"));
		referenceSequence = fastaFile.substring(indexofFirstLineSeparator + 1).trim();
		
		indexofLineSeparator = referenceSequence.indexOf(System.getProperty("line.separator"));
		
		//Get rid of line separators within referenceSequence
		while(indexofLineSeparator>=0){
			referenceSequence = referenceSequence.substring(0,indexofLineSeparator) +  referenceSequence.substring(indexofLineSeparator+1);
			indexofLineSeparator = referenceSequence.indexOf(System.getProperty("line.separator"));			
		}		

		return referenceSequence;

	}

	// TF starts
	public static void readAllTFAnnotationsWriteSequencesandMatrices(
			AugmentationofGivenIntervalwithRsIds augmentationOfAGivenIntervalWithRsIDs,
			AugmentationofGivenRsIdwithInformation augmentationOfAGivenRsIdWithInformation,
			Map<String, String> chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap, 
			String forRSAFolder,
			String all_TF_Annotations_File_1Based_Start_End_LatestAssemblyReturnedFromNCBIEutils, 
			Map<String, String> tfName2PfmMatrices,
			Map<String, String> tfName2LogoMatrices, 
			String enrichmentType) {

		FileReader allTFAnnotationsFileReader;
		BufferedReader allTFAnnotationsBufferedReader;

		String strLine;

		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;		
		int indexofEigthTab;
		int indexofNinethTab;
		
		String chrNameWithPreceedingChr = null;
		String chrNameWithoutPreceedingChr = null;

		int snpOneBasedStart;
		int snpOneBasedEnd;

		String tfName;
		String userDefinedObservedAlleles = null;

		String tfNameRemovedLastCharacter;
		String previousTfNameRemovedLastCharacter;

		boolean thereExistsPFMMatrix = false;
		boolean thereExistsLOGOMatrix = false;

		String directoryBase = Commons.TF_PFM_AND_LOGO_Matrices + System.getProperty( "file.separator");

		Boolean isThereAnExactTfNamePfmMatrix = false;

		/*******************************************************************************/
		/********************* TF 2 PFMLogoMatricesExists MAP starts *******************/
		/*******************************************************************************/
		// This map is used whether this pfm matrix file is already created and
		// written for a certain TF.
		// Key is TF Name
		// If once pfm and logo matrices are found and written to text files
		// then there is no need to search and write pfm matrix files again
		Map<String, Boolean> tf2PFMLogoMatriceAlreadyExistsMap = new HashMap<String, Boolean>();
		/*******************************************************************************/
		/********************* TF 2 PFMLogoMatricesExists MAP ends *********************/
		/*******************************************************************************/

		/*******************************************************************************/
		/************** givenSNP 2 SNPInformation Map starts ***************************/
		/*******************************************************************************/
		// Key is chrNameWithPreceedingChr + "_" + snpOneBasedStart
		String givenSNPKey;
		String snpDirectory;
		List<Integer> rsIdList;
		List<Integer> validRsIdList;
		RsInformation rsInformation;
		SNPInformation snpInformation;
		String fastaFile;
		String snpReferenceSequence;
		int alteredSequenceCount;
		Map<String, SNPInformation> givenSNP2SNPInformationMap = new HashMap<String, SNPInformation>();
		/*******************************************************************************/
		/************** givenSNP 2 SNPInformation Map ends *****************************/
		/*******************************************************************************/
		
		//12 DEC 2016 starts
		/*******************************************************************************/
		/************** givenSNP 2 TFNames Map starts **********************************/
		/*******************************************************************************/
		Map<String, List<String>> givenSNP2TFNamesMap = new HashMap<String, List<String>>();	
		List<String> tfNamesList = null;
		/*******************************************************************************/
		/************** givenSNP 2 TFNames Map ends ************************************/
		/*******************************************************************************/
		//12 DEC 2016 ends

		/*******************************************************************************/
		/********************* rsID 2 rsInformation MAP starts *************************/
		/*******************************************************************************/
		Map<Integer, RsInformation> rsID2RsIDInformationMap = new HashMap<Integer, RsInformation>();
		/*******************************************************************************/
		/********************* rsID 2 rsInformation MAP ends ***************************/
		/*******************************************************************************/

		// 10 March 2014
		// Pay attention, there can be more than two observed alleles such as
		// A\tG\tT\t-\tACG
		// Pay attention, for the same chrName and ChrPosition there can be more than one rsIDs
		// Therefore each rsInformation can have observedAlleles String. It is rare but it is possible.

		try{
			
			allTFAnnotationsFileReader = new FileReader(forRSAFolder + all_TF_Annotations_File_1Based_Start_End_LatestAssemblyReturnedFromNCBIEutils);
			allTFAnnotationsBufferedReader = new BufferedReader(allTFAnnotationsFileReader);

			/****************************************************************************************/
			/********************* Reading All TF Annotations File Starts ***************************/
			/****************************************************************************************/
			while((strLine = allTFAnnotationsBufferedReader.readLine()) != null){

				// skip strLine starts with '#' comment character
				if( strLine.charAt( 0) != Commons.GLANET_COMMENT_CHARACTER){

					indexofFirstTab = strLine.indexOf( '\t');
					indexofSecondTab = ( indexofFirstTab > 0)?strLine.indexOf( '\t', indexofFirstTab + 1):-1;
					indexofThirdTab = ( indexofSecondTab > 0)?strLine.indexOf( '\t', indexofSecondTab + 1):-1;
					indexofFourthTab = ( indexofThirdTab > 0)?strLine.indexOf( '\t', indexofThirdTab + 1):-1;
					indexofFifthTab = ( indexofFourthTab > 0)?strLine.indexOf( '\t', indexofFourthTab + 1):-1;
					indexofSixthTab = ( indexofFifthTab > 0)?strLine.indexOf( '\t', indexofFifthTab + 1):-1;
					indexofSeventhTab = ( indexofSixthTab > 0)?strLine.indexOf( '\t', indexofSixthTab + 1):-1;
					indexofEigthTab = ( indexofSeventhTab > 0)?strLine.indexOf( '\t', indexofSeventhTab + 1):-1;
					indexofNinethTab = ( indexofEigthTab > 0)?strLine.indexOf( '\t', indexofEigthTab + 1):-1;
					
					//new example line
					//chr14	55411899	55411899	chr14	55411775	55411904	ATF3	GM12878	spp.optimal.wgEncodeHaibTfbsGm12878Atf3Pcr1xAlnRep0_VS_wgEncodeHaibTfbsGm12878ControlPcr1xAlnRep0.narrowPeak	G/A

					chrNameWithPreceedingChr = strLine.substring( 0, indexofFirstTab);
					chrNameWithoutPreceedingChr = chrNameWithPreceedingChr.substring( 3);

					// Used in finding list of rsIds in this given latest assembly coordinate
					snpOneBasedStart = Integer.parseInt( strLine.substring( indexofFirstTab + 1, indexofSecondTab));
					snpOneBasedEnd = Integer.parseInt( strLine.substring( indexofSecondTab + 1, indexofThirdTab));

					tfName = strLine.substring(indexofSixthTab+1,indexofSeventhTab);
					
					//Initialize
					userDefinedObservedAlleles = null;
					//Means that user has provided user defined observed alleles
					//No need to look for rsIDs using ncbi eutils
					if (indexofNinethTab>-1){
						userDefinedObservedAlleles = strLine.substring(indexofNinethTab + 1);
					}
					
					//Initialize tfNameRemovedLastCharacter to tfName
					tfNameRemovedLastCharacter = tfName;

					/*************************************************************************/
					/**********Create Files for pfm Matrices and logo Matrices starts*********/
					/*************************************************************************/
					if( tf2PFMLogoMatriceAlreadyExistsMap.get(tfName) == null){

						isThereAnExactTfNamePfmMatrix = false;

						// Find PFM entry
						for( Map.Entry<String, String> pfmEntry : tfName2PfmMatrices.entrySet()){
							if( pfmEntry.getKey().contains( tfName)){
								isThereAnExactTfNamePfmMatrix = true;
								PositionFrequencyAndLogoMatrices.writeMatrixFile( forRSAFolder, directoryBase, tfName,
										Commons.PFM_MATRICES + Commons.UNDERSCORE + tfName, pfmEntry.getValue());

							}
						}// End of for

						// Find LOGO entry
						for( Map.Entry<String, String> logoEntry : tfName2LogoMatrices.entrySet()){
							if( logoEntry.getKey().contains( tfName)){
								PositionFrequencyAndLogoMatrices.writeMatrixFile( forRSAFolder, directoryBase, tfName,
										Commons.LOGO_MATRICES + Commons.UNDERSCORE + tfName, logoEntry.getValue());

							}
						}

						if(!isThereAnExactTfNamePfmMatrix){

							thereExistsPFMMatrix = false;
							thereExistsLOGOMatrix = false;

							while( !thereExistsPFMMatrix && !thereExistsLOGOMatrix){
								previousTfNameRemovedLastCharacter = tfNameRemovedLastCharacter;
								// @todo removeLastCharacter may need further check
								tfNameRemovedLastCharacter = removeLastCharacter( tfNameRemovedLastCharacter);

								// If no change
								if( previousTfNameRemovedLastCharacter.equals( tfNameRemovedLastCharacter)){
									break;
								}

								// find pfm entry
								for( Map.Entry<String, String> pfmEntry : tfName2PfmMatrices.entrySet()){
									if( pfmEntry.getKey().contains( tfNameRemovedLastCharacter)){
										thereExistsPFMMatrix = true;
										PositionFrequencyAndLogoMatrices.writeMatrixFile( forRSAFolder, directoryBase, tfName,
												Commons.PFM_MATRICES + Commons.UNDERSCORE + tfName, pfmEntry.getValue());

									}
								}// End of for PFM

								// find logo entry
								for( Map.Entry<String, String> logoEntry : tfName2LogoMatrices.entrySet()){
									if( logoEntry.getKey().contains( tfNameRemovedLastCharacter)){
										thereExistsLOGOMatrix = true;
										PositionFrequencyAndLogoMatrices.writeMatrixFile( forRSAFolder, directoryBase, tfName,
												Commons.LOGO_MATRICES + Commons.UNDERSCORE + tfName,
												logoEntry.getValue());

									}
								}// End of for LOGO

							}// End of while

						}// End of IF there is no exact TF NAME PFM Matrix Match

						tf2PFMLogoMatriceAlreadyExistsMap.put(tfName, true);
					} // End of if
					/*************************************************************************/
					/********** Create Files for pfm Matrices and logo Matrices ends *********/
					/*************************************************************************/

					/*******************************************************************************************************************************/
					/************************* SET KEYS starts *************************************************************************************/
					/*******************************************************************************************************************************/
					// Set Given ChrName OneBasedStart
					givenSNPKey = chrNameWithPreceedingChr + "_" + snpOneBasedStart;
					/*******************************************************************************************************************************/
					/************************* SET KEYS ends ***************************************************************************************/
					/*******************************************************************************************************************************/

					/*******************************************************************************************************************************/
					/********************** Filling Maps starts ************************************************************************************/
					/*******************************************************************************************************************************/

					/*************************************************************************/
					/*****************Fill givenSNP2SNPInformationMap starts *****************/
					/*************************************************************************/
					snpInformation = givenSNP2SNPInformationMap.get(givenSNPKey);

					// This SNP is looked for for the first time
					if( snpInformation == null){

						snpInformation = new SNPInformation();											

						snpInformation.setChrNameWithoutPreceedingChr(chrNameWithoutPreceedingChr);
						snpInformation.setOneBasedStart(snpOneBasedStart);
						snpInformation.setOneBasedEnd(snpOneBasedEnd);
						
						//17 DEC 2016
						if (userDefinedObservedAlleles!=null){
							
							rsIdList = null;
							validRsIdList = null;
							snpInformation.setValidRsIDList(validRsIdList);		
							snpInformation.setUserDefinedObservedAlleles(userDefinedObservedAlleles);
							
						}else{
							
							/*************************************************************************/
							/*************** Fill rsID2RsIDInformationMap starts *********************/
							/*************************************************************************/
							// Get all the rsIDs in this given interval
							// We have to provide 1-based coordinates as arguments
							// Caution: This rsIdList may contain merged rsIds
							// rsIdList is a list of integers
							// rsId is an integer without --rs-- prefix
							rsIdList = augmentationOfAGivenIntervalWithRsIDs.getRsIdsInAGivenInterval(chrNameWithoutPreceedingChr, snpOneBasedStart, snpOneBasedEnd);
							validRsIdList = new ArrayList<Integer>();

							for(Integer rsId : rsIdList){
								
								rsInformation = rsID2RsIDInformationMap.get(rsId);

								// For this rsID, we are getting rsInformation for the first time
								if( rsInformation == null){

									// For each rsId get rsInformation
									rsInformation = augmentationOfAGivenRsIdWithInformation.getInformationforGivenRsId(String.valueOf(rsId));

									// Option 1---Here we can either return a not
									// null rsInformation with a different rsId
									// And check whether given rsID and returned
									// rsID matches
									// If they do not match we can ignore this
									// rsInformation
									// Option 2---Or we can simply return a null
									// rsInformation in case of merge sitution
									// I have chosen ---Option 2--- since I exit the
									// loop and return null, do not continue unused
									// assignments
									if( rsInformation != null){

										// @todo Here we can check whether this rsId
										// is in the given input rsID list if the
										// given input type is dbSNP IDs
										// Decision: I decided --not to do-- such a
										// check since searched rsID and returned
										// rsID might be different because of merge
										// situation

										// rsId and and rsInformation.getRsId()
										// might be different because of merge
										// situation
										if(!rsID2RsIDInformationMap.containsKey(rsInformation.getRsId())){
											rsID2RsIDInformationMap.put(rsInformation.getRsId(), rsInformation);
										}

										if(!validRsIdList.contains( rsInformation.getRsId())){
											validRsIdList.add( rsInformation.getRsId());
										}
									}// End of IF rsInformation is not NULL

								}// End of if rsInformation is null
								else{

									if( GlanetRunner.shouldLog())logger.error( "I guess this else part is unnecessary!");

									// Means that rsInformation is already put
									// so this rsId is not a merged rsId
									if( !validRsIdList.contains( rsInformation.getRsId())){
										validRsIdList.add( rsInformation.getRsId());
									}

								}// End of ELSE: this chrName_OneBasedCoordinate is
									// looked at for the first time but this rsID is
									// found before, can it be?

							}// End of for each rsId
							
							snpInformation.setValidRsIDList(validRsIdList);
							snpInformation.setUserDefinedObservedAlleles(null);
							/*************************************************************************/
							/*************** Fill rsID2RsIDInformationMap ends ***********************/
							/*************************************************************************/

						}//End of Else: userDefinedObservedAlleles is null

						givenSNP2SNPInformationMap.put(givenSNPKey, snpInformation);

					}// End of IF snpInformation is null
					/*************************************************************************/
					/***************** Fill givenSNP2SNPInformationMap ends ******************/
					/*************************************************************************/
					
					
					//Simplify
					//12 DEC 2016 starts
					/*************************************************************************/
					/*********** Fill givenSNP2TFNamesMap starts *****************************/
					/*************************************************************************/
					tfNamesList = givenSNP2TFNamesMap.get(givenSNPKey);
					
					// This SNP is looked for for the first time
					if (tfNamesList == null){
						
						tfNamesList = new ArrayList<String>();
						tfNamesList.add(tfName);
						
						givenSNP2TFNamesMap.put(givenSNPKey, tfNamesList);
					}//End of IF 
					else if (!tfNamesList.contains(tfName)){
						tfNamesList.add(tfName);
					}
					/*************************************************************************/
					/*********** Fill givenSNP2TFNamesMap ends *******************************/
					/*************************************************************************/					
					//12 DEC 2016 ends
					
					/*******************************************************************************************************************************/
					/********************** Filling Maps ends **************************************************************************************/
					/*******************************************************************************************************************************/

				}// End of IF strLine is not comment character

			}// End of While loop reading: allTFAnnotationsBufferedReader
			/****************************************************************************************/
			/********************* Reading All TF Annotations File Ends *****************************/
			/****************************************************************************************/

			/****************************************************************************************/
			/****************** Close All TF Annotations Buffered Writer ****************************/
			/****************************************************************************************/
			allTFAnnotationsBufferedReader.close();
			/****************************************************************************************/
			/****************** Close All TF Annotations Buffered Writer ****************************/
			/****************************************************************************************/

			/*********************************************************************************************************************************/
			/**************** Get DNA sequences starts ***************************************************************************************/
			/**************** SNP Reference Sequence *****************************************************************************************/
			/**************** SNP Alternate Sequences ****************************************************************************************/
			/**************** TF OVERLAP Peak Sequence ***************************************************************************************/
			for( Map.Entry<String, SNPInformation> entry : givenSNP2SNPInformationMap.entrySet()){
				givenSNPKey = entry.getKey();
				snpInformation = entry.getValue();

				// Get Fasta File for each SNP
				// Get SNP Reference DNA Sequence from fasta file for each SNP
				fastaFile = getDNASequence(
						snpInformation.getChrNameWithoutPreceedingChr(),
						snpInformation.getOneBasedStart() - Commons.NUMBER_OF_BASES_BEFORE_SNP_POSITION,
						snpInformation.getOneBasedEnd() + Commons.NUMBER_OF_BASES_AFTER_SNP_POSITION,
						chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap);

				snpInformation.setFastaFile( fastaFile);
				snpReferenceSequence = getDNASequenceFromFastaFile( fastaFile);
				snpInformation.setSnpReferenceSequence( snpReferenceSequence);

				/*****************************************************************/
				/***************** Set SNP directory starts **********************/
				/*****************************************************************/
				snpDirectory = forRSAFolder + Commons.SNPs + System.getProperty( "file.separator") + entry.getKey();

				if(snpInformation.getValidRsIDList()!=null){
					
					// Add valid rsIDs to the snpDirectory
					for(Integer validRsId : snpInformation.getValidRsIDList()){
						snpDirectory = snpDirectory + Commons.UNDERSCORE + Commons.RS + validRsId;
					}// End of for each valid rsID in this SNP

				}//End of IF 

				
				snpDirectory = snpDirectory + System.getProperty( "file.separator");
				/*****************************************************************/
				/***************** Set SNP directory ends ************************/
				/*****************************************************************/

				/*****************************************************************/
				/******** Write SNP Reference DNA Sequence starts ****************/
				/*****************************************************************/
				writeSequenceFile( 
						snpDirectory, 
						Commons.SNP_REFERENCE_SEQUENCE + "_" + entry.getKey(),
						Commons.SNP_REFERENCE_SEQUENCE + "_" + entry.getKey(),
						entry.getValue().getFastaFile());
				/*****************************************************************/
				/******** Write SNP Reference DNA Sequence ends ******************/
				/*****************************************************************/
				
				//17 DEC 2016 
				//One way: Altered sequences can be generated from user defined observed alleles 
				//Second way:  Altered sequences can be generated from valid rs ids returned from ncbi eutils
				
				if (snpInformation.getUserDefinedObservedAlleles()!=null){
					
					//Write Observed Alleles
					writeObservedAllelesFile(
							snpDirectory,
							Commons.OBSERVED_ALLELES,
							snpInformation.getUserDefinedObservedAlleles());
					
					//Create SNP Altered Sequences
					createSNPAlteredSequencesUsingUserDefinedObservedAlleles(
							snpInformation,
							snpInformation.getUserDefinedObservedAlleles(),
							chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap);
					//Write SNP Altered Sequences starts
										
					
				}else{
					
					/**********************************************************************************/
					/*********** Write valid rsID Based SNP Observed Alleles Files starts *************/
					/**********************************************************************************/
					for( Integer validRsId : snpInformation.getValidRsIDList()){

						rsInformation = rsID2RsIDInformationMap.get(validRsId);
						writeObservedAllelesFile(
								snpDirectory,
								Commons.OBSERVED_ALLELES + Commons.UNDERSCORE + Commons.RS + validRsId + Commons.UNDERSCORE + rsInformation.getOrient().convertEnumtoString(),
								rsInformation.getSlashSeparatedObservedAlleles());
						

						/*******************************************************************/
						/************* Create SNP Altered Sequences starts *****************/
						/*******************************************************************/
						createSNPAlteredSequences(snpInformation,
								rsInformation,
								chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap);
						/*******************************************************************/
						/************* Create SNP Altered Sequences ends *******************/
						/*******************************************************************/

	
					}// End of for each valid rsID in this SNP
					/**********************************************************************************/
					/*********** Write valid rsID Based SNP Observed Alleles Files ends ***************/
					/**********************************************************************************/

				}//End of Else user defined observed alleles is null
			

				/*******************************************************************/
				/************* Write SNP Altered Sequences starts ******************/
				/*******************************************************************/					
				alteredSequenceCount = 1;
				
				for(Entry<String, String> name2Sequence: snpInformation.getAlteredSequenceName2SequenceMap().entrySet()){
					
					String alteredSequenceName = name2Sequence.getKey();
					String alteredSequence = name2Sequence.getValue();
					
					writeSequenceFile(
							snpDirectory,
							Commons.SNP_ALTERED_SEQUENCE + alteredSequenceCount,
							Commons.SNP_ALTERED_SEQUENCE + Commons.UNDERSCORE + alteredSequenceName + Commons.UNDERSCORE + entry.getKey(),
							alteredSequence);
					
					alteredSequenceCount++;
					
					alteredSequenceName = null;
					alteredSequence = null;
					
				}//End of for each alteredSequence entry
				/*******************************************************************/
				/************* Write SNP Altered Sequences ends ********************/
				/*******************************************************************/
												
				/*******************************************************************/
				/************* Write TF Extended Sequence starts *******************/
				/*******************************************************************/					
				//Write only one TF extended sequence file +/- 200 bp around SNP position
				//12 DEC 2016 starts
				writeTFExtendedPeakSequenceFile( 
						snpDirectory, 
						snpInformation.getOneBasedStart(),
						snpInformation.getOneBasedEnd(),
						snpInformation.getChrNameWithoutPreceedingChr(), 
						chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap);
				
				//Write Overlapping TFs with this snp
				tfNamesList = givenSNP2TFNamesMap.get(givenSNPKey);
				writeOverlappingTFsFile(snpDirectory,tfNamesList);
				//12 DEC 2016 ends
				/*******************************************************************/
				/************* Write TF Extended Sequence ends *********************/
				/*******************************************************************/					
									
			}// End of for each SNP
			/*******************************************************************************************************************************/
			/**************** SNP Reference Sequence ***************************************************************************************/
			/**************** SNP Alternate Sequences **************************************************************************************/
			/**************** TF OVERLAP Peak Sequence *************************************************************************************/
			/**************** Get DNA sequences ends ***************************************************************************************/
			/*******************************************************************************************************************************/

		}catch( FileNotFoundException e1){
			if( GlanetRunner.shouldLog()){
				logger.info("ALL TF annotations in latest assembly file can not be found.");
				logger.info("Since there might be no TF annotations in GRCh37.p13.");
			}
			e1.printStackTrace();
		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch( Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// end ends

	// Pay Attention
	// Contains X for chrX
	// Contains 1 for chr1

	

	// Pay Attention
	// Contains X for chrX
	// Contains 1 for chr1
	// # Sequence-Name Sequence-Role Assigned-Molecule
	// Assigned-Molecule-Location/Type GenBank-Accn Relationship RefSeq-Accn
	// Assembly-Unit
	// 1 assembled-molecule 1 Chromosome CM000663.1 = NC_000001.10 Primary
	// Assembly
	// X assembled-molecule X Chromosome CM000685.1 = NC_000023.10 Primary
	// Assembly
	public Map<String, String> fillMap( String refSeqIdsforGRCh37InputFile) {

		Map<String, String> chrName2RefSeqIdforGrch37Map = new HashMap<String, String>();

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		String strLine = null;
		int numberofChromosomesinHomoSapiens = 24;
		int count = 0;

		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;

		String chrName;
		String refSeqId;

		try{
			fileReader = new FileReader( refSeqIdsforGRCh37InputFile);
			bufferedReader = new BufferedReader( fileReader);

			while( ( strLine = bufferedReader.readLine()) != null){
				if( strLine.startsWith( "#")){
					continue;
				}else{
					if( count < numberofChromosomesinHomoSapiens){
						count++;

						indexofFirstTab = strLine.indexOf( '\t');
						indexofSecondTab = strLine.indexOf( '\t', indexofFirstTab + 1);
						indexofThirdTab = strLine.indexOf( '\t', indexofSecondTab + 1);
						indexofFourthTab = strLine.indexOf( '\t', indexofThirdTab + 1);
						indexofFifthTab = strLine.indexOf( '\t', indexofFourthTab + 1);
						indexofSixthTab = strLine.indexOf( '\t', indexofFifthTab + 1);
						indexofSeventhTab = strLine.indexOf( '\t', indexofSixthTab + 1);

						chrName = strLine.substring( 0, indexofFirstTab);
						refSeqId = strLine.substring( indexofSixthTab + 1, indexofSeventhTab);

						chrName2RefSeqIdforGrch37Map.put( chrName, refSeqId);
						continue;

					}
				}

				break;

			}

			bufferedReader.close();

		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return chrName2RefSeqIdforGrch37Map;
	}

	// args[0] ---> Input File Name with folder
	// args[1] ---> GLANET installation folder with "\\" at the end. This folder
	// will be used for outputFolder and dataFolder.
	// args[2] ---> Input File Format
	// ---> default
	// Commons.INPUT_FILE_FORMAT_1_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
	// --->
	// Commons.INPUT_FILE_FORMAT_0_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
	// --->
	// Commons.INPUT_FILE_FORMAT_DBSNP_IDS_0_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
	// --->
	// Commons.INPUT_FILE_FORMAT_BED_0_BASED_COORDINATES_START_INCLUSIVE_END_EXCLUSIVE
	// --->
	// Commons.INPUT_FILE_FORMAT_GFF3_1_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
	// args[3] ---> Annotation, overlap definition, number of bases,
	// default 1
	// args[4] ---> Perform Enrichment parameter
	// ---> default Commons.DO_ENRICH
	// ---> Commons.DO_NOT_ENRICH
	// args[5] ---> Generate Random Data Mode
	// ---> default Commons.GENERATE_RANDOM_DATA_WITH_MAPPABILITY_AND_GC_CONTENT
	// ---> Commons.GENERATE_RANDOM_DATA_WITHOUT_MAPPABILITY_AND_GC_CONTENT
	// args[6] ---> multiple testing parameter, enriched elements will be
	// decided and sorted with respect to this parameter
	// ---> default Commons.BENJAMINI_HOCHBERG_FDR
	// ---> Commons.BONFERRONI_CORRECTION
	// args[7] ---> Bonferroni Correction Significance Level, default 0.05
	// args[8] ---> Bonferroni Correction Significance Criteria, default 0.05
	// args[9] ---> Number of permutations, default 5000
	// args[10] ---> Dnase Enrichment
	// ---> default Commons.DO_NOT_DNASE_ENRICHMENT
	// ---> Commons.DO_DNASE_ENRICHMENT
	// args[11] ---> Histone Enrichment
	// ---> default Commons.DO_NOT_HISTONE_ENRICHMENT
	// ---> Commons.DO_HISTONE_ENRICHMENT
	// args[12] ---> Transcription Factor(TF) Enrichment
	// ---> default Commons.DO_NOT_TF_ENRICHMENT
	// ---> Commons.DO_TF_ENRICHMENT
	// args[13] ---> KEGG Pathway Enrichment
	// ---> default Commons.DO_NOT_KEGGPATHWAY_ENRICHMENT
	// ---> Commons.DO_KEGGPATHWAY_ENRICHMENT
	// args[14] ---> TF and KEGG Pathway Enrichment
	// ---> default Commons.DO_NOT_TF_KEGGPATHWAY_ENRICHMENT
	// ---> Commons.DO_TF_KEGGPATHWAY_ENRICHMENT
	// args[15] ---> TF and CellLine and KeggPathway Enrichment
	// ---> default Commons.DO_NOT_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT
	// ---> Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT
	// args[16] ---> RSAT parameter
	// ---> default Commons.DO_NOT_REGULATORY_SEQUENCE_ANALYSIS_USING_RSAT
	// ---> Commons.DO_REGULATORY_SEQUENCE_ANALYSIS_USING_RSAT
	// args[17] ---> job name example: ocd_gwas_snps
	// args[18] ---> writeGeneratedRandomDataMode checkBox
	// ---> default Commons.DO_NOT_WRITE_GENERATED_RANDOM_DATA
	// ---> Commons.WRITE_GENERATED_RANDOM_DATA
	// args[19] ---> writePermutationBasedandParametricBasedAnnotationResultMode
	// checkBox
	// ---> default
	// Commons.DO_NOT_WRITE_PERMUTATION_BASED_AND_PARAMETRIC_BASED_ANNOTATION_RESULT
	// --->
	// Commons.WRITE_PERMUTATION_BASED_AND_PARAMETRIC_BASED_ANNOTATION_RESULT
	// args[20] ---> writePermutationBasedAnnotationResultMode checkBox
	// ---> default Commons.DO_NOT_WRITE_PERMUTATION_BASED_ANNOTATION_RESULT
	// ---> Commons.WRITE_PERMUTATION_BASED_ANNOTATION_RESULT
	// args[21] ---> number of permutations in each run. Default is 2000
	// args[22] ---> UserDefinedGeneSet Enrichment
	// default Commons.DO_NOT_USER_DEFINED_GENESET_ENRICHMENT
	// Commons.DO_USER_DEFINED_GENESET_ENRICHMENT
	// args[23] ---> UserDefinedGeneSet InputFile
	// args[24] ---> UserDefinedGeneSet GeneInformationType
	// default Commons.GENE_ID
	// Commons.GENE_SYMBOL
	// Commons.RNA_NUCLEOTIDE_ACCESSION
	// args[25] ---> UserDefinedGeneSet Name
	// args[26] ---> UserDefinedGeneSet Optional GeneSet Description InputFile
	// args[27] ---> UserDefinedLibrary Enrichment
	// default Commons.DO_NOT_USER_DEFINED_LIBRARY_ENRICHMENT
	// Commons.DO_USER_DEFINED_LIBRARY_ENRICHMENT
	// args[28] ---> UserDefinedLibrary InputFile
	// args[29] - args[args.length-1] ---> Note that the selected cell lines are
	// always inserted at the end of the args array because it's size
	// is not fixed. So for not (until the next change on args array) the
	// selected cell
	// lines can be reached starting from 22th index up until (args.length-1)th
	// index.
	// If no cell line selected so the args.length-1 will be 22-1 = 21. So it
	// will never
	// give an out of boundry exception in a for loop with this approach.
	public static void main(String[] args) {

		String glanetFolder = args[CommandLineArguments.GlanetFolder.value()];

		// jobName starts
		String jobName = args[CommandLineArguments.JobName.value()].trim();
		if( jobName.isEmpty()){
			jobName = Commons.NO_NAME;
		}
		// jobName ends

		String dataFolder = glanetFolder + Commons.DATA + System.getProperty( "file.separator");
		String outputFolder = args[CommandLineArguments.OutputFolder.value()];

		String forRSAFolder = outputFolder + Commons.FOR_RSA + System.getProperty( "file.separator");

		// TfAnnotation, DO or DO_NOT
		AnnotationType tfAnnotationType = AnnotationType.convertStringtoEnum( args[CommandLineArguments.TfAnnotation.value()]);
		AnnotationType tfKEGGAnnotationType = AnnotationType.convertStringtoEnum( args[CommandLineArguments.TfAndKeggPathwayAnnotation.value()]);
		AnnotationType tfCellLineKEGGAnnotationType = AnnotationType.convertStringtoEnum( args[CommandLineArguments.CellLineBasedTfAndKeggPathwayAnnotation.value()]);


		// pfm matrices
		String encodeMotifsInputFileName = Commons.ENCODE_MOTIFS;
		String jasparCoreInputFileName = Commons.JASPAR_CORE;

		// TF
		String all_TF_Annotations_File_1Based_Start_End_LatestAssemblyReturnedByNCBIEutils = Commons.ALL_TF_ANNOTATIONS_FILE_1BASED_START_END_LATEST_ASSEMBLY_RETURNED_BY_NCBI_EUTILS;

		// Example Data
		// 7 NC_000007.13 GRCh37
		// Chromosome 7 CM000669.2 = NC_000007.14 0 GRCh37
		Map<String, String> chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap = new HashMap<String, String>();			
		
		/***************************************************************************************/
		/***********************************Part1 starts****************************************/
		/***************************************************************************************/
		String latestAssemblyNameReturnedByNCBIEutils = null;
		latestAssemblyNameReturnedByNCBIEutils = NCBIEutils.getLatestAssemblyNameReturnedByNCBIEutils();
		/***************************************************************************************/
		/***********************************Part1 ends******************************************/
		/***************************************************************************************/
		
		
		/***************************************************************************************/
		/***********************************Part2 starts****************************************/
		/***************************************************************************************/
		Map<String, String> assemblyName2RefSeqAssemblyIDMap = new HashMap<String, String>();
		
		//No need to call this again and again.
		//Since it is already called in GenerationofAllTFAnnotationsFileInGRCh37p13AndInLatestAssembly class
		//Remap.remap_show_batches(dataFolder, Commons.NCBI_REMAP_API_SUPPORTED_ASSEMBLIES_FILE);
		
		Remap.fillAssemblyName2RefSeqAssemblyIDMap(
				dataFolder, 
				Commons.NCBI_REMAP_API_SUPPORTED_ASSEMBLIES_FILE,
				assemblyName2RefSeqAssemblyIDMap);
		/***************************************************************************************/
		/***********************************Part2 ends******************************************/
		/***************************************************************************************/
	
		/***************************************************************************************/
		/***********************************Part3 starts****************************************/
		/***************************************************************************************/
		String refSeqAssemblyID = NCBIEutils.getRefSeqAssemblyID(latestAssemblyNameReturnedByNCBIEutils, assemblyName2RefSeqAssemblyIDMap);
		/***************************************************************************************/
		/***********************************Part3 ends******************************************/
		/***************************************************************************************/
						
		/***************************************************************************************/
		/***********************************Part4 starts****************************************/
		/***************************************************************************************/
		// Download from  ftp://ftp.ncbi.nlm.nih.gov/genomes/ASSEMBLY_REPORTS/All/RefSeqAssemblyID.assembly.txt
		String assemblyReportFileName = Commons.ASSEMBLY_REPORTS +  refSeqAssemblyID + Commons.ASSEMBLY_REPORTS_FILE_EXTENSION ;
		NCBIEutils.getAssemblyReport(latestAssemblyNameReturnedByNCBIEutils,refSeqAssemblyID, dataFolder, assemblyReportFileName);
		/***************************************************************************************/
		/***********************************Part4 ends******************************************/
		/***************************************************************************************/
						
		/***************************************************************************************/
		/***********************************Part5 starts****************************************/
		/***************************************************************************************/
		NCBIEutils.fillChrName2RefSeqIDMap(dataFolder, assemblyReportFileName, chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap);
		/***************************************************************************************/
		/***********************************Part5 ends******************************************/
		/***************************************************************************************/

		// Construct pfm matrices from encode-motif.txt file
		// A tf can have more than one pfm matrices
		// Take the transpose of given matrices in encode-motif.txt
		// Write the matrices in tab format for RSAT tool
		Map<String, String> tfName2PfmMatrices = new HashMap<String, String>();

		Map<String, String> tfName2LogoMatrices = new HashMap<String, String>();

		// Construct position frequency matrices from Encode Motifs
		PositionFrequencyAndLogoMatrices.constructPfmMatricesfromEncodeMotifs( dataFolder, encodeMotifsInputFileName, tfName2PfmMatrices);

		// Construct logo matrices from Encode Motifs
		PositionFrequencyAndLogoMatrices.constructLogoMatricesfromEncodeMotifs( dataFolder, encodeMotifsInputFileName, tfName2LogoMatrices);

		
		// Construct position frequency matrices from Jaspar Core
		// Construct logo matrices from Jaspar Core
		PositionFrequencyAndLogoMatrices.constructPfmMatricesandLogoMatricesfromJasparCore(
				dataFolder, 
				jasparCoreInputFileName, 
				tfName2PfmMatrices,
				tfName2LogoMatrices);
		
		AugmentationofGivenIntervalwithRsIds augmentationOfAGivenIntervalWithRsIDs;
		AugmentationofGivenRsIdwithInformation augmentationOfAGivenRsIdWithInformation;

		try{
			augmentationOfAGivenIntervalWithRsIDs = new AugmentationofGivenIntervalwithRsIds();
			augmentationOfAGivenRsIdWithInformation = new AugmentationofGivenRsIdwithInformation();

			// TF Annotations are used
			if( tfAnnotationType.doTFAnnotation() || 
				tfKEGGAnnotationType.doTFKEGGPathwayAnnotation() || 
				tfCellLineKEGGAnnotationType.doTFCellLineKEGGPathwayAnnotation()){

				// Generate DNA Sequences and TF Matrices for Annotated TF Elements
				readAllTFAnnotationsWriteSequencesandMatrices(
						augmentationOfAGivenIntervalWithRsIDs,
						augmentationOfAGivenRsIdWithInformation, 
						chrName2RefSeqIdforLatestAssemblyReturnedByNCBIEutilsMap, 
						forRSAFolder,
						all_TF_Annotations_File_1Based_Start_End_LatestAssemblyReturnedByNCBIEutils, 
						tfName2PfmMatrices, 
						tfName2LogoMatrices,
						Commons.TF);

			}

		}catch( Exception e){
			e.printStackTrace();
		}

	}

}
