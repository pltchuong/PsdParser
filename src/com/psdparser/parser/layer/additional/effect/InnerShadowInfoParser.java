package com.psdparser.parser.layer.additional.effect;

import java.io.DataInputStream;

import org.apache.commons.io.input.CountingInputStream;

import com.psdparser.model.layer.additional.effect.InnerShadowInfo;
import com.psdparser.parser.common.BlendModeParser;
import com.psdparser.parser.common.KernelParser;


public class InnerShadowInfoParser {

	/**
	 * http://www.adobe.com/devnet-apps/photoshop/fileformatashtml/#50577409_22203
	 * **/
	
	public static InnerShadowInfo parse(DataInputStream dis, CountingInputStream cis) throws Exception {
		
		InnerShadowInfo innerShadowInfo = new InnerShadowInfo();
		innerShadowInfo.setSize(dis.readInt());
		innerShadowInfo.setVersion(dis.readInt());
		innerShadowInfo.setBlur(dis.readInt());
		innerShadowInfo.setIntensity(dis.readInt());
		innerShadowInfo.setAngle(dis.readInt());
		innerShadowInfo.setDistance(dis.readInt());
		innerShadowInfo.setColor(KernelParser.parseString(dis, cis, 10));
		innerShadowInfo.setBlendMode(BlendModeParser.parse(dis, cis));
		innerShadowInfo.setEnabled(dis.readBoolean());
		innerShadowInfo.setCommonAngle(dis.readBoolean());
		innerShadowInfo.setOpacity(Integer.valueOf(dis.read()));
		innerShadowInfo.setNativeColor(KernelParser.parseString(dis, cis, 10));
		
		return innerShadowInfo;
		
	}
}
