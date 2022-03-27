package id.unitest.undipmaps;

import java.util.ArrayList;
import java.util.Arrays;

public class TableRouteFaculty { 
	private ArrayList<ArrayList<Integer>> routes;
	private ArrayList<String> faculties;
	
	public TableRouteFaculty() {
		// Add faculty
		faculties = new ArrayList<String>();
		faculties.add("FSM"); faculties.add("FEB"); faculties.add("FP");
		faculties.add("FT"); faculties.add("FPP"); faculties.add("FPIK");
		faculties.add("FKM"); faculties.add("FK"); faculties.add("FIB");
		faculties.add("FISIP"); faculties.add("FH"); faculties.add("SV");
		
		
		// Add route between faculties
		routes = new ArrayList<ArrayList<Integer>>();
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FT"), faculties.indexOf("FPP"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FT"), faculties.indexOf("FSM"), 10) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FT"), faculties.indexOf("FISIP"), 15) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FPP"), faculties.indexOf("FPIK"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FPIK"), faculties.indexOf("FKM"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FKM"), faculties.indexOf("FEB"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FKM"), faculties.indexOf("FK"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FK"), faculties.indexOf("FEB"), 15) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FK"), faculties.indexOf("FP"), 25) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FEB"), faculties.indexOf("FP"), 10) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FSM"), faculties.indexOf("FEB"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FSM"), faculties.indexOf("FP"), 15) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FP"), faculties.indexOf("FIB"), 50) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FIB"), faculties.indexOf("FSM"), 14) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FIB"), faculties.indexOf("SV"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FH"), faculties.indexOf("SV"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FH"), faculties.indexOf("FIB"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FH"), faculties.indexOf("FSM"), 15) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FISIP"), faculties.indexOf("FH"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FISIP"), faculties.indexOf("FSM"), 17) ));
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
		return faculties.indexOf(faculty);
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