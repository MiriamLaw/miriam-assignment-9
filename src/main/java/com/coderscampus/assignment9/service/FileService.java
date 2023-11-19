package com.coderscampus.assignment9.service;

import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class FileService {

	Reader in = new FileReader("recipes.txt");
	Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().withHeader(args).parse(in);
	for (CSVRecord record : records) {
		Integer.parseInt(record.get(0));
		Boolean.parseBoolean(record.get(1));
		Boolean.parseBoolean(record.get(2));
		record.get(3);
	}

}}
