package com.psdparser.parser.layer.additional.effect;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.effect.OuterGlowInfo;
import com.psdparser.parser.common.BlendModeParser;
import com.psdparser.parser.common.KernelParser;


public class OuterGlowInfoParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_25738
	 * **/
	
	public static OuterGlowInfo parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		OuterGlowInfo outerGlowInfo = new OuterGlowInfo();
		outerGlowInfo.setSize(dis.readInt());
		outerGlowInfo.setVersion(dis.readInt());
		outerGlowInfo.setBlur(dis.readInt());
		outerGlowInfo.setIntensity(dis.readInt());
		outerGlowInfo.setColor(KernelParser.parseString(dis, cis, 10));
		outerGlowInfo.setBlendMode(BlendModeParser.parse(dis, cis));
		outerGlowInfo.setEnabled(dis.readBoolean());
		outerGlowInfo.setOpacity(Integer.valueOf(dis.read()));
		
		if(outerGlowInfo.getVersion() == 2) {
			outerGlowInfo.setNativeColor(KernelParser.parseString(dis, cis, 10));
		}
		
		return outerGlowInfo;
		
	}
}
