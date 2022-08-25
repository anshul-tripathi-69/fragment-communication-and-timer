package com.example.fragmentcommunication;

public class DataBridge {
    private static DataBridge instance = null;
    private String timerDurationText;

    private DataBridge() {}

    public static DataBridge getInstance() {
        if (instance == null) {
            synchronized (DataBridge.class) {
                if (instance == null) {
                    instance = new DataBridge();
                }
            }
        }
        return instance;
    }

    public void setTimerDurationInBottomFragment() {

    }

    public String getTimerDurationText() {
        return timerDurationText;
    }

    public void setTimerDurationText(String timerDurationText) {
        this.timerDurationText = timerDurationText;
    }
}
