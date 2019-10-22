package org.team1540.chonk.commands.drivetrain;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.OI;
import org.team1540.chonk.Robot;
import org.team1540.chonk.Tuning;
import org.team1540.rooster.Utilities;

public class PointDrive extends Command {

    private double lastError;
    private double integralAccumulator;

    public PointDrive() {
        requires(Robot.drivetrain);
    }

    private static double signedAngleError(double target, double source) {
        double diff = (target - source + Math.PI) % (Math.PI * 2) - Math.PI;
        return diff < -Math.PI ? diff + (Math.PI * 2) : diff;
    }

    @Override
    protected void initialize() {
        System.out.println("Starting Point Drive");
        Tuning.POINT_DRIVE_P = SmartDashboard.getNumber("drive/pointp", Tuning.POINT_DRIVE_P);
        Tuning.POINT_DRIVE_I = SmartDashboard.getNumber("drive/pointi", Tuning.POINT_DRIVE_I);
        Tuning.POINT_DRIVE_D = SmartDashboard.getNumber("drive/pointd", Tuning.POINT_DRIVE_D);

    }

    @Override
    protected void execute() {
        double destAngle = -Math.atan2(OI.getJoystick(GenericHID.Hand.kRight, OI.Axis.Y), OI.getJoystick(GenericHID.Hand.kRight, OI.Axis.X)) + (Math.PI / 2);
        double currentAngle = -Math.toRadians(Hardware.navx.getAngle());
        double error = signedAngleError(destAngle, currentAngle);
        double output = error * Tuning.POINT_DRIVE_P;
        integralAccumulator += error;
        output += integralAccumulator * Tuning.POINT_DRIVE_I;
        output += (error - lastError) * Tuning.POINT_DRIVE_D;
        lastError = error;
        double leftY = OI.getJoystick(GenericHID.Hand.kLeft, OI.Axis.Y);
        Robot.drivetrain.setThrottle(output + leftY, -output + leftY);
        SmartDashboard.putNumber("drive/dest", destAngle);
        SmartDashboard.putNumber("drive/current", currentAngle);
        SmartDashboard.putNumber("drive/signedangleerror", error);
        SmartDashboard.putNumber("drive/error", error);
        SmartDashboard.putNumber("drive/output", output);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
