package com.psdparser.utils;

import org.apache.commons.lang3.StringUtils;

import com.psdparser.Application;
import com.psdparser.model.Psd;

public class ExportUtils {

	public static void export(Psd psd) throws Exception {
		String command = StringUtils.join(new String[] {
				"wscript",
				Application.class.getResource("/com/psdparser/ext/export.vbs").getFile().substring(1),
				psd.getFile().getAbsolutePath(),
				"C:\\test\\",
		}, " ");
		Runtime.getRuntime().exec(command);
	}
}
