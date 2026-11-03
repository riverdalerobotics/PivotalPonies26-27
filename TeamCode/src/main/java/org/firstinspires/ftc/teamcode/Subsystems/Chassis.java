package org.firstinspires.ftc.teamcode.Subsystems;

import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.IMU;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.drivebase.MecanumDrive;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Chassis extends SubsystemBase {

    private final MecanumDrive drive;
    private final Follower m_follower;
    HardwareMap hardwareMap;
    private static IMU imu;

    public Chassis(HardwareMap hardwareMap, Follower follower) {
        this.hardwareMap = hardwareMap;
        MotorEx frontLeft = new MotorEx(hardwareMap, "frontLeft", Motor.GoBILDA.RPM_312);
        MotorEx frontRight = new MotorEx(hardwareMap, "frontRight", Motor.GoBILDA.RPM_312);
        MotorEx backLeft = new MotorEx(hardwareMap, "backLeft", Motor.GoBILDA.RPM_312);
        MotorEx backRight = new MotorEx(hardwareMap, "backRight", Motor.GoBILDA.RPM_312);
        IMU.Parameters myIMUparameters;

        myIMUparameters = new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.BACKWARD,
                        RevHubOrientationOnRobot.UsbFacingDirection.UP
                )
        );

        imu = hardwareMap.get(IMU.class, "imu");
        imu.initialize(myIMUparameters);

        drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
        m_follower = follower;
    }

    public void driveRobotCentric(double strafe, double forward, double turn) {
        drive.driveRobotCentric(-strafe, forward, -turn);
    }

    public void driveFieldCentric(double strafe, double forward, double turn, double gyro) {
        drive.driveFieldCentric(-strafe, forward, -turn, gyro);
    }

    public static double get_yaw() {
        return imu.getRobotYawPitchRollAngles().getYaw();
    }

    public void reset_gyro() {
        imu.resetYaw();
    }

    public Pose get_position() {
        return m_follower.pose();
    }

}
