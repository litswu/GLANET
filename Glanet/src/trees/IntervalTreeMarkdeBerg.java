/**
 * 
 */
package trees;

import intervaltree.Interval;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import printing.Print;
import sorting.CountingSort;
import auxiliary.FileOperations;

import common.Commons;

import enumtypes.ChromosomeName;
import enumtypes.CommandLineArguments;
import enumtypes.SortingOrder;
import enumtypes.AnnotationFoundOverlapsOutputMode;
import gnu.trove.map.TIntByteMap;
import gnu.trove.map.TIntObjectMap;

/**
 * @author Bur�ak Otlu
 * @date Jun 28, 2016
 * @project Glanet 
 * 
 * Implemented from Computational Geometry, Mark de Berg
 * 
 * Assume that there are n intervals with 2n end points (each interval has two end points namely left and right end points)
 * Let x_mid be the median of 2n end points.
 * So at most half of the interval end points lies to the left of x_mid and at most half of the interval end points lies to the right of x_mid
 * Interval tree is a binary tree constructed based on this idea.
 * The right subtree of the tree stores I_right of the intervals that lie completely to the right of x_mid.   
 * The left subtree of the tree stores I_left of the intervals that lie completely to the left of x_mid.
 * The subtrees are constructed recursively in the same manner.
 * 
 * Root of the tree has its x_mid value and I_mid of of intervals containing (overlapping) this x_mid point.
 * Please notice that median of end points is not the average of end points.
 * 
 * Interval Tree Data Structure
 * 
 * 1. If I is empty set, then the interval tree is a leaf.
 * 2. Otherwise, let x_mid be the median of 2n end points.
 * 		Let 
 * 			I_left= {(x_left,x_right): x_right < x_mid}
 * 			I_mid=  {(x_left,x_right): x_left <= x_mid <= x_right}
 * 			I_right={(x_left,x_right): x_mid < x_left}
 * 
 * Interval tree consists of a root node v storing x_mid.
 * I_mid is stored in 2 lists, L_left is a list sorted in ascending left end points,
 * L_right is a list in descending right end points.
 * 
 * The left subtree of v is an interval tree for the set I_left. 
 * The right subtree of v is an interval tree for the set I_right. 
 * 
 * An interval tree of n intervals uses O(n) storage and has depth of O(logn).
 * 
 * Finding the median of a set of points take linear time.
 * 
 * It is better to find median by pre-sorting the set of points.
 * It is easy to maintain these pre-sorted sets through the recursive calls.
 * 
 * Let n_mid = card(I_mid)
 * Creating the lists, L_left and L_right takes O(n_mid log n_mid) time.
 * Hence time we spent is  O(n + n_mid log n_mid)
 * 
 * An interval tree of n intervals can be built in O(nlogn) time.
 *
 */
public class IntervalTreeMarkdeBerg {
	
	IntervalTreeMarkdeBergNode root;
	
	long constructionTimeCost1;
	long constructionTimeCost2_1;
	long constructionTimeCost2_2;
	long constructionTimeCost2_3;
	long constructionTimeCost3_1;
	long constructionTimeCost3_2;
	
	
	public long getConstructionTimeCost1() {
		return constructionTimeCost1;
	}

	public void setConstructionTimeCost1(long constructionTimeCost1) {
		this.constructionTimeCost1 = constructionTimeCost1;
	}

	public long getConstructionTimeCost2_1() {
		return constructionTimeCost2_1;
	}

	public void setConstructionTimeCost2_1(long constructionTimeCost2_1) {
		this.constructionTimeCost2_1 = constructionTimeCost2_1;
	}

	public long getConstructionTimeCost2_2() {
		return constructionTimeCost2_2;
	}

	public void setConstructionTimeCost2_2(long constructionTimeCost2_2) {
		this.constructionTimeCost2_2 = constructionTimeCost2_2;
	}

	public long getConstructionTimeCost2_3() {
		return constructionTimeCost2_3;
	}

	public void setConstructionTimeCost2_3(long constructionTimeCost2_3) {
		this.constructionTimeCost2_3 = constructionTimeCost2_3;
	}

	public long getConstructionTimeCost3_1() {
		return constructionTimeCost3_1;
	}

	public void setConstructionTimeCost3_1(long constructionTimeCost3_1) {
		this.constructionTimeCost3_1 = constructionTimeCost3_1;
	}

	public long getConstructionTimeCost3_2() {
		return constructionTimeCost3_2;
	}

	public void setConstructionTimeCost3_2(long constructionTimeCost3_2) {
		this.constructionTimeCost3_2 = constructionTimeCost3_2;
	}

	public IntervalTreeMarkdeBergNode getRoot() {
		return root;
	}

	public void setRoot(IntervalTreeMarkdeBergNode root) {
		this.root = root;
	}

	public IntervalTreeMarkdeBerg() {
		super();
	}

