package com.ballistic.constant;

/**
 * Created by Nabeel on 12/26/2017.
 */
public enum Singleton {

//    UPDATE suppliers SET broker =
//        CASE
//            WHEN type = 'WHOLE' THEN 'Broker A'
//            WHEN type = 'VENDOR' THEN 'Broker B'
//        ELSE
//            'null'
//    END

    INSTANCE;

    private int count;

    public void setCount(int count) {
        this.count = count;
    }
    public void doProcess() {
        System.out.println("Do high memory or CPU consume operation. count :- " + this.count++);
    }
}
