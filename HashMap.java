import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Map.Entry;


public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner csvData = new Scanner(new File("C:\\Users\\jenni\\Desktop\\CA\\IN\\Dataset1.csv"))) {
			List<String> list = new ArrayList<String>();
			while (csvData.hasNext()) {
				list.add(csvData.nextLine());
			}
			String[] tempArray = list.toArray(new String[1]);
			String[][] csvArray = new String[tempArray.length][];
			String combined_list[] = new String[tempArray.length];
			String myData = null;
		
		for(int i = 0; i < tempArray.length; i++) {
			if(i==0) continue;
			csvArray[i] = tempArray[i].split(",");
			if(csvArray[i][4].matches("^\"[a-zA-Z].*\"")) {
				continue;
			}
			else {
				myData = csvArray[i][2] + " " +
						csvArray[i][3] + " " +
						csvArray[i][4] + " " +
						csvArray[i][5] + " " +
						csvArray[i][6]; 
				combined_list[i] = myData;
			}
		}
		
		getOccurances("Suspicious Result(s)", combined_list);
	}
	catch(Exception ex) {
		System.out.println(ex);
	}
}

private static void getOccurances(String message, String[] myArray) {
	Map<String, Integer> map = new HashMap<>();
	for(String key : myArray) {
		if(map.containsKey(key)) {
			int occurrence = map.get(key);
			occurrence++;
			map.put(key, occurrence);
		}
		else {
			map.put(key, 1);
		}
	}
	
	Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue())).collect(Collectors.toMap(Entry::getKey,  Entry::getValue, (e1,e2) -> e2, LinkedHashMap::new));
	
	printMap(message, sortedMap);
}

private static void printMap(String message, Map<String, Integer> map) {
	System.out.println();
	System.out.println();
	System.out.println("Printing " + message);
	System.out.println();
	
	map.forEach((key, value) -> {
		if(key != null && value > 100) {
			System.out.println(key + " appeared " + value + " time(s).");
			}
		});
	
	}
}

