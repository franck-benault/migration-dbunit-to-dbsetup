package net.franckbenault.migration.dbunittodbsetup;

import java.util.ArrayList;
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
	
	public static String listToStringReverse(List<String> input) {
		
		List<String> reverse = new ArrayList<String>();
		for (int i = input.size() ; 0 < i ; i--){
			reverse.add(input.get(i-1));
		}
		return listToString(reverse);
	}
	
	public static String listToStringWithNull(List<String> inputl, int listSize) {
		
		String output = null;
		
		List<String> processList = new ArrayList<String>();
		
		if(inputl.size()<=listSize)
			processList.addAll(inputl);
		else
			for(int i=0; i<listSize; i++)
				processList.add(inputl.get(i));
		
		for(String s : processList) {
			if(output==null)
				output="\"";
			else
				output+="\",\"";
			output+=s;
		}
		
		if(processList.size()<listSize) {
			for(int i=0; i<(listSize-processList.size());i++)
				if(i==0)
					output+="\",null";
				else
					output+=",null";
		} else
			output+="\"";
		
		output = output.replace("\"NULL\"", "null");
		
		return output;
	}
}
