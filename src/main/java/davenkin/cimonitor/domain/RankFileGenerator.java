package davenkin.cimonitor.domain;

import java.io.IOException;

/**
 * Created by twer on 3/30/14.
 */
public interface RankFileGenerator {
    void reportToFile() throws IOException;
}
