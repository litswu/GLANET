/**
 * @author Burcak Otlu
 *
 * 
 */

/*
 * This program searches for each given dnase, tfbs, histone and kegg pathway
 * and outputs the input lines which overlaps with that certain dnase, tfbs, histone and kegg pathway
 * 
 * SearchChromosomeIntervalsUsingIntervalTree.java outputs the overlapping dnase, tfbs, histone and ucscrefseq genes intervals
 * with the given input interval.
 * Therefore SearchChromosomeIntervalsUsingIntervalTree.java outputs
 * given interval versus overlapping dnase, tfbs, histone and ucscrefseq genes intervals.
 * 
 * AnnotateGivenIntervalsWithGivenParameters.java does the opposite.
 * AnnotateGivenIntervalsWithGivenParameters.java outputs
 * for each dnase, tfbs, histone, kegg pathway name
 * its corresponding overlapping input lines.
 * 
 * It has only one mode:
 * 
 * 1) Find all overlapping intervals
 * 
 * 
 * It counts the number of existence of each dnase cell line name , tfbs name, histone name and kegg pathway name.
 * It finds k out of n given search input lines.
 * 
 * For kegg pathway
 * it finds the exon based, regulation based and all based kegg pathway overlaps.
 * 
 */



package annotate.intervals.parametric;

import intervaltree.ChromosomeName;
import intervaltree.DnaseIntervalTreeNode;
import intervaltree.Interval;
import intervaltree.IntervalTree;
import intervaltree.IntervalTreeNode;
import intervaltree.NodeType;
import intervaltree.TforHistoneIntervalTreeNode;
import intervaltree.UcscRefSeqGeneIntervalTreeNode;

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

import keggpathway.ncbigenes.KeggPathwayUtility;
import auxiliary.FileOperations;

import common.Commons;

import create.ChromosomeBasedFilesandOperations;
import empiricalpvalues.AllMaps;
import empiricalpvalues.AllName2KMaps;
import empiricalpvalues.InputLine;


public class AnnotateGivenIntervalsWithGivenParameters {
	
