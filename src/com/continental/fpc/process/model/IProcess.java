package com.continental.fpc.process.model;

import java.util.List;  

public interface IProcess extends ProcessNode {
	
	public List<IStep> getSteps();
	
	public void addStep(IStep step);
	
	public void setSteps(List<IStep> steps);
}
