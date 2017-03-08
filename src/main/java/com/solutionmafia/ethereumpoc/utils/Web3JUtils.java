/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutionmafia.ethereumpoc.utils;

import java.util.concurrent.ExecutionException;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

/**
 *
 * @author tanujv
 */
public class Web3JUtils {

    
    
    public static String getVersion(org.web3j.protocol.Web3j web3) throws InterruptedException,
            ExecutionException {
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        return clientVersion;
    }
}
