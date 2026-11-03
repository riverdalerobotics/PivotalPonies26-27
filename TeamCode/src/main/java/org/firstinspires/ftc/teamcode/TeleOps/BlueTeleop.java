package org.firstinspires.ftc.teamcode.TeleOps;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.MatchInfo;
import org.firstinspires.ftc.teamcode.Subsystems.Chassis;

@TeleOp(name = "Blue Teleop")
public class BlueTeleop extends CommandOpMode {
    Chassis chassis;
    MatchInfo matchInfo;

    @Override
    public void initialize() {

    }

    @Override
    public void preRun() {
        matchInfo.startTimer();
    }
}
