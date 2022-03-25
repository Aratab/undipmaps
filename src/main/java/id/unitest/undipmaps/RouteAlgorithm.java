package id.unitest.undipmaps;
 
import java.util.ArrayList;

public class RouteAlgorithm {
	
	/* Samuel Batara
	 * Check if there is a route from faculty A to faculty B.
	 * 
	 * @return boolean
	 */
	public boolean isThereRoute(String fA, String fB, TableRouteFaculty table) { 
		ArrayList<ArrayList<Integer>> routes = table.getRoutes();
		int nfaculty = table.getNumberOfFaculty();

		ArrayList<Boolean> visited = new ArrayList<Boolean>();
		for(int i=0; i<nfaculty; i++) {
			visited.add(false);
		}
		
		int indexFA = table.getIndex(fA);
		int indexFB = table.getIndex(fB);
		
		visited.set(indexFA, true);
		for(int k=0; k<nfaculty; k++) {
			for(int i=0; i<routes.size(); i++) {
				int a = routes.get(i).get(0);
				int b = routes.get(i).get(1);
				boolean res = visited.get(b) | visited.get(a);
				visited.set(b, res);
			}
		}
		return visited.get(indexFB);
	}
	
	/* Samuel Batara
	 * Get the distance between two faculties.
	 * 
	 * @return int
	 */
	public int getClosestDistance(String fA, String fB, TableRouteFaculty table) {
		ArrayList<ArrayList<Integer>> routes = table.getRoutes();
		int nfaculty = table.getNumberOfFaculty();
		int INF = 123999;
		
		ArrayList<Integer> distance = new ArrayList<Integer>();
		for(int i=0; i<nfaculty; i++) {
			distance.add(INF);
		}
		 
		int indexFA = table.getIndex(fA);
		int indexFB = table.getIndex(fB);
		 
		distance.set(indexFA, 0);
		for(int k=0; k<nfaculty; k++) {
			for(int i=0; i<routes.size(); i++) {
				int a = routes.get(i).get(0);
				int b = routes.get(i).get(1);
				int w = routes.get(i).get(2);
				int res = Math.min(distance.get(b), distance.get(a) + w);
				distance.set(b, res);
			}
		}
		 
		return distance.get(indexFB) == INF? -1 : distance.get(indexFB);
	}
}