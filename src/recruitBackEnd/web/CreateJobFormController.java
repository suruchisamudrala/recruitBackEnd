package recruitBackEnd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import recruitBackEnd.domain.Job;
import recruitBackEnd.service.SimpleJobManager;

@Controller
public class CreateJobFormController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/createJobForm", method = RequestMethod.GET)
    public ModelAndView loadFormPage(Model m) {
    	m.addAttribute("message", "Hello Message");
    	return new ModelAndView("createJobForm", "command", new Job()); 
    }
    
    @RequestMapping(value = "/createJobForm", method = RequestMethod.POST)
    public ModelAndView submitForm(@ModelAttribute Job job, 
    ModelMap model) {
    	SimpleJobManager jobManager = new SimpleJobManager();
    	jobManager.createJob(job);
       
    	model.addAttribute("message", jobManager.getMessage());
    	return new ModelAndView("createJobForm", "command", job); 
    }
    
    @RequestMapping(value = "recruitBackEnd/jobList", method = RequestMethod.GET)
    public ModelAndView listForm(Model model) {
    	logger.info("controller invoked");
    	SimpleJobManager jobManager = new SimpleJobManager();
    	return new ModelAndView("/jobList", "jobList", jobManager.showJobs()); 
    }
    
}