	//Empirical P value Calculation
	//For Thread Version for 
	public void createChromBaseSeachInputFiles(String outputFolder,String permutationNumber, List<BufferedWriter> bufferedWriterList){
		try {
			FileWriter fileWriter1 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr1_input_file.txt");
			FileWriter fileWriter2 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr2_input_file.txt");
			FileWriter fileWriter3 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr3_input_file.txt");
			FileWriter fileWriter4 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr4_input_file.txt");
			FileWriter fileWriter5		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr5_input_file.txt");
			FileWriter fileWriter6 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr6_input_file.txt");
			FileWriter fileWriter7 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr7_input_file.txt");
			FileWriter fileWriter8 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr8_input_file.txt");
			FileWriter fileWriter9 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr9_input_file.txt");
			FileWriter fileWriter10 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr10_input_file.txt");
			FileWriter fileWriter11 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr11_input_file.txt");
			FileWriter fileWriter12 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr12_input_file.txt");
			FileWriter fileWriter13 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr13_input_file.txt");
			FileWriter fileWriter14 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr14_input_file.txt");
			FileWriter fileWriter15 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr15_input_file.txt");
			FileWriter fileWriter16 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr16_input_file.txt");
			FileWriter fileWriter17 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr17_input_file.txt");
			FileWriter fileWriter18 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr18_input_file.txt");
			FileWriter fileWriter19 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr19_input_file.txt");
			FileWriter fileWriter20		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr20_input_file.txt");
			FileWriter fileWriter21 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr21_input_file.txt");
			FileWriter fileWriter22 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr22_input_file.txt");
			FileWriter fileWriter23 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chrX_input_file.txt");
			FileWriter fileWriter24		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chrY_input_file.txt");
			
			BufferedWriter bufferedWriter1 	= new BufferedWriter(fileWriter1);
			BufferedWriter bufferedWriter2 	= new BufferedWriter(fileWriter2);
			BufferedWriter bufferedWriter3 	= new BufferedWriter(fileWriter3);
			BufferedWriter bufferedWriter4 	= new BufferedWriter(fileWriter4);
			BufferedWriter bufferedWriter5 	= new BufferedWriter(fileWriter5);
			BufferedWriter bufferedWriter6 	= new BufferedWriter(fileWriter6);
			BufferedWriter bufferedWriter7 	= new BufferedWriter(fileWriter7);
			BufferedWriter bufferedWriter8 	= new BufferedWriter(fileWriter8);
			BufferedWriter bufferedWriter9 	= new BufferedWriter(fileWriter9);
			BufferedWriter bufferedWriter10 = new BufferedWriter(fileWriter10);
			BufferedWriter bufferedWriter11 = new BufferedWriter(fileWriter11);
			BufferedWriter bufferedWriter12 = new BufferedWriter(fileWriter12);
			BufferedWriter bufferedWriter13 = new BufferedWriter(fileWriter13);
			BufferedWriter bufferedWriter14 = new BufferedWriter(fileWriter14);
			BufferedWriter bufferedWriter15 = new BufferedWriter(fileWriter15);
			BufferedWriter bufferedWriter16 = new BufferedWriter(fileWriter16);
			BufferedWriter bufferedWriter17 = new BufferedWriter(fileWriter17);
			BufferedWriter bufferedWriter18 = new BufferedWriter(fileWriter18);
			BufferedWriter bufferedWriter19 = new BufferedWriter(fileWriter19);
			BufferedWriter bufferedWriter20 = new BufferedWriter(fileWriter20);
			BufferedWriter bufferedWriter21 = new BufferedWriter(fileWriter21);
			BufferedWriter bufferedWriter22 = new BufferedWriter(fileWriter22);
			BufferedWriter bufferedWriter23 = new BufferedWriter(fileWriter23);
			BufferedWriter bufferedWriter24 = new BufferedWriter(fileWriter24);
			
			bufferedWriterList.add(bufferedWriter1);
			bufferedWriterList.add(bufferedWriter2);
			bufferedWriterList.add(bufferedWriter3);
			bufferedWriterList.add(bufferedWriter4);
			bufferedWriterList.add(bufferedWriter5);
			bufferedWriterList.add(bufferedWriter6);
			bufferedWriterList.add(bufferedWriter7);
			bufferedWriterList.add(bufferedWriter8);
			bufferedWriterList.add(bufferedWriter9);
			bufferedWriterList.add(bufferedWriter10);
			bufferedWriterList.add(bufferedWriter11);
			bufferedWriterList.add(bufferedWriter12);
			bufferedWriterList.add(bufferedWriter13);
			bufferedWriterList.add(bufferedWriter14);
			bufferedWriterList.add(bufferedWriter15);
			bufferedWriterList.add(bufferedWriter16);
			bufferedWriterList.add(bufferedWriter17);
			bufferedWriterList.add(bufferedWriter18);
			bufferedWriterList.add(bufferedWriter19);
			bufferedWriterList.add(bufferedWriter20);
			bufferedWriterList.add(bufferedWriter21);
			bufferedWriterList.add(bufferedWriter22);
			bufferedWriterList.add(bufferedWriter23);
			bufferedWriterList.add(bufferedWriter24);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void createChromBaseSeachInputFiles(String outputFolder,List<BufferedWriter> bufferedWriterList){
		try {
			FileWriter fileWriter1 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
			FileWriter fileWriter2 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
			FileWriter fileWriter3 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
			FileWriter fileWriter4 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
			FileWriter fileWriter5 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
			FileWriter fileWriter6 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
			FileWriter fileWriter7	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
			FileWriter fileWriter8 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
			FileWriter fileWriter9 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
			FileWriter fileWriter10 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
			FileWriter fileWriter11 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
			FileWriter fileWriter12 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
			FileWriter fileWriter13 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
			FileWriter fileWriter14 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
			FileWriter fileWriter15 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
			FileWriter fileWriter16 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
			FileWriter fileWriter17 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
			FileWriter fileWriter18 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
			FileWriter fileWriter19 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
			FileWriter fileWriter20 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
			FileWriter fileWriter21 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
			FileWriter fileWriter22 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
			FileWriter fileWriter23 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
			FileWriter fileWriter24 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
			
			BufferedWriter bufferedWriter1 	= new BufferedWriter(fileWriter1);
			BufferedWriter bufferedWriter2 	= new BufferedWriter(fileWriter2);
			BufferedWriter bufferedWriter3 	= new BufferedWriter(fileWriter3);
			BufferedWriter bufferedWriter4 	= new BufferedWriter(fileWriter4);
			BufferedWriter bufferedWriter5 	= new BufferedWriter(fileWriter5);
			BufferedWriter bufferedWriter6 	= new BufferedWriter(fileWriter6);
			BufferedWriter bufferedWriter7 	= new BufferedWriter(fileWriter7);
			BufferedWriter bufferedWriter8 	= new BufferedWriter(fileWriter8);
			BufferedWriter bufferedWriter9 	= new BufferedWriter(fileWriter9);
			BufferedWriter bufferedWriter10 = new BufferedWriter(fileWriter10);
			BufferedWriter bufferedWriter11 = new BufferedWriter(fileWriter11);
			BufferedWriter bufferedWriter12 = new BufferedWriter(fileWriter12);
			BufferedWriter bufferedWriter13 = new BufferedWriter(fileWriter13);
			BufferedWriter bufferedWriter14 = new BufferedWriter(fileWriter14);
			BufferedWriter bufferedWriter15 = new BufferedWriter(fileWriter15);
			BufferedWriter bufferedWriter16 = new BufferedWriter(fileWriter16);
			BufferedWriter bufferedWriter17 = new BufferedWriter(fileWriter17);
			BufferedWriter bufferedWriter18 = new BufferedWriter(fileWriter18);
			BufferedWriter bufferedWriter19 = new BufferedWriter(fileWriter19);
			BufferedWriter bufferedWriter20 = new BufferedWriter(fileWriter20);
			BufferedWriter bufferedWriter21 = new BufferedWriter(fileWriter21);
			BufferedWriter bufferedWriter22 = new BufferedWriter(fileWriter22);
			BufferedWriter bufferedWriter23 = new BufferedWriter(fileWriter23);
			BufferedWriter bufferedWriter24 = new BufferedWriter(fileWriter24);
			
			bufferedWriterList.add(bufferedWriter1);
			bufferedWriterList.add(bufferedWriter2);
			bufferedWriterList.add(bufferedWriter3);
			bufferedWriterList.add(bufferedWriter4);
			bufferedWriterList.add(bufferedWriter5);
			bufferedWriterList.add(bufferedWriter6);
			bufferedWriterList.add(bufferedWriter7);
			bufferedWriterList.add(bufferedWriter8);
			bufferedWriterList.add(bufferedWriter9);
			bufferedWriterList.add(bufferedWriter10);
			bufferedWriterList.add(bufferedWriter11);
			bufferedWriterList.add(bufferedWriter12);
			bufferedWriterList.add(bufferedWriter13);
			bufferedWriterList.add(bufferedWriter14);
			bufferedWriterList.add(bufferedWriter15);
			bufferedWriterList.add(bufferedWriter16);
			bufferedWriterList.add(bufferedWriter17);
			bufferedWriterList.add(bufferedWriter18);
			bufferedWriterList.add(bufferedWriter19);
			bufferedWriterList.add(bufferedWriter20);
			bufferedWriterList.add(bufferedWriter21);
			bufferedWriterList.add(bufferedWriter22);
			bufferedWriterList.add(bufferedWriter23);
			bufferedWriterList.add(bufferedWriter24);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void writeChromBaseSearchInputFile(ChromosomeName chromName, String strLine, List<BufferedWriter> bufList){
		try {
			
			if (chromName.equals(ChromosomeName.CHROMOSOME1)){
				bufList.get(0).write(strLine + System.getProperty("line.separator"));
				bufList.get(0).flush();		
			} else 	if (chromName.equals(ChromosomeName.CHROMOSOME2)){
				bufList.get(1).write(strLine + System.getProperty("line.separator"));
				bufList.get(1).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME3)){
				bufList.get(2).write(strLine + System.getProperty("line.separator"));
				bufList.get(2).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME4)){
				bufList.get(3).write(strLine + System.getProperty("line.separator"));
				bufList.get(3).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME5)){
				bufList.get(4).write(strLine + System.getProperty("line.separator"));
				bufList.get(4).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME6)){
				bufList.get(5).write(strLine + System.getProperty("line.separator"));
				bufList.get(5).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME7)){
				bufList.get(6).write(strLine + System.getProperty("line.separator"));
				bufList.get(6).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME8)){
				bufList.get(7).write(strLine + System.getProperty("line.separator"));
				bufList.get(7).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME9)){
				bufList.get(8).write(strLine + System.getProperty("line.separator"));
				bufList.get(8).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME10)){
				bufList.get(9).write(strLine + System.getProperty("line.separator"));
				bufList.get(9).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME11)){
				bufList.get(10).write(strLine + System.getProperty("line.separator"));
				bufList.get(10).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME12)){
				bufList.get(11).write(strLine + System.getProperty("line.separator"));
				bufList.get(11).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME13)){
				bufList.get(12).write(strLine + System.getProperty("line.separator"));
				bufList.get(12).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME14)){
				bufList.get(13).write(strLine + System.getProperty("line.separator"));
				bufList.get(13).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME15)){
				bufList.get(14).write(strLine + System.getProperty("line.separator"));
				bufList.get(14).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME16)){
				bufList.get(15).write(strLine + System.getProperty("line.separator"));
				bufList.get(15).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME17)){
				bufList.get(16).write(strLine + System.getProperty("line.separator"));
				bufList.get(16).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME18)){
				bufList.get(17).write(strLine + System.getProperty("line.separator"));
				bufList.get(17).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME19)){
				bufList.get(18).write(strLine + System.getProperty("line.separator"));
				bufList.get(18).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME20)){
				bufList.get(19).write(strLine + System.getProperty("line.separator"));
				bufList.get(19).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME21)){
				bufList.get(20).write(strLine + System.getProperty("line.separator"));
				bufList.get(20).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME22)){
				bufList.get(21).write(strLine + System.getProperty("line.separator"));
				bufList.get(21).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOMEX)){
				bufList.get(22).write(strLine + System.getProperty("line.separator"));
				bufList.get(22).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOMEY)){
				bufList.get(23).write(strLine + System.getProperty("line.separator"));
				bufList.get(23).flush();		
			}else{
				System.out.println("Unknown chromosome");
			}

		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void partitionSearchInputFilePerChromName(String inputFileName, List<BufferedWriter> bufferedWriterList){
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		String strLine;
		int indexofFirstTab;
		ChromosomeName chromName;
		
		try {
			fileReader = new FileReader(inputFileName);
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine=bufferedReader.readLine())!=null){
				
				indexofFirstTab = strLine.indexOf('\t');
				chromName = ChromosomeName.convertStringtoEnum(strLine.substring(0,indexofFirstTab));
				writeChromBaseSearchInputFile(chromName,strLine,bufferedWriterList);
				
			} // End of While
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
	
	
	//Empirical P value Computation
	public void partitionSearchInputFilePerChromName(List<InputLine> inputLines, List<BufferedWriter> bufferedWriterList){
		
		String strLine;
		
		ChromosomeName chrName;
		int low;
		int high;
		
		InputLine inputLine;
			
			for(int i = 0; i<inputLines.size(); i++){
				
				inputLine = inputLines.get(i);
				
				chrName = inputLine.getChrName();
				low = inputLine.getLow();
				high = inputLine.getHigh();
				
				strLine = chrName + "\t" + low + "\t" + high;
				
				writeChromBaseSearchInputFile(chrName,strLine,bufferedWriterList);
				
			} // End of While
		
						
	}
	
	//Empirical P Value Calculation
	public static IntervalTree generateEncodeDnaseIntervalTree(BufferedReader bufferedReader) {
		IntervalTree dnaseIntervalTree = new IntervalTree();
		String strLine = null;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		
		int startPosition = 0;
		int endPosition = 0;
		
		String chromName;
		String cellLineName;
		String fileName;
		
		
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
//				example strLine
//				chr1	91852781	91853156	GM12878	idrPool.GM12878-DS9432-DS10671.z_OV_GM12878-DS10671.z_VS_GM12878-DS9432.z.npk2.narrowPeak

				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
					
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				cellLineName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
								
				fileName = strLine.substring(indexofFourthTab+1);
				
				//important note
				//while constructing the dnaseIntervalTree
				//we don't check for overlaps
				//we insert any given interval without overlap check
				
//				Creating millions of nodes with six attributes causes out of memory error
				IntervalTreeNode node = new DnaseIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,cellLineName,fileName,NodeType.ORIGINAL);
				dnaseIntervalTree.intervalTreeInsert(dnaseIntervalTree, node);						
			
				chromName = null;
				cellLineName = null;
				fileName = null;				
				strLine = null;
				
			} // End of While 
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dnaseIntervalTree;
	}

	
	public IntervalTree generateEncodeDnaseIntervalTree(BufferedReader bufferedReader, List<String> dnaseCellLineNameList) {
		IntervalTree dnaseIntervalTree = new IntervalTree();
		String strLine = null;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		
		int startPosition = 0;
		int endPosition = 0;
		
		String chromName;
		String cellLineName;
		String fileName;
		
		
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
//				example strLine
//				chr1	91852781	91853156	GM12878	idrPool.GM12878-DS9432-DS10671.z_OV_GM12878-DS10671.z_VS_GM12878-DS9432.z.npk2.narrowPeak

				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
					
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				cellLineName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
								
				fileName = strLine.substring(indexofFourthTab+1);
				
				//important note
				//while constructing the dnaseIntervalTree
				//we don't check for overlaps
				//we insert any given interval without overlap check
				
//				if dnase exists in dnaseList 
				if (dnaseCellLineNameList.contains(cellLineName)){
//					Creating millions of nodes with six attributes causes out of memory error
					IntervalTreeNode node = new DnaseIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,cellLineName,fileName,NodeType.ORIGINAL);
					dnaseIntervalTree.intervalTreeInsert(dnaseIntervalTree, node);						
				} //End of If	
				
				chromName = null;
				cellLineName = null;
				fileName = null;				
				strLine = null;
				
			} // End of While 
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dnaseIntervalTree;
	}
	
	//Empirical P Value Calculation
	public static IntervalTree generateEncodeTfbsIntervalTree(BufferedReader bufferedReader){
		IntervalTree tfbsIntervalTree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		int indexofFifthTab = 0;
		
		int startPosition = 0;
		int endPosition = 0;
		
		String chromName;
		String tfbsName;
		String cellLineName;
		String fileName;
		
	  
	    
		try {
			while((strLine = bufferedReader.readLine())!=null){
//				exampple strLine
//				chrY	2804079	2804213	Ctcf	H1hesc	spp.optimal.wgEncodeBroadHistoneH1hescCtcfStdAlnRep0_VS_wgEncodeBroadHistoneH1hescControlStdAlnRep0.narrowPeak
			
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab = strLine.indexOf('\t', indexofFourthTab+1);
					
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				tfbsName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
				
				cellLineName = strLine.substring(indexofFourthTab+1, indexofFifthTab);
				
				fileName = strLine.substring(indexofFifthTab+1);

//				Creating millions of nodes with six attributes causes out of memory error
				IntervalTreeNode node = new TforHistoneIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,tfbsName,cellLineName,fileName,NodeType.ORIGINAL);
				tfbsIntervalTree.intervalTreeInsert(tfbsIntervalTree, node);					
				
				chromName = null;
				tfbsName = null;
				cellLineName = null;
				fileName = null;
				strLine = null;
								
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tfbsIntervalTree;
	}

	
	public IntervalTree generateEncodeTfbsIntervalTree(BufferedReader bufferedReader, List<String> tfbsNameList){
		IntervalTree tfbsIntervalTree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		int indexofFifthTab = 0;
		
		int startPosition = 0;
		int endPosition = 0;
		
		String chromName;
		String tfbsName;
		String cellLineName;
		String fileName;
		
	  
	    
		try {
			while((strLine = bufferedReader.readLine())!=null){
//				example strLine
//				chrY	2804079	2804213	Ctcf	H1hesc	spp.optimal.wgEncodeBroadHistoneH1hescCtcfStdAlnRep0_VS_wgEncodeBroadHistoneH1hescControlStdAlnRep0.narrowPeak
			
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab = strLine.indexOf('\t', indexofFourthTab+1);
					
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				tfbsName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
				
				cellLineName = strLine.substring(indexofFourthTab+1, indexofFifthTab);
				
				fileName = strLine.substring(indexofFifthTab+1);

//				if tfbs exists in tfbsList 
				if (tfbsNameList.contains(tfbsName)){
//					Creating millions of nodes with six attributes causes out of memory error
					IntervalTreeNode node = new TforHistoneIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,tfbsName,cellLineName,fileName,NodeType.ORIGINAL);
					tfbsIntervalTree.intervalTreeInsert(tfbsIntervalTree, node);					
				}
				
				chromName = null;
				tfbsName = null;
				cellLineName = null;
				fileName = null;
				strLine = null;
								
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tfbsIntervalTree;
	}
	
	//Empirical P Value Calculation
	public static IntervalTree generateEncodeHistoneIntervalTree(BufferedReader bufferedReader) {
		IntervalTree histoneIntervalTree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		int indexofFifthTab = 0;
				
		String chromName;
		int startPosition = 0;
		int endPosition = 0;
		
		String histoneName;
		String cellLineName;
		String fileName;
		
	
		try {
			while((strLine = bufferedReader.readLine())!=null){
//				example strLine
//				chr9	131533188	131535395	H2az	Gm12878	wgEncodeBroadHistoneGm12878H2azStdAln.narrowPeak

				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab = strLine.indexOf('\t', indexofFourthTab+1);
					
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				
				histoneName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
				
				cellLineName = strLine.substring(indexofFourthTab+1, indexofFifthTab);
				
				fileName = strLine.substring(indexofFifthTab+1);
				
//				Creating millions of nodes with six attributes causes out of memory error
				IntervalTreeNode node = new TforHistoneIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,histoneName,cellLineName,fileName,NodeType.ORIGINAL);
				histoneIntervalTree.intervalTreeInsert(histoneIntervalTree, node);				
				
				chromName = null;
				histoneName  = null;
				cellLineName = null;
				fileName = null;
				strLine = null;
								
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return histoneIntervalTree;
	}


	public IntervalTree generateEncodeHistoneIntervalTree(BufferedReader bufferedReader, List<String> histoneNameList) {
		IntervalTree histoneIntervalTree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		int indexofFifthTab = 0;
				
		String chromName;
		int startPosition = 0;
		int endPosition = 0;
		
		String histoneName;
		String cellLineName;
		String fileName;
		
	
		try {
			while((strLine = bufferedReader.readLine())!=null){
//				example strLine
//				chr9	131533188	131535395	H2az	Gm12878	wgEncodeBroadHistoneGm12878H2azStdAln.narrowPeak

				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab = strLine.indexOf('\t', indexofFourthTab+1);
					
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				
				histoneName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
				
				cellLineName = strLine.substring(indexofFourthTab+1, indexofFifthTab);
				
				fileName = strLine.substring(indexofFifthTab+1);
				
				if (histoneNameList.contains(histoneName)){
//					Creating millions of nodes with six attributes causes out of memory error
					IntervalTreeNode node = new TforHistoneIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,histoneName,cellLineName,fileName,NodeType.ORIGINAL);
					histoneIntervalTree.intervalTreeInsert(histoneIntervalTree, node);				
				}
				
				chromName = null;
				histoneName  = null;
				cellLineName = null;
				fileName = null;
				strLine = null;
								
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return histoneIntervalTree;
	}

	public static IntervalTree generateUcscRefSeqGenesIntervalTree(BufferedReader bufferedReader){
		IntervalTree tree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		int indexofFifthTab = 0;
		int indexofSixthTab = 0;
		int indexofSeventhTab = 0;
		
		int startPosition = 0;
		int endPosition = 0;
		
		String chromName;
		String  refSeqGeneName;
		Integer geneEntrezId;
		String intervalName;
		String geneHugoSymbol;		
		
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
//				example strLine
//				chr17	67074846	67075215	NM_080284	23460	Exon1	-	ABCA6

				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab = strLine.indexOf('\t', indexofFourthTab+1);
				indexofSixthTab = strLine.indexOf('\t', indexofFifthTab+1);
				indexofSeventhTab = strLine.indexOf('\t',indexofSixthTab+1);	
				
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				refSeqGeneName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
				
				geneEntrezId = Integer.parseInt(strLine.substring(indexofFourthTab+1, indexofFifthTab));
				
				intervalName = strLine.substring(indexofFifthTab+1, indexofSixthTab);
				
				geneHugoSymbol = strLine.substring(indexofSeventhTab+1);
				
//				Creating millions of nodes with seven attributes causes out of memory error
				IntervalTreeNode node = new UcscRefSeqGeneIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,refSeqGeneName,geneEntrezId,intervalName,geneHugoSymbol,NodeType.ORIGINAL);
				tree.intervalTreeInsert(tree, node);
				
				chromName = null;
				refSeqGeneName = null;
				geneEntrezId = null;
				intervalName = null;
				geneHugoSymbol = null;
				strLine = null;
			}// end of While
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return tree;
	}

	
	//Empirical P Value Calculation
	public static IntervalTree createDnaseIntervalTree(String dataFolder,ChromosomeName chromName){
		IntervalTree  dnaseIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (ChromosomeName.CHROMOSOME1.equals(chromName)){
					fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR1_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR2_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR3_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR4_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR5_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR6_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR7_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR8_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR9_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR10_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR11_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR12_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR13_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR14_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR15_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR16_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR17_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR18_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR19_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR20_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR21_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR22_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHRX_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHRY_DNASE_FILENAME);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			dnaseIntervalTree = generateEncodeDnaseIntervalTree(bufferedReader);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dnaseIntervalTree;
	}

	
	public IntervalTree createDnaseIntervalTree(String outputFolder, String chromName, List<String> dnaseCellLineNameList){
		IntervalTree  dnaseIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (Commons.CHROMOSOME1.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR1_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR2_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR3_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR4_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR5_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR6_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR7_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR8_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR9_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR10_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR11_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR12_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR13_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR14_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR15_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR16_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR17_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR18_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR19_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR20_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR21_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR22_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHRX_DNASE_FILENAME);				
			} else if (Commons.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHRY_DNASE_FILENAME);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			dnaseIntervalTree = generateEncodeDnaseIntervalTree(bufferedReader,dnaseCellLineNameList);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dnaseIntervalTree;
	}

	//Empirical P Value Calculation
	public static IntervalTree createTfbsIntervalTree(String dataFolder,ChromosomeName chromName){
		IntervalTree  tfbsIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (ChromosomeName.CHROMOSOME1.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR1_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR2_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR3_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR4_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR5_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR6_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR7_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR8_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR9_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR10_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR11_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR12_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR13_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR14_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR15_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR16_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR17_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR18_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR19_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR20_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR21_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR22_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHRX_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHRY_TFBS_FILENAME);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			tfbsIntervalTree = generateEncodeTfbsIntervalTree(bufferedReader);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return tfbsIntervalTree;	
	}

	
	public IntervalTree createTfbsIntervalTree(String outputFolder,ChromosomeName chromName, List<String> tfbsNameList){
		IntervalTree  tfbsIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (ChromosomeName.CHROMOSOME1.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR1_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR2_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR3_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR4_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR5_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR6_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR7_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR8_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR9_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR10_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR11_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR12_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR13_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR14_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR15_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR16_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR17_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR18_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR19_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR20_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR21_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR22_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHRX_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHRY_TFBS_FILENAME);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			tfbsIntervalTree = generateEncodeTfbsIntervalTree(bufferedReader,tfbsNameList);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return tfbsIntervalTree;	
	}

	// Empirical P Value Calculation
	public static IntervalTree createHistoneIntervalTree(String dataFolder,ChromosomeName chromName){
		IntervalTree  histoneIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (ChromosomeName.CHROMOSOME1.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR1_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR2_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR3_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR4_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR5_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR6_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR7_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR8_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR9_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR10_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR11_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR12_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR13_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR14_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR15_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR16_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR17_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR18_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR19_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR20_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR21_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR22_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHRX_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHRY_HISTONE_FILENAME);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			histoneIntervalTree = generateEncodeHistoneIntervalTree(bufferedReader);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return histoneIntervalTree;	
	}
	
	public IntervalTree createHistoneIntervalTree(String outputFolder, String chromName,List<String> histoneNameList){
		IntervalTree  histoneIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (Commons.CHROMOSOME1.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR1_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR2_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR3_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR4_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR5_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR6_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR7_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR8_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR9_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR10_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR11_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR12_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR13_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR14_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR15_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR16_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR17_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR18_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR19_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR20_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR21_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR22_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHRX_HISTONE_FILENAME);				
			} else if (Commons.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHRY_HISTONE_FILENAME);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			histoneIntervalTree = generateEncodeHistoneIntervalTree(bufferedReader,histoneNameList);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return histoneIntervalTree;	
	}
	
	public static IntervalTree createUcscRefSeqGenesIntervalTree(String dataFolder,ChromosomeName chromName){
		IntervalTree  ucscRefSeqGenesIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		fileReader = ChromosomeBasedFilesandOperations.getUnsortedRefSeqGenesFileReader(dataFolder,chromName);
		
		bufferedReader = new BufferedReader(fileReader);
		ucscRefSeqGenesIntervalTree = generateUcscRefSeqGenesIntervalTree(bufferedReader);
		
		return ucscRefSeqGenesIntervalTree;	
	
	}

	

	//Empirical P Value Calculation
	//with IO
	public static void searchDnase(String outputFolder,int permutationNumber,ChromosomeName chromName,List<InputLine> inputLines, IntervalTree dnaseIntervalTree, Map<String,BufferedWriter> dnaseBufferedWriterHashMap,Map<String,Integer> permutationNumberDnaseCellLineName2KMap,int overlapDefinition){
		InputLine inputLine;		
		int low;
		int high;
		
		for(int i= 0; i<inputLines.size(); i++){
			Map<String,Integer> permutationNumberDnaseCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
			
			inputLine = inputLines.get(i);
			low = inputLine.getLow();
			high = inputLine.getHigh();
													
			Interval interval = new Interval(low,high);
			
			if(dnaseIntervalTree.getRoot().getNodeName().isNotSentinel()){
				dnaseIntervalTree.findAllOverlappingDnaseIntervals(outputFolder,permutationNumber,dnaseIntervalTree.getRoot(),interval,chromName, dnaseBufferedWriterHashMap, permutationNumberDnaseCellLineName2ZeroorOneMap,overlapDefinition);	
			}
			
			//accumulate search results of dnaseCellLine2OneorZeroMap in permutationNumberDnaseCellLineName2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberDnaseCellLineName2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberDnaseCellLineName2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberDnaseCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberDnaseCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberDnaseCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}

			}//End of for
			
			interval = null;
			
		}//End of for
	}


	
	//Empirical P Value Calculation
	//without IO
	public static void searchDnasewithoutIO(int permutationNumber,ChromosomeName chromName,List<InputLine> inputLines, IntervalTree dnaseIntervalTree,Map<String,Integer> permutationNumberDnaseCellLineName2KMap,int overlapDefinition){
		InputLine inputLine;		
		int low;
		int high;
		
//		//Keeps the overlapping node list for the current query
//		List<IntervalTreeNode> overlappingNodeList = new ArrayList<IntervalTreeNode>();
//		//Keeps the latest non empty overlapping node list for the previous queries
//		List<IntervalTreeNode> previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>();
//		//Keeps the left most node 
//		IntervalTreeNode previousLeftMostNode = new IntervalTreeNode();
//		
//		IntervalTreeNode newSearchStartingNode= dnaseIntervalTree.getRoot();
				
			
		
		for(int i= 0; i<inputLines.size(); i++){
			Map<String,Integer> permutationNumberDnaseCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
			
			inputLine = inputLines.get(i);
			low = inputLine.getLow();
			high = inputLine.getHigh();
													
			Interval interval = new Interval(low,high);
			
//			//Empty the overlapping node list for the new query
//			overlappingNodeList.clear();	
//			
//			if (previousLeftMostNode.isNotSentinel()){
//			
//				//Go up in the interval tree for the new query
//				newSearchStartingNode = IntervalTree.findMostGeneralSearchStaringNodeforNewQuery(interval,previousLeftMostNode);
//				
//				//Go down in the interval tree for the new query 
//				newSearchStartingNode = IntervalTree.findMostSpecificSearchStaringNodeforNewQuery(interval,newSearchStartingNode);	
//			}
//			
//			
//			
//			//If sentinel means that there is no need to search for this new query
//			if(newSearchStartingNode.isNotSentinel()){
//				dnaseIntervalTree.findAllOverlappingDnaseIntervals(repeatNumber,permutationNumber,NUMBER_OF_PERMUTATIONS,newSearchStartingNode,interval,chromName, permutationNumberDnaseCellLineName2ZeroorOneMap,overlappingNodeList);							
//			}			
//			
//			if(!overlappingNodeList.isEmpty()){
//				previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>(overlappingNodeList);
//				previousLeftMostNode = IntervalTree.findLeftMostNodefromPreviousQuery(previousNonEmptyOverlappingNodeList);			
//			}			

			if(dnaseIntervalTree.getRoot().getNodeName().isNotSentinel()){
				dnaseIntervalTree.findAllOverlappingDnaseIntervals(permutationNumber,dnaseIntervalTree.getRoot(),interval,chromName, permutationNumberDnaseCellLineName2ZeroorOneMap,overlapDefinition);				
			}
			
			//accumulate search results of dnaseCellLine2OneorZeroMap in permutationNumberDnaseCellLineName2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberDnaseCellLineName2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberDnaseCellLineName2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberDnaseCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberDnaseCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberDnaseCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}

			}//End of for
			
			interval = null;
			
		}//End of for
	}
	
	public void searchDnase(String outputFolder,String chromName,BufferedReader bufferedReader, IntervalTree dnaseIntervalTree, Map<String,BufferedWriter> dnaseBufferedWriterHashMap,List<String> dnaseCellLineNameList,Map<String,Integer> dnaseCellLine2KMap,int overlapDefinition){
		
		
		String strLine = null;
		int indexofFirstTab = 0 ;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				Map<String,Integer> dnaseCellLine2OneorZeroMap = new HashMap<String,Integer>();
				
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//				indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
							
				Interval interval = new Interval(low,high);

				
				if(dnaseIntervalTree.getRoot().getNodeName().isNotSentinel()){
					dnaseIntervalTree.findAllOverlappingDnaseIntervals(outputFolder,dnaseIntervalTree.getRoot(),interval,chromName, dnaseBufferedWriterHashMap,dnaseCellLineNameList, dnaseCellLine2OneorZeroMap,overlapDefinition);
				}
					
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				for(Map.Entry<String, Integer> zeroOrOne: dnaseCellLine2OneorZeroMap.entrySet()){
					 
					if (dnaseCellLine2KMap.get(zeroOrOne.getKey())==null){
						dnaseCellLine2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						dnaseCellLine2KMap.put(zeroOrOne.getKey(), dnaseCellLine2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				
			
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // End of while 
			
	}

	//Empirical P Value Calculation
	//with IO
	public static void searchTfbs(String outputFolder,int permutationNumber,ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfbsIntervalTree, Map<String,BufferedWriter> tfbsBufferedWriterHashMap, Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap,int overlapDefinition){
		
		InputLine inputLine;
		int low;
		int high;
		
		for(int i= 0; i<inputLines.size(); i++){
			Map<String,Integer> permutationNumberTfbsNameCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
		
			inputLine = inputLines.get(i);
			
			low = inputLine.getLow();
			high = inputLine.getHigh();
			Interval interval = new Interval(low,high);
			
			if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
				tfbsIntervalTree.findAllOverlappingTfbsIntervals(outputFolder,permutationNumber,tfbsIntervalTree.getRoot(),interval,chromName,tfbsBufferedWriterHashMap,permutationNumberTfbsNameCellLineName2ZeroorOneMap,overlapDefinition);
			}
			
			//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberTfbsNameCellLineName2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberTfbsNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberTfbsNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberTfbsNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberTfbsNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
					
				}

			}//End of for
		}//End of for
	}

	//Empirical P Value Calculation
	//without IO
	public static void searchTfbswithoutIO(int permutationNumber,ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfbsIntervalTree, Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap,int overlapDefinition){
		
		InputLine inputLine;
		int low;
		int high;
		
//		//Keeps the overlapping node list for the current query
//		List<IntervalTreeNode> overlappingNodeList = new ArrayList<IntervalTreeNode>();
//		//Keeps the latest non empty overlapping node list for the previous queries
//		List<IntervalTreeNode> previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>();
//		//Keeps the left most node 
//		IntervalTreeNode previousLeftMostNode = new IntervalTreeNode();
//		
//		IntervalTreeNode newSearchStartingNode= tfbsIntervalTree.getRoot();
	
		for(int i= 0; i<inputLines.size(); i++){
			Map<String,Integer> permutationNumberTfbsNameCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
		
			inputLine = inputLines.get(i);
			
			low = inputLine.getLow();
			high = inputLine.getHigh();
			Interval interval = new Interval(low,high);
			
//			//Empty the overlapping node list for the new query
//			overlappingNodeList.clear();	
//			
//			if (previousLeftMostNode.isNotSentinel()){
//			
//				//Go up in the interval tree for the new query
//				newSearchStartingNode = IntervalTree.findMostGeneralSearchStaringNodeforNewQuery(interval,previousLeftMostNode);
//				
//				//Go down in the interval tree for the new query 
//				newSearchStartingNode = IntervalTree.findMostSpecificSearchStaringNodeforNewQuery(interval,newSearchStartingNode);	
//			}
//			
//			
//			
//			//If sentinel means that there is no need to search for this new query
//			if(newSearchStartingNode.isNotSentinel()){
//				tfbsIntervalTree.findAllOverlappingTfbsIntervals(repeatNumber,permutationNumber,NUMBER_OF_PERMUTATIONS,newSearchStartingNode,interval,chromName,permutationNumberTfbsNameCellLineName2ZeroorOneMap,overlappingNodeList);
//			}			
//			
//			if(!overlappingNodeList.isEmpty()){
//				previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>(overlappingNodeList);
//				previousLeftMostNode = IntervalTree.findLeftMostNodefromPreviousQuery(previousNonEmptyOverlappingNodeList);			
//			}

			
			if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
				tfbsIntervalTree.findAllOverlappingTfbsIntervals(permutationNumber,tfbsIntervalTree.getRoot(),interval,chromName,permutationNumberTfbsNameCellLineName2ZeroorOneMap,overlapDefinition);
			}
			
			//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberTfbsNameCellLineName2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberTfbsNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberTfbsNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberTfbsNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberTfbsNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
					
				}

			}//End of for
		}//End of for
	}

	public void searchTfbs(String chromName, BufferedReader bufferedReader, IntervalTree tfbsIntervalTree, Map<String,BufferedWriter> tfbsBufferedWriterHashMap, List<String> tfbsNameList, Map<String,Integer> tfbsNameandCellLineName2KMap){
		String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				
				Map<String,Integer> tfbsNameandCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
				
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//				indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);
				
				if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
					tfbsIntervalTree.findAllOverlappingTfbsIntervals(tfbsIntervalTree.getRoot(),interval,chromName,tfbsBufferedWriterHashMap,tfbsNameList,tfbsNameandCellLineName2ZeroorOneMap);	
				}
				
				//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
				for(Map.Entry<String, Integer> zeroOrOne: tfbsNameandCellLineName2ZeroorOneMap.entrySet()){
					 
					if (tfbsNameandCellLineName2KMap.get(zeroOrOne.getKey())==null){
						tfbsNameandCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						tfbsNameandCellLineName2KMap.put(zeroOrOne.getKey(), tfbsNameandCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 
	}
	
	//New Functionality
	//TF and Kegg Pathway
	//TF and CellLine and KeggPathway
	public void searchTfandKeggPathway(String outputFolder,String chromName, BufferedReader bufferedReader, IntervalTree tfbsIntervalTree,IntervalTree ucscRefSeqGenesIntervalTree,Map<String,BufferedWriter>  tfbsBufferedWriterHashMap, Map<String,BufferedWriter>  exonBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter>  regulationBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter>  allBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,List<String> tfNameList,List<String> keggPathwayNameList,Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> tfbsNameandCellLineName2KMap, Map<String,Integer> exonBasedKeggPathway2KMap, Map<String,Integer> regulationBasedKeggPathway2KMap, Map<String,Integer> allBasedKeggPathway2KMap, Map<String,Integer> tfCellLineExonBasedKeggPathway2KMap, Map<String,Integer> tfCellLineRegulationBasedKeggPathway2KMap, Map<String,Integer> tfCellLineAllBasedKeggPathway2KMap,Map<String,Integer> tfExonBasedKeggPathway2KMap, Map<String,Integer> tfRegulationBasedKeggPathway2KMap, Map<String,Integer> tfAllBasedKeggPathway2KMap,int overlapDefinition){
			String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
			
		FileWriter fileWriter1 = null;
		FileWriter fileWriter2 = null;
		BufferedWriter bufferedWriter1 = null;
		BufferedWriter bufferedWriter2 = null;
		
		
		String tfName= null;
		String tfNameCellLineName= null;
		String tfNameCellLineNameKeggPathwayName = null;
		String tfNameKeggPathwayName = null;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				
				Map<String,Integer> tfbsNameandCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
				Map<String,Integer> exonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				Map<String,Integer> regulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				Map<String,Integer> allBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				
				//will be filled here
				Map<String,Integer> tfCellLineExonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				Map<String,Integer> tfCellLineRegulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				Map<String,Integer> tfCellLineAllBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				
				//new
				//will be filled here
				Map<String,Integer> tfExonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				Map<String,Integer> tfRegulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				Map<String,Integer> tfAllBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				
				//Fill these lists during search for tfs and search for ucscRefSeqGenes
				List<TfNameandCellLineNameOverlap> tfandCellLineOverlapList = new ArrayList<TfNameandCellLineNameOverlap>();
				List<UcscRefSeqGeneOverlap> exonBasedKeggPathwayOverlapList = new ArrayList<UcscRefSeqGeneOverlap>();
				List<UcscRefSeqGeneOverlap> regulationBasedKeggPathwayOverlapList = new ArrayList<UcscRefSeqGeneOverlap>();
				List<UcscRefSeqGeneOverlap> allBasedKeggPathwayOverlapList = new ArrayList<UcscRefSeqGeneOverlap>();
					
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//				indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);
				
				//TF Search starts here					
				if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
					tfbsIntervalTree.findAllOverlappingTfbsIntervals(outputFolder,tfbsIntervalTree.getRoot(),interval,chromName,tfbsBufferedWriterHashMap,tfNameList,tfbsNameandCellLineName2ZeroorOneMap,tfandCellLineOverlapList,overlapDefinition);	
				}
				
				//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
				for(Map.Entry<String, Integer> zeroOrOne: tfbsNameandCellLineName2ZeroorOneMap.entrySet()){
					 
					if (tfbsNameandCellLineName2KMap.get(zeroOrOne.getKey())==null){
						tfbsNameandCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						tfbsNameandCellLineName2KMap.put(zeroOrOne.getKey(), tfbsNameandCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				//TF Search ends here					
				
				//UCSCRefSeqGenes Search starts here
				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(outputFolder,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, keggPathwayNameList,exonBasedKeggPathway2OneorZeroMap,regulationBasedKeggPathway2OneorZeroMap,allBasedKeggPathway2OneorZeroMap,Commons.NCBI_GENE_ID,exonBasedKeggPathwayOverlapList,regulationBasedKeggPathwayOverlapList,allBasedKeggPathwayOverlapList,overlapDefinition);
				}
				//UCSCRefSeqGenes Search ends here
				
				//accumulate search results of exonBasedKeggPathway2OneorZeroMap in exonBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: exonBasedKeggPathway2OneorZeroMap.entrySet()){
					 
					if (exonBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						exonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						exonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), exonBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
					}
	
				}//End of for
				
				
				//accumulate search results of regulationBasedKeggPathway2OneorZeroMap in regulationBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: regulationBasedKeggPathway2OneorZeroMap.entrySet()){
					 
					if (regulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						regulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						regulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), regulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
					}
	
				}//End of for
				
				//accumulate search results of allBasedKeggPathway2OneorZeroMap in allBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: allBasedKeggPathway2OneorZeroMap.entrySet()){
					 
					if (allBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						allBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						allBasedKeggPathway2KMap.put(zeroOrOne.getKey(), allBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				//code will be added here
				
				
				//New search for given input SNP or interval case, does not matter.
				//starts here
				//for each tf overlap
				//for each ucscRefSeqGene overlap
				//if these overlaps overlaps
				//then write common overlap to output files 
				//question will the overlapDefinition apply here?
				for(TfNameandCellLineNameOverlap tfOverlap: tfandCellLineOverlapList){
					
					tfNameCellLineName 	= tfOverlap.getTfNameandCellLineName();
					tfName 				= tfNameCellLineName.substring(0,tfNameCellLineName.indexOf('_'));
					
					//TF and Exon Based Kegg Pathway
					for (UcscRefSeqGeneOverlap ucscRefSeqGeneOverlap: exonBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlap.getLow(), ucscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:ucscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
										
										
										tfNameCellLineNameKeggPathwayName = tfNameCellLineName + "_" + keggPathwayName;
										tfNameKeggPathwayName =  tfName + "_" + keggPathwayName;
										
										
									
										if (tfCellLineExonBasedKeggPathway2OneorZeroMap.get(tfNameCellLineNameKeggPathwayName)==null){
											tfCellLineExonBasedKeggPathway2OneorZeroMap.put(tfNameCellLineNameKeggPathwayName, 1);
										}
								
										if (tfExonBasedKeggPathway2OneorZeroMap.get(tfNameKeggPathwayName)==null){
											tfExonBasedKeggPathway2OneorZeroMap.put(tfNameKeggPathwayName, 1);
										}
										
										/*************************************************************/
										bufferedWriter1 = tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.get(tfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){						
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY +"_" + tfNameCellLineNameKeggPathwayName + ".txt");
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.put(tfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}

										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfOverlap.getTfNameandCellLineName()+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  ucscRefSeqGeneOverlap.getRefSeqGeneName() + "\t" + ucscRefSeqGeneOverlap.getLow()+ "\t" + ucscRefSeqGeneOverlap.getHigh()  + "\t"  + ucscRefSeqGeneOverlap.getIntervalName() + "\t" + ucscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + ucscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/*************************************************************/

										/*************************************************************/
										bufferedWriter2 = tfExonBasedKeggPathwayBufferedWriterHashMap.get(tfNameKeggPathwayName);
										
										if (bufferedWriter2==null){						
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_EXON_BASED_KEGG_PATHWAY +"_" + tfNameKeggPathwayName + ".txt");
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfExonBasedKeggPathwayBufferedWriterHashMap.put(tfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}

										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfOverlap.getTfNameandCellLineName()+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  ucscRefSeqGeneOverlap.getRefSeqGeneName() + "\t" + ucscRefSeqGeneOverlap.getLow()+ "\t" + ucscRefSeqGeneOverlap.getHigh()  + "\t"  + ucscRefSeqGeneOverlap.getIntervalName() + "\t" + ucscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + ucscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/*************************************************************/

							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
					//TF and Regulation Based Kegg Pathway
					for (UcscRefSeqGeneOverlap ucscRefSeqGeneOverlap: regulationBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlap.getLow(), ucscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:ucscRefSeqGeneOverlap.getKeggPathwayNameList()){
										
										tfNameCellLineNameKeggPathwayName = tfOverlap.getTfNameandCellLineName() + "_" + keggPathwayName;
										tfNameKeggPathwayName =  tfName + "_" + keggPathwayName;
										
										if (tfCellLineRegulationBasedKeggPathway2OneorZeroMap.get(tfNameCellLineNameKeggPathwayName)==null){
											tfCellLineRegulationBasedKeggPathway2OneorZeroMap.put(tfNameCellLineNameKeggPathwayName, 1);
										}
										
										if (tfRegulationBasedKeggPathway2OneorZeroMap.get(tfNameKeggPathwayName)==null){
											tfRegulationBasedKeggPathway2OneorZeroMap.put(tfNameKeggPathwayName, 1);
										}
										
										/***********************************************************/
										bufferedWriter1 = tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.get(tfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){						
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY +"_" + tfNameCellLineNameKeggPathwayName + ".txt");
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.put(tfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}

										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfOverlap.getTfNameandCellLineName()+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  ucscRefSeqGeneOverlap.getRefSeqGeneName() + "\t" + ucscRefSeqGeneOverlap.getLow()+ "\t" + ucscRefSeqGeneOverlap.getHigh()  + "\t"  + ucscRefSeqGeneOverlap.getIntervalName() + "\t" + ucscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + ucscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/***********************************************************/
										
										
										/***********************************************************/
										bufferedWriter2 = tfRegulationBasedKeggPathwayBufferedWriterHashMap.get(tfNameKeggPathwayName);
										
										if (bufferedWriter2==null){						
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_REGULATION_BASED_KEGG_PATHWAY +"_" + tfNameKeggPathwayName + ".txt");
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfRegulationBasedKeggPathwayBufferedWriterHashMap.put(tfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}

										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfOverlap.getTfNameandCellLineName()+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh() + "\t" + ucscRefSeqGeneOverlap.getRefSeqGeneName()  + "\t" + ucscRefSeqGeneOverlap.getLow()+ "\t" + ucscRefSeqGeneOverlap.getHigh()  + "\t" + ucscRefSeqGeneOverlap.getIntervalName() + "\t" + ucscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + ucscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/***********************************************************/
										
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
					//TF and All Based Kegg Pathway
					for (UcscRefSeqGeneOverlap ucscRefSeqGeneOverlap: allBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlap.getLow(), ucscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:ucscRefSeqGeneOverlap.getKeggPathwayNameList()){
										
										tfNameCellLineNameKeggPathwayName = tfOverlap.getTfNameandCellLineName() + "_" + keggPathwayName;
										tfNameKeggPathwayName =  tfName + "_" + keggPathwayName;
										
										if (tfCellLineAllBasedKeggPathway2OneorZeroMap.get(tfNameCellLineNameKeggPathwayName)==null){
											tfCellLineAllBasedKeggPathway2OneorZeroMap.put(tfNameCellLineNameKeggPathwayName, 1);
										}
								
										if (tfAllBasedKeggPathway2OneorZeroMap.get(tfNameKeggPathwayName)==null){
											tfAllBasedKeggPathway2OneorZeroMap.put(tfNameKeggPathwayName, 1);
										}
										
										/*****************************************************************/
										bufferedWriter1 = tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.get(tfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){						
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY +"_" + tfNameCellLineNameKeggPathwayName + ".txt");
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.put(tfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}

										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfOverlap.getTfNameandCellLineName()+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  ucscRefSeqGeneOverlap.getRefSeqGeneName() + "\t" + ucscRefSeqGeneOverlap.getLow()+ "\t" + ucscRefSeqGeneOverlap.getHigh()  + "\t"  + ucscRefSeqGeneOverlap.getIntervalName() + "\t" + ucscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + ucscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/*****************************************************************/
										
										
										/*****************************************************************/
										bufferedWriter2 = tfAllBasedKeggPathwayBufferedWriterHashMap.get(tfNameKeggPathwayName);
										
										if (bufferedWriter2==null){						
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_ALL_BASED_KEGG_PATHWAY +"_" + tfNameKeggPathwayName + ".txt");
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfAllBasedKeggPathwayBufferedWriterHashMap.put(tfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}

										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfOverlap.getTfNameandCellLineName()+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  ucscRefSeqGeneOverlap.getRefSeqGeneName() + "\t" + ucscRefSeqGeneOverlap.getLow()+ "\t" + ucscRefSeqGeneOverlap.getHigh()  + "\t"  + ucscRefSeqGeneOverlap.getIntervalName() + "\t" + ucscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + ucscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/*****************************************************************/
								
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query

				}//for each tfOverlap for the given query
				//ends here
				
				
				//TF CELLLINE EXONBASED_KEGGPATHWAY
				//Fill tfbsAndCellLineAndExonBasedKeggPathway2KMap using tfandExonBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: tfCellLineExonBasedKeggPathway2OneorZeroMap.entrySet()){
				
					tfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (tfCellLineExonBasedKeggPathway2KMap.get(tfNameCellLineNameKeggPathwayName)==null){
						tfCellLineExonBasedKeggPathway2KMap.put(tfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						tfCellLineExonBasedKeggPathway2KMap.put(tfNameCellLineNameKeggPathwayName, tfCellLineExonBasedKeggPathway2KMap.get(tfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				//TF CELLLINE REGULATIONBASED_KEGGPATHWAY
				//Fill tfbsAndCellLineAndRegulationBasedKeggPathway2KMap using tfandRegulationBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: tfCellLineRegulationBasedKeggPathway2OneorZeroMap.entrySet()){
					
					tfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (tfCellLineRegulationBasedKeggPathway2KMap.get(tfNameCellLineNameKeggPathwayName)==null){
						tfCellLineRegulationBasedKeggPathway2KMap.put(tfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						tfCellLineRegulationBasedKeggPathway2KMap.put(tfNameCellLineNameKeggPathwayName, tfCellLineRegulationBasedKeggPathway2KMap.get(tfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				
				//TF CELLLINE ALLBASED_KEGGPATHWAY
				//Fill  tfbsAndCellLineAndAllBasedKeggPathway2KMap using tfandAllBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: tfCellLineAllBasedKeggPathway2OneorZeroMap.entrySet()){
					
					tfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (tfCellLineAllBasedKeggPathway2KMap.get(tfNameCellLineNameKeggPathwayName)==null){
						tfCellLineAllBasedKeggPathway2KMap.put(tfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						tfCellLineAllBasedKeggPathway2KMap.put(tfNameCellLineNameKeggPathwayName, tfCellLineAllBasedKeggPathway2KMap.get(tfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				//TF EXONBASED_KEGGPATHWAY
				//Fill tfExonBasedKeggPathway2KMap using tfExonBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: tfExonBasedKeggPathway2OneorZeroMap.entrySet()){
					tfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					//new
					if (tfExonBasedKeggPathway2KMap.get(tfNameKeggPathwayName)==null){
						tfExonBasedKeggPathway2KMap.put(tfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						tfExonBasedKeggPathway2KMap.put(tfNameKeggPathwayName, tfExonBasedKeggPathway2KMap.get(tfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					//new		
				}//End of for inner loop 
				
				//TF REGULATIONBASED_KEGGPATHWAY
				//Fill tfRegulationBasedKeggPathway2KMap using tfRegulationBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: tfRegulationBasedKeggPathway2OneorZeroMap.entrySet()){
					tfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					//new
					if (tfRegulationBasedKeggPathway2KMap.get(tfNameKeggPathwayName)==null){
						tfRegulationBasedKeggPathway2KMap.put(tfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						tfRegulationBasedKeggPathway2KMap.put(tfNameKeggPathwayName, tfRegulationBasedKeggPathway2KMap.get(tfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					//new	
				}//End of for inner loop 
				
				
				//TF ALLBASED_KEGGPATHWAY
				//Fill  tfAllBasedKeggPathway2KMap using tfAllBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: tfAllBasedKeggPathway2OneorZeroMap.entrySet()){
					
					tfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					//new
					if (tfAllBasedKeggPathway2KMap.get(tfNameKeggPathwayName)==null){
						tfAllBasedKeggPathway2KMap.put(tfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						tfAllBasedKeggPathway2KMap.put(tfNameKeggPathwayName, tfAllBasedKeggPathway2KMap.get(tfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					//new
					
				}//End of for inner loop 
				
				//added here ends
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 
	}
	//New Functionality
	
	
	//Empirical P Value Calculation
	//with IO
	public static void searchHistone(String outputFolder,int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree histoneIntervalTree, Map<String,BufferedWriter> histoneBufferedWriterHashMap, Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap,int overlapDefinition){
		InputLine inputLine;	
		int low;
		int high;
		
		
			for(int i=0; i<inputLines.size(); i++){
				
				Map<String,Integer> permutationNumberHistoneNameCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
				
				inputLine = inputLines.get(i);
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				
				Interval interval = new Interval(low,high);
				
				if(histoneIntervalTree.getRoot().getNodeName().isNotSentinel()){
					histoneIntervalTree.findAllOverlappingHistoneIntervals(outputFolder,permutationNumber,histoneIntervalTree.getRoot(),interval,chromName, histoneBufferedWriterHashMap,permutationNumberHistoneNameCellLineName2ZeroorOneMap,overlapDefinition);					
				}
								
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberHistoneNameCellLineName2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberHistoneNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberHistoneNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberHistoneNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberHistoneNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				
			}//End of for
		
	}

	
	//Empirical P Value Calculation
	//without IO
	public static void searchHistonewithoutIO(int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree histoneIntervalTree, Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap,int overlapDefinition){
		InputLine inputLine;	
		int low;
		int high;
		
//		//Keeps the overlapping node list for the current query
//		List<IntervalTreeNode> overlappingNodeList = new ArrayList<IntervalTreeNode>();
//		//Keeps the latest non empty overlapping node list for the previous queries
//		List<IntervalTreeNode> previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>();
//		//Keeps the left most node 
//		IntervalTreeNode previousLeftMostNode = new IntervalTreeNode();
//		
//		IntervalTreeNode newSearchStartingNode= histoneIntervalTree.getRoot();
			

			for(int i=0; i<inputLines.size(); i++){
				
				Map<String,Integer> permutationNumberHistoneNameCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
				
				inputLine = inputLines.get(i);
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				
				Interval interval = new Interval(low,high);
				
//				//Empty the overlapping node list for the new query
//				overlappingNodeList.clear();	
//				
//				if (previousLeftMostNode.isNotSentinel()){
//				
//					//Go up in the interval tree for the new query
//					newSearchStartingNode = IntervalTree.findMostGeneralSearchStaringNodeforNewQuery(interval,previousLeftMostNode);
//					
//					//Go down in the interval tree for the new query 
//					newSearchStartingNode = IntervalTree.findMostSpecificSearchStaringNodeforNewQuery(interval,newSearchStartingNode);	
//				}
//				
//				
//				//If sentinel means that there is no need to search for this new query
//				if(newSearchStartingNode.isNotSentinel()){
//					histoneIntervalTree.findAllOverlappingHistoneIntervals(repeatNumber,permutationNumber,NUMBER_OF_PERMUTATIONS,newSearchStartingNode,interval,chromName,permutationNumberHistoneNameCellLineName2ZeroorOneMap,overlappingNodeList);					
//				}			
//				
//				if(!overlappingNodeList.isEmpty()){
//					previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>(overlappingNodeList);
//					previousLeftMostNode = IntervalTree.findLeftMostNodefromPreviousQuery(previousNonEmptyOverlappingNodeList);			
//				}
				
				if(histoneIntervalTree.getRoot().getNodeName().isNotSentinel()){
					histoneIntervalTree.findAllOverlappingHistoneIntervals(permutationNumber,histoneIntervalTree.getRoot(),interval,chromName,permutationNumberHistoneNameCellLineName2ZeroorOneMap,overlapDefinition);					
				}
								
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberHistoneNameCellLineName2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberHistoneNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberHistoneNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberHistoneNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberHistoneNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				
			}//End of for
		
	}
	
	public void searchHistone(String outputFolder,String chromName, BufferedReader bufferedReader, IntervalTree histoneIntervalTree, Map<String,BufferedWriter> histoneBufferedWriterHashMap, List<String> histoneNameList, Map<String,Integer> histoneNameandCellLineName2KMap,int overlapDefinition){
		String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				
				Map<String,Integer> histoneNameandCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
				
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//				indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);
				
				if(histoneIntervalTree.getRoot().getNodeName().isNotSentinel()){
					histoneIntervalTree.findAllOverlappingHistoneIntervals(outputFolder,histoneIntervalTree.getRoot(),interval,chromName, histoneBufferedWriterHashMap,histoneNameList,histoneNameandCellLineName2ZeroorOneMap,overlapDefinition);						
				}
								
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				for(Map.Entry<String, Integer> zeroOrOne: histoneNameandCellLineName2ZeroorOneMap.entrySet()){
					 
					if (histoneNameandCellLineName2KMap.get(zeroOrOne.getKey())==null){
						histoneNameandCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						histoneNameandCellLineName2KMap.put(zeroOrOne.getKey(), histoneNameandCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 
	}
	
	//Empirical P Value Calculation
	//Search keggPathway
	//with IO
	public static void searchUcscRefSeqGenes(String outputFolder,int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,BufferedWriter> bufferedWriterHashMap, Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> permutationNumberKeggPathway2KMap, String type,String keggPathwayAnalysisType,int overlapDefinition){
		
		InputLine inputLine;
		int low;
		int high;
		
		for(int i=0; i<inputLines.size(); i++){
				
				Map<String,Integer> permutationNumberKeggPathway2OneorZeroMap = new HashMap<String,Integer>();				
				
				inputLine = inputLines.get(i);
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				Interval interval = new Interval(low,high);

				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(outputFolder,permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,bufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberKeggPathway2OneorZeroMap,type,keggPathwayAnalysisType,overlapDefinition);
				}
								
				//accumulate search results of keggPathway2OneorZeroMap in keggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberKeggPathway2OneorZeroMap.entrySet()){
					 
					if (permutationNumberKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());					
					}
	
				}//End of for
		}//End of for
		
	}
	
	//Empirical P Value Calculation
	//Search keggPathway
	//without IO
	public static  void searchUcscRefSeqGeneswithoutIO(int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> permutationNumberKeggPathway2KMap, String type,String keggPathwayAnalysisType,int overlapDefinition){
		
		InputLine inputLine;
		int low;
		int high;
		
//		//Keeps the overlapping node list for the current query
//		List<IntervalTreeNode> overlappingNodeList = new ArrayList<IntervalTreeNode>();
//		//Keeps the latest non empty overlapping node list for the previous queries
//		List<IntervalTreeNode> previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>();
//		//Keeps the left most node 
//		IntervalTreeNode previousLeftMostNode = new IntervalTreeNode();
//		
//			
//		IntervalTreeNode newSearchStartingNode= ucscRefSeqGenesIntervalTree.getRoot();

		for(int i=0; i<inputLines.size(); i++){
				
				Map<String,Integer> permutationNumberKeggPathway2OneorZeroMap = new HashMap<String,Integer>();				
				
				inputLine = inputLines.get(i);
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				Interval interval = new Interval(low,high);
				
//				//Empty the overlapping node list for the new query
//				overlappingNodeList.clear();	
//				
//				if (previousLeftMostNode.isNotSentinel()){
//				
//					//Go up in the interval tree for the new query
//					newSearchStartingNode = IntervalTree.findMostGeneralSearchStaringNodeforNewQuery(interval,previousLeftMostNode);
//					
//					//Go down in the interval tree for the new query 
//					newSearchStartingNode = IntervalTree.findMostSpecificSearchStaringNodeforNewQuery(interval,newSearchStartingNode);	
//				}
//				
//				
//				
//				//If sentinel means that there is no need to search for this new query
//				if(newSearchStartingNode.isNotSentinel()){
//					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(repeatNumber,permutationNumber,NUMBER_OF_PERMUTATIONS,newSearchStartingNode,interval,chromName, geneId2KeggPathwayMap, permutationNumberKeggPathway2OneorZeroMap,type,keggPathwayAnalysisType,overlappingNodeList);					
//				}			
//				
//				if(!overlappingNodeList.isEmpty()){
//					previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>(overlappingNodeList);
//					previousLeftMostNode = IntervalTree.findLeftMostNodefromPreviousQuery(previousNonEmptyOverlappingNodeList);			
//				}

				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayMap, permutationNumberKeggPathway2OneorZeroMap,type,keggPathwayAnalysisType,overlapDefinition);					
				}
				
				
				//accumulate search results of keggPathway2OneorZeroMap in keggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberKeggPathway2OneorZeroMap.entrySet()){
					 
					if (permutationNumberKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
		}//End of for
		
	}
	
	//TF and KeggPathway Enrichment or
	//TF and CellLine and KeggPathway Enrichment starts
	//Empirical P Value Calculation
	//Search tf and keggPathway
	//TF CellLine Exon Based Kegg Pathway
	//TF CellLine Regulation Based Kegg Pathway
	//TF CellLine All Based Kegg Pathway
	//TF Exon Based Kegg Pathway
	//TF Regulation Based Kegg Pathway
	//TF All Based Kegg Pathway
	//with IO
	public static  void searchTfandKeggPathway(String outputFolder,int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfIntervalTree, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,BufferedWriter> tfbsBufferedWriterHashMap, Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> permutationNumberTfNameCellLineName2KMap, Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap, Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap, Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap, String type,String tfandKeggPathwayEnrichmentType,int overlapDefinition){
		int low;
		int high;
		
		FileWriter fileWriter1 = null;
		BufferedWriter bufferedWriter1 = null;
		FileWriter fileWriter2 = null;
		BufferedWriter bufferedWriter2 = null;

		
		int repeatNumberReflectedPermutationNumber = permutationNumber;
		
		String permutationNumberTfNameCellLineName;
		String permutationNumberTfName;
		String permutationNumberTfNameCellLineNameKeggPathwayName;
		String permutationNumberTfNameKeggPathwayName;	
		
		int indexofFirstUnderscore;
		int indexofSecondUnderscore;
		

		try{	
			for(InputLine inputLine: inputLines){
				
				Map<String,Integer> permutationNumberTfNameCellLineName2ZeroorOneMap 			= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberExonBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberAllBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();				
				
				//will be used 	for tf and keggPathway enrichment and
				Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				
				//will be used	for tf and cellLine and keggPathway enrichment
				Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
	
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				Interval interval = new Interval(low,high);
				
				//Fill these lists during search for tfs and search for ucscRefSeqGenes
				List<PermutationNumberTfNameCellLineNameOverlap> 	permutationNumberTfNameCellLineNameOverlapList = new ArrayList<PermutationNumberTfNameCellLineNameOverlap>();
				List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberExonBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
				List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberRegulationBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
				List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberAllBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
		
				if(tfIntervalTree.getRoot().getNodeName().isNotSentinel()){
					tfIntervalTree.findAllOverlappingTfbsIntervals(outputFolder,permutationNumber,tfIntervalTree.getRoot(),interval,chromName,tfbsBufferedWriterHashMap,permutationNumberTfNameCellLineName2ZeroorOneMap,permutationNumberTfNameCellLineNameOverlapList,overlapDefinition);	
				}
				
				//accumulate search results of permutationNumberTfbsNameCellLineName2ZeroorOneMap in permutationNumberTfbsNameCellLineName2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberTfNameCellLineName2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
					}
				}//End of for
				
				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(outputFolder,permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,permutationNumberExonBasedKeggPathway2ZeroorOneMap,permutationNumberRegulationBasedKeggPathway2ZeroorOneMap,permutationNumberAllBasedKeggPathway2ZeroorOneMap,type,permutationNumberExonBasedKeggPathwayOverlapList,permutationNumberRegulationBasedKeggPathwayOverlapList,permutationNumberAllBasedKeggPathwayOverlapList,overlapDefinition);					
				}
				
				//accumulate search results of permutationNumberExonBasedKeggPathway2ZeroorOneMap in permutationNumberExonBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberExonBasedKeggPathway2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
				}//End of for
			
				//accumulate search results of permutationNumberRegulationBasedKeggPathway2ZeroorOneMap in permutationNumberRegulationBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
				}//End of for
				
				//accumulate search results of permutationNumberAllBasedKeggPathway2ZeroorOneMap in permutationNumberAllBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberAllBasedKeggPathway2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
				}//End of for
				
				
				
				//New search for given input SNP or interval case, does not matter.
				//for each tf overlap
				//for each ucscRefSeqGene overlap
				//if these overlaps overlaps
				//question will overlapDefinition apply here?
				//then write common overlap to output files 
				//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
				//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
				//Fill permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
				
				//permutation number is same for tf and keggPathway  maps
				//for example: permutationNumberTfbsNameCellLineName2ZeroorOneMap
				//for example: permutationNumberExonBasedKeggPathway2ZeroorOneMap
				//input lines are randomly generated data for this permutation number 
				//all the entries in these maps have 1 values.
				//if there is an entry, it means that it is 1.
				
				for(PermutationNumberTfNameCellLineNameOverlap permutationNumberTfNameCellLineNameOverlap: permutationNumberTfNameCellLineNameOverlapList){
					
					permutationNumberTfNameCellLineName = permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName();
					indexofFirstUnderscore 	= permutationNumberTfNameCellLineName.indexOf('_');
					indexofSecondUnderscore = permutationNumberTfNameCellLineName.indexOf('_', indexofFirstUnderscore+1);
					permutationNumberTfName = permutationNumberTfNameCellLineName.substring(0,indexofSecondUnderscore);
					
					//TF and Exon Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberExonBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
										
								   if(tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT)){
										/******************************************************/
										permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;

										if (permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameKeggPathwayName)==null){
											permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameKeggPathwayName, 1);
										}
										/******************************************************/
										/******************************************************/
										bufferedWriter2 = tfExonBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameKeggPathwayName);
										
										if (bufferedWriter2==null){												
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_EXON_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfExonBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
										
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t"+ permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t"  + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/******************************************************/
										
								   }else if (tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){
									   /******************************************************/
										permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
											permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
										}
										/******************************************************/
										
										/******************************************************/
										bufferedWriter1 = tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){	
																						
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
										
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" +permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/******************************************************/
										
								   }
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
					//TF and Regulation Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberRegulationBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
										
									if(tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT)){
										
										/************************************************/
										permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameKeggPathwayName)==null){
											permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameKeggPathwayName, 1);
										}
										/************************************************/										
										
										/************************************************/
										bufferedWriter2 = tfRegulationBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameKeggPathwayName);
										
										if (bufferedWriter2==null){	
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfRegulationBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
	
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" +permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/************************************************/
										
									}else if (tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){
										/************************************************/
										permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
											permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
										}
										/************************************************/
										
										/************************************************/
										bufferedWriter1 = tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){											
											
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
	
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" +permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/************************************************/

									}
										
										
										

							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
					//TF and All Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberAllBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
								
									if (tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT)){
										
										/************************************************/
										permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameKeggPathwayName)==null){
											permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameKeggPathwayName, 1);
										}
										/************************************************/
										
										/************************************************/
										bufferedWriter2 = tfAllBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameKeggPathwayName);
										
										if (bufferedWriter2==null){	
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_ALL_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfAllBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
	
	
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" +permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/************************************************/

									}else if (tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){
										/************************************************/
										permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
											permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
										}
										/************************************************/
										
										/************************************************/
										bufferedWriter1 = tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){	
											
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
	
	
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" +permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/************************************************/
																		
									}
											
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
	
				}//for each tfOverlap for the given query
				
				
				if (tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT)){
					
					//TF EXON BASED
					//Fill permutationNumberTfNameExonBasedKeggPathway2KMap using permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap
					for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap.entrySet()){
					
						permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
						
						if (permutationNumberTfNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
							permutationNumberTfNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
						}else{
							permutationNumberTfNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
						}
						
					}//End of for inner loop 
					
					//TF REGULATION BASED
					//Fill permutationNumberTfNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap
					for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
						
						permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
						
						if (permutationNumberTfNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
							permutationNumberTfNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
						}else{
							permutationNumberTfNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
						}
						
					}//End of for inner loop 
					
					
					//TF ALL BASED
					//Fill  permutationNumberTfNameAllBasedKeggPathway2KMap using permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap
					for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap.entrySet()){
						
						permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
						
						if (permutationNumberTfNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
							permutationNumberTfNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
						}else{
							permutationNumberTfNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
						}
						
					}//End of for inner loop 
					
				} else if (tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){
					//TF CELLLINE EXON BASED
					//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
					for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap.entrySet()){
					
						permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
						
						if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
							permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
						}else{
							permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
						}
						
					}//End of for inner loop 
					
					//TF CELLLINE REGULATION BASED
					//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
					for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
						
						permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
						
						if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
							permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
						}else{
							permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
						}
						
					}//End of for inner loop 
					
					
					//TF CELLLINE ALL BASED
					//Fill  permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
					for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap.entrySet()){
						
						permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
						
						if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
							permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
						}else{
							permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
						}
						
					}//End of for inner loop 
					
				}
				
				
				
				
				
			}//End of for each input line
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 

		
	}
	//TF and KeggPathway Enrichment or
	//TF and CellLine and KeggPathway Enrichment ends
	
	//Empirical P Value Calculation
	//Search tf and keggPathway
	//TF CellLine Exon Based Kegg Pathway
	//TF CellLine Regulation Based Kegg Pathway
	//TF CellLine All Based Kegg Pathway
	//TF Exon Based Kegg Pathway
	//TF Regulation Based Kegg Pathway
	//TF All Based Kegg Pathway
	//with IO
	public static  void searchTfandKeggPathway(String outputFolder,int repeatNumber,int permutationNumber,int NUMBER_OF_PERMUTATIONS, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfIntervalTree, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,BufferedWriter> tfbsBufferedWriterHashMap, Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap,Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> permutationNumberTfNameCellLineName2KMap, Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap, Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap, Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2KMap, String type,int overlapDefinition){
		int low;
		int high;
		
		FileWriter fileWriter1 = null;
		BufferedWriter bufferedWriter1 = null;
		FileWriter fileWriter2 = null;
		BufferedWriter bufferedWriter2 = null;

		
		int repeatNumberReflectedPermutationNumber = ((repeatNumber-1)*NUMBER_OF_PERMUTATIONS) + permutationNumber;
		
		String permutationNumberTfNameCellLineName;
		String permutationNumberTfName;
		String permutationNumberTfNameCellLineNameKeggPathwayName;
		String permutationNumberTfNameKeggPathwayName;	
		
		int indexofFirstUnderscore;
		int indexofSecondUnderscore;
		

		try{	
			for(InputLine inputLine: inputLines){
				
				Map<String,Integer> permutationNumberTfNameCellLineName2ZeroorOneMap 			= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberExonBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberAllBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();				
				
				Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				
				Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				Interval interval = new Interval(low,high);
				
				//Fill these lists during search for tfs and search for ucscRefSeqGenes
				List<PermutationNumberTfNameCellLineNameOverlap> 	permutationNumberTfNameCellLineNameOverlapList = new ArrayList<PermutationNumberTfNameCellLineNameOverlap>();
				List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberExonBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
				List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberRegulationBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
				List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberAllBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
		
				if(tfIntervalTree.getRoot().getNodeName().isNotSentinel()){
					tfIntervalTree.findAllOverlappingTfbsIntervals(outputFolder,permutationNumber,tfIntervalTree.getRoot(),interval,chromName,tfbsBufferedWriterHashMap,permutationNumberTfNameCellLineName2ZeroorOneMap,permutationNumberTfNameCellLineNameOverlapList,overlapDefinition);	
				}
				
				//accumulate search results of permutationNumberTfbsNameCellLineName2ZeroorOneMap in permutationNumberTfbsNameCellLineName2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberTfNameCellLineName2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
					}
				}//End of for
				
				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
						ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(outputFolder,permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,permutationNumberExonBasedKeggPathway2ZeroorOneMap,permutationNumberRegulationBasedKeggPathway2ZeroorOneMap,permutationNumberAllBasedKeggPathway2ZeroorOneMap,type,permutationNumberExonBasedKeggPathwayOverlapList,permutationNumberRegulationBasedKeggPathwayOverlapList,permutationNumberAllBasedKeggPathwayOverlapList,overlapDefinition);					
				}
				
				//accumulate search results of permutationNumberExonBasedKeggPathway2ZeroorOneMap in permutationNumberExonBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberExonBasedKeggPathway2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
				}//End of for
			
				//accumulate search results of permutationNumberRegulationBasedKeggPathway2ZeroorOneMap in permutationNumberRegulationBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
				}//End of for
				
				//accumulate search results of permutationNumberAllBasedKeggPathway2ZeroorOneMap in permutationNumberAllBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberAllBasedKeggPathway2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
				}//End of for
				
				
				
				//New search for SNP or interval case, does not matter.
				//for each tf overlap
				//for each ucscRefSeqGene overlap
				//if these overlaps overlaps
				//then write common overlap to output files 
				//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
				//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
				//Fill permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
				
				//permutation number is same for tf and keggPathway  maps
				//for example: permutationNumberTfbsNameCellLineName2ZeroorOneMap
				//for example: permutationNumberExonBasedKeggPathway2ZeroorOneMap
				//input lines are randomly generated data for this permutation number 
				//all the entries in these maps have 1 values.
				//if there is an entry, it means that it is 1.
				
				for(PermutationNumberTfNameCellLineNameOverlap permutationNumberTfNameCellLineNameOverlap: permutationNumberTfNameCellLineNameOverlapList){
					
					permutationNumberTfNameCellLineName = permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName();
					indexofFirstUnderscore 	= permutationNumberTfNameCellLineName.indexOf('_');
					indexofSecondUnderscore = permutationNumberTfNameCellLineName.indexOf('_', indexofFirstUnderscore+1);
					permutationNumberTfName = permutationNumberTfNameCellLineName.substring(0,indexofSecondUnderscore);
					
					//TF and Exon Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberExonBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
										
										/******************************************************/
										permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
											permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
										}
										/******************************************************/
										
										
										/******************************************************/
										permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;

										if (permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameKeggPathwayName)==null){
											permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameKeggPathwayName, 1);
										}
										/******************************************************/
										
										/******************************************************/
										bufferedWriter1 = tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){	
																					
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}
										
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()   + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/******************************************************/
										
										/******************************************************/
										bufferedWriter2 = tfExonBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameKeggPathwayName);
										
										if (bufferedWriter2==null){												
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_EXON_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfExonBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}
										
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()   + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/******************************************************/
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
					//TF and Regulation Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberRegulationBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
										
										/************************************************/
										permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
											permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
										}
										/************************************************/

										/************************************************/
										permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameKeggPathwayName)==null){
											permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameKeggPathwayName, 1);
										}
										/************************************************/

										
										/************************************************/
										bufferedWriter1 = tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){	
																						
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}
	
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()   + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/************************************************/
										
										/************************************************/
										bufferedWriter2 = tfRegulationBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameKeggPathwayName);
										
										if (bufferedWriter2==null){	
																						
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfRegulationBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}
	
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()   + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/************************************************/
										

							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
					//TF and All Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberAllBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
										
										/************************************************/
										permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
											permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
										}
										/************************************************/
									
										/************************************************/
										permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameKeggPathwayName)==null){
											permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameKeggPathwayName, 1);
										}
										/************************************************/

										/************************************************/
										bufferedWriter1 = tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){	
																						
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}
	
	
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()   + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/************************************************/
										
										
										/************************************************/
										bufferedWriter2 = tfAllBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameKeggPathwayName);
										
										if (bufferedWriter2==null){	
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_ALL_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfAllBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}
	
	
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()   + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/************************************************/
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
	
				}//for each tfOverlap for the given query
				
				//TF CELLLINE EXON BASED
				//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap.entrySet()){
				
					permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
						permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				//TF CELLLINE REGULATION BASED
				//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
					
					permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
						permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				
				//TF CELLLINE ALL BASED
				//Fill  permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap.entrySet()){
					
					permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
						permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				
				//TF EXON BASED
				//Fill permutationNumberTfNameExonBasedKeggPathway2KMap using permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap.entrySet()){
				
					permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
						permutationNumberTfNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				//TF REGULATION BASED
				//Fill permutationNumberTfNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
					
					permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
						permutationNumberTfNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				
				//TF ALL BASED
				//Fill  permutationNumberTfNameAllBasedKeggPathway2KMap using permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap.entrySet()){
					
					permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
						permutationNumberTfNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
			}//End of for each input line
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 

		
	}
	
	
	
	//There is a parameter called tfandKeggPathwayEnrichmentType	
	//Tf and KeggPathway Enrichment or
	//Tf and CellLine and KeggPathway Enrichment starts
	//New Functionality START
	//Empirical P Value Calculation
	//Search tf and keggPathway
	//TF and Exon Based Kegg Pathway
	//TF and Regulation Based Kegg Pathway
	//TF and All Based Kegg Pathway
	//without IO
	public static  void searchTfandKeggPathwaywithoutIO(int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfIntervalTree, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> permutationNumberTfNameCellLineName2KMap, Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap, Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap, Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap,String type,String tfandKeggPathwayEnrichmentType,int overlapDefinition){
		
		int low;
		int high;
		
		String permutationNumberTfNameCellLineName;
		String permutationNumberTfName;		
		String permutationNumberTfNameCellLineNameKeggPathwayName;
		String permutationNumberTfNameKeggPathwayName;
		
		int indexofFirstUnderscore;
		int indexofSecondUnderscore;
				
		for(InputLine inputLine: inputLines){
			
			//Will be filled in tfIntervalTree search
			Map<String,Integer> permutationNumberTfNameCellLineName2ZeroorOneMap 			= new HashMap<String,Integer>();
			
			//Will be filled in ucscRefSeqGene search
			Map<String,Integer> permutationNumberExonBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberAllBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();	
			
			//Will be filled in common overlap check
			//Will be used for tf and kegg pathway enrichment 
			Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
		
			//Will be filled in common overlap check
			//Will be used for tf and cell line and kegg pathway enrichment 
			Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			
			low = inputLine.getLow();
			high = inputLine.getHigh();
			Interval interval = new Interval(low,high);
			
			//Fill these lists during search for tfs and search for ucscRefSeqGenes
			List<PermutationNumberTfNameCellLineNameOverlap> 	permutationNumberTfNameCellLineNameOverlapList = new ArrayList<PermutationNumberTfNameCellLineNameOverlap>();
			List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberExonBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
			List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberRegulationBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
			List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberAllBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
			
			//First TF
			//Fill permutationNumberTfNameCellLineName2ZeroorOneMap
			if(tfIntervalTree.getRoot().getNodeName().isNotSentinel()){
				tfIntervalTree.findAllOverlappingTfbsIntervals(permutationNumber,tfIntervalTree.getRoot(),interval,chromName,permutationNumberTfNameCellLineName2ZeroorOneMap,permutationNumberTfNameCellLineNameOverlapList,overlapDefinition);
			}
			
			//accumulate search results of permutationNumberTfNameCellLineName2ZeroorOneMap in permutationNumberTfNameaCellLineName2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberTfNameCellLineName2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());	
				}
			}//End of for
			
			//Second UcscRefSeqGenes
			//Fill permutationNumberExonBasedKeggPathway2ZeroorOneMap
			//Fill permutationNumberRegulationBasedKeggPathway2ZeroorOneMap
			//Fill permutationNumberAllBasedKeggPathway2ZeroorOneMap
			if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
				ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2ZeroorOneMap,permutationNumberRegulationBasedKeggPathway2ZeroorOneMap,permutationNumberAllBasedKeggPathway2ZeroorOneMap,type,permutationNumberExonBasedKeggPathwayOverlapList,permutationNumberRegulationBasedKeggPathwayOverlapList,permutationNumberAllBasedKeggPathwayOverlapList,overlapDefinition);					
			}
			
			//accumulate search results of exonBasedKeggPathway2ZeroorOneMap in permutationNumberExonBasedKeggPathway2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberExonBasedKeggPathway2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}
			}//End of for
			
			//accumulate search results of regulationBasedKeggPathway2ZeroorOneMap in permutationNumberRegulationBasedKeggPathway2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}
			}//End of for
			
			//accumulate search results of allBasedKeggPathway2ZeroorOneMap in permutationNumberAllBasedKeggPathway2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberAllBasedKeggPathway2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}
			}//End of for
					
			
			//New search for given input SNP or interval case, does not matter.
			//for each tf overlap
			//for each ucscRefSeqGene overlap
			//if these overlaps overlaps
			//then write common overlap to output files 
			//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
			//question will overlapDefition apply to here?
			for(PermutationNumberTfNameCellLineNameOverlap permutationNumberTfNameCellLineNameOverlap: permutationNumberTfNameCellLineNameOverlapList){
				
				permutationNumberTfNameCellLineName = permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName();
				indexofFirstUnderscore 	= permutationNumberTfNameCellLineName.indexOf('_');
				indexofSecondUnderscore = permutationNumberTfNameCellLineName.indexOf('_', indexofFirstUnderscore+1);
				permutationNumberTfName = permutationNumberTfNameCellLineName.substring(0,indexofSecondUnderscore);
				
				//TF and Exon Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberExonBasedKeggPathwayOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
						for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
							
							if(tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT)){
								/***********************************/
								permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
								
								if (permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameKeggPathwayName)==null){
									permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameKeggPathwayName, 1);
								}
								/***********************************/
							
							}else if(tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){
								/***********************************/
								permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
								
								if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
									permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
								}
								/***********************************/
								
							}
									
							
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
				
				
				//TF and Regulation Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberRegulationBasedKeggPathwayOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
						for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
									
							if(tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT)){
								/***********************************/
								permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
								
								if (permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameKeggPathwayName)==null){
									permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameKeggPathwayName, 1);
								}
								/***********************************/
								
							} else if (tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){
								/***********************************/
								permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
						
								if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
									permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
								}
								/***********************************/
							
							}
								
									
									
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
				
				
				//TF and All Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberAllBasedKeggPathwayOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
						for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
									
							if(tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT)){
								/***********************************/
								permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
								
								if (permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameKeggPathwayName)==null){
									permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameKeggPathwayName, 1);
								}
								/***********************************/
								
							} else if (tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){
								/***********************************/
								permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
							
								if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
									permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
								}
								/***********************************/
								
							}
								
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
			}//for each tfOverlap for the given query
			
			
			if(tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT)){
				
				//new code starts 
				//TF EXON BASED
				//Fill permutationNumberTfExonBasedKeggPathway2KMap using permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap.entrySet()){
				
					permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
						permutationNumberTfNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
									
				}//End of for inner loop 
				
				//TF REGULATION BASED
				//Fill permutationNumberTfRegulationBasedKeggPathway2KMap using permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap.entrySet()){
					
					permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
						permutationNumberTfNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				
				//TF ALL BASED
				//Fill  permutationNumberTfAllBasedKeggPathway2KMap using permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap.entrySet()){
					
					permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
						permutationNumberTfNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 

				//new code ends
				
			} else if (tfandKeggPathwayEnrichmentType.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){
				
				//TF CELLLINE EXON BASED
				//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap.entrySet()){
				
					permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
						permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
									
				}//End of for inner loop 
				
				//TF CELLLINE REGULATION BASED
				//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap.entrySet()){
					
					permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
						permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				
				//TF CELLLINE ALL BASED
				//Fill  permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap.entrySet()){
					
					permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
						permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
			}
				
		}//End of for each input line
				
	}
	//New Functionality END
	//Tf and KeggPathway Enrichment or
	//Tf and CellLine and KeggPathway Enrichment ends
		
	//There is NO parameter called tfandKeggPathwayEnrichmentType	
	//New Functionality START
	//Empirical P Value Calculation
	//Search tf and keggPathway
	//TF and Exon Based Kegg Pathway
	//TF and Regulation Based Kegg Pathway
	//TF and All Based Kegg Pathway
	//without IO
	public static  void searchTfandKeggPathwaywithoutIO(int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfIntervalTree, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> permutationNumberTfNameCellLineName2KMap, Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap, Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap, Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfExonBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfRegulationBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfAllBasedKeggPathway2KMap,String type,int overlapDefinition){
		
		int low;
		int high;
		
		String permutationNumberTfNameCellLineName;
		String permutationNumberTfName;		
		String permutationNumberTfNameCellLineNameKeggPathwayName;
		String permutationNumberTfNameKeggPathwayName;
		
		int indexofFirstUnderscore;
		int indexofSecondUnderscore;
		
		
		for(InputLine inputLine: inputLines){
			
			//Will be filled in tfIntervalTree search
			Map<String,Integer> permutationNumberTfNameCellLineName2ZeroorOneMap 			= new HashMap<String,Integer>();
			
			//Will be filled in ucscRefSeqGene search
			Map<String,Integer> permutationNumberExonBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberAllBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();	
			
			//Will be filled in common overlap check
			Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			
			//Will be filled in common overlap check
			Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			
			low = inputLine.getLow();
			high = inputLine.getHigh();
			Interval interval = new Interval(low,high);
			
			//Fill these lists during search for tfs and search for ucscRefSeqGenes
			List<PermutationNumberTfNameCellLineNameOverlap> 	permutationNumberTfNameCellLineNameOverlapList = new ArrayList<PermutationNumberTfNameCellLineNameOverlap>();
			List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberExonBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
			List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberRegulationBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
			List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberAllBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
			
			//First TF
			//Fill permutationNumberTfNameCellLineName2ZeroorOneMap
			if(tfIntervalTree.getRoot().getNodeName().isNotSentinel()){
				tfIntervalTree.findAllOverlappingTfbsIntervals(permutationNumber,tfIntervalTree.getRoot(),interval,chromName,permutationNumberTfNameCellLineName2ZeroorOneMap,permutationNumberTfNameCellLineNameOverlapList,overlapDefinition);
			}
			
			//accumulate search results of permutationNumberTfNameCellLineName2ZeroorOneMap in permutationNumberTfNameaCellLineName2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberTfNameCellLineName2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());	
				}
			}//End of for
			
			//Second UcscRefSeqGenes
			//Fill permutationNumberExonBasedKeggPathway2ZeroorOneMap
			//Fill permutationNumberRegulationBasedKeggPathway2ZeroorOneMap
			//Fill permutationNumberAllBasedKeggPathway2ZeroorOneMap
			if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
				ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2ZeroorOneMap,permutationNumberRegulationBasedKeggPathway2ZeroorOneMap,permutationNumberAllBasedKeggPathway2ZeroorOneMap,type,permutationNumberExonBasedKeggPathwayOverlapList,permutationNumberRegulationBasedKeggPathwayOverlapList,permutationNumberAllBasedKeggPathwayOverlapList,overlapDefinition);					
			}
			
			//accumulate search results of exonBasedKeggPathway2ZeroorOneMap in permutationNumberExonBasedKeggPathway2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberExonBasedKeggPathway2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}
			}//End of for
			
			//accumulate search results of regulationBasedKeggPathway2ZeroorOneMap in permutationNumberRegulationBasedKeggPathway2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}
			}//End of for
			
			//accumulate search results of allBasedKeggPathway2ZeroorOneMap in permutationNumberAllBasedKeggPathway2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberAllBasedKeggPathway2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}
			}//End of for
					
			
			//New search for SNP or interval case, does not matter.
			//for each tf overlap
			//for each ucscRefSeqGene overlap
			//if these overlaps overlaps
			//then write common overlap to output files 
			//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap
			for(PermutationNumberTfNameCellLineNameOverlap permutationNumberTfNameCellLineNameOverlap: permutationNumberTfNameCellLineNameOverlapList){
				
				permutationNumberTfNameCellLineName = permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName();
				indexofFirstUnderscore 	= permutationNumberTfNameCellLineName.indexOf('_');
				indexofSecondUnderscore = permutationNumberTfNameCellLineName.indexOf('_', indexofFirstUnderscore+1);
				permutationNumberTfName = permutationNumberTfNameCellLineName.substring(0,indexofSecondUnderscore);
				
				//TF and Exon Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberExonBasedKeggPathwayOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
						for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
							
									/***********************************/
									permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
									
									if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
										permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
									}
									/***********************************/
									
									
									/***********************************/
									permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
									
									if (permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameKeggPathwayName)==null){
										permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameKeggPathwayName, 1);
									}
									/***********************************/
									
							
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
				
				
				//TF and Regulation Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberRegulationBasedKeggPathwayOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
						for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
									
									/***********************************/
									permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
							
									if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
										permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
									}
									/***********************************/
									
									
									/***********************************/
									permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
									
									if (permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameKeggPathwayName)==null){
										permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameKeggPathwayName, 1);
									}
									/***********************************/
									
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
				
				
				//TF and All Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberAllBasedKeggPathwayOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
						for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
									
									/***********************************/
									permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
								
									if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
										permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
									}
									/***********************************/
									
									/***********************************/
									permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
									
									if (permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameKeggPathwayName)==null){
										permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameKeggPathwayName, 1);
									}
									/***********************************/
									
							
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query

			}//for each tfOverlap for the given query
			
			
			//TF CELLLINE EXON BASED
			//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
			for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap.entrySet()){
			
				permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
				
				if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
					permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
				}else{
					permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
				}
								
			}//End of for inner loop 
			
			//TF CELLLINE REGULATION BASED
			//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
			for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap.entrySet()){
				
				permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
				
				if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
					permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
				}else{
					permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
				}
				
			}//End of for inner loop 
			
			
			//TF CELLLINE ALL BASED
			//Fill  permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
			for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap.entrySet()){
				
				permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
				
				if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
					permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
				}else{
					permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
				}
				
			}//End of for inner loop 
			
			//new code starts 
			//TF EXON BASED
			//Fill permutationNumberTfExonBasedKeggPathway2KMap using permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap
			for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap.entrySet()){
			
				permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
				
				if (permutationNumberTfExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
					permutationNumberTfExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
				}else{
					permutationNumberTfExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
				}
								
			}//End of for inner loop 
			
			//TF REGULATION BASED
			//Fill permutationNumberTfRegulationBasedKeggPathway2KMap using permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap
			for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap.entrySet()){
				
				permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
				
				if (permutationNumberTfRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
					permutationNumberTfRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
				}else{
					permutationNumberTfRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
				}
				
			}//End of for inner loop 
			
			
			//TF ALL BASED
			//Fill  permutationNumberTfAllBasedKeggPathway2KMap using permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap
			for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap.entrySet()){
				
				permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
				
				if (permutationNumberTfAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
					permutationNumberTfAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
				}else{
					permutationNumberTfAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
				}
				
			}//End of for inner loop 

			//new code ends
				
		}//End of for each input line
	}
	//New Functionality END

	
	//Search keggPathway
	public void searchUcscRefSeqGenes(String chromName, BufferedReader bufferedReader, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,BufferedWriter> bufferedWriterHashMap, Map<String,List<String>> geneId2KeggPathwayMap, List<String> keggPathwayNameList, Map<String,Integer> keggPathway2KMap, String type,String keggPathwayAnalysisType){
		String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				
				Map<String,Integer> keggPathway2OneorZeroMap = new HashMap<String,Integer>();				
				
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//				indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);

				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,bufferedWriterHashMap, geneId2KeggPathwayMap, keggPathwayNameList, keggPathway2OneorZeroMap,type,keggPathwayAnalysisType);
				}
				
				
				//accumulate search results of keggPathway2OneorZeroMap in keggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: keggPathway2OneorZeroMap.entrySet()){
					 
					if (keggPathway2KMap.get(zeroOrOne.getKey())==null){
						keggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						keggPathway2KMap.put(zeroOrOne.getKey(), keggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // End of while 
	}

	
	
	

	public void searchUcscRefSeqGenes(String chromName, BufferedReader bufferedReader, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,BufferedWriter> bufferedWriterHashMap, Map<String,Integer> nameorIdHashMap, String type){
		String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//				indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);
//				todo
//				bufferedWriter.write("Searched for" + "\t" + chromName + "\t" + low + "\t" + high + System.getProperty("line.separator"));
//				bufferedWriter.flush();				
				ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,bufferedWriterHashMap,nameorIdHashMap,type);
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // End of while 
	}
	
	

	

	public BufferedReader createBufferedReader(String outputFolder, String fileName){
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(outputFolder + fileName);
			bufferedReader = new BufferedReader(fileReader);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return bufferedReader;
	}
	
	
	public void fillList(List<String> list, String dataFolder, String inputFileName){
		String strLine;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(dataFolder + inputFileName);			
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine = bufferedReader.readLine())!=null) {			
				list.add(strLine);
				strLine = null;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}

	
	public static void fillHashMap(Map<String,Integer> hashMap, String inputFileName){
		String strLine;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(inputFileName);			
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine = bufferedReader.readLine())!=null) {
				hashMap.put(strLine, Commons.ZERO);
				
				strLine = null;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	public void writeResults(Map<String,Integer> hashMap, String outputFolder, String outputFileName){
		FileWriter fileWriter;
		BufferedWriter  bufferedWriter;
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder + outputFileName);
			bufferedWriter = new BufferedWriter(fileWriter);	
			
			for (Map.Entry<String, Integer> entry: hashMap.entrySet()){
				bufferedWriter.write(entry.getKey() + "\t" + entry.getValue() + System.getProperty("line.separator"));
			}
						
			bufferedWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void closeBufferedWriterList(List<BufferedWriter> bufferedWriterList){
		BufferedWriter bufferedWriter = null;
		try {			
			for(int i = 0; i<bufferedWriterList.size(); i++){			
				bufferedWriter = bufferedWriterList.get(i);				
				bufferedWriter.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	

	
	
	
	public void searchDnase(String dataFolder,String outputFolder, List<String> dnaseCellLineNameList, Map<String,Integer> dnaseCellLine2KMap, int overlapDefinition) {
		
		BufferedReader bufferedReader =null ;
				
		IntervalTree dnaseIntervalTree;
			
		Map<String,BufferedWriter> dnaseBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME1,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
					searchDnase(outputFolder,Commons.CHROMOSOME1,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList, dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());				
					dnaseIntervalTree = null;
			
					break;
				case 2:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME2,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME2,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());	
					dnaseIntervalTree = null;
					
					break;
				case 3:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME3,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME3,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;

					break;
				case 4:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME4,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME4,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;		
					
					break;
				case 5:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME5,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME5,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;

				
					break;
				case 6:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME6,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME6,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
			
					
					break;
				case 7:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME7,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME7,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					break;
				case 8:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME8,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME8,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 9	:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME9,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME9,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;

					break;
				case 10:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME10,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME10,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());	
					dnaseIntervalTree = null;
				
					break;
				case 11:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME11,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME11,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
	
					
					break;
				case 12:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME12,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME12,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
	
					break;
				case 13:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME13,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME13,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 14:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME14,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME14,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 15:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME15,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME15,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 16:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME16,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME16,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 17:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME17,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME17,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					break;
				case 18:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME18,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME18,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
						
					break;
				case 19:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME19,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME19,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 20:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME20,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME20,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					
					break;
				case 21:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME21,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME21,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					break;
				case 22:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOME22,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOME22,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					
					break;
				case 23:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOMEX,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOMEX,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 24:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, Commons.CHROMOSOMEY,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
					searchDnase(outputFolder, Commons.CHROMOSOMEY,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
					
				}//end of Swicth
		}//end of For
		
		closeBufferedWriters(dnaseBufferedWriterHashMap);	
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//New Functionality START
	//Which cell line does not matter.
	public void searchTfandKeggPathway(String dataFolder, String outputFolder, List<String> tfNameList, List<String> keggPathwayNameList, Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> tfbsNameandCellLineName2KMap, Map<String,Integer> exonBasedKeggPathway2KMap, Map<String,Integer> regulationBasedKeggPathway2KMap, Map<String,Integer> allBasedKeggPathway2KMap, Map<String,Integer> tfCellLineExonBasedKeggPathway2KMap,Map<String,Integer> tfCellLineRegulationBasedKeggPathway2KMap,Map<String,Integer> tfCellLineAllBasedKeggPathway2KMap, Map<String,Integer> tfExonBasedKeggPathway2KMap, Map<String,Integer> tfRegulationBasedKeggPathway2KMap, Map<String,Integer> tfAllBasedKeggPathway2KMap,int overlapDefinition){
		BufferedReader bufferedReader =null ;
		
		IntervalTree tfbsIntervalTree;
		IntervalTree ucscRefSeqGenesIntervalTree;
		
		Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		
		//In order to write the results of common overlaps of tfCellLine and kegg pathway for the same given query
		Map<String,BufferedWriter>  tfCellLineExonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>();
		Map<String,BufferedWriter>  tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		Map<String,BufferedWriter>  tfCellLineAllBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>();
		
		//In order to write the results of common overlaps of tf and kegg pathway for the same given query
		Map<String,BufferedWriter>  tfExonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>();
		Map<String,BufferedWriter>  tfRegulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		Map<String,BufferedWriter>  tfAllBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>();
	
		
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME1,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME1);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME1,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
						
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;
					
				case 2:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME2,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME2);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME2,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 3:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME3,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME3);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME3,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
				
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 4:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME4,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME4);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME4,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 5:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME5,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME5);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME5,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 6:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME6,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME6);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME6,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 7:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME7,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME7);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME7,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 8:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME8,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME8);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME8,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 9:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME9,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME9);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME9,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
				
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 10:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME10,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME10);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME10,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 11:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME11,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME11);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME11,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 12:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME12,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME12);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME12,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 13:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME13,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME13);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME13,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 14:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME14,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME14);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME14,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 15:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME15,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME15);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME15,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 16:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME16,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME16);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME16,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 17:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME17,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME17);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME17,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 18:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME18,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME18);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME18,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 19:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME19,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME19);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME19,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 20:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME20,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME20);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME20,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 21:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME21,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME21);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME21,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 22:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME22,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME22);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOME22,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 23:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEX,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEX);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOMEX,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 24:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEY,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEY);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,Commons.CHROMOSOMEY,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
			} // End of Switch
		}//End of FOR all chromosomes
					
		
		closeBufferedWriters(tfbsBufferedWriterHashMap);
		
		closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
		closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
		closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);
		
		closeBufferedWriters(tfExonBasedKeggPathwayBufferedWriterHashMap);
		closeBufferedWriters(tfRegulationBasedKeggPathwayBufferedWriterHashMap);
		closeBufferedWriters(tfAllBasedKeggPathwayBufferedWriterHashMap);
			
		closeBufferedWriters(tfCellLineExonBasedKeggPathwayBufferedWriterHashMap);
		closeBufferedWriters(tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap);
		closeBufferedWriters(tfCellLineAllBasedKeggPathwayBufferedWriterHashMap);
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	//New Functionality END
	
	public void searchTfbs(String dataFolder,String outputFolder, List<String> tfbsNameList, Map<String,Integer> tfbsNameandCellLineName2KMap) {
		
		BufferedReader bufferedReader =null ;
				
		IntervalTree tfbsIntervalTree;
		
		Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME1,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
					searchTfbs(Commons.CHROMOSOME1,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					
					break;
				case 2:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME2,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
					searchTfbs(Commons.CHROMOSOME2,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					break;
				case 3:							
	
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME3,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
					searchTfbs(Commons.CHROMOSOME3,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					break;
				case 4:							
			
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME4,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
					searchTfbs(Commons.CHROMOSOME4,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					
					break;
				case 5:							

					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME5,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
					searchTfbs(Commons.CHROMOSOME5,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
	
					break;
				case 6:							
	
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME6,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
					searchTfbs(Commons.CHROMOSOME6,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					break;
				case 7:							

					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME7,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
					searchTfbs(Commons.CHROMOSOME7,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					
					break;
				case 8:							
														
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME8,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
					searchTfbs(Commons.CHROMOSOME8,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					
					break;
				case 9	:							
	
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME9,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
					searchTfbs(Commons.CHROMOSOME9,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					break;
				case 10:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME10,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
					searchTfbs(Commons.CHROMOSOME10,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					
					break;
				case 11:							
						
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME11,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
					searchTfbs(Commons.CHROMOSOME11,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;


					
					break;
				case 12:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME12,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
					searchTfbs(Commons.CHROMOSOME12,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					break;
				case 13:							
				
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME13,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
					searchTfbs(Commons.CHROMOSOME13,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					
					break;
				case 14:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME14,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
					searchTfbs(Commons.CHROMOSOME14,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					
					break;
				case 15:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME15,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
					searchTfbs(Commons.CHROMOSOME15,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

				
					break;
				case 16:							
				
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME16,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
					searchTfbs(Commons.CHROMOSOME16,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;


					break;
				case 17:							
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME17,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
					searchTfbs(Commons.CHROMOSOME17,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					
					break;
				case 18:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME18,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
					searchTfbs(Commons.CHROMOSOME18,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					break;
				case 19:							
						
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME19,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
					searchTfbs(Commons.CHROMOSOME19,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					
					break;
				case 20:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME20,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
					searchTfbs(Commons.CHROMOSOME20,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					
					break;
				case 21:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME21,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
					searchTfbs(Commons.CHROMOSOME21,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					
					break;
				case 22:							
				
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME22,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
					searchTfbs(Commons.CHROMOSOME22,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
				
					break;
				case 23:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEX,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
					searchTfbs(Commons.CHROMOSOMEX,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
						
					break;
				case 24:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEY,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
					searchTfbs(Commons.CHROMOSOMEY,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					
					break;
					
				}//end of Swicth
		}//end of For
		
		closeBufferedWriters(tfbsBufferedWriterHashMap);
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void searchHistone(String dataFolder,String outputFolder, List<String> histoneNameList, Map<String,Integer> histoneNameandCellLineName2KMap,int overlapDefinition) {
		
		BufferedReader bufferedReader =null ;
				
		IntervalTree histoneIntervalTree;
		
		Map<String,BufferedWriter> histoneBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 				
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
		
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME1,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME1,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 2:							
					
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME2,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME2,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
						break;
				case 3:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME3,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME3,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

						break;
				case 4:							
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME4,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME4,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 5:							
				
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME5,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME5,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

					break;
				case 6:							
					
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME6,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME6,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 7:							
				
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME7,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME7,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 8:							
				
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME8,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME8,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 9	:							
		
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME9,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME9,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

					break;
				case 10:							
		
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME10,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME10,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 11:							
		
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME11,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME11,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

					
					break;
				case 12:							
	
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME12,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME12,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

					break;
				case 13:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME13,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME13,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 14:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME14,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME14,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 15:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME15,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME15,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 16:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME16,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME16,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					

					break;
				case 17:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME17,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME17,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 18:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME18,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME18,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 19:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME19,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME19,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 20:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME20,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME20,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 21:							
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME21,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME21,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 22:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOME22,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOME22,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 23:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOMEX,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOMEX,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 24:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,Commons.CHROMOSOMEY,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
					searchHistone(outputFolder,Commons.CHROMOSOMEY,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
					
				}//end of Swicth
		}//end of For
		
		closeBufferedWriters(histoneBufferedWriterHashMap);
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


public void searchNcbiGeneId(String outputFolder, Map<String,Integer> ncbiGeneIdHashMap) {
		
		BufferedReader bufferedReader =null ;
				
		IntervalTree geneIntervalTree;
		
		Map<String,BufferedWriter> ncbiGeneIdBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME1);

					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME1,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
										
					emptyIntervalTree(geneIntervalTree.getRoot());
					geneIntervalTree = null;
					System.out.println("Chr1 NcbiGeneId");
					break;
				case 2:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME2);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME2,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());
					geneIntervalTree = null;
					System.out.println("Chr2 NcbiGeneId");

					break;
				case 3:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME3);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME3,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());
					geneIntervalTree = null;
					System.out.println("Chr3  NcbiGeneId");

					break;
				case 4:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME4);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME4,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr4  NcbiGeneId");

					break;
				case 5:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME5);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME5,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr5 NcbiGeneId");

					break;
				case 6:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME6);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME6,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr6 NcbiGeneId");

					break;
				case 7:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME7);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME7,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr7 NcbiGeneId");

					break;
				case 8:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME8);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME8,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr8 NcbiGeneId");

					break;
				case 9	:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME9);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME9,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr9 NcbiGeneId");

					break;
				case 10:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME10);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME10,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr10 NcbiGeneId");

					break;
				case 11:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME11);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME11,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr11 NcbiGeneId");
					
					break;
				case 12:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME12);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME12,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr12 NcbiGeneId");

					break;
				case 13:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME13);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME13,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr13 NcbiGeneId");

					break;
				case 14:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME14);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME14,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr14 NcbiGeneId");

					break;
				case 15:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME15);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME15,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr15 NcbiGeneId");

					break;
				case 16:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME16);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME16,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr16 NcbiGeneId");

					break;
				case 17:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME17);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME17,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);

					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr17 NcbiGeneId");

					break;
				case 18:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME18);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME18,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr18 NcbiGeneId");

					break;
				case 19:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME19);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME19,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr19 NcbiGeneId");

					break;
				case 20:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME20);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME20,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr20 NcbiGeneId");

					break;
				case 21:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME21);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME21,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr21 NcbiGeneId");

					break;
				case 22:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME22);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOME22,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr22 NcbiGeneId");
					
					break;
				case 23:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOMEX);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOMEX,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr23 NcbiGeneId");

					break;
				case 24:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOMEY);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
					searchUcscRefSeqGenes(Commons.CHROMOSOMEY,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);

					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					System.out.println("Chr24 NcbiGeneId");
			
					break;
					
				}//end of Swicth
		}//end of For
		
		closeBufferedWriters(ncbiGeneIdBufferedWriterHashMap);
	
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




