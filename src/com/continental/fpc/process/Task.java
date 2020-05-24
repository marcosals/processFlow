/**
 * 
 */
package com.continental.fpc.process;

/**
 * @author uidp0368
 *
 */
public class Task implements ITask {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7426446327764231645L;
	
	private int id;
	
	private String name;
	
	private String description;
	
	private Status status;
	
	public Task() {
		
	}
	
	public Task(int id, String name, String description, Status status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;		
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Status getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return "    - Task: \n" +
			   "       id: " + id + "\n" +
			   "       name: " + name + "\n" +
			   "       description: " + description + "\n" +
			   "       status: " + status + "\n";
		
	}

	@Override
	public void setId(int id) {
		this.id = id;		
	}

	@Override
	public void setName(String name) {
		this.name = name;		
	}

	@Override
	public void setDescription(String description) {
		this.description = description;		
	}

	@Override
	public void setStatus(Status status) {
		this.status = status;		
	}

}
