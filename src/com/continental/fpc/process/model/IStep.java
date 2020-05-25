/**
 * 
 */
package com.continental.fpc.process.model;

import java.util.List;

/**
 * @author uidp0368
 *
 */
public interface IStep extends ProcessNode {

	public List<ITask> getTasks();
	
	public void addTask(ITask task);
	
	public void setTasks(List<ITask> tasks);
}
