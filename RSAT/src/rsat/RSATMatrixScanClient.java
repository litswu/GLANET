/**
 * @author Burcak Otlu
 * Jan 30, 2014
 * 12:05:22 PM
 * 2014
 *
 *
 *How to read RSAT result?
 *
 *example
 *
 *>altered1_snp_chr10_111787715
 *GGTAGAAAAGGTTGCGGGGGGAAGAAAAG
 *
 *Best alteredSequence1 containing snp position  found at 5. result lines	R	10	18	CCCGCAACC	3.20E-02	-1.43E-01
 *
 *
 * from sequence above sequence between 10. and 18. bases (inclusive) GGTTGCGGG, first base starts at 1. base
 * take complement CCAACGCCC
 * take reverse CCCGCAACC
 * 
 */
package rsat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import RSATWS.MatrixScanRequest;
import RSATWS.MatrixScanResponse;
import RSATWS.RSATWSPortType;
import RSATWS.RSATWebServicesLocator;
import auxiliary.FileOperations;

import common.Commons;



public class RSATMatrixScanClient {

	/**
	 * 
	 */
	public RSATMatrixScanClient() {
		// TODO Auto-generated constructor stub
	}
	
	public static String readAllfromFile(String inputFileName){
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		String strLine = null;
		String all = "";
		
		
		try {
			fileReader = new FileReader(inputFileName);
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine = bufferedReader.readLine())!=null){
				all = all + strLine +System.getProperty("line.separator");
				
			}
			
			bufferedReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return all;
		
	}
	
	
	
	
	//direction does not matter
	//start is always less than end
	public static boolean constainsSNP(int start,int end,int snpPosition){
			if (snpPosition <= end && snpPosition>=start){
				return true;
			}
			
		
		return false;
	}
	
	public static int getOneBasedPeakStart(String bestPeakResultLine){
//		peak_BCLAF1M33_GM12878_170862295_170862544_BCLAF1M33_hsa05016 	site 	matrix-scan_2014-03-03.2 	R 	108 	117 	GCCGGAAGTG 	7.7 	1.7e-06 	-13.269 	5.762 	1 	1
//		int indexofFirstTab = bestPeakResultLine.indexOf('\t');
//		
//		String peak = bestPeakResultLine.substring(0, indexofFirstTab);
//		
//		int indexofFirstUnderscore 	= peak.indexOf('_');
//		int indexofSecondUnderscore = peak.indexOf('_',indexofFirstUnderscore+1);
//		int indexofThirdUnderscore 	= peak.indexOf('_',indexofSecondUnderscore+1);
//		int indexFourthUnderscore 	= peak.indexOf('_',indexofThirdUnderscore+1);
//		
//		return Integer.parseInt(peak.substring(indexofThirdUnderscore+1, indexFourthUnderscore));
	
		//example
		//gi|224589818:170862228-170862467	site	matrix-scan-matrix_2014-04-14.5	R	37	45	ACAGAGCCG	4.7	5.6e-04	-7.490	3.253	1	1
		
		int indexofFirstColon = bestPeakResultLine.indexOf(':');
		int indexofFirstHyphen = bestPeakResultLine.indexOf('-');
					
		return Integer.parseInt(bestPeakResultLine.substring(indexofFirstColon+1, indexofFirstHyphen));

	}
	
	
	public static int getOneBasedSNPStart(String bestSNPResultLine){
//		example snp result line
//		snp_chr6_170862335_BCLAF1M33_hsa05016 	site 	matrix-scan_2014-03-03.5 	D 	15 	28 	GGCTGCGCCTGCGG 	4.8 	4.2e-06 	-12.391 	5.381 	1 	1
		
//		int indexofFirstTab = bestSNPResultLine.indexOf('\t');
//		
//		String snp = bestSNPResultLine.substring(0, indexofFirstTab);
//		
//		int indexofFirstUnderscore = snp.indexOf('_');
//		int indexofSecondUnderscore = snp.indexOf('_',indexofFirstUnderscore+1);
//		int indexofThirdUnderscore = snp.indexOf('_',indexofSecondUnderscore+1);
//		
//		return Integer.parseInt(snp.substring(indexofSecondUnderscore+1, indexofThirdUnderscore));
		
		//example snp result line
		//gi|224589818:170862322-170862350	site	matrix-scan-matrix_2014-04-11.5	D	13	21	ACGGCTGCG	3.5	3.7e-03	-5.602	2.433	2	2		
		int indexofFirstColon = bestSNPResultLine.indexOf(':');
		int indexofFirstHyphen = bestSNPResultLine.indexOf('-');
					
		return Integer.parseInt(bestSNPResultLine.substring(indexofFirstColon+1, indexofFirstHyphen)) + Commons.NUMBER_OF_BASES_BEFORE_SNP_POSITION;

		

	}
	
	public static void getPeakSequenceStartandEnd(PeakSequence peakSequence,String peakResultLine){
		
		//example
		//gi|224589818:170862228-170862467	site	matrix-scan-matrix_2014-04-14.5	R	37	45	ACAGAGCCG	4.7	5.6e-04	-7.490	3.253	1	1
		int indexofFirstTab 	= peakResultLine.indexOf('\t');
		int indexofSecondTab 	= peakResultLine.indexOf('\t',indexofFirstTab+1);
		int indexofThirdTab 	= peakResultLine.indexOf('\t',indexofSecondTab+1);
		int indexofFourthTab	= peakResultLine.indexOf('\t',indexofThirdTab+1);
		int indexofFifthTab 	= peakResultLine.indexOf('\t',indexofFourthTab+1);
		int indexofSixthTab 	= peakResultLine.indexOf('\t',indexofFifthTab+1);
		
		peakSequence.setStart(Integer.parseInt(peakResultLine.substring(indexofFourthTab+1, indexofFifthTab)));
		peakSequence.setEnd(Integer.parseInt(peakResultLine.substring(indexofFifthTab+1, indexofSixthTab)));
		
	}

	
	public static boolean peakResultLineContainsSNPPosition(String snpResultLine,String peakResultLine){
		int snpStartOneBased = 0;
		int peakStartOneBased = 0;
		int snpPositionWithRespectoPeakSequence = 0;
		
		PeakSequence peakSequence= new PeakSequence();
		
		
		snpStartOneBased = getOneBasedSNPStart(snpResultLine);
		peakStartOneBased = getOneBasedPeakStart(peakResultLine);
		
		snpPositionWithRespectoPeakSequence = snpStartOneBased - peakStartOneBased +1;
		
		getPeakSequenceStartandEnd(peakSequence,peakResultLine);
		
		return constainsSNP(peakSequence.getStart(), peakSequence.getEnd(), snpPositionWithRespectoPeakSequence);
		
	}
	
	//Among the reference result lines 
	//get the best reference line containing snp position
	public static Result getBestReferenceResultLineContainigSNPPosition(String description, String snpResult,BufferedWriter bufferedWriter,Result bestReferenceLineResult) throws IOException{
		
		String resultLine = null;
		String bestResultLine =null;
		
		int indexofSharpinSNPResult;
		int indexofNewLineinSNPResult;
		int indexofNextNewLineinSNPResult;
			
		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;
		int indexofEigthTab;
		int indexofNinethTab;
		
		char direction = ' ';
		int start = 0;
		int end = 0;
		
		double pValue = 0;
		double pValueofReferenceSequence = 0;
		double logRatio;
		
		String sequence = null;
		
		DecimalFormat df = new DecimalFormat("0.######E0");
		
		
		int countforResultLine = 0;
		
		Result result = new Result();
	
		indexofSharpinSNPResult = snpResult.indexOf('#');
		indexofNewLineinSNPResult = snpResult.indexOf('\n',indexofSharpinSNPResult+1);
		indexofNextNewLineinSNPResult = snpResult.indexOf('\n',indexofNewLineinSNPResult+1);
					
		
		do{
			
			resultLine = snpResult.substring(indexofNewLineinSNPResult+1,indexofNextNewLineinSNPResult);
			
			if(resultLine.startsWith(";")){
				//Not a valid snp result line 
				break;
			}
			
			//check whether there is no snp result or there is no snp result containing snp position
			//if there is a break countforSNPResultLine will remain zero means that there is no snp result
			//else countforSNPResultLine will be nonzero means there is at least one snp result 
			countforResultLine++;
			
			indexofFirstTab 	= resultLine.indexOf('\t');
			indexofSecondTab 	= resultLine.indexOf('\t',indexofFirstTab+1);
			indexofThirdTab 	= resultLine.indexOf('\t',indexofSecondTab+1);
			indexofFourthTab 	= resultLine.indexOf('\t',indexofThirdTab+1);
			indexofFifthTab 	= resultLine.indexOf('\t',indexofFourthTab+1);
			indexofSixthTab 	= resultLine.indexOf('\t',indexofFifthTab+1);
			indexofSeventhTab	= resultLine.indexOf('\t',indexofSixthTab+1);
			indexofEigthTab 	= resultLine.indexOf('\t',indexofSeventhTab+1);
			indexofNinethTab 	= resultLine.indexOf('\t',indexofEigthTab+1);
			
			direction = resultLine.substring(indexofThirdTab+1, indexofFourthTab).charAt(0);
			start = Integer.parseInt(resultLine.substring(indexofFourthTab+1, indexofFifthTab));
			end = Integer.parseInt(resultLine.substring(indexofFifthTab+1, indexofSixthTab));
			sequence = resultLine.substring(indexofSixthTab+1,indexofSeventhTab);
			pValue = Double.parseDouble(resultLine.substring(indexofEigthTab+1, indexofNinethTab));
			
			
			//in case of next snpResult fetch
			indexofNewLineinSNPResult = indexofNextNewLineinSNPResult;
			indexofNextNewLineinSNPResult = snpResult.indexOf('\n', indexofNewLineinSNPResult+1);
			
		} while(!constainsSNP(start,end,Commons.ONE_BASED_SNP_POSITION));

		
		if(resultLine.startsWith(";") && countforResultLine==0){
			bufferedWriter.write("There is no result line" + System.getProperty("line.separator"));	
		}else if (resultLine.startsWith(";") && countforResultLine!=0){
			bufferedWriter.write("There is NO result line containing snp position" + System.getProperty("line.separator"));
		}else {
			bestResultLine = resultLine;
		}
		
		
		//there is a result line containing snp position
		if(bestResultLine!=null){
			//This method has called for altered sequence
			//since bestReferenceLineResult is not null
			if (bestReferenceLineResult!=null && bestReferenceLineResult.getResultLine() !=null){
				
				pValueofReferenceSequence = bestReferenceLineResult.getpValue();
				logRatio = Math.log10(pValueofReferenceSequence/pValue);
				
				bufferedWriter.write(description + " found at " +  countforResultLine + ". result lines" + "\t" + direction + "\t" + start + "\t" + end + "\t" + sequence + "\t" + df.format(pValue) + "\t" + df.format(logRatio) + System.getProperty("line.separator"));
			}
			//This method has called for reference sequence
			//since bestReferenceLineResult is null
			else{
				bufferedWriter.write(description + " found at " +  countforResultLine + ". result lines" + "\t" + direction + "\t" + start + "\t" + end + "\t" + sequence + "\t" + df.format(pValue) + "\t" + ""+ System.getProperty("line.separator"));
				
			}
		}
		//there is no result line containing snp position		
		else{
			//Do nothing
			//Already covered above
		}
		
		result.setpValue(pValue);
		result.setResultLine(bestResultLine);
		
		return result;

	}
	
	
	public static void getBestPeakResultLine(String bestSNPResultLine,String peakResult, BufferedWriter bufferedWriter) throws IOException{
		
		int countforPeakResultLine = 1;
		
		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;
		int indexofEigthTab;
		int indexofNinethTab;
		
		char direction = ' ';
		int start = 0;
		int end = 0;	
		String sequence = null;
		double pValue = 0;
		
		boolean isThereAPeakResultLineContainingSNPPosition = false;
		
		DecimalFormat df = new DecimalFormat("0.######E0");
		

		int indexofSharpinPeakResult = peakResult.indexOf('#');
		int indexofNewLineinPeakResult = peakResult.indexOf('\n',indexofSharpinPeakResult+1);
		int indexofNextNewLineinPeakResult = peakResult.indexOf('\n',indexofNewLineinPeakResult+1);
		
		
		String peakResultLine = peakResult.substring(indexofNewLineinPeakResult+1,indexofNextNewLineinPeakResult);
		String  bestPeakResultLine = null;
		
		if(peakResultLine.startsWith(";")){
			bufferedWriter.write("There is no peak result line" + System.getProperty("line.separator"));	
		}else{
			//example
			//gi|224589818:170862228-170862467	site	matrix-scan-matrix_2014-04-14.5	R	37	45	ACAGAGCCG	4.7	5.6e-04	-7.490	3.253	1	1
			
			bestPeakResultLine = peakResultLine;
			
			indexofFirstTab 	= bestPeakResultLine.indexOf('\t');
			indexofSecondTab 	= bestPeakResultLine.indexOf('\t',indexofFirstTab+1);
			indexofThirdTab 	= bestPeakResultLine.indexOf('\t',indexofSecondTab+1);
			indexofFourthTab 	= bestPeakResultLine.indexOf('\t',indexofThirdTab+1);
			indexofFifthTab 	= bestPeakResultLine.indexOf('\t',indexofFourthTab+1);
			indexofSixthTab 	= bestPeakResultLine.indexOf('\t',indexofFifthTab+1);
			indexofSeventhTab	= bestPeakResultLine.indexOf('\t',indexofSixthTab+1);
			indexofEigthTab 	= bestPeakResultLine.indexOf('\t',indexofSeventhTab+1);
			indexofNinethTab 	= bestPeakResultLine.indexOf('\t',indexofEigthTab+1);
			
			direction = bestPeakResultLine.substring(indexofThirdTab+1, indexofFourthTab).charAt(0);
			start = Integer.parseInt(bestPeakResultLine.substring(indexofFourthTab+1, indexofFifthTab));
			end = Integer.parseInt(bestPeakResultLine.substring(indexofFifthTab+1, indexofSixthTab));
			sequence = bestPeakResultLine.substring(indexofSixthTab+1,indexofSeventhTab);
			pValue = Double.parseDouble(bestPeakResultLine.substring(indexofEigthTab+1, indexofNinethTab));
		
				
			bufferedWriter.write(countforPeakResultLine + ". peak result line" +  "\t" + direction + "\t" + start + "\t" + end + "\t" + sequence + "\t" + df.format(pValue) + "\t" + ""+ System.getProperty("line.separator"));
		}
		
		//if best snp result line and best peak result line are not null
		if(bestSNPResultLine!=null && bestPeakResultLine!=null){
			
			while(!(isThereAPeakResultLineContainingSNPPosition = peakResultLineContainsSNPPosition(bestSNPResultLine,bestPeakResultLine))){
				
				//in case of next peakResult fetch
				indexofNewLineinPeakResult = indexofNextNewLineinPeakResult;
				indexofNextNewLineinPeakResult = peakResult.indexOf('\n',indexofNewLineinPeakResult+1);
				countforPeakResultLine++;
				
				bestPeakResultLine = peakResult.substring(indexofNewLineinPeakResult+1,indexofNextNewLineinPeakResult);
				
				//Not a valid peak result line
				if(bestPeakResultLine.startsWith(";")){
					break;
				}
				
			}//End of while 
			
			//There is a peak result line containing snp position
			if(isThereAPeakResultLineContainingSNPPosition){
				//example
				//gi|224589818:170862228-170862467	site	matrix-scan-matrix_2014-04-14.5	D	107	115	ACGGCTGCG	3.5	3.7e-03	-5.602	2.433	9	6
				
				indexofFirstTab 	= bestPeakResultLine.indexOf('\t');
				indexofSecondTab 	= bestPeakResultLine.indexOf('\t',indexofFirstTab+1);
				indexofThirdTab 	= bestPeakResultLine.indexOf('\t',indexofSecondTab+1);
				indexofFourthTab 	= bestPeakResultLine.indexOf('\t',indexofThirdTab+1);
				indexofFifthTab 	= bestPeakResultLine.indexOf('\t',indexofFourthTab+1);
				indexofSixthTab 	= bestPeakResultLine.indexOf('\t',indexofFifthTab+1);
				indexofSeventhTab	= bestPeakResultLine.indexOf('\t',indexofSixthTab+1);
				indexofEigthTab 	= bestPeakResultLine.indexOf('\t',indexofSeventhTab+1);
				indexofNinethTab 	= bestPeakResultLine.indexOf('\t',indexofEigthTab+1);
				
				direction = bestPeakResultLine.substring(indexofThirdTab+1, indexofFourthTab).charAt(0);
				start = Integer.parseInt(bestPeakResultLine.substring(indexofFourthTab+1, indexofFifthTab));
				end = Integer.parseInt(bestPeakResultLine.substring(indexofFifthTab+1, indexofSixthTab));
				sequence = bestPeakResultLine.substring(indexofSixthTab+1,indexofSeventhTab);
				pValue = Double.parseDouble(bestPeakResultLine.substring(indexofEigthTab+1, indexofNinethTab));
			
				bufferedWriter.write("Peak result line containing snp position found at " + countforPeakResultLine + ". peak result lines" +   "\t" + direction + "\t" + start + "\t" + end + "\t" + sequence + "\t" + df.format(pValue) + "\t" + ""+ System.getProperty("line.separator"));

			}
			//There is no peak result line containing snp position
			else{
				bufferedWriter.write("There is no peak result line containing snp position" + System.getProperty("line.separator"));
				
			}
		}
	}
	
	
	
	public static void matrixScan(String enrichedTfandKeggPathwayName, String givenIntervalName, String snpName,String snpInputFile,List<String> alteredSNPInputFiles,String peakInputFile,String pfmMatricesInputFile,RSATWSPortType proxy,MatrixScanRequest matrixScanRequest,BufferedWriter bufferedWriter){
		try{
		
			
			bufferedWriter.write("**********" + enrichedTfandKeggPathwayName + "**********" + givenIntervalName +  "**********" + snpName + "**********************************" + System.getProperty("line.separator"));
			//bufferedWriter.write("This script illustrates a request to RSATMatrixScan ..." + System.getProperty("line.separator"));
			//bufferedWriter.write("pfmMatricesFile: "  + pfmMatricesInputFile +System.getProperty("line.separator"));

			
//			RSATWebServicesLocator service = new RSATWebServicesLocator();		
//			RSATWSPortType proxy = service.getRSATWSPortType();			
//			MatrixScanRequest matrixScanRequest = new MatrixScanRequest();
				
			String snpSequence = readAllfromFile(snpInputFile);
			String peakSequences = readAllfromFile(peakInputFile);
						
			String sequence_format = "fasta";
			matrixScanRequest.setSequence_format(sequence_format);
			
			String mask = "non-dna";
			//How to set this parameter?
						
			String pfmMatrices = readAllfromFile(pfmMatricesInputFile);
		
			matrixScanRequest.setMatrix(pfmMatrices);
						
			String matrixFormat = "tab";
			matrixScanRequest.setMatrix_format(matrixFormat);
			
			Integer markov     = new Integer (0);
			matrixScanRequest.setMarkov(markov);
				
			String organism = Commons.RSAT_ORGANISM_Homo_sapiens_ensembl_74_GRCh37;
			matrixScanRequest.setOrganism(organism);
			
			String background 	= Commons.RSAT_BACKGROUND_upstream_noorf;
			matrixScanRequest.setBackground(background);
			
			float pseudo_frequencies = 0.01f;
			matrixScanRequest.setBackground_pseudo(new Float(pseudo_frequencies));
			
//			String tmp_background_infile = Commons.RSAT_tmp_background_infile;
//			matrixScanRequest.setTmp_background_infile(tmp_background_infile);
		
			Integer search_strands = new Integer(2);
			matrixScanRequest.setStr(search_strands);
			
			//Although it is set to start
			//It is not set in the called matrixScan
			String origin 		= "start";
			matrixScanRequest.setOrigin(origin);
			
			String offset = "0";
			//how to set this parameter?
			
			Integer verbosity 	= new Integer (1);
			matrixScanRequest.setVerbosity(verbosity);
		
			Integer pseudo_counts 		= new Integer (1);
			matrixScanRequest.setPseudo(pseudo_counts);
						
			Integer score_decimals 	= new Integer (1);
			matrixScanRequest.setDecimals(score_decimals);
			
			String n_treatment	 = "score";
			matrixScanRequest.setN_treatment(n_treatment);
			
			//If you do not set these parameters 
			//they are set to NONE
		
			String[] uth = {"pval 0.1"};
			matrixScanRequest.setUth(uth);
			
						
			matrixScanRequest.setReturn_fields("sites,pval,rank");
			
						
			matrixScanRequest.setSequence(snpSequence);
		
			/*Call the service*/
			//bufferedWriter.write("Matrix-scan: sending request to the server for reference sequence..." + System.getProperty("line.separator"));
			//bufferedWriter.write("referenceSequenceFile: "+  snpInputFile + System.getProperty("line.separator"));
			
			MatrixScanResponse snpResponse = proxy.matrix_scan(matrixScanRequest);
				
			/* Process results*/
			//Report the remote command
	//		System.out.println("Command used on the server:"+ response.getCommand());
//			String commandUsedontheServerforSNP = snpResponse.getCommand();
				
			//Report the server file location
	//		System.out.println("Result file on the server::" + System.getProperty("line.separator")+ response.getServer());
//			String resultFileontheServerforSNP = snpResponse.getServer();
			
			//Write header to the outputFile
			bufferedWriter.write("Description" + "\t" + "Direction" + "\t" + "Start" + "\t" + "End" + 	"\t" + "Sequence" + "\t" + "pValue" + "\t" + "log(referenceSequenceResultPValue/alteredSequenceResultPValue)" + System.getProperty("line.separator"));
			
				
			//reference Results
			String referenceResult = snpResponse.getClient();
			
			/****************************************************************************/
			String description = "Best reference sequence containing snp position ";
			Result bestReferenceLineResult = null;
			
			//Get best reference result line containing snp position if it exists
			bestReferenceLineResult = getBestReferenceResultLineContainigSNPPosition(description,referenceResult,bufferedWriter,null);
			/****************************************************************************/
									
			
			//**************************************
			int alteredSequenceCount = 1;
			
			for(String alteredSNPInputFile:alteredSNPInputFiles ){
				String alteredSNPSequence = readAllfromFile(alteredSNPInputFile);
				
				//Set the altered SNP Sequence
				matrixScanRequest.setSequence(alteredSNPSequence);
				
				/*Call the service*/
				//bufferedWriter.write("Matrix-scan: sending request to the server for altered sequences..." + System.getProperty("line.separator"));
				//bufferedWriter.write("alteredSequenceFile: "+  alteredSNPInputFile + System.getProperty("line.separator"));
				
				MatrixScanResponse alteredSNPResponse = proxy.matrix_scan(matrixScanRequest);
			
				//Altered Results
				String alteredSequenceResult = alteredSNPResponse.getClient();
				
				/****************************************************************************/
				description = "Best alteredSequence"  + alteredSequenceCount + " containing snp position ";					
				Result bestAlteredLineResult = null;
				
				//Get best altered result line containing snp position if it exists
				bestAlteredLineResult =getBestReferenceResultLineContainigSNPPosition(description,alteredSequenceResult,bufferedWriter,bestReferenceLineResult);
				
				alteredSequenceCount++;
				/****************************************************************************/
								
				
			}//for each altered snp sequence file		
			//**************************************
		
			
			
			/****************************************************************************/
			matrixScanRequest.setSequence(peakSequences);
			
			/*Call the service*/
			//bufferedWriter.write("Matrix-scan: sending request to the server for extended peak sequence..." + System.getProperty("line.separator"));
			//bufferedWriter.write("extendedPeakSequenceFile: "+  peakInputFile + System.getProperty("line.separator"));
			
			MatrixScanResponse peakResponse = proxy.matrix_scan(matrixScanRequest);
				
			//Extended Peak Results
			String extendedPeakResult = peakResponse.getClient();
			
			//Get best peak result line containing snp position 
			getBestPeakResultLine(bestReferenceLineResult.getResultLine(),extendedPeakResult,bufferedWriter);
			/****************************************************************************/
				
		
			
		} catch(Exception e) {
			System.out.println(e.toString());
			
		}

	}
	
	

	public static void matrixScan(String outputFolder,String baseDirectory,BufferedWriter bufferedWriter){
		
	
			File baseFolder = new File(outputFolder+baseDirectory);
			File[] files = baseFolder.listFiles();
			
			String snpInputFile = null;
			String alteredSnpInputFile = null;
			List<String> alteredSNPInputFiles = null;
			String peakInputFile = null;
			String pfmMatricesInputFile = null;
			
			String fileName=null;
			String fileAbsolutePath = null;
			
			RSATWebServicesLocator service = new RSATWebServicesLocator();
			RSATWSPortType proxy  = null;
			
			String enrichedTfandKeggPathwayName = null;
			String givenIntervalName = null;
			String snpName = null;
			
			try {
				proxy = service.getRSATWSPortType();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MatrixScanRequest matrixScanRequest = new MatrixScanRequest();
						
			 
		    for(File enrichedTfandKeggPathways: files){
		    	
		    	//example	BCL3_hsa03050
		        if(enrichedTfandKeggPathways.isDirectory()) {
		        	
		        	enrichedTfandKeggPathwayName = enrichedTfandKeggPathways.getName();
		        	
		        	//Initialise input files
	        		pfmMatricesInputFile = null;
	        		
	        		//First get the enriched tf specific pfm matrices file
	        		//First get the pfm matrices input file	 
	        		//example pfmMatrices_BCL3.txt
		        	for (File givenInterval:enrichedTfandKeggPathways.listFiles() ){
		        		if(!givenInterval.isDirectory()){	        		
		        	 			//get the pfmMatrixFile
			        			fileName = givenInterval.getName();
		         				fileAbsolutePath = givenInterval.getAbsolutePath();
		         				
			        			if(fileName.startsWith("pfm")){
		         					pfmMatricesInputFile = fileAbsolutePath;
		         					break;
		         				}
			     		}//End of if			        		
		        	}//End of for
		        	
		        	//Now get the snp specific files
		        	for (File givenInterval:enrichedTfandKeggPathways.listFiles() ){

		        		//we found a given interval directory
		        		//example givenInterval_chr6_170862335_170862335
		        		if(givenInterval.isDirectory()){
		        			
		        			givenIntervalName = givenInterval.getName();
		        			
		        		  	for(File snps:givenInterval.listFiles()){
		        		  		
		        		  		//example snp_chr6_170862335
				         		if(snps.isDirectory()){
				         			
				         			snpName = snps.getName();
				         			
				         			//Initialise input files
				         			snpInputFile = null;
				         			alteredSnpInputFile = null;
				         			alteredSNPInputFiles = new ArrayList<String>();
				        			peakInputFile = null;
				        				         			
				         			File[] filesforSNPs = snps.listFiles();
				         			
				         			for(File snporPeakorPFMorLogo: filesforSNPs){
				         				
				         				fileName = snporPeakorPFMorLogo.getName();
				         				fileAbsolutePath = snporPeakorPFMorLogo.getAbsolutePath();
				         				
				         				
				         				if (fileName.startsWith("reference")){
				         					snpInputFile = fileAbsolutePath;
				         				}else if (fileName.startsWith("altered")){
				         					alteredSnpInputFile = fileAbsolutePath;
				         					alteredSNPInputFiles.add(alteredSnpInputFile);
				         				}else if (fileName.startsWith("extendedPeak")){
				         					peakInputFile = fileAbsolutePath;
				         				}
				         				 
				         			}//for each necessary file under snp directory
				         			
				         			//If all necessary files are not null
				         			if(snpInputFile!= null && peakInputFile!=null && pfmMatricesInputFile!=null ){
				            			//Matrix Scan Call
				         				//what is enrichedElement
				         				//what is given interval name
				         				//what is snp
					         			matrixScan(enrichedTfandKeggPathwayName, givenIntervalName, snpName,snpInputFile,alteredSNPInputFiles,peakInputFile,pfmMatricesInputFile,proxy,matrixScanRequest,bufferedWriter);
					   
				         			}
				         				
				         		}//if it is a directory
				         	}//End of each snp directory
		        			
		        		}//if givenIntervals is directory
		        				        		
		        	}//end of for each givenInterval	         	
		         	
		        }  // if it is a directory
		    }//End of for each enriched tf and kegg pathway directory
		    
			
			
	}
	
	//args[0]	--->	Input File Name with folder
	//args[1]	--->	GLANET installation folder with "\\" at the end. This folder will be used for outputFolder and dataFolder.
	//args[2]	--->	Input File Format	
	//			--->	default	Commons.INPUT_FILE_FORMAT_1_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
	//			--->			Commons.INPUT_FILE_FORMAT_0_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
	//			--->			Commons.INPUT_FILE_FORMAT_DBSNP_IDS_0_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
	//			--->			Commons.INPUT_FILE_FORMAT_BED_0_BASED_COORDINATES_START_INCLUSIVE_END_EXCLUSIVE
	//			--->			Commons.INPUT_FILE_FORMAT_GFF3_1_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE	
	//args[3]	--->	Annotation, overlap definition, number of bases, default 1
	//args[4]	--->	Enrichment parameter
	//			--->	default	Commons.DO_ENRICH
	//			--->			Commons.DO_NOT_ENRICH	
	//args[5]	--->	Generate Random Data Mode
	//			--->	default	Commons.GENERATE_RANDOM_DATA_WITH_MAPPABILITY_AND_GC_CONTENT
	//			--->			Commons.GENERATE_RANDOM_DATA_WITHOUT_MAPPABILITY_AND_GC_CONTENT	
	//args[6]	--->	multiple testing parameter, enriched elements will be decided and sorted with respest to this parameter
	//			--->	default Commons.BENJAMINI_HOCHBERG_FDR_ADJUSTED_P_VALUE
	//			--->			Commons.BONFERRONI_CORRECTED_P_VALUE
	//args[7]	--->	Bonferroni Correction Significance Level, default 0.05
	//args[8]	--->	Benjamini Hochberg FDR, default 0.05
	//args[9]	--->	Number of permutations, default 5000
	//args[10]	--->	Dnase Enrichment
	//			--->	default Commons.DO_NOT_DNASE_ENRICHMENT
	//			--->	Commons.DO_DNASE_ENRICHMENT
	//args[11]	--->	Histone Enrichment
	//			--->	default	Commons.DO_NOT_HISTONE_ENRICHMENT
	//			--->			Commons.DO_HISTONE_ENRICHMENT
	//args[12]	--->	Transcription Factor(TF) Enrichment 
	//			--->	default	Commons.DO_NOT_TF_ENRICHMENT
	//			--->			Commons.DO_TF_ENRICHMENT
	//args[13]	--->	KEGG Pathway Enrichment
	//			--->	default	Commons.DO_NOT_KEGGPATHWAY_ENRICHMENT 
	//			--->			Commons.DO_KEGGPATHWAY_ENRICHMENT
	//args[14]	--->	TF and KEGG Pathway Enrichment
	//			--->	default	Commons.DO_NOT_TF_KEGGPATHWAY_ENRICHMENT 
	//			--->			Commons.DO_TF_KEGGPATHWAY_ENRICHMENT
	//args[15]	--->	TF and CellLine and KeggPathway Enrichment
	//			--->	default	Commons.DO_NOT_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT 
	//			--->			Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT
	//args[16]	--->	RSAT parameter
	//			--->	default Commons.DO_NOT_REGULATORY_SEQUENCE_ANALYSIS_USING_RSAT
	//			--->			Commons.DO_REGULATORY_SEQUENCE_ANALYSIS_USING_RSAT
	//args[17]	--->	job name example: ocd_gwas_snps 
	//args[18]	--->	writeGeneratedRandomDataMode checkBox
	//			--->	default Commons.DO_NOT_WRITE_GENERATED_RANDOM_DATA
	//			--->			Commons.WRITE_GENERATED_RANDOM_DATA
	//args[19]	--->	writePermutationBasedandParametricBasedAnnotationResultMode checkBox
	//			--->	default Commons.DO_NOT_WRITE_PERMUTATION_BASED_AND_PARAMETRIC_BASED_ANNOTATION_RESULT
	//			--->			Commons.WRITE_PERMUTATION_BASED_AND_PARAMETRIC_BASED_ANNOTATION_RESULT
	//args[20]	--->	writePermutationBasedAnnotationResultMode checkBox
	//			---> 	default	Commons.DO_NOT_WRITE_PERMUTATION_BASED_ANNOTATION_RESULT
	//			--->			Commons.WRITE_PERMUTATION_BASED_ANNOTATION_RESULT			
	public static void main(String[] args) {
		
		String glanetFolder = args[1];
		String dataFolder 	= glanetFolder + System.getProperty("file.separator") + Commons.DATA + System.getProperty("file.separator") ;
		String outputFolder = glanetFolder + System.getProperty("file.separator") + Commons.OUTPUT + System.getProperty("file.separator") ;
		
		
		String tfExonBasedKeggPathwayBaseDirectory = Commons.TF_EXON_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;
		String tfRegulationBasedKeggPathwayBaseDirectory = Commons.TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;
		String tfAllBasedKeggPathwayBaseDirectory = Commons.TF_ALL_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;
		
		
		String tfCellLineExonBasedKeggPathwayBaseDirectory = Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;
		String tfCellLineRegulationBasedKeggPathwayBaseDirectory = Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;
		String tfCellLineAllBasedKeggPathwayBaseDirectory = Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;
		
		
		//Delete the results of the former RSAT matrix scan call
		FileOperations.deleteFile(outputFolder,Commons.RSAT_OUTPUT_FILENAME);
		
		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder +Commons.RSAT_OUTPUT_FILENAME,true);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			matrixScan(outputFolder,tfExonBasedKeggPathwayBaseDirectory,bufferedWriter);
//			matrixScan(outputFolder,tfRegulationBasedKeggPathwayBaseDirectory,bufferedWriter);
//			matrixScan(outputFolder,tfAllBasedKeggPathwayBaseDirectory,bufferedWriter);
//
//			matrixScan(outputFolder,tfCellLineExonBasedKeggPathwayBaseDirectory,bufferedWriter);
//			matrixScan(outputFolder,tfCellLineRegulationBasedKeggPathwayBaseDirectory,bufferedWriter);
//			matrixScan(outputFolder,tfCellLineAllBasedKeggPathwayBaseDirectory,bufferedWriter);
			
			//Close bufferedWriter
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}
				

}
