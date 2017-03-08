/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutionmafia.ethereumpoc.utils;

import com.solutionmafia.ethereumpoc.models.MyModel;
import org.ethereum.crypto.ECKey;
import org.ethereum.crypto.HashUtil;
import org.spongycastle.util.encoders.Hex;

/**
 *
 * @author tanujv
 */
public class EthereumUtils {

    
    
    public static MyModel createAccount(String password) {
        byte[] passwordBytes = HashUtil.sha3(password.getBytes());
        ECKey key = ECKey.fromPrivate(passwordBytes);

        byte[] addr = key.getAddress();
        byte[] priv = key.getPrivKeyBytes();

        String addrBase16 = Hex.toHexString(addr);
        String privBase16 = Hex.toHexString(priv);

        return new MyModel(addrBase16, privBase16);
    }
}
