package davenkin.cimonitor.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by twer on 3/30/14.
 */
public class DDDReporter {
    private static Logger logger = LoggerFactory.getLogger(DDDReporter.class);

    private String command;

    public void setCommand(String command) {
        this.command = command;
    }

    public void report() throws IOException, InterruptedException {
        logger.info("DDD Amazon Reporting");
        Runtime r = Runtime.getRuntime();
        Process p = r.exec(command);
        p.waitFor();
    }


}
