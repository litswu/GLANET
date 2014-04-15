/**
 * @author Burcak Otlu
 * Jan 16, 2014
 * 4:28:36 PM
 * 2014
 *
 * 
 */
package augmentation.results;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import auxiliary.FileOperations;

import common.Commons;


public class AugmentationofEnrichedElementswithIntervals {

	/**
	 * 
	 */
	public AugmentationofEnrichedElementswithIntervals() {
	}
	
	//Read C:\Users\burcakotlu\GLANET\Output\Doktora\empiricalpvalues\toBeCollected\Histone
	//Augment it with C:\Users\burcakotlu\GLANET\Output\Doktora\annotate\intervals\parametric\original\histone overlaps
	//Write augmented results
	//For Histone
	public void	readHistoneFileAugmentandWrite(String outputFolder,String multipleTestingParameter,Float FDR, Float bonfCorrectionSignificanceLevel,String inputFileName, String outputFileName){
		String strLine1;
		String strLine2;
		
		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;
		int indexofEigthTab; 
	
		String histoneNameCellLineName;
		
		Float empiricalPValue;
		Float bonfCorrectedPValue; 
		Float bhFDRAdjustedPValue;
		
		FileReader inputFileReader = null;
		BufferedReader bufferedReader = null;
		
		FileWriter outputFileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		FileReader histoneFileReader = null;
		BufferedReader histoneBufferedReader = null;
				
		List<String> enrichedHistoneElements = new ArrayList<String>();
				
		try {
			inputFileReader = new FileReader(outputFolder + inputFileName);
			bufferedReader = new BufferedReader(inputFileReader);
			
			outputFileWriter = FileOperations.createFileWriter(outputFolder + outputFileName);
			bufferedWriter = new BufferedWriter(outputFileWriter);

			//skip headerLine
			//Element	OriginalNumberofOverlaps	NumberofPermutationsHavingNumberofOverlapsGreaterThanorEqualTo in 10 Permutations	Number of Permutations	Number of comparisons	empiricalPValue	BonfCorrPVlaue: numberOfComparisons 82	BH FDR Adjusted P Value	Reject Null Hypothesis for an FDR of 0.05
			strLine1= bufferedReader.readLine();
			
			while ((strLine1= bufferedReader.readLine())!=null ){
				
				//example line
				//H2AZ_K562	129	0	10	162	0.00E+00	0.00E+00	0.00E+00	TRUE
	
				indexofFirstTab 	= strLine1.indexOf('\t');
				indexofSecondTab 	= strLine1.indexOf('\t',indexofFirstTab+1);
				indexofThirdTab 	= strLine1.indexOf('\t',indexofSecondTab+1);
				indexofFourthTab 	= strLine1.indexOf('\t',indexofThirdTab+1);
				indexofFifthTab 	= strLine1.indexOf('\t',indexofFourthTab+1);
				indexofSixthTab 	= strLine1.indexOf('\t',indexofFifthTab+1);
				indexofSeventhTab	= strLine1.indexOf('\t',indexofSixthTab+1);
				indexofEigthTab 	= strLine1.indexOf('\t',indexofSeventhTab+1);
						
				histoneNameCellLineName = strLine1.substring(0, indexofFirstTab);
							
				//Pay attention to the order
				empiricalPValue = Float.parseFloat(strLine1.substring(indexofFifthTab+1, indexofSixthTab));
				bonfCorrectedPValue= Float.parseFloat(strLine1.substring(indexofSixthTab+1, indexofSeventhTab));
				bhFDRAdjustedPValue = Float.parseFloat(strLine1.substring(indexofSeventhTab+1, indexofEigthTab));
											
							
				if(multipleTestingParameter.equals(Commons.BENJAMINI_HOCHBERG_FDR_ADJUSTED_P_VALUE)){
					
					if (bhFDRAdjustedPValue <= FDR){					
						enrichedHistoneElements.add(histoneNameCellLineName);	
					}
					
				}else if(multipleTestingParameter.equals(Commons.BONFERRONI_CORRECTED_P_VALUE)){
					
					if (bonfCorrectedPValue <= bonfCorrectionSignificanceLevel){					
						enrichedHistoneElements.add(histoneNameCellLineName);	
					}
					
				}

					
			}//end of while : reading enriched dnase elements file line by line.
			
			
			
			//starts
			for(String histoneElementName: enrichedHistoneElements){
				
				bufferedWriter.write("**************" + "\t" + histoneElementName + "\t" + "**************" +  System.getProperty("line.separator"));
												
					histoneFileReader = new FileReader(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_HISTONE + "_" + histoneElementName + ".txt");						
					histoneBufferedReader = new BufferedReader(histoneFileReader);
							
					//Get all the lines of the original data annotation for the enriched Tf and KeggPathway 
					//Write them to the file
					while((strLine2 = histoneBufferedReader.readLine())!=null){
						bufferedWriter.write(histoneElementName + "\t" +strLine2 + System.getProperty("line.separator"));
					}
					
				
			}//End of for	
			//ends
						
			bufferedWriter.close();
			bufferedReader.close();
			
			if(histoneBufferedReader!=null){
				histoneBufferedReader.close();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	//Read C:\Users\burcakotlu\GLANET\Output\Doktora\empiricalpvalues\toBeCollected\Dnase\Dnase_all.txt
	//Augment it with annotate\\intervals\\parametric\\output results
	//Write augmented results
	//For Dnase
	public void readDnaseFileAugmentandWrite(String outputFolder,String multipleTestingParameter,Float FDR, Float bonfCorrectionSignificanceLevel,String inputFileName, String outputFileName){
	
		String strLine1;
		String strLine2;
		
		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;
		int indexofEigthTab; 
	
		String dnaseElementName;
		
		Float empiricalPValue;
		Float bonfCorrectedPValue; 
		Float bhFDRAdjustedPValue;
		
		FileReader inputFileReader = null;
		BufferedReader bufferedReader = null;
		
		FileWriter outputFileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		FileReader dnaseFileReader = null;
		BufferedReader dnaseBufferedReader = null;
				
		List<String> enrichedDnaseElements = new ArrayList<String>();
				
		try {
			inputFileReader = new FileReader(outputFolder + inputFileName);
			bufferedReader = new BufferedReader(inputFileReader);
			
			outputFileWriter = FileOperations.createFileWriter(outputFolder + outputFileName);
			bufferedWriter = new BufferedWriter(outputFileWriter);

			//skip headerLine
			//Element	OriginalNumberofOverlaps	NumberofPermutationsHavingNumberofOverlapsGreaterThanorEqualTo in 10 Permutations	Number of Permutations	Number of comparisons	empiricalPValue	BonfCorrPVlaue: numberOfComparisons 82	BH FDR Adjusted P Value	Reject Null Hypothesis for an FDR of 0.05
			strLine1= bufferedReader.readLine();
			
			while ((strLine1= bufferedReader.readLine())!=null ){
				
				//example line
				//HMVEC_LLY	30	0	10	82	0.00E+00	0.00E+00	0.00E+00	TRUE
				
				indexofFirstTab 	= strLine1.indexOf('\t');
				indexofSecondTab 	= strLine1.indexOf('\t',indexofFirstTab+1);
				indexofThirdTab 	= strLine1.indexOf('\t',indexofSecondTab+1);
				indexofFourthTab 	= strLine1.indexOf('\t',indexofThirdTab+1);
				indexofFifthTab 	= strLine1.indexOf('\t',indexofFourthTab+1);
				indexofSixthTab 	= strLine1.indexOf('\t',indexofFifthTab+1);
				indexofSeventhTab	= strLine1.indexOf('\t',indexofSixthTab+1);
				indexofEigthTab 	= strLine1.indexOf('\t',indexofSeventhTab+1);
						
				dnaseElementName = strLine1.substring(0, indexofFirstTab);
							
				//Pay attention to the order
				empiricalPValue = Float.parseFloat(strLine1.substring(indexofFifthTab+1, indexofSixthTab));
				bonfCorrectedPValue= Float.parseFloat(strLine1.substring(indexofSixthTab+1, indexofSeventhTab));
				bhFDRAdjustedPValue = Float.parseFloat(strLine1.substring(indexofSeventhTab+1, indexofEigthTab));
				
				if(multipleTestingParameter.equals(Commons.BENJAMINI_HOCHBERG_FDR_ADJUSTED_P_VALUE)){
					
					if (bhFDRAdjustedPValue <= FDR){					
						enrichedDnaseElements.add(dnaseElementName);	
									}
					
				}else if(multipleTestingParameter.equals(Commons.BONFERRONI_CORRECTED_P_VALUE)){
					
					if (bonfCorrectedPValue <= bonfCorrectionSignificanceLevel){					
						enrichedDnaseElements.add(dnaseElementName);	
									}
					
				}
					
					
			}//end of while : reading enriched dnase elements file line by line.
			
			
			
			//starts
			for(String dnaseName: enrichedDnaseElements){
				
				bufferedWriter.write("**************" + "\t" + dnaseName + "\t" + "**************" +  System.getProperty("line.separator"));
												
					dnaseFileReader = new FileReader(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_DNASE + "_" + dnaseName + ".txt");						
					dnaseBufferedReader = new BufferedReader(dnaseFileReader);
							
					//Get all the lines of the original data annotation for the enriched Tf and KeggPathway 
					//Write them to the file
					while((strLine2 = dnaseBufferedReader.readLine())!=null){
						bufferedWriter.write(dnaseName + "\t" +strLine2 + System.getProperty("line.separator"));
					}
					
				
			}//End of for	
			//ends
			
			
			bufferedWriter.close();
			bufferedReader.close();
			if (dnaseBufferedReader!=null) {
				dnaseBufferedReader.close();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	
	//Read the empiricalpvalues\\output\\tobeCollected  first
	//and
	//Augment it with annotate\\intervals\\parametric\\original results
	//Write augmented results
	//For Tf KeggPathway
	public void readTfKeggPathwayFileAugmentandWrite(String outputFolder,String multipleTestingParameter, Float FDR, Float bonfCorrectionSignificanceLevel, String inputFileName, String outputFileName, String type){
		String strLine1;
		String strLine2;
		
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
			
		int indexofFirstUnderscore;
		
		String tfName_keggPathwayName;
		String keggPathwayName;
		String keggPathwayDescription;
		Float bonfCorrectedPValue; 
		Float empiricalPValue;
		String keggPathwayNameandDescription;
		
		Float bhFDRAdjustedPValue ;
		
		FileReader tfandKeggPathwayFileReader = null;
		BufferedReader tfandKeggPathwayBufferedReader;
		
		Map<String,List<String>> enrichedKeggPathways = new HashMap<String,List<String>>();
		List<String> lines;
				
		try {
			FileReader inputFileReader  = new FileReader(outputFolder + inputFileName);
			BufferedReader bufferedReader = new BufferedReader(inputFileReader);
			
			FileWriter outputFileWriter = FileOperations.createFileWriter(outputFolder + outputFileName);
			BufferedWriter bufferedWriter = new BufferedWriter(outputFileWriter);
			
			//skip headerLine
			//Name	OriginalNumberofOverlaps	AccumulatedNumberofOverlaps	NumberofPermutations	NumberofComparisons	BonfCorrEmpiricalPValue	EmpiricalPValue
			strLine1= bufferedReader.readLine();
			
			while ((strLine1= bufferedReader.readLine())!=null ){
			
				//example line
				//AP2GAMMA_hsa00532	1	2	10000	40081	1.00E+00	2.00E-04	9.00E-03	1	Glycosaminoglycan biosynthesis - chondroitin sulfate / dermatan sulfate - Homo sapiens (human)	10090, 11285, 113189, 126792, 166012, 22856, 26229, 29940, 337876, 50515, 51363, 54480, 55454, 55501, 55790, 56548, 64131, 64132, 79586, 9469	UST, B4GALT7, CHST14, B3GALT6, CHST13, CHSY1, B3GAT3, DSE, CHSY3, CHST11, CHST15, CHPF2, CSGALNACT2, CHST12, CSGALNACT1, CHST7, XYLT1, XYLT2, CHPF, CHST3
				//WHIP_hsa05016	0.00E+00	Huntington's disease - Homo sapiens (human)	100532726, 10105, 10126, 10476, 10488, 10540, 10891, 10975, 1173, 1175, 1211, 1212, 1213, 125965, 126328, 1327, 1329, 1337, 1339, 1340, 1345, 1346, 1347, 1349, 1350, 1351, 1385, 1387, 146754, 148327, 1537, 160, 161, 163, 1639, 170712, 1742, 2033, 23186, 23236, 246721, 25942, 25981, 27019, 27089, 27113, 2776, 2876, 2902, 2904, 291, 2915, 292, 293, 29796, 3064, 3065, 3066, 3092, 317, 341947, 3708, 374291, 387332, 440567, 4508, 4509, 4512, 4513, 4514, 4519, 4694, 4695, 4696, 4697, 4698, 4700, 4701, 4702, 4704, 4705, 4706, 4707, 4708, 4709, 4710, 4711, 4712, 4713, 4714, 4715, 4716, 4717, 4718, 4719, 4720, 4722, 4723, 4724, 4725, 4726, 4728, 4729, 4731, 4899, 498, 506, 509, 51079, 51164, 513, 514, 515, 516, 517, 518, 522, 5330, 5331, 5332, 539, 54205, 5430, 5431, 5432, 5433, 5434, 5435, 5436, 5437, 5438, 5439, 5440, 5441, 54539, 5468, 548644, 55081, 55567, 55967, 56901, 581, 5978, 627, 6389, 6390, 6391, 6392, 64446, 64764, 6647, 6648, 6667, 6874, 6875, 6908, 7019, 7052, 7157, 7350, 7381, 7384, 7385, 7386, 7388, 7416, 7417, 7419, 7802, 8218, 83447, 83544, 836, 841, 842, 84699, 84701, 9001, 90993, 9167, 9377, 9519, 9586	NDUFC2-KCTD14, PPIF, DNAL4, ATP5H, CREB3, DCTN2, PPARGC1A, UQCR11, AP2M1, AP2S1, CLTA, CLTB, CLTC, COX6B2, NDUFA11, COX4I1, COX5B, COX6A1, COX6A2, COX6B1, COX6C, COX7A1, COX7A2, COX7B, COX7C, COX8A, CREB1, CREBBP, DNAH2, CREB3L4, CYC1, AP2A1, AP2A2, AP2B1, DCTN1, COX7B2, DLG4, EP300, RCOR1, PLCB1, POLR2J2, SIN3A, DNAH1, DNAI1, UQCRQ, BBC3, GNAQ, GPX1, GRIN1, GRIN2B, SLC25A4, GRM5, SLC25A5, SLC25A6, UQCR10, HTT, HDAC1, HDAC2, HIP1, APAF1, COX8C, ITPR1, NDUFS7, TBPL2, UQCRHL, NDUFA1, NDUFA2, NDUFA3, NDUFA4, NDUFA5, NDUFA6, NDUFA7, NDUFA8, NDUFA9, NDUFA10, NDUFAB1, NDUFB1, NDUFB2, NDUFB3, NDUFB4, NDUFB5, NDUFB6, NDUFB7, NDUFB8, NDUFB9, NDUFB10, NDUFC1, NDUFC2, NDUFS1, NDUFS2, NDUFS3, NDUFV1, NDUFS4, NDUFS5, NDUFS6, NDUFS8, NDUFV2, NDUFV3, NRF1, ATP5A1, ATP5B, ATP5C1, NDUFA13, DCTN4, ATP5D, ATP5E, ATP5F1, ATP5G1, ATP5G2, ATP5G3, ATP5J, PLCB2, PLCB3, PLCB4, ATP5O, CYCS, POLR2A, POLR2B, POLR2C, POLR2D, POLR2E, POLR2F, POLR2G, POLR2H, POLR2I, POLR2J, POLR2K, POLR2L, NDUFB11, PPARG, POLR2J3, IFT57, DNAH3, NDUFA12, NDUFA4L2, BAX, REST, BDNF, SDHA, SDHB, SDHC, SDHD, DNAI2, CREB3L2, SOD1, SOD2, SP1, TAF4, TAF4B, TBP, TFAM, TGM2, TP53, UCP1, UQCRB, UQCRC1, UQCRC2, UQCRFS1, UQCRH, VDAC1, VDAC2, VDAC3, DNALI1, CLTCL1, SLC25A31, DNAL1, CASP3, CASP8, CASP9, CREB3L3, COX4I2, HAP1, CREB3L1, COX7A2L, COX5A, TBPL1, CREB5

//				new example line
//				JUND_hsa05164	4	0	10000	40081	0.00E+00	0.00E+00	0.00E+00	TRUE
				
				indexofFirstTab 	= strLine1.indexOf('\t');
				indexofSecondTab 	= strLine1.indexOf('\t',indexofFirstTab+1);
				indexofThirdTab 	= strLine1.indexOf('\t',indexofSecondTab+1);
				indexofFourthTab 	= strLine1.indexOf('\t',indexofThirdTab+1);
				indexofFifthTab 	= strLine1.indexOf('\t',indexofFourthTab+1);
				indexofSixthTab 	= strLine1.indexOf('\t',indexofFifthTab+1);
				indexofSeventhTab	= strLine1.indexOf('\t',indexofSixthTab+1);
				indexofEigthTab 	= strLine1.indexOf('\t',indexofSeventhTab+1);
				indexofNinethTab 	= strLine1.indexOf('\t',indexofEigthTab+1);
				indexofTenthTab 	= strLine1.indexOf('\t',indexofNinethTab+1);
					
				tfName_keggPathwayName = strLine1.substring(0, indexofFirstTab);
				
				indexofFirstUnderscore = tfName_keggPathwayName.indexOf('_');
				keggPathwayName = tfName_keggPathwayName.substring(indexofFirstUnderscore+1,indexofFirstTab);
				
				
				//Pay attention to the order
				empiricalPValue = Float.parseFloat(strLine1.substring(indexofFifthTab+1, indexofSixthTab));
				bonfCorrectedPValue= Float.parseFloat(strLine1.substring(indexofSixthTab+1, indexofSeventhTab));
				bhFDRAdjustedPValue = Float.parseFloat(strLine1.substring(indexofSeventhTab+1, indexofEigthTab));
				
				keggPathwayDescription = strLine1.substring(indexofNinethTab+1, indexofTenthTab);
				
				if(multipleTestingParameter.equals(Commons.BENJAMINI_HOCHBERG_FDR_ADJUSTED_P_VALUE)){
					
					if (bhFDRAdjustedPValue <= FDR){					
						
						lines = enrichedKeggPathways.get(keggPathwayName + " " + keggPathwayDescription);
		
						if (lines==null){
							lines = new ArrayList<String>();
							lines.add(strLine1);
							enrichedKeggPathways.put(keggPathwayName+ " " +keggPathwayDescription, lines);
						}else{
							lines.add(strLine1);
						}			
					}
					
				}else if(multipleTestingParameter.equals(Commons.BONFERRONI_CORRECTED_P_VALUE)){
					
					if (bonfCorrectedPValue <= bonfCorrectionSignificanceLevel){					
						
						lines = enrichedKeggPathways.get(keggPathwayName + " " + keggPathwayDescription);
		
						if (lines==null){
							lines = new ArrayList<String>();
							lines.add(strLine1);
							enrichedKeggPathways.put(keggPathwayName+ " " +keggPathwayDescription, lines);
						}else{
							lines.add(strLine1);
						}			
					}
					
				}
								
					
			}//end of while : reading enriched tf and kegg Pathway file line by line.
			
			//for debug purposes start
			int numberofEnrichedTfExonBasedKeggPathwayElements = 0;
			//for debug purposes end
			
			for(Map.Entry<String,List<String>> entry: enrichedKeggPathways.entrySet()){
				keggPathwayNameandDescription = entry.getKey();
				lines = entry.getValue();
				
				numberofEnrichedTfExonBasedKeggPathwayElements += lines.size();
				
				bufferedWriter.write("**************\t" + keggPathwayNameandDescription + "\t**************" + System.getProperty("line.separator"));
							
				for(String strLine: lines){
					indexofFirstTab = strLine.indexOf('\t');
					tfName_keggPathwayName = strLine.substring(0,indexofFirstTab);
					
					if(Commons.TF_EXON_BASED_KEGG_PATHWAY.equals(type)){
						tfandKeggPathwayFileReader = new FileReader(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_EXON_BASED_KEGG_PATHWAY + "_" + tfName_keggPathwayName + ".txt");						
					}else if (Commons.TF_REGULATION_BASED_KEGG_PATHWAY.equals(type)){
						tfandKeggPathwayFileReader = new FileReader(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_REGULATION_BASED_KEGG_PATHWAY + "_" + tfName_keggPathwayName + ".txt");						
					}else if (Commons.TF_ALL_BASED_KEGG_PATHWAY.equals(type)){
						tfandKeggPathwayFileReader = new FileReader(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_ALL_BASED_KEGG_PATHWAY + "_" + tfName_keggPathwayName + ".txt");					
					}
					
					tfandKeggPathwayBufferedReader = new BufferedReader(tfandKeggPathwayFileReader);
							
					//Get all the lines of the original data annotation for the enriched Tf and KeggPathway 
					//Write them to the file
					while((strLine2 = tfandKeggPathwayBufferedReader.readLine())!=null){
						bufferedWriter.write(tfName_keggPathwayName + "\t" +strLine2 + System.getProperty("line.separator"));
					}
					
				}
			}//End of for	
			
			//for debug purposes start
			System.out.println("numberofEnrichedTfExonBasedKeggPathwayElements " + numberofEnrichedTfExonBasedKeggPathwayElements);
			//for debug purposes end
		
				
		
			bufferedReader.close();
			bufferedWriter.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Read the empiricalpvalues\\output\\ results
	//Augment it with annotate\\intervals\\parametric\\output results
	//Write augmented results
	//For Tf CellLine KeggPathway
	
	//ExampleLine
	//POL24H8_HCT116_hsa05020	0.00E+00	Prion diseases - Homo sapiens (human)	100506742, 10963, 1958, 2002, 2534, 3303, 3309, 3552, 3553, 3569, 3915, 4684, 4685, 4851, 5566, 5567, 5568, 5594, 5595, 5604, 5605, 5613, 5621, 581, 6352, 6647, 712, 713, 714, 727, 729, 730, 731, 732, 733, 735	CASP12, STIP1, EGR1, ELK1, FYN, HSPA1A, HSPA5, IL1A, IL1B, IL6, LAMC1, NCAM1, NCAM2, NOTCH1, PRKACA, PRKACB, PRKACG, MAPK1, MAPK3, MAP2K1, MAP2K2, PRKX, PRNP, BAX, CCL5, SOD1, C1QA, C1QB, C1QC, C5, C6, C7, C8A, C8B, C8G, C9
	public void readTfCellLineKeggPathwayFileAugmentandWrite(String outputFolder,String multipleTestingParameter,Float FDR, Float bonfCorrectionSignificanceLevel, String inputFileName, String outputFileName, String type){
		String strLine1;
		String strLine2;
		
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
		
		
		int indexofFirstUnderscore;
		int indexofSecondUnderscore;
		
		String tfName_cellLineName_keggPathwayName;
		String keggPathwayName;
		Float bonfCorrectedPValue; 
		Float empiricalPValue;
		Float bhFDRAdjustedPValue;
		String keggPathwayDescription;
		String keggPathwayNameandDescription;
		
		FileReader tfandKeggPathwayFileReader = null;
		BufferedReader tfandKeggPathwayBufferedReader;
		
		Map<String,List<String>> enrichedKeggPathways = new HashMap<String,List<String>>();
		List<String> lines;
		
		try {
			FileReader inputFileReader  = new FileReader(outputFolder + inputFileName);
			BufferedReader bufferedReader = new BufferedReader(inputFileReader);
			
			FileWriter outputFileWriter = FileOperations.createFileWriter(outputFolder + outputFileName);
			BufferedWriter bufferedWriter = new BufferedWriter(outputFileWriter);
			
			//Skip header line
			//Name	OriginalNumberofOverlaps	AccumulatedNumberofOverlaps	NumberofPermutations	NumberofComparisons	BonfCorrEmpiricalPValue	EmpiricalPValue
			strLine1= bufferedReader.readLine();
			
			while ((strLine1= bufferedReader.readLine())!=null ){
			
				//example line
				//AP2GAMMA_HELAS3_hsa00532	1	4	10000	109214	1E0	4E-4	Glycosaminoglycan biosynthesis - chondroitin sulfate / dermatan sulfate - Homo sapiens (human)	10090, 11285, 113189, 126792, 166012, 22856, 26229, 29940, 337876, 50515, 51363, 54480, 55454, 55501, 55790, 56548, 64131, 64132, 79586, 9469	UST, B4GALT7, CHST14, B3GALT6, CHST13, CHSY1, B3GAT3, DSE, CHSY3, CHST11, CHST15, CHPF2, CSGALNACT2, CHST12, CSGALNACT1, CHST7, XYLT1, XYLT2, CHPF, CHST3
				
//				new example line			
//				HEY1_K562_hsa05166	5	0	10000	109214	0.00E+00	0.00E+00	0.00E+00	TRUE

				indexofFirstTab = strLine1.indexOf('\t');
				indexofSecondTab = strLine1.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine1.indexOf('\t',indexofSecondTab+1);
				indexofFourthTab 	= strLine1.indexOf('\t',indexofThirdTab+1);
				indexofFifthTab 	= strLine1.indexOf('\t',indexofFourthTab+1);
				indexofSixthTab 	= strLine1.indexOf('\t',indexofFifthTab+1);
				indexofSeventhTab	= strLine1.indexOf('\t',indexofSixthTab+1);
				indexofEigthTab 	= strLine1.indexOf('\t',indexofSeventhTab+1);
				indexofNinethTab 	= strLine1.indexOf('\t',indexofEigthTab+1);
				indexofTenthTab 	= strLine1.indexOf('\t',indexofNinethTab+1);
				
				
				tfName_cellLineName_keggPathwayName = strLine1.substring(0, indexofFirstTab);
				
				indexofFirstUnderscore = tfName_cellLineName_keggPathwayName.indexOf('_');
				indexofSecondUnderscore = tfName_cellLineName_keggPathwayName.indexOf('_',indexofFirstUnderscore+1);
				keggPathwayName = tfName_cellLineName_keggPathwayName.substring(indexofSecondUnderscore+1,indexofFirstTab);
				
				//Pay attention order is important
				empiricalPValue = Float.parseFloat(strLine1.substring(indexofFifthTab+1, indexofSixthTab));
				bonfCorrectedPValue= Float.parseFloat(strLine1.substring(indexofSixthTab+1, indexofSeventhTab));
				bhFDRAdjustedPValue = Float.parseFloat(strLine1.substring(indexofSeventhTab+1, indexofEigthTab));
				
				keggPathwayDescription = strLine1.substring(indexofNinethTab+1, indexofTenthTab);
					
				if(multipleTestingParameter.equals(Commons.BENJAMINI_HOCHBERG_FDR_ADJUSTED_P_VALUE)){
					
					if (bhFDRAdjustedPValue <= FDR){					
						
						lines = enrichedKeggPathways.get(keggPathwayName + " " + keggPathwayDescription);
						
						if (lines==null){
							lines = new ArrayList<String>();
							lines.add(strLine1);
							enrichedKeggPathways.put(keggPathwayName+ " " +keggPathwayDescription, lines);
						}else{
							lines.add(strLine1);
						}
					}
					
				}else if(multipleTestingParameter.equals(Commons.BONFERRONI_CORRECTED_P_VALUE)){
					
					if (bonfCorrectedPValue <= bonfCorrectionSignificanceLevel){					
						
						lines = enrichedKeggPathways.get(keggPathwayName + " " + keggPathwayDescription);
						
						if (lines==null){
							lines = new ArrayList<String>();
							lines.add(strLine1);
							enrichedKeggPathways.put(keggPathwayName+ " " +keggPathwayDescription, lines);
						}else{
							lines.add(strLine1);
						}
					}
					
				}
					
			}//End of while : reading Tf CellLine KeggPathway input file line by line
			
			
			
			for(Map.Entry<String,List<String>> entry: enrichedKeggPathways.entrySet()){
				keggPathwayNameandDescription = entry.getKey();
				lines = entry.getValue();
				
				bufferedWriter.write("**************\t" + keggPathwayNameandDescription + "\t**************" + System.getProperty("line.separator"));
								
				for(String strLine: lines){
					indexofFirstTab = strLine.indexOf('\t');
					tfName_cellLineName_keggPathwayName = strLine.substring(0,indexofFirstTab);
					
					//Get the original data annotation results
					if(Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY.equals(type)){
						tfandKeggPathwayFileReader = new FileReader(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY + "_" + tfName_cellLineName_keggPathwayName + ".txt");
						
					}else if (Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY.equals(type)){
						tfandKeggPathwayFileReader = new FileReader(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY + "_" + tfName_cellLineName_keggPathwayName + ".txt");
						
					}else if (Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY.equals(type)){
						tfandKeggPathwayFileReader = new FileReader(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY + "_" + tfName_cellLineName_keggPathwayName + ".txt");
						
					}
					
					tfandKeggPathwayBufferedReader = new BufferedReader(tfandKeggPathwayFileReader);
					
					//Add the original data annotation results
					//Get all the lines of the original data annotation for the enriched Tf and KeggPathway 
					//Write them to the file
					while((strLine2 = tfandKeggPathwayBufferedReader.readLine())!=null){
						bufferedWriter.write(tfName_cellLineName_keggPathwayName + "\t" +strLine2 + System.getProperty("line.separator"));	
					}
					
				}
			}	
				
		
			bufferedReader.close();
			bufferedWriter.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void readandWriteFiles(String outputFolder,String multipleTestingParameter,Float FDR, Float bonfCorrectionSignificanceLevel,String dnaseEnrichment, String histoneEnrichment, String tfKeggPathwayEnrichment, String tfCellLineKeggPathwayEnrichment){
		String withRespectToFileName = null;
		
		if (multipleTestingParameter.equals(Commons.BENJAMINI_HOCHBERG_FDR_ADJUSTED_P_VALUE)){
			withRespectToFileName = Commons.ALL_WITH_RESPECT_TO_BH_FDR_ADJUSTED_P_VALUE;
		}else if (multipleTestingParameter.equals(Commons.BONFERRONI_CORRECTED_P_VALUE)){
			withRespectToFileName = Commons.ALL_WITH_RESPECT_TO_BONF_CORRECTED_P_VALUE;
			
		}
		
		 if (dnaseEnrichment.equals(Commons.DO_DNASE_ENRICHMENT)){
		 		readDnaseFileAugmentandWrite(outputFolder,multipleTestingParameter,FDR,bonfCorrectionSignificanceLevel,Commons.TO_BE_COLLECTED_DNASE_NUMBER_OF_OVERLAPS  + withRespectToFileName, Commons.AUGMENTED_DNASE_RESULTS);	
		 }
		 
		 if (histoneEnrichment.equals(Commons.DO_HISTONE_ENRICHMENT)){
		 		readHistoneFileAugmentandWrite(outputFolder,multipleTestingParameter,FDR,bonfCorrectionSignificanceLevel,Commons.TO_BE_COLLECTED_HISTONE_NUMBER_OF_OVERLAPS  + withRespectToFileName, Commons.AUGMENTED_HISTONE_RESULTS);	
		 }
		
	     if (tfKeggPathwayEnrichment.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT)){
	    	 
	 		readTfKeggPathwayFileAugmentandWrite(outputFolder,multipleTestingParameter,FDR,bonfCorrectionSignificanceLevel,Commons.TO_BE_COLLECTED_TF_EXON_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS  + withRespectToFileName, Commons.AUGMENTED_TF_EXON_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_EXON_BASED_KEGG_PATHWAY);
			readTfKeggPathwayFileAugmentandWrite(outputFolder,multipleTestingParameter,FDR,bonfCorrectionSignificanceLevel,Commons.TO_BE_COLLECTED_TF_REGULATION_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS + withRespectToFileName, Commons.AUGMENTED_TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_REGULATION_BASED_KEGG_PATHWAY);
			readTfKeggPathwayFileAugmentandWrite(outputFolder,multipleTestingParameter,FDR,bonfCorrectionSignificanceLevel,Commons.TO_BE_COLLECTED_TF_ALL_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS + withRespectToFileName, Commons.AUGMENTED_TF_ALL_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_ALL_BASED_KEGG_PATHWAY);
			
	     }
		
	     if (tfCellLineKeggPathwayEnrichment.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){

	    	readTfCellLineKeggPathwayFileAugmentandWrite(outputFolder,multipleTestingParameter,FDR,bonfCorrectionSignificanceLevel,Commons.TO_BE_COLLECTED_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS + withRespectToFileName, Commons.AUGMENTED_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY);
	    	readTfCellLineKeggPathwayFileAugmentandWrite(outputFolder,multipleTestingParameter,FDR,bonfCorrectionSignificanceLevel,Commons.TO_BE_COLLECTED_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS + withRespectToFileName, Commons.AUGMENTED_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY);
	    	readTfCellLineKeggPathwayFileAugmentandWrite(outputFolder,multipleTestingParameter,FDR,bonfCorrectionSignificanceLevel,Commons.TO_BE_COLLECTED_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS+ withRespectToFileName, Commons.AUGMENTED_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY);

	     }
	
	    
//		readTfKeggPathwayFileAugmentandWrite(Commons.TF_EXON_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION  + "_OCD_withGCMap_"  + "1"+ "Rep_" + "5000" + "Perm.txt", Commons.AUGMENTED_TF_EXON_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_EXON_BASED_KEGG_PATHWAY);
//		readTfKeggPathwayFileAugmentandWrite(Commons.TF_REGULATION_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION + "_OCD_withGCMap_"  + "1"+ "Rep_" + "5000" + "Perm.txt", Commons.AUGMENTED_TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_REGULATION_BASED_KEGG_PATHWAY);
//		readTfKeggPathwayFileAugmentandWrite(Commons.TF_ALL_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION  + "_OCD_withGCMap_"  + "1"+ "Rep_" + "5000" + "Perm.txt", Commons.AUGMENTED_TF_ALL_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_ALL_BASED_KEGG_PATHWAY);
//		
//		readTfCellLineKeggPathwayFileAugmentandWrite(Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR  + "_Level_" + level + "_HIV1_withGCMap_"  + "1"+ "Rep_" + "10000" + "Perm.txt", Commons.AUGMENTED_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY);
//		readTfCellLineKeggPathwayFileAugmentandWrite(Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR  + "_Level_" + level + "_HIV1_withGCMap_"  + "1"+ "Rep_" + "10000" + "Perm.txt", Commons.AUGMENTED_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY);
//		readTfCellLineKeggPathwayFileAugmentandWrite(Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR + "_Level_" + level  + "_HIV1_withGCMap_"  + "1"+ "Rep_" + "10000" + "Perm.txt", Commons.AUGMENTED_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS, Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY);

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
		
		String multipleTestingParameter = args[6];
		Float FDR = Float.parseFloat(args[8]);
		Float bonfCorrectionSignificanceLevel = Float.parseFloat(args[7]);

		String dnaseEnrichment = args[10];
		String histoneEnrichment  = args[11];
		String tfKeggPathwayEnrichment = args[14];
		String tfCellLineKeggPathwayEnrichment = args[15];
	
		AugmentationofEnrichedElementswithIntervals enrich = new AugmentationofEnrichedElementswithIntervals();
		
		enrich.readandWriteFiles(outputFolder,multipleTestingParameter,FDR, bonfCorrectionSignificanceLevel,dnaseEnrichment,histoneEnrichment,tfKeggPathwayEnrichment,tfCellLineKeggPathwayEnrichment);
		

	}

}
//