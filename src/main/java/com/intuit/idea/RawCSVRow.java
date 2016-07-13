package com.intuit.idea;

import java.util.StringTokenizer;

/**
 * Created by bm3 on 7/13/16.
 */
public class RawCSVRow implements Comparable<RawCSVRow>
{
	int id;
	String text;
	String timeStamp;
	char delimiter;

	public RawCSVRow(char delimiter)
	{
		this.delimiter = delimiter;
	}

	public static RawCSVRow translate(String row, char delimiter )
	{
		RawCSVRow result = new RawCSVRow(delimiter);
		StringTokenizer tokenizer = new StringTokenizer(row, Character.toString(delimiter));
		result.setId( Integer.valueOf((String)tokenizer.nextElement()) );
		result.setText( ((String) tokenizer.nextElement()).toUpperCase() );
		result.setTimeStamp( (String) tokenizer.nextElement() );
		return result;
	}

	public String getTimeStamp()
	{
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		try
		{
			Thread.sleep(1);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return id + "" + delimiter + text + delimiter + timeStamp;
	}

	public int compareTo(RawCSVRow that)
	{
		return this.id - that.id;
	}
}
