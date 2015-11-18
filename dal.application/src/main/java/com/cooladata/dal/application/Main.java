package com.cooladata.dal.application;

public class Main {

	private static String  x = "INSERT INTO `dal`.`datacolumn` ( `created`, `modified`, `version`, `DType`, `UID`, `calculation`, `classificationsStr`, `configJson`, `custom`, `expression`, `hasData`, `haslookup`, `lookupValues`, `name`, `required`, `scope`, `source`, `visible`, `projectId`, `candidate`, `store`, `storageTable`, `isRefreshing`, `lookupsCupSize`, `hasLookupValues`) VALUES ( now(), now(), 0, 0, \"session_event_string_@X\", 1, \"OTHER\", \"{}\", 3, \"session_event_string_@X\", true, false, null, \"event_string_@X\", false, 2, \"event_string__@X\", true, 114135 , null, true, 0, false, null, false); ";
			
	public static void main(String[] args) {

		for (int i = 50; i <= 100; i++) {
			String string = x.replace("@X",""+i);
			System.out.println(string);
			
		}

	}

}
