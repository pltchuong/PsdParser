package com.psdparser.parser.common;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.common.Path;

public class PathParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_17587
	 * **/
	
	public static List<Path> parse(DataInputStream dis, CountingInputStream cis, int length) throws Exception {
		
		// TODO
		List<Path> paths = new ArrayList<Path>();
		
		int pathCount = length / 26;
		for (int i = 0; i < pathCount; i++) {
			Path path = new Path();
			path.setType(Integer.valueOf(dis.readShort()));
			path.setValue(KernelParser.parseHex(dis, cis, 24));
			
			paths.add(path);
		}
		
		
		return paths;
		
	}
	
}
