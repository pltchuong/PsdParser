package com.psdparser.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;

import com.psdparser.Application;
import com.psdparser.generator.html.Tag;
import com.psdparser.model.Layer;
import com.psdparser.model.Psd;
import com.psdparser.utils.ExportUtils;
import com.psdparser.utils.LayerUtils;

public class DefaultGenerator {

	public static void generate(Psd psd, String outputFile) throws Exception {
		
		// export all layers
//		ExportUtils.export(psd);
		
		
		InputStream input = Application.class.getResourceAsStream("/com/psdparser/template/index.html");
		BufferedWriter output = Files.newBufferedWriter(new File(outputFile).toPath(), Charset.forName("ISO-8859-1"));
		
		int b;
		while((b = input.read()) > 0) {
			output.write(b);	
		}
		
		for (Layer layer : psd.getLayers()) {
			output.write(generate(layer));
		}
		output.write("</div></body></html>");
		output.close();
	}

	private static String generate(Layer layer) throws Exception {
		if (!layer.isVisible() || layer.isClipping()) return "";
		
		String x = "";
		if(layer.isGroup() && !layer.isMergeable()) {
			for (Layer child : layer.getLayers()) {
				x += generate(child);
			}
		} else {
			Tag tag = LayerUtils.getTagFromLayer(layer);
			x += tag.getHtml();
		}
		
//		String x = "";
//		if(tag == null) {
//			x += "<div style='position: absolute; top: " + layer.getTop() + "px; left: " + layer.getLeft() + "px;'>" + layer.toString() + "</div>";
//		} else {
//			x += tag.getHtml();
//		}
		return x;
	}
}
