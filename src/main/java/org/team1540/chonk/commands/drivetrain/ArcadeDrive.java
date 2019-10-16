package org.team1540.chonk.commands.drivetrain;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.team1540.chonk.OI;
import org.team1540.chonk.Robot;
import org.team1540.rooster.Utilities;

public class ArcadeDrive extends Command {

    public ArcadeDrive() {
        requires(Robot.drivetrain);
    }

    @Override
    protected void initialize() {
        System.out.println("Starting Arcade Drive");
    }

    @Override
    protected void execute() {
        double joystickY = Utilities.processDeadzone(OI.driver.getY(GenericHID.Hand.kRight), .1);
        double joystickX = Utilities.processDeadzone(OI.driver.getX(GenericHID.Hand.kRight), .1);
        double throttleRight = -(joystickX + joystickY);
        double throttleLeft  = -(joystickX - joystickY);
        Robot.drivetrain.setThrottle(throttleRight, throttleLeft);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
