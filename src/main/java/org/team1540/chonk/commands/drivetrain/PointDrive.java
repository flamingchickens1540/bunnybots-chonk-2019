package org.team1540.chonk.commands.drivetrain;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.OI;
import org.team1540.chonk.Robot;
import org.team1540.chonk.Tuning;
import org.team1540.rooster.Utilities;

import static org.team1540.chonk.utils.SignedAngleError.signedAngleError;

public class PointDrive extends PIDCommand {

    private double lastError;
    private double integralAccumulator;
    private double lastAngle;

    public PointDrive() {
        super(Tuning.POINT_DRIVE_P, Tuning.POINT_DRIVE_I, Tuning.POINT_DRIVE_D);
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        System.out.println("Starting Point Drive");
        Tuning.POINT_DRIVE_P = SmartDashboard.getNumber("drive/pointp", Tuning.POINT_DRIVE_P);
        Tuning.POINT_DRIVE_I = SmartDashboard.getNumber("drive/pointi", Tuning.POINT_DRIVE_I);
        Tuning.POINT_DRIVE_D = SmartDashboard.getNumber("drive/pointd", Tuning.POINT_DRIVE_D);
        getPIDController().setPID(Tuning.POINT_DRIVE_P, Tuning.POINT_DRIVE_I, Tuning.POINT_DRIVE_D);
    }

    @Override
    protected double returnPIDInput() {
        double destAngle = -Math.atan2(OI.getJoystick(OI.driver, GenericHID.Hand.kRight, OI.Axis.Y),
            OI.getJoystick(OI.driver, GenericHID.Hand.kRight, OI.Axis.X)) - (Math.PI / 2);
        if ((Utilities
            .processDeadzone(OI.getJoystick(OI.driver, GenericHID.Hand.kRight, OI.Axis.X), .5) == 0)
            && (Utilities
            .processDeadzone(OI.getJoystick(OI.driver, GenericHID.Hand.kRight, OI.Axis.Y), .5)
            == 0)) {
            destAngle = lastAngle;
//            Hardware.leds.set(RevBlinken.ColorPattern.RED);
        } else {
//            Hardware.leds.set(RevBlinken.ColorPattern.GREEN);
        }
        lastAngle = destAngle;
        double currentAngle = Math.toRadians(Hardware.navx.getYaw());
        double error = signedAngleError(destAngle, currentAngle);
        return error;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void usePIDOutput(double output) {
        double leftY = OI.getJoystick(OI.driver, GenericHID.Hand.kLeft, OI.Axis.Y);
        Robot.driveTrain.setThrottle(-output + leftY, output + leftY);
    }
}
