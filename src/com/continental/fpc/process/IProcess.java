package com.continental.fpc.process;

import java.io.Serializable;
import java.util.List;  

public interface IProcess extends Serializable {

	public int getId();
	
	public String getName();
	
	public String getDescription();
	
	public Status getStatus();
	
	public List<IStep> getSteps();
	
	public void addStep(IStep step);
	
	public void setId(int id);
	
	public void setName(String name);
	
	public void setDescription(String description);
	
	public void setStatus(Status status);
	
	public void setSteps(List<IStep> steps);
}

// Input/Output
// 

// management

// Process
// Step
// Task

// 
// 
