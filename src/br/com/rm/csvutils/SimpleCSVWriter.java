package br.com.rm.csvutils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimpleCSVWriter {
	
	public static final String COMMA_SEPARATOR = ",", TAB_SEPARATOR="\t", SEMICOLON_SEPARATOR=";";
	
	private String separator = COMMA_SEPARATOR;
		
	private String filename = new Date().getTime()+ ".csv";
	
	public SimpleCSVWriter(String separator, String filename) {
		super();
		this.separator = separator;
		if(filename == null || filename.trim().isEmpty()) {
			throw new IllegalArgumentException("Arg 'filename' does not be null or empty.");
		}else {
			this.filename = filename;
		}
	}

	/**
	 * Arg head does not must be null or empty
	 * @param head List of head columns
	 * @param body List of Columns
	 */
	public void write(List<String> head, List<List<String>> body ) {
		List<String> rows = new ArrayList<String>();
		
		rows.add(extractRowFromColunsList(head));
		
		if(body != null && body.size() > 0) {
			for(List<String> bodyCol : body) {
				rows.add(extractRowFromColunsList(bodyCol));
			}
		}
		
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			String filename = getValidFilename();
			fw = new FileWriter(filename);
			bw = new BufferedWriter(fw);
			
			for(String cols : rows) {
				bw.write(cols+"\n");
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
	}
	
	private String getValidFilename() {
		String extension = ".csv";
		StringBuilder sb = new StringBuilder(extension);
		String extReverse = sb.reverse().toString();
		sb = new StringBuilder(filename);
		String filenameReverse = sb.reverse().toString();
		String defaultFile = new Date().getTime()+ ".csv";
		if(filename == null || filename.isEmpty()) {
			return defaultFile;
		}else if(filenameReverse.startsWith(extReverse)) {
			return filename;
		}else {
			return filename+".csv";
		}
		
	}
	
	private String extractRowFromColunsList(List<String> columns){
		StringBuilder row = new StringBuilder();
		if(columns != null && columns.size() > 0) {
			for(String headCol : columns) {
				headCol = headCol == null? "": headCol;
				headCol = headCol.replaceAll(separator, "");
				row.append(headCol).append(separator);
			}
		}
		return row.toString();
	}
	
	/*public static void main(String[] args) {
		List<String> head = new ArrayList<String>();
		head.add("Nome");
		head.add("E-mail");
		head.add("Telefone");
		List<List<String>> bodyList = new ArrayList<List<String>>();
		
		List<String> body = new ArrayList<String>();
		body.add("Romário");
		body.add("rommario20@gmail.com");
		body.add("(85) 9 9987-1899");
		
		bodyList.add(body);
		
		body = new ArrayList<String>();
		body.add("Gabriela"+SEMICOLON_SEPARATOR+" Rocha");
		body.add("gabiRocha@gmail.com");
		body.add("(85) 9 9987-1899");
		
		bodyList.add(body);
		
		new SimpleCSVWriter(COMMA_SEPARATOR, "      ").write(head, bodyList);
	}*/

}
