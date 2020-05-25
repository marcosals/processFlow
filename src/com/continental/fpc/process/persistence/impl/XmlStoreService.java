/**
 * 
 */
package com.continental.fpc.process.persistence.impl;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.continental.fpc.process.model.IProcess;
import com.continental.fpc.process.model.ProcessNode;
import com.continental.fpc.process.persistence.StoreService;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @author marcosal
 *
 */
public class XmlStoreService implements StoreService {
	
	private String filename;
	
	public XmlStoreService() {
		
	}
	
	public XmlStoreService(String filename) {
		this.filename = filename;
	}

	@Override
	public void serializeObject(ProcessNode node) {
		
		// xml serialization
		try {
			FileOutputStream fos = new FileOutputStream(
					filename);
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.setExceptionListener(new ExceptionListener() {
				public void exceptionThrown(Exception e) {
					System.out.println("Exception! :" + e.toString());
				}
			});
			encoder.writeObject(node);
			encoder.close();
			fos.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public ProcessNode deserializeObject() {
		IProcess process = null;
		try {
			XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
			process = (IProcess) decoder.readObject();
			decoder.close();
			System.out.println(process);
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return process;
	}

}
