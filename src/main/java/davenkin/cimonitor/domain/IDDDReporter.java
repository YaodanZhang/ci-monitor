package davenkin.cimonitor.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by twer on 3/30/14.
 */
public class IDDDReporter {
    private static Logger logger = LoggerFactory.getLogger(IDDDReporter.class);
    private List<RankFileGenerator> contextList;

    public IDDDReporter(List<RankFileGenerator> contextList) {
        this.contextList = contextList;
    }

    public void report() throws IOException, InterruptedException {
        logger.info("Generate IDDD rank report");
        for (RankFileGenerator context : contextList) {
            context.reportToFile();
        }
    }

}