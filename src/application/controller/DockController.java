package application.controller;

import java.util.ArrayList;
import java.util.List;

import application.entity.Bike;
import application.entity.Dock;

public class DockController {
	private List<Dock> listOfDocks = new ArrayList<Dock>();
	
	public List<Dock> getAllDock() {
		return listOfDocks;
	}
	
	public void addDockToList(Dock dock) {
		listOfDocks.add(dock);
	}
	
	public List<Dock> searchDocks(String queryString){
		List<Dock> resultDocks = new ArrayList<Dock>();
		for (int i = 0; i < listOfDocks.size(); i++) {
			if (listOfDocks.get(i).getName().contains(queryString)) {
				System.out.println("Found\n");
				resultDocks.add(listOfDocks.get(i));
			}
				
		}
		return resultDocks;
	}
}
