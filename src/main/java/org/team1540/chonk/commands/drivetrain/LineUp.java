package org.team1540.chonk.commands.drivetrain;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.team1540.chonk.Hardware;

public class LineUp extends PIDCommand {

    public LineUp() {
        super(Hardware.getLimelightP(), Hardware.getLimelightI(), Hardware.getLimelightD());
    }

    @Override
    protected void initialize() {
        System.out.println("Lining Up");
    }

    @Override
    protected void execute() {
        double offsetX = Hardware.limelight.getEntry("tx").getDouble(0);

    }

    @Override
    protected double returnPIDInput() {
        return 0;
    }

    @Override
    protected void usePIDOutput(double output) {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
