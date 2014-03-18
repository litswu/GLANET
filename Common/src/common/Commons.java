/*
 * This program takes human_gene2refseq.txt as input
 * and returns human_refseq2gene.txt as output
 */

package common;


public class Commons {
	
	public static final String OUTPUT_DATA = System.getProperty("user.home") + System.getProperty("file.separator") + "GLANET" + System.getProperty("file.separator") + "Output" + System.getProperty("file.separator");
	public static final String LARGE_OUTPUT_DATA = System.getProperty("user.home") + System.getProperty("file.separator") + "GLANET" + System.getProperty("file.separator") + "LOutput" + System.getProperty("file.separator");
	public static final String INPUT_DATA = System.getProperty("user.home") + System.getProperty("file.separator") + "GLANET" + System.getProperty("file.separator") + "AnnotationData" + System.getProperty("file.separator");

	public static final String RSERVE =  System.getProperty("user.home") + System.getProperty("file.separator") + "GLANET" + System.getProperty("file.separator") + "Rserve" + System.getProperty("file.separator");
	
	public static final Integer ORIGINAL_DATA_PERMUTATION_NUMBER = new Integer(0);
	public static final String PERMUTATION0 = "PERMUTATION0";

	public static Integer ZERO = new Integer(0); 
	public static Integer ONE = new Integer(1); 
	
	public static Float FLOAT_ZERO = new Float(0.0f); 
	public static Float FLOAT_TEN_QUADRILLION = new Float(10000000000000000f); 
	
	public static Long LONG_ZERO = new Long(0); 
	public static Long LONG_ONE = new Long(1); 
	
	public static final String GC = "GC";
	public static final String MAPABILITY = "MAPABILITY";
	
	public static final String RANDOM_DATA_GENERATION_LOG_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "generate" + System.getProperty("file.separator") + "randomdata" + System.getProperty("file.separator") + "GenerateRandomDataLog.txt";
	
	//RSID to CHRNAME CHRPOSITION OBSERVEDALLELES converter
	
	public static final String  OCD_GWAS_SIGNIFICANT_SNPS_RSIDS_INPUT_FILE_NAME_TEST = INPUT_DATA + System.getProperty("file.separator") +"OCD_GWAS_SNP" + System.getProperty("file.separator") +"OCD_GWAS_SIGNIFICANT_SNP_RSIDs_TEST.txt";
	public static final String  OCD_GWAS_SIGNIFICANT_SNPS_RSIDS_INPUT_FILE_NAME = INPUT_DATA + System.getProperty("file.separator") +"OCD_GWAS_SNP" + System.getProperty("file.separator") +"OCD_GWAS_SIGNIFICANT_SNP_RSIDs.txt";
	public static final String  OCD_GWAS_SIGNIFICANT_SNPS_RSIDS_OUTPUT_FILE_NAME = OUTPUT_DATA + System.getProperty("file.separator")+ "Doktora" + System.getProperty("file.separator") +  "jaxbxjctool" + System.getProperty("file.separator") +"OCD_GWAS_SIGNIFICANT_SNP_CHRNAME_CHRPOSITION_OBSERVEDALLELES.txt";

//dbSNP
	public static final String NUCLEOTIDE_A = "A";
	public static final String NUCLEOTIDE_C = "C";
	public static final String NUCLEOTIDE_G = "G";
	public static final String NUCLEOTIDE_T = "T";
	
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR1 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch1.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR2 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch2.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR3 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch3.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR4 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch4.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR5 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch5.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR6 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch6.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR7 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch7.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR8 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch8.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR9 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch9.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR10 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch10.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR11 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch11.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR12 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch12.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR13 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch13.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR14 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch14.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR15 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch15.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR16 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch16.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR17 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch17.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR18 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch18.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR19 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch19.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR20 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch20.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR21	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch21.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHR22 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_ch22.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHRX 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_chX.flat";
	public static final String DOKTORA_DATA_DB_SNP_DS_FLAT_FILE_FOR_CHRY 	= INPUT_DATA + System.getProperty("file.separator") + "dbSNP" + System.getProperty("file.separator") + "ASN1_flat" + System.getProperty("file.separator") + "ds_flat_chY.flat";

	//Enrich Outputs
	public static final String ENRICH_OUTPUT_FOLDER = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "augmentation" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator");
	
	
	public static final String AUGMENTED_TF_EXON_BASED_KEGG_PATHWAY_RESULTS 		= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "augmentation" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "AugmentedTfExonBasedKeggPathwayResults.txt";
	public static final String AUGMENTED_TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS 	= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "augmentation" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "AugmentedTfRegulationBasedKeggPathwayResults.txt";
	public static final String AUGMENTED_TF_ALL_BASED_KEGG_PATHWAY_RESULTS 			= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "augmentation" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "AugmentedTfAllBasedKeggPathwayResults.txt";

	public static final String AUGMENTED_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "augmentation" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "AugmentedTfCellLineExonBasedKeggPathwayResults.txt";
	public static final String AUGMENTED_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "augmentation" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "AugmentedTfCellLineRegulationBasedKeggPathwayResults.txt";
	public static final String AUGMENTED_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "augmentation" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "AugmentedTfCellLineAllBasedKeggPathwayResults.txt";
	
	public static final String TEST_AUGMENTED_TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS 	= OUTPUT_DATA + "augmentation" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "Test_AugmentedTfRegulationBasedKeggPathwayResults.txt";
	
	//RSAT
	 public static final String RSAT_ORGANISM_Homo_sapiens_ensembl_74_GRCh37 = "Homo_sapiens_ensembl_74_GRCh37";
	 public static final String RSAT_BACKGROUND_upstream_noorf = "upstream-noorf";
	 public static final String RSAT_tmp_background_infile = "/home/rsat/rsat/public_html/data/genomes/Homo_sapiens_ensembl_74_GRCh37/oligo-frequencies/1nt_upstream-noorf_Homo_sapiens_ensembl_74_GRCh37-ovlp-1str.freq.gz";
	 
	 public static final String RSAT_OUTPUT_FILENAME= OUTPUT_DATA + "RSAT" + System.getProperty("file.separator") + "rsat" + System.getProperty("file.separator") + "RSAT_results.txt";
	    
	//Rserve
	public static final String RSERVE_OUTPUT_FOLDER = OUTPUT_DATA + "rserve" + System.getProperty("file.separator");
	
	/*************************************************************************************/
	//TF KEGGPATHWAY DIRECTORY BASES
	public static final String TF_EXON_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE 		= RSERVE_OUTPUT_FOLDER + "TfKeggPathway" + System.getProperty("file.separator") + "TfExonBasedKeggPathway" + System.getProperty("file.separator");
	public static final String TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE 	= RSERVE_OUTPUT_FOLDER + "TfKeggPathway" + System.getProperty("file.separator") + "TfRegulationBasedKeggPathway" + System.getProperty("file.separator");
	public static final String TF_ALL_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE 		= RSERVE_OUTPUT_FOLDER + "TfKeggPathway" + System.getProperty("file.separator") + "TfAllBasedKeggPathway" + System.getProperty("file.separator");
	
	
	//TF CELLLINE KEGGPATHWAY DIRECTORY BASES
	public static final String TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE 		= RSERVE_OUTPUT_FOLDER + "TfCellLineKeggPathway" + System.getProperty("file.separator") + "TfCellLineExonBasedKeggPathway" + System.getProperty("file.separator");
	public static final String TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE = RSERVE_OUTPUT_FOLDER + "TfCellLineKeggPathway" + System.getProperty("file.separator") + "TfCellLineRegulationBasedKeggPathway" + System.getProperty("file.separator");
	public static final String TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE 		= RSERVE_OUTPUT_FOLDER + "TfCellLineKeggPathway" + System.getProperty("file.separator") + "TfCellLineAllBasedKeggPathway" + System.getProperty("file.separator");

	/*************************************************************************************/

	
	
	//Encode-motifs file
	public static final String ENCODE_MOTIFS = INPUT_DATA + "encode_motifs" + System.getProperty("file.separator") + "motifs.txt";
	
	//Jaspar Core File
	public static final String JASPAR_CORE = INPUT_DATA + "jaspar_core" + System.getProperty("file.separator") + "pfm_all.txt";
	
	
	public static final String JASPAR_CORE_MATRICES_FOR_LOGO = RSERVE_OUTPUT_FOLDER + "jaspar_core_logo_matrices.txt";
	
	public static final int NUMBER_OF_BASES_BEFORE_SNP_POSITION= 14;
	public static final int NUMBER_OF_BASES_AFTER_SNP_POSITION= 14;
	public static final int ONE_BASED_SNP_POSITION= 15;
	
	public static final char SEQUENCE_DIRECTION_D = 'D';
	public static final char SEQUENCE_DIRECTION_R = 'R';
		
	
	//Case Study OCD_GWAS
	//Comparison of Binomial Test versus Permutation Test
	public static final String DNASE_ADJUSTED_P_VALUE_BINOMIAL_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "binomialdistribution" + System.getProperty("file.separator") + "dnase_adjusted_pvalues.txt";
	public static final String DNASE_ADJUSTED_P_VALUE_10000_WITH_OCD_GWAS_PERMUTATION_TEST 		= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_10000Perm.txt";
	public static final String DNASE_ADJUSTED_P_VALUE_10000_WITHOUT_OCD_GWAS_PERMUTATION_TEST 	= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_10000Perm.txt";
	public static final String DNASE_ADJUSTED_P_VALUE_5000_WITH_OCD_GWAS_PERMUTATION_TEST 		= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_5000Perm.txt";
	public static final String DNASE_ADJUSTED_P_VALUE_5000_WITHOUT_OCD_GWAS_PERMUTATION_TEST 	= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_5000Perm.txt";
	public static final String DNASE_ADJUSTED_P_VALUE_1000_WITH_OCD_GWAS_PERMUTATION_TEST 		= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_1000Perm.txt";
	public static final String DNASE_ADJUSTED_P_VALUE_1000_WITHOUT_OCD_GWAS_PERMUTATION_TEST 	= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_1000Perm.txt";
	public static final String DNASE_BINOMIAL_VERSUS_PERMUTATION_COMPARISON_OCD_GWAS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "comparison" + System.getProperty("file.separator") + "binomialversuspermutation" + System.getProperty("file.separator") + "dnase_comparison_of_binomial_and_permutation_tests_OCD_GWAS.txt";
	
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_BINOMIAL_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "binomialdistribution" + System.getProperty("file.separator") + "tfbs_adjusted_pvalues.txt";;
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_10000_WITH_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_10000Perm.txt";
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_10000_WITHOUT_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_10000Perm.txt";
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_5000_WITH_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_5000Perm.txt";
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_5000_WITHOUT_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_5000Perm.txt";
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_1000_WITH_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_1000Perm.txt";
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_1000_WITHOUT_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_1000Perm.txt";
	public static final String TRANSCRIPTION_FACTOR_BINOMIAL_VERSUS_PERMUTATION_COMPARISON_OCD_GWAS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "comparison" + System.getProperty("file.separator") + "binomialversuspermutation" + System.getProperty("file.separator") + "tfbs_comparison_of_binomial_and_permutation_tests_OCD_GWAS.txt";
	
