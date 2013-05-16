package davenkin.cimonitor.web;

import davenkin.cimonitor.domain.CiProject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/16/13
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class CiMonitorController {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public CiProject processRequest() throws IOException {
        CiProject ciProject = new CiProject();
        ciProject.setName("GCIS");
        ciProject.setSuccess(true);
        return ciProject;
    }

}
