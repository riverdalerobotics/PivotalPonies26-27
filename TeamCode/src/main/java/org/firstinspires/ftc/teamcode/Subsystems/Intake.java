package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.hardware.servos.ServoEx;
import org.firstinspires.ftc.teamcode.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
    private final ServoEx flowerLeft, flowerRight;
    private final MotorEx intake;

    public Intake(HardwareMap hardwareMap) {
        flowerLeft = new ServoEx(hardwareMap, "flowerLeft", 300);
        flowerRight = new ServoEx(hardwareMap, "flowerRight", 300);
        flowerRight.setInverted(true);
        intake = new MotorEx(hardwareMap, "intake");
    }

    public void setIntakeSpeed(double speed) { intake.set(speed); }

    public void spit() { setIntakeSpeed(-1); }

    public void lowerFlowerEmptier() {
        flowerLeft.set(IntakeConstants.FLOWER_EMPTIER_DOWN);
        flowerRight.set(IntakeConstants.FLOWER_EMPTIER_DOWN);
    }

    public void raiseFlowerEmptier() {
        flowerLeft.set(IntakeConstants.FLOWER_EMPTIER_UP);
        flowerRight.set(IntakeConstants.FLOWER_EMPTIER_UP);
    }
}
