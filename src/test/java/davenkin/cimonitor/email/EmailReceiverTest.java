package davenkin.cimonitor.email;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/16/13
 * Time: 10:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmailReceiverTest {
   @Test
    public void dd(){
       String subject = "Stage [GCIS-Trunk/1118/Build/1] passed";
       String[] split = subject.split("\\[|/");
       for (String s : split) {
           System.out.println(s);
       }
       System.out.println();
       Pattern pattern = Pattern.compile("(\\[.*?/)");
       Matcher matcher = pattern.matcher(subject);
       if (matcher.find()) {
           System.out.println(matcher.group(1));
       }
   }
}
