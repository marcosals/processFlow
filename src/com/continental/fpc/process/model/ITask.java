/**
 * 
 */
package com.continental.fpc.process.model;

/**
 * @author uidp0368
 *
 */
public interface ITask extends ProcessNode {
	
	public String getCommand();
	
	public void setCommand(String command);
}
