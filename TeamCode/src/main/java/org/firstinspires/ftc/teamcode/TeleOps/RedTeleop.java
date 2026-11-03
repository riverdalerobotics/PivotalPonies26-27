package org.firstinspires.ftc.teamcode.TeleOps;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Commands.DefaultDrive;
import org.firstinspires.ftc.teamcode.MatchInfo;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.pedro.Constants;

@TeleOp(name = "Red Teleop", group = "Teleop")
public class RedTeleop extends CommandOpMode {
    Chassis chassis;
    Follower follower;
    MatchInfo matchInfo = new MatchInfo("red");

    @Override
    public void initialize() {
        follower = Constants.create(hardwareMap);
        chassis = new Chassis(hardwareMap, follower);
        chassis.setDefaultCommand(new DefaultDrive(chassis, gamepad1));
    }

    @Override
    public void preRun() {
        matchInfo.startTimer();
    }

    @Override
    public void run() {
        super.run();
        telemetry.addData("Time", matchInfo.getTimeElapsed());
        telemetry.update();

        if (gamepad1.xWasPressed()) {
            chassis.reset_gyro();
        }

//        if (follower != null) {
//            follower.update();
//        }
    }
}
