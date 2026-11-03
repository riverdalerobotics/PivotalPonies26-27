package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.hardware.servos.ServoEx;
import org.firstinspires.ftc.teamcode.Constants.TurretConstants;

public class Turret extends SubsystemBase {
    private final ServoEx azimuthLeft, azimuthRight; // Five turn servo
    private final ServoEx sizeAdjust, hood;
    private final MotorEx shooterLeft, shooterRight;

    public Turret(HardwareMap hardwareMap) {
        azimuthLeft = new ServoEx(hardwareMap, "azimuthLeft", 1800);
        azimuthRight = new ServoEx(hardwareMap, "azimuthRight", 1800);
        sizeAdjust = new ServoEx(hardwareMap, "sizeAdjust");
        hood = new ServoEx(hardwareMap, "hood");
        shooterRight = new MotorEx(hardwareMap, "shooterRight");
        shooterLeft = new MotorEx(hardwareMap, "shooterLeft");
    }

    public void setServoDegrees(double degrees) {
        azimuthLeft.set(degrees);
        azimuthRight.set(degrees);
    }

    public void setAzimuthPosition(double angle) {
        azimuthLeft.set(angle*TurretConstants.AZIMUTH_GEAR_RATIO);
        azimuthRight.set(angle*TurretConstants.AZIMUTH_GEAR_RATIO);
    }
}