	public static final String HISTONE_ADJUSTED_P_VALUE_BINOMIAL_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "binomialdistribution" + System.getProperty("file.separator") + "histone_adjusted_pvalues.txt";;
	public static final String HISTONE_ADJUSTED_P_VALUE_10000_WITH_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_10000Perm.txt";
	public static final String HISTONE_ADJUSTED_P_VALUE_10000_WITHOUT_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_10000Perm.txt";
	public static final String HISTONE_ADJUSTED_P_VALUE_5000_WITH_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_5000Perm.txt";
	public static final String HISTONE_ADJUSTED_P_VALUE_5000_WITHOUT_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_5000Perm.txt";
	public static final String HISTONE_ADJUSTED_P_VALUE_1000_WITH_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_1000Perm.txt";
	public static final String HISTONE_ADJUSTED_P_VALUE_1000_WITHOUT_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_1000Perm.txt";
	public static final String HISTONE_BINOMIAL_VERSUS_PERMUTATION_COMPARISON_OCD_GWAS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "comparison" + System.getProperty("file.separator") + "binomialversuspermutation" + System.getProperty("file.separator") + "histone_comparison_of_binomial_and_permutation_tests_OCD_GWAS.txt";
	
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_BINOMIAL_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "binomialdistribution" + System.getProperty("file.separator") + "exonBased_KeggPathway_adjusted_pvalues.txt";;
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_10000_WITH_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_10000Perm.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_10000_WITHOUT_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_10000Perm.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_5000_WITH_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_5000Perm.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_5000_WITHOUT_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_5000Perm.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_1000_WITH_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_1000Perm.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_1000_WITHOUT_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_1000Perm.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_BINOMIAL_VERSUS_PERMUTATION_COMPARISON_OCD_GWAS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "comparison" + System.getProperty("file.separator") + "binomialversuspermutation" + System.getProperty("file.separator") + "exonBasedKeggPathway_comparison_of_binomial_and_permutation_tests_OCD_GWAS.txt";
	
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_BINOMIAL_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "binomialdistribution" + System.getProperty("file.separator") + "regulationBased_KeggPathway_adjusted_pvalues.txt";;
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_10000_WITH_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_10000Perm.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_10000_WITHOUT_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_10000Perm.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_5000_WITH_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_5000Perm.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_5000_WITHOUT_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_5000Perm.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_1000_WITH_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues_OCD_withGCMap_1Rep_1000Perm.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_1000_WITHOUT_OCD_GWAS_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues_OCD_withoutGCMap_1Rep_1000Perm.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_BINOMIAL_VERSUS_PERMUTATION_COMPARISON_OCD_GWAS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "comparison" + System.getProperty("file.separator") + "binomialversuspermutation" + System.getProperty("file.separator") + "regulationBasedKeggPathway_comparison_of_binomial_and_permutation_tests_OCD_GWAS.txt";
	
	
	
	//Case Study Positive Control K562 GATA1
	//Comparison of Permutation Tests
	public static final String DNASE_ADJUSTED_P_VALUE_10000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST 		= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_10000Perm.txt";
	public static final String DNASE_ADJUSTED_P_VALUE_10000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST 	= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_10000Perm.txt";
	public static final String DNASE_ADJUSTED_P_VALUE_5000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST 		= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_5000Perm.txt";
	public static final String DNASE_ADJUSTED_P_VALUE_5000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST 	= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_5000Perm.txt";
	public static final String DNASE_ADJUSTED_P_VALUE_1000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST 		= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_1000Perm.txt";
	public static final String DNASE_ADJUSTED_P_VALUE_1000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST 	= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_1000Perm.txt";
	public static final String DNASE_PERMUTATION_COMPARISON_POSITIVE_CONTROL_K562_GATA1 = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "comparison" + System.getProperty("file.separator") + "binomialversuspermutation" + System.getProperty("file.separator") + "dnase_comparison_of_permutation_tests_K562_GATA1.txt";
	
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_10000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_10000Perm.txt";
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_10000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_10000Perm.txt";
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_5000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_5000Perm.txt";
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_5000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_5000Perm.txt";
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_1000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_1000Perm.txt";
	public static final String TRANSCRIPTION_FACTOR_ADJUSTED_P_VALUE_1000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_1000Perm.txt";
	public static final String TRANSCRIPTION_FACTOR_PERMUTATION_COMPARISON_POSITIVE_CONTROL_K562_GATA1 = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "comparison" + System.getProperty("file.separator") + "binomialversuspermutation" + System.getProperty("file.separator") + "tfbs_comparison_of_permutation_tests_K562_GATA1.txt";
	
	public static final String HISTONE_ADJUSTED_P_VALUE_10000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_10000Perm.txt";
	public static final String HISTONE_ADJUSTED_P_VALUE_10000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_10000Perm.txt";
	public static final String HISTONE_ADJUSTED_P_VALUE_5000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_5000Perm.txt";
	public static final String HISTONE_ADJUSTED_P_VALUE_5000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_5000Perm.txt";
	public static final String HISTONE_ADJUSTED_P_VALUE_1000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_1000Perm.txt";
	public static final String HISTONE_ADJUSTED_P_VALUE_1000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_1000Perm.txt";
	public static final String HISTONE_PERMUTATION_COMPARISON_POSITIVE_CONTROL_K562_GATA1 = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "comparison" + System.getProperty("file.separator") + "binomialversuspermutation" + System.getProperty("file.separator") + "histone_comparison_of_permutation_tests_K562_GATA1.txt";
	
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_10000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_10000Perm.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_10000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_10000Perm.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_5000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_5000Perm.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_5000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_5000Perm.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_1000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_1000Perm.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_1000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_1000Perm.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_PERMUTATION_COMPARISON_POSITIVE_CONTROL_K562_GATA1 = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "comparison" + System.getProperty("file.separator") + "binomialversuspermutation" + System.getProperty("file.separator") + "exonBasedKeggPathway_comparison_of_permutation_tests_K562_GATA1.txt";
	
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_10000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_10000Perm.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_10000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_10000Perm.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_5000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_5000Perm.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_5000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_5000Perm.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_1000_WITH_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues_K562_GATA1_withGCMap_1Rep_1000Perm.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUE_1000_WITHOUT_POSITIVE_CONTROL_K562_GATA1_PERMUTATION_TEST = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues_K562_GATA1_withoutGCMap_1Rep_1000Perm.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_PERMUTATION_COMPARISON_POSITIVE_CONTROL_K562_GATA1 = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")  + "comparison" + System.getProperty("file.separator") + "binomialversuspermutation" + System.getProperty("file.separator") + "regulationBasedKeggPathway_comparison_of_permutation_tests_K562_GATA1.txt";
	

	
	//Mapability and GC
	public static final String WRITE_MEAN_VALUE_OF_EACH_FILE = "WRITE_MEAN_VALUE_OF_EACH_FILE";
	public static final String WRITE_STANDARD_DEVIATION_VALUE_OF_EACH_FILE = "WRITE_STANDARD_DEVIATION_VALUE_OF_EACH_FILE";
	
	//ALL FILES
	public static final String ALL_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "all_gc_files.txt";
	public static final String ALL_DNASE_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "all_dnase_gc_files.txt";
	public static final String ALL_TFBS_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "all_tfbs_gc_files.txt";
	public static final String ALL_HISTONE_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "all_histone_gc_files.txt";
	
	public static final String ALL_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "all_mapability_files.txt";
	public static final String ALL_DNASE_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "all_dnase_mapability_files.txt";
	public static final String ALL_TFBS_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "all_tfbs_mapability_files.txt";
	public static final String ALL_HISTONE_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "all_histone_mapability_files.txt";

	
	//Ten Different Mean Files
	public static final String TEN_DIFFERENT_MEAN_DNASE_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "ten_different_mean_dnase_gc_files.txt";
	public static final String TEN_DIFFERENT_MEAN_TFBS_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "ten_different_mean_tfbs_gc_files.txt";
	public static final String TEN_DIFFERENT_MEAN_HISTONE_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "ten_different_mean_histone_gc_files.txt";
	
	public static final String TEN_DIFFERENT_MEAN_DNASE_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "ten_different_mean_dnase_mapability_files.txt";
	public static final String TEN_DIFFERENT_MEAN_TFBS_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "ten_different_mean_tfbs_mapability_files.txt";
	public static final String TEN_DIFFERENT_MEAN_HISTONE_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "ten_different_mean_histone_mapability_files.txt";
	
	//TOP TEN MOST VARYING FILES
	public static final String TOP_TEN_MOST_VARYING_DNASE_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "top_ten_dnase_gc_files.txt";
	public static final String TOP_TEN_MOST_VARYING_TFBS_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "top_ten_tfbs_gc_files.txt";
	public static final String TOP_TEN_MOST_VARYING_HISTONE_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "top_ten_histone_gc_files.txt";
	
	public static final String TOP_TEN_MOST_VARYING_DNASE_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "top_ten_dnase_mapability_files.txt";
	public static final String TOP_TEN_MOST_VARYING_TFBS_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "top_ten_tfbs_mapability_files.txt";
	public static final String TOP_TEN_MOST_VARYING_HISTONE_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "top_ten_histone_mapability_files.txt";
	
	//Data Files for R for Ten Different Mean Files
	public static final String DATA_FILE_FOR_R_TEN_DIFFERENT_MEAN_DNASE_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "TenDifferentMeanDnaseGCFiles.txt";
	public static final String DATA_FILE_FOR_R_TEN_DIFFERENT_MEAN_TFBS_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "TenDifferentMeanTfbsGCFiles.txt";
	public static final String DATA_FILE_FOR_R_TEN_DIFFERENT_MEAN_HISTONE_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "TenDifferentMeanHistoneGCFiles.txt";
	
	public static final String DATA_FILE_FOR_R_TEN_DIFFERENT_MEAN_DNASE_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "TenDifferentMeanDnaseMAPABILITYFiles.txt";
	public static final String DATA_FILE_FOR_R_TEN_DIFFERENT_MEAN_TFBS_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "TenDifferentMeanTfbsMAPABILITYFiles.txt";
	public static final String DATA_FILE_FOR_R_TEN_DIFFERENT_MEAN_HISTONE_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "TenDifferentMeanHistoneMAPABILITYFiles.txt";
		
	//Top Ten Most Varying Dnase Tfbs Histone Mapability and GC files for Box Plot in R
	public static final String DATA_FILE_FOR_R_TOP_TEN_MOST_VARYING_DNASE_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "TopTenMostVaryingDnaseGCFiles.txt";
	public static final String DATA_FILE_FOR_R_TOP_TEN_MOST_VARYING_TFBS_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "TopTenMostVaryingTfbsGCFiles.txt";
	public static final String DATA_FILE_FOR_R_TOP_TEN_MOST_VARYING_HISTONE_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "TopTenMostVaryingHistoneGCFiles.txt";
	
	public static final String DATA_FILE_FOR_R_TOP_TEN_MOST_VARYING_DNASE_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "TopTenMostVaryingDnaseMapabilityFiles.txt";
	public static final String DATA_FILE_FOR_R_TOP_TEN_MOST_VARYING_TFBS_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "TopTenMostVaryingTfbsMapabilityFiles.txt";
	public static final String DATA_FILE_FOR_R_TOP_TEN_MOST_VARYING_HISTONE_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "TopTenMostVaryingHistoneMapabilityFiles.txt";
	
	//All Dnase Tfbs Histone Mapability and GC files for Box Plot in R
	public static final String DATA_FILE_FOR_R_ALL_DNASE_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "AllDnaseGCFiles.txt";
	public static final String DATA_FILE_FOR_R_ALL_TFBS_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "AllTfbsGCFiles.txt";
	public static final String DATA_FILE_FOR_R_ALL_HISTONE_GC_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "AllHistoneGCFiles.txt";

	public static final String DATA_FILE_FOR_R_ALL_DNASE_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "AllDnaseMapabilityFiles.txt";;
	public static final String DATA_FILE_FOR_R_ALL_TFBS_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "AllTfbsMapabilityFiles.txt";
	public static final String DATA_FILE_FOR_R_ALL_HISTONE_MAPABILITY_FILES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "DataFilesForR" + System.getProperty("file.separator") + "AllHistoneMapabilityFiles.txt";

	public static final String ALL_DNASE_GC_FILES_DIRECTORY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "Dnase" + System.getProperty("file.separator") + "Gc" + System.getProperty("file.separator");
	public static final String ALL_TFBS_GC_FILES_DIRECTORY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "Tfbs" + System.getProperty("file.separator") + "Gc" + System.getProperty("file.separator");
	public static final String ALL_HISTONE_GC_FILES_DIRECTORY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "Histone" + System.getProperty("file.separator") + "Gc" + System.getProperty("file.separator");
	
