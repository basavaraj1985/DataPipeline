package com.intuit.idea;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by bm3 on 7/13/16.
 */
public class DataPipeline
{
	/**
	 * Processes an input csv file and generates output file based on 'some' business logic.
	 * @param inputFile - the input csv to be processed
	 * @param outputFile - processed output file
	 * @param delimiter - delimiter used
	 * @return
	 * @throws IOException
	 */
	public static File process(String inputFile, String outputFile, char delimiter) throws IOException
	{
		File resultFile = new File(outputFile);
		BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile));
		File file = new File(inputFile);
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String line ;
		List<RawCSVRow> outputList = new ArrayList<RawCSVRow>();
		while ( ( line = reader.readLine() ) != null )
		{
			RawCSVRow row = RawCSVRow.translate(line, delimiter);
			row.setTimeStamp(String.valueOf(System.currentTimeMillis()));
			Random random = new Random();
			int rand = random.nextInt(100) + 1;
			if ( rand % 7 == 0  && rand % 3 == 0 )
			{
				System.out.print("-");
				row.setId(rand);
			}
			outputList.add(row);
		}
		System.out.println();
		Collections.shuffle(outputList);
		for ( RawCSVRow row: outputList )
		{
			writer.write(row.toString());
			writer.newLine();
		}
		writer.flush();
		System.out.println("Processed " + inputFile + " and generated output file: " + resultFile.getAbsolutePath() );
		return  resultFile;
	}

	public static void main(String[] args) throws IOException
	{
		if (args.length == 3)
		{
			DataPipeline.process(args[0], args[1], args[2].charAt(0));
		}
		else
		{
			System.out.println("Usage: java -jar thisJar.jar inputFile outputFile delimiter");
			System.out.println("Usage: example java -jar thisJar.jar test.csv output.csv ,");
			DataPipeline.process("test.csv", "output.csv",',');
		}
	}
}
