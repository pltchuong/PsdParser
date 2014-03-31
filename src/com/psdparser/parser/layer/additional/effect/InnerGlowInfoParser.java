package com.psdparser.parser.layer.additional.effect;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.effect.InnerGlowInfo;
import com.psdparser.parser.common.BlendModeParser;
import com.psdparser.parser.common.KernelParser;


public class InnerGlowInfoParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_27692
	 * **/
	
	public static InnerGlowInfo parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		InnerGlowInfo innerGlowInfo = new InnerGlowInfo();
		innerGlowInfo.setSize(dis.readInt());
		innerGlowInfo.setVersion(dis.readInt());
		innerGlowInfo.setBlur(dis.readInt());
		innerGlowInfo.setIntensity(dis.readInt());
		innerGlowInfo.setColor(KernelParser.parseString(dis, cis, 10));
		innerGlowInfo.setBlendMode(BlendModeParser.parse(dis, cis));
		innerGlowInfo.setEnabled(dis.readBoolean());
		innerGlowInfo.setOpacity(Integer.valueOf(dis.read()));
		
		if(innerGlowInfo.getVersion() == 2) {
			innerGlowInfo.setInvert(dis.readBoolean());
			innerGlowInfo.setNativeColor(KernelParser.parseString(dis, cis, 10));
		}
		
		return innerGlowInfo;
		
	}
}
