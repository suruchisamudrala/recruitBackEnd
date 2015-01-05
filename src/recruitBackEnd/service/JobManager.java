package recruitBackEnd.service;


import java.io.Serializable;
import java.util.List;

import recruitBackEnd.domain.Job;

public interface JobManager extends Serializable{

    public void createJob(Job inpJob);
    
    public void editJob(Job inpJob);
    
    public void deleteJob(Job inpJob);
    
    public List<Job> showJobs();
    
}