	public static final String ALL_DNASE_MAPABILITY_FILES_DIRECTORY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "Dnase" + System.getProperty("file.separator") + "Mapability" + System.getProperty("file.separator");
	public static final String ALL_TFBS_MAPABILITY_FILES_DIRECTORY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "Tfbs" + System.getProperty("file.separator") + "Mapability" + System.getProperty("file.separator");
	public static final String ALL_HISTONE_MAPABILITY_FILES_DIRECTORY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "mapabilityandgc" + System.getProperty("file.separator") + "Augmentation" + System.getProperty("file.separator") + "FunctionalElementFileBased" + System.getProperty("file.separator") + "Histone" + System.getProperty("file.separator") + "Mapability" + System.getProperty("file.separator");
	
	
	//MAPABILITY
	public static final String WG_ENCODE_CRG_MAPABILITY_ALIGN_100_MER_WIG = INPUT_DATA + "MAPABILITY" + System.getProperty("file.separator") + "wgEncodeCrgMapabilityAlign100mer.wig" ;
	public static final String WG_ENCODE_CRG_MAPABILITY_ALIGN_50_MER_WIG = INPUT_DATA + "MAPABILITY" + System.getProperty("file.separator") + "wgEncodeCrgMapabilityAlign50mer.wig" ;
	public static final String MAPABILITY_HG19_CHR1_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr1_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR2_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr2_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR3_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr3_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR4_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr4_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR5_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr5_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR6_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr6_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR7_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr7_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR8_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr8_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR9_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr9_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR10_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr10_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR11_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr11_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR12_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr12_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR13_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr13_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR14_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr14_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR15_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr15_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR16_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr16_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR17_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr17_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR18_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr18_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR19_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr19_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR20_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr20_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR21_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr21_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHR22_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chr22_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHRX_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chrX_hg19_mapability.txt" ;
	public static final String MAPABILITY_HG19_CHRY_FILE = INPUT_DATA +  "MAPABILITY" + System.getProperty("file.separator") + "chrY_hg19_mapability.txt" ;
	
	//GC
	public static final String GC_HG19_CHR1_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr1.fa" ;
	public static final String GC_HG19_CHR2_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr2.fa" ;
	public static final String GC_HG19_CHR3_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr3.fa" ;
	public static final String GC_HG19_CHR4_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr4.fa" ;
	public static final String GC_HG19_CHR5_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr5.fa" ;
	public static final String GC_HG19_CHR6_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr6.fa" ;
	public static final String GC_HG19_CHR7_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr7.fa" ;
	public static final String GC_HG19_CHR8_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr8.fa" ;
	public static final String GC_HG19_CHR9_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr9.fa" ;
	public static final String GC_HG19_CHR10_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr10.fa" ;
	public static final String GC_HG19_CHR11_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr11.fa" ;
	public static final String GC_HG19_CHR12_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr12.fa" ;
	public static final String GC_HG19_CHR13_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr13.fa" ;
	public static final String GC_HG19_CHR14_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr14.fa" ;
	public static final String GC_HG19_CHR15_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr15.fa" ;
	public static final String GC_HG19_CHR16_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr16.fa" ;
	public static final String GC_HG19_CHR17_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr17.fa" ;
	public static final String GC_HG19_CHR18_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr18.fa" ;
	public static final String GC_HG19_CHR19_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr19.fa" ;
	public static final String GC_HG19_CHR20_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr20.fa" ;
	public static final String GC_HG19_CHR21_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr21.fa" ;
	public static final String GC_HG19_CHR22_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chr22.fa" ;
	public static final String GC_HG19_CHRX_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chrX.fa" ;
	public static final String GC_HG19_CHRY_FASTA_FILE = INPUT_DATA +  "GC" + System.getProperty("file.separator") + "chrY.fa" ;
	
	public static final String GC_HG19_CHR1_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr1_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR2_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr2_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR3_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr3_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR4_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr4_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR5_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr5_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR6_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr6_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR7_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr7_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR8_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr8_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR9_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr9_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR10_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr10_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR11_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr11_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR12_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr12_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR13_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr13_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR14_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr14_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR15_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr15_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR16_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr16_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR17_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr17_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR18_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr18_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR19_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr19_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR20_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr20_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR21_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr21_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHR22_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chr22_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHRX_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chrX_GC_onezero_file.txt" ;
	public static final String GC_HG19_CHRY_ONEZERO_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator")+  "mappabilityandgc" + System.getProperty("file.separator") + "GC" + System.getProperty("file.separator") + "chrY_GC_onezero_file.txt" ;
	
	public static final char NUCLEIC_ACID_UPPER_CASE_A = 'A' ;
	public static final char NUCLEIC_ACID_LOWER_CASE_A = 'a' ;
	
	public static final char NUCLEIC_ACID_UPPER_CASE_G = 'G' ;
	public static final char NUCLEIC_ACID_LOWER_CASE_G = 'g' ;
	
	public static final char NUCLEIC_ACID_UPPER_CASE_C = 'C' ;
	public static final char NUCLEIC_ACID_LOWER_CASE_C = 'c' ;
	
	public static final char NUCLEIC_ACID_UPPER_CASE_T = 'T' ;
	public static final char NUCLEIC_ACID_LOWER_CASE_T = 't' ;
	
	public static final char NUCLEIC_ACID_UPPER_CASE_N = 'N' ;
	public static final char NUCLEIC_ACID_LOWER_CASE_N = 'n' ;
	
		
	
	//Empirical P Value	
	public static final float GC_THRESHOLD_LOWER_VALUE = (float) 0.01;
	public static final float GC_THRESHOLD_UPPER_VALUE = (float) 0.1;
	
	public static final float MAPABILITY_THRESHOLD_LOWER_VALUE = (float) 0.01;
	public static final float MAPABILITY_THRESHOLD_UPPER_VALUE = (float) 0.1;
	
	public static final float THRESHOLD_INCREASE_VALUE_0_POINT_001	= (float) 0.001;
	public static final float THRESHOLD_INCREASE_VALUE_0_POINT_002	= (float) 0.002;
	public static final float THRESHOLD_INCREASE_VALUE_0_POINT_003 	= (float) 0.003;
	public static final float THRESHOLD_INCREASE_VALUE_0_POINT_004	= (float) 0.004;
	
	public static final int NUMBER_OF_TRIAL_FIRST_LEVEL 	=	1000;
	public static final int NUMBER_OF_TRIAL_SECOND_LEVEL	=	2000;
	public static final int NUMBER_OF_TRIAL_THIRD_LEVEL	=	3000;
	public static final int NUMBER_OF_TRIAL_FOURTH_LEVEL	=	4000;
	
	public static final String ORIGINAL_INPUT_DATA_FILE = "ORIGINAL_INPUT_DATA_FILE";
	
	public static final String WRITE_GENERATED_RANDOM_DATA = "WRITE_GENERATED_RANDOM_DATA";
	public static final String DO_NOT_WRITE_GENERATED_RANDOM_DATA = "DO_NOT_WRITE_GENERATED_RANDOM_DATA";
	
	public static final String WRITE_PERMUTATION_BASED_AND_PARAMETRIC_BASED_ANNOTATION_RESULT = "WRITE_PERMUTATION_BASED_AND_PARAMETRIC_BASED_ANNOTATION_RESULT";
	public static final String DO_NOT_WRITE_PERMUTATION_BASED_AND_PARAMETRIC_BASED_ANNOTATION_RESULT = "DO_NOT_WRITE_PERMUTATION_BASED_AND_PARAMETRIC_BASED_ANNOTATION_RESULT";
	
	public static final String WRITE_PERMUTATION_BASED_ANNOTATION_RESULT = "WRITE_PERMUTATION_BASED_ANNOTATION_RESULT";
	public static final String DO_NOT_WRITE_PERMUTATION_BASED_ANNOTATION_RESULT = "DO_NOT_WRITE_PERMUTATION_BASED_ANNOTATION_RESULT";

	public static final String GENERATE_RANDOM_DATA_WITHOUT_MAPPABILITY_AND_GC_CONTENT = "GENERATE_RANDOM_DATA_WITHOUT_MAPPABILITY_AND_GC_CONTENT";
	public static final String GENERATE_RANDOM_DATA_WITH_MAPPABILITY_AND_GC_CONTENT = "GENERATE_RANDOM_DATA_WITH_MAPPABILITY_AND_GC_CONTENT";
	public static final String PERMUTATION = "PERMUTATION";
	public static final String RANDOMLY_GENERATED_DATA_FOLDER = "RandomlyGeneratedData" + System.getProperty("file.separator");
	public static final String RANDOMLY_GENERATED_DATA = "RANDOMLY_GENERATED_DATA";
	
	
	//Positive Control
	public static final String POSITIVE_CONTROL_INPUT_FILE_NAME = INPUT_DATA +  "ENCODE" + System.getProperty("file.separator") + "transcription_factors" + System.getProperty("file.separator") + "spp.optimal.wgEncodeSydhTfbsK562bGata1UcdAlnRep0_VS_wgEncodeSydhTfbsK562bInputUcdAlnRep1.narrowPeak";
	public static final String POSITIVE_CONTROL_OUTPUT_FILE_NAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "inputdata" + System.getProperty("file.separator") + "prepare" + System.getProperty("file.separator") + "positive_control_K562_Gata1.txt";
	public static final String POSITIVE_CONTROL_OUTPUT_FILE_NAME_WITHOUT_OVERLAPS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "inputdata" + System.getProperty("file.separator") + "process" + System.getProperty("file.separator") + "positive_control_K562_Gata1_without_overlaps.txt";
	
	
	
	//Input Data Prepare
	public static final String CHROMOSOME_POSITION_TYPE_ZERO_BASED = "CHROMOSOME_POSITION_TYPE_ZERO_BASED"; 
	public static final String CHROMOSOME_POSITION_TYPE_ONE_BASED = "CHROMOSOME_POSITION_TYPE_ONE_BASED"; 
	
	public static final String NOT_AVAILABLE_SNP_ID = "#N/A";
	
	//OCD_GWAS_SIGNIFICANT_SNPS
	public static final String OCD_GWAS_SIGNIFICANT_SNPS_CHRNUMBER_BASEPAIRNUMBER = INPUT_DATA + "OCD_GWAS_SNP" + System.getProperty("file.separator") + "ocd_gwas_snp_chrNumber_basePairNumber.txt";
	public static final String OCD_GWAS_SIGNIFICANT_SNPS_PREPARED_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "inputdata" + System.getProperty("file.separator") + "prepare" + System.getProperty("file.separator") + "ocd_gwas_snp_chrNumber_basePairNumber_prepared_file.txt";
	public static final String OCD_GWAS_SIGNIFICANT_SNPS_WITHOUT_OVERLAPS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "inputdata" + System.getProperty("file.separator") + "process" + System.getProperty("file.separator") + "ocd_gwas_snp_chrNumber_basePairNumber_without_overlaps.txt";	
	public static final String OCD_GWAS_SIGNIFICANT_SNPS_AUGMENTED_WITH_DBSNP = OUTPUT_DATA +  "Doktora" + System.getProperty("file.separator") + "inputdata" + System.getProperty("file.separator") + "augment" + System.getProperty("file.separator") + "ocd_gwas_snp_chrNumber_basePairNumber_augmented_with_dbSNP.txt";

	
	//HIV1 SNPS
	public static final String HIV1_SNPS_START_INCLUSIVE_END_EXCLUSIVE = INPUT_DATA + "HIV1_SNP" + System.getProperty("file.separator") + "hglft_www_5c79_8ab500.bed" ;
	public static final String HIV1_SNPS_START_INCLUSIVE_END_INCLUSIVE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "inputdata" + System.getProperty("file.separator") + "prepare" + System.getProperty("file.separator") + "HIV1_SNPs_hg19_start_inclusive_end_inclusive.txt" ;
	public static final String HIV1_SNPS_START_INCLUSIVE_END_INCLUSIVE_WITHOUT_OVERLAPS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "inputdata" + System.getProperty("file.separator") + "process" + System.getProperty("file.separator") + "HIV1_SNPs_hg19_start_inclusive_end_inclusive_without_overlaps.txt" ;
	
	public static final String RANDOMLY_GENERATED_DATA_FILE = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "RandomlyGeneratedData" + System.getProperty("file.separator") + "PERMUTATION4_RANDOMLY_GENERATED_DATA.txt";
	
	//Is an interval tree node an original node or a merged node?
	public static final String ORIGINAL_NODE = "ORIGINAL_NODE";
	public static final String MERGED_NODE = "MERGED_NODE";
	
	//For Whole Genome Sliding Window
	public static final String ORIGINAL_READ_LINE = "ORIGINAL_READ_LINE";
	public static final String DEGENERATED_LINE = "DEGENERATED_LINE";
	
	
	
	public static final String SENTINEL = "SENTINEL";
	public static final String NOT_SENTINEL = "NOT_SENTINEL";
	
	public static final char RED = 'r';
	public static final char BLACK = 'b';
	
	public static final String INSERT = "INSERT";
	public static final String DELETE = "DELETE";
	public static final String chr = "chr";
	
