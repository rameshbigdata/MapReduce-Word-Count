package com.ramesh.wordcount;

 

import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Mapper;
	public class WordCountMapper extends Mapper<Object, Text, Text, IntWritable> {
	@Override
	public void map(Object key, Text line, Context context) throws IOException, InterruptedException {
	String word;
	StringTokenizer tokens=new StringTokenizer(line.toString());
	while(tokens.hasMoreElements())
	{
		word=tokens.nextToken();
		context.write(new Text(word), new IntWritable(1));
	}

	}
	}
