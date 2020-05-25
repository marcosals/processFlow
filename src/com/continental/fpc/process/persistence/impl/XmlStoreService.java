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

	@Override
	public void serializeObject(ProcessNode node) {
		
		XmlMapper xmlMapper = new XmlMapper();
	    try {
			xmlMapper.writeValue(new File("simple_bean.xml"), node);
			File file = new File("simple_bean.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    /*
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\uidp0368\\eclipse-workspace-jee\\fpc_grappa_release\\process.xml");
		    XMLEncoder encoder = new XMLEncoder(fos);
		    encoder.setExceptionListener(new ExceptionListener() {
		            public void exceptionThrown(Exception e) {
		                System.out.println("Exception! :"+e.toString());
		            }
		    });
		    encoder.writeObject(node);
		    encoder.close();
		    fos.close();
		} catch (Exception e) {
			System.out.println(e);
		}*/

	}

	@Override
	public ProcessNode deserializeObject() {
		IProcess process = null;
		try {
			XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("simple_bean.xml")));
			process = (IProcess) decoder.readObject();
			decoder.close();
			System.out.println(process);
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return process;
	}

}