public void searchNcbiRNANucleotideAccessionVersion(String outputFolder,Map<String,Integer> ncbiRnaNucleotideAccessionVersionHashMap) {
	
	BufferedReader bufferedReader =null ;
			
	IntervalTree geneIntervalTree;
	
	Map<String,BufferedWriter> ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
	
	
	for(int i = 1; i<=24 ; i++ ){
		
		switch(i){
			case 1:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME1);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY  + "search_chr1_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME1,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				System.out.println("Chr1 NcbiRNA");
				break;
			case 2:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME2);

				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME2,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				System.out.println("Chr2 NcbiRNA");

				break;
			case 3:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME3);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME3,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				System.out.println("Chr3 NcbiRNA");

				break;
			case 4:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME4);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME4,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr4 NcbiRNA");

				break;
			case 5:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME5);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME5,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr5 NcbiRNA");

				break;
			case 6:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME6);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME6,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr6 NcbiRNA");

				break;
			case 7:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME7);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME7,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr7 NcbiRNA");

				break;
			case 8:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME8);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME8,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr8 NcbiRNA");

				break;
			case 9	:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME9);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME9,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr9 NcbiRNA");

				break;
			case 10:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME10);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME10,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr10 NcbiRNA");

				break;
			case 11:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME11);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME11,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr11 NcbiRNA");
				
				break;
			case 12:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME12);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME12,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr12 NcbiRNA");

				break;
			case 13:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME13);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME13,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr13 NcbiRNA");

				break;
			case 14:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME14);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME14,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr14 NcbiRNA");

				break;
			case 15:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME15);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME15,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr15 NcbiRNA");

				break;
			case 16:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME16);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME16,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr16 NcbiRNA");

				break;
			case 17:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME17);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME17,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr17 NcbiRNA");

				break;
			case 18:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME18);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME18,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr18 NcbiRNA");

				break;
			case 19:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME19);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME19,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr19 NcbiRNA");

				break;
			case 20:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME20);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME20,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr20 NcbiRNA");

				break;
			case 21:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME21);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME21,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr21 NcbiRNA");

				break;
			case 22:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME22);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME22,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr22 NcbiRNA");
				
				break;
			case 23:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOMEX);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOMEX,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr23 NcbiRNA");

				break;
			case 24:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOMEY);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOMEY,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr24 NcbiRNA");
		
				break;
				
			}//end of Swicth
	}//end of For
	
	closeBufferedWriters(ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap);
	
	try {
		bufferedReader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}


