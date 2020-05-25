package com.continental.fpc.process.persistence;

import com.continental.fpc.process.model.ProcessNode;

public interface StoreService {
	
	public void serializeObject (ProcessNode node);
	
	public ProcessNode deserializeObject();

}
