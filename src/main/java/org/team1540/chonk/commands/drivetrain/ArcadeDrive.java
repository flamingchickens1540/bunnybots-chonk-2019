package org.team1540.chonk.commands.drivetrain;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.team1540.chonk.OI;
import org.team1540.chonk.Robot;

public class ArcadeDrive extends Command {

    public ArcadeDrive() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        System.out.println("Starting Arcade Drive");
    }

    @Override
    protected void execute() {
        double rightX = OI.getJoystick(OI.driver, GenericHID.Hand.kRight, OI.Axis.X);
        double rightY = OI.getJoystick(OI.driver, GenericHID.Hand.kRight, OI.Axis.Y);
        double throttleLeft  = rightY + rightX;
        double throttleRight = rightY - rightX;
        Robot.driveTrain.setThrottle(throttleLeft, throttleRight);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
