package com.ramesh.wordcount;

import java.io.File;
	import java.io.IOException;
	import org.apache.commons.io.FileUtils;
	import org.apache.hadoop.conf.Configuration;
	import org.apache.hadoop.fs.Path;
	import org.apache.hadoop.io.NullWritable;
	import org.apache.hadoop.io.Text;
	import org.apache.hadoop.io.IntWritable;
	import org.apache.hadoop.mapreduce.Job;
	import org.apache.hadoop.mapreduce.lib.input.FileInputFormat; 
	import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
	import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
	import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
	
	public class WordCountDriver { 
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
	/*
	* I have used my local path in windows change the path as per your
	* local machine
	*/
	/*
	* I have used my local path in windows change the path as per your
	* local machine
	*/
	args = new String[] { 
	"/media/hadoop/156d5b2f-6481-4a81-b1bb-56e2179981bb1/ramesh/2018 life/hadoop/DataFlair/Assignments/Movie_Lens_Project/ml-1m/movies.dat",
	"/media/hadoop/156d5b2f-6481-4a81-b1bb-56e2179981bb1/ramesh/2018 life/hadoop/DataFlair/Assignments/Movie_Lens_Project/Output_ML1_2/"};
	 
	/* delete the output directory before running the job */
	FileUtils.deleteDirectory(new File(args[1])); 
	 
	if (args.length != 2) {
	System.err.println("Please specify the input and output path");
	System.exit(-1);
	}
	
	System.setProperty("hadoop.home.dir","/home/hadoop/work/hadoop-3.1.2");
	
	Configuration conf = new Configuration();
	Job sampleJob = new Job(conf,"Word Count Program");
	sampleJob.setJarByClass(WordCountDriver.class);
	sampleJob.setMapperClass(WordCountMapper.class);
	sampleJob.setReducerClass(WordCountReducer.class);
	FileInputFormat.addInputPath(sampleJob, new Path(args[0])); 
	TextOutputFormat.setOutputPath(sampleJob, new Path(args[1]));
	sampleJob.setMapOutputKeyClass(Text.class);
	sampleJob.setMapOutputValueClass(IntWritable.class);
	sampleJob.setOutputKeyClass(Text.class);
	sampleJob.setOutputValueClass(IntWritable.class);
	System.exit(sampleJob.waitForCompletion(true) ? 0 : 1);
 
	}
	}
 
