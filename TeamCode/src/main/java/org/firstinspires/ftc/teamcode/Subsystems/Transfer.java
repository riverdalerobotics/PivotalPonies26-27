package org.firstinspires.ftc.teamcode.Subsystems;

import com.seattlesolvers.solverslib.hardware.SensorColor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

public class Transfer {
    private SensorColor colorSensor;
    private MotorEx motor;

    public Transfer(SensorColor colorSensor, MotorEx motor) {
        this.colorSensor = colorSensor;
        this.motor = motor;
    }

    public double getColorDist(int[] color1, int[] color2) {
        double dist = 0;
        for (int i = 0; i < color1.length; i++) {
            dist += Math.pow(color1[i] - color2[i], 2);
        }
        return dist;
    }

    public void getCurrentColor() {
        int[] colors = colorSensor.getARGB();
    }
}
