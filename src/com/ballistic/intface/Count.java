package com.ballistic.intface;

/**
 * Created by Nabeel on 12/27/2017.
 */
// Functional Interfaces is an interface with only one abstract method inside.
@FunctionalInterface
public interface Count {

    public double pay(double amount);

    static Count creditCardPayment(int serviceCharge, int creditCardFee){
        return (double amount) -> amount + serviceCharge + creditCardFee;
    }

    static Count cashPayment(int serviceCharge){
        return amount -> amount + serviceCharge;
    }
}
