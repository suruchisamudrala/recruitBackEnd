package recruitBackEnd.repository;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;  

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.PreparedStatement;

import recruitBackEnd.domain.Job;

public class JdbcJobDAO implements JobDAO{
	public String message = "Here";
	protected final Log logger = LogFactory.getLog(getClass());
    
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("../recruitBackEnd-servlet.xml");
	JdbcTemplate jdbcTemplate = new JdbcTemplate((DataSource)applicationContext.getBean("dataSource"));
	
	public byte[] getPdf(Integer jobId){
		String sql = "SELECT upld_file as upldFile FROM job_detail_table where job_id=?";
		byte[] pdfByteArray = (byte[]) jdbcTemplate.queryForObject(sql, new Object[] { jobId }, byte[].class);
	 
		return pdfByteArray;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Job> getJobList() {
		String sql = "SELECT job_master_table.job_id as jobId,"
				+ "deadline as deadline,"
				+ "keywords as keywords,"
				+ "job_title as title,"
				+ "location as loc,"
				+ "salary as salary,"
				+ "line_manager as manager,"
				+ "band as band,"
				+ "directorate as directorate,"
				+ "profile as profile,"
				+ "upld_filename as pdfUpldFileName,"
				+ "upld_file as upldFile FROM job_master_table, job_detail_table where job_master_table.job_id = job_detail_table.job_id";
		 
		List<Job> jobList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Job.class));
	 
		return jobList;
	}

	public void addJob(Job inpJob) throws DataAccessException, FileNotFoundException, SQLException {
		logger.info("Logging here now");
		String sql = "INSERT INTO JOB_MASTER_TABLE (job_id, job_title, deadline, keywords) VALUES (?, ?, ?,?)";
		
		inpJob.setJobId(getNewJobId());
		
		jdbcTemplate.update(sql, new Object[] { inpJob.getJobId(), inpJob.getTitle(), inpJob.getDeadline(), inpJob.getKeywords() });  
		
		sql = "INSERT INTO JOB_DETAIL_TABLE (job_id, location, salary, line_manager, band, directorate, profile, upld_filename, upld_file) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = (PreparedStatement) jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
		stmt.setString(1, inpJob.getJobId().toString());
		stmt.setString(2, inpJob.getLoc());
		stmt.setString(3, inpJob.getSalary());
		stmt.setString(4, inpJob.getManager());
		stmt.setString(5, inpJob.getBand());
		stmt.setString(6, inpJob.getDirectorate());
		stmt.setString(7, inpJob.getProfile());
		stmt.setString(8, inpJob.getPdfUpldFileName());
		stmt.setBinaryStream(9, new FileInputStream(new File(inpJob.getPdfUpldFileName())), (int)new File(inpJob.getPdfUpldFileName()).length());
		int i = stmt.executeUpdate();
		logger.info("Insert output" + i);
		jdbcTemplate.getDataSource().getConnection().close();
	}

	public int getNewJobId(){
		String seqJobId;
		String sql = "SELECT max(job_id) from JOB_MASTER_TABLE";
		seqJobId = jdbcTemplate.queryForObject(sql, String.class);
		if (seqJobId == null){
			return 1;
		}
		else
		{
			return Integer.parseInt(seqJobId) + 1;
		}
	};

	public void updateJob(Job inpJob) {
		// TODO Auto-generated method stub
		
	}


	public void deleteJob(Job inpJob) {
		// TODO Auto-generated method stub
		
	}
}
