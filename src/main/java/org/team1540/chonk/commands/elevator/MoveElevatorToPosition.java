package org.team1540.chonk.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.chonk.Robot;
import org.team1540.chonk.Tuning;

public class MoveElevatorToPosition extends Command {

    private double position;

    public MoveElevatorToPosition(double position) {
        requires(Robot.elevator);
        this.position = position;
    }

    @Override
    protected void initialize() {
        System.out.println("Moving elevator to position " + position);
        Robot.elevator.setPosition(position);
    }

    @Override
    protected void execute() {
//        System.out.println("Error: " + Math.abs(Robot.elevator.getPosition() - position));
    }

    @Override
    protected void end() {
        System.out.println("Elevator movement to position " + position + " finished");
    }

    @Override
    protected boolean isFinished() {
        return Math.abs(Robot.elevator.getPosition() - position) <= Tuning.ELEVATOR_POSITION_TOLERANCE;
    }
}
