package com.florianingerl.math.termcalculator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;

import com.florianingerl.util.regex.CaptureTree;
import com.florianingerl.util.regex.CaptureTreeNode;
import com.florianingerl.util.regex.Matcher;
import com.florianingerl.util.regex.Pattern;

public class TermParser {

	private static Pattern pattern;

	static {
		try {
			pattern = Pattern
					.compile(IOUtils.toString(
									TermParser.class.getClassLoader().getResourceAsStream("term1.regex")) );
							
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public Term parse(String term) {
		Matcher matcher = pattern.matcher(term);
		matcher.setMode(Matcher.CAPTURE_TREE);
		if (!matcher.matches())
			return null;
		CaptureTree captureTree = matcher.captureTree();
		System.out.println(captureTree);
		return parse(captureTree.getRoot() );

	}

	private Term parse(CaptureTreeNode node) {
		if (node.getGroupName() == null || "term".equals(node.getGroupName()))
			return parse(node.getChildren().get(0));

		switch (node.getGroupName() ) {
		case "sum":
			List<Term> summands = node.getChildren().stream()
					.map(c -> parse(c)).collect(Collectors.toList());
			return new Sum(summands.get(0), summands.get(1));
		case "product":
			List<Term> factors = node.getChildren().stream()
					.map(c -> parse(c)).collect(Collectors.toList());
			return new Product(factors.get(0), factors.get(1));
		case "summand1":
		case "summand2":
		case "factor1":
		case "factor2":
			return parse(node.getChildren().get(0) );
		case "number":
			return new Number(Integer.parseInt(node.getCapture().getValue()));
		case "inverse":
			return new Inverse( parse(node.getChildren().get(0)) );
		}

		return null;
	}

}
