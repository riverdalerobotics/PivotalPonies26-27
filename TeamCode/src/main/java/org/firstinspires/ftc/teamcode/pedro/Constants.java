package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.Encoder;
import com.pedropathing.revhub.localizers.RevHubIMU;
import com.pedropathing.revhub.localizers.TwoWheelConfig;
import com.pedropathing.revhub.localizers.TwoWheelLocalizer;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("frontLeft");
        c.frontRightName.set("frontRight");
        c.backLeftName.set("backLeft");
        c.backRightName.set("backRight");
        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });

    public static TwoWheelConfig localizerConfig = new TwoWheelConfig(c -> {
        c.xPodName.set("parEncoder");
        c.yPodName.set("perpEncoder");
        c.imuName.set("imu");
        c.xPodOffset.set(4.509876709543166);
        c.yPodOffset.set(6.300322654420435);
        c.forwardTicksToInches.set(0.0019712106488078236);
        c.strafeTicksToInches.set(0.0027842952896791422);
        c.xPodDirection.set(Encoder.FORWARD);
        c.yPodDirection.set(Encoder.FORWARD);
        c.imu.set(new RevHubIMU(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.BACKWARD,
                RevHubOrientationOnRobot.UsbFacingDirection.UP
        )));
    });

    public static ForesightConfig foresightConfig = new ForesightConfig(c -> {
        // Tuned default gains for stable heading holding and path tracking
        c.headingFeedback.set(Controller.proportional(2.0));
        c.forwardTranslational.set(Controller.proportional(0.8));
        c.strafeTranslational.set(Controller.proportional(0.8));
        c.brake.set(Controller.proportionalFeedforward(0.05));
        c.coast.set(Controller.proportionalFeedforward(0.05));
        c.linearBrakeCoefficients.set(Matrix.diag(0.5, 0.5));
        c.quadraticBrakeCoefficients.set(Matrix.diag(0.05, 0.05));
        c.headingBrakeCoefficients.set(Vector2D.cartesian(0.1, 0.01));
        c.maxAchievableForwardVelocity.set(50.0);
        c.maxAchievableStrafeVelocity.set(50.0);
        c.naturalForwardDeceleration.set(50.0);
        c.naturalStrafeDeceleration.set(50.0);
    });

    public static Follower create(HardwareMap h) {
        return new Follower(
                new TwoWheelLocalizer(h, localizerConfig),
                new Mecanum(h, drivetrainConfig),
                new Foresight(foresightConfig)
        );
    }
}
