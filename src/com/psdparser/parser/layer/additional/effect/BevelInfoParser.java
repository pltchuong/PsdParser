package com.psdparser.parser.layer.additional.effect;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.effect.BevelInfo;
import com.psdparser.parser.common.BlendModeParser;
import com.psdparser.parser.common.KernelParser;


public class BevelInfoParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_31889
	 * **/
	
	public static BevelInfo parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		BevelInfo bevelInfo = new BevelInfo();
		bevelInfo.setSize(dis.readInt());
		bevelInfo.setVersion(dis.readInt());
		bevelInfo.setAngle(dis.readInt());
		bevelInfo.setStrength(dis.readInt());
		bevelInfo.setBlur(dis.readInt());
		bevelInfo.setHighlightBlendMode(BlendModeParser.parse(dis, cis));
		bevelInfo.setShadowBlendMode(BlendModeParser.parse(dis, cis));
		bevelInfo.setHighlightColor(KernelParser.parseString(dis, cis, 10));
		bevelInfo.setShadowColor(KernelParser.parseString(dis, cis, 10));
		bevelInfo.setStyle(dis.read());
		bevelInfo.setHighlightOpacity(dis.read());
		bevelInfo.setShadowOpacity(dis.read());
		bevelInfo.setEnabled(dis.readBoolean());
		bevelInfo.setCommonAngle(dis.readBoolean());
		bevelInfo.setUp(dis.readBoolean());
		
		if(bevelInfo.getVersion() == 2) {
			bevelInfo.setHighlightRealColor(KernelParser.parseString(dis, cis, 10));
			bevelInfo.setShadowRealColor(KernelParser.parseString(dis, cis, 10));
		}
		
		return bevelInfo;
		
	}
}
