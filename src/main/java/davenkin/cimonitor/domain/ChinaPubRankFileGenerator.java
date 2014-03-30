package davenkin.cimonitor.domain;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;

/**
 * Created by twer on 3/30/14.
 */
public class ChinaPubRankFileGenerator extends AbstractRankFileGenerator {

    public ChinaPubRankFileGenerator(String url, String fileName, String rankXpath) {
        super(fileName, url, rankXpath);
    }

    protected String findRank(String rankNumberXpath) {
        List<WebElement> elementsByXPath = driver.findElementsByXPath(rankNumberXpath);
        ImmutableList<String> links = from(elementsByXPath).transform(new Function<WebElement, String>() {
            @Override
            public String apply(WebElement input) {
                return input.getAttribute("href");
            }
        }).toList();
        return String.valueOf(links.indexOf("http://product.china-pub.com/3769562") + 1);
    }

}