package recruitBackEnd.service;


import junit.framework.TestCase;

import org.junit.Test;
import java.util.List;  


import recruitBackEnd.domain.Job;
import recruitBackEnd.service.SimpleJobManager;


public class SimpleJobManagerTests extends TestCase{
/*
	@Test
	public void testAddNewJob() throws Exception{		
        Job testJob = new Job();
        
        testJob.setKeywords("Test");
        testJob.setDeadline("01-01-2015");
        testJob.setTitle("Developer");
        testJob.setLoc("Swindon");
        testJob.setSalary("40000");
        testJob.setManager("Suruchi");
        testJob.setBand("C");
        testJob.setDirectorate("IT Services");
        testJob.setProfile("Java developer required");
        testJob.setPdfUpldFileName("/Users/suruchisamudrala/Desktop/Job.pdf");
        
        SimpleJobManager testJobManager = new SimpleJobManager();
        testJobManager.createJob(testJob);
        assertEquals("Job will be added to database", testJobManager.getMessage());
    }
*/	
	@Test
	public void testListJob(){
		SimpleJobManager testJobManager = new SimpleJobManager();
		List<Job> jobList = testJobManager.showJobs();
		for (Job job : jobList) {
			System.out.println(job.getUpldFile());
			assertEquals("Developer", job.getTitle());
		}
	}

}
