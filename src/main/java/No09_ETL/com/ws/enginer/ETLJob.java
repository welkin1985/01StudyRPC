package No09_ETL.com.ws.enginer;

import No09_ETL.com.ws.beans.LogBeanFactory;
import No09_ETL.com.ws.beans.impl.ETLedLogBean;
import No09_ETL.com.ws.beans.impl.OrgLogBean;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 *
 */
public class ETLJob extends Configured implements Tool {


    public static class MapClass extends Mapper<LongWritable, Text, Text, Text> {

        private static AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");



        public void map(LongWritable key, Text logText, Context context) throws IOException, InterruptedException {
            OrgLogBean orgLogBean = LogBeanFactory.getOrgLogBen(logText.toString());
            ETLedLogBean initETLBean = LogBeanFactory.getInitETLBean();


            context.write(new Text(initETLBean.toString()), null);
        }
    }

    /*Reduce静态类*/
    public static class Reduce extends Reducer<Text, Text, Text, Text> {
        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            String csv = "";
            for (Text val : values) {
                if (csv.length() > 0) {
                    csv += ",";
                }
                csv += val.toString();
            }
            context.write(key, new Text(csv));
        }
    }

    /*driver驱动方法*/
    public int run(String[] args) throws Exception {
        Configuration conf = getConf();
        Job job = new Job(conf, "MyJobName");
        job.setJarByClass(ETLJob.class);

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(MapClass.class);
        job.setCombinerClass(Reduce.class);
        job.setReducerClass(Reduce.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);

        return 0;
    }


    public static void main(String[] args) throws Exception {


        int res = ToolRunner.run(new Configuration(), new ETLJob(), args);


        System.exit(res);

    }


}
