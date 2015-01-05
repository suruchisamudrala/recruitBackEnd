package recruitBackEnd.domain;

import java.io.Serializable;

public class Job implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String loc;
	private String manager;
	private String band;
	private String directorate;
	private String deadline;
	private String keywords;
	private String profile;
	private String title;
	private String salary;
	private Integer jobId;
	private String pdfUpldFileName;
	private byte[] upldFile;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getDirectorate() {
		return directorate;
	}
	public void setDirectorate(String directorate) {
		this.directorate = directorate;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
		
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer inpJobId) {
		jobId = inpJobId;;
	}
	
	public String getPdfUpldFileName() {
		return pdfUpldFileName;
	}
	public void setPdfUpldFileName(String pdfUpldFileName) {
		this.pdfUpldFileName = pdfUpldFileName;
	}
	
	public byte[] getUpldFile() {
		return upldFile;
	}
	public void setUpldFile(byte[] upldFile) {
		this.upldFile = upldFile;
	}
	
	@Override
	public String toString() {
		return "Job [loc=" + loc + ", manager=" + manager + ", band=" + band
				+ ", directorate=" + directorate + ", deadline=" + deadline
				+ ", keywords=" + keywords + ", profile=" + profile
				+ ", title=" + title + ", salary=" + salary +"]";
	}
	
		
}
