/**
 * 
 */
package create;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import auxiliary.FileOperations;

import common.Commons;

/**
 * @author burcakotlu
 *
 */
public class ChromosomeBasedFiles {

	
	public static void closeChromosomeBasedBufferedWriters(List<BufferedWriter> bufferedWriterList){
		Iterator<BufferedWriter> itr = bufferedWriterList.iterator();
		
		while (itr.hasNext()){
			BufferedWriter bw = (BufferedWriter) itr.next();
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static void closeChromosomeBasedBufferedReaders(List<BufferedReader> bufferedReaderList){
		Iterator<BufferedReader> itr = bufferedReaderList.iterator();
		
		while (itr.hasNext()){
			BufferedReader br = (BufferedReader) itr.next();
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	
	public static void openUnsortedChromosomeBasedDnaseFileWriters(List<BufferedWriter> bufferedWriterList){
		
		try {
			FileWriter  fileWriter1 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR1_DNASE_FILENAME);
			FileWriter  fileWriter2 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR2_DNASE_FILENAME);
			FileWriter  fileWriter3 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR3_DNASE_FILENAME);
			FileWriter  fileWriter4 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR4_DNASE_FILENAME);
			FileWriter  fileWriter5 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR5_DNASE_FILENAME);
			FileWriter  fileWriter6 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR6_DNASE_FILENAME);
			FileWriter  fileWriter7 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR7_DNASE_FILENAME);
			FileWriter  fileWriter8 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR8_DNASE_FILENAME);
			FileWriter  fileWriter9 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR9_DNASE_FILENAME);
			FileWriter  fileWriter10 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR10_DNASE_FILENAME);
			FileWriter  fileWriter11 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR11_DNASE_FILENAME);
			FileWriter  fileWriter12 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR12_DNASE_FILENAME);
			FileWriter  fileWriter13 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR13_DNASE_FILENAME);
			FileWriter  fileWriter14 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR14_DNASE_FILENAME);
			FileWriter  fileWriter15 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR15_DNASE_FILENAME);
			FileWriter  fileWriter16 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR16_DNASE_FILENAME);
			FileWriter  fileWriter17 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR17_DNASE_FILENAME);
			FileWriter  fileWriter18 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR18_DNASE_FILENAME);
			FileWriter  fileWriter19 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR19_DNASE_FILENAME);
			FileWriter  fileWriter20 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR20_DNASE_FILENAME);
			FileWriter  fileWriter21 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR21_DNASE_FILENAME);
			FileWriter  fileWriter22 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHR22_DNASE_FILENAME);
			FileWriter  fileWriterX = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHRX_DNASE_FILENAME);
			FileWriter  fileWriterY = FileOperations.createFileWriter(Commons.CREATE_ENCODE_DNASE_DIRECTORY , Commons.UNSORTED_CHRY_DNASE_FILENAME);
				
			bufferedWriterList.add(new BufferedWriter(fileWriter1));
			bufferedWriterList.add(new BufferedWriter(fileWriter2));
			bufferedWriterList.add(new BufferedWriter(fileWriter3));
			bufferedWriterList.add(new BufferedWriter(fileWriter4));
			bufferedWriterList.add(new BufferedWriter(fileWriter5));
			bufferedWriterList.add(new BufferedWriter(fileWriter6));
			bufferedWriterList.add(new BufferedWriter(fileWriter7));
			bufferedWriterList.add(new BufferedWriter(fileWriter8));
			bufferedWriterList.add(new BufferedWriter(fileWriter9));
			bufferedWriterList.add(new BufferedWriter(fileWriter10));
			bufferedWriterList.add(new BufferedWriter(fileWriter11));
			bufferedWriterList.add(new BufferedWriter(fileWriter12));
			bufferedWriterList.add(new BufferedWriter(fileWriter13));
			bufferedWriterList.add(new BufferedWriter(fileWriter14));
			bufferedWriterList.add(new BufferedWriter(fileWriter15));
			bufferedWriterList.add(new BufferedWriter(fileWriter16));
			bufferedWriterList.add(new BufferedWriter(fileWriter17));
			bufferedWriterList.add(new BufferedWriter(fileWriter18));
			bufferedWriterList.add(new BufferedWriter(fileWriter19));
			bufferedWriterList.add(new BufferedWriter(fileWriter20));
			bufferedWriterList.add(new BufferedWriter(fileWriter21));
			bufferedWriterList.add(new BufferedWriter(fileWriter22));
			bufferedWriterList.add(new BufferedWriter(fileWriterX));
			bufferedWriterList.add(new BufferedWriter(fileWriterY));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	public static void openUnsortedChromosomeBasedHistoneFileWriters(List<BufferedWriter> bufferedWriterList){
		
		try {
			FileWriter  fileWriter1 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR1_HISTONE_FILENAME);
			FileWriter  fileWriter2 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR2_HISTONE_FILENAME);
			FileWriter  fileWriter3 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR3_HISTONE_FILENAME);
			FileWriter  fileWriter4 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR4_HISTONE_FILENAME);
			FileWriter  fileWriter5 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR5_HISTONE_FILENAME);
			FileWriter  fileWriter6 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR6_HISTONE_FILENAME);
			FileWriter  fileWriter7 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR7_HISTONE_FILENAME);
			FileWriter  fileWriter8 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR8_HISTONE_FILENAME);
			FileWriter  fileWriter9 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR9_HISTONE_FILENAME);
			FileWriter  fileWriter10 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR10_HISTONE_FILENAME);
			FileWriter  fileWriter11 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR11_HISTONE_FILENAME);
			FileWriter  fileWriter12 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR12_HISTONE_FILENAME);
			FileWriter  fileWriter13 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR13_HISTONE_FILENAME);
			FileWriter  fileWriter14 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR14_HISTONE_FILENAME);
			FileWriter  fileWriter15 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR15_HISTONE_FILENAME);
			FileWriter  fileWriter16 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR16_HISTONE_FILENAME);
			FileWriter  fileWriter17 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR17_HISTONE_FILENAME);
			FileWriter  fileWriter18 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR18_HISTONE_FILENAME);
			FileWriter  fileWriter19 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR19_HISTONE_FILENAME);
			FileWriter  fileWriter20 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR20_HISTONE_FILENAME);
			FileWriter  fileWriter21 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR21_HISTONE_FILENAME);
			FileWriter  fileWriter22 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHR22_HISTONE_FILENAME);
			FileWriter  fileWriterX = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHRX_HISTONE_FILENAME);
			FileWriter  fileWriterY = FileOperations.createFileWriter(Commons.CREATE_ENCODE_HISTONE_DIRECTORY , Commons.UNSORTED_CHRY_HISTONE_FILENAME);
				
			bufferedWriterList.add(new BufferedWriter(fileWriter1));
			bufferedWriterList.add(new BufferedWriter(fileWriter2));
			bufferedWriterList.add(new BufferedWriter(fileWriter3));
			bufferedWriterList.add(new BufferedWriter(fileWriter4));
			bufferedWriterList.add(new BufferedWriter(fileWriter5));
			bufferedWriterList.add(new BufferedWriter(fileWriter6));
			bufferedWriterList.add(new BufferedWriter(fileWriter7));
			bufferedWriterList.add(new BufferedWriter(fileWriter8));
			bufferedWriterList.add(new BufferedWriter(fileWriter9));
			bufferedWriterList.add(new BufferedWriter(fileWriter10));
			bufferedWriterList.add(new BufferedWriter(fileWriter11));
			bufferedWriterList.add(new BufferedWriter(fileWriter12));
			bufferedWriterList.add(new BufferedWriter(fileWriter13));
			bufferedWriterList.add(new BufferedWriter(fileWriter14));
			bufferedWriterList.add(new BufferedWriter(fileWriter15));
			bufferedWriterList.add(new BufferedWriter(fileWriter16));
			bufferedWriterList.add(new BufferedWriter(fileWriter17));
			bufferedWriterList.add(new BufferedWriter(fileWriter18));
			bufferedWriterList.add(new BufferedWriter(fileWriter19));
			bufferedWriterList.add(new BufferedWriter(fileWriter20));
			bufferedWriterList.add(new BufferedWriter(fileWriter21));
			bufferedWriterList.add(new BufferedWriter(fileWriter22));
			bufferedWriterList.add(new BufferedWriter(fileWriterX));
			bufferedWriterList.add(new BufferedWriter(fileWriterY));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void openUnsortedChromosomeBasedTfbsFileWriters(List<BufferedWriter> bufferedWriterList){
		
		try {
			FileWriter  fileWriter1 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR1_TFBS_FILENAME);
			FileWriter  fileWriter2 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR2_TFBS_FILENAME);
			FileWriter  fileWriter3 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR3_TFBS_FILENAME);
			FileWriter  fileWriter4 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR4_TFBS_FILENAME);
			FileWriter  fileWriter5 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR5_TFBS_FILENAME);
			FileWriter  fileWriter6 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR6_TFBS_FILENAME);
			FileWriter  fileWriter7 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR7_TFBS_FILENAME);
			FileWriter  fileWriter8 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR8_TFBS_FILENAME);
			FileWriter  fileWriter9 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR9_TFBS_FILENAME);
			FileWriter  fileWriter10 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR10_TFBS_FILENAME);
			FileWriter  fileWriter11 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR11_TFBS_FILENAME);
			FileWriter  fileWriter12 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR12_TFBS_FILENAME);
			FileWriter  fileWriter13 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR13_TFBS_FILENAME);
			FileWriter  fileWriter14 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR14_TFBS_FILENAME);
			FileWriter  fileWriter15 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR15_TFBS_FILENAME);
			FileWriter  fileWriter16 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR16_TFBS_FILENAME);
			FileWriter  fileWriter17 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR17_TFBS_FILENAME);
			FileWriter  fileWriter18 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR18_TFBS_FILENAME);
			FileWriter  fileWriter19 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR19_TFBS_FILENAME);
			FileWriter  fileWriter20 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR20_TFBS_FILENAME);
			FileWriter  fileWriter21 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR21_TFBS_FILENAME);
			FileWriter  fileWriter22 = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHR22_TFBS_FILENAME);
			FileWriter  fileWriterX = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHRX_TFBS_FILENAME);
			FileWriter  fileWriterY = FileOperations.createFileWriter(Commons.CREATE_ENCODE_TFBS_DIRECTORY , Commons.UNSORTED_CHRY_TFBS_FILENAME);
				
			bufferedWriterList.add(new BufferedWriter(fileWriter1));
			bufferedWriterList.add(new BufferedWriter(fileWriter2));
			bufferedWriterList.add(new BufferedWriter(fileWriter3));
			bufferedWriterList.add(new BufferedWriter(fileWriter4));
			bufferedWriterList.add(new BufferedWriter(fileWriter5));
			bufferedWriterList.add(new BufferedWriter(fileWriter6));
			bufferedWriterList.add(new BufferedWriter(fileWriter7));
			bufferedWriterList.add(new BufferedWriter(fileWriter8));
			bufferedWriterList.add(new BufferedWriter(fileWriter9));
			bufferedWriterList.add(new BufferedWriter(fileWriter10));
			bufferedWriterList.add(new BufferedWriter(fileWriter11));
			bufferedWriterList.add(new BufferedWriter(fileWriter12));
			bufferedWriterList.add(new BufferedWriter(fileWriter13));
			bufferedWriterList.add(new BufferedWriter(fileWriter14));
			bufferedWriterList.add(new BufferedWriter(fileWriter15));
			bufferedWriterList.add(new BufferedWriter(fileWriter16));
			bufferedWriterList.add(new BufferedWriter(fileWriter17));
			bufferedWriterList.add(new BufferedWriter(fileWriter18));
			bufferedWriterList.add(new BufferedWriter(fileWriter19));
			bufferedWriterList.add(new BufferedWriter(fileWriter20));
			bufferedWriterList.add(new BufferedWriter(fileWriter21));
			bufferedWriterList.add(new BufferedWriter(fileWriter22));
			bufferedWriterList.add(new BufferedWriter(fileWriterX));
			bufferedWriterList.add(new BufferedWriter(fileWriterY));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void openUnsortedChromosomeBasedRefSeqGeneFileWriters(List<BufferedWriter> bufferedWriterList){
		
		try {
			FileWriter  fileWriter1 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR1_REFSEQ_GENES);
			FileWriter  fileWriter2 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR2_REFSEQ_GENES);
			FileWriter  fileWriter3 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR3_REFSEQ_GENES);
			FileWriter  fileWriter4 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR4_REFSEQ_GENES);
			FileWriter  fileWriter5 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR5_REFSEQ_GENES);
			FileWriter  fileWriter6 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR6_REFSEQ_GENES);
			FileWriter  fileWriter7 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR7_REFSEQ_GENES);
			FileWriter  fileWriter8 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR8_REFSEQ_GENES);
			FileWriter  fileWriter9 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR9_REFSEQ_GENES);
			FileWriter  fileWriter10 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR10_REFSEQ_GENES);
			FileWriter  fileWriter11 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR11_REFSEQ_GENES);
			FileWriter  fileWriter12 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR12_REFSEQ_GENES);
			FileWriter  fileWriter13 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR13_REFSEQ_GENES);
			FileWriter  fileWriter14 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR14_REFSEQ_GENES);
			FileWriter  fileWriter15 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR15_REFSEQ_GENES);
			FileWriter  fileWriter16 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR16_REFSEQ_GENES);
			FileWriter  fileWriter17 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR17_REFSEQ_GENES);
			FileWriter  fileWriter18 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR18_REFSEQ_GENES);
			FileWriter  fileWriter19 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR19_REFSEQ_GENES);
			FileWriter  fileWriter20 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR20_REFSEQ_GENES);
			FileWriter  fileWriter21 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR21_REFSEQ_GENES);
			FileWriter  fileWriter22 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHR22_REFSEQ_GENES);
			FileWriter  fileWriterX = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHRX_REFSEQ_GENES);
			FileWriter  fileWriterY = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME , Commons.UNSORTED_CHRY_REFSEQ_GENES);
				
			bufferedWriterList.add(new BufferedWriter(fileWriter1));
			bufferedWriterList.add(new BufferedWriter(fileWriter2));
			bufferedWriterList.add(new BufferedWriter(fileWriter3));
			bufferedWriterList.add(new BufferedWriter(fileWriter4));
			bufferedWriterList.add(new BufferedWriter(fileWriter5));
			bufferedWriterList.add(new BufferedWriter(fileWriter6));
			bufferedWriterList.add(new BufferedWriter(fileWriter7));
			bufferedWriterList.add(new BufferedWriter(fileWriter8));
			bufferedWriterList.add(new BufferedWriter(fileWriter9));
			bufferedWriterList.add(new BufferedWriter(fileWriter10));
			bufferedWriterList.add(new BufferedWriter(fileWriter11));
			bufferedWriterList.add(new BufferedWriter(fileWriter12));
			bufferedWriterList.add(new BufferedWriter(fileWriter13));
			bufferedWriterList.add(new BufferedWriter(fileWriter14));
			bufferedWriterList.add(new BufferedWriter(fileWriter15));
			bufferedWriterList.add(new BufferedWriter(fileWriter16));
			bufferedWriterList.add(new BufferedWriter(fileWriter17));
			bufferedWriterList.add(new BufferedWriter(fileWriter18));
			bufferedWriterList.add(new BufferedWriter(fileWriter19));
			bufferedWriterList.add(new BufferedWriter(fileWriter20));
			bufferedWriterList.add(new BufferedWriter(fileWriter21));
			bufferedWriterList.add(new BufferedWriter(fileWriter22));
			bufferedWriterList.add(new BufferedWriter(fileWriterX));
			bufferedWriterList.add(new BufferedWriter(fileWriterY));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void openUnsortedChromosomeBasedRefSeqGeneFileReaders(List<BufferedReader> bufferedReaderList){
		
		try {
			FileReader  fileReader1 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR1_REFSEQ_GENES);
			FileReader  fileReader2 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR2_REFSEQ_GENES);
			FileReader  fileReader3 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR3_REFSEQ_GENES);
			FileReader  fileReader4 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR4_REFSEQ_GENES);
			FileReader  fileReader5 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR5_REFSEQ_GENES);
			FileReader  fileReader6 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR6_REFSEQ_GENES);
			FileReader  fileReader7 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR7_REFSEQ_GENES);
			FileReader  fileReader8 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR8_REFSEQ_GENES);
			FileReader  fileReader9 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR9_REFSEQ_GENES);
			FileReader  fileReader10 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR10_REFSEQ_GENES);
			FileReader  fileReader11 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR11_REFSEQ_GENES);
			FileReader  fileReader12 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR12_REFSEQ_GENES);
			FileReader  fileReader13 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR13_REFSEQ_GENES);
			FileReader  fileReader14 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR14_REFSEQ_GENES);
			FileReader  fileReader15 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR15_REFSEQ_GENES);
			FileReader  fileReader16 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR16_REFSEQ_GENES);
			FileReader  fileReader17 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR17_REFSEQ_GENES);
			FileReader  fileReader18 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR18_REFSEQ_GENES);
			FileReader  fileReader19 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR19_REFSEQ_GENES);
			FileReader  fileReader20 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR20_REFSEQ_GENES);
			FileReader  fileReader21 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR21_REFSEQ_GENES);
			FileReader  fileReader22 = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHR22_REFSEQ_GENES);
			FileReader  fileReaderX = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHRX_REFSEQ_GENES);
			FileReader  fileReaderY = FileOperations.createFileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME ,Commons.UNSORTED_CHRY_REFSEQ_GENES);
			
						
			bufferedReaderList.add(new BufferedReader(fileReader1));
			bufferedReaderList.add(new BufferedReader(fileReader2));
			bufferedReaderList.add(new BufferedReader(fileReader3));
			bufferedReaderList.add(new BufferedReader(fileReader4));
			bufferedReaderList.add(new BufferedReader(fileReader5));
			bufferedReaderList.add(new BufferedReader(fileReader6));
			bufferedReaderList.add(new BufferedReader(fileReader7));
			bufferedReaderList.add(new BufferedReader(fileReader8));
			bufferedReaderList.add(new BufferedReader(fileReader9));
			bufferedReaderList.add(new BufferedReader(fileReader10));
			bufferedReaderList.add(new BufferedReader(fileReader11));
			bufferedReaderList.add(new BufferedReader(fileReader12));
			bufferedReaderList.add(new BufferedReader(fileReader13));
			bufferedReaderList.add(new BufferedReader(fileReader14));
			bufferedReaderList.add(new BufferedReader(fileReader15));
			bufferedReaderList.add(new BufferedReader(fileReader16));
			bufferedReaderList.add(new BufferedReader(fileReader17));
			bufferedReaderList.add(new BufferedReader(fileReader18));
			bufferedReaderList.add(new BufferedReader(fileReader19));
			bufferedReaderList.add(new BufferedReader(fileReader20));
			bufferedReaderList.add(new BufferedReader(fileReader21));
			bufferedReaderList.add(new BufferedReader(fileReader22));
			bufferedReaderList.add(new BufferedReader(fileReaderX));
			bufferedReaderList.add(new BufferedReader(fileReaderY));
						
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void openSortedChromosomeBasedRefSeqGeneFiles(List<BufferedWriter> bufferedWriterList){
		try {
			FileWriter  fileWriter1 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR1_REFSEQ_GENES);
			FileWriter  fileWriter2 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR2_REFSEQ_GENES);
			FileWriter  fileWriter3 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR3_REFSEQ_GENES);
			FileWriter  fileWriter4 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR4_REFSEQ_GENES);
			FileWriter  fileWriter5 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR5_REFSEQ_GENES);
			FileWriter  fileWriter6 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR6_REFSEQ_GENES);
			FileWriter  fileWriter7 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR7_REFSEQ_GENES);
			FileWriter  fileWriter8 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR8_REFSEQ_GENES);
			FileWriter  fileWriter9 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR9_REFSEQ_GENES);
			FileWriter  fileWriter10 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR10_REFSEQ_GENES);
			FileWriter  fileWriter11 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR11_REFSEQ_GENES);
			FileWriter  fileWriter12 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR12_REFSEQ_GENES);
			FileWriter  fileWriter13 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR13_REFSEQ_GENES);
			FileWriter  fileWriter14 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR14_REFSEQ_GENES);
			FileWriter  fileWriter15 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR15_REFSEQ_GENES);
			FileWriter  fileWriter16 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR16_REFSEQ_GENES);
			FileWriter  fileWriter17 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR17_REFSEQ_GENES);
			FileWriter  fileWriter18 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR18_REFSEQ_GENES);
			FileWriter  fileWriter19 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR19_REFSEQ_GENES);
			FileWriter  fileWriter20 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR20_REFSEQ_GENES);
			FileWriter  fileWriter21 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR21_REFSEQ_GENES);
			FileWriter  fileWriter22 = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHR22_REFSEQ_GENES);
			FileWriter  fileWriterX = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHRX_REFSEQ_GENES);
			FileWriter  fileWriterY = FileOperations.createFileWriter(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME, Commons.SORTED_CHRY_REFSEQ_GENES);
				
			bufferedWriterList.add(new BufferedWriter(fileWriter1));
			bufferedWriterList.add(new BufferedWriter(fileWriter2));
			bufferedWriterList.add(new BufferedWriter(fileWriter3));
			bufferedWriterList.add(new BufferedWriter(fileWriter4));
			bufferedWriterList.add(new BufferedWriter(fileWriter5));
			bufferedWriterList.add(new BufferedWriter(fileWriter6));
			bufferedWriterList.add(new BufferedWriter(fileWriter7));
			bufferedWriterList.add(new BufferedWriter(fileWriter8));
			bufferedWriterList.add(new BufferedWriter(fileWriter9));
			bufferedWriterList.add(new BufferedWriter(fileWriter10));
			bufferedWriterList.add(new BufferedWriter(fileWriter11));
			bufferedWriterList.add(new BufferedWriter(fileWriter12));
			bufferedWriterList.add(new BufferedWriter(fileWriter13));
			bufferedWriterList.add(new BufferedWriter(fileWriter14));
			bufferedWriterList.add(new BufferedWriter(fileWriter15));
			bufferedWriterList.add(new BufferedWriter(fileWriter16));
			bufferedWriterList.add(new BufferedWriter(fileWriter17));
			bufferedWriterList.add(new BufferedWriter(fileWriter18));
			bufferedWriterList.add(new BufferedWriter(fileWriter19));
			bufferedWriterList.add(new BufferedWriter(fileWriter20));
			bufferedWriterList.add(new BufferedWriter(fileWriter21));
			bufferedWriterList.add(new BufferedWriter(fileWriter22));
			bufferedWriterList.add(new BufferedWriter(fileWriterX));
			bufferedWriterList.add(new BufferedWriter(fileWriterY));
			
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
	
	public static FileReader getUnsortedRefSeqGenesFileReader(String chromName){
				
		FileReader fileReader = null;
	
		try {
			
			if (Commons.CHROMOSOME1.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR1_REFSEQ_GENES);								
			} else if (Commons.CHROMOSOME2.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR2_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME3.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR3_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME4.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR4_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME5.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR5_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME6.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR6_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME7.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR7_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME8.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR8_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME9.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR9_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME10.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR10_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME11.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR11_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME12.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR12_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME13.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR13_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME14.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR14_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME15.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR15_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME16.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR16_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME17.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR17_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME18.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR18_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME19.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR19_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME20.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR20_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME21.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR21_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME22.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHR22_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOMEX.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHRX_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOMEY.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.UNSORTED_CHRY_REFSEQ_GENES);				
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileReader;
	}
	
	
	public static FileReader getSortedRefSeqGenesFileReader(String chromName){
		
		FileReader fileReader = null;
	
		try {
			
			if (Commons.CHROMOSOME1.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR1_REFSEQ_GENES);								
			} else if (Commons.CHROMOSOME2.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR2_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME3.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR3_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME4.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR4_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME5.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR5_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME6.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR6_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME7.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR7_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME8.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR8_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME9.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR9_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME10.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR10_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME11.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR11_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME12.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR12_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME13.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR13_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME14.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR14_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME15.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR15_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME16.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR16_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME17.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR17_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME18.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR18_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME19.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR19_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME20.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR20_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME21.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR21_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOME22.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHR22_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOMEX.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHRX_REFSEQ_GENES);				
			} else if (Commons.CHROMOSOMEY.equals(chromName)){
				fileReader = new FileReader(Commons.CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME + Commons.SORTED_CHRY_REFSEQ_GENES);				
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileReader;
	}
	
	public static BufferedWriter getBufferedWriter(String chromName,List<BufferedWriter> bufferedWriterList){
		BufferedWriter bufferedWriter = null;
		
		if (chromName.equals(Commons.CHROMOSOME1)){
			bufferedWriter = bufferedWriterList.get(0);
		}else if (chromName.equals(Commons.CHROMOSOME2)){
			bufferedWriter = bufferedWriterList.get(1);			
		}else if (chromName.equals(Commons.CHROMOSOME3)){
			bufferedWriter = bufferedWriterList.get(2);			
		}else if (chromName.equals(Commons.CHROMOSOME4)){
			bufferedWriter = bufferedWriterList.get(3);			
		}else if (chromName.equals(Commons.CHROMOSOME5)){
			bufferedWriter = bufferedWriterList.get(4);			
		}else if (chromName.equals(Commons.CHROMOSOME6)){
			bufferedWriter = bufferedWriterList.get(5);			
		}else if (chromName.equals(Commons.CHROMOSOME7)){
			bufferedWriter = bufferedWriterList.get(6);			
		}else if (chromName.equals(Commons.CHROMOSOME8)){
			bufferedWriter = bufferedWriterList.get(7);			
		}else if (chromName.equals(Commons.CHROMOSOME9)){
			bufferedWriter = bufferedWriterList.get(8);			
		}else if (chromName.equals(Commons.CHROMOSOME10)){
			bufferedWriter = bufferedWriterList.get(9);			
		}else if (chromName.equals(Commons.CHROMOSOME11)){
			bufferedWriter = bufferedWriterList.get(10);			
		}else if (chromName.equals(Commons.CHROMOSOME12)){
			bufferedWriter = bufferedWriterList.get(11);			
		}else if (chromName.equals(Commons.CHROMOSOME13)){
			bufferedWriter = bufferedWriterList.get(12);			
		}else if (chromName.equals(Commons.CHROMOSOME14)){
			bufferedWriter = bufferedWriterList.get(13);			
		}else if (chromName.equals(Commons.CHROMOSOME15)){
			bufferedWriter = bufferedWriterList.get(14);			
		}else if (chromName.equals(Commons.CHROMOSOME16)){
			bufferedWriter = bufferedWriterList.get(15);			
		}else if (chromName.equals(Commons.CHROMOSOME17)){
			bufferedWriter = bufferedWriterList.get(16);			
		}else if (chromName.equals(Commons.CHROMOSOME18)){
			bufferedWriter = bufferedWriterList.get(17);			
		}else if (chromName.equals(Commons.CHROMOSOME19)){
			bufferedWriter = bufferedWriterList.get(18);			
		}else if (chromName.equals(Commons.CHROMOSOME20)){
			bufferedWriter = bufferedWriterList.get(19);			
		}else if (chromName.equals(Commons.CHROMOSOME21)){
			bufferedWriter = bufferedWriterList.get(20);			
		}else if (chromName.equals(Commons.CHROMOSOME22)){
			bufferedWriter = bufferedWriterList.get(21);			
		}else if (chromName.equals(Commons.CHROMOSOMEX)){
			bufferedWriter = bufferedWriterList.get(22);			
		}else if (chromName.equals(Commons.CHROMOSOMEY)){
			bufferedWriter = bufferedWriterList.get(23);			
		}
		
		return bufferedWriter;
	}
}
