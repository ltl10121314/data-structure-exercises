package com.exercises.hook;

public class HookDemo {
    public static void main(String[] args) {
        EventHook customHook = new CustomHook();
        MyEvent myEvent = new MyEvent(customHook);
        myEvent.trigger();
    }
}