package recruitBackEnd.service;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import recruitBackEnd.service.JobManager;
import recruitBackEnd.domain.Job;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.dao.DataAccessException;

import recruitBackEnd.repository.*;;  


public class SimpleJobManager implements JobManager{

	/**
	 * 
	 */
	private String message;
	private static final long serialVersionUID = 1L;

	@Autowired  
	JdbcJobDAO jobdao = new JdbcJobDAO();  
	
	public void createJob(Job inpJob) {
		try {
			jobdao.addJob(inpJob);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		message = "Job will be added to database";
	}

	
	public void editJob(Job inpJob) {
		// TODO Auto-generated method stub
		
	}


	public void deleteJob(Job inpJob) {
		// TODO Auto-generated method stub
		
	}


	public List<Job> showJobs() {
		return jobdao.getJobList();
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public byte[] getPdf(Integer jobId){
		return jobdao.getPdf(jobId);
	}
}
