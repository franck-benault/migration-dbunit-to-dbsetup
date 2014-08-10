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
	
	public static String listToStringWithNull(List<String> input, int listSize) {
		
		String output = null;
		
		for(String s : input) {
			if(output==null)
				output="\"";
			else
				output+="\",\"";
			output+=s;
		}
		
		if(input.size()<listSize) {
			for(int i=0; i<(listSize-input.size());i++)
				if(i==0)
					output+="\",null";
				else
					output+=",null";
		} else
			output+="\"";
		
		
		
		return output;
	}
}
