/**
 * 
 */
package enrichment;

import gnu.trove.map.TIntByteMap;
import gnu.trove.map.TLongByteMap;

/**
 * @author Burcak Otlu
 * @date Jun 29, 2015
 * @project Glanet 
 *
 */
public class AllMapsKeysWithNumbersAndValuesOneorZero {

	// Each map has key as elementNumber and key as 1 or 0.
	// Key as 1 means that permutation has number of overlaps greater than equal to the original number of overlaps,
	// else 0.

	// DNASE TF HISTONE
	TIntByteMap dnaseCellLineNumber2PermutationOneorZeroMap;
	TIntByteMap tfNumberCellLineNumber2PermutationOneorZeroMap;
	TIntByteMap histoneNumberCellLineNumber2PermutationOneorZeroMap;

	// Gene
	TIntByteMap geneNumber2PermutationOneorZeroMap;

	// UserDefinedGeneset
	TIntByteMap exonBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap;
	TIntByteMap regulationBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap;
	TIntByteMap allBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap;

	// UserDefinedLibrary
	TIntByteMap elementTypeNumberElementNumber2PermutationOneorZeroMap;

	// KEGG Pathway
	TIntByteMap exonBasedKeggPathwayNumber2PermutationOneorZeroMap;
	TIntByteMap regulationBasedKeggPathwayNumber2PermutationOneorZeroMap;
	TIntByteMap allBasedKeggPathwayNumber2PermutationOneorZeroMap;

	// TF and KEGG Pathway
	TIntByteMap tfNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap;
	TIntByteMap tfNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap;
	TIntByteMap tfNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap;

	// TF and CellLine and KEGG Pathway
	TLongByteMap tfNumberCellLineNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap;
	TLongByteMap tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap;
	TLongByteMap tfNumberCellLineNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap;

	public TIntByteMap getDnaseCellLineNumber2PermutationOneorZeroMap() {

		return dnaseCellLineNumber2PermutationOneorZeroMap;
	}

	public void setDnaseCellLineNumber2PermutationOneorZeroMap( TIntByteMap dnaseCellLineNumber2PermutationOneorZeroMap) {

		this.dnaseCellLineNumber2PermutationOneorZeroMap = dnaseCellLineNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getTfNumberCellLineNumber2PermutationOneorZeroMap() {

		return tfNumberCellLineNumber2PermutationOneorZeroMap;
	}

	public void setTfNumberCellLineNumber2PermutationOneorZeroMap(
			TIntByteMap tfNumberCellLineNumber2PermutationOneorZeroMap) {

		this.tfNumberCellLineNumber2PermutationOneorZeroMap = tfNumberCellLineNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getHistoneNumberCellLineNumber2PermutationOneorZeroMap() {

		return histoneNumberCellLineNumber2PermutationOneorZeroMap;
	}

	public void setHistoneNumberCellLineNumber2PermutationOneorZeroMap(
			TIntByteMap histoneNumberCellLineNumber2PermutationOneorZeroMap) {

		this.histoneNumberCellLineNumber2PermutationOneorZeroMap = histoneNumberCellLineNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getGeneNumber2PermutationOneorZeroMap() {

		return geneNumber2PermutationOneorZeroMap;
	}

	public void setGeneNumber2PermutationOneorZeroMap( TIntByteMap geneNumber2PermutationOneorZeroMap) {

		this.geneNumber2PermutationOneorZeroMap = geneNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getExonBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap() {

		return exonBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap;
	}

	public void setExonBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap(
			TIntByteMap exonBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap) {

		this.exonBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap = exonBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getRegulationBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap() {

		return regulationBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap;
	}

	public void setRegulationBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap(
			TIntByteMap regulationBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap) {

		this.regulationBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap = regulationBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getAllBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap() {

		return allBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap;
	}

	public void setAllBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap(
			TIntByteMap allBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap) {

		this.allBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap = allBasedUserDefinedGeneSetNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getElementTypeNumberElementNumber2PermutationOneorZeroMap() {

		return elementTypeNumberElementNumber2PermutationOneorZeroMap;
	}

	public void setElementTypeNumberElementNumber2PermutationOneorZeroMap(
			TIntByteMap elementTypeNumberElementNumber2PermutationOneorZeroMap) {

		this.elementTypeNumberElementNumber2PermutationOneorZeroMap = elementTypeNumberElementNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getExonBasedKeggPathwayNumber2PermutationOneorZeroMap() {

		return exonBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public void setExonBasedKeggPathwayNumber2PermutationOneorZeroMap(
			TIntByteMap exonBasedKeggPathwayNumber2PermutationOneorZeroMap) {

		this.exonBasedKeggPathwayNumber2PermutationOneorZeroMap = exonBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap() {

		return regulationBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public void setRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap(
			TIntByteMap regulationBasedKeggPathwayNumber2PermutationOneorZeroMap) {

		this.regulationBasedKeggPathwayNumber2PermutationOneorZeroMap = regulationBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getAllBasedKeggPathwayNumber2PermutationOneorZeroMap() {

		return allBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public void setAllBasedKeggPathwayNumber2PermutationOneorZeroMap(
			TIntByteMap allBasedKeggPathwayNumber2PermutationOneorZeroMap) {

		this.allBasedKeggPathwayNumber2PermutationOneorZeroMap = allBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getTfNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap() {

		return tfNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public void setTfNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap(
			TIntByteMap tfNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap) {

		this.tfNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap = tfNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getTfNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap() {

		return tfNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public void setTfNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap(
			TIntByteMap tfNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap) {

		this.tfNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap = tfNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public TIntByteMap getTfNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap() {

		return tfNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public void setTfNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap(
			TIntByteMap tfNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap) {

		this.tfNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap = tfNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public TLongByteMap getTfNumberCellLineNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap() {

		return tfNumberCellLineNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public void setTfNumberCellLineNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap(
			TLongByteMap tfNumberCellLineNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap) {

		this.tfNumberCellLineNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap = tfNumberCellLineNumberExonBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public TLongByteMap getTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap() {

		return tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public void setTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap(
			TLongByteMap tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap) {

		this.tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap = tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public TLongByteMap getTfNumberCellLineNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap() {

		return tfNumberCellLineNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

	public void setTfNumberCellLineNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap(
			TLongByteMap tfNumberCellLineNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap) {

		this.tfNumberCellLineNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap = tfNumberCellLineNumberAllBasedKeggPathwayNumber2PermutationOneorZeroMap;
	}

}
