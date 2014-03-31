package com.psdparser;

import com.psdparser.generator.DefaultGenerator;
import com.psdparser.model.Psd;


public class Application {

	public static void main(String[] args) throws Exception {

		String input = "D:\\Code\\creekwoodinn.com\\Creekwood_web_v5.psd";
		String output = "C:\\test\\";

		Psd psd = new Psd(input);
		DefaultGenerator.generate(psd, output + "index.htm");
	}

}
