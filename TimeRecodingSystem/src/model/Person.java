package model;

import java.util.LinkedHashSet;
/**
* <h1>Representation of a person!</h1>
* Simple representation of a person as a name, 
* manager indication and the persons assigned projects.
*<p>
*/
public class Person implements Comparable<Person> {
	public String name;
	
	public Boolean isManager;

	public LinkedHashSet<String> assignedProjects = new LinkedHashSet<String>();

	
	public Person (String n, Boolean b, String project){
		this.name = n;
		this.isManager = b;
		this.assignProject(project);
	}
	public int compareTo(Person p) {
		return this.name.compareTo(p.name);
	}
	public void assignProject (String project) {
		this.assignedProjects.add(project);
	}
	
	public void PrintPerson () {
		System.out.print(this.name);
		if (this.isManager){
			System.out.println(" Manager");
		}
		else System.out.println(" Developer");
		this.PrintAssignments();
	}
	
	public void PrintAssignments () {
		for (String entry : assignedProjects){
			System.out.println(entry);
		}
	}

}


