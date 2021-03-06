/**
 * @author burcakotlu
 * @date Sep 17, 2014 
 * @time 4:47:22 PM
 */
package collaboration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import auxiliary.FileOperations;
import common.Commons;
import enumtypes.CommandLineArguments;
import enumtypes.MultipleTestingType;

/**
 * 
 */
public class ElementVersusPhenotypeEnrichmentBinaryMatrixForAllPhenotypes {

	public static final int NUMBER_OF_PHENOTYPES = 20;

	public static void readEnrichmentResults( String outputFolder, String phenoTypeName,
			float bonferroniCorrectionSignificanceLevel, String elementDirectory, ElementEnrichmentMap elementMap,
			List<String> elementNameList) {

		String enrichmentDirectory = outputFolder + phenoTypeName + System.getProperty( "file.separator") + Commons.ENRICHMENT + System.getProperty( "file.separator") + elementDirectory + System.getProperty( "file.separator");
		String name = null;

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String strLine = null;

		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;
		int indexofEigthTab;
		int indexofNinethTab;
		int indexofTenthTab;

		String elementName = null;
		float empiricalPValue;
		float BonferroniCorrectedPValue;
		float BHFDRAdjustedPValue;
		boolean enriched_BH_FDR;
		boolean enriched_Bonferroni_Correction;

		boolean headerLine = true;

		ElementEnrichment element = null;

		// Read each file under enrichmentFolder
		File enrichmentFolder = new File( enrichmentDirectory);

		if( enrichmentFolder.exists() && enrichmentFolder.isDirectory()){
			File[] files = enrichmentFolder.listFiles();

			for( File elementEnrichmentFile : files){
				// example
				// ExonBased_KEGGPathway_test4_wrt_BH_FDR_adjusted_pValue.txt
				if( elementEnrichmentFile.isFile()){

					// get file whose name contain "wrt"
					name = elementEnrichmentFile.getName();

					if( name.contains( Commons.WRT)){
						try{
							fileReader = new FileReader( elementEnrichmentFile);
							bufferedReader = new BufferedReader( fileReader);

							// Skip header line
							if( headerLine){
								strLine = bufferedReader.readLine();
								headerLine = false;
							}

							while( ( strLine = bufferedReader.readLine()) != null){

								indexofFirstTab = strLine.indexOf( '\t');
								indexofSecondTab = strLine.indexOf( '\t', indexofFirstTab + 1);
								indexofThirdTab = strLine.indexOf( '\t', indexofSecondTab + 1);
								indexofFourthTab = strLine.indexOf( '\t', indexofThirdTab + 1);
								indexofFifthTab = strLine.indexOf( '\t', indexofFourthTab + 1);
								indexofSixthTab = strLine.indexOf( '\t', indexofFifthTab + 1);
								indexofSeventhTab = strLine.indexOf( '\t', indexofSixthTab + 1);
								indexofEigthTab = strLine.indexOf( '\t', indexofSeventhTab + 1);
								indexofNinethTab = strLine.indexOf( '\t', indexofEigthTab + 1);
								indexofTenthTab = strLine.indexOf( '\t', indexofNinethTab + 1);

								// 3100170099 PU1_GM12878_hsa03060 1 0 10 109214
								// 0.00E+00 0.00E+00 0.00E+00 TRUE Protein
								// export - Homo sapiens (human) 10952, 11231,
								// 196294, 23478, 23480, 28972, 29927, 3309,
								// 5018, 55176, 58477, 60559, 6726, 6727, 6728,
								// 6729, 6730, 6731, 6734, 7095, 83943, 90701,
								// 9789 SEC61B, SEC63, IMMP1L, SEC11A, SEC61G,
								// SPCS1, SEC61A1, HSPA5, OXA1L, SEC61A2, SRPRB,
								// SPCS3, SRP9, SRP14, SRP19, SRP54, SRP68,
								// SRP72, SRPR, SEC62, IMMP2L, SEC11C, SPCS2

								// Get the element name
								elementName = strLine.substring( indexofFirstTab + 1, indexofSecondTab);

								if( !elementNameList.contains( elementName)){
									elementNameList.add( elementName);
								}

								empiricalPValue = Float.parseFloat( strLine.substring( indexofSixthTab + 1,
										indexofSeventhTab));
								BonferroniCorrectedPValue = Float.parseFloat( strLine.substring( indexofSeventhTab + 1,
										indexofEigthTab));
								BHFDRAdjustedPValue = Float.parseFloat( strLine.substring( indexofEigthTab + 1,
										indexofNinethTab));

								if( indexofTenthTab != -1){
									enriched_BH_FDR = Boolean.parseBoolean( strLine.substring( indexofNinethTab + 1,
											indexofTenthTab));

								}else{
									enriched_BH_FDR = Boolean.parseBoolean( strLine.substring( indexofNinethTab + 1));
								}

								if( BonferroniCorrectedPValue <= bonferroniCorrectionSignificanceLevel){
									enriched_Bonferroni_Correction = true;
								}else{
									enriched_Bonferroni_Correction = false;

								}

								element = new ElementEnrichment( elementName, enriched_Bonferroni_Correction,
										enriched_BH_FDR, empiricalPValue, BonferroniCorrectedPValue,
										BHFDRAdjustedPValue);

								elementMap.getElementEnrichmentMap().put( elementName, element);

							}// End of while

							bufferedReader.close();
							fileReader.close();

						}catch( FileNotFoundException e){
							// TODO Auto-generated catch block
							e.printStackTrace();
						}catch( IOException e){
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}// End of IF: file containing Commons.WRT

				}// End of IF: it is a file

			}// End of for: each file in this directory

		}// End of IF: It is a directory
	}

	public static void writeEnrichmentResultsInACertainOrder( String encodeCollaborationHeatMapDirectory,
			String elementDirectory, String extraFileName, MultipleTestingType multipleTestingParameter,
			String[] phenotypeDirectoryNames, ElementEnrichmentMap[] elementEnrichmentMapArray,
			List<String> elementNameList) {

		String outputDirectory = encodeCollaborationHeatMapDirectory + elementDirectory + System.getProperty( "file.separator") + extraFileName + "_EnrichmentTable.txt";

		BufferedWriter bufferedWriter = null;

		ElementEnrichmentMap elementEnrichmentMap = null;
		ElementEnrichment elementEnrichment = null;

		try{
			bufferedWriter = new BufferedWriter( FileOperations.createFileWriter( outputDirectory));

			// Write header line
			bufferedWriter.write( "ElementName" + "\t");

			for( int i = 0; i < phenotypeDirectoryNames.length; i++){
				// not last phenotype
				if( i < phenotypeDirectoryNames.length - 1){
					bufferedWriter.write( phenotypeDirectoryNames[i] + "\t");
				}
				// last phenotype name
				else if( i == ( phenotypeDirectoryNames.length - 1)){
					bufferedWriter.write( phenotypeDirectoryNames[i] + System.getProperty( "line.separator"));
				}
			}// End of For: writing header line

			for( String elementName : elementNameList){
				bufferedWriter.write( elementName + "\t");

				for( int i = 0; i < phenotypeDirectoryNames.length; i++){

					elementEnrichmentMap = elementEnrichmentMapArray[i];

					// not last phenotype
					if( i < ( phenotypeDirectoryNames.length - 1)){
						if( elementEnrichmentMap.getElementEnrichmentMap().containsKey( elementName)){

							elementEnrichment = elementEnrichmentMap.getElementEnrichmentMap().get( elementName);
							// Write its 1/0 enriched or not value

							if( multipleTestingParameter.isBonferroniCorrection()){
								if( elementEnrichment.isEnriched_Bonferroni_Correction()){
									bufferedWriter.write( "1" + "\t");
								}else{
									bufferedWriter.write( "0" + "\t");
								}
							}else if( multipleTestingParameter.isBenjaminiHochbergFDR()){
								if( elementEnrichment.isEnriched_BH_FDR()){
									bufferedWriter.write( "1" + "\t");
								}else{
									bufferedWriter.write( "0" + "\t");
								}
							}

						}else{
							// Write 0
							bufferedWriter.write( "0" + "\t");
						}
					}
					// last phenotype
					else if( i == ( phenotypeDirectoryNames.length - 1)){
						if( elementEnrichmentMap.getElementEnrichmentMap().containsKey( elementName)){

							elementEnrichment = elementEnrichmentMap.getElementEnrichmentMap().get( elementName);
							// Write its 1/0 enriched or not value

							if( multipleTestingParameter.isBonferroniCorrection()){
								if( elementEnrichment.isEnriched_Bonferroni_Correction()){
									bufferedWriter.write( "1" + System.getProperty( "line.separator"));
								}else{
									bufferedWriter.write( "0" + System.getProperty( "line.separator"));
								}
							}else if( multipleTestingParameter.isBenjaminiHochbergFDR()){
								if( elementEnrichment.isEnriched_BH_FDR()){
									bufferedWriter.write( "1" + System.getProperty( "line.separator"));
								}else{
									bufferedWriter.write( "0" + System.getProperty( "line.separator"));
								}
							}

						}else{
							// Write 0
							bufferedWriter.write( "0" + System.getProperty( "line.separator"));
						}
					}

				}// End of for each phenotype in the phenotypeDirectoryNames
			}// End of for each elementName in the elementNameList

			bufferedWriter.close();

		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initializePhenotypeDirectoryNames( String[] phenotypeDirectoryNames) {

		phenotypeDirectoryNames[0] = "AtrialFibrillation";
		phenotypeDirectoryNames[1] = "BloodPressure";
		phenotypeDirectoryNames[2] = "BodyMassIndex";
		phenotypeDirectoryNames[3] = "Cardiomegaly";
		phenotypeDirectoryNames[4] = "CarotidArteryDiseases";
		phenotypeDirectoryNames[5] = "Cholesterol_HDL";
		phenotypeDirectoryNames[6] = "Cholesterol_LDL";
		phenotypeDirectoryNames[7] = "Coagulation";
		phenotypeDirectoryNames[8] = "CoronaryArteryDisease";
		phenotypeDirectoryNames[9] = "CReactiveProtein";
		phenotypeDirectoryNames[10] = "DeathSuddenCardiac";
		phenotypeDirectoryNames[11] = "DiabetesMellitusType1";
		phenotypeDirectoryNames[12] = "DiabetesMellitusType2";
		phenotypeDirectoryNames[13] = "DiabeticRetinopathy";
		phenotypeDirectoryNames[14] = "IntracranialAneurysm";
		phenotypeDirectoryNames[15] = "Lipoproteina";
		phenotypeDirectoryNames[16] = "Smoking";
		phenotypeDirectoryNames[17] = "Triglycerides";
		phenotypeDirectoryNames[18] = "VenousThrombosis";
		phenotypeDirectoryNames[18] = "VenousThrombosis";
		phenotypeDirectoryNames[19] = "CVD_381_snps_100000P";

	}

	public static void readElementEnrichmentMapsforDifferentPhenotypes( String outputFolder,
			float bonferroniCorrectionSignificanceLevel, String elementDirectory,
			String[] phenotypeDirectoryNamesArray, ElementEnrichmentMap[] elementEnrichmentMapArray,
			List<String> elementNameList) {

		ElementEnrichmentMap elementEnrichmentMap = null;

		// for each phenotype in the phenotypeDirectoryNamesArray
		// Read elementEnrichmentMap for that phenotype
		// for the indicated elementType
		// also fill the elementNameList while reading elementEnrichmentMap
		for( int i = 0; i < phenotypeDirectoryNamesArray.length; i++){
			elementEnrichmentMap = elementEnrichmentMapArray[i];
			readEnrichmentResults( outputFolder, phenotypeDirectoryNamesArray[i],
					bonferroniCorrectionSignificanceLevel, elementDirectory, elementEnrichmentMap, elementNameList);

		}// End of for each phenotype

	}

	public static void prepareElementVersusPhenotypeEnrichmentTable( String outputFolder,
			String encodeCollaborationHeatMapDirectory, float bonferroniCorrectionSignificanceLevel,
			MultipleTestingType multipleTestingParameter, String elementShortDirectory, String elementLongDirectory,
			String extraFileName, int NUMBER_OF_PHENOTYPES, String[] phenotypeDirectoryNames,
			List<String> elementNameList, ElementEnrichmentMap[] elementEnrichmentMapArray) {

		// Will be initialized for each element type starts
		elementNameList = new ArrayList<String>();
		elementEnrichmentMapArray = new ElementEnrichmentMap[NUMBER_OF_PHENOTYPES];

		for( int i = 0; i < NUMBER_OF_PHENOTYPES; i++){
			elementEnrichmentMapArray[i] = new ElementEnrichmentMap();
		}

		// Read elementEnrichmentMap for all phenotypes starts
		// Fill elementNameList while reading elementEnrichmentMaps for 19
		// phenotypes
		readElementEnrichmentMapsforDifferentPhenotypes( outputFolder, bonferroniCorrectionSignificanceLevel,
				elementLongDirectory, phenotypeDirectoryNames, elementEnrichmentMapArray, elementNameList);
		// Read elementEnrichmentMap for all phenotypes ends

		// According to the order in elementNameList
		// Write EnrichmentTable filled with 1/0s for the selected multiple
		// testing parameter for 19 phenotypes
		writeEnrichmentResultsInACertainOrder( encodeCollaborationHeatMapDirectory, elementShortDirectory,
				extraFileName, multipleTestingParameter, phenotypeDirectoryNames, elementEnrichmentMapArray,
				elementNameList);

	}

	public static void main( String[] args) {

		
		//String glanetFolder = args[CommandLineArguments.GlanetFolder.value()];

		// Multiple Testing Parameter for selection of enriched elements
		MultipleTestingType multipleTestingParameter = MultipleTestingType.convertStringtoEnum( args[6]);

		float bonferroniCorrectionSignificanceLevel = Float.parseFloat( args[7]);

		// jobName starts
		String jobName = args[17].trim();
		if( jobName.isEmpty()){
			jobName = "noname";
		}
		// jobName ends

		String outputFolder = args[CommandLineArguments.OutputFolder.value()];

		/********************************************************************/
		/*********** delete old files starts **********************************/
		String encodeCollaborationHeatMapDirectory = outputFolder + System.getProperty( "file.separator") + jobName + System.getProperty( "file.separator") + Commons.ENCODE_COLLABORATION + System.getProperty( "file.separator") + Commons.ENRICHMENT_BINARY_MATRIX_FOR_ALL_PHENOTYPES + System.getProperty( "file.separator");

		FileOperations.deleteOldFiles( encodeCollaborationHeatMapDirectory);
		/*********** delete old files ends ***********************************/
		/******************************************************************/

		// Element Name List
		List<String> elementNameList = null;

		// Order of phenotypes in elementEnrichmentMapArray and
		// phenotypeDirectoryNames are the same
		// For example elementEnrichmentMapArray[0] has the
		// elementEnrichmentMapArray for the phenotypeDirectoryNames[0]
		// phenotype.
		// Element Enrichment Map Array
		ElementEnrichmentMap[] elementEnrichmentMapArray = null;
		// Fill array with all Phenotype directory names starts
		String[] phenotypeDirectoryNames = new String[NUMBER_OF_PHENOTYPES];
		initializePhenotypeDirectoryNames( phenotypeDirectoryNames);
		// Fill array with all Phenotype directory names ends

		/*******************************************************************************/
		/*************************** DNASE starts ****************************************/
		/*******************************************************************************/
		prepareElementVersusPhenotypeEnrichmentTable( outputFolder, encodeCollaborationHeatMapDirectory,
				bonferroniCorrectionSignificanceLevel, multipleTestingParameter, Commons.DNASE, Commons.DNASE,
				Commons.DNASE, NUMBER_OF_PHENOTYPES, phenotypeDirectoryNames, elementNameList,
				elementEnrichmentMapArray);
		/*******************************************************************************/
		/*************************** DNASE ends ******************************************/
		/*******************************************************************************/

		/*******************************************************************************/
		/*************************** TF starts *******************************************/
		/*******************************************************************************/
		prepareElementVersusPhenotypeEnrichmentTable( outputFolder, encodeCollaborationHeatMapDirectory,
				bonferroniCorrectionSignificanceLevel, multipleTestingParameter, Commons.TF, Commons.TF, Commons.TF,
				NUMBER_OF_PHENOTYPES, phenotypeDirectoryNames, elementNameList, elementEnrichmentMapArray);
		/*******************************************************************************/
		/*************************** TF ends *********************************************/
		/*******************************************************************************/

		/*******************************************************************************/
		/*************************** HISTONE starts **************************************/
		/*******************************************************************************/
		prepareElementVersusPhenotypeEnrichmentTable( outputFolder, encodeCollaborationHeatMapDirectory,
				bonferroniCorrectionSignificanceLevel, multipleTestingParameter, Commons.HISTONE, Commons.HISTONE,
				Commons.HISTONE, NUMBER_OF_PHENOTYPES, phenotypeDirectoryNames, elementNameList,
				elementEnrichmentMapArray);
		/*******************************************************************************/
		/*************************** HISTONE ends ****************************************/
		/*******************************************************************************/

		/*******************************************************************************/
		/*************************** KEGGPATHWAY starts **********************************/
		/*******************************************************************************/
		prepareElementVersusPhenotypeEnrichmentTable( outputFolder, encodeCollaborationHeatMapDirectory,
				bonferroniCorrectionSignificanceLevel, multipleTestingParameter, Commons.KEGG_PATHWAY,
				Commons.KEGG_PATHWAY + System.getProperty( "file.separator") + Commons.EXON_BASED_KEGG_PATHWAY,
				Commons.EXON_BASED_KEGG_PATHWAY, NUMBER_OF_PHENOTYPES, phenotypeDirectoryNames, elementNameList,
				elementEnrichmentMapArray);
		prepareElementVersusPhenotypeEnrichmentTable( outputFolder, encodeCollaborationHeatMapDirectory,
				bonferroniCorrectionSignificanceLevel, multipleTestingParameter, Commons.KEGG_PATHWAY,
				Commons.KEGG_PATHWAY + System.getProperty( "file.separator") + Commons.REGULATION_BASED_KEGG_PATHWAY,
				Commons.REGULATION_BASED_KEGG_PATHWAY, NUMBER_OF_PHENOTYPES, phenotypeDirectoryNames, elementNameList,
				elementEnrichmentMapArray);
		prepareElementVersusPhenotypeEnrichmentTable( outputFolder, encodeCollaborationHeatMapDirectory,
				bonferroniCorrectionSignificanceLevel, multipleTestingParameter, Commons.KEGG_PATHWAY,
				Commons.KEGG_PATHWAY + System.getProperty( "file.separator") + Commons.ALL_BASED_KEGG_PATHWAY,
				Commons.ALL_BASED_KEGG_PATHWAY, NUMBER_OF_PHENOTYPES, phenotypeDirectoryNames, elementNameList,
				elementEnrichmentMapArray);
		/*******************************************************************************/
		/*************************** KEGGPATHWAY ends ************************************/
		/*******************************************************************************/

		/*******************************************************************************/
		/*************************** TF_KEGGPATHWAY starts *******************************/
		/*******************************************************************************/
		prepareElementVersusPhenotypeEnrichmentTable( outputFolder, encodeCollaborationHeatMapDirectory,
				bonferroniCorrectionSignificanceLevel, multipleTestingParameter, Commons.TF_KEGGPATHWAY,
				Commons.TF_KEGGPATHWAY + System.getProperty( "file.separator") + Commons.TF_EXON_BASED_KEGG_PATHWAY,
				Commons.TF_EXON_BASED_KEGG_PATHWAY, NUMBER_OF_PHENOTYPES, phenotypeDirectoryNames, elementNameList,
				elementEnrichmentMapArray);
		prepareElementVersusPhenotypeEnrichmentTable(
				outputFolder,
				encodeCollaborationHeatMapDirectory,
				bonferroniCorrectionSignificanceLevel,
				multipleTestingParameter,
				Commons.TF_KEGGPATHWAY,
				Commons.TF_KEGGPATHWAY + System.getProperty( "file.separator") + Commons.TF_REGULATION_BASED_KEGG_PATHWAY,
				Commons.TF_REGULATION_BASED_KEGG_PATHWAY, NUMBER_OF_PHENOTYPES, phenotypeDirectoryNames,
				elementNameList, elementEnrichmentMapArray);
		prepareElementVersusPhenotypeEnrichmentTable( outputFolder, encodeCollaborationHeatMapDirectory,
				bonferroniCorrectionSignificanceLevel, multipleTestingParameter, Commons.TF_KEGGPATHWAY,
				Commons.TF_KEGGPATHWAY + System.getProperty( "file.separator") + Commons.TF_ALL_BASED_KEGG_PATHWAY,
				Commons.TF_ALL_BASED_KEGG_PATHWAY, NUMBER_OF_PHENOTYPES, phenotypeDirectoryNames, elementNameList,
				elementEnrichmentMapArray);
		/*******************************************************************************/
		/*************************** TF_KEGGPATHWAY ends *********************************/
		/*******************************************************************************/

		/*******************************************************************************/
		/*************************** TF_CELLLINE_KEGGPATHWAY starts **********************/
		/*******************************************************************************/
		prepareElementVersusPhenotypeEnrichmentTable(
				outputFolder,
				encodeCollaborationHeatMapDirectory,
				bonferroniCorrectionSignificanceLevel,
				multipleTestingParameter,
				Commons.TF_CELLLINE_KEGGPATHWAY,
				Commons.TF_CELLLINE_KEGGPATHWAY + System.getProperty( "file.separator") + Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY,
				Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY, NUMBER_OF_PHENOTYPES, phenotypeDirectoryNames,
				elementNameList, elementEnrichmentMapArray);
		prepareElementVersusPhenotypeEnrichmentTable(
				outputFolder,
				encodeCollaborationHeatMapDirectory,
				bonferroniCorrectionSignificanceLevel,
				multipleTestingParameter,
				Commons.TF_CELLLINE_KEGGPATHWAY,
				Commons.TF_CELLLINE_KEGGPATHWAY + System.getProperty( "file.separator") + Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY,
				Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY, NUMBER_OF_PHENOTYPES, phenotypeDirectoryNames,
				elementNameList, elementEnrichmentMapArray);
		prepareElementVersusPhenotypeEnrichmentTable(
				outputFolder,
				encodeCollaborationHeatMapDirectory,
				bonferroniCorrectionSignificanceLevel,
				multipleTestingParameter,
				Commons.TF_CELLLINE_KEGGPATHWAY,
				Commons.TF_CELLLINE_KEGGPATHWAY + System.getProperty( "file.separator") + Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY,
				Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY, NUMBER_OF_PHENOTYPES, phenotypeDirectoryNames,
				elementNameList, elementEnrichmentMapArray);
		/*******************************************************************************/
		/*************************** TF_CELLINE_KEGGPATHWAY ends *************************/
		/*******************************************************************************/

	}

}
