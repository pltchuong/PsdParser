package com.psdparser.parser.layer.additional.effect;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.effect.DropShadowInfo;
import com.psdparser.parser.common.BlendModeParser;
import com.psdparser.parser.common.KernelParser;


public class DropShadowInfoParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_22203
	 * **/
	
	public static DropShadowInfo parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		DropShadowInfo dropShadowInfo = new DropShadowInfo();
		dropShadowInfo.setSize(dis.readInt());
		dropShadowInfo.setVersion(dis.readInt());
		dropShadowInfo.setBlur(dis.readInt());
		dropShadowInfo.setIntensity(dis.readInt());
		dropShadowInfo.setAngle(dis.readInt());
		dropShadowInfo.setDistance(dis.readInt());
		dropShadowInfo.setColor(KernelParser.parseString(dis, cis, 10));
		dropShadowInfo.setBlendMode(BlendModeParser.parse(dis, cis));
		dropShadowInfo.setEnabled(dis.readBoolean());
		dropShadowInfo.setCommonAngle(dis.readBoolean());
		dropShadowInfo.setOpacity(Integer.valueOf(dis.read()));
		dropShadowInfo.setNativeColor(KernelParser.parseString(dis, cis, 10));
		
		return dropShadowInfo;
		
	}
}
