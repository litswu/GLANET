/**
 * @author burcakotlu
 * @date Aug 30, 2014 
 * @time 4:10:57 PM
 * 
 * AnnotationBinaryMatrixForOnePhenotype filled with 1/0s
 * Row: givenInterval
 * Column: elementName
 * 
 * 
 */
package collaboration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import auxiliary.FileOperations;
import common.Commons;
import enumtypes.AnnotationType;
import enumtypes.CommandLineArguments;
import enumtypes.WriteAnnotationBinaryMatrixMode;
import enumtypes.AnnotationFoundOverlapsOutputMode;

/**
 * 
 */
public class GivenIntervalVersusElementAnnotationBinaryMatrixForOnePhenotype {

	public static void readGivenIntervals( 
			Map<String, Integer> givenIntervalName2ArrayXIndexMap,
			String[] givenIntervalNames, 
			String givenInputDataFolder) {

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String strLine;

		int indexOfFirstTab;
		int indexOfSecondTab;

		String chrNumber;
		int start_0BasedInclusive;
		int end_0BasedInclusive;

		String givenIntervalKey = null;
		int givenIntervalIndex = 0;

		try{
			fileReader = FileOperations.createFileReader( givenInputDataFolder + Commons.REMOVED_OVERLAPS_INPUT_FILE_0BASED_START_END_GRCh37_p13);
			bufferedReader = new BufferedReader( fileReader);

			while( ( strLine = bufferedReader.readLine()) != null){
				// chr1 11862777 11862777
				indexOfFirstTab = strLine.indexOf( '\t');
				indexOfSecondTab = strLine.indexOf( '\t', indexOfFirstTab + 1);

				chrNumber = strLine.substring( 0, indexOfFirstTab);
				start_0BasedInclusive = Integer.parseInt( strLine.substring( indexOfFirstTab + 1, indexOfSecondTab));
				end_0BasedInclusive = Integer.parseInt( strLine.substring( indexOfSecondTab + 1));

				givenIntervalKey = chrNumber + "_" + start_0BasedInclusive + "_" + end_0BasedInclusive;
				givenIntervalName2ArrayXIndexMap.put( givenIntervalKey, givenIntervalIndex);
				givenIntervalNames[givenIntervalIndex] = givenIntervalKey;
				givenIntervalIndex++;
			}// end of while

			bufferedReader.close();

		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void readAnnotations( Map<String, Integer> givenIntervalName2ArrayXIndexMap,
			List<String> elementNameList, String[] elementNames, short[][] annotationBinaryMatrix, String outputFolder,
			String elementType) {

		String folderName = null;
		File folder;
		String fileName;
		String fileAbsolutePath;

		int indexofDot;
		String elementName;
		int elementIndex = 0;

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String strLine;

		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;

		String givenIntervalKey = null;

		String givenIntervalChrNumber;
		int givenIntervalStart;
		int givenIntervalEnd;

		int givenIntervalIndex;

		if( elementType.equals( Commons.DNASE)){
			folderName = outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_DNASE;
		}else if( elementType.equals( Commons.HISTONE)){
			folderName = outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_HISTONE;
		}else if( elementType.equals( Commons.TF)){
			folderName = outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TFBS;
		}

		else if( elementType.equals( Commons.EXON_BASED_KEGG_PATHWAY)){
			folderName = outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_EXON_BASED_KEGG_PATHWAY_ANALYSIS;
		}else if( elementType.equals( Commons.REGULATION_BASED_KEGG_PATHWAY)){
			folderName = outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS;
		}else if( elementType.equals( Commons.ALL_BASED_KEGG_PATHWAY)){
			folderName = outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_ALL_BASED_KEGG_PATHWAY_ANALYSIS;
		}

		else if( elementType.equals( Commons.TF_EXON_BASED_KEGG_PATHWAY)){
			folderName = outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_EXON_BASED_KEGG_PATHWAY;
		}else if( elementType.equals( Commons.TF_REGULATION_BASED_KEGG_PATHWAY)){
			folderName = outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_REGULATION_BASED_KEGG_PATHWAY;
		}else if( elementType.equals( Commons.TF_ALL_BASED_KEGG_PATHWAY)){
			folderName = outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_ALL_BASED_KEGG_PATHWAY;
		}

		else if( elementType.equals( Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY)){
			folderName = outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY;
		}else if( elementType.equals( Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY)){
			folderName = outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY;
		}else if( elementType.equals( Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY)){
			folderName = outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY;
		}

		folder = new File( folderName);

		if( folder.exists() && folder.isDirectory()){
			File[] files = folder.listFiles();

			for( File file : files){
				if( file.isFile()){
					fileName = file.getName();
					indexofDot = fileName.indexOf( '.');
					elementName = fileName.substring( 0, indexofDot);

					elementNameList.add( elementName);

					elementNames[elementIndex] = elementName;

					fileAbsolutePath = file.getAbsolutePath();

					try{
						fileReader = FileOperations.createFileReader( fileAbsolutePath);
						bufferedReader = new BufferedReader( fileReader);

						// read annotations
						while( ( strLine = bufferedReader.readLine()) != null){

							// Skip comment lines
							if( strLine.charAt( 0) != Commons.GLANET_COMMENT_CHARACTER){
								// Searched for chr given interval low given
								// interval high dnase overlap chrom name node
								// low node high node CellLineName node FileName
								// chr1 109817589 109817589 chr1 109817060
								// 109817913 MCF7 MCF7DukeDNaseSeq.pk
								indexofFirstTab = strLine.indexOf( '\t');
								indexofSecondTab = strLine.indexOf( '\t', indexofFirstTab + 1);
								indexofThirdTab = strLine.indexOf( '\t', indexofSecondTab + 1);

								givenIntervalChrNumber = strLine.substring( 0, indexofFirstTab);
								givenIntervalStart = Integer.parseInt( strLine.substring( indexofFirstTab + 1,
										indexofSecondTab));
								givenIntervalEnd = Integer.parseInt( strLine.substring( indexofSecondTab + 1,
										indexofThirdTab));

								givenIntervalKey = givenIntervalChrNumber + "_" + givenIntervalStart + "_" + givenIntervalEnd;

								givenIntervalIndex = givenIntervalName2ArrayXIndexMap.get( givenIntervalKey);

								annotationBinaryMatrix[givenIntervalIndex][elementIndex] = 1;
							}// End of IF
						}// End of WHILE

						bufferedReader.close();

					}catch( IOException e){
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					elementIndex++;
				}

			}

		}

	}

	public static void writeAnnotationBinaryMatrix( short[][] annotationBinaryMatrix, String[] givenIntervalNames,
			int numberofGivenIntervals, String[] elementNames, int numberofElements, String outputFolder,
			String elementType, Map<String, String> overlap2RSIDMap) {

		BufferedWriter bufferedWriter = null;

		String outputFileName = null;

		String rsId = null;

		if( elementType.equals( Commons.DNASE)){
			outputFileName = outputFolder + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ANNOTATIONBINARYMATRIX_DNASE;
		}else if( elementType.equals( Commons.HISTONE)){
			outputFileName = outputFolder + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ANNOTATIONBINARYMATRIX_HISTONE;
		}else if( elementType.equals( Commons.TF)){
			outputFileName = outputFolder + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ANNOTATIONBINARYMATRIX_TF;
		}

		else if( elementType.equals( Commons.EXON_BASED_KEGG_PATHWAY)){
			outputFileName = outputFolder + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ANNOTATIONBINARYMATRIX_EXONBASEDKEGG;
		}else if( elementType.equals( Commons.REGULATION_BASED_KEGG_PATHWAY)){
			outputFileName = outputFolder + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ANNOTATIONBINARYMATRIX_REGULATIONBASEDKEGG;
		}else if( elementType.equals( Commons.ALL_BASED_KEGG_PATHWAY)){
			outputFileName = outputFolder + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ANNOTATIONBINARYMATRIX_ALLBASEDKEGG;
		}

		else if( elementType.equals( Commons.TF_EXON_BASED_KEGG_PATHWAY)){
			outputFileName = outputFolder + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ANNOTATIONBINARYMATRIX_TFEXONBASEDKEGG;
		}else if( elementType.equals( Commons.TF_REGULATION_BASED_KEGG_PATHWAY)){
			outputFileName = outputFolder + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ANNOTATIONBINARYMATRIX_TFREGULATIONBASEDKEGG;
		}else if( elementType.equals( Commons.TF_ALL_BASED_KEGG_PATHWAY)){
			outputFileName = outputFolder + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ANNOTATIONBINARYMATRIX_TFALLBASEDKEGG;
		}

		else if( elementType.equals( Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY)){
			outputFileName = outputFolder + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ANNOTATIONBINARYMATRIX_TFCELLLINEEXONBASEDKEGG;
		}else if( elementType.equals( Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY)){
			outputFileName = outputFolder + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ANNOTATIONBINARYMATRIX_TFCELLLINEREGULATIONBASEDKEGG;
		}else if( elementType.equals( Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY)){
			outputFileName = outputFolder + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ANNOTATIONBINARYMATRIX_TFCELLLINEALLBASEDKEGG;
		}

		try{
			bufferedWriter = new BufferedWriter( FileOperations.createFileWriter( outputFileName));

			// Write header file starts
			if( overlap2RSIDMap != null){
				bufferedWriter.write( "rsId" + "\t" + "givenInterval_chrName_start0Basedhg19_end0Basedhg19" + "\t");
				for( int i = 0; i < numberofElements; i++){
					bufferedWriter.write( elementNames[i] + "\t");
				}
				bufferedWriter.write( System.getProperty( "line.separator"));
			}else{
				bufferedWriter.write( "givenInterval_chrName_start0Basedhg19_end0Basedhg19" + "\t");
				for( int i = 0; i < numberofElements; i++){
					bufferedWriter.write( elementNames[i] + "\t");
				}
				bufferedWriter.write( System.getProperty( "line.separator"));
			}

			// Write header file ends

			// Write givenIntervalName and 1s and 0s starts
			for( int i = 0; i < numberofGivenIntervals; i++){

				if( overlap2RSIDMap != null){
					// get rsID
					rsId = overlap2RSIDMap.get( givenIntervalNames[i]);

					if( rsId != null){
						bufferedWriter.write( rsId + "\t");

					}
				}// End of IF overlap2RSIDMap is not null

				bufferedWriter.write( givenIntervalNames[i] + "\t");

				for( int j = 0; j < numberofElements; j++){
					bufferedWriter.write( annotationBinaryMatrix[i][j] + "\t");
				}

				bufferedWriter.write( System.getProperty( "line.separator"));

			}
			// Write givenIntervalName and 1s and 0s ends

			bufferedWriter.close();
		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main( String[] args) {

		//String glanetFolder = args[CommandLineArguments.GlanetFolder.value()];

		// jobName starts
		String jobName = args[CommandLineArguments.JobName.value()].trim();
		if( jobName.isEmpty()){
			jobName = Commons.NO_NAME;
		}
		// jobName ends

		String outputFolder = args[CommandLineArguments.OutputFolder.value()];
		String givenInputDataFolder = outputFolder + Commons.GIVENINPUTDATA + System.getProperty( "file.separator");
		/****************************************************************************/
		/*********** delete old files starts ****************************************/
		String encodeCollaborationOutputBaseDirectoryName = outputFolder + Commons.ENCODE_COLLABORATION;

		FileOperations.deleteOldFiles( encodeCollaborationOutputBaseDirectoryName);
		/*********** delete old files ends ******************************************/
		/****************************************************************************/

		// /************************************************************************************/
		// /********************************FILL givenInterval2rsID starts**********************/
		// /************************************************************************************/
		// //File provided by Chen Yao
		// String inputFileName = "C:"+ System.getProperty("file.separator")
		// +"Users" + System.getProperty("file.separator") + "burcakotlu" +
		// System.getProperty("file.separator") + "Desktop" +
		// System.getProperty("file.separator") + "ENCODE Collaboration" +
		// System.getProperty("file.separator") +"eqtl-gene-anno-all.txt";
		//
		Map<String, String> overlap2RSIDMap = null;
		// Map<String,String> overlap2RSIDMap = new HashMap<String,String>();
		//
		// ElementVersusNumberofOver"lapsWithRSIDsAndEnrichmentForOnePhenotype.readRSIDMap(inputFileName,
		// overlap2RSIDMap);
		// /************************************************************************************/
		// /********************************FILL givenInterval2rsID
		// ends************************/
		// /************************************************************************************/

		/************************************************************************************/
		/******************************** HASH MAPS starts ************************************/
		/************************************************************************************/
		// Given Intervals
		Map<String, Integer> givenIntervalName2ArrayXIndexMap = new HashMap<String, Integer>();

		/************************************************************************************/
		/******************************** HASH MAPS ends **************************************/
		/************************************************************************************/

		/************************************************************************************/
		/******************************* My assumptions starts ********************************/
		/************************************************************************************/
		// number of given intervals at most 10000
		// number of elements at most 10000
		final Integer MAXIMUM_NUMBER_OF_GIVEN_INTERVALS = new Integer( 100000);
		final Integer MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND = new Integer( 10000);
		final Integer MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND = new Integer( 100000);

		/************************************************************************************/
		/******************************** My assumptions ends *********************************/
		/************************************************************************************/

		String[] givenIntervalNames = new String[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS];

		/***********************************************************************************************/
		/*************************** READ GIVEN INPUT starts *********************************************/
		/***********************************************************************************************/
		readGivenIntervals( givenIntervalName2ArrayXIndexMap, givenIntervalNames, givenInputDataFolder);
		/***********************************************************************************************/
		/*************************** READ GIVEN INPUT ends ***********************************************/
		/***********************************************************************************************/

		AnnotationFoundOverlapsOutputMode writeElementBasedAnnotationFoundOverlapsMode = AnnotationFoundOverlapsOutputMode.convertStringtoEnum( args[CommandLineArguments.AnnotationFoundOverlapsOutputMode.value()]);
		WriteAnnotationBinaryMatrixMode writeAnnotationBinaryMatrixMode = WriteAnnotationBinaryMatrixMode.convertStringtoEnum( args[CommandLineArguments.WriteAnnotationBinaryMatrixMode.value()]);

		if( writeElementBasedAnnotationFoundOverlapsMode.isWriteFoundOverlapsElementBased() && writeAnnotationBinaryMatrixMode.doWriteAnnotationBinaryMatrixMode()){

			/****************************************************************/
			/********** DNASE starts*****************************************/
			/****************************************************************/
			AnnotationType dnaseAnnotationType = AnnotationType.convertStringtoEnum( args[CommandLineArguments.DnaseAnnotation.value()]);

			if( dnaseAnnotationType.doDnaseAnnotation()){

				List<String> dnaseCellLineNameList = new ArrayList<String>();

				// Index to Name Array
				String[] dnaseCelllineNames = new String[MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND];

				// ANNOTATION BINARY MATRICE
				short[][] annotationBinaryMatrixforDnase = new short[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS][MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND];

				// READ ANNOTATIONs FILL BINARY MATRICES starts
				readAnnotations( givenIntervalName2ArrayXIndexMap, dnaseCellLineNameList, dnaseCelllineNames,
						annotationBinaryMatrixforDnase, outputFolder, Commons.DNASE);
				// READ ANNOTATIONs FILL BINARY MATRICES ends

				// WRITE ANNOTATION BINARY MATRICES starts
				writeAnnotationBinaryMatrix( annotationBinaryMatrixforDnase, givenIntervalNames,
						givenIntervalName2ArrayXIndexMap.size(), dnaseCelllineNames, dnaseCellLineNameList.size(),
						outputFolder, Commons.DNASE, overlap2RSIDMap);
				// WRITE ANNOTATION BINARY MATRICES ends

				dnaseCellLineNameList = null;
				dnaseCelllineNames = null;
				annotationBinaryMatrixforDnase = null;
			}
			/****************************************************************/
			/********** DNASE ends*******************************************/
			/****************************************************************/

			/****************************************************************/
			/********** TF starts********************************************/
			/****************************************************************/
			AnnotationType tfAnnotationType = AnnotationType.convertStringtoEnum( args[CommandLineArguments.TfAnnotation.value()]);

			if( tfAnnotationType.doTFAnnotation()){

				List<String> tfNameCellLineNameList = new ArrayList<String>();
				String[] tfNameCellLineNames = new String[MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND];
				short[][] annotationBinaryMatrixforTf = new short[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS][MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND];

				readAnnotations( givenIntervalName2ArrayXIndexMap, tfNameCellLineNameList, tfNameCellLineNames,
						annotationBinaryMatrixforTf, outputFolder, Commons.TF);
				writeAnnotationBinaryMatrix( annotationBinaryMatrixforTf, givenIntervalNames,
						givenIntervalName2ArrayXIndexMap.size(), tfNameCellLineNames, tfNameCellLineNameList.size(),
						outputFolder, Commons.TF, overlap2RSIDMap);

				tfNameCellLineNameList = null;
				tfNameCellLineNames = null;
				annotationBinaryMatrixforTf = null;

			}
			/****************************************************************/
			/********** TF ends**********************************************/
			/****************************************************************/

			/****************************************************************/
			/********** Histone starts***************************************/
			/****************************************************************/
			AnnotationType histoneAnnotationType = AnnotationType.convertStringtoEnum( args[CommandLineArguments.HistoneAnnotation.value()]);

			if( histoneAnnotationType.doHistoneAnnotation()){

				List<String> histoneNameCellLineNameList = new ArrayList<String>();
				String[] histoneNameCellLineNames = new String[MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND];
				short[][] annotationBinaryMatrixforHistone = new short[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS][MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND];

				readAnnotations( givenIntervalName2ArrayXIndexMap, histoneNameCellLineNameList,
						histoneNameCellLineNames, annotationBinaryMatrixforHistone, outputFolder, Commons.HISTONE);
				writeAnnotationBinaryMatrix( annotationBinaryMatrixforHistone, givenIntervalNames,
						givenIntervalName2ArrayXIndexMap.size(), histoneNameCellLineNames,
						histoneNameCellLineNameList.size(), outputFolder, Commons.HISTONE, overlap2RSIDMap);

				histoneNameCellLineNameList = null;
				histoneNameCellLineNames = null;
				annotationBinaryMatrixforHistone = null;

			}
			/****************************************************************/
			/********** Histone ends*****************************************/
			/****************************************************************/

			/****************************************************************/
			/**********KEGGPathway starts************************************/
			/****************************************************************/
			AnnotationType KEGGPathwayAnnotationType = AnnotationType.convertStringtoEnum( args[CommandLineArguments.KeggPathwayAnnotation.value()]);

			if( KEGGPathwayAnnotationType.doKEGGPathwayAnnotation()){

				/****************************************************************/
				/********** ExonBased KEGGPathway starts*************************/
				/****************************************************************/
				List<String> exonBasedKEGGPathwayList = new ArrayList<String>();
				String[] exonBasedKEGGPathwayNames = new String[MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND];
				short[][] annotationBinaryMatrixforExonBasedKEGG = new short[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS][MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND];

				readAnnotations( givenIntervalName2ArrayXIndexMap, exonBasedKEGGPathwayList, exonBasedKEGGPathwayNames,
						annotationBinaryMatrixforExonBasedKEGG, outputFolder, Commons.EXON_BASED_KEGG_PATHWAY);
				writeAnnotationBinaryMatrix( annotationBinaryMatrixforExonBasedKEGG, givenIntervalNames,
						givenIntervalName2ArrayXIndexMap.size(), exonBasedKEGGPathwayNames,
						exonBasedKEGGPathwayList.size(), outputFolder, Commons.EXON_BASED_KEGG_PATHWAY, overlap2RSIDMap);

				exonBasedKEGGPathwayList = null;
				exonBasedKEGGPathwayNames = null;
				annotationBinaryMatrixforExonBasedKEGG = null;
				/****************************************************************/
				/********** ExonBased KEGGPathway ends***************************/
				/****************************************************************/

				/****************************************************************/
				/********** RegulationBased KEGGPathway starts*******************/
				/****************************************************************/
				List<String> regulationBasedKEGGPathwayList = new ArrayList<String>();
				String[] regulationBasedKEGGPathwayNames = new String[MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND];
				short[][] annotationBinaryMatrixforRegulationBasedKEGG = new short[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS][MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND];

				readAnnotations( givenIntervalName2ArrayXIndexMap, regulationBasedKEGGPathwayList,
						regulationBasedKEGGPathwayNames, annotationBinaryMatrixforRegulationBasedKEGG, outputFolder,
						Commons.REGULATION_BASED_KEGG_PATHWAY);
				writeAnnotationBinaryMatrix( annotationBinaryMatrixforRegulationBasedKEGG, givenIntervalNames,
						givenIntervalName2ArrayXIndexMap.size(), regulationBasedKEGGPathwayNames,
						regulationBasedKEGGPathwayList.size(), outputFolder, Commons.REGULATION_BASED_KEGG_PATHWAY,
						overlap2RSIDMap);

				regulationBasedKEGGPathwayList = null;
				regulationBasedKEGGPathwayNames = null;
				annotationBinaryMatrixforRegulationBasedKEGG = null;
				/****************************************************************/
				/********** RegulationBased KEGGPathway ends*********************/
				/****************************************************************/

				/****************************************************************/
				/********** ALLBased KEGGPathway starts**************************/
				/****************************************************************/
				List<String> allBasedKEGGPathwayList = new ArrayList<String>();
				String[] allBasedKEGGPathwayNames = new String[MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND];
				short[][] annotationBinaryMatrixforAllBasedKEGG = new short[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS][MAXIMUM_NUMBER_OF_ELEMENTS_TEN_THOUSAND];

				readAnnotations( givenIntervalName2ArrayXIndexMap, allBasedKEGGPathwayList, allBasedKEGGPathwayNames,
						annotationBinaryMatrixforAllBasedKEGG, outputFolder, Commons.ALL_BASED_KEGG_PATHWAY);
				writeAnnotationBinaryMatrix( annotationBinaryMatrixforAllBasedKEGG, givenIntervalNames,
						givenIntervalName2ArrayXIndexMap.size(), allBasedKEGGPathwayNames,
						allBasedKEGGPathwayList.size(), outputFolder, Commons.ALL_BASED_KEGG_PATHWAY, overlap2RSIDMap);

				allBasedKEGGPathwayList = null;
				allBasedKEGGPathwayNames = null;
				annotationBinaryMatrixforAllBasedKEGG = null;
				/****************************************************************/
				/********** ALLBased KEGGPathway ends****************************/
				/****************************************************************/

			}
			/****************************************************************/
			/**********KEGGPathway ends**************************************/
			/****************************************************************/

			/****************************************************************/
			/**********TF KEGGPathway starts*********************************/
			/****************************************************************/
			AnnotationType tfKEGGPathwayAnnotationType = AnnotationType.convertStringtoEnum( args[CommandLineArguments.TfAndKeggPathwayAnnotation.value()]);

			if( tfKEGGPathwayAnnotationType.doTFKEGGPathwayAnnotation()){

				/****************************************************************/
				/********** TF EXONBased KEGGPathway starts**********************/
				/****************************************************************/
				List<String> tfExonBasedKEGGPathwayList = new ArrayList<String>();
				String[] tfExonBasedKEGGPathwayNames = new String[MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND];
				short[][] annotationBinaryMatrixforTFExonBasedKEGG = new short[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS][MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND];

				readAnnotations( givenIntervalName2ArrayXIndexMap, tfExonBasedKEGGPathwayList,
						tfExonBasedKEGGPathwayNames, annotationBinaryMatrixforTFExonBasedKEGG, outputFolder,
						Commons.TF_EXON_BASED_KEGG_PATHWAY);
				writeAnnotationBinaryMatrix( annotationBinaryMatrixforTFExonBasedKEGG, givenIntervalNames,
						givenIntervalName2ArrayXIndexMap.size(), tfExonBasedKEGGPathwayNames,
						tfExonBasedKEGGPathwayList.size(), outputFolder, Commons.TF_EXON_BASED_KEGG_PATHWAY,
						overlap2RSIDMap);

				tfExonBasedKEGGPathwayList = null;
				tfExonBasedKEGGPathwayNames = null;
				annotationBinaryMatrixforTFExonBasedKEGG = null;
				/****************************************************************/
				/********** TF EXONBased KEGGPathway ends************************/
				/****************************************************************/

				/****************************************************************/
				/********** TF RegulationBased KEGGPathway starts****************/
				/****************************************************************/
				List<String> tfRegulationBasedKEGGPathwayList = new ArrayList<String>();
				String[] tfRegulationBasedKEGGPathwayNames = new String[MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND];
				short[][] annotationBinaryMatrixforTFRegulationBasedKEGG = new short[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS][MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND];

				readAnnotations( givenIntervalName2ArrayXIndexMap, tfRegulationBasedKEGGPathwayList,
						tfRegulationBasedKEGGPathwayNames, annotationBinaryMatrixforTFRegulationBasedKEGG,
						outputFolder, Commons.TF_REGULATION_BASED_KEGG_PATHWAY);
				writeAnnotationBinaryMatrix( annotationBinaryMatrixforTFRegulationBasedKEGG, givenIntervalNames,
						givenIntervalName2ArrayXIndexMap.size(), tfRegulationBasedKEGGPathwayNames,
						tfRegulationBasedKEGGPathwayList.size(), outputFolder,
						Commons.TF_REGULATION_BASED_KEGG_PATHWAY, overlap2RSIDMap);

				tfRegulationBasedKEGGPathwayList = null;
				tfRegulationBasedKEGGPathwayNames = null;
				annotationBinaryMatrixforTFRegulationBasedKEGG = null;
				/****************************************************************/
				/********** TF RegulationBased KEGGPathway ends******************/
				/****************************************************************/

				/****************************************************************/
				/********** TF AllBased KEGGPathway starts***********************/
				/****************************************************************/
				List<String> tfAllBasedKEGGPathwayList = new ArrayList<String>();
				String[] tfAllBasedKEGGPathwayNames = new String[MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND];
				short[][] annotationBinaryMatrixforTFAllBasedKEGG = new short[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS][MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND];

				readAnnotations( givenIntervalName2ArrayXIndexMap, tfAllBasedKEGGPathwayList,
						tfAllBasedKEGGPathwayNames, annotationBinaryMatrixforTFAllBasedKEGG, outputFolder,
						Commons.TF_ALL_BASED_KEGG_PATHWAY);
				writeAnnotationBinaryMatrix( annotationBinaryMatrixforTFAllBasedKEGG, givenIntervalNames,
						givenIntervalName2ArrayXIndexMap.size(), tfAllBasedKEGGPathwayNames,
						tfAllBasedKEGGPathwayList.size(), outputFolder, Commons.TF_ALL_BASED_KEGG_PATHWAY,
						overlap2RSIDMap);

				tfAllBasedKEGGPathwayList = null;
				tfAllBasedKEGGPathwayNames = null;
				annotationBinaryMatrixforTFAllBasedKEGG = null;
				/****************************************************************/
				/********** TF AllBased KEGGPathway ends*************************/
				/****************************************************************/

			}
			/****************************************************************/
			/**********TF KEGGPathway ends***********************************/
			/****************************************************************/

			/****************************************************************/
			/**********TF CellLine KEGGPathway starts************************/
			/****************************************************************/
			AnnotationType tfCellLineKEGGPathwayAnnotationType = AnnotationType.convertStringtoEnum( args[CommandLineArguments.CellLineBasedTfAndKeggPathwayAnnotation.value()]);

			if( tfCellLineKEGGPathwayAnnotationType.doTFCellLineKEGGPathwayAnnotation()){

				/****************************************************************/
				/********** TF CELLLINE EXONBased KEGGPathway starts*************/
				/****************************************************************/
				List<String> tfCellLineExonBasedKEGGPathwayList = new ArrayList<String>();
				String[] tfCellLineExonBasedKEGGPathwayNames = new String[MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND];
				short[][] annotationBinaryMatrixforTFCellLineExonBasedKEGG = new short[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS][MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND];

				readAnnotations( givenIntervalName2ArrayXIndexMap, tfCellLineExonBasedKEGGPathwayList,
						tfCellLineExonBasedKEGGPathwayNames, annotationBinaryMatrixforTFCellLineExonBasedKEGG,
						outputFolder, Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY);
				writeAnnotationBinaryMatrix( annotationBinaryMatrixforTFCellLineExonBasedKEGG, givenIntervalNames,
						givenIntervalName2ArrayXIndexMap.size(), tfCellLineExonBasedKEGGPathwayNames,
						tfCellLineExonBasedKEGGPathwayList.size(), outputFolder,
						Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY, overlap2RSIDMap);

				tfCellLineExonBasedKEGGPathwayList = null;
				tfCellLineExonBasedKEGGPathwayNames = null;
				annotationBinaryMatrixforTFCellLineExonBasedKEGG = null;
				/****************************************************************/
				/********** TF CELLLINE EXONBased KEGGPathway ends***************/
				/****************************************************************/

				/****************************************************************/
				/********** TF CELLLINE REGULATIONBASED KEGGPathway starts*******/
				/****************************************************************/
				List<String> tfCellLineRegulationBasedKEGGPathwayList = new ArrayList<String>();
				String[] tfCellLineRegulationBasedKEGGPathwayNames = new String[MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND];
				short[][] annotationBinaryMatrixforTFCellLineRegulationBasedKEGG = new short[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS][MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND];

				readAnnotations( givenIntervalName2ArrayXIndexMap, tfCellLineRegulationBasedKEGGPathwayList,
						tfCellLineRegulationBasedKEGGPathwayNames,
						annotationBinaryMatrixforTFCellLineRegulationBasedKEGG, outputFolder,
						Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY);
				writeAnnotationBinaryMatrix( annotationBinaryMatrixforTFCellLineRegulationBasedKEGG,
						givenIntervalNames, givenIntervalName2ArrayXIndexMap.size(),
						tfCellLineRegulationBasedKEGGPathwayNames, tfCellLineRegulationBasedKEGGPathwayList.size(),
						outputFolder, Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY, overlap2RSIDMap);

				tfCellLineRegulationBasedKEGGPathwayList = null;
				tfCellLineRegulationBasedKEGGPathwayNames = null;
				annotationBinaryMatrixforTFCellLineRegulationBasedKEGG = null;
				/****************************************************************/
				/********** TF CELLLINE REGULATIONBASED KEGGPathway ends*********/
				/****************************************************************/

				/****************************************************************/
				/********** TF CELLLINE ALLBASED KEGGPathway starts**************/
				/****************************************************************/
				List<String> tfCellLineAllBasedKEGGPathwayList = new ArrayList<String>();
				String[] tfCellLineAllBasedKEGGPathwayNames = new String[MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND];
				short[][] annotationBinaryMatrixforTFCellLineAllBasedKEGG = new short[MAXIMUM_NUMBER_OF_GIVEN_INTERVALS][MAXIMUM_NUMBER_OF_ELEMENTS_ONE_HUNDRED_THOUSAND];

				readAnnotations( givenIntervalName2ArrayXIndexMap, tfCellLineAllBasedKEGGPathwayList,
						tfCellLineAllBasedKEGGPathwayNames, annotationBinaryMatrixforTFCellLineAllBasedKEGG,
						outputFolder, Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY);
				writeAnnotationBinaryMatrix( annotationBinaryMatrixforTFCellLineAllBasedKEGG, givenIntervalNames,
						givenIntervalName2ArrayXIndexMap.size(), tfCellLineAllBasedKEGGPathwayNames,
						tfCellLineAllBasedKEGGPathwayList.size(), outputFolder,
						Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY, overlap2RSIDMap);

				tfCellLineAllBasedKEGGPathwayList = null;
				tfCellLineAllBasedKEGGPathwayNames = null;
				annotationBinaryMatrixforTFCellLineAllBasedKEGG = null;
				/****************************************************************/
				/********** TF CELLLINE ALLBASED KEGGPathway ends****************/
				/****************************************************************/
			}
			/****************************************************************/
			/**********TF CellLine KEGGPathway ends**************************/
			/****************************************************************/

		}// End of IF doWriteAnnotationBinaryMatrixMode is true

		// Make null
		givenIntervalNames = null;
		givenIntervalName2ArrayXIndexMap = null;

	}

}
