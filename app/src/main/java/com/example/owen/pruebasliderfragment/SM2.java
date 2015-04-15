package com.example.owen.pruebasliderfragment;

/**
 * Created by Owen on 15/04/2015.
 */

/**
 * SM2 spaced repetition algorithm implementation.
 *
 * @author Andrei Matveyeu
 * see supermemo SM2 algorithm implementation by Dr. P. Wozniak: http://www.supermemo.com/english/ol/sm2.htm
 */


public class SM2 {

    double eFactor;
    int qualityResponse;

    public SM2() {
        eFactor = 2.5f;
        qualityResponse = 0;
    }

    public SM2(double ef, int qr) {
        eFactor = ef;
        qualityResponse = qr;
    }

    /**
     * Get new interval
     * @param n
     * @return
     */
    public int getNextInterval(int n) {
        if (n==1) {
            return 1;
        }
        else if (n==2) {
            return 6;
        }
        else if (n>2) {
            return (int) ((n-1)*eFactor);
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
