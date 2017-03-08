/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutionmafia.ethereumpoc.utils;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author tanujv
 */
public class DateUtils {

    public static String generateTimeStamp() {
        return new Timestamp(new Date().getTime()).toString();
    }
}