	// Generate Dnase Interval Tree with Numbers starts
	public static trees.IntervalTreeMarkdeBerg generateEncodeDnaseIntervalTreeWithNumbers(
			BufferedReader bufferedReader,
			BufferedWriter bufferedWriter) {

		trees.IntervalTreeMarkdeBerg dnaseIntervalTree = new IntervalTreeMarkdeBerg();
		String strLine = null;

		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;

		int startPosition = 0;
		int endPosition = 0;

//		ChromosomeName chromName;
		short cellLineNumber;
		short fileNumber;
		
		long dateBefore;
		long dateAfter;
		
		List<IntervalMarkdeBerg> intervalList = new ArrayList<IntervalMarkdeBerg>();

		try{
			while( ( strLine = bufferedReader.readLine()) != null){

				// old example strLine
				// chr1 91852781 91853156 GM12878
				// idrPool.GM12878-DS9432-DS10671.z_OV_GM12878-DS10671.z_VS_GM12878-DS9432.z.npk2.narrowPeak

				// new example line with numbers
				// chrY 2709520 2709669 1 1

				indexofFirstTab = strLine.indexOf( '\t');
				indexofSecondTab = strLine.indexOf( '\t', indexofFirstTab + 1);
				indexofThirdTab = strLine.indexOf( '\t', indexofSecondTab + 1);
				indexofFourthTab = strLine.indexOf( '\t', indexofThirdTab + 1);

//				chromName = ChromosomeName.convertStringtoEnum( strLine.substring( 0, indexofFirstTab));

				startPosition = Integer.parseInt( strLine.substring( indexofFirstTab + 1, indexofSecondTab));
				endPosition = Integer.parseInt( strLine.substring( indexofSecondTab + 1, indexofThirdTab));

				cellLineNumber = Short.parseShort( strLine.substring( indexofThirdTab + 1, indexofFourthTab));
				fileNumber = Short.parseShort( strLine.substring( indexofFourthTab + 1));

				// important note
				// while constructing the dnaseIntervalTree
				// we don't check for overlaps
				// we insert any given interval without overlap check

				DnaseIntervalMarkdeBerg interval = new DnaseIntervalMarkdeBerg(startPosition,endPosition,cellLineNumber,fileNumber);
				intervalList.add(interval);

			} // End of WHILE
			
			//Sort intervalList w.r.t. the left end points in ascending order.
			//Then all left, middle and right intervals will be added with left end points in ascending order.
			//Then you don't have to sort middle intervals w.r.t. left end points in in ascending order.
			//But only sort middle intervals w.r.t. right end points in in descending order.
			
			IntervalMarkdeBerg[] intervalArray = (IntervalMarkdeBerg[]) intervalList.toArray(new IntervalMarkdeBerg[intervalList.size()]);
			
			//Cost1
			//Do it only once. Sort intervals in ascending order w.r.t. left end points.
			//Usage of parallel sort has reduced sorting time by 50%.
			dateBefore = System.currentTimeMillis();
			//parallelSort(T[] a, Comparator<? super T> cmp)
			//Sorts the specified array of objects according to the order induced by the specified comparator.
			Arrays.parallelSort(intervalArray,IntervalMarkdeBerg.INTERVALTREEMARKDEBERG_LEFTENDPOINT_ASCENDING);
			//To be tested ends
			dateAfter = System.currentTimeMillis();
			dnaseIntervalTree.setConstructionTimeCost1(dateAfter - dateBefore);
			
			//Free space
			intervalList = null;
			//intervalArrayUnsorted = null;
			
			//Construct interval tree
			//IntervalTreeMarkdeBergNode root = constructIntervalTree(dnaseIntervalTree,intervalArraySorted,bufferedWriter);
			IntervalTreeMarkdeBergNode root = constructIntervalTree(dnaseIntervalTree,intervalArray,bufferedWriter);
			
			dnaseIntervalTree.setRoot(root);
			
		}catch( IOException e){
			System.out.println(e.toString());
		}

		return dnaseIntervalTree;
	}
	

