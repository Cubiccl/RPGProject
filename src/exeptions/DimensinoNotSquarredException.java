package exeptions;

import java.awt.Dimension;

public class DimensinoNotSquarredException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DimensinoNotSquarredException() {
		System.err.println("DimensinoNotSquarredException :");
		System.err.println("Rectangular shape detected, square one expected.");
	}
	
	public DimensinoNotSquarredException(Dimension d) {
		System.err.println("DimensinoNotSquarredException :");
		System.err.println("Rectangular shape detected, square one expected.");
		System.err.println("Tried dimention : "+d.height+"/"+d.width);
	}

}
