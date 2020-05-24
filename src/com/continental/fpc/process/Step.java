/**
 * 
 */
package com.continental.fpc.process;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uidp0368
 *
 */
public class Step implements IStep {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6442678467820673092L;
	
	private List<ITask> tasks;
	
	private int id;
	
	private String name;
	
	private String description;
	
	private Status status;
	
	public Step() {
		
	}

	public Step(int id, String name, String description, Status status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;		
		tasks = new ArrayList<ITask>();
		tasks.add(new Task((id + 1), "Task_"+(id + 1), "Description_"+(id + 1),Status.NOT_STARTED));
		tasks.add(new Task((id + 2), "Task_"+(id + 2), "Description_"+(id + 2),Status.IN_PROGRESS));
		tasks.add(new Task((id + 3), "Task_"+(id + 3), "Description_"+(id + 3),Status.COMPLETED));
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
	public List<ITask> getTasks() {
		return tasks;
	}

	@Override
	public void addTask(ITask task) {
		tasks.add(task);
	}
	
	@Override
	public String toString() {
		return "  - Step: \n" +
			   "     id: " + id + "\n" +
			   "     name: " + name + "\n" +
			   "     description: " + description + "\n" +
			   "     status: " + status + "\n" +
			   "     tasks: \n" + tasks + "\n";
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

	@Override
	public void setTasks(List<ITask> tasks) {
		this.tasks = tasks;		
	}

}
