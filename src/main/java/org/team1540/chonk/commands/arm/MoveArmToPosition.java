package org.team1540.chonk.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.chonk.Robot;
import org.team1540.chonk.Tuning;

public class MoveArmToPosition extends Command {

    private double position;

    public MoveArmToPosition(double position) {
        requires(Robot.arm);
        this.position = position;
    }

    @Override
    protected void initialize() {
        System.out.println("Moving Arm");
    }

    @Override
    protected void execute() {
        Robot.arm.setPosition(position);
    }

    @Override
    protected boolean isFinished() {
        System.out.println("Running isFinished");
        return (Math.abs(Robot.arm.getPosition() - position) <= Tuning.ARM_POSITION_TOLERANCE);
    }
}
