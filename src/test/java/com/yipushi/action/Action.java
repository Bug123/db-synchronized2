package com.yipushi.action;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Action {
	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");
		JobLauncher launcher = c.getBean("jobLauncher",JobLauncher.class);
		Job job = c.getBean("DataReadAndWriterJob",Job.class);
		try {
			launcher.run(job, new JobParameters());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Job job2 = c.getBean("DataInspect",Job.class);
		try {
			launcher.run(job2, new JobParameters());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
