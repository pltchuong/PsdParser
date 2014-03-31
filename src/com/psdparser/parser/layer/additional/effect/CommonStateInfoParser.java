package com.psdparser.parser.layer.additional.effect;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.effect.CommonStateInfo;


public class CommonStateInfoParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_41831
	 * **/
	
	public static CommonStateInfo parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		CommonStateInfo commonStateInfo = new CommonStateInfo();
		commonStateInfo.setSize(dis.readInt());
		commonStateInfo.setVersion(dis.readInt());
		commonStateInfo.setVisible(dis.readBoolean());
		commonStateInfo.setUnused(Integer.valueOf(dis.readShort()));
		
		return commonStateInfo;
		
	}
}