	public static final String PROCESS_INPUT_DATA_REMOVE_OVERLAPS = "PROCESS_INPUT_DATA_REMOVE_OVERLAPS";
	
		
	public static final String FTP_ENCODE_DNASE_DIRECTORY1 	= INPUT_DATA + "ENCODE" + System.getProperty("file.separator") + "dnase";
	public static final String FTP_ENCODE_DNASE_DIRECTORY2 	= INPUT_DATA + "ENCODE" + System.getProperty("file.separator") + "dnase_jul2010";
	public static final String FTP_ENCODE_TFBS_DIRECTORY 	= INPUT_DATA + "ENCODE" + System.getProperty("file.separator") + "transcription_factors";
	public static final String FTP_ENCODE_HISTONE_DIRECTORY = INPUT_DATA + "ENCODE" + System.getProperty("file.separator") + "histone_macs";
	
	public static final String STRING_HYPHEN = "-";
	
	public static final String HYPHEN = "HYPHEN";
	public static final String TEST_LINEAR_SEARCH_VERSUS_INTERVAL_TREE_SEARCH =OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "testlinearsearchversusintervaltreesearch" + System.getProperty("file.separator") + "Compare.txt";
	
	public static int NUMBER_OF_CHROMOSOMES_HG19 = 24;
	
//	Calculations
	public static final String HG19_CHROMOSOME_SIZES_INPUT_FILE = INPUT_DATA + "FTP" + System.getProperty("file.separator") + "HG19_CHROM_SIZES" + System.getProperty("file.separator") + "hg19.chrom.sizes.txt";
	
	
	//ANNOTATE
	public static final String ANNOTATE_INTERVALS_DNASE_RESULTS_GIVEN_SEARCH_INPUT =  OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "number_of_k_out_of_n_search_input_lines_dnase_results.txt";
	public static final String ANNOTATE_INTERVALS_TF_RESULTS_GIVEN_SEARCH_INPUT =  OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "number_of_k_out_of_n_search_input_lines_tf_results.txt";
	public static final String ANNOTATE_INTERVALS_HISTONE_RESULTS_GIVEN_SEARCH_INPUT =  OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "number_of_k_out_of_n_search_input_lines_histone_results.txt";
	
	public static final String ANNOTATE_INTERVALS_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT =  OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "number_of_k_out_of_n_search_input_lines_exon_based_kegg_pathway_results.txt";
	public static final String ANNOTATE_INTERVALS_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT =  OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "number_of_k_out_of_n_search_input_lines_regulation_based_kegg_pathway_results.txt";
	public static final String ANNOTATE_INTERVALS_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT =  OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "number_of_k_out_of_n_search_input_lines_all_based_kegg_pathway_results.txt";
	
	public static final String ANNOTATE_INTERVALS_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT =  OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "number_of_k_out_of_n_search_input_lines_tf_cellLine_exon_based_kegg_pathway_results.txt";
	public static final String ANNOTATE_INTERVALS_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT =  OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "number_of_k_out_of_n_search_input_lines_tf_cellLine_regulation_based_kegg_pathway_results.txt";
	public static final String ANNOTATE_INTERVALS_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT =  OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "number_of_k_out_of_n_search_input_lines_tf_cellLine_all_based_kegg_pathway_results.txt";
	
	public static final String ANNOTATE_INTERVALS_TF_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT =  OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "number_of_k_out_of_n_search_input_lines_tf_exon_based_kegg_pathway_results.txt";
	public static final String ANNOTATE_INTERVALS_TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT =  OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "number_of_k_out_of_n_search_input_lines_tf_regulation_based_kegg_pathway_results.txt";
	public static final String ANNOTATE_INTERVALS_TF_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT =  OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "results" + System.getProperty("file.separator") + "number_of_k_out_of_n_search_input_lines_tf_all_based_kegg_pathway_results.txt";
			
	//whole genome using interval tree
	public static final String DNASE_CELL_LINE_WHOLE_GENOME_USING_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "wholegenome" + System.getProperty("file.separator") + "nonoverlappingbasepairs" + System.getProperty("file.separator") + "wholegenome_intervaltree" + System.getProperty("file.separator") + "dnaseCellLine_whole_genome_using_interval_tree_number_of_non_overlapping_base_pairs_.txt";
	public static final String DUMMY_DNASE_CELL_LINE_WHOLE_GENOME_USING_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "wholegenome" + System.getProperty("file.separator") + "nonoverlappingbasepairs" + System.getProperty("file.separator") + "wholegenome_intervaltree" + System.getProperty("file.separator") + "dummy_dnase_cell_line_whole_genome_using_interval_tree_number_of_non_overlapping_base_pairs_.txt";
	public static final String TFBS_WHOLE_GENOME_USING_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "wholegenome" + System.getProperty("file.separator") + "nonoverlappingbasepairs" + System.getProperty("file.separator") + "wholegenome_intervaltree" + System.getProperty("file.separator") + "tfbs_whole_genome_using_interval_tree_number_of_non_overlapping_base_pairs_.txt";
	public static final String HISTONE_WHOLE_GENOME_USING_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "wholegenome" + System.getProperty("file.separator") + "nonoverlappingbasepairs" + System.getProperty("file.separator") + "wholegenome_intervaltree" + System.getProperty("file.separator") + "histone_whole_genome_using_interval_tree_number_of_non_overlapping_base_pairs_.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_WHOLE_GENOME_USING_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "wholegenome" + System.getProperty("file.separator") + "nonoverlappingbasepairs" + System.getProperty("file.separator") + "wholegenome_intervaltree" + System.getProperty("file.separator") + "exon_based_kegg_pathway_whole_genome_using_interval_tree_number_of_non_overlapping_base_pairs.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_WHOLE_GENOME_USING_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "wholegenome" + System.getProperty("file.separator") + "nonoverlappingbasepairs" + System.getProperty("file.separator") + "wholegenome_intervaltree" + System.getProperty("file.separator") + "regulation_based_kegg_pathway_whole_genome_using_interval_tree_number_of_non_overlapping_base_pairs_.txt";

	//whole genome using sliding window
	public static final String DNASE_CELL_LINE_WHOLE_GENOME_USING_SLIDING_WINDOW = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "wholegenome" + System.getProperty("file.separator") + "nonoverlappingbasepairs" + System.getProperty("file.separator") + "wholegenome_slidingwindow" + System.getProperty("file.separator") + "dnaseCellLine_whole_genome_using_sliding_window_number_of_non_overlapping_base_pairs.txt";
	public static final String TFBS_WHOLE_GENOME_USING_SLIDING_WINDOW = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "wholegenome" + System.getProperty("file.separator") + "nonoverlappingbasepairs" + System.getProperty("file.separator") + "wholegenome_slidingwindow" + System.getProperty("file.separator") + "tfbs_whole_genome_sliding_window_number_of_non_overlapping_base_pairs_.txt";		
	public static final String HISTONE_WHOLE_GENOME_USING_SLIDING_WINDOW = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "wholegenome" + System.getProperty("file.separator") + "nonoverlappingbasepairs" + System.getProperty("file.separator") + "wholegenome_slidingwindow" + System.getProperty("file.separator") + "histone_whole_genome_sliding_window_number_of_non_overlapping_base_pairs.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_WHOLE_GENOME_USING_SLIDING_WINDOW = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "wholegenome" + System.getProperty("file.separator") + "nonoverlappingbasepairs" + System.getProperty("file.separator") + "wholegenome_slidingwindow" + System.getProperty("file.separator") + "exon_based_kegg_pathway_whole_genome_sliding_window_number_of_non_overlapping_base_pairs.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_WHOLE_GENOME_USING_SLIDING_WINDOW = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "wholegenome" + System.getProperty("file.separator") + "nonoverlappingbasepairs" + System.getProperty("file.separator") + "wholegenome_slidingwindow" + System.getProperty("file.separator") + "regulation_based_kegg_pathway_whole_genome_sliding_window_number_of_non_overlapping_base_pairs.txt";
	
	//empirical P values
	public static final String DNASE_CELL_LINE_NAME_EMPIRICAL_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_EmpiricalPValues";
	public static final String TFBS_NAME_CELL_LINE_NAME_EMPIRICAL_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_EmpiricalPValues";
	public static final String HISTONE_NAME_CELL_LINE_NAME_EMPIRICAL_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "histone_EmpiricalPValues";
	public static final String EXON_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_EmpiricalPValues";
	public static final String REGULATION_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_EmpiricalPValues";
	public static final String ALL_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "allBasedKeggPathway_EmpiricalPValues";
	public static final String TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfCellLineExonBasedKeggPathway_EmpiricalPValues";
	public static final String TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfCellLineRegulationBasedKeggPathway_EmpiricalPValues";
	public static final String TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfCellLineAllBasedKeggPathway_EmpiricalPValues";
	public static final String TF_EXON_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfExonBasedKeggPathway_EmpiricalPValues";
	public static final String TF_REGULATION_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfRegulationBasedKeggPathway_EmpiricalPValues";
	public static final String TF_ALL_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfAllBasedKeggPathway_EmpiricalPValues";

	//empirical P values using Bonferroni Correction
	public static final String DNASE_CELL_LINE_NAME_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BonfCorr_EmpiricalPValues";
	public static final String TFBS_NAME_CELL_LINE_NAME_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BonfCorr_EmpiricalPValues";
	public static final String HISTONE_NAME_CELL_LINE_NAME_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BonfCorr_EmpiricalPValues";
	public static final String EXON_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BonfCorr_EmpiricalPValues";
	public static final String REGULATION_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BonfCorr_EmpiricalPValues";
	public static final String ALL_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "allBasedKeggPathway_BonfCorr_EmpiricalPValues";
	public static final String TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfCellLineExonBasedKeggPathway_BonfCorr_EmpiricalPValues";
	public static final String TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfCellLineRegulationBasedKeggPathway_BonfCorr_EmpiricalPValues";
	public static final String TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfCellLineAllBasedKeggPathway_BonfCorr_EmpiricalPValues";
	public static final String TF_EXON_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfExonBasedKeggPathway_BonfCorr_EmpiricalPValues";
	public static final String TF_REGULATION_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfRegulationBasedKeggPathway_BonfCorr_EmpiricalPValues";
	public static final String TF_ALL_BASED_KEGG_PATHWAY_EMPIRICAL_P_VALUES_USING_BONFERRONI_CORRECTION = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfAllBasedKeggPathway_BonfCorr_EmpiricalPValues";
	
	
	//Significant for FDR
	public static final String DNASE_CELL_LINE_NAME_BENJAMINI_HOCHBERG_FDR = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "dnase_BH_FDR";
	public static final String TFBS_NAME_CELL_LINE_NAME_BENJAMINI_HOCHBERG_FDR = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfbs_BH_FDR";
	public static final String HISTONE_NAME_CELL_LINE_NAME_BENJAMINI_HOCHBERG_FDR = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "histone_BH_FDR";
	public static final String EXON_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "exonBasedKeggPathway_BH_FDR";
	public static final String REGULATION_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "regulationBasedKeggPathway_BH_FDR";
	public static final String ALL_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "allBasedKeggPathway_BH_FDR";
	public static final String TF_EXON_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfExonBasedKeggPathway_BH_FDR";
	public static final String TF_REGULATION_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfRegulationBasedKeggPathway_BH_FDR";
	public static final String TF_ALL_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfAllBasedKeggPathway_BH_FDR";
	public static final String TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfCellLineExonBasedKeggPathway_BH_FDR";
	public static final String TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfCellLineRegulationBasedKeggPathway_BH_FDR";
	public static final String TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_BENJAMINI_HOCHBERG_FDR = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "tfCellLineAllBasedKeggPathway_BH_FDR";
	
	
	//Empirical P Value type
	public static final String BONFERRONI_CORRECTED_EMPIRICAL_P_VALUE = "BONFERRONI_CORRECTED_EMPIRICAL_P_VALUE";
	public static final String EMPIRICAL_P_VALUE = "EMPIRICAL_P_VALUE";
	public static final String BENJAMINI_HOCHBERG_FDR_ADJUSTED_P_VALUE = "BENJAMINI_HOCHBERG_FDR_ADJUSTED_P_VALUE";
	

	//empirical P values 
	//directories for annotation of permutations
	public static final String ANNOTATE_PERMUTATIONS_FOR_DNASE = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "dnase" + System.getProperty("file.separator");
	public static final String ANNOTATE_PERMUTATIONS_FOR_TFBS = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfbs" + System.getProperty("file.separator");
	public static final String ANNOTATE_PERMUTATIONS_FOR_HISTONE = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "histone" + System.getProperty("file.separator");
	
