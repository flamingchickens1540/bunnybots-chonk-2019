package org.team1540.chonk.commands.drivetrain;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.team1540.chonk.OI;
import org.team1540.chonk.Robot;

public class ModifiedArcadeDrive extends Command {

    public ModifiedArcadeDrive() {
        requires(Robot.driveTrain);
    }

    private double positivePart(double input) {
        if (input <= 0) {
            return 0;
        } else {
            return input;
        }
    }
    private double negativePart(double input) {
        if (input >= 0) {
            return 0;
        } else {
            return input;
        }
    }

    @Override
    protected void initialize() {
        System.out.println("Starting Modified Arcade Drive");
    }

    @Override
    protected void execute() {
        double triggerThrottle = OI.getTriggerThrottle(OI.driver);
        double leftY = OI.getJoystick(OI.driver, GenericHID.Hand.kLeft, OI.Axis.Y);
        double rightX = OI.getJoystick(OI.driver, GenericHID.Hand.kRight, OI.Axis.X);
        double throttleLeft = leftY + (leftY * negativePart(rightX)) + triggerThrottle;
        double throttleRight = leftY - (leftY * positivePart(rightX)) - triggerThrottle;
        Robot.driveTrain.setThrottle(throttleLeft, throttleRight);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
