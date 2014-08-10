package net.franckbenault.migration.dbunittodbsetup;

public class StringUtils {

	public static String removePointAddProperCase(String xmlFileName) {
	
		String output ="";
		String[] res =xmlFileName.split("\\.");
		
		output = res[0];
		for(int i=1; i<res.length-1; i++) {
			output+=StringUtils.toProperCase(res[i]);
		}
		
		
		return output;
	}
	
	public static String toProperCase(String input) {
		
		String output = input.substring(0, 1).toUpperCase();
		output +=input.substring(1);
				
		
		return output;
	}
}