	public static final String ANNOTATE_PERMUTATIONS_FOR_EXON_BASED_KEGG_PATHWAY_ANALYSIS = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "keggPathway" + System.getProperty("file.separator") + "exonBased" + System.getProperty("file.separator");
	public static final String ANNOTATE_PERMUTATIONS_FOR_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "keggPathway" + System.getProperty("file.separator") + "regulationBased" + System.getProperty("file.separator");
	public static final String ANNOTATE_PERMUTATIONS_FOR_ALL_BASED_KEGG_PATHWAY_ANALYSIS = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "keggPathway" + System.getProperty("file.separator") + "allBased" + System.getProperty("file.separator");
	
	public static final String ANNOTATE_PERMUTATIONS_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_ANALYSIS = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfCellLineKeggPathway" + System.getProperty("file.separator") + "tfCellLineExonBased" + System.getProperty("file.separator");
	public static final String ANNOTATE_PERMUTATIONS_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfCellLineKeggPathway" + System.getProperty("file.separator") + "tfCellLineRegulationBased" + System.getProperty("file.separator");
	public static final String ANNOTATE_PERMUTATIONS_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_ANALYSIS = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfCellLineKeggPathway" + System.getProperty("file.separator") + "tfCellLineAllBased" + System.getProperty("file.separator");
	
	public static final String ANNOTATE_PERMUTATIONS_TF_EXON_BASED_KEGG_PATHWAY_ANALYSIS = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfKeggPathway" + System.getProperty("file.separator") + "tfExonBased" + System.getProperty("file.separator");
	public static final String ANNOTATE_PERMUTATIONS_TF_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfKeggPathway" + System.getProperty("file.separator") + "tfRegulationBased" + System.getProperty("file.separator");
	public static final String ANNOTATE_PERMUTATIONS_TF_ALL_BASED_KEGG_PATHWAY_ANALYSIS = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfKeggPathway" + System.getProperty("file.separator") + "tfAllBased" + System.getProperty("file.separator");

	public static final String E_DOKTORA_ECLIPSE_WORKSPACE_ANNOTATE_PERMUTATIONS = LARGE_OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator");
	public static final String ANNOTATE_INTERVALS_PARAMETRIC = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator");
	
	//Results to be polled 
	
	public static final String TO_BE_POLLED_DIRECTORY 	= OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "empiricalpvalues" + System.getProperty("file.separator") + "toBePolled" + System.getProperty("file.separator");
	
	public static final String TO_BE_POLLED_DNASE_NUMBER_OF_OVERLAPS 	= TO_BE_POLLED_DIRECTORY + "Dnase" + System.getProperty("file.separator") + "Dnase";
	public static final String TO_BE_POLLED_HISTONE_NUMBER_OF_OVERLAPS 	= TO_BE_POLLED_DIRECTORY + "Histone" + System.getProperty("file.separator") + "Histone";
	public static final String TO_BE_POLLED_TF_NUMBER_OF_OVERLAPS		= TO_BE_POLLED_DIRECTORY + "Tf" + System.getProperty("file.separator") + "Tf";
	
	public static final String TO_BE_POLLED_EXON_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS = TO_BE_POLLED_DIRECTORY + "KeggPathway" + System.getProperty("file.separator") + "ExonBased";
	public static final String TO_BE_POLLED_REGULATION_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS = TO_BE_POLLED_DIRECTORY + "KeggPathway" + System.getProperty("file.separator") + "RegulationBased";
	public static final String TO_BE_POLLED_ALL_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS = TO_BE_POLLED_DIRECTORY + "KeggPathway" + System.getProperty("file.separator") + "AllBased";
	
	public static final String TO_BE_POLLED_TF_EXON_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS = TO_BE_POLLED_DIRECTORY + "TfKeggPathway" + System.getProperty("file.separator") + "TfExonBasedKeggPathway";
	public static final String TO_BE_POLLED_TF_REGULATION_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS = TO_BE_POLLED_DIRECTORY + "TfKeggPathway" + System.getProperty("file.separator") + "TfRegulationBasedKeggPathway";
	public static final String TO_BE_POLLED_TF_ALL_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS = TO_BE_POLLED_DIRECTORY + "TfKeggPathway" + System.getProperty("file.separator") + "TfAllBasedKeggPathway";
	
	public static final String TO_BE_POLLED_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS = TO_BE_POLLED_DIRECTORY + "TfCellLineKeggPathway" + System.getProperty("file.separator") + "TfCellLineExonBasedKeggPathway";
	public static final String TO_BE_POLLED_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS = TO_BE_POLLED_DIRECTORY + "TfCellLineKeggPathway" + System.getProperty("file.separator") + "TfCellLineRegulationBasedKeggPathway";;
	public static final String TO_BE_POLLED_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_NUMBER_OF_OVERLAPS = TO_BE_POLLED_DIRECTORY + "TfCellLineKeggPathway" + System.getProperty("file.separator") + "TfCellLineAllBasedKeggPathway";
	
	
	//binomial distribution
	public static final String DNASE_CELLLINE_NAMES_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "dnase_pvalues.txt";
	public static final String DNASE_CELLLINE_NAMES_ADJUSTED_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "dnase_adjusted_pvalues.txt";
	public static final String DNASE_CELLLINE_NAMES_ALL_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "dnase_all_values.txt";
	public static final String DNASE_CELLLINE_NAMES_ADJUSTED_ALL_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "dnase_adjusted_all_values.txt";
	
	public static final String TFBS_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "tfbs_pvalues.txt";
	public static final String TFBS_ADJUSTED_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "tfbs_adjusted_pvalues.txt";
	public static final String TFBS_ALL_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "tfbs_all_values.txt";
	public static final String TFBS_ADJUSTED_ALL_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "tfbs_adjusted_all_values.txt";
	
	public static final String HISTONE_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "histone_pvalues.txt";
	public static final String HISTONE_ADJUSTED_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "histone_adjusted_pvalues.txt";
	public static final String HISTONE_ALL_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "histone_all_values.txt";
	public static final String HISTONE_ADJUSTED_ALL_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "histone_adjusted_all_values.txt";
	
	public static final String EXON_BASED_KEGG_PATHWAY_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "exonBased_KeggPathway_pvalues.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "exonBased_KeggPathway_adjusted_pvalues.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ALL_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "exonBased_KeggPathway_all_values.txt";
	public static final String EXON_BASED_KEGG_PATHWAY_ADJUSTED_ALL_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "exonBased_KeggPathway_adjusted_all_values.txt";
	
	public static final String REGULATION_BASED_KEGG_PATHWAY_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "regulationBased_KeggPathway_pvalues.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_P_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "regulationBased_KeggPathway_adjusted_pvalues.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ALL_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "regulationBased_KeggPathway_all_values.txt";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ADJUSTED_ALL_VALUES = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "binomialdistribution" + System.getProperty("file.separator") + "regulationBased_KeggPathway_adjusted_all_values.txt";
	
	public static final String CALCULATE_USING_BINOMIAL_DISTRIBUTION = "CALCULATE_USING_BINOMIAL_DISTRIBUTION";
	public static final String CALCULATE_USING_BURCAK_BINOMIAL_DISTRIBUTION = "CALCULATE_USING_BURCAK_BINOMIAL_DISTRIBUTION";
	
	public static final String EXON = "EXON";
	public static final String INTRON = "INTRON";
	public static final String FIVE_P_ONE = "5P1";
	public static final String FIVE_P_TWO = "5P2";
	public static final String THREE_P_ONE = "3P1";
	public static final String THREE_P_TWO = "3P2";
	
	public static final String EXON_BASED_KEGG_PATHWAY_ANALYSIS 		= "EXON_BASED_KEGG_PATHWAY_ANALYSIS";
	public static final String REGULATION_BASED_KEGG_PATHWAY_ANALYSIS 	= "REGULATION_BASED_KEGG_PATHWAY_ANALYSIS";
	public static final String ALL_BASED_KEGG_PATHWAY_ANALYSIS 	= "ALL_BASED_KEGG_PATHWAY_ANALYSIS";
	
	//Annotation Type
	public static final String DNASE_ANNOTATION 		= "DNASE_ANNOTATION";
	public static final String TFBS_ANNOTATION 			= "TFBS_ANNOTATION";
	public static final String HISTONE_ANNOTATION 		= "HISTONE_ANNOTATION";
	public static final String UCSC_REFSEQ_GENE_ANNOTATION = "UCSC_REFSEQ_GENE_ANNOTATION";
	public static final String TF_CELLLINE_KEGG_PATHWAY_ANNOTATION = "TF_CELLLINE_KEGG_PATHWAY_ANNOTATION";
	public static final String TF_KEGG_PATHWAY_ANNOTATION = "TF_KEGG_PATHWAY_ANNOTATION";

	//Enrichment Type
	public static final String DO_DNASE_ENRICHMENT 		= "DO_DNASE_ENRICHMENT";
	public static final String DO_NOT_DNASE_ENRICHMENT 	= "DO_NOT_DNASE_ENRICHMENT";
	
	public static final String DO_HISTONE_ENRICHMENT 		= "DO_HISTONE_ENRICHMENT";
	public static final String DO_NOT_HISTONE_ENRICHMENT 	= "DO_NOT_HISTONE_ENRICHMENT";

	//6 March 2014
	public static final String DO_TF_ENRICHMENT 		= "DO_TF_ENRICHMENT";
	public static final String DO_NOT_TF_ENRICHMENT 	= "DO_NOT_TF_ENRICHMENT";
	
	//6 March 2014
	public static final String DO_KEGGPATHWAY_ENRICHMENT 		= "DO_KEGGPATHWAY_ENRICHMENT";
	public static final String DO_NOT_KEGGPATHWAY_ENRICHMENT 	= "DO_NOT_KEGGPATHWAY_ENRICHMENT";
	
	//You can choose TF_CELLLINE_KEGGPATHWAY or TF_KEGGPATHWAY, not both
	//TF and KEGGPATHWAY Enrichment is done by default in case of any choice.
	public static final String DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT 		= "DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT";
	public static final String DO_NOT_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT 	= "DO_NOT_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT";
	
	public static final String DO_TF_KEGGPATHWAY_ENRICHMENT 			= "DO_TF_KEGGPATHWAY_ENRICHMENT";
	public static final String DO_NOT_TF_KEGGPATHWAY_ENRICHMENT 		= "DO_NOT_TF_KEGGPATHWAY_ENRICHMENT";

	
//	Write all possible names
	public static final String DNASE = "DNASE";
	public static final String TFBS = "TFBS";
	public static final String HISTONE = "HISTONE";
	public static final String UCSC_GENE = "UCSC_GENE";
	public static final String NCBI_GENE_ID = "NCBI_GENE_ID";
	public static final String NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION = "NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION";
	public static final String UCSC_GENE_ALTERNATE_NAME = "UCSC_GENE_ALTERNATE_NAME";
	public static final String KEGG_PATHWAY = "KEGG_PATHWAY";
	
	public static final String EXON_BASED_KEGG_PATHWAY = "EXON_BASED_KEGG_PATHWAY";
	public static final String REGULATION_BASED_KEGG_PATHWAY = "REGULATION_BASED_KEGG_PATHWAY";
	public static final String ALL_BASED_KEGG_PATHWAY = "ALL_BASED_KEGG_PATHWAY";
	
	public static final String CELLLINE = "CELLLINE";
	
	public static final String TF_CELLLINE_EXON_BASED_KEGG_PATHWAY = "TF_CELLLINE_EXON_BASED_KEGG_PATHWAY";
	public static final String TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY = "TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY";
	public static final String TF_CELLLINE_ALL_BASED_KEGG_PATHWAY = "TF_CELLLINE_ALL_BASED_KEGG_PATHWAY";
	
	public static final String TF_EXON_BASED_KEGG_PATHWAY = "TF_EXON_BASED_KEGG_PATHWAY";
	public static final String TF_REGULATION_BASED_KEGG_PATHWAY = "TF_REGULATION_BASED_KEGG_PATHWAY";
	public static final String TF_ALL_BASED_KEGG_PATHWAY = "TF_ALL_BASED_KEGG_PATHWAY";
	
