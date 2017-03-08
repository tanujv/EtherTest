package com.solutionmafia.ethereumpoc.main;

import com.solutionmafia.ethereumpoc.utils.Web3JUtils;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class MainApp {

    public static Logger log = Logger.getLogger(MainApp.class.getName());

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            log.info("Welcome to Ethereum POC!");
            Web3j web3 = Web3j.build(new HttpService());
            String version = Web3JUtils.getVersion(web3);
            log.info("version: " + version);
        } catch (InterruptedException | ExecutionException ex) {
            log.error(ex);
        }
    }

}
