package ui;

import javax.swing.JPanel;
import ui.MainView.MainViewDelegate;
import common.Commons;
import enumtypes.CommandLineArguments;

public class MainViewController extends ViewController implements MainViewDelegate {

	private MainView mainView;
	private Thread runnerThread;
	private GlanetRunner runner;

	public MainViewController( JPanel contentPanel) {

		super( contentPanel);

		loadView();
	}

	@Override
	public void loadView() {

		if( mainView != null){
			contentPanel.remove( mainView);
		}

		mainView = new MainView();
		mainView.setDelegate( this);
		contentPanel.add( mainView);
	}

	@Override
	public void presentViewController( ViewController viewController) {

		contentPanel.removeAll();
		contentPanel.invalidate();
		viewController.loadView();
		contentPanel.revalidate();

	}

	@Override
	public void dismissViewController() {

		contentPanel.removeAll();
		contentPanel.add( mainView);
	}
	
	@Override
	public void frameSizeChanged(int width, int height){
		
		mainView.setPreferredSizeForScrollPane(width, height);
	}

	@Override
	public void startRunActionsWithOptions( 
			String inputFileName, 
			String inputFileAssembly, 
			String glanetFolder,
			String outputFolder,
			String inputFileFormat, 
			String associationMeasureType,
			String numberOfBases, 
			String enrichmentEnabled,
			String enrichmentZScoreMode, 
			String generateRandomDataMode,
			String multipleTestingChoice, 
			String bonferoniCorrectionSignificanceLevel, 
			String falseDiscoveryRate,
			String numberOfPermutations, 
			String dnaseAnnotation, 
			String histoneAnnotation, 
			String tfAnnotation,
			String geneAnnotation, 
			String bpGOTermsAnnotation,
			String mfGOTermsAnnotation,
			String ccGOTermsAnnotation,
			String keggPathwayAnnotation, 
			String tfAndKeggPathwayAnnotation,
			String cellLineBasedTfAndKeggPathwayAnnotation, 
			String regulatorySequenceAnalysisUsingRSAT, 
			String jobName,
			String writeAnnotationFoundOverlapsMode, 
			String writeAnnotationBinaryMatrixMode,
			String writeGeneratedRandomDataMode, 
			String writePermutationBasedandParametricBasedAnnotationResultMode,
			String writePermutationBasedAnnotationResultMode, 
			String numberOfPermutationsInEachRun,
			String userDefinedGeneSetEnrichment, 
			String userDefinedGeneSetInputFile,
			String userDefinedGeneSetGeneInformation, 
			String userDefinedGeneSetName,
			String userDefinedGeneSetDescription, 
			String userDefinedLibraryEnrichment,
			String userDefinedLibraryInputFile, 
			String userDefinedLibraryDataFormat, 
			String givenInputDataType,
			String glanetRunType,
			String isochoreFamilyMode,
			String numOfThreads,
			String[] cellLinesToBeConsidered) {

		String[] args = new String[CommandLineArguments.NumberOfArguments.value() + cellLinesToBeConsidered.length];

		args[CommandLineArguments.InputFileNameWithFolder.value()] = inputFileName;
		args[CommandLineArguments.InputFileAssembly.value()] = inputFileAssembly;
		args[CommandLineArguments.GlanetFolder.value()] = glanetFolder;
		args[CommandLineArguments.OutputFolder.value()] = outputFolder;
		args[CommandLineArguments.InputFileDataFormat.value()] = inputFileFormat;
		args[CommandLineArguments.AssociationMeasureType.value()] = associationMeasureType;
		args[CommandLineArguments.NumberOfBasesRequiredForOverlap.value()] = numberOfBases;
		args[CommandLineArguments.PerformEnrichment.value()] = enrichmentEnabled;
		args[CommandLineArguments.EnrichmentZScoreMode.value()] = enrichmentZScoreMode;
		args[CommandLineArguments.GenerateRandomDataMode.value()] = generateRandomDataMode;
		args[CommandLineArguments.MultipleTesting.value()] = multipleTestingChoice;
		args[CommandLineArguments.BonferroniCorrectionSignificanceCriteria.value()] = bonferoniCorrectionSignificanceLevel;
		args[CommandLineArguments.FalseDiscoveryRate.value()] = falseDiscoveryRate;
		args[CommandLineArguments.NumberOfPermutation.value()] = numberOfPermutations;
		args[CommandLineArguments.DnaseAnnotation.value()] = dnaseAnnotation;
		args[CommandLineArguments.HistoneAnnotation.value()] = histoneAnnotation;
		args[CommandLineArguments.TfAnnotation.value()] = tfAnnotation;
		args[CommandLineArguments.GeneAnnotation.value()] = geneAnnotation;
		args[CommandLineArguments.BPGOTermsAnnotation.value()] = bpGOTermsAnnotation;	
		args[CommandLineArguments.MFGOTermsAnnotation.value()] = mfGOTermsAnnotation;	
		args[CommandLineArguments.CCGOTermsAnnotation.value()] = ccGOTermsAnnotation;	
		args[CommandLineArguments.KeggPathwayAnnotation.value()] = keggPathwayAnnotation;
		args[CommandLineArguments.TfAndKeggPathwayAnnotation.value()] = tfAndKeggPathwayAnnotation;
		args[CommandLineArguments.CellLineBasedTfAndKeggPathwayAnnotation.value()] = cellLineBasedTfAndKeggPathwayAnnotation;
		args[CommandLineArguments.RegulatorySequenceAnalysisUsingRSAT.value()] = regulatorySequenceAnalysisUsingRSAT;
		args[CommandLineArguments.JobName.value()] = jobName;
		args[CommandLineArguments.AnnotationFoundOverlapsOutputMode.value()] = writeAnnotationFoundOverlapsMode;
		args[CommandLineArguments.WriteAnnotationBinaryMatrixMode.value()] = writeAnnotationBinaryMatrixMode;
		args[CommandLineArguments.WriteGeneratedRandomDataMode.value()] = writeGeneratedRandomDataMode;
		args[CommandLineArguments.WritePermutationBasedandParametricBasedAnnotationResultMode.value()] = writePermutationBasedandParametricBasedAnnotationResultMode;
		args[CommandLineArguments.WritePermutationBasedAnnotationResultMode.value()] = writePermutationBasedAnnotationResultMode;
		args[CommandLineArguments.NumberOfPermutationsInEachRun.value()] = numberOfPermutationsInEachRun;
		args[CommandLineArguments.UserDefinedGeneSetAnnotation.value()] = userDefinedGeneSetEnrichment;
		args[CommandLineArguments.UserDefinedGeneSetInput.value()] = userDefinedGeneSetInputFile;
		args[CommandLineArguments.UserDefinedGeneSetGeneInformation.value()] = userDefinedGeneSetGeneInformation;
		args[CommandLineArguments.UserDefinedGeneSetName.value()] = userDefinedGeneSetName;
		args[CommandLineArguments.UserDefinedGeneSetDescriptionFile.value()] = userDefinedGeneSetDescription;
		args[CommandLineArguments.UserDefinedLibraryAnnotation.value()] = userDefinedLibraryEnrichment;
		args[CommandLineArguments.UserDefinedLibraryInput.value()] = userDefinedLibraryInputFile;
		args[CommandLineArguments.UserDefinedLibraryDataFormat.value()] = userDefinedLibraryDataFormat;
		args[CommandLineArguments.GivenInputDataType.value()] = givenInputDataType;
		args[CommandLineArguments.LogFile.value()] = Commons.ARG_LOG_FILE;
		args[CommandLineArguments.GLANETRun.value()] = glanetRunType;
		args[CommandLineArguments.IsochoreFamilyMode.value()] = isochoreFamilyMode;
		args[CommandLineArguments.NumberOfThreads.value()] = numOfThreads;

		// filling the rest with selected cell lines.
		for( int i = CommandLineArguments.NumberOfArguments.value(); i < args.length; i++)
			args[i] = cellLinesToBeConsidered[i - Commons.NUMBER_OF_PROGRAM_RUNTIME_ARGUMENTS];

		runner = new GlanetRunner();

		GlanetRunner.setArgs( args);
		GlanetRunner.setMainView( mainView);

		runnerThread = new Thread( runner);
		runnerThread.start();
	}

	@Override
	public void stopCurrentProcess() {

		runnerThread.interrupt();
	}
}