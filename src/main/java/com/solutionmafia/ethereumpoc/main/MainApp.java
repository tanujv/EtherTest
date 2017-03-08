package com.solutionmafia.ethereumpoc.main;

import com.solutionmafia.ethereumpoc.utils.Web3JUtils;
import java.util.concurrent.ExecutionException;
import org.apache.log4j.Logger;
import org.ethereum.core.Account;
import org.ethereum.crypto.ECKey;
import org.ethereum.facade.Ethereum;
import org.ethereum.facade.EthereumFactory;
import org.ethereum.facade.Repository;
import org.spongycastle.util.encoders.Hex;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class MainApp {

    static {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.wire", "DEBUG");
    }
    public static Logger log = Logger.getLogger(MainApp.class.getName());
    public static final String ADDRESS_1 = "c53e3501d717c5a5c45fd1e7c41533483804a572";
    public static final String ADDRESS_2 = "9a61a2557d8a2b8d4151cd889ce0b2ac7b64f6c3";
    public static final String PRIVATE_KEY_1 = "9e3cba36d4691e4e0789e9da78c9615cb4937ce14db8271f4828a2a520fe7609";
    public static final String PRIVATE_KEY_2 = "2ca484c64fa4257dff71282756afb352e74ca33509a00573225812253e94a04c";

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ethereum ethereum = EthereumFactory.createEthereum();
        Account account;
        Repository repository = ethereum.getRepository();
        log.info("Welcome to Ethereum POC!");
        String version = null;
        Web3j web3 = null;
        try {
            web3 = Web3j.build(new HttpService());
            version = Web3JUtils.getVersion(web3);
        } catch (InterruptedException | ExecutionException ex) {
            log.error(ex);
        }
        log.info("version: " + version);
        if (version != null) {  
            
            
            

            ECKey key = new ECKey();

            byte[] addr = key.getAddress();
            byte[] priv = key.getPrivKeyBytes();
//
            String addrBase16 = Hex.toHexString(addr);
            String privBase16 = Hex.toHexString(priv);

            System.out.println("Address     : " + addrBase16);
            System.out.println("Private Key : " + privBase16);

        }
    }

}
