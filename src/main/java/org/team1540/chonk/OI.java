package org.team1540.chonk;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.team1540.chonk.commands.arm.JoystickArmControl;
import org.team1540.chonk.commands.arm.MoveArmToPosition;
import org.team1540.chonk.commands.bunnyarm.GrabBunnies;
import org.team1540.chonk.commands.bunnyarm.OpenBunnyDoor;
import org.team1540.chonk.commands.claw.CloseClaw;
import org.team1540.chonk.commands.claw.GrabBinSequence;
import org.team1540.chonk.commands.claw.OpenClaw;
import org.team1540.chonk.commands.drivetrain.MoveForwardLineUp;
import org.team1540.rooster.Utilities;
import org.team1540.rooster.triggers.AxisButton;
import org.team1540.rooster.triggers.DPadAxis;
import org.team1540.rooster.triggers.DPadButton;
import org.team1540.rooster.util.SimpleCommand;

public class OI {
    //driver
    public static XboxController driver = new XboxController(0);

    public static Button driverAButton = new JoystickButton(driver, 1);
    public static Button driverBButton = new JoystickButton(driver, 2);
    public static Button driverXButton = new JoystickButton(driver, 3);
    public static Button driverYButton = new JoystickButton(driver, 4);

    public static Button driverRB = new JoystickButton(driver, 6);
    public static Button driverLB = new JoystickButton(driver, 5);

    public static Button driverBackButton = new JoystickButton(driver, 7);
    public static Button driverStartButton = new JoystickButton(driver, 8);

    public static Button driverRightJoystickButton = new JoystickButton(driver, 10);
    public static Button driverLeftJoystickButton = new JoystickButton(driver, 9);

    public static Button driverDpadUp = new DPadButton(driver, 0, DPadAxis.UP);
    public static Button driverDpadDown = new DPadButton(driver, 0, DPadAxis.DOWN);
    public static Button driverDpadLeft = new DPadButton(driver, 0, DPadAxis.LEFT);
    public static Button driverDpadRight = new DPadButton(driver, 0, DPadAxis.RIGHT);

    public static AxisButton driverLeftTriggerMoved = new AxisButton(driver, 0.2, 2);
    public static AxisButton driverRightTriggerMoved = new AxisButton(driver, 0.2, 3);
    //copilot
    public static XboxController copilot = new XboxController(1);

    public static Button copilotAButton = new JoystickButton(copilot, 1);
    public static Button copilotBButton = new JoystickButton(copilot, 2);
    public static Button copilotXButton = new JoystickButton(copilot, 3);
    public static Button copilotYButton = new JoystickButton(copilot, 4);

    public static Button copilotRB = new JoystickButton(copilot, 6);
    public static Button copilotLB = new JoystickButton(copilot, 5);

    public static AxisButton copilotLeftTriggerPressed = new AxisButton(copilot, 0.5, 2);
    public static AxisButton copilotRightTriggerPressed = new AxisButton(copilot, 0.5, 3);

    public static Button copilotBackButton = new JoystickButton(copilot, 7);
    public static Button copilotStartButton = new JoystickButton(copilot, 8);

    public static Button copilotRightJoystickButton = new JoystickButton(copilot, 10);
    public static Button copilotLeftJoystickButton = new JoystickButton(copilot, 9);

    public static Button copilotDpadUp = new DPadButton(copilot, 0, DPadAxis.UP);
    public static Button copilotDpadDown = new DPadButton(copilot, 0, DPadAxis.DOWN);
    public static Button copilotDpadLeft = new DPadButton(copilot, 0, DPadAxis.LEFT);
    public static Button copilotDpadRight = new DPadButton(copilot, 0, DPadAxis.RIGHT);

    public static AxisButton copilotLeftJoystickMovedPositiveY = new AxisButton(copilot, 0.2, 1);
    public static AxisButton copilotLeftJoystickMovedNegativeY = new AxisButton(copilot, -0.2, 1);


    public enum Axis {
        X,
        Y;
    }

    public static double getJoystick(XboxController controller, GenericHID.Hand hand, Axis axis) {
        if (axis == Axis.X) {
            return Utilities.processDeadzone(controller.getX(hand), .1);
        } else {
            return -Utilities.processDeadzone(controller.getY(hand), .1);
        }
    }

    public static double getTriggerThrottle(XboxController controller) {
        return Utilities.scale(Utilities.processDeadzone(
            controller.getTriggerAxis(GenericHID.Hand.kRight) - controller
                .getTriggerAxis(GenericHID.Hand.kLeft), .1), 2);
    }


    public static boolean getBinOverrideButtonPressed() {
        return copilotBButton.get();
    }

    public static boolean getArmSafetyOverride() {
        return driverRB.get();
    }

    //bindings
    public static void init() {
        System.out.println("Initializing OI...");

        copilotRB.whenPressed(new CloseClaw());
        copilotRightTriggerPressed.whenPressed(new OpenClaw());
        copilotLeftJoystickMovedPositiveY.whileHeld(new JoystickArmControl());
        copilotLeftJoystickMovedNegativeY.whileHeld(new JoystickArmControl());
        driverLeftTriggerMoved.whileHeld(new JoystickArmControl());
        driverRightTriggerMoved.whileHeld(new JoystickArmControl());
        copilotXButton.whenPressed(new GrabBinSequence());
        copilotDpadUp.whenPressed(new MoveArmToPosition(Tuning.ARM_DUMP_POSITION));
        copilotDpadDown.whenPressed(new MoveArmToPosition(Tuning.ARM_BIN_POSITION));
        SimpleCommand zeroNavX = new SimpleCommand("ZeroNavX", Hardware.navx::zeroYaw);
        zeroNavX.setRunWhenDisabled(true);
        driverYButton.whenPressed(zeroNavX);
//        copilotDpadDown.whenPressed(new BunnyArmDown());
//        copilotDpadUp.whenPressed(new BunnyArmUp());
        copilotAButton.whenPressed(new OpenBunnyDoor());
        copilotYButton.whenPressed(new GrabBunnies());
        driverAButton.whileHeld(new MoveForwardLineUp(315_000));
    }
}
