package mesquite.examples.ExFindSeqCriterion;/*~~  */import java.util.*;import mesquite.lib.*;import mesquite.lib.characters.*;import mesquite.lib.duties.*;import mesquite.lib.table.*;import mesquite.molec.lib.*;/* ======================================================================== */public class ExFindSeqCriterion extends FindSequenceCriterion {	/*.................................................................................................................*/	public boolean startJob(String arguments, Object condition, CommandRecord commandRec, boolean hiredByName) {		return true;	}	/*.................................................................................................................*/   	 public boolean isPrerelease(){   	 	return true;   	 }	/*.................................................................................................................*/	/** returns whether this module is requesting to appear as a primary choice */   	public boolean requestPrimaryChoice(){   		return true;     	}	public boolean showOptions(CharacterData data, MesquiteTable table){		return true;	}   	public boolean findNext(CharacterData data, MesquiteTable table, MesquiteInteger charFound, MesquiteInteger length, MesquiteInteger taxonFound, CommandRecord commandRec) {  			length.setValue(0);  			int firstTaxon = taxonFound.getValue();  			int firstChar = charFound.getValue();			for (int it = firstTaxon; it< data.getNumTaxa(); it++){	   			for (int ic = firstChar; ic< data.getNumChars(); ic++) {	   				if (sequencesMatch(data, table,it, ic, "aaa")){  						charFound.setValue(ic);  						taxonFound.setValue(it);  						length.setValue(3);  						return true;	   				}   				}   			}   			return false;   	}	/*.................................................................................................................*/   	boolean sequencesMatch(CharacterData data, MesquiteTable table, int it, int ic, String sequence) {   		int length = sequence.length();   		if (ic + (length)>=data.getNumChars()){ 			return false;   		}   		for (int site= 0; site < length; site++){   			String cell = table.getMatrixText(site+ic, it);   			if (!cell.equalsIgnoreCase(String.valueOf(sequence.charAt(site)))) {				return false;   			}   		}   		return true;   	}	/*.................................................................................................................*/    	 public String getName() {		return "Find AAA (example module)";   	 }	/*.................................................................................................................*/ 	/** returns an explanation of what the module does.*/ 	public String getExplanation() { 		return "A simple example of a criterion for Find Sequence.  Finds the next occurrence of AAA in a matrix of molecular data." ;   	 }   	 }