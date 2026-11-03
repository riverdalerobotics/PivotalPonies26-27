package org.firstinspires.ftc.teamcode;

public class MatchInfo {

    String color;
    long startTime = 0;


    public MatchInfo(String color) {
        this.color = color;
    }

    public void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public double getTimeElapsed() {
        return (double) (System.currentTimeMillis() - startTime)/1000;
    }

    public boolean isEndgame() {
        return getTimeElapsed() > 60;
    }

}
