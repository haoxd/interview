package com.bread.coalquality.mvc.controller.callback;

public class EventNotifier {




    public void doWork(String a, String b, InterestingEvent event) {

        String ac = a + b;

        event.interestingEvent(ac);

    }

}