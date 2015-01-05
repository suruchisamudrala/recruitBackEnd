package recruitBackEnd.repository;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import recruitBackEnd.domain.Job;

public interface JobDAO {
	public List<Job> getJobList();

    public void addJob(Job inpJob) throws DataAccessException, FileNotFoundException, SQLException;
    
    public void updateJob(Job inpJob);
    
    public void deleteJob(Job inpJob);
}
