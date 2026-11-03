package org.firstinspires.ftc.teamcode.Commands;

import com.pedropathing.math.Pose;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Chassis;
import org.firstinspires.ftc.teamcode.Subsystems.Turret;

public class PointToTarget extends CommandBase {

    Chassis m_chassis;

    public PointToTarget(Chassis chassis, Turret turret) {
        m_chassis = chassis;
        addRequirements(turret); // Chassis is just required for localization
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        Pose robotPose = m_chassis.get_position();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
