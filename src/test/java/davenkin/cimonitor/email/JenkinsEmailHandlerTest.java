package davenkin.cimonitor.email;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/23/13
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class JenkinsEmailHandlerTest {
    @Test
    public void test(){
        String[] strings = "Jenkins build is back to normal : uama-ci >> oracle-identity-service #933".split(":|#|»|>>");
        String trim = strings[1].trim();
        System.out.println(trim);
    }
}