	public static final String FIND_ALL = "FIND_ALL";
	public static final String FIND_FIRST = "FIND_FIRST";
	
	
// 	All possible names		
	public static final String WRITE_ALL_POSSIBLE_DNASE_CELL_NAMES_OUTPUT_DIRECTORYNAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "all_possible_names" + System.getProperty("file.separator");
	public static final String WRITE_ALL_POSSIBLE_DNASE_CELL_NAMES_OUTPUT_FILENAME = "all_possible_dnase_cell_lines_names.txt";
	
	public static final String WRITE_ALL_POSSIBLE_TFBS_NAMES_OUTPUT_DIRECTORYNAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "all_possible_names" + System.getProperty("file.separator");
	public static final String WRITE_ALL_POSSIBLE_TFBS_NAMES_OUTPUT_FILENAME = "all_possible_tfbs_names.txt";
	
	public static final String WRITE_ALL_POSSIBLE_HISTONE_NAMES_OUTPUT_DIRECTORYNAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "all_possible_names" + System.getProperty("file.separator");
	public static final String WRITE_ALL_POSSIBLE_HISTONE_NAMES_OUTPUT_FILENAME = "all_possible_histone_names.txt";
		
	public static final String WRITE_ALL_POSSIBLE_GENE_IDS_OUTPUT_DIRECTORYNAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "all_possible_names" + System.getProperty("file.separator");	
	public static final String WRITE_ALL_POSSIBLE_GENE_IDS_OUTPUT_FILENAME =  "all_possible_gene_ids.txt";	
	
	public static final String WRITE_ALL_POSSIBLE_RNA_NUCLEUOTIDE_ACCESSION_VERSIONS_OUTPUT_DIRECTORYNAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "all_possible_names" + System.getProperty("file.separator");	
	public static final String WRITE_ALL_POSSIBLE_RNA_NUCLEUOTIDE_ACCESSION_VERSIONS_OUTPUT_FILENAME = "all_possible_rna_nucleotide_accession_versions.txt";	
	
	public static final String WRITE_ALL_POSSIBLE_ALTERNATE_GENE_NAMES_OUTPUT_DIRECTORYNAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "all_possible_names" + System.getProperty("file.separator");	
	public static final String WRITE_ALL_POSSIBLE_ALTERNATE_GENE_NAMES_OUTPUT_FILENAME = "all_possible_alternate_gene_names.txt";	
	
	public static final String WRITE_ALL_POSSIBLE_KEGG_PATHWAY_NAMES_OUTPUT_DIRECTORYNAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "all_possible_names" + System.getProperty("file.separator");
	public static final String WRITE_ALL_POSSIBLE_KEGG_PATHWAY_NAMES_OUTPUT_FILENAME = "all_possible_kegg_pathway_names.txt";
	
//	Kegg Pathway to Ncbi Ref Seq Gene Ids
	public static final String KEGG_PATHWAY_ENTRY_2_NAME_INPUT_FILE = INPUT_DATA + "KEGG" + System.getProperty("file.separator") + "list_pathway_hsa.txt";
	public static final String KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE = INPUT_DATA + "KEGG" + System.getProperty("file.separator") + "pathway_hsa.list";
	public static final String ALL_POSSIBLE_KEGG_PATHWAY_NAMES_OUTPUT_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "keggpathway" + System.getProperty("file.separator") + "ncbigenes" + System.getProperty("file.separator") + "all_possible_kegg_pathway_names.txt";
	public static final String KEGG_PATHWAY_2_NCBI_GENE_IDS_OUTPUT_FILE_PATH = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "keggpathway" + System.getProperty("file.separator") + "ncbigenes" + System.getProperty("file.separator");
	
	
//	Annotate intervals using interval tree
	public static final String TCGA_INPUT_DATA_WITH_NON_BLANKS_SNP_IDS_WITH_OVERLAPS = INPUT_DATA + "FTP" + System.getProperty("file.separator") + "TCGA" + System.getProperty("file.separator") + "SearchInputTCGADataWithNonBlankSNPRows.txt";
	public static final String TCGA_INPUT_DATA_WITH_NON_BLANKS_SNP_IDS_WITHOUT_OVERLAPS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "inputdata" + System.getProperty("file.separator") + "process" + System.getProperty("file.separator") + "TCGAInputDataWithNonBlankSNPsWithoutOverlaps.txt";
	
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_DNASE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "dnase" + System.getProperty("file.separator");
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TFBS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfbs" + System.getProperty("file.separator");
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_HISTONE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "histone" + System.getProperty("file.separator");
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_NCBI_GENE_ID = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "ncbiGeneId" + System.getProperty("file.separator");
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_NCBI_RNA = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "ncbiRNA" + System.getProperty("file.separator");
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_UCSC_GENE_ALTERNATE_NAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "ucscGeneAlternateName" + System.getProperty("file.separator");
	
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_EXON_BASED_KEGG_PATHWAY_ANALYSIS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "keggPathway" + System.getProperty("file.separator") + "exonBased" + System.getProperty("file.separator");
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "keggPathway" + System.getProperty("file.separator") + "regulationBased" + System.getProperty("file.separator");
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_ALL_BASED_KEGG_PATHWAY_ANALYSIS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "keggPathway" + System.getProperty("file.separator") + "allBased" + System.getProperty("file.separator");
	
	
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfCellLineKeggPathway" + System.getProperty("file.separator") + "tfCellLineExonBased" + System.getProperty("file.separator");
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfCellLineKeggPathway" + System.getProperty("file.separator") + "tfCellLineRegulationBased" + System.getProperty("file.separator");
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfCellLineKeggPathway" + System.getProperty("file.separator") + "tfCellLineAllBased" + System.getProperty("file.separator");
	
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_EXON_BASED_KEGG_PATHWAY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfKeggPathway" + System.getProperty("file.separator") + "tfExonBased" + System.getProperty("file.separator");
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_REGULATION_BASED_KEGG_PATHWAY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfKeggPathway" + System.getProperty("file.separator") + "tfRegulationBased" + System.getProperty("file.separator");
	public static final String ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_ALL_BASED_KEGG_PATHWAY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator") + "tfKeggPathway" + System.getProperty("file.separator") + "tfAllBased" + System.getProperty("file.separator");
		
//	Search using Linear search
	public static final String SEARCH_USING_LINEAR_SEARCH_INPUT_FILE =INPUT_DATA + "FTP" + System.getProperty("file.separator") + "TCGA" + System.getProperty("file.separator") + "SearchInputforTCGATestData_three_columns.txt";
	public static final String SEARCH_USING_LINEAR_SEARCH_OUTPUT_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "search" + System.getProperty("file.separator") + "encodeucscgenome" + System.getProperty("file.separator") + "SearchOutput_Using_LinearSearch.txt";	
	
// 	Searching using IntervalTree 	
//	public static final String SEARCH_USING_INTERVAL_TREE_INPUT_FILE = INPUT_DATA + "FTP" + System.getProperty("file.separator") + "TCGA" + System.getProperty("file.separator") + "SearchInputTCGADataWithNonBlankSNPRows.txt";
	public static final String SEARCH_USING_INTERVAL_TREE_OUTPUT_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "search" + System.getProperty("file.separator") + "encodeucscgenome" + System.getProperty("file.separator") + "SearchOutput_Using_IntervalTreeSearch.txt";
	
	
	public static final String ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "intervals" + System.getProperty("file.separator") + "parametric" + System.getProperty("file.separator");
	
	public static final String SEARCH_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "search" + System.getProperty("file.separator") + "encodeucscgenome" + System.getProperty("file.separator");
	
	
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR1_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr1_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR2_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr2_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR3_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr3_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR4_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr4_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR5_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr5_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR6_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr6_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR7_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr7_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR8_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr8_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR9_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr9_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR10_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr10_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR11_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr11_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR12_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr12_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR13_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr13_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR14_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr14_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR15_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr15_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR16_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr16_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR17_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr17_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR18_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr18_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR19_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr19_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR20_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr20_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR21_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr21_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHR22_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chr22_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHRX_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chrX_ucsc_refseq_genes_interval_tree.txt";
	public static final String C_ECLIPSE_WORKSPACE_DOKTORA_CREATE_UCSCGENOME_SORTED_CHRY_UCSC_REFSEQ_GENES_INTERVAL_TREE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator") + "sorted_with_Interval_Tree_Infix_Traversal" + System.getProperty("file.separator") + "sorted_chrY_ucsc_refseq_genes_interval_tree.txt";
			
	//Downloaded from ncbi, gene2refseq.txt data
	public static final String NCBI_GENE_TO_REF_SEQ = INPUT_DATA + "FTP" + System.getProperty("file.separator") + "GENE_2_REFSEQ" + System.getProperty("file.separator") + "gene2refseq" + System.getProperty("file.separator") + "gene2refseq.txt";	
	
	public static final String NCBI_HUMAN_GENE_TO_REF_SEQ_DIRECTORYNAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "ncbi" + System.getProperty("file.separator");
	public static final String NCBI_HUMAN_GENE_TO_REF_SEQ_FILENAME ="human_gene2refseq.txt";

	public static final String NCBI_HUMAN_REF_SEQ_TO_GENE_DIRECTORYNAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "ncbi" + System.getProperty("file.separator");
	public static final String NCBI_HUMAN_REF_SEQ_TO_GENE_FILENAME = "human_refseq2gene.txt";

	public static final String NCBI_HUMAN_REF_SEQ_TO_GENE_2_DIRECTORYNAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "ncbi" + System.getProperty("file.separator");
	public static final String NCBI_HUMAN_REF_SEQ_TO_GENE_2_FILENAME = "human_refseq2gene2.txt";
		
//	These files have been downloaded from ftp.ebi.ac.uk
//	They have been unzipped.
//	These files are yet unprocessed. 
//	They will be processed and will be accumated in corresponding chromosome base files first in unsorted manner then in sorted manner.
	public static final String TRANSCRIPTION_FACTOR_FILES_DIRECTORY = "C:" + System.getProperty("file.separator") + "eclipse_ganymede" + System.getProperty("file.separator") + "workspace" + System.getProperty("file.separator") + "ftp_encode" + System.getProperty("file.separator") + "transcription_factors";
	public static final String HISTONE_MARK_FILES_DIRECTORY = "C:" + System.getProperty("file.separator") + "eclipse_ganymede" + System.getProperty("file.separator") + "workspace" + System.getProperty("file.separator") + "ftp_encode" + System.getProperty("file.separator") + "histone_macs";
	public static final String DNASE_JUL2010_FILES_DIRECTORY = "C:" + System.getProperty("file.separator") + "eclipse_ganymede" + System.getProperty("file.separator") + "workspace" + System.getProperty("file.separator") + "ftp_encode" + System.getProperty("file.separator") + "dnase_jul2010";
	public static final String DNASE_FILES_DIRECTORY = "C:" + System.getProperty("file.separator") + "eclipse_ganymede" + System.getProperty("file.separator") + "workspace" + System.getProperty("file.separator") + "ftp_encode" + System.getProperty("file.separator") + "dnase";
	
	
	public static final String SEARCH_INPUT_FILE_WITH_NON_BLANK_SNP_IDS= INPUT_DATA + "FTP" + System.getProperty("file.separator") + "TCGA" + System.getProperty("file.separator") + "SearchInputWithNonBlankSNPIDs.txt";
	public static final String SEARCH_INPUT_FILE_FOR_TCGA_TEST_DATA = INPUT_DATA + "FTP" + System.getProperty("file.separator") + "TCGA" + System.getProperty("file.separator") + "SearchInputforTCGATestData.txt";
	public static final String SEARCH_INPUT_FILE_FOR_TCGA_DATA_WITH_NON_BLANK_SNP_ROWS = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "testtcgadata" + System.getProperty("file.separator") + "SearchInputTCGADataWithNonBlankSNPRows.txt";
	public static final String SEARCH_OUTPUT_FILE_FOR_TCGA_TEST_DATA = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "testtcgadata" + System.getProperty("file.separator") + "SearchOutputforTCGATestData.txt";
	
	
	public static final String SEARCH_OUTPUT_FILE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "annotate" + System.getProperty("file.separator") + "using" + System.getProperty("file.separator") + "encode" + System.getProperty("file.separator") + "SearchOutput.txt";
	
	
	public static final String FTP_HG19_REFSEQ_GENES = INPUT_DATA + "FTP" + System.getProperty("file.separator") + "HG19_REFSEQ_GENES" + System.getProperty("file.separator") + "hg19_refseq_genes.txt"; 
	
