package com.continental.fpc.process.app;

import com.continental.fpc.process.execution.Executable;
import com.continental.fpc.process.model.IProcess;
import com.continental.fpc.process.model.Status;
import com.continental.fpc.process.model.impl.Process;
import com.continental.fpc.process.persistence.StoreService;
import com.continental.fpc.process.persistence.impl.XmlStoreService;

public class ProcessApplication {

	public static void main(String[] args) {
		IProcess originalProcess = new Process(100, "Process_" + 100, "Description_" + 100, Status.NOT_STARTED);
		
		StoreService storeService = new XmlStoreService("proc.xml");
		
		storeService.serializeObject(originalProcess);
		
		IProcess deserializedProcess = (IProcess)storeService.deserializeObject();
		
		String result = Executable.execute(deserializedProcess.getSteps().get(0).getTasks().get(0));
		
		System.out.println(result);

	}

}