public void searchUcscGeneAlternateName(String outputFolder, Map<String,Integer>  ucscGeneAlternateNameHashMap) {
	
	BufferedReader bufferedReader =null ;
			
	IntervalTree geneIntervalTree;
	
	Map<String,BufferedWriter> ucscGeneAlternateNameBufferedWriterHashMap = new HashMap<String,BufferedWriter>();		
	
	
	for(int i = 1; i<=24 ; i++ ){
		
		switch(i){
			case 1:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME1);

				bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME1,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				System.out.println("Chr1 UcscGeneAlternateName");
				break;
			case 2:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME2);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME2,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
									
				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				System.out.println("Chr2 UcscGeneAlternateName");

				break;
			case 3:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME3);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME3,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				System.out.println("Chr3 UcscGeneAlternateName");

				break;
			case 4:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME4);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME4,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr4 UcscGeneAlternateName");

				break;
			case 5:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME5);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME5,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
									
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr5 UcscGeneAlternateName");

				break;
			case 6:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME6);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME6,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr6 UcscGeneAlternateName");

				break;
			case 7:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME7);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME7,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr7 UcscGeneAlternateName");

				break;
			case 8:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME8);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME8,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr8 UcscGeneAlternateName");

				break;
			case 9	:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME9);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME9,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr9 UcscGeneAlternateName");

				break;
			case 10:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME10);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME10,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr10 UcscGeneAlternateName");

				break;
			case 11:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME11);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME11,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr11 UcscGeneAlternateName");
				
				break;
			case 12:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME12);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME12,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr12 UcscGeneAlternateName");

				break;
			case 13:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME13);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME13,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr13 UcscGeneAlternateName");

				break;
			case 14:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME14);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME14,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr14 UcscGeneAlternateName");

				break;
			case 15:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME15);
				
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME15,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr15 UcscGeneAlternateName");

				break;
			case 16:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME16);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME16,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr16 UcscGeneAlternateName");

				break;
			case 17:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME17);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME17,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr17 UcscGeneAlternateName");

				break;
			case 18:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME18);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME18,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr18 UcscGeneAlternateName");

				break;
			case 19:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME19);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME19,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
									
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr19 UcscGeneAlternateName");

				break;
			case 20:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME20);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME20,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr20 UcscGeneAlternateName");

				break;
			case 21:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME21);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME21,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
									
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr21 UcscGeneAlternateName");

				break;
			case 22:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME22);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME22,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr22 UcscGeneAlternateName");
				
				break;
			case 23:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOMEX);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOMEX,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr23 UcscGeneAlternateName");

				break;
			case 24:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOMEY);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOMEY,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				System.out.println("Chr24 UcscGeneAlternateName");
		
				break;
				
			}//end of Swicth
	}//end of For
	
	closeBufferedWriters(ucscGeneAlternateNameBufferedWriterHashMap);
	
	try {
		bufferedReader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}



