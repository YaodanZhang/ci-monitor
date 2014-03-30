package davenkin.cimonitor.domain;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by twer on 3/30/14.
 */
public abstract class AbstractRankFileGenerator implements RankFileGenerator {
    protected final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    protected final HtmlUnitDriver driver = new HtmlUnitDriver();
    protected File reportingFile;
    protected String contextUrl;
    protected String rankXpath;

    @Override
    public void reportToFile() throws IOException {
        FileUtils.writeLines(reportingFile, Charset.defaultCharset().toString(), newArrayList(dateFormatter.format(new Date()) + "," + getRankIn(contextUrl, rankXpath)), true);
    }


    public String getRankIn(String url, String rankNumberXpath) {
        try {
            driver.get(url);
            Thread.sleep(2000);
            return findRank(rankNumberXpath);
        } catch (Exception e) {
            return "";
        }
    }

    protected abstract String findRank(String rankNumberXpath);


    public AbstractRankFileGenerator(String fileName, String url, String rankXpath) {
        this.reportingFile = new File(fileName);
        this.contextUrl = url;
        this.rankXpath = rankXpath;
    }

    protected String trim(String str) {
        return str.replaceAll("\\D+", "");
    }
}
