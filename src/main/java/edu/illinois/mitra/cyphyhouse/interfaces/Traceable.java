package edu.illinois.mitra.cyphyhouse.interfaces;

import java.util.HashMap;

/**
 * Traceable objects are capable of providing a HashMap (String -> Object) of important attributes to trace.
 * HashMap keys represent tag names, values represent tag values.
 * 
 * @author Adam Zimmerman
 * @version 1.0
 * 
 */
public interface Traceable {
	
	/**
	 * @return a HashMap (String -> Object) representing all of the key/value pairs
	 * to be written to the trace file in XML form.
	 * For example, putting("color", "orange") will write "<color>orange</color>" in the XML file.
	 */
	HashMap<String,Object> getXML();
}
