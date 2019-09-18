package org.team1540.chonk;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

    @Override
    public void robotInit() {
        Hardware.initAll();
    }

    @Override
    public void teleopPeriodic() {

    }
}