	public static final String ANNOTATE_UCSC_ANALYZE_HG19_REFSEQ_GENES_DIRECTORYNAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator");
	public static final String ANNOTATE_UCSC_ANALYZE_HG19_REFSEQ_GENES_FILENAME = "analyze_hg19_refseq_genes.txt";
	
	public static final String CHROMOSOME1 = "chr1";
	public static final String CHROMOSOME2 = "chr2";
	public static final String CHROMOSOME3 = "chr3";
	public static final String CHROMOSOME4 = "chr4";
	public static final String CHROMOSOME5 = "chr5";
	public static final String CHROMOSOME6 = "chr6";
	public static final String CHROMOSOME7 = "chr7";
	public static final String CHROMOSOME8 = "chr8";
	public static final String CHROMOSOME9 = "chr9";
	public static final String CHROMOSOME10 = "chr10";
	public static final String CHROMOSOME11 = "chr11";
	public static final String CHROMOSOME12 = "chr12";
	public static final String CHROMOSOME13 = "chr13";
	public static final String CHROMOSOME14 = "chr14";
	public static final String CHROMOSOME15 = "chr15";
	public static final String CHROMOSOME16 = "chr16";
	public static final String CHROMOSOME17 = "chr17";
	public static final String CHROMOSOME18 = "chr18";
	public static final String CHROMOSOME19 = "chr19";
	public static final String CHROMOSOME20 = "chr20";
	public static final String CHROMOSOME21 = "chr21";
	public static final String CHROMOSOME22 = "chr22";
	public static final String CHROMOSOMEX = "chrX";
	public static final String CHROMOSOMEY = "chrY";
	
	//Create ucsc refseq genes directory
	public static final String CREATE_UCSCGENOME_REFSEQ_GENES_DIRECTORYNAME = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "ucscgenome" + System.getProperty("file.separator");
	
	
	//Unsorted Chromosome Base RefSeq Gene Files
	public static final String UNSORTED_CHR1_REFSEQ_GENES = "unsorted_chr1_refseq_genes.txt";
	public static final String UNSORTED_CHR2_REFSEQ_GENES = "unsorted_chr2_refseq_genes.txt";
	public static final String UNSORTED_CHR3_REFSEQ_GENES = "unsorted_chr3_refseq_genes.txt";
	public static final String UNSORTED_CHR4_REFSEQ_GENES = "unsorted_chr4_refseq_genes.txt";
	public static final String UNSORTED_CHR5_REFSEQ_GENES = "unsorted_chr5_refseq_genes.txt";
	public static final String UNSORTED_CHR6_REFSEQ_GENES = "unsorted_chr6_refseq_genes.txt";
	public static final String UNSORTED_CHR7_REFSEQ_GENES = "unsorted_chr7_refseq_genes.txt";
	public static final String UNSORTED_CHR8_REFSEQ_GENES = "unsorted_chr8_refseq_genes.txt";
	public static final String UNSORTED_CHR9_REFSEQ_GENES = "unsorted_chr9_refseq_genes.txt";
	public static final String UNSORTED_CHR10_REFSEQ_GENES = "unsorted_ch10_refseq_genes.txt";
	public static final String UNSORTED_CHR11_REFSEQ_GENES = "unsorted_chr11_refseq_genes.txt";
	public static final String UNSORTED_CHR12_REFSEQ_GENES = "unsorted_chr12_refseq_genes.txt";
	public static final String UNSORTED_CHR13_REFSEQ_GENES = "unsorted_chr13_refseq_genes.txt";
	public static final String UNSORTED_CHR14_REFSEQ_GENES = "unsorted_chr14_refseq_genes.txt";
	public static final String UNSORTED_CHR15_REFSEQ_GENES = "unsorted_chr15_refseq_genes.txt";
	public static final String UNSORTED_CHR16_REFSEQ_GENES = "unsorted_chr16_refseq_genes.txt";
	public static final String UNSORTED_CHR17_REFSEQ_GENES = "unsorted_chr17_refseq_genes.txt";
	public static final String UNSORTED_CHR18_REFSEQ_GENES = "unsorted_chr18_refseq_genes.txt";
	public static final String UNSORTED_CHR19_REFSEQ_GENES = "unsorted_chr19_refseq_genes.txt";
	public static final String UNSORTED_CHR20_REFSEQ_GENES = "unsorted_chr20_refseq_genes.txt";
	public static final String UNSORTED_CHR21_REFSEQ_GENES = "unsorted_chr21_refseq_genes.txt";
	public static final String UNSORTED_CHR22_REFSEQ_GENES = "unsorted_chr22_refseq_genes.txt";
	public static final String UNSORTED_CHRX_REFSEQ_GENES = "unsorted_chrX_refseq_genes.txt";
	public static final String UNSORTED_CHRY_REFSEQ_GENES =  "unsorted_chrY_refseq_genes.txt";
	
	//Sorted Chromosome Base RefSeq Gene Files
	public static final String SORTED_CHR1_REFSEQ_GENES = "sorted_chr1_refseq_genes.txt";
	public static final String SORTED_CHR2_REFSEQ_GENES = "sorted_chr2_refseq_genes.txt";
	public static final String SORTED_CHR3_REFSEQ_GENES = "sorted_chr3_refseq_genes.txt";
	public static final String SORTED_CHR4_REFSEQ_GENES = "sorted_chr4_refseq_genes.txt";
	public static final String SORTED_CHR5_REFSEQ_GENES = "sorted_chr5_refseq_genes.txt";
	public static final String SORTED_CHR6_REFSEQ_GENES = "sorted_chr6_refseq_genes.txt";
	public static final String SORTED_CHR7_REFSEQ_GENES = "sorted_chr7_refseq_genes.txt";
	public static final String SORTED_CHR8_REFSEQ_GENES = "sorted_chr8_refseq_genes.txt";
	public static final String SORTED_CHR9_REFSEQ_GENES = "sorted_chr9_refseq_genes.txt";
	public static final String SORTED_CHR10_REFSEQ_GENES = "sorted_chr10_refseq_genes.txt";
	public static final String SORTED_CHR11_REFSEQ_GENES = "sorted_chr11_refseq_genes.txt";
	public static final String SORTED_CHR12_REFSEQ_GENES = "sorted_chr12_refseq_genes.txt";
	public static final String SORTED_CHR13_REFSEQ_GENES = "sorted_chr13_refseq_genes.txt";
	public static final String SORTED_CHR14_REFSEQ_GENES = "sorted_chr14_refseq_genes.txt";
	public static final String SORTED_CHR15_REFSEQ_GENES = "sorted_chr15_refseq_genes.txt";
	public static final String SORTED_CHR16_REFSEQ_GENES = "sorted_chr16_refseq_genes.txt";
	public static final String SORTED_CHR17_REFSEQ_GENES = "sorted_chr17_refseq_genes.txt";
	public static final String SORTED_CHR18_REFSEQ_GENES = "sorted_chr18_refseq_genes.txt";
	public static final String SORTED_CHR19_REFSEQ_GENES = "sorted_chr19_refseq_genes.txt";
	public static final String SORTED_CHR20_REFSEQ_GENES = "sorted_chr20_refseq_genes.txt";
	public static final String SORTED_CHR21_REFSEQ_GENES = "sorted_chr21_refseq_genes.txt";
	public static final String SORTED_CHR22_REFSEQ_GENES = "sorted_chr22_refseq_genes.txt";
	public static final String SORTED_CHRX_REFSEQ_GENES = "sorted_chrX_refseq_genes.txt";
	public static final String SORTED_CHRY_REFSEQ_GENES = "sorted_chrY_refseq_genes.txt";
	
	
	//Create Encode DNASE Directory
	public static final String CREATE_ENCODE_DNASE_DIRECTORY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "encode" + System.getProperty("file.separator") + "dnase" + System.getProperty("file.separator");
		
	//Create Encode Unsorted Chromosome Based DNASE Filenames
	public static final String UNSORTED_CHR1_DNASE_FILENAME = "unsorted_chr1_dnase.txt";
	public static final String UNSORTED_CHR2_DNASE_FILENAME = "unsorted_chr2_dnase.txt";
	public static final String UNSORTED_CHR3_DNASE_FILENAME = "unsorted_chr3_dnase.txt";
	public static final String UNSORTED_CHR4_DNASE_FILENAME = "unsorted_chr4_dnase.txt";
	public static final String UNSORTED_CHR5_DNASE_FILENAME = "unsorted_chr5_dnase.txt";
	public static final String UNSORTED_CHR6_DNASE_FILENAME = "unsorted_chr6_dnase.txt";
	public static final String UNSORTED_CHR7_DNASE_FILENAME = "unsorted_chr7_dnase.txt";
	public static final String UNSORTED_CHR8_DNASE_FILENAME = "unsorted_chr8_dnase.txt";
	public static final String UNSORTED_CHR9_DNASE_FILENAME = "unsorted_chr9_dnase.txt";
	public static final String UNSORTED_CHR10_DNASE_FILENAME = "unsorted_chr10_dnase.txt";
	public static final String UNSORTED_CHR11_DNASE_FILENAME = "unsorted_chr11_dnase.txt";
	public static final String UNSORTED_CHR12_DNASE_FILENAME = "unsorted_chr12_dnase.txt";
	public static final String UNSORTED_CHR13_DNASE_FILENAME = "unsorted_chr13_dnase.txt";
	public static final String UNSORTED_CHR14_DNASE_FILENAME = "unsorted_chr14_dnase.txt";
	public static final String UNSORTED_CHR15_DNASE_FILENAME = "unsorted_chr15_dnase.txt";
	public static final String UNSORTED_CHR16_DNASE_FILENAME = "unsorted_chr16_dnase.txt";
	public static final String UNSORTED_CHR17_DNASE_FILENAME = "unsorted_chr17_dnase.txt";
	public static final String UNSORTED_CHR18_DNASE_FILENAME = "unsorted_chr18_dnase.txt";
	public static final String UNSORTED_CHR19_DNASE_FILENAME = "unsorted_chr19_dnase.txt";
	public static final String UNSORTED_CHR20_DNASE_FILENAME = "unsorted_chr20_dnase.txt";
	public static final String UNSORTED_CHR21_DNASE_FILENAME = "unsorted_chr21_dnase.txt";
	public static final String UNSORTED_CHR22_DNASE_FILENAME = "unsorted_chr22_dnase.txt";
	public static final String UNSORTED_CHRX_DNASE_FILENAME = "unsorted_chrX_dnase.txt";
	public static final String UNSORTED_CHRY_DNASE_FILENAME = "unsorted_chrY_dnase.txt";
	
	//Sorted Chromosome Based DNASE File names
	public static final String SORTED_CHR1_DNASE_FILENAME = "sorted_chr1_dnase.txt";
	public static final String SORTED_CHR2_DNASE_FILENAME = "sorted_chr2_dnase.txt";
	public static final String SORTED_CHR3_DNASE_FILENAME = "sorted_chr3_dnase.txt";
	public static final String SORTED_CHR4_DNASE_FILENAME = "sorted_chr4_dnase.txt";
	public static final String SORTED_CHR5_DNASE_FILENAME = "sorted_chr5_dnase.txt";
	public static final String SORTED_CHR6_DNASE_FILENAME = "sorted_chr6_dnase.txt";
	public static final String SORTED_CHR7_DNASE_FILENAME = "sorted_chr7_dnase.txt";
	public static final String SORTED_CHR8_DNASE_FILENAME = "sorted_chr8_dnase.txt";
	public static final String SORTED_CHR9_DNASE_FILENAME = "sorted_chr9_dnase.txt";
	public static final String SORTED_CHR10_DNASE_FILENAME = "sorted_chr10_dnase.txt";
	public static final String SORTED_CHR11_DNASE_FILENAME = "sorted_chr11_dnase.txt";
	public static final String SORTED_CHR12_DNASE_FILENAME = "sorted_chr12_dnase.txt";
	public static final String SORTED_CHR13_DNASE_FILENAME = "sorted_chr13_dnase.txt";
	public static final String SORTED_CHR14_DNASE_FILENAME = "sorted_chr14_dnase.txt";
	public static final String SORTED_CHR15_DNASE_FILENAME = "sorted_chr15_dnase.txt";
	public static final String SORTED_CHR16_DNASE_FILENAME = "sorted_chr16_dnase.txt";
	public static final String SORTED_CHR17_DNASE_FILENAME = "sorted_chr17_dnase.txt";
	public static final String SORTED_CHR18_DNASE_FILENAME = "sorted_chr18_dnase.txt";
	public static final String SORTED_CHR19_DNASE_FILENAME = "sorted_chr19_dnase.txt";
	public static final String SORTED_CHR20_DNASE_FILENAME = "sorted_chr20_dnase.txt";
	public static final String SORTED_CHR21_DNASE_FILENAME = "sorted_chr21_dnase.txt";
	public static final String SORTED_CHR22_DNASE_FILENAME = "sorted_chr22_dnase.txt";
	public static final String SORTED_CHRX_DNASE_FILENAME = "sorted_chrX_dnase.txt";
	public static final String SORTED_CHRY_DNASE_FILENAME = "sorted_chrY_dnase.txt";
	
	
	//for debug sliding window versus interval tree
	public static final String BURCAK_DEBUG_ENCODE_SORTED_CHR1_HISTONE = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "encode" + System.getProperty("file.separator") + "histone" + System.getProperty("file.separator") + "burcak_debug_sorted_chr1_histone.txt";
		
