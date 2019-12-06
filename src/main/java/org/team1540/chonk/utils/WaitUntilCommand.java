package org.team1540.chonk.utils;

import edu.wpi.first.wpilibj.command.Command;

import java.util.function.BooleanSupplier;

public class WaitUntilCommand extends Command {

    private final BooleanSupplier isFinished;
    private final Runnable end;

    public WaitUntilCommand(BooleanSupplier isFinished, Runnable end) {
        this.isFinished = isFinished;
        this.end = end;
    }

    public WaitUntilCommand(BooleanSupplier isFinished) {
        this(isFinished, null);
    }

    @Override
    protected boolean isFinished() {
        return isFinished.getAsBoolean();
    }

    @Override
    protected void end() {
        if (end != null) {
            end.run();
        }
    }
}