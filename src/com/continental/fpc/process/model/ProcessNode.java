package com.continental.fpc.process.model;

import java.io.Serializable;

public interface ProcessNode extends Serializable {
	
	public int getId();
	
	public String getName();
	
	public String getDescription();
	
	public Status getStatus();
	
	public void setId(int id);
	
	public void setName(String name);
	
	public void setDescription(String description);

	public void setStatus(Status status);
	
}