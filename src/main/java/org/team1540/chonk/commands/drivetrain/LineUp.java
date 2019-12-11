package org.team1540.chonk.commands.drivetrain;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.Robot;

public class LineUp extends PIDCommand {

    public LineUp() {
        super(Hardware.getLimelightP(), Hardware.getLimelightI(), Hardware.getLimelightD());
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        System.out.println("Lining Up");
        setSetpoint(0);
        getPIDController().setPID(Hardware.getLimelightP(), Hardware.getLimelightI(), Hardware.getLimelightD());
    }

    @Override
    protected void execute() {}

    @Override
    protected double returnPIDInput() {
        return Hardware.limelight.getEntry("tx").getDouble(0);
    }

    @Override
    protected void usePIDOutput(double output) {
        Robot.driveTrain.setThrottle(-output, output);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
