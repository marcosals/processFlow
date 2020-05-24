/**
 * 
 */
package com.continental.fpc.process;

import java.io.Serializable;
import java.util.List;

/**
 * @author uidp0368
 *
 */
public interface IStep extends Serializable {

	public int getId();
	
	public String getName();
	
	public String getDescription();
	
	public Status getStatus();
	
	public List<ITask> getTasks();
	
	public void addTask(ITask task);
	
	public void setId(int id);
	
	public void setName(String name);
	
	public void setDescription(String description);
	
	public void setStatus(Status status);
	
	public void setTasks(List<ITask> tasks);
}
