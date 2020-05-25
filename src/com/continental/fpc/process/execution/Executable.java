package com.continental.fpc.process.execution;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import com.continental.fpc.process.model.ITask;

public class Executable {
	
	public static String execute(ITask task) {
		
		String result = "Task: " + task.getCommand();
		try {
			//Run a bat file
			//Process process = Runtime.getRuntime().exec(
			//			"cmd /c hello.bat", null, new File("."));
			
			Process process = Runtime.getRuntime().exec(task.getCommand());

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("exitVal = Success!");
			} else {
				System.out.println("exitVal = Fail!");
			}
			
			result += output.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
