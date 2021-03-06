/**
 * @author burcakotlu
 * @date Sep 16, 2014 
 * @time 10:14:50 AM
 */
package collaboration;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * 
 */
public class ElementAnnotationEnrichment {

	String elementName;
	boolean enriched_BH_FDR;
	boolean enriched_Bonferroni_Correction;
	Float empiricalPValue;
	Float BonferroniCorrectedPValue;
	Float BHFDRAdjustedPValue;
	int numberofOverlaps;

	Set<String> overlappingGivenIntervalSet;
	List<String> rsIdList;

	public Float getEmpiricalPValue() {

		return empiricalPValue;
	}

	public void setEmpiricalPValue( Float empiricalPValue) {

		this.empiricalPValue = empiricalPValue;
	}

	public boolean isEnriched_Bonferroni_Correction() {

		return enriched_Bonferroni_Correction;
	}

	public void setEnriched_Bonferroni_Correction( boolean enriched_Bonferroni_Correction) {

		this.enriched_Bonferroni_Correction = enriched_Bonferroni_Correction;
	}

	public List<String> getRsIdList() {

		return rsIdList;
	}

	public void setRsIdList( List<String> rsIdList) {

		this.rsIdList = rsIdList;
	}

	public String getElementName() {

		return elementName;
	}

	public void setElementName( String elementName) {

		this.elementName = elementName;
	}

	public boolean isEnriched_BH_FDR() {

		return enriched_BH_FDR;
	}

	public void setEnriched_BH_FDR( boolean enriched_BH_FDR) {

		this.enriched_BH_FDR = enriched_BH_FDR;
	}

	public Float getBonferroniCorrectedPValue() {

		return BonferroniCorrectedPValue;
	}

	public void setBonferroniCorrectedPValue( Float bonferroniCorrectedPValue) {

		BonferroniCorrectedPValue = bonferroniCorrectedPValue;
	}

	public Float getBHFDRAdjustedPValue() {

		return BHFDRAdjustedPValue;
	}

	public void setBHFDRAdjustedPValue( Float bHFDRAdjustedPValue) {

		BHFDRAdjustedPValue = bHFDRAdjustedPValue;
	}

	public int getNumberofOverlaps() {

		return numberofOverlaps;
	}

	public void setNumberofOverlaps( int numberofOverlaps) {

		this.numberofOverlaps = numberofOverlaps;
	}

	public Set<String> getOverlappingGivenIntervalSet() {

		return overlappingGivenIntervalSet;
	}

	public void setOverlappingGivenIntervalSet( Set<String> overlappingGivenIntervalSet) {

		this.overlappingGivenIntervalSet = overlappingGivenIntervalSet;
	}

	// AnnotationEnrichmentElement
	public ElementAnnotationEnrichment( String elementName, int numberofOverlaps,
			Set<String> overlappingGivenIntervalSet) {

		super();
		this.elementName = elementName;
		this.numberofOverlaps = numberofOverlaps;
		this.overlappingGivenIntervalSet = overlappingGivenIntervalSet;
	}

	public static Comparator<ElementAnnotationEnrichment> BENJAMINI_HOCHBERG_FDR_ADJUSTED_P_VALUE = new Comparator<ElementAnnotationEnrichment>() {

		public int compare( ElementAnnotationEnrichment element1, ElementAnnotationEnrichment element2) {

			return element1.getBHFDRAdjustedPValue().compareTo( element2.getBHFDRAdjustedPValue());

		}
	};

	public static Comparator<ElementAnnotationEnrichment> BONFERRONI_CORRECTED_P_VALUE = new Comparator<ElementAnnotationEnrichment>() {

		public int compare( ElementAnnotationEnrichment element1, ElementAnnotationEnrichment element2) {

			return element1.getBonferroniCorrectedPValue().compareTo( element2.getBonferroniCorrectedPValue());

		}
	};

	/**
	 * @param args
	 */
	public static void main( String[] args) {

		// TODO Auto-generated method stub

	}

}
