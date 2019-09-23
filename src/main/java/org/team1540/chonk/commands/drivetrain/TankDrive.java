package org.team1540.chonk.commands.drivetrain;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.team1540.chonk.OI;
import org.team1540.chonk.Robot;
import org.team1540.rooster.Utilities;

public class TankDrive extends Command {

    public TankDrive() {
        requires(Robot.drivetrain);
    }

    @Override
    protected void execute() {
        Robot.drivetrain.setThrottle(Utilities.processDeadzone(OI.driver.getY(GenericHID.Hand.kLeft), .1), Utilities.processDeadzone(OI.driver.getY(GenericHID.Hand.kLeft), .1));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
