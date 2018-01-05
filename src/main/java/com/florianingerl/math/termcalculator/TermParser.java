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
							new FileInputStream(
									TermParser.class.getClassLoader().getResource("term.regex").getFile()),
							"UTF-8"));
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
		CaptureTree groupTree = matcher.captureTree();
		return parse(groupTree.getRoot() );

	}

	private Term parse(CaptureTreeNode groupTree) {
		if (groupTree.getGroupName() == null || "term".equals(groupTree.getGroupName()))
			return parse(groupTree.getChildren().get(0));

		switch (groupTree.getGroupName() ) {
		case "sum":
			List<Term> summands = groupTree.getChildren().stream().filter(g -> "summand".equals(g.getGroupName()))
					.map(g -> parse(g)).collect(Collectors.toList());
			return new Sum(summands);
		case "product":
			List<Term> factors = groupTree.getChildren().stream().filter(g -> "factor".equals(g.getGroupName()))
					.map(g -> parse(g)).collect(Collectors.toList());
			return new Product(factors);
		case "summand":
		case "factor":
			return parse(groupTree.getChildren().stream().filter(g -> !"round".equals(g.getGroupName())).findAny().get());
		case "number":
			return new Number(Integer.parseInt(groupTree.getCapture().getValue()));

		}

		return null;
	}

}
