package de.mfreund.pamtram.util;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public abstract class BundleContentHelper {
	/**
	 * Get file from the de.tud.et.ifa.agtele.autoprobe.transformation plugin
	 * 
	 * @param path path relative to the bundle root
	 * @return file from the bundle
	 */
	public static File getBundleEntry(String path) {
		Bundle bundle = Platform.getBundle("de.tud.et.ifa.agtele.autoprobe.transformation");
		File f = null;
		
    	try {
    		URL resolvedFileURL = FileLocator.toFileURL(bundle.getEntry(path));
    		f = new File(new URI(resolvedFileURL.getProtocol(), resolvedFileURL.getPath(), null));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return f;
    }
	
	/**
	 * Get contents of a folder in the de.tud.et.ifa.agtele.autoprobe.transformation plugin
	 * 
	 * @param dir path of the folder relative to the bundle root
	 * @return list of files from the bundle folder
	 */
	public static ArrayList<File> getBundleContents(String dir) {
    	Bundle bundle = Platform.getBundle("de.tud.et.ifa.agtele.autoprobe.transformation");
    	ArrayList<File> files = new ArrayList<File>();
    	
    	// get all bundle entries of the folder
    	Enumeration<String> entries = bundle.getEntryPaths(dir);
    	
    	// skip if there are no entries in the folder
    	if (entries != null) {
	    	// iterate over the BundleContents
	    	for (String file : Collections.list(bundle.getEntryPaths(dir))) {
	    		// get the file from the bundle
	    		File f = getBundleEntry(file);
	    		
	    		// add the file to the file list
	    		files.add(f);
	
	    		// if the current file is a directory then get its entry recursively
	    		if (f.isDirectory()) {
	    			files.addAll(getBundleContents(file));
	    		}
			}
    	}
    	return files;
    }
	
}