public void searchKeggPathway(String dataFolder,String outputFolder,Map<String,List<String>> geneId2KeggPathwayMap,List<String> keggPathwayNameList, Map<String,Integer> keggPathway2KMap, String keggPathwayAnalysisType) {
	
	BufferedReader bufferedReader =null ;
			
	IntervalTree geneIntervalTree;
	
	Map<String,BufferedWriter> keggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>();
	
	
	for(int i = 1; i<=24 ; i++ ){
		
		switch(i){
			case 1:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME1);

				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME1,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				break;
			case 2:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME2);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME2,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
					
				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				break;
			case 3:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME3);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME3,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				break;
			case 4:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME4);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME4,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 5:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME5);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME5,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 6:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME6);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME6,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 7:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME7);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME7,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 8:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME8);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME8,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 9	:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME9);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME9,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 10:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME10);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME10,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 11:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME11);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME11,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 12:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME12);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME12,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 13:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME13);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME13,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 14:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME14);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME14,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 15:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME15);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME15,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 16:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME16);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME16,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 17:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME17);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME17,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 18:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME18);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME18,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 19:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME19);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME19,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 20:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME20);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME20,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 21:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME21);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME21,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 22:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME22);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOME22,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 23:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEX);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOMEX,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
					
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 24:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEY);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
				searchUcscRefSeqGenes(Commons.CHROMOSOMEY,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
				
			}//end of Swicth
	}//end of For
	
	closeBufferedWriters(keggPathwayBufferedWriterHashMap);
	
	try {
		bufferedReader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}


	public void emptyIntervalTree(IntervalTreeNode node){
		if(node!=null){
			emptyIntervalTree(node.getRight());
			emptyIntervalTree(node.getLeft());
			
//			if(node.getCellLineName()!=null){
//				node.setCellLineName(null);
//			}
//			
//			if(node.getFileName()!=null){
//				node.setFileName(null);
//			}
//			
//			if(node.getTfbsorHistoneName()!=null){
//				node.setTfbsorHistoneName(null);
//			}
//			
//			if(node.getGeneHugoSymbol()!=null){
//				node.setGeneHugoSymbol(null);
//			}
//			
//			if(node.getIntervalName()!=null){
//				node.setIntervalName(null);
//			}
//			
//			if(node.getGeneEntrezId()!=null){
//				node.setGeneEntrezId(null);
//			}
//			
//			if(node.getRefSeqGeneName()!=null){
//				node.setRefSeqGeneName(null);
//			}
			
			if(node.getChromName()!=null){
				node.setChromName(null);
			}
			
			if (node.getLeft()!=null) {
				node.setLeft(null);
			}

			if (node.getRight()!=null) {
				node.setRight(null);
			}

			if (node.getParent()!=null) {
				node.setParent(null);
			}

			node = null;
		}		
	}
	
	//Empirical P Value Calculation
	//args[0] must have input file name with folder
	//args[1] must have GLANET output folder
	//args[2] must have GLANET data folder (necessary data for annotation and augmentation)
	//args[3] must have Input File Format		
	public AllName2KMaps annotateOriginalData(String[] args){
		
		String outputFolder = args[1];
		String dataFolder = args[2];
		int overlapDefinition = Integer.parseInt(args[3]);
		
		String inputFileName = outputFolder + Commons.REMOVED_OVERLAPS_INPUT_FILE;
		
		AllName2KMaps allName2KMaps = new AllName2KMaps();
		
		//Prepare chromosome based partitioned input interval files to be searched for
		List<BufferedWriter> bufferedWriterList = new ArrayList<BufferedWriter>();	
		//Create Buffered Writers for writing chromosome based input files
		createChromBaseSeachInputFiles(outputFolder,bufferedWriterList);

		//Partition the input file into 24 chromosome based input files
		partitionSearchInputFilePerChromName(inputFileName,bufferedWriterList);
			
		//Close Buffered Writers
		closeBufferedWriterList(bufferedWriterList);	
		
		//DNASE
		//Search input interval files for dnase 
		List<String> dnaseCellLineNameList = new ArrayList<String>();	
		//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
		Map<String,Integer> dnaseCellLine2KMap = new HashMap<String,Integer>();		
		
		fillList(dnaseCellLineNameList,dataFolder , Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_CELL_LINE_NAMES_OUTPUT_FILENAME);		
		searchDnase(dataFolder,outputFolder,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);	
		writeResults(dnaseCellLine2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_DNASE_RESULTS_GIVEN_SEARCH_INPUT);
		allName2KMaps.setDnaseCellLineName2NumberofOverlapsMap(dnaseCellLine2KMap);
		
		//TFBS
		//Search input interval files for tfbs 		
		List<String> tfbsNameList = new ArrayList<String>();
		//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
		Map<String,Integer> tfbsNameandCellLineName2KMap = new HashMap<String,Integer>();	
		
		fillList(tfbsNameList,dataFolder , Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_TF_NAMES_OUTPUT_FILENAME);		
		searchTfbs(dataFolder,outputFolder,tfbsNameList,tfbsNameandCellLineName2KMap);		
		writeResults(tfbsNameandCellLineName2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_TF_RESULTS_GIVEN_SEARCH_INPUT);
		allName2KMaps.setTfbsNameandCellLineName2NumberofOverlapsMap(tfbsNameandCellLineName2KMap);

		//HISTONE
		//Search input interval files for histone 		
		List<String> histoneNameList = new ArrayList<String>();		
		//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
		Map<String,Integer> histoneNameandCellLineName2KMap = new HashMap<String,Integer>();	
			
		fillList(histoneNameList,dataFolder ,Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_HISTONE_NAMES_OUTPUT_FILENAME);
		searchHistone(dataFolder,outputFolder,histoneNameList,histoneNameandCellLineName2KMap,overlapDefinition);
		writeResults(histoneNameandCellLineName2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_HISTONE_RESULTS_GIVEN_SEARCH_INPUT);
		allName2KMaps.setHistoneNameandCellLineName2NumberofOverlapsMap(histoneNameandCellLineName2KMap);
		
		
		//KEGG PATHWAY
		//Search input interval files for kegg Pathway
		List<String> keggPathwayNameList = new ArrayList<String>();
				
		//Fill keggPathwayNameList
		fillList(keggPathwayNameList,dataFolder , Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_KEGG_PATHWAY_NAMES_OUTPUT_FILENAME);
		
		Map<String,List<String>> geneId2KeggPathwayMap = new HashMap<String, List<String>>();
		KeggPathwayUtility.createNcbiGeneId2KeggPathwayMap(dataFolder, Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE, geneId2KeggPathwayMap);
		
		//Exon Based Kegg Pathway Analysis
		//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
		Map<String,Integer> exonBasedKeggPathway2KMap = new HashMap<String,Integer>();
				
		searchKeggPathway(dataFolder,outputFolder,geneId2KeggPathwayMap,keggPathwayNameList, exonBasedKeggPathway2KMap, Commons.EXON_BASED_KEGG_PATHWAY_ANALYSIS);
		writeResults(exonBasedKeggPathway2KMap, outputFolder,Commons.ANNOTATE_INTERVALS_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		allName2KMaps.setExonBasedKeggPathway2NumberofOverlapsMap(exonBasedKeggPathway2KMap);
		
		
		//Regulation Based Kegg Pathway Analysis
		//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
		Map<String,Integer> regulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
				
		searchKeggPathway(dataFolder,outputFolder,geneId2KeggPathwayMap,keggPathwayNameList, regulationBasedKeggPathway2KMap, Commons.REGULATION_BASED_KEGG_PATHWAY_ANALYSIS);
		writeResults(regulationBasedKeggPathway2KMap, outputFolder , Commons.ANNOTATE_INTERVALS_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		allName2KMaps.setRegulationBasedKeggPathway2NumberofOverlapsMap(regulationBasedKeggPathway2KMap);
		
		//All results Kegg Pathway Analysis
		//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
		Map<String,Integer> allResultsKeggPathway2KMap = new HashMap<String,Integer>();
						
		searchKeggPathway(dataFolder,outputFolder, geneId2KeggPathwayMap,keggPathwayNameList, allResultsKeggPathway2KMap, Commons.ALL_BASED_KEGG_PATHWAY_ANALYSIS);
		writeResults(allResultsKeggPathway2KMap, outputFolder , Commons.ANNOTATE_INTERVALS_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		
		return allName2KMaps;
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
	public void annotate(String[] args){
		
		String glanetFolder = args[1];
		String dataFolder 	= glanetFolder + System.getProperty("file.separator") + Commons.DATA + System.getProperty("file.separator") ;
		String outputFolder = glanetFolder + System.getProperty("file.separator") + Commons.OUTPUT + System.getProperty("file.separator") ;
		
		int overlapDefinition = Integer.parseInt(args[3]);
		
		String inputFileName = outputFolder + Commons.REMOVED_OVERLAPS_INPUT_FILE;
		
		/*********************************************/
		//delete old files
		String annotateOutputBaseDirectoryName = outputFolder + Commons.ANNOTATION;
		List<String> notToBeDeleted = new ArrayList<String>();
		
		FileOperations.deleteDirectoriesandFilesUnderThisDirectory(annotateOutputBaseDirectoryName,notToBeDeleted);
		/*********************************************/
		
		/*********************************************/
		//Prepare chromosome based partitioned input interval files to be searched for
		List<BufferedWriter> bufferedWriterList = new ArrayList<BufferedWriter>();	
		//Create Buffered Writers for writing chromosome based input files
		createChromBaseSeachInputFiles(outputFolder,bufferedWriterList);

		//Partition the input file into 24 chromosome based input files
		partitionSearchInputFilePerChromName(inputFileName,bufferedWriterList);
			
		//Close Buffered Writers
		closeBufferedWriterList(bufferedWriterList);	
		/*********************************************/
		
		/*********************************************/
		//DNASE
		//Search input interval files for dnase 
		List<String> dnaseCellLineNameList = new ArrayList<String>();	
		//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
		Map<String,Integer> dnaseCellLine2KMap = new HashMap<String,Integer>();		
		
		fillList(dnaseCellLineNameList,dataFolder, Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_CELL_LINE_NAMES_OUTPUT_FILENAME);		
		searchDnase(dataFolder,outputFolder, dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);	
		writeResults(dnaseCellLine2KMap, outputFolder , Commons.ANNOTATE_INTERVALS_DNASE_RESULTS_GIVEN_SEARCH_INPUT);
		System.out.println("DNASE analysis ends.");
		/*********************************************/
		

//		Accomplished in NEW FUNCTIONALITY ---TF and Kegg Pathway Analysis
//		//TFBS
//		//Search input interval files for tfbs 		
//		List<String> tfbsNameList = new ArrayList<String>();
//		//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
//		Map<String,Integer> tfbsNameandCellLineName2KMap = new HashMap<String,Integer>();	
//		
//		fillList(tfbsNameList,Commons.WRITE_ALL_POSSIBLE_TFBS_NAMES_OUTPUT_FILE);		
//		searchTfbs(tfbsNameList,tfbsNameandCellLineName2KMap);		
//		writeResults(tfbsNameandCellLineName2KMap, Commons.ANNOTATE_INTERVALS_TFBS_RESULTS_GIVEN_SEARCH_INPUT);

		/*********************************************/
		//HISTONE
		//Search input interval files for histone 		
		List<String> histoneNameList = new ArrayList<String>();		
		//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
		Map<String,Integer> histoneNameandCellLineName2KMap = new HashMap<String,Integer>();	
			
		fillList(histoneNameList,dataFolder , Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_HISTONE_NAMES_OUTPUT_FILENAME);
		searchHistone(dataFolder,outputFolder,histoneNameList,histoneNameandCellLineName2KMap,overlapDefinition);
		writeResults(histoneNameandCellLineName2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_HISTONE_RESULTS_GIVEN_SEARCH_INPUT);
		System.out.println("Histone analysis ends.");
		/*********************************************/
		
		
//		//search input interval files for ncbiGeneId		
//		Map<String,Integer> ncbiGeneIdHashMap = new HashMap<String,Integer>();		
//		annotateIntervals.fillHashMap(ncbiGeneIdHashMap,Commons.ANNOTATE_INTERVALS_WITH_NCBI_GENE_ID_USING_INTERVAL_TREE_INPUT_FILE);		
//		annotateIntervals.searchNcbiGeneId(ncbiGeneIdHashMap);
//		annotateIntervals.writeResults(Commons.NCBI_GENE_ID, ncbiGeneIdHashMap, Commons.ANNOTATE_INTERVALS_NCBI_GENE_ID_RESULTS_OUTPUT_FILE);
//		//Free space
//		ncbiGeneIdHashMap.clear();
//		ncbiGeneIdHashMap = null;
//		
//		//ncbiRna		
//		Map<String,Integer> ncbiRnaNucleotideAccessionVersionHashMap = new HashMap<String,Integer>();
//		annotateIntervals.fillHashMap(ncbiRnaNucleotideAccessionVersionHashMap,Commons.ANNOTATE_INTERVALS_WITH_NCBI_RNA_USING_INTERVAL_TREE_INPUT_FILE);
//		annotateIntervals.searchNcbiRNANucleotideAccessionVersion(ncbiRnaNucleotideAccessionVersionHashMap);
//		annotateIntervals.writeResults(Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION, ncbiRnaNucleotideAccessionVersionHashMap, Commons.ANNOTATE_INTERVALS_NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION_RESULTS_OUTPUT_FILE);
//		//Free space
//		ncbiRnaNucleotideAccessionVersionHashMap.clear();
//		ncbiRnaNucleotideAccessionVersionHashMap = null;
//		
//		//ucscGeneAlternateName
//		Map<String,Integer> ucscGeneAlternateNameHashMap = new HashMap<String,Integer>();
//		annotateIntervals.fillHashMap(ucscGeneAlternateNameHashMap,Commons.ANNOTATE_INTERVALS_WITH_UCSC_ALTERNATE_GENE_NAME_USING_INTERVAL_TREE_INPUT_FILE);			
//		annotateIntervals.searchUcscGeneAlternateName(ucscGeneAlternateNameHashMap);
//		annotateIntervals.writeResults(Commons.UCSC_GENE_ALTERNATE_NAME, ucscGeneAlternateNameHashMap, Commons.ANNOTATE_INTERVALS_UCSC_GENE_ALTERNATE_NAME_RESULTS_OUTPUT_FILE);
//		//Free space
//		ucscGeneAlternateNameHashMap.clear();
//		ucscGeneAlternateNameHashMap= null;
//		
		
//		Accomplished in NEW FUNCTIONALITY ---TF and Kegg Pathway	
//		//KEGG PATHWAY
//		//Search input interval files for kegg Pathway
//		List<String> keggPathwayNameList = new ArrayList<String>();
//				
//		//Fill keggPathwayNameList
//		fillList(keggPathwayNameList, Commons.WRITE_ALL_POSSIBLE_KEGG_PATHWAY_NAMES_OUTPUT_FILE);
//		
//		Map<String,List<String>> geneId2KeggPathwayMap = new HashMap<String, List<String>>();
//				
//		KeggPathwayUtility.createNcbiGeneId2KeggPathwayMap(Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE,geneId2KeggPathwayMap);
//		
//		//Exon Based Kegg Pathway Analysis
//		//Only Exons
//		//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
//		Map<String,Integer> exonBasedKeggPathway2KMap = new HashMap<String,Integer>();
//				
//		searchKeggPathway(geneId2KeggPathwayMap,keggPathwayNameList, exonBasedKeggPathway2KMap, Commons.EXON_BASED_KEGG_PATHWAY_ANALYSIS);
//		writeResults(exonBasedKeggPathway2KMap, Commons.ANNOTATE_INTERVALS_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
//		
//		
//		//Regulation Based Kegg Pathway Analysis
//		//Introns, 5p1 5p2 3p1 3p2 included
//		//5d and 3d excluded 
//		//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
//		Map<String,Integer> regulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
//				
//		searchKeggPathway(geneId2KeggPathwayMap,keggPathwayNameList, regulationBasedKeggPathway2KMap, Commons.REGULATION_BASED_KEGG_PATHWAY_ANALYSIS);
//		writeResults(regulationBasedKeggPathway2KMap, Commons.ANNOTATE_INTERVALS_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
//		
//		//All Based Kegg Pathway Analysis
//		//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n
//		//exons, introns, 5p1, 5p2, 5d, 3p1, 3p2, 3d all included
//		Map<String,Integer> allResultsKeggPathway2KMap = new HashMap<String,Integer>();
//						
//		searchKeggPathway(geneId2KeggPathwayMap,keggPathwayNameList, allResultsKeggPathway2KMap, Commons.ALL_BASED_KEGG_PATHWAY_ANALYSIS);
//		writeResults(allResultsKeggPathway2KMap, Commons.ANNOTATE_INTERVALS_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		
		/*********************************************/
		//New Functionality START
		//Search for tf here
		//Search for kegg pathway here
		//Search for tf and kegg pathway here
		//This tfbsCellLineKeggPathway2KMap hash map will contain the tfbs cell line and Kegg Pathway name to number of tfbs cell Line and Kegg Pathway :k for the given search input size:n
	
		//For TF
		List<String> tfbsNameList = new ArrayList<String>();
		//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
		fillList(tfbsNameList,dataFolder , Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_TF_NAMES_OUTPUT_FILENAME);		
		Map<String,Integer> tfCellLine2KMap = new HashMap<String,Integer>();	
		
		//For Kegg Pathway
		List<String> keggPathwayNameList = new ArrayList<String>();
		//Fill keggPathwayNameList
		fillList(keggPathwayNameList, dataFolder , Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME +Commons.WRITE_ALL_POSSIBLE_KEGG_PATHWAY_NAMES_OUTPUT_FILENAME );
		Map<String,List<String>> geneId2KeggPathwayMap = new HashMap<String, List<String>>();
		KeggPathwayUtility.createNcbiGeneId2KeggPathwayMap(dataFolder, Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE, geneId2KeggPathwayMap);
		Map<String,Integer> exonBasedKeggPathway2KMap = new HashMap<String,Integer>();
		Map<String,Integer> regulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
		Map<String,Integer> allBasedKeggPathway2KMap = new HashMap<String,Integer>();
		
		//For TF and CellLine and KeggPathway
		Map<String,Integer> tfCellLineExonBasedKeggPathway2KMap = new HashMap<String,Integer>();
		Map<String,Integer> tfCellLineRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
		Map<String,Integer> tfCellLineAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
		
		//New
		//For TF and KeggPathway
		Map<String,Integer> tfExonBasedKeggPathway2KMap = new HashMap<String,Integer>();
		Map<String,Integer> tfRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
		Map<String,Integer> tfAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			
		searchTfandKeggPathway(dataFolder,outputFolder,tfbsNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfCellLine2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap, overlapDefinition);
		
		writeResults(tfCellLine2KMap, outputFolder , Commons.ANNOTATE_INTERVALS_TF_RESULTS_GIVEN_SEARCH_INPUT);
		
		writeResults(exonBasedKeggPathway2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		writeResults(regulationBasedKeggPathway2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		writeResults(allBasedKeggPathway2KMap,  outputFolder, Commons.ANNOTATE_INTERVALS_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		
		writeResults(tfCellLineExonBasedKeggPathway2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		writeResults(tfCellLineRegulationBasedKeggPathway2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		writeResults(tfCellLineAllBasedKeggPathway2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		
		writeResults(tfExonBasedKeggPathway2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_TF_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		writeResults(tfRegulationBasedKeggPathway2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		writeResults(tfAllBasedKeggPathway2KMap, outputFolder,Commons.ANNOTATE_INTERVALS_TF_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		
		System.out.println("TF analysis ends, Kegg Pathway analysis ends, Tf_CellLine_KeggPathway analysis ends, Tf_KeggPathway analysis ends.");
		//New Functionality END
		/*********************************************/
		

	}
	
	//Empirical P Value Calculation
	//ExecutorService
	public AllMaps annotatPermutation(String dataFolder,Integer permutationNumber, String chrName, List<InputLine> inputLines,IntervalTree dnaseIntervalTree,IntervalTree tfbsIntervalTree,IntervalTree histoneIntervalTree,IntervalTree ucscRefSeqGeneIntervalTree){
		AllMaps allMaps = new AllMaps();
		
		//DNASE
		//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
		Map<String,Integer> dnaseCellLine2KMap = new HashMap<String,Integer>();		
//		Map<String,BufferedWriter> dnaseBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
//		searchDnase(permutationNumber,chrName,inputLines, dnaseIntervalTree, dnaseBufferedWriterHashMap, dnaseCellLine2KMap);
		allMaps.setPermutationNumberDnaseCellLineName2KMap(dnaseCellLine2KMap);
		
		//TFBS
		//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
		Map<String,Integer> tfbsNameandCellLineName2KMap = new HashMap<String,Integer>();	
//		Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
//		searchTfbs(permutationNumber,chrName,inputLines,tfbsIntervalTree,tfbsBufferedWriterHashMap,tfbsNameandCellLineName2KMap);
		allMaps.setPermutationNumberTfNameCellLineName2KMap(tfbsNameandCellLineName2KMap);

		//HISTONE
		//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
		Map<String,Integer> histoneNameandCellLineName2KMap = new HashMap<String,Integer>();	
//		Map<String,BufferedWriter> histoneBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
//		searchHistone(permutationNumber,chrName,inputLines,histoneIntervalTree,histoneBufferedWriterHashMap,histoneNameandCellLineName2KMap);
		allMaps.setPermutationNumberHistoneNameCellLineName2KMap(histoneNameandCellLineName2KMap);
		
		
		//KEGG PATHWAY
		//Search input interval files for kegg Pathway
		Map<String,List<String>> geneId2KeggPathwayMap = new HashMap<String, List<String>>();
		KeggPathwayUtility.createNcbiGeneId2KeggPathwayMap(dataFolder,Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE, geneId2KeggPathwayMap);
		
		//Exon Based Kegg Pathway Analysis
		//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
		Map<String,Integer> exonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
//		Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
//		searchUcscRefSeqGenes(permutationNumber, chrName, inputLines, ucscRefSeqGeneIntervalTree, exonBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, exonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.EXON_BASED_KEGG_PATHWAY_ANALYSIS);
		allMaps.setPermutationNumberExonBasedKeggPathway2KMap(exonBasedKeggPathway2KMap);
		
		
		//Regulation Based Kegg Pathway Analysis
		//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
		Map<String,Integer> regulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
//		Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
//		searchUcscRefSeqGenes(permutationNumber, chrName, inputLines, ucscRefSeqGeneIntervalTree, regulationBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, regulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.REGULATION_BASED_KEGG_PATHWAY_ANALYSIS);
		allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(regulationBasedKeggPathway2KMap);

		return allMaps;
		
	}

	
	public static void closeBufferedWriters(Map<String,BufferedWriter> BufferedWriterHashMap){
		BufferedWriter bufferedWriter  = null;
		for(Map.Entry<String, BufferedWriter> entry: BufferedWriterHashMap.entrySet()){
			try {
				bufferedWriter = entry.getValue();
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	//Using fork join framework
	//Empirical P Value Calculation
	//With IO
	public static AllMaps annotatePermutationwithIO(String outputFolder,String dataFolder,int repeatNumber,int permutationNumber,int NUMBER_OF_PERMUTATIONS, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree dnaseIntervalTree, IntervalTree tfbsIntervalTree, IntervalTree histoneIntervalTree,IntervalTree ucscRefSeqGenesIntervalTree,int overlapDefinition){
		AllMaps allMaps = new AllMaps();
		
		//DNASE
		//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
		Map<String,Integer> permutationNumberDnaseCellLineName2KMap = new HashMap<String,Integer>();		
		Map<String,BufferedWriter> dnaseBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		searchDnase(outputFolder,permutationNumber,chrName,randomlyGeneratedData, dnaseIntervalTree, dnaseBufferedWriterHashMap, permutationNumberDnaseCellLineName2KMap,overlapDefinition);
		closeBufferedWriters(dnaseBufferedWriterHashMap);
		allMaps.setPermutationNumberDnaseCellLineName2KMap(permutationNumberDnaseCellLineName2KMap);
		
		//TFBS
		//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
		Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
		Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		searchTfbs(outputFolder,permutationNumber,chrName,randomlyGeneratedData,tfbsIntervalTree,tfbsBufferedWriterHashMap,permutationNumberTfbsNameCellLineName2KMap,overlapDefinition);
		closeBufferedWriters(tfbsBufferedWriterHashMap);
		allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);

		//HISTONE
		//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
		Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap = new HashMap<String,Integer>();	
		Map<String,BufferedWriter> histoneBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		searchHistone(outputFolder,permutationNumber,chrName,randomlyGeneratedData,histoneIntervalTree,histoneBufferedWriterHashMap,permutationNumberHistoneNameCellLineName2KMap,overlapDefinition);
		closeBufferedWriters(histoneBufferedWriterHashMap);
		allMaps.setPermutationNumberHistoneNameCellLineName2KMap(permutationNumberHistoneNameCellLineName2KMap);
		
		
		//KEGG PATHWAY
		//Search input interval files for kegg Pathway
		Map<String,List<String>> geneId2KeggPathwayMap = new HashMap<String, List<String>>();
		KeggPathwayUtility.createNcbiGeneId2KeggPathwayMap(dataFolder,Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE, geneId2KeggPathwayMap);
		
		//Exon Based Kegg Pathway Analysis
		//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
		Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
		Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, ucscRefSeqGenesIntervalTree, exonBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.EXON_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
		closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
		allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
		
		
		//Regulation Based Kegg Pathway Analysis
		//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
		Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
		Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, ucscRefSeqGenesIntervalTree, regulationBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.REGULATION_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
		closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
		allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);

		return allMaps;
		
	}
	
	//Tf and KeggPathway Enrichment or
	//Tf and CellLine and KeggPathway Enrichment starts
	public static AllMaps annotatePermutationwithIO(String outputFolder,int permutationNumber, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree intervalTree,  IntervalTree ucscRefSeqGenesIntervalTree, String annotationType, String tfandKeggPathwayEnrichmentType, Map<String,List<String>> geneId2KeggPathwayMap,int overlapDefinition){
		AllMaps allMaps = new AllMaps();
		
		if (Commons.DNASE_ANNOTATION.equals(annotationType)){
			//DNASE
			//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
			Map<String,Integer> permutationNumberDnaseCellLineName2KMap = new HashMap<String,Integer>();		
			Map<String,BufferedWriter> dnaseBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchDnase(outputFolder,permutationNumber,chrName,randomlyGeneratedData, intervalTree, dnaseBufferedWriterHashMap, permutationNumberDnaseCellLineName2KMap,overlapDefinition);
			closeBufferedWriters(dnaseBufferedWriterHashMap);
			allMaps.setPermutationNumberDnaseCellLineName2KMap(permutationNumberDnaseCellLineName2KMap);
			
		}else if (Commons.TFBS_ANNOTATION.equals(annotationType)){
			//TFBS
			//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
			Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchTfbs(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,tfbsBufferedWriterHashMap,permutationNumberTfbsNameCellLineName2KMap,overlapDefinition);
			closeBufferedWriters(tfbsBufferedWriterHashMap);
			allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);

		}else if (Commons.HISTONE_ANNOTATION.equals(annotationType)){
			//HISTONE
			//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
			Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,BufferedWriter> histoneBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchHistone(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,histoneBufferedWriterHashMap,permutationNumberHistoneNameCellLineName2KMap,overlapDefinition);
			closeBufferedWriters(histoneBufferedWriterHashMap);
			allMaps.setPermutationNumberHistoneNameCellLineName2KMap(permutationNumberHistoneNameCellLineName2KMap);
		
		}else if (Commons.UCSC_REFSEQ_GENE_ANNOTATION.equals(annotationType)){
			//KEGG PATHWAY
			//Search input interval files for kegg Pathway
			
			//Exon Based Kegg Pathway Analysis
			//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
			Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, exonBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.EXON_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
			closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
			allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			
			//Regulation Based Kegg Pathway Analysis
			//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, regulationBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.REGULATION_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
			closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
			allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			
			//All Based Kegg Pathway Analysis
			//This allBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, allBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberAllBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.ALL_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
			closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);
			allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);

		}else if(Commons.TF_KEGG_PATHWAY_ANNOTATION.equals(annotationType)){
			
			//start adding new functionality	
			/***************************************************************************/
			/***************************************************************************/
			//New Functionality
			//TF and Kegg Pathway
			Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			
			//Will be used	for tf and keggPathway enrichment
			Map<String,Integer> permutationNumberTfExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			
			Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		
			
			//Will be used 	for tf and keggPathway enrichment
			Map<String,BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
						
			searchTfandKeggPathway(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap,tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,null,null,null,geneId2KeggPathwayMap,permutationNumberTfbsNameCellLineName2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,permutationNumberTfExonBasedKeggPathway2KMap,permutationNumberTfRegulationBasedKeggPathway2KMap,permutationNumberTfAllBasedKeggPathway2KMap,null,null,null,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);
			
			closeBufferedWriters(tfbsBufferedWriterHashMap);
			closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);
			
			closeBufferedWriters(tfExonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfRegulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfAllBasedKeggPathwayBufferedWriterHashMap);
			
			allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);
			allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
			
			
			allMaps.setPermutationNumberTfExonBasedKeggPathway2KMap(permutationNumberTfExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfRegulationBasedKeggPathway2KMap(permutationNumberTfRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfAllBasedKeggPathway2KMap(permutationNumberTfAllBasedKeggPathway2KMap);
	
			
			
			/***************************************************************************/
			/***************************************************************************/
			//start adding new functionality
		}else if(Commons.TF_CELLLINE_KEGG_PATHWAY_ANNOTATION.equals(annotationType)){
			
			//start adding new functionality	
			/***************************************************************************/
			/***************************************************************************/
			//New Functionality
			//TF and Kegg Pathway
			Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			
			
			//Will be used	for tf and cellline and keggPathway enrichment
			Map<String,Integer> permutationNumberTfCellLineExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfCellLineRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfCellLineAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			
			Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		
			
			//Will be used 	for tf and cellline and keggPathway enrichment
			Map<String,BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			
			searchTfandKeggPathway(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,null,null,null,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap,tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,permutationNumberTfbsNameCellLineName2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,null,null,null,permutationNumberTfCellLineExonBasedKeggPathway2KMap,permutationNumberTfCellLineRegulationBasedKeggPathway2KMap,permutationNumberTfCellLineAllBasedKeggPathway2KMap,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);
			
			closeBufferedWriters(tfbsBufferedWriterHashMap);
			closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);
			
			closeBufferedWriters(tfCellLineExonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfCellLineAllBasedKeggPathwayBufferedWriterHashMap);
					
			
			allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);
			allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
			
			
			allMaps.setPermutationNumberTfCellLineExonBasedKeggPathway2KMap(permutationNumberTfCellLineExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfCellLineRegulationBasedKeggPathway2KMap(permutationNumberTfCellLineRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfCellLineAllBasedKeggPathway2KMap(permutationNumberTfCellLineAllBasedKeggPathway2KMap);
	
			
			
			/***************************************************************************/
			/***************************************************************************/
			//start adding new functionality
		}
			
		return allMaps;
		
	}
	//Tf and KeggPathway Enrichment or
	//Tf and CellLine and KeggPathway Enrichment ends

	
	//Start adding NEW FUNCITIONALITY
	//Each time one interval tree
	//Using fork join framework
	//Empirical P Value Calculation
	//With IO
	public static AllMaps annotatePermutationwithIO(String outputFolder,int repeatNumber,int permutationNumber,int NUMBER_OF_PERMUTATIONS, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree intervalTree,  IntervalTree ucscRefSeqGenesIntervalTree, String annotationType, Map<String,List<String>> geneId2KeggPathwayMap,int overlapDefinition){
		AllMaps allMaps = new AllMaps();
		
		if (Commons.DNASE_ANNOTATION.equals(annotationType)){
			//DNASE
			//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
			Map<String,Integer> permutationNumberDnaseCellLineName2KMap = new HashMap<String,Integer>();		
			Map<String,BufferedWriter> dnaseBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchDnase(outputFolder,permutationNumber,chrName,randomlyGeneratedData, intervalTree, dnaseBufferedWriterHashMap, permutationNumberDnaseCellLineName2KMap,overlapDefinition);
			closeBufferedWriters(dnaseBufferedWriterHashMap);
			allMaps.setPermutationNumberDnaseCellLineName2KMap(permutationNumberDnaseCellLineName2KMap);
			
		}else if (Commons.TFBS_ANNOTATION.equals(annotationType)){
			//TFBS
			//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
			Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchTfbs(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,tfbsBufferedWriterHashMap,permutationNumberTfbsNameCellLineName2KMap,overlapDefinition);
			closeBufferedWriters(tfbsBufferedWriterHashMap);
			allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);

		}else if (Commons.HISTONE_ANNOTATION.equals(annotationType)){
			//HISTONE
			//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
			Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,BufferedWriter> histoneBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchHistone(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,histoneBufferedWriterHashMap,permutationNumberHistoneNameCellLineName2KMap,overlapDefinition);
			closeBufferedWriters(histoneBufferedWriterHashMap);
			allMaps.setPermutationNumberHistoneNameCellLineName2KMap(permutationNumberHistoneNameCellLineName2KMap);
		
		}else if (Commons.UCSC_REFSEQ_GENE_ANNOTATION.equals(annotationType)){
			//KEGG PATHWAY
			//Search input interval files for kegg Pathway
			
			//Exon Based Kegg Pathway Analysis
			//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
			Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, exonBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.EXON_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
			closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
			allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			
			//Regulation Based Kegg Pathway Analysis
			//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, regulationBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.REGULATION_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
			closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
			allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			
			//All Based Kegg Pathway Analysis
			//This allBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, allBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberAllBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.ALL_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
			closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);
			allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);

		}else if(Commons.TF_CELLLINE_KEGG_PATHWAY_ANNOTATION.equals(annotationType)){
			
			//start adding new functionality	
			/***************************************************************************/
			/***************************************************************************/
			//New Functionality
			//TF and Kegg Pathway
			Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfCellLineExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfCellLineRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfCellLineAllBasedKeggPathway2KMap 			= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			
			Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			
			
			searchTfandKeggPathway(outputFolder,repeatNumber,permutationNumber,NUMBER_OF_PERMUTATIONS,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap,tfCellLineAllBasedKeggPathwayBufferedWriterHashMap, tfExonBasedKeggPathwayBufferedWriterHashMap,tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,permutationNumberTfbsNameCellLineName2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,permutationNumberTfCellLineExonBasedKeggPathway2KMap,permutationNumberTfCellLineRegulationBasedKeggPathway2KMap,permutationNumberTfCellLineAllBasedKeggPathway2KMap,permutationNumberTfExonBasedKeggPathway2KMap,permutationNumberTfRegulationBasedKeggPathway2KMap,permutationNumberTfAllBasedKeggPathway2KMap,Commons.NCBI_GENE_ID,overlapDefinition);
			
			closeBufferedWriters(tfbsBufferedWriterHashMap);
			closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfCellLineExonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfCellLineAllBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfExonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfRegulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfAllBasedKeggPathwayBufferedWriterHashMap);
			
			
			allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);
			allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfCellLineExonBasedKeggPathway2KMap(permutationNumberTfCellLineExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfCellLineRegulationBasedKeggPathway2KMap(permutationNumberTfCellLineRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfCellLineAllBasedKeggPathway2KMap(permutationNumberTfCellLineAllBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfExonBasedKeggPathway2KMap(permutationNumberTfExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfRegulationBasedKeggPathway2KMap(permutationNumberTfRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfAllBasedKeggPathway2KMap(permutationNumberTfAllBasedKeggPathway2KMap);
			
			
			/***************************************************************************/
			/***************************************************************************/
			//start adding new functionality
		}
			
		return allMaps;
		
	}

	
		//All 4 types of interval trees are sent full
		//Using fork join framework
		//Empirical P Value Calculation
		//Without IO
		public static AllMaps annotatePermutationwithoutIO(String dataFolder,int permutationNumber, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree dnaseIntervalTree, IntervalTree tfbsIntervalTree, IntervalTree histoneIntervalTree,IntervalTree ucscRefSeqGenesIntervalTree,int overlapDefinition){
			AllMaps allMaps = new AllMaps();
			
			//DNASE
			//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
			Map<String,Integer> permutationNumberDnaseCellLineName2KMap = new HashMap<String,Integer>();		
			searchDnasewithoutIO(permutationNumber,chrName,randomlyGeneratedData, dnaseIntervalTree, permutationNumberDnaseCellLineName2KMap,overlapDefinition);
			allMaps.setPermutationNumberDnaseCellLineName2KMap(permutationNumberDnaseCellLineName2KMap);
			
			//TFBS
			//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
			Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
			searchTfbswithoutIO(permutationNumber,chrName,randomlyGeneratedData,tfbsIntervalTree,permutationNumberTfbsNameCellLineName2KMap,overlapDefinition);
			allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);

			//HISTONE
			//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
			Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap = new HashMap<String,Integer>();	
			searchHistonewithoutIO(permutationNumber,chrName,randomlyGeneratedData,histoneIntervalTree,permutationNumberHistoneNameCellLineName2KMap,overlapDefinition);
			allMaps.setPermutationNumberHistoneNameCellLineName2KMap(permutationNumberHistoneNameCellLineName2KMap);
			
			
			//KEGG PATHWAY
			//Search input interval files for kegg Pathway
			Map<String,List<String>> geneId2KeggPathwayMap = new HashMap<String, List<String>>();
			KeggPathwayUtility.createNcbiGeneId2KeggPathwayMap(dataFolder,Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE, geneId2KeggPathwayMap);
			
			//Exon Based Kegg Pathway Analysis
			//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
			searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, ucscRefSeqGenesIntervalTree, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.EXON_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
			allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			
			//Regulation Based Kegg Pathway Analysis
			//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
			searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, ucscRefSeqGenesIntervalTree, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.REGULATION_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
			allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);

			return allMaps;
			
		}

		
		//new starts there is a parameter called tfandKeggPathwayEnrichmentType
		//TF_AND_KEGGPATHWAY_ENRICHMENT OR
		//TF_AND_CELLLINE_AND_KEGGPATHWAY_ENRICHMENT
		//Not both enrichment at the same time
		//each time one interval tree EXCEPT NEW FUNCTIONALITY
		//Using fork join framework
		//Empirical P Value Calculation
		//Without IO
		public static AllMaps annotatePermutationwithoutIO(int permutationNumber, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree intervalTree, IntervalTree ucscRefSeqGenesIntervalTree, String annotationType,String tfandKeggPathwayEnrichmentType, Map<String,List<String>> geneId2KeggPathwayMap,int overlapDefinition){
				AllMaps allMaps = new AllMaps();
					
				if (Commons.DNASE_ANNOTATION.equals(annotationType)){
					//DNASE
					//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
					Map<String,Integer> permutationNumberDnaseCellLineName2KMap = new HashMap<String,Integer>();		
					searchDnasewithoutIO(permutationNumber,chrName,randomlyGeneratedData, intervalTree, permutationNumberDnaseCellLineName2KMap,overlapDefinition);
					allMaps.setPermutationNumberDnaseCellLineName2KMap(permutationNumberDnaseCellLineName2KMap);
					
				}else if (Commons.TFBS_ANNOTATION.equals(annotationType)){
					//TFBS
					//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
					Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
					searchTfbswithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,permutationNumberTfbsNameCellLineName2KMap,overlapDefinition);
					allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);

				}else if (Commons.HISTONE_ANNOTATION.equals(annotationType)){
					//HISTONE
					//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
					Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap = new HashMap<String,Integer>();	
					searchHistonewithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,permutationNumberHistoneNameCellLineName2KMap,overlapDefinition);
					allMaps.setPermutationNumberHistoneNameCellLineName2KMap(permutationNumberHistoneNameCellLineName2KMap);
					
				}else if (Commons.UCSC_REFSEQ_GENE_ANNOTATION.equals(annotationType)){
					//KEGG PATHWAY
					//Search input interval files for kegg Pathway
						
					//Exon Based Kegg Pathway Analysis
					//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
					Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
					searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.EXON_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
					allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
					
					//Regulation Based Kegg Pathway Analysis
					//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
					Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
					searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.REGULATION_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
					allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);

					//All Based Kegg Pathway Analysis
					//This allBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
					Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
					searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberAllBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.ALL_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
					allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);

					
				}else if (Commons.TF_KEGG_PATHWAY_ANNOTATION.equals(annotationType)){
					
					/***************************************************************************/
					/***************************************************************************/
					//New Functionality
					//TF and Kegg Pathway
					Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
					
					Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
					Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
					Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
					
					
					//Will be used 	for tf and keggPathway enrichment
					Map<String,Integer> permutationNumberTfExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
					Map<String,Integer> permutationNumberTfRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
					Map<String,Integer> permutationNumberTfAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
						
					searchTfandKeggPathwaywithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,geneId2KeggPathwayMap,permutationNumberTfbsNameCellLineName2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,permutationNumberTfExonBasedKeggPathway2KMap,permutationNumberTfRegulationBasedKeggPathway2KMap,permutationNumberTfAllBasedKeggPathway2KMap,null,null,null,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);				
					
					allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);	
					
					allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
					allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
					allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
					
					allMaps.setPermutationNumberTfExonBasedKeggPathway2KMap(permutationNumberTfExonBasedKeggPathway2KMap);
					allMaps.setPermutationNumberTfRegulationBasedKeggPathway2KMap(permutationNumberTfRegulationBasedKeggPathway2KMap);
					allMaps.setPermutationNumberTfAllBasedKeggPathway2KMap(permutationNumberTfAllBasedKeggPathway2KMap);
								
					
					
					/***************************************************************************/
					/***************************************************************************/
					
				}else if (Commons.TF_CELLLINE_KEGG_PATHWAY_ANNOTATION.equals(annotationType)){
					
					
					/***************************************************************************/
					/***************************************************************************/
					//New Functionality
					//TF and Kegg Pathway
					Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
					
					Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
					Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
					Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
					
					
					//Will be used	for tf and cellLine and keggPathway enrichment					
					Map<String,Integer> permutationNumberTfCellLineExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
					Map<String,Integer> permutationNumberTfCellLineRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
					Map<String,Integer> permutationNumberTfCellLineAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
						
					searchTfandKeggPathwaywithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,geneId2KeggPathwayMap,permutationNumberTfbsNameCellLineName2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,null,null,null,permutationNumberTfCellLineExonBasedKeggPathway2KMap,permutationNumberTfCellLineRegulationBasedKeggPathway2KMap,permutationNumberTfCellLineAllBasedKeggPathway2KMap,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);				
					
					allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);	
					
					allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
					allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
					allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
					
					allMaps.setPermutationNumberTfCellLineExonBasedKeggPathway2KMap(permutationNumberTfCellLineExonBasedKeggPathway2KMap);
					allMaps.setPermutationNumberTfCellLineRegulationBasedKeggPathway2KMap(permutationNumberTfCellLineRegulationBasedKeggPathway2KMap);
					allMaps.setPermutationNumberTfCellLineAllBasedKeggPathway2KMap(permutationNumberTfCellLineAllBasedKeggPathway2KMap);
								
					
					
					/***************************************************************************/
					/***************************************************************************/
					
				}
							
				return allMaps;
				
		}
		//new ends
		
		//there is NO parameter called tfandKeggPathwayEnrichmentType
		//each time one interval tree EXCEPT NEW FUNCTIONALITY
		//Using fork join framework
		//Empirical P Value Calculation
		//Without IO
		public static AllMaps annotatePermutationwithoutIO(int permutationNumber, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree intervalTree, IntervalTree ucscRefSeqGenesIntervalTree, String annotationType,Map<String,List<String>> geneId2KeggPathwayMap,int overlapDefinition){
			AllMaps allMaps = new AllMaps();
				
			if (Commons.DNASE_ANNOTATION.equals(annotationType)){
				//DNASE
				//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
				Map<String,Integer> permutationNumberDnaseCellLineName2KMap = new HashMap<String,Integer>();		
				searchDnasewithoutIO(permutationNumber,chrName,randomlyGeneratedData, intervalTree, permutationNumberDnaseCellLineName2KMap,overlapDefinition);
				allMaps.setPermutationNumberDnaseCellLineName2KMap(permutationNumberDnaseCellLineName2KMap);
				
			}else if (Commons.TFBS_ANNOTATION.equals(annotationType)){
				//TFBS
				//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
				Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
				searchTfbswithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,permutationNumberTfbsNameCellLineName2KMap,overlapDefinition);
				allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);

			}else if (Commons.HISTONE_ANNOTATION.equals(annotationType)){
				//HISTONE
				//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
				Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap = new HashMap<String,Integer>();	
				searchHistonewithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,permutationNumberHistoneNameCellLineName2KMap,overlapDefinition);
				allMaps.setPermutationNumberHistoneNameCellLineName2KMap(permutationNumberHistoneNameCellLineName2KMap);
				
			}else if (Commons.UCSC_REFSEQ_GENE_ANNOTATION.equals(annotationType)){
				//KEGG PATHWAY
				//Search input interval files for kegg Pathway
					
				//Exon Based Kegg Pathway Analysis
				//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
				Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
				searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.EXON_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
				allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
				
				//Regulation Based Kegg Pathway Analysis
				//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
				Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
				searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.REGULATION_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
				allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);

				//All Based Kegg Pathway Analysis
				//This allBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
				Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
				searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberAllBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.ALL_BASED_KEGG_PATHWAY_ANALYSIS,overlapDefinition);
				allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);

				
			} else if (Commons.TF_CELLLINE_KEGG_PATHWAY_ANNOTATION.equals(annotationType)){
				
				
				/***************************************************************************/
				/***************************************************************************/
				//New Functionality
				//TF and Kegg Pathway
				Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
				
				Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
				Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			
				Map<String,Integer> permutationNumberTfCellLineExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
				Map<String,Integer> permutationNumberTfCellLineRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
				Map<String,Integer> permutationNumberTfCellLineAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
				
				Map<String,Integer> permutationNumberTfExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
				Map<String,Integer> permutationNumberTfRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
				Map<String,Integer> permutationNumberTfAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
				
				searchTfandKeggPathwaywithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,geneId2KeggPathwayMap,permutationNumberTfbsNameCellLineName2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,permutationNumberTfCellLineExonBasedKeggPathway2KMap,permutationNumberTfCellLineRegulationBasedKeggPathway2KMap,permutationNumberTfCellLineAllBasedKeggPathway2KMap,permutationNumberTfExonBasedKeggPathway2KMap,permutationNumberTfRegulationBasedKeggPathway2KMap,permutationNumberTfAllBasedKeggPathway2KMap,Commons.NCBI_GENE_ID,overlapDefinition);
				
				allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);
				
				allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
				allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
				allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
				
				allMaps.setPermutationNumberTfCellLineExonBasedKeggPathway2KMap(permutationNumberTfCellLineExonBasedKeggPathway2KMap);
				allMaps.setPermutationNumberTfCellLineRegulationBasedKeggPathway2KMap(permutationNumberTfCellLineRegulationBasedKeggPathway2KMap);
				allMaps.setPermutationNumberTfCellLineAllBasedKeggPathway2KMap(permutationNumberTfCellLineAllBasedKeggPathway2KMap);
				
				allMaps.setPermutationNumberTfExonBasedKeggPathway2KMap(permutationNumberTfExonBasedKeggPathway2KMap);
				allMaps.setPermutationNumberTfRegulationBasedKeggPathway2KMap(permutationNumberTfRegulationBasedKeggPathway2KMap);
				allMaps.setPermutationNumberTfAllBasedKeggPathway2KMap(permutationNumberTfAllBasedKeggPathway2KMap);
				/***************************************************************************/
				/***************************************************************************/
				
			}
						
			return allMaps;
			
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
		
		
		AnnotateGivenIntervalsWithGivenParameters annotateIntervals = new AnnotateGivenIntervalsWithGivenParameters();
		
		annotateIntervals.annotate(args);
		
		
	}

}
			