	public static IntervalTreeMarkdeBerg createDnaseIntervalTreeWithNumbers(
			String dataFolder, 
			String outputFolder,
			ChromosomeName chrName){
		
		IntervalTreeMarkdeBerg intervalTree = null;
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try{

			fileReader = FileOperations.createFileReader( 
					dataFolder + Commons.BYGLANET_ENCODE_DNASE_DIRECTORY,
					chrName.convertEnumtoString() + Commons.UNSORTED_ENCODE_DNASE_FILE_WITH_NUMBERS);
			
			bufferedReader = new BufferedReader(fileReader);
			
			fileWriter = FileOperations.createFileWriter(outputFolder + "IntervalsDistribution.txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			
			//Create IntervalTreeMarkdeBerg
			intervalTree = generateEncodeDnaseIntervalTreeWithNumbers(bufferedReader,bufferedWriter);
			
			//Close bufferedReader and bufferedWriter
			bufferedReader.close();
			bufferedWriter.close();

		}catch( FileNotFoundException e){
			System.out.println(e.toString());
		}catch( IOException e){
			System.out.println(e.toString());
		}
		
		return intervalTree; 
		
	}


	
	
	//allIntervals are sorted w.r.t. to left end points ascending order.
	//Take left and right end points and sort the all end points and find the median
	//Having median at hand, find the left node intervals such that right end point is less than median
	//Having median at hand, find the middle node intervals such that left end point is less than or equal to median and right end point is greater than or equal to median.
	//Having median at hand, find the right node intervals such that left end point is greater than median
	public static float findMedianAndFillLeftMiddleRightNodeIntervals(
			IntervalTreeMarkdeBerg intervalTreeMarkdeBerg,
			IntervalMarkdeBerg[] allIntervalsLeftEndPointsAscendingSorted,
			List<IntervalMarkdeBerg> leftNodeIntervals,
			List<IntervalMarkdeBerg> middleNodeIntervals,
			List<IntervalMarkdeBerg> rightNodeIntervals,
			BufferedWriter bufferedWriter){
		
		long dateBefore;
		long dateAfter;
		
		int numberofIntervals = allIntervalsLeftEndPointsAscendingSorted.length;
		int numberofEndPoints = numberofIntervals*2;
		
		int[] allEndPoints = new int[numberofEndPoints];
		
		int j=0;
		int saved_i = allIntervalsLeftEndPointsAscendingSorted.length;

		float median;
		
		//Cost2_1 starts
		//Fill allEndPoints
		dateBefore = System.currentTimeMillis();
		for(int i=0; i<allIntervalsLeftEndPointsAscendingSorted.length; i++){
			allEndPoints[j++] = allIntervalsLeftEndPointsAscendingSorted[i].getLow();
			allEndPoints[j++] = allIntervalsLeftEndPointsAscendingSorted[i].getHigh();
		}//End of For Fill allEndPoints 
		dateAfter = System.currentTimeMillis();
		intervalTreeMarkdeBerg.setConstructionTimeCost2_1(intervalTreeMarkdeBerg.getConstructionTimeCost2_1() + (dateAfter- dateBefore));
		//Cost2_1 ends
		
		
		//Cost2_2 starts
		//We have to sort all end points in order to find the median.
		//Sorting an array into ascending order. 
		//This can be done either sequentially, using the sort method, or concurrently, using the parallelSort method introduced in Java SE 8
		//Parallel sorting of large arrays on multiprocessor systems is faster than sequential array sorting.
		dateBefore = System.currentTimeMillis();
		//Usage of parallelSort decreased sorting time enormously.
		Arrays.parallelSort(allEndPoints);
		dateAfter = System.currentTimeMillis();
		intervalTreeMarkdeBerg.setConstructionTimeCost2_2(intervalTreeMarkdeBerg.getConstructionTimeCost2_2() + (dateAfter- dateBefore));
		//Cost2_2 ends
		
		
		//Find median
		median = (allEndPoints[numberofIntervals-1] + allEndPoints[numberofIntervals])*1.0f/2;

		
		//Free space
		allEndPoints = null;

		//Cost2_3 starts
		//Fill left, middle and right interval lists
		//We have sorted all the intervals w.r.t. left end points in ascending order O(nlogn) or O(n+k)
		//Loop until you hit an interval with its low is greater than median
		//Then exit loop and add all the remaining intervals into right intervals.
		dateBefore = System.currentTimeMillis();
		for(int i= 0 ; i<numberofIntervals; i++){
			
			if (allIntervalsLeftEndPointsAscendingSorted[i].getHigh() < median){
				leftNodeIntervals.add(allIntervalsLeftEndPointsAscendingSorted[i]);
			}else if (allIntervalsLeftEndPointsAscendingSorted[i].getLow() > median){
				rightNodeIntervals.add(allIntervalsLeftEndPointsAscendingSorted[i]);
				//We have inserted interval indexed at i
				//We know that rest of the intervals will be added to the rightNodeIntervals
				saved_i = i+1;
				break;
			}else{
				middleNodeIntervals.add(allIntervalsLeftEndPointsAscendingSorted[i]);
			}
		}//End of FOR
		
		
		//Check you don't put the cut off value twice
		for(int i= saved_i ; i<numberofIntervals; i++){
			rightNodeIntervals.add(allIntervalsLeftEndPointsAscendingSorted[i]);
		}
		dateAfter = System.currentTimeMillis();
		intervalTreeMarkdeBerg.setConstructionTimeCost2_3(intervalTreeMarkdeBerg.getConstructionTimeCost2_3() + (dateAfter- dateBefore));
		//Cost2_3 ends
		
//		try {
//			bufferedWriter.write("Median: " + median + " Number of all intervals  is: " + allIntervalsSorted.length + "=[Left: " + leftNodeIntervals.size() +  ", Middle: " + middleNodeIntervals.size() + ", Right: " + rightNodeIntervals.size() + "]" + System.getProperty("line.separator"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
		
		return median;
	}
	
	/*
	 * Sort middle intervals in two ways
	 * With respect to the left end points in ascending order
	 * With respect to the right end points in descending order
	 * Using counting sort
	 */
	public static void sortMiddleNodeIntervalsInTwoWays(
			IntervalTreeMarkdeBerg intervalTreeMarkdeBerg,
			List<IntervalMarkdeBerg> middleNodeIntervals,
			IntervalMarkdeBerg[] middleIntervalsLeftEndPointsAscending,
			IntervalMarkdeBerg[] middleIntervalsRightEndPointsDescending){
		
		
		long dateBefore;
		long dateAfter;
		
		//Does middleNodeIntervals has to be a list? Can it be stored in an array?
		//Yes it can be stored in an array of size all intervals
		//Or list can be converted into array
		//first requires more space, latter requires more space and time
		
		//middleNodeIntervals can be an empty list
		//In that case there is no need to convert it into an array
		//Then there is no need to sort this array in two ways
		if (middleNodeIntervals!=null && !middleNodeIntervals.isEmpty()){
			
			//Since it is already sorted w.r.t. left end points in ascending order			
			//Cost3_1
			dateBefore = System.currentTimeMillis();
			middleNodeIntervals.toArray(middleIntervalsLeftEndPointsAscending);
			dateAfter = System.currentTimeMillis();
			intervalTreeMarkdeBerg.setConstructionTimeCost3_1(intervalTreeMarkdeBerg.getConstructionTimeCost3_1() + (dateAfter- dateBefore));
			
			//Cost3_2
			//Parallel sorting of large arrays on multiprocessor systems is faster than sequential array sorting.
			//Since middleNodeIntervals size is not high, parallelSort costs more than normal sorting.
			// TODO Try heapSort
			// TODO Try quickSort
			// DONE Try CountingSort : seems better
			// DONE Try Arrays.sort
			// DONE Try parallelSort
			dateBefore = System.currentTimeMillis();
			CountingSort.sortRightEndPointsDescending(middleIntervalsLeftEndPointsAscending, SortingOrder.SORTING_IN_DESCENDING_ORDER,middleIntervalsRightEndPointsDescending);
			//middleNodeIntervals.toArray(middleIntervalsRightEndPointsDescending);
			//Arrays.sort(middleIntervalsRightEndPointsDescending, IntervalMarkdeBerg.INTERVALTREEMARKDEBERG_RIGHTENDPOINT_DESCENDING);
			dateAfter = System.currentTimeMillis();
			intervalTreeMarkdeBerg.setConstructionTimeCost3_2(intervalTreeMarkdeBerg.getConstructionTimeCost3_2() + (dateAfter- dateBefore));
						
		}
		
	}
	
	
	//list contains unsorted intervals.
	//First sort the interval end points
	//Find the median
	//Find the node intervals
	//Find the left subtree intervals
	//Find the right subtree intervals
	public static IntervalTreeMarkdeBergNode constructIntervalTree(
			IntervalTreeMarkdeBerg intervalTreeMarkdeBerg,
			IntervalMarkdeBerg[] allIntervalsLeftEndPointsAscendingSorted,
			BufferedWriter bufferedWriter){
		
		IntervalTreeMarkdeBergNode node = null;
		
		
		
		if (allIntervalsLeftEndPointsAscendingSorted==null || allIntervalsLeftEndPointsAscendingSorted.length==0){
			
			return node;
			
		}else{
			
			Float median = new Float(0);
			List<IntervalMarkdeBerg> leftNodeIntervals = new ArrayList<>();
			List<IntervalMarkdeBerg> middleNodeIntervals = new ArrayList<>();
			List<IntervalMarkdeBerg> rightNodeIntervals = new ArrayList<>();
			
			IntervalTreeMarkdeBergNode left = null;
			IntervalTreeMarkdeBergNode right =null;
			
			//Cost2
			//allIntervals can be an array
			//the filled list can be converted to an array
			//However we do not know how many of the intervals will be in left, middle and right.
			//By creating array of size of number of all intervals can be a solution.
			median = findMedianAndFillLeftMiddleRightNodeIntervals(intervalTreeMarkdeBerg,allIntervalsLeftEndPointsAscendingSorted,leftNodeIntervals,middleNodeIntervals,rightNodeIntervals,bufferedWriter);
			
			//Free space
			allIntervalsLeftEndPointsAscendingSorted  = null;
						
			//We don't know the number of middle intervals
			//middleIntervalsLeftEndPointsAscending can be an array
			//middleIntervalsRightEndPointsDescending can be an array
			IntervalMarkdeBerg[] middleIntervalsLeftEndPointsAscending = new IntervalMarkdeBerg[middleNodeIntervals.size()];
			IntervalMarkdeBerg[] middleIntervalsRightEndPointsDescending = new IntervalMarkdeBerg[middleNodeIntervals.size()];
			
			//Cost3
			sortMiddleNodeIntervalsInTwoWays(
					intervalTreeMarkdeBerg,
					middleNodeIntervals,
					middleIntervalsLeftEndPointsAscending,
					middleIntervalsRightEndPointsDescending);
			
			//Free Space
			//We have created middleIntervalsLeftEndPointsAscending and middleIntervalsRightEndPointsDescending from middleNodeIntervals
			//So remove middleNodeIntervals
			middleNodeIntervals = null;
			
			left = constructIntervalTree(intervalTreeMarkdeBerg,leftNodeIntervals.toArray(new IntervalMarkdeBerg[leftNodeIntervals.size()]),bufferedWriter);
			
			right = constructIntervalTree(intervalTreeMarkdeBerg,rightNodeIntervals.toArray(new IntervalMarkdeBerg[rightNodeIntervals.size()]),bufferedWriter);
			
			node = new IntervalTreeMarkdeBergNode(
					middleIntervalsLeftEndPointsAscending, 
					middleIntervalsRightEndPointsDescending, 
					median, 
					left, 
					right);
			
		}
		
		return node;
		
	}
	
	

	public IntervalTreeMarkdeBerg(IntervalTreeMarkdeBergNode root) {
		super();
		this.root = root;
	}


	
	public static void traverseIntervalTreeBreadthFirstOrder(IntervalTreeMarkdeBerg intervalTree){
		
		System.out.println("Breadth first tree traversal starts.");
		
		Queue<IntervalTreeMarkdeBergNode> queue = new LinkedList<IntervalTreeMarkdeBergNode>();
		
	    if (intervalTree.getRoot() == null)
	        return;
	    
	    queue.clear();
	    queue.add(intervalTree.getRoot());
	    
	    while(!queue.isEmpty()){
	    	
	        IntervalTreeMarkdeBergNode newNode = queue.remove();
	        System.out.print("Median:" + newNode.getMedian());
	        
	        System.out.print(" Number of node intervals: " + newNode.getIntervalsLeftEndPointsAscending().length);
		      
	        System.out.print(" Node intervals:");
	        Print.printArray(newNode.getIntervalsLeftEndPointsAscending());
	        
	        if(newNode.getLeft() != null) queue.add(newNode.getLeft());
	        if(newNode.getRight() != null) queue.add(newNode.getRight());
	        
	    }//End of while

		System.out.println("Breadth first tree traversal ends.");

	}
	
	
	//8 July 2016 starts
	public static void searchInLeftEndPointsInAscendingOrder(
			String outputFolder,
			String annotationFolder,
			String elementTypeName,
			AnnotationFoundOverlapsOutputMode writeFoundOverlapsMode,
			TIntObjectMap<String> cellLineNumber2CellLineNameMap,
			TIntObjectMap<String>fileNumber2FileNameMap,
			Interval interval, 
			ChromosomeName chromName,
			TIntByteMap dnaseCellLineNumber2HeaderWrittenMap,
			TIntByteMap dnaseCellLineNumber2OneorZeroMap,
			IntervalMarkdeBerg[] intervalsLeftEndPointsAscending, 
			int overlapDefinition){
		
		DnaseIntervalMarkdeBerg dnaseIntervalMarkdeBerg = null;
		
		
		for(int i=0; i<intervalsLeftEndPointsAscending.length;i++){
			
			//Case where interval_high < median
			//Therefore interval_low <  node's interval's high : Condition1 is satisfied for overlap
			//So we are looking for node's intervals such that their node_interval_low <= interval_high : Condition2 has to be checked 
			//which means that there is overlap

			dnaseIntervalMarkdeBerg = (DnaseIntervalMarkdeBerg)intervalsLeftEndPointsAscending[i];
			
			//Condition2 is checked here.
			if(dnaseIntervalMarkdeBerg.getLow()<=interval.getHigh()){	
				
				if(overlaps(dnaseIntervalMarkdeBerg.getLow(),dnaseIntervalMarkdeBerg.getHigh(), interval.getLow(), interval.getHigh(), overlapDefinition)){
					
					//There is overlap
					//Write it down.
					writeOverlapsFoundInAnnotation(
							outputFolder,
							annotationFolder,
							elementTypeName,
							writeFoundOverlapsMode,
							cellLineNumber2CellLineNameMap,
							fileNumber2FileNameMap,
							interval, 
							chromName,
							dnaseIntervalMarkdeBerg,
							dnaseCellLineNumber2HeaderWrittenMap);
					
					
					if( !dnaseCellLineNumber2OneorZeroMap.containsKey(dnaseIntervalMarkdeBerg.getCellLineNumber())){
						dnaseCellLineNumber2OneorZeroMap.put(dnaseIntervalMarkdeBerg.getCellLineNumber(), Commons.BYTE_1);
					}

				}//End of If there is overlap w.r.t. overlapDefinition

			}//End of IF there is a chance of overlap
			else{
					break;
			}//End of IF there is no chance of overlap
			
		}//End of FOR each interval in the node

	}
	//8 July 2016 ends

	
	
	public static void searchInLeftEndPointsInAscendingOrder(IntervalMarkdeBerg[] leftEndPointsAscending, int high, BufferedWriter bufferedWriter){
		try {

			for(int i=0; i<leftEndPointsAscending.length;i++){
				if(leftEndPointsAscending[i].getLow()<=high){
					//There is overlap
					//Write it down.
					bufferedWriter.write("Found Overlap: [" + leftEndPointsAscending[i].getLow() + "," + leftEndPointsAscending[i].getHigh() +"]" + System.getProperty("line.separator"));
					}//End of IF
				else{
					break;
				}
			}//End of FOR
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	// overlap definition: number of overlapping bases necessary for overlap
	//We know that node_interval_low < interval_high
	//Since node_interval_low <= median and median < interval_low
	//Therefore  node_interval_low < interval_high
	public static boolean overlapsForRightEndPointsInDescendingOrder( int node_interval_low, int node_interval_high, int interval_low, int interval_high, int numberofOverlappingBases) {

		if( ( interval_low <= node_interval_high)){

			if( ( Math.min( node_interval_high, interval_high) - Math.max( node_interval_low, interval_low) + 1) >= numberofOverlappingBases){
				return true;
			}else
				return false;
		}else
			return false;
	}

	// We know that low_x <= high_y and low_y <= high_x
	// overlapDefinition: number of overlapping bases necessary for overlap
	public static boolean overlaps(int low_x, int high_x, int low_y, int high_y, int numberofOverlappingBases) {

		if( ( Math.min( high_x, high_y) - Math.max( low_x, low_y) + 1) >= numberofOverlappingBases){
			return true;
		}else
			return false;
		
	}

	
	//8 July 2016 starts
	public static void searchInRightEndPointsInDescendingOrder(
			String outputFolder,
			String annotationFolder,
			String elementTypeName,
			AnnotationFoundOverlapsOutputMode writeFoundOverlapsMode,
			TIntObjectMap<String> cellLineNumber2CellLineNameMap,
			TIntObjectMap<String>fileNumber2FileNameMap,
			Interval interval, 
			ChromosomeName chromName,
			TIntByteMap dnaseCellLineNumber2HeaderWrittenMap,
			TIntByteMap dnaseCellLineNumber2OneorZeroMap,
			IntervalMarkdeBerg[] intervalsRightEndPointsDescending,
			int overlapDefinition){
		
		DnaseIntervalMarkdeBerg dnaseIntervalMarkdeBerg = null;
			
		for(int i=0; i<intervalsRightEndPointsDescending.length;i++){
			

		
			dnaseIntervalMarkdeBerg = (DnaseIntervalMarkdeBerg)intervalsRightEndPointsDescending[i];
			
			//OverlapDefinition is satisfied.
			if(interval.getLow() <= dnaseIntervalMarkdeBerg.getHigh()){
				if(overlaps(dnaseIntervalMarkdeBerg.getLow(),dnaseIntervalMarkdeBerg.getHigh(), interval.getLow(), interval.getHigh(), overlapDefinition)){
					
					//There is overlap
					//Write it down.
					writeOverlapsFoundInAnnotation(
							outputFolder,
							annotationFolder,
							elementTypeName,
							writeFoundOverlapsMode,
							cellLineNumber2CellLineNameMap,
							fileNumber2FileNameMap,
							interval, 
							chromName,
							dnaseIntervalMarkdeBerg,
							dnaseCellLineNumber2HeaderWrittenMap);
					
					
						if( !dnaseCellLineNumber2OneorZeroMap.containsKey(dnaseIntervalMarkdeBerg.getCellLineNumber())){
							dnaseCellLineNumber2OneorZeroMap.put(dnaseIntervalMarkdeBerg.getCellLineNumber(), Commons.BYTE_1);
						}
						
				}//End of IF there is overlap w.r.t. overlapDefinition
			
			}//There is a chance of overlap
			
			else{
				break;			
			}//There is no chance of overlap	
			
			
			
			
		}//End of FOR
	
	}
	//8 July 2016 ends
	
	public static void searchInRightEndPointsInDescendingOrder(IntervalMarkdeBerg[] rightEndPointsDescending, int low, BufferedWriter bufferedWriter){
		try {
			
			for(int i=0; i<rightEndPointsDescending.length;i++){
				
				if(low <= rightEndPointsDescending[i].getHigh()){
					//There is overlap
					//Write it down.
					bufferedWriter.write("Found Overlap: [" + rightEndPointsDescending[i].getLow() + "," + rightEndPointsDescending[i].getHigh() + "]"+ System.getProperty("line.separator"));
				}//End of IF
				else{
					break;			
				}
			}//End of FOR
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//From Case1 interval_high equality with median
	//From Case2 interval_low equality with median
	//From Case3 interval_low <= median <= interval_high
	public static void processOverlaps(
			String outputFolder,
			String annotationFolder,
			String elementTypeName,
			AnnotationFoundOverlapsOutputMode writeFoundOverlapsMode,
			TIntObjectMap<String> cellLineNumber2CellLineNameMap,
			TIntObjectMap<String>fileNumber2FileNameMap,
			Interval interval, 
			ChromosomeName chromName,
			IntervalTreeMarkdeBergNode node,
			TIntByteMap dnaseCellLineNumber2HeaderWrittenMap,
			TIntByteMap dnaseCellLineNumber2OneorZeroMap,
			int overlapDefinition){
		
		DnaseIntervalMarkdeBerg dnaseIntervalMarkdeBerg = null;
		
		// We know that all the intervals of node and given interval have median common
		for(int i=0; i<node.getIntervalsLeftEndPointsAscending().length; i++){
			
			dnaseIntervalMarkdeBerg = (DnaseIntervalMarkdeBerg) node.getIntervalsLeftEndPointsAscending()[i];
			
			// Use overlapDefinition
			// For case1 we know that interval_high = median
			// Therefore we know that node_interval_low < interval_high : condition1 is satisfied for overlap
			// Since node_interval_low < median 
			// Therefore we know that interval_low < node_interval_high since  interval_low < interval_high == median < node_interval_high : : condition2 is satisfied for overlap
			// We have to check number of overlapping bases satisfies overlapDefinition or not. 
			
	
			// For case2 we know that interval_low = median
			// Therefore we know that node_interval_low < interval_high : condition1 is satisfied for overlap
			// Since node_interval_low < median 
			// Therefore we know that interval_low < node_interval_high since  interval_low = median < node_interval_high : : condition2 is satisfied for overlap
			// We have to check number of overlapping bases satisfies overlapDefinition or not. 
			
			// For case3 interval_low <= median <= interval_high
			// Therefore interval_low < node_interval_high : condition1 is satisfied for overlap
			// Therefore node_interval_low < interval_high : condition2 is satisfied for overlap

			if (IntervalTreeMarkdeBerg.overlaps(dnaseIntervalMarkdeBerg.getLow(), dnaseIntervalMarkdeBerg.getHigh(), interval.getLow(), interval.getHigh(),overlapDefinition)){
				
				writeOverlapsFoundInAnnotation(
						outputFolder,
						annotationFolder,
						elementTypeName,
						writeFoundOverlapsMode,
						cellLineNumber2CellLineNameMap,
						fileNumber2FileNameMap,
						interval, 
						chromName,
						dnaseIntervalMarkdeBerg,
						dnaseCellLineNumber2HeaderWrittenMap);
				
				
				if( !dnaseCellLineNumber2OneorZeroMap.containsKey(dnaseIntervalMarkdeBerg.getCellLineNumber())){
					dnaseCellLineNumber2OneorZeroMap.put(dnaseIntervalMarkdeBerg.getCellLineNumber(), Commons.BYTE_1);
				}
				
			}//End of IF There is overlap w.r.t. overlapDefinition
			
		}//End of for each interval
		
	}

	
	// 8 July 2016
	// For testing purposes
	// Dnase
	public static void writeOverlapsFoundInAnnotation(
			String outputFolder,
			String annotationFolder,
			String elementTypeName,
			AnnotationFoundOverlapsOutputMode writeFoundOverlapsMode,
			TIntObjectMap<String> cellLineNumber2CellLineNameMap,
			TIntObjectMap<String>fileNumber2FileNameMap,
			Interval interval, 
			ChromosomeName chromName,
			DnaseIntervalMarkdeBerg dnaseIntervalMarkdeBerg,
			TIntByteMap dnaseCellLineNumber2HeaderWrittenMap){
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		String cellLineName = null;
		String fileName = null;

		try {
			

			/**************************************************************************************/
			/**************************WRITE ELEMENT BASED starts**********************************/
			/**************************************************************************************/
			if( writeFoundOverlapsMode.isWriteFoundOverlapsElementBased()){
	
				cellLineName = cellLineNumber2CellLineNameMap.get(dnaseIntervalMarkdeBerg.getCellLineNumber());
				fileName = fileNumber2FileNameMap.get(dnaseIntervalMarkdeBerg.getFileNumber());
	
				fileWriter = FileOperations.createFileWriter(outputFolder + annotationFolder + cellLineName + ".txt", true);
				bufferedWriter = new BufferedWriter(fileWriter);
					 
				//Write header only once for each DNase cellLine
				if (!dnaseCellLineNumber2HeaderWrittenMap.containsKey(dnaseIntervalMarkdeBerg.getCellLineNumber())){
					dnaseCellLineNumber2HeaderWrittenMap.put(dnaseIntervalMarkdeBerg.getCellLineNumber(),Commons.BYTE_1);
	
					bufferedWriter.write("#Searched for Chr" + "\t" + "Given Interval Low" + "\t" +
							 "Given Interval High" + "\t" + "DNase Chr" + "\t" + "DNase Interval Low" + "\t" +
							 "DNase Interval High" + "\t" + "CellLineName" + "\t" + "FileName" +
							 System.getProperty("line.separator"));
				}
				
				//Write each overlap
				bufferedWriter.write(chromName.convertEnumtoString() + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" +
						ChromosomeName.convertEnumtoString(chromName) + "\t" + dnaseIntervalMarkdeBerg.getLow() + "\t" + dnaseIntervalMarkdeBerg.getHigh() + "\t" + 
						cellLineName + "\t" + fileName + System.getProperty( "line.separator"));
	
				bufferedWriter.close();
	
			}// End of IF Element Based
			/**************************************************************************************/
			/**************************WRITE ELEMENT BASED ends************************************/
			/**************************************************************************************/
	
			
			/**************************************************************************************/
			/**************************WRITE ELEMENT TYPE BASED starts*****************************/
			/**************************************************************************************/
			else if( writeFoundOverlapsMode.isWriteFoundOverlapsElementTypeBased()){
				
				cellLineName = cellLineNumber2CellLineNameMap.get(dnaseIntervalMarkdeBerg.getCellLineNumber());
				fileName = fileNumber2FileNameMap.get(dnaseIntervalMarkdeBerg.getFileNumber());
	
				fileWriter = FileOperations.createFileWriter(outputFolder + annotationFolder + elementTypeName  + ".txt", true);
				bufferedWriter = new BufferedWriter( fileWriter);
			
				//Write header only once for each DNase cellLine
				if (!dnaseCellLineNumber2HeaderWrittenMap.containsKey(Commons.ONE)){
					dnaseCellLineNumber2HeaderWrittenMap.put(Commons.ONE,Commons.BYTE_1);
	
					bufferedWriter.write("#Searched for Chr" + "\t" + "Given Interval Low" + "\t" +
							 "Given Interval High" + "\t" + "DNase Chr" + "\t" + "DNase Interval Low" + "\t" +
							 "DNase Interval High" + "\t" + "CellLineName" + "\t" + "FileName" +
							 System.getProperty("line.separator"));
				}
				
				//Write each overlap
				bufferedWriter.write(chromName.convertEnumtoString() + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" +
						ChromosomeName.convertEnumtoString(chromName) + "\t" + dnaseIntervalMarkdeBerg.getLow() + "\t" + dnaseIntervalMarkdeBerg.getHigh() + "\t" + 
						cellLineName + "\t" + fileName + System.getProperty( "line.separator"));
	
				bufferedWriter.close();
				
			}// End of IF Element Type Based
			/**************************************************************************************/
			/**************************WRITE ELEMENT TYPE BASED ends*******************************/
			/**************************************************************************************/

		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
	//For testing purposes
	//Search Dnase
	//EOO
	//IntervalTreeMarkdeBerg
	public static void searchIntervalTreeMarkdeBerg(
			String outputFolder,
			AnnotationFoundOverlapsOutputMode writeFoundOverlapsMode,
			TIntByteMap dnaseCellLineNumber2HeaderWrittenMap,
			TIntObjectMap<String> cellLineNumber2CellLineNameMap, 
			TIntObjectMap<String> fileNumber2FileNameMap,
			IntervalTreeMarkdeBergNode node, 
			Interval interval, 
			ChromosomeName chromName,
			TIntByteMap dnaseCellLineNumber2OneorZeroMap, 
			int overlapDefinition) {
		
		if (node!=null){
			
			//Case1 starts
			//Look at node's intervals left end points in ascending order
			//Look at node's left child
			if (interval.getHigh() <= node.getMedian().intValue()){
				
				//interval_high equality with median
				if (interval.getHigh() == node.getMedian().intValue()){
					
					//There might be overlaps w.r.t. overlap definition
					//We know that interval overlaps with median
					processOverlaps(
							outputFolder,
							Commons.DNASE_ANNOTATION_DIRECTORY,
							Commons.DNASE,
							writeFoundOverlapsMode,
							cellLineNumber2CellLineNameMap,
							fileNumber2FileNameMap,
							interval, 
							chromName,
							node,
							dnaseCellLineNumber2HeaderWrittenMap,
							dnaseCellLineNumber2OneorZeroMap,
							overlapDefinition);
				}
				//interval_high is less than with median
				else{
					//Search in
					//Overlaps if node.getIntervalsLeftEndPointsAscending()[i].getLow() <= interval.getHigh()  
					//else breaks
					searchInLeftEndPointsInAscendingOrder(
							outputFolder,
							Commons.DNASE_ANNOTATION_DIRECTORY,
							Commons.DNASE,
							writeFoundOverlapsMode,
							cellLineNumber2CellLineNameMap,
							fileNumber2FileNameMap,
							interval, 
							chromName,
							dnaseCellLineNumber2HeaderWrittenMap,
							dnaseCellLineNumber2OneorZeroMap,
							node.getIntervalsLeftEndPointsAscending(),
							overlapDefinition);

				}
				
				//Continue search in left node
				searchIntervalTreeMarkdeBerg(
						outputFolder,
						writeFoundOverlapsMode,
						dnaseCellLineNumber2HeaderWrittenMap,
						cellLineNumber2CellLineNameMap, 
						fileNumber2FileNameMap,
						node.getLeft(), 
						interval, 
						chromName,
						dnaseCellLineNumber2OneorZeroMap, 
						overlapDefinition);	
			}//Case1 ends 
			
			//Case 2  starts
			//Look at node's intervals right end points in descending order
			//Look at node's right child
			else if (node.getMedian().intValue() <= interval.getLow()){
				
				//Interval_low equality with median
				if (node.getMedian().intValue() == interval.getLow()){
					
					//There might be overlaps w.r.t. overlapDefinition
					processOverlaps(
							outputFolder,
							Commons.DNASE_ANNOTATION_DIRECTORY,
							Commons.DNASE,
							writeFoundOverlapsMode,
							cellLineNumber2CellLineNameMap,
							fileNumber2FileNameMap,
							interval, 
							chromName,
							node,
							dnaseCellLineNumber2HeaderWrittenMap,
							dnaseCellLineNumber2OneorZeroMap,
							overlapDefinition);

				}else{
					
					//Search in
					//Overlaps if interval.getLow() <=  node.getIntervalsRightEndPointsDescending()[i].getHigh()
					//else breaks
					searchInRightEndPointsInDescendingOrder(
							 outputFolder,
							 Commons.DNASE_ANNOTATION_DIRECTORY,
							 Commons.DNASE,
							 writeFoundOverlapsMode,
							 cellLineNumber2CellLineNameMap,
							 fileNumber2FileNameMap,
							 interval, 
							 chromName,
							 dnaseCellLineNumber2HeaderWrittenMap,
							 dnaseCellLineNumber2OneorZeroMap,
							 node.getIntervalsRightEndPointsDescending(), 
							 overlapDefinition);	

				}
				
					
				//Continue search in right node
				searchIntervalTreeMarkdeBerg(
						outputFolder,
						writeFoundOverlapsMode,
						dnaseCellLineNumber2HeaderWrittenMap,
						cellLineNumber2CellLineNameMap, 
						fileNumber2FileNameMap,
						node.getRight(), 
						interval, 
						chromName,
						dnaseCellLineNumber2OneorZeroMap, 
						overlapDefinition);	
			}//Case2 ends
			

			//Case3 starts
			else if (interval.getLow() <= node.getMedian().intValue() && node.getMedian().intValue() <=interval.getHigh()){
				
				//There are overlaps
				//We know that interval overlaps with node's intervals
				//Write node's intervals down if there is overlap w.r.t. overlapDefinition
				processOverlaps(
						outputFolder,
						Commons.DNASE_ANNOTATION_DIRECTORY,
						Commons.DNASE,
						writeFoundOverlapsMode,
						cellLineNumber2CellLineNameMap,
						fileNumber2FileNameMap,
						interval, 
						chromName,
						node,
						dnaseCellLineNumber2HeaderWrittenMap,
						dnaseCellLineNumber2OneorZeroMap,
						overlapDefinition);
				
				//Continue search in left node
				searchIntervalTreeMarkdeBerg(
						outputFolder,
						writeFoundOverlapsMode,
						dnaseCellLineNumber2HeaderWrittenMap,
						cellLineNumber2CellLineNameMap, 
						fileNumber2FileNameMap,
						node.getLeft(), 
						interval, 
						chromName,
						dnaseCellLineNumber2OneorZeroMap, 
						overlapDefinition);	
	
				//Continue search in right node
				searchIntervalTreeMarkdeBerg(
						outputFolder,
						writeFoundOverlapsMode,
						dnaseCellLineNumber2HeaderWrittenMap,
						cellLineNumber2CellLineNameMap, 
						fileNumber2FileNameMap,
						node.getRight(), 
						interval, 
						chromName,
						dnaseCellLineNumber2OneorZeroMap, 
						overlapDefinition);	

			}//Case3 ends

			//Control Case
			else {
				System.out.println("Security there is a problem. There is an unhandled case." + System.getProperty("line.separator"));
			}
			
		}//End of IF node is not null
		
				
	}//End of search method

	
	public static void searchIntervalTreeMarkdeBerg(
			IntervalTreeMarkdeBergNode node, 
			Interval interval, 
			BufferedWriter searchOutputBufferedWriter) throws IOException{
		
		if (node!=null){
			
			//Case 1
			//Look at node's intervals left end points in ascendig order
			//Look at node's left child
			if (interval.getHigh() <= node.getMedian()){
				
				//In case of equality
				if (interval.getHigh() == node.getMedian()){
					
					//We know that interval overlaps with node's intervals
					//Write node's intervals down
					searchOutputBufferedWriter.write("Found overlaps: ");
					Print.printArray(node.getIntervalsLeftEndPointsAscending(),searchOutputBufferedWriter);
					searchOutputBufferedWriter.write(System.getProperty("line.separator"));
					
				}else{
					//Search in
					//Overlaps if node.getIntervalsLeftEndPointsAscending()[i].getLow() <= interval.getHigh()  
					//else breaks
					searchInLeftEndPointsInAscendingOrder(node.getIntervalsLeftEndPointsAscending(),interval.getHigh(),searchOutputBufferedWriter);
				}
				
				//Continue search in left node
				searchIntervalTreeMarkdeBerg(node.getLeft(), interval,searchOutputBufferedWriter);	
			}
			
			//Case 2 
			//Look at node's intervals right end points in descendig order
			//Look at node's right child
			else if (node.getMedian() <= interval.getLow()){
				
				//In case of equality
				if (node.getMedian() == interval.getLow()){
					//We know that interval overlaps with node's intervals
					//Write node's intervals down
					searchOutputBufferedWriter.write("Found overlaps: ");
					Print.printArray(node.getIntervalsLeftEndPointsAscending(),searchOutputBufferedWriter);
					searchOutputBufferedWriter.write(System.getProperty("line.separator"));
					
				}else{
					//Search in
					//Overlaps if interval.getLow() <=  node.getIntervalsRightEndPointsDescending()[i].getHigh()
					//else breaks
					searchInRightEndPointsInDescendingOrder(node.getIntervalsRightEndPointsDescending(),interval.getLow(),searchOutputBufferedWriter);	
				}
				
				//Continue search in right node
				searchIntervalTreeMarkdeBerg(node.getRight(), interval,searchOutputBufferedWriter);	
			}
			
			//Case 3
			//Look at node's left child
			//Look at node's right child
			else if (interval.getLow() <= node.median && node.median <=interval.getHigh()){
				
				//We know that interval overlaps with node's intervals
				//Write node's intervals down
				searchOutputBufferedWriter.write("Found overlaps: ");
				Print.printArray(node.getIntervalsLeftEndPointsAscending(),searchOutputBufferedWriter);
				searchOutputBufferedWriter.write(System.getProperty("line.separator"));

				searchIntervalTreeMarkdeBerg(node.getLeft(), interval,searchOutputBufferedWriter);	
				searchIntervalTreeMarkdeBerg(node.getRight(), interval,searchOutputBufferedWriter);	
				
			}
			
			//Control Case
			else {
				searchOutputBufferedWriter.write("Security there is a problem. There is an unhandled case." + System.getProperty("line.separator"));
			}
			
		}//End of IF node is not null
		
	}

	
	public static void traverseIntervalTreeBreadthFirstOrder(IntervalTreeMarkdeBerg intervalTree, BufferedWriter bufferedWriter){
		
		try {
			bufferedWriter.write("Breadth first tree traversal starts." + System.getProperty("line.separator"));
		
			Queue<IntervalTreeMarkdeBergNode> queue = new LinkedList<IntervalTreeMarkdeBergNode>();
			
		    if (intervalTree.getRoot() == null)
		        return;
		    
		    queue.clear();
		    queue.add(intervalTree.getRoot());
		    
		    while(!queue.isEmpty()){
		    	
		        IntervalTreeMarkdeBergNode newNode = queue.remove();
		        bufferedWriter.write("Median:" + newNode.getMedian());
		        
		        bufferedWriter.write(" Number of node intervals: " + newNode.getIntervalsLeftEndPointsAscending().length);
			      
		        bufferedWriter.write(" Node intervals:");
		        Print.printArray(newNode.getIntervalsLeftEndPointsAscending(),bufferedWriter);
		        
		        if(newNode.getLeft() != null) queue.add(newNode.getLeft());
		        if(newNode.getRight() != null) queue.add(newNode.getRight());
		        
		    }//End of while

		    bufferedWriter.write("Breadth first tree traversal ends."+ System.getProperty("line.separator"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		try {
			
			String glanetFolder = args[CommandLineArguments.GlanetFolder.value()];
			//String dataFolder = glanetFolder + Commons.DATA + System.getProperty( "file.separator");
			String outputFolder = glanetFolder + Commons.OUTPUT + System.getProperty( "file.separator");
			
			IntervalMarkdeBerg i1 = new IntervalMarkdeBerg(10, 20);
			IntervalMarkdeBerg i2 = new IntervalMarkdeBerg(5, 40);
			IntervalMarkdeBerg i3 = new IntervalMarkdeBerg(30, 50);
			IntervalMarkdeBerg i4 = new IntervalMarkdeBerg(0, 15);
			IntervalMarkdeBerg i5 = new IntervalMarkdeBerg(40, 60);
			IntervalMarkdeBerg i6 = new IntervalMarkdeBerg(10, 30);
			IntervalMarkdeBerg i7 = new IntervalMarkdeBerg(70, 80);
			IntervalMarkdeBerg i8 = new IntervalMarkdeBerg(80, 100);
			IntervalMarkdeBerg i9 = new IntervalMarkdeBerg(0, 100);
			IntervalMarkdeBerg i10 = new IntervalMarkdeBerg(80, 120);
			IntervalMarkdeBerg i11 = new IntervalMarkdeBerg(90, 100);
			
			List<IntervalMarkdeBerg> list = new ArrayList<IntervalMarkdeBerg>();
			
			list.add(i1);
			list.add(i2);
			list.add(i3);
			list.add(i4);
			list.add(i5);
			list.add(i6);
			list.add(i7);
			list.add(i8);
			list.add(i9);
			list.add(i10);
			list.add(i11);
	
			/**************************************************************************************/
			/********************TIME MEASUREMENT**************************************************/
			/**************************************************************************************/
			// if you want to see the current year and day etc. change the line of code below with:
			// DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			// DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			long dateBefore = Long.MIN_VALUE;
			long dateAfter = Long.MIN_VALUE;
			/**************************************************************************************/
			/********************TIME MEASUREMENT**************************************************/
			/**************************************************************************************/
	
			//Time before constructing interval tree 
			dateBefore = System.currentTimeMillis();
			
			BufferedWriter bufferedWriter = null;
			
			FileWriter searchFileWriter = null;
			BufferedWriter searchBufferedWriter = null;
			
			
			searchFileWriter = FileOperations.createFileWriter(outputFolder + "SearchOutputIntervalTreeMarkdeBerg.txt");
			searchBufferedWriter = new BufferedWriter(searchFileWriter);
		
			IntervalMarkdeBerg[] intervalArrayUnsorted = (IntervalMarkdeBerg[]) list.toArray(new IntervalMarkdeBerg[list.size()]);
			IntervalMarkdeBerg[] intervalArraySorted = new IntervalMarkdeBerg[list.size()];
			
			//Do it only once. Sort intervals in ascending order w.r.t. left end points.
			CountingSort.sortLeftEndPointsAscending(intervalArrayUnsorted, SortingOrder.SORTING_IN_ASCENDING_ORDER, intervalArraySorted);			
			
			//Free space
			list = null;
			
			IntervalTreeMarkdeBerg intervalTree = new IntervalTreeMarkdeBerg();
		
			//You have a list of intervals
			IntervalTreeMarkdeBergNode root = constructIntervalTree(intervalTree,intervalArraySorted,bufferedWriter);
			
			intervalTree.setRoot(root);
			
			//Time after constructing interval tree 
			dateAfter = System.currentTimeMillis();
	
			//How much did it take to construct interval tree using Mark de Berg?
			System.out.println("Construction Time for Interval Tree Mark de Berg: " + ((dateAfter - dateBefore)*1.0f)/1000 + " seconds");
			System.out.println("Construction Time for Interval Tree Mark de Berg: " + (dateAfter - dateBefore) + " milli seconds");
			System.out.println("****************************************************************");
	
			if (root!=null){
				traverseIntervalTreeBreadthFirstOrder(intervalTree);
			}
			
			Interval givenInterval = new Interval(96,96);
			searchIntervalTreeMarkdeBerg(intervalTree.getRoot(), givenInterval, searchBufferedWriter);
				
			//Close bufferedWriter
			//bufferedWriter.close();
			searchBufferedWriter.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
