package davenkin.cimonitor.domain;

/**
 * Created by twer on 3/30/14.
 */
public class AmazonRankFileGenerator extends AbstractRankFileGenerator {

    public AmazonRankFileGenerator(String url, String fileName, String rankXpath) {
        super(fileName, url, rankXpath);
    }

    protected String findRank(String rankNumberXpath) {
        return trim(driver.findElementByXPath(rankNumberXpath).getText());
    }

}
