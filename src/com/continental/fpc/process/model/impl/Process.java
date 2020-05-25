/**
 * 
 */
package com.continental.fpc.process.model.impl;

import java.util.ArrayList;
import java.util.List;

import com.continental.fpc.process.model.IProcess;
import com.continental.fpc.process.model.IStep;
import com.continental.fpc.process.model.Status;

/**
 * @author uidp0368
 *
 */
public class Process implements IProcess {
	
	private static final long serialVersionUID = -8007607822980691689L;
	
	private List<IStep> steps;	

	private int id;
	
	private String name;
	
	private String description;
	
	private Status status;
	
	public Process() {
		
	}

	public Process(int id, String name, String description, Status status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;		
		steps = new ArrayList<IStep>();
		steps.add(new Step((id + 10), "Step_"+(id + 10), "Description_"+(id + 10),Status.NOT_STARTED));
		steps.add(new Step((id + 20), "Step_"+(id + 20), "Description_"+(id + 20),Status.IN_PROGRESS));
		steps.add(new Step((id + 30), "Step_"+(id + 30), "Description_"+(id + 30),Status.COMPLETED));
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
	public List<IStep> getSteps() {
		return steps;
	}

	@Override
	public void addStep(IStep step) {
		steps.add(step);
	}
	
	@Override
	public String toString() {
		return "- Process: \n" +
			   "   id: " + id + "\n" +
			   "   name: " + name + "\n" +
			   "   description: " + description + "\n" +
			   "   status: " + status + "\n" +
			   "   steps: \n" + steps + "\n";
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
	public void setSteps(List<IStep> steps) {
		this.steps = steps;		
	}

}
