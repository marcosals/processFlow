package com.continental.fpc.process.app;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.continental.fpc.process.IProcess;
import com.continental.fpc.process.Process;
import com.continental.fpc.process.Status;

public class ProcessApplication {

	public static void main(String[] args) {
		IProcess originalProcess = new Process(100, "Process_" + 100, "Description_" + 100, Status.NOT_STARTED);
		//System.out.println(process);
		
		// byte serialization
		/*
		try {
			FileOutputStream fout = new FileOutputStream("C:\\Users\\uidp0368\\eclipse-workspace-jee\\fpc_grappa_release\\process.txt");  
			ObjectOutputStream out = new ObjectOutputStream(fout);  
			out.writeObject(originalProcess);  
			out.flush();  
			//closing the stream  
			out.close();  
			System.out.println("serialize sucess!!");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			// Creating stream to read the object
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\uidp0368\\eclipse-workspace-jee\\fpc_grappa_release\\process.txt"));
			IProcess process = (IProcess) in.readObject();
			// printing the data of the serialized object
			System.out.println(process);
			// closing the stream
			in.close();
			
			if (originalProcess.toString().equals(process.toString())) {
				System.out.println("Both object are equal!!!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		*/
		
		// xml serialization
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\uidp0368\\eclipse-workspace-jee\\fpc_grappa_release\\process.xml");
		    XMLEncoder encoder = new XMLEncoder(fos);
		    encoder.setExceptionListener(new ExceptionListener() {
		            public void exceptionThrown(Exception e) {
		                System.out.println("Exception! :"+e.toString());
		            }
		    });
		    encoder.writeObject(originalProcess);
		    encoder.close();
		    fos.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("C:\\Users\\uidp0368\\eclipse-workspace-jee\\fpc_grappa_release\\process.xml")));
			IProcess process = (IProcess) decoder.readObject();
			decoder.close();
			System.out.println(process);
			
			if (originalProcess.toString().equals(process.toString())) {
				System.out.println("Both object are equal!!!");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		

	}

}