	//CREATE ENCODE HISTONE directory
	public static final String CREATE_ENCODE_HISTONE_DIRECTORY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "encode" + System.getProperty("file.separator") + "histone" + System.getProperty("file.separator");
	
	 //Unsorted Chromosome Based HISTONE File names
	 public static final String UNSORTED_CHR1_HISTONE_FILENAME = "unsorted_chr1_histone.txt";
	 public static final String UNSORTED_CHR2_HISTONE_FILENAME = "unsorted_chr2_histone.txt";
	 public static final String UNSORTED_CHR3_HISTONE_FILENAME = "unsorted_chr3_histone.txt";
	 public static final String UNSORTED_CHR4_HISTONE_FILENAME = "unsorted_chr4_histone.txt";
	 public static final String UNSORTED_CHR5_HISTONE_FILENAME = "unsorted_chr5_histone.txt";
	 public static final String UNSORTED_CHR6_HISTONE_FILENAME = "unsorted_chr6_histone.txt";
	 public static final String UNSORTED_CHR7_HISTONE_FILENAME = "unsorted_chr7_histone.txt";
	 public static final String UNSORTED_CHR8_HISTONE_FILENAME = "unsorted_chr8_histone.txt";
	 public static final String UNSORTED_CHR9_HISTONE_FILENAME = "unsorted_chr9_histone.txt";
	 public static final String UNSORTED_CHR10_HISTONE_FILENAME = "unsorted_chr10_histone.txt";
	 public static final String UNSORTED_CHR11_HISTONE_FILENAME = "unsorted_chr11_histone.txt";
	 public static final String UNSORTED_CHR12_HISTONE_FILENAME = "unsorted_chr12_histone.txt";
	 public static final String UNSORTED_CHR13_HISTONE_FILENAME = "unsorted_chr13_histone.txt";
	 public static final String UNSORTED_CHR14_HISTONE_FILENAME = "unsorted_chr14_histone.txt";
	 public static final String UNSORTED_CHR15_HISTONE_FILENAME = "unsorted_chr15_histone.txt";
	 public static final String UNSORTED_CHR16_HISTONE_FILENAME = "unsorted_chr16_histone.txt";
	 public static final String UNSORTED_CHR17_HISTONE_FILENAME = "unsorted_chr17_histone.txt";
	 public static final String UNSORTED_CHR18_HISTONE_FILENAME = "unsorted_chr18_histone.txt";
	 public static final String UNSORTED_CHR19_HISTONE_FILENAME = "unsorted_chr19_histone.txt";
	 public static final String UNSORTED_CHR20_HISTONE_FILENAME = "unsorted_chr20_histone.txt";
	 public static final String UNSORTED_CHR21_HISTONE_FILENAME = "unsorted_chr21_histone.txt";
	 public static final String UNSORTED_CHR22_HISTONE_FILENAME = "unsorted_chr22_histone.txt";
	 public static final String UNSORTED_CHRX_HISTONE_FILENAME = "unsorted_chrX_histone.txt";
	 public static final String UNSORTED_CHRY_HISTONE_FILENAME = "unsorted_chrY_histone.txt";
		
	//Sorted Chromosome Base HISTONE File names
	public static final String SORTED_CHR1_HISTONE_FILENAME = "sorted_chr1_histone.txt";
	public static final String SORTED_CHR2_HISTONE_FILENAME = "sorted_chr2_histone.txt";
	public static final String SORTED_CHR3_HISTONE_FILENAME = "sorted_chr3_histone.txt";
	public static final String SORTED_CHR4_HISTONE_FILENAME = "sorted_chr4_histone.txt";
	public static final String SORTED_CHR5_HISTONE_FILENAME = "sorted_chr5_histone.txt";
	public static final String SORTED_CHR6_HISTONE_FILENAME = "sorted_chr6_histone.txt";
	public static final String SORTED_CHR7_HISTONE_FILENAME = "sorted_chr7_histone.txt";
	public static final String SORTED_CHR8_HISTONE_FILENAME = "sorted_chr8_histone.txt";
	public static final String SORTED_CHR9_HISTONE_FILENAME = "sorted_chr9_histone.txt";
	public static final String SORTED_CHR10_HISTONE_FILENAME = "sorted_chr10_histone.txt";
	public static final String SORTED_CHR11_HISTONE_FILENAME = "sorted_chr11_histone.txt";
	public static final String SORTED_CHR12_HISTONE_FILENAME = "sorted_chr12_histone.txt";
	public static final String SORTED_CHR13_HISTONE_FILENAME = "sorted_chr13_histone.txt";
	public static final String SORTED_CHR14_HISTONE_FILENAME = "sorted_chr14_histone.txt";
	public static final String SORTED_CHR15_HISTONE_FILENAME = "sorted_chr15_histone.txt";
	public static final String SORTED_CHR16_HISTONE_FILENAME = "sorted_chr16_histone.txt";
	public static final String SORTED_CHR17_HISTONE_FILENAME = "sorted_chr17_histone.txt";
	public static final String SORTED_CHR18_HISTONE_FILENAME = "sorted_chr18_histone.txt";
	public static final String SORTED_CHR19_HISTONE_FILENAME = "sorted_chr19_histone.txt";
	public static final String SORTED_CHR20_HISTONE_FILENAME = "sorted_chr20_histone.txt";
	public static final String SORTED_CHR21_HISTONE_FILENAME = "sorted_chr21_histone.txt";
	public static final String SORTED_CHR22_HISTONE_FILENAME = "sorted_chr22_histone.txt";
	public static final String SORTED_CHRX_HISTONE_FILENAME = "sorted_chrX_histone.txt";
	public static final String SORTED_CHRY_HISTONE_FILENAME = "sorted_chrY_histone.txt";
		
			
	//CREATE ENCODE TFBS directory
	public static final String CREATE_ENCODE_TFBS_DIRECTORY = OUTPUT_DATA + "Doktora" + System.getProperty("file.separator") + "create" + System.getProperty("file.separator") + "encode" + System.getProperty("file.separator") + "tfbs" + System.getProperty("file.separator");
	
	//Unsorted Chromosome Based TFBS filenames
	public static final String UNSORTED_CHR1_TFBS_FILENAME = "unsorted_chr1_tfbs.txt";
	public static final String UNSORTED_CHR2_TFBS_FILENAME = "unsorted_chr2_tfbs.txt";
	public static final String UNSORTED_CHR3_TFBS_FILENAME = "unsorted_chr3_tfbs.txt";
	public static final String UNSORTED_CHR4_TFBS_FILENAME = "unsorted_chr4_tfbs.txt";
	public static final String UNSORTED_CHR5_TFBS_FILENAME = "unsorted_chr5_tfbs.txt";
	public static final String UNSORTED_CHR6_TFBS_FILENAME = "unsorted_chr6_tfbs.txt";
	public static final String UNSORTED_CHR7_TFBS_FILENAME = "unsorted_chr7_tfbs.txt";
	public static final String UNSORTED_CHR8_TFBS_FILENAME = "unsorted_chr8_tfbs.txt";
	public static final String UNSORTED_CHR9_TFBS_FILENAME = "unsorted_chr9_tfbs.txt";
	public static final String UNSORTED_CHR10_TFBS_FILENAME = "unsorted_chr10_tfbs.txt";
	public static final String UNSORTED_CHR11_TFBS_FILENAME = "unsorted_chr11_tfbs.txt";
	public static final String UNSORTED_CHR12_TFBS_FILENAME = "unsorted_chr12_tfbs.txt";
	public static final String UNSORTED_CHR13_TFBS_FILENAME = "unsorted_chr13_tfbs.txt";
	public static final String UNSORTED_CHR14_TFBS_FILENAME = "unsorted_chr14_tfbs.txt";
	public static final String UNSORTED_CHR15_TFBS_FILENAME = "unsorted_chr15_tfbs.txt";
	public static final String UNSORTED_CHR16_TFBS_FILENAME = "unsorted_chr16_tfbs.txt";
	public static final String UNSORTED_CHR17_TFBS_FILENAME = "unsorted_chr17_tfbs.txt";
	public static final String UNSORTED_CHR18_TFBS_FILENAME = "unsorted_chr18_tfbs.txt";
	public static final String UNSORTED_CHR19_TFBS_FILENAME = "unsorted_chr19_tfbs.txt";
	public static final String UNSORTED_CHR20_TFBS_FILENAME = "unsorted_chr20_tfbs.txt";
	public static final String UNSORTED_CHR21_TFBS_FILENAME = "unsorted_chr21_tfbs.txt";
	public static final String UNSORTED_CHR22_TFBS_FILENAME = "unsorted_chr22_tfbs.txt";
	public static final String UNSORTED_CHRX_TFBS_FILENAME = "unsorted_chrX_tfbs.txt";
	public static final String UNSORTED_CHRY_TFBS_FILENAME = "unsorted_chrY_tfbs.txt";
	
	// Sorted Chromosome Base TFBS File names
	public static final String SORTED_CHR1_TFBS_FILENAME = "sorted_chr1_tfbs.txt";
	public static final String SORTED_CHR2_TFBS_FILENAME = "sorted_chr2_tfbs.txt";
	public static final String SORTED_CHR3_TFBS_FILENAME = "sorted_chr3_tfbs.txt";
	public static final String SORTED_CHR4_TFBS_FILENAME = "sorted_chr4_tfbs.txt";
	public static final String SORTED_CHR5_TFBS_FILENAME = "sorted_chr5_tfbs.txt";
	public static final String SORTED_CHR6_TFBS_FILENAME = "sorted_chr6_tfbs.txt";
	public static final String SORTED_CHR7_TFBS_FILENAME = "sorted_chr7_tfbs.txt";
	public static final String SORTED_CHR8_TFBS_FILENAME = "sorted_chr8_tfbs.txt";
	public static final String SORTED_CHR9_TFBS_FILENAME = "sorted_chr9_tfbs.txt";
	public static final String SORTED_CHR10_TFBS_FILENAME = "sorted_chr10_tfbs.txt";
	public static final String SORTED_CHR11_TFBS_FILENAME = "sorted_chr11_tfbs.txt";
	public static final String SORTED_CHR12_TFBS_FILENAME = "sorted_chr12_tfbs.txt";
	public static final String SORTED_CHR13_TFBS_FILENAME = "sorted_chr13_tfbs.txt";
	public static final String SORTED_CHR14_TFBS_FILENAME = "sorted_chr14_tfbs.txt";
	public static final String SORTED_CHR15_TFBS_FILENAME = "sorted_chr15_tfbs.txt";
	public static final String SORTED_CHR16_TFBS_FILENAME = "sorted_chr16_tfbs.txt";
	public static final String SORTED_CHR17_TFBS_FILENAME = "sorted_chr17_tfbs.txt";
	public static final String SORTED_CHR18_TFBS_FILENAME = "sorted_chr18_tfbs.txt";
	public static final String SORTED_CHR19_TFBS_FILENAME = "sorted_chr19_tfbs.txt";
	public static final String SORTED_CHR20_TFBS_FILENAME = "sorted_chr20_tfbs.txt";
	public static final String SORTED_CHR21_TFBS_FILENAME = "sorted_chr21_tfbs.txt";
	public static final String SORTED_CHR22_TFBS_FILENAME = "sorted_chr22_tfbs.txt";
	public static final String SORTED_CHRX_TFBS_FILENAME = "sorted_chrX_tfbs.txt";
	public static final String SORTED_CHRY_TFBS_FILENAME = "sorted_chrY_tfbs.txt";
		
	
}
