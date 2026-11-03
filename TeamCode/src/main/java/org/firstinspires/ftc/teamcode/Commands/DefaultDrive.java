package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.seattlesolvers.solverslib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Chassis;

public class DefaultDrive extends CommandBase {

    Chassis m_chassis;
    Gamepad m_gamepad;

    public DefaultDrive(Chassis chassis, Gamepad gamepad) {
        m_chassis = chassis;
        m_gamepad = gamepad;
        addRequirements(chassis);
    }

    @Override
    public void execute() {
        m_chassis.driveFieldCentric(m_gamepad.left_stick_x, m_gamepad.left_stick_y, m_gamepad.right_stick_x, Chassis.get_yaw());
    }
}
