package com.example.owen.pruebasliderfragment;

/**
 * Created by Owen on 15/04/2015.
 */

import java.util.Date;

/**
 * SM2 spaced repetition algorithm implementation.
 *
 * @author Andrei Matveyeu
 * see supermemo SM2 algorithm implementation by Dr. P. Wozniak: http://www.supermemo.com/english/ol/sm2.htm
 */


public class SM2 {

    double eFactor;
    int qualityResponse;
    private static int NUM_SEC_DAY = 86400;
    // valores de repeticion I(1) e I(2)
    private static int FIRST_REPEAT = 1;
    private static int SECOND_REPEAT = 6;

    public SM2() {
        eFactor = 2.5f;
        qualityResponse = 0;
    }

    public SM2(double ef, int qr) {
        eFactor = ef;
        qualityResponse = qr;
    }

    /**
     * Get new interval in epoch Unix format (seconds)
     * @param n
     * @return
     */
    public long getNextInterval(int n) {
        Date date = new Date();
        long epoch = date.getTime()/1000;
        if (n==1) {
            return epoch + (FIRST_REPEAT*NUM_SEC_DAY);
        }
        else if (n==2) {
            return epoch + (SECOND_REPEAT*NUM_SEC_DAY);
        }
        else if (n>2) {
            // I(n) = (I(2) * EF^(n-2))
            epoch += ((int) (SECOND_REPEAT*Math.pow(eFactor, n-2)))*NUM_SEC_DAY;
            return epoch;
        }
        else {
            return 0;
        }
    }


    public double getNewEFactor() {
        double newEFactor = eFactor +(0.1-(5-qualityResponse)*(0.08+(5-qualityResponse)*0.02));
        if (newEFactor < 1.3) newEFactor = 1.3;
        return newEFactor;
    }

}
