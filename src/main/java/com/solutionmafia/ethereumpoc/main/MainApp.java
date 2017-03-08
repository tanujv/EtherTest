package com.solutionmafia.ethereumpoc.main;

import com.solutionmafia.ethereumpoc.utils.Web3JUtils;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
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

        log.info("Welcome to Ethereum POC!");
        String version = null;
        try {
            Web3j web3 = Web3j.build(new HttpService());
            version = Web3JUtils.getVersion(web3);
        } catch (InterruptedException | ExecutionException ex) {
            log.error(ex);
        }
        log.info("version: " + version);
        if (version != null) {
            try {
                ECKeyPair ecKeyPair = Keys.createEcKeyPair();
                BigInteger privateKey = ecKeyPair.getPrivateKey();
                BigInteger publicKey = ecKeyPair.getPublicKey();
                log.info("privateKey: " + privateKey);
                log.info("publicKey: " + publicKey);
            } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException ex) {
                log.error(ex);
            }

        }
    }

}
