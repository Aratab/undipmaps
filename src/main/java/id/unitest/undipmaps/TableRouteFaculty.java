package id.unitest.undipmaps;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class TableRouteFaculty {
	private HashMap<String, Integer> indexes;
	private ArrayList<ArrayList<Integer>> routes;
	private ArrayList<String> faculties;
	
	public TableRouteFaculty() {
		// Add faculty
		faculties = new ArrayList<String>();
		faculties.add("FSM");
		faculties.add("FEB");
		faculties.add("FP");
		faculties.add("FT");
		faculties.add("FPP");
		faculties.add("FPIK");
		faculties.add("FKM");
		faculties.add("FK");
		faculties.add("FIB");
		faculties.add("FISIP");
		faculties.add("FH");
		faculties.add("SV");
		
		// Add index and abbreviation of faculty 
		indexes = new HashMap<String, Integer>();
		indexes.put("FSM", 0);
		indexes.put("FEB", 1);
		indexes.put("FP", 2);
		indexes.put("FT", 3);
		indexes.put("FPP", 4);
		indexes.put("FPIK", 5);
		indexes.put("FKM", 6);
		indexes.put("FK", 7);
		indexes.put("FIB", 8);
		indexes.put("FISIP", 9);
		indexes.put("FH", 10);
		indexes.put("SV", 11);
		
		// Add route between faculties
		routes = new ArrayList<ArrayList<Integer>>();
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FT"), indexes.get("FPP"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FT"), indexes.get("FSM"), 10) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FT"), indexes.get("FISIP"), 15) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FPP"), indexes.get("FPIK"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FPIK"), indexes.get("FKM"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FKM"), indexes.get("FEB"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FKM"), indexes.get("FK"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FK"), indexes.get("FEB"), 15) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FK"), indexes.get("FP"), 25) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FEB"), indexes.get("FP"), 10) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FSM"), indexes.get("FEB"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FSM"), indexes.get("FP"), 15) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FP"), indexes.get("FIB"), 50) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FIB"), indexes.get("FSM"), 14) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FIB"), indexes.get("SV"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FH"), indexes.get("SV"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FH"), indexes.get("FIB"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FH"), indexes.get("FSM"), 15) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FISIP"), indexes.get("FH"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(indexes.get("FISIP"), indexes.get("FSM"), 17) ));
	}
	
	/* Samuel Batara
	 * Return all route.
	 * 
	 * @return ArrayList<ArrayList<Integer>> 
	 */
	public ArrayList<ArrayList<Integer>> getRoutes() {
		return routes;
	}
	
	/* Samuel Batara
	 * Return the index of faculty.
	 * 
	 * @return Integer 
	 */
	public Integer getIndex(String faculty) {
		return indexes.get(faculty);
	}
	
	/* Samuel Batara
	 * Return the number of faculty.
	 * 
	 * @return int 
	 */
	public int getNumberOfFaculty() {
		return faculties.size();
	}
	
}