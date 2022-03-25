package id.unitest.undipmaps;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class TableRouteFacultyTest {
	
	private TableRouteFaculty table;
	
	@BeforeEach
	void generateTable() {
		table = new TableRouteFaculty();
	}
	
	@Test
	void testGetRoutes() { 
		ArrayList<ArrayList<Integer>> routes = table.getRoutes();
		assertEquals(20, routes.size());
	}
	
	@Test
	void testGetIndexOfFaculty() {
		Integer index = table.getIndex("FSM");
		assertEquals(0, index);
	}

}
