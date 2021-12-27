package com.ramesh.wordcount;

 

import java.io.IOException; 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
	
	public class WordCountReducer extends Reducer<Text,IntWritable,Text,IntWritable>
	{
 
		public  void reduce(Text word,Iterable<IntWritable> values,Context con) throws IOException,InterruptedException
		{
			int sum=0;
			// TODO Auto-generated method stub
			for (IntWritable val : values)
			{
				sum=sum+val.get();
			}
			con.write(word, new IntWritable(sum));
		}

	}