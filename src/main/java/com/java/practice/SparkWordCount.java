package com.java.practice;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class SparkWordCount {
    private static final Pattern SPACE = Pattern.compile(" ");

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: WordCount <file>");
            System.exit(1);
        }

        final SparkConf sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount");
        final JavaSparkContext ctx = new JavaSparkContext(sparkConf);
        final JavaRDD<String> lines = ctx.textFile(args[0], 1);

        final JavaRDD<String> words = lines.flatMap( line -> Arrays.asList(line.split(" ")).iterator());
        final JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(s, 1));
        final JavaPairRDD<String, Integer> counts = ones.reduceByKey((i1, i2) -> (Integer) (i1 + i2));

        final List<Tuple2<String, Integer>> output = counts.collect();
        for (Tuple2 tuple : output) {
            System.out.println(tuple._1() + ": " + tuple._2());
        }
        ctx.stop();
    }
}
