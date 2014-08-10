package net.franckbenault.migration.dbunittodbsetup;

import java.util.List;

public class ListUtils {

	public static String listToString(List<String> input) {
		
		String output = null;
		
		for(String s : input) {
			if(output==null)
				output="\"";
			else
				output+="\",\"";
			output+=s;
		}
		output+="\"";
		
		return output;
	}
}
