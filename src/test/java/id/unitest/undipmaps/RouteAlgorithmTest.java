package id.unitest.undipmaps;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RouteAlgorithmTest { 
	private TableRouteFaculty table;
	private RouteAlgorithm ralog;
	private ArrayList<ArrayList<Integer>> routes;
	private ArrayList<String> faculties;  
	
	@BeforeEach
	public void generateRouteAlgorithm() {
		ralog = new RouteAlgorithm();
		
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
		 		
		// Add route between faculties
		routes = new ArrayList<ArrayList<Integer>>();
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FT"), faculties.indexOf("FPP"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FT"), faculties.indexOf("FSM"), 10) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FT"), faculties.indexOf("FISIP"), 15) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FPP"), faculties.indexOf("FPIK"), 5) ));
		routes.add(new ArrayList<Integer>(Arrays.asList(faculties.indexOf("FPIK"), faculties.indexOf("FKM"), 2) ));
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
	
		// Mockito
		table = mock(TableRouteFaculty.class);
	}
	
	@ParameterizedTest(name= "{index} => facultyA={0}, facultyB={1}, expected={2}")
	@CsvSource({"FSM,FIB,true", "FT,FP,true", 
		        "FT,SV,true", "FK,FISIP,false",
		        "FKM,FH,false", "FISIP,FK,false", 
		        "FSM,SV,true", "FSM,FT,false"})
	public void testIsThereRoute(String facultyA, String facultyB, boolean expected) {
		when(table.getIndex(facultyA)).thenReturn(faculties.indexOf(facultyA));
		when(table.getIndex(facultyB)).thenReturn(faculties.indexOf(facultyB));
		when(table.getRoutes()).thenReturn(routes);
		when(table.getNumberOfFaculty()).thenReturn(faculties.size());
		 		 
		boolean result = ralog.isThereRoute(facultyA, facultyB, table); 
		assertEquals(expected, result);
	}
	
	@ParameterizedTest(name= "{index} => facultyA={0}, facultyB={1}, expected={2}")
	@CsvSource({"FSM,FIB,65", "FT,FP,25",
			    "FT,SV,25", "FPP,FEB,12"})
	public void testGetClosestDistance(String facultyA, String facultyB, int expected) {
		when(table.getIndex(facultyA)).thenReturn(faculties.indexOf(facultyA));
		when(table.getIndex(facultyB)).thenReturn(faculties.indexOf(facultyB));
		when(table.getRoutes()).thenReturn(routes);
		when(table.getNumberOfFaculty()).thenReturn(faculties.size());
		 		
		int result = ralog.getClosestDistance(facultyA, facultyB, table);
		assertEquals(expected, result);
	}
}
