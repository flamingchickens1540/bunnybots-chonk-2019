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
    protected void execute() {
        double throttleRight = -(Utilities.processDeadzone(OI.driver.getY(GenericHID.Hand.kRight), .1) + Utilities.processDeadzone(OI.driver.getX(GenericHID.Hand.kRight), .1));
        double throttleLeft  = -(Utilities.processDeadzone(OI.driver.getX(GenericHID.Hand.kRight), .1) - Utilities.processDeadzone(OI.driver.getY(GenericHID.Hand.kRight), .1));
        Robot.drivetrain.setThrottle(throttleRight, throttleLeft);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
