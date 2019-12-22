package org.team1540.chonk.commands.drivetrain;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.Robot;
import org.team1540.chonk.Tuning;

public class MoveForwardLineUp extends PIDCommand  {

    private double maxDistance;
    private double startingRadians;

    public MoveForwardLineUp(double maxDistance) {
        super(Hardware.getLimelightP(), Hardware.getLimelightI(), Hardware.getLimelightD());
        requires(Robot.driveTrain);
        this.maxDistance = maxDistance;
    }

    @Override
    protected void initialize() {
        System.out.println("Starting MoveForwardLineUp");
        double startingRadians = -Math.toRadians(Hardware.navx.getYaw());
        setSetpoint(0);
        Hardware.driveLeftA.setSelectedSensorPosition(0);
        Hardware.driveRightA.setSelectedSensorPosition(0);
    }

    @Override
    protected void end() {
        System.out.println("Finished MoveForwardLineUp");
        Robot.driveTrain.setThrottle(0, 0);
    }

    @Override
    protected double returnPIDInput() {
//        double forwardError = signedAngleError(startingRadians, -Math.toRadians(Hardware.navx.getYaw()));
//        double limelightError = Math.toRadians(Hardware.limelight.getEntry("tx").getDouble(0));
        return Hardware.limelight.getEntry("tx").getDouble(0);
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.driveTrain
            .setThrottle(-output + Tuning.AUTO_FWD_SPEED, output + Tuning.AUTO_FWD_SPEED);
    }

    @Override
    protected boolean isFinished() {
        if (Hardware.driveRightA.getSelectedSensorPosition() >= maxDistance) {
            System.out.println("Finished MoveForwardLineUp because over max distance");
            return true;
        }
//        double bottomAngle = 90 - Hardware.limelight.getEntry("ty").getDouble(0);
//        double dist = Math.tan(bottomAngle) * Tuning.LIMELIGHT_HEIGHT;
        return Hardware.limelight.getEntry("ty").getDouble(0) < -12.5;
//        return Hardware.frontUltrasonic.getVoltage() < Tuning.FRONT_ULTRASONIC_BIN_DISTANCE;
    }
}
