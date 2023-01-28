// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Utilities;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/** Add your docs here. */
public class Axis extends Trigger {
    public Axis whenHeld(final Command command, Boolean interrutible){
        whileActiveContinuous(command, interrutible);
        return this;
    }
    public Axis whenHeld(final Command command){
        whileActiveContinuous(command);
        return this;
    }
    public Axis whenReleased(final Command command, boolean interruptible){
        whenReleased(command, interruptible);
        return this;
    }
    public Axis whenReleased(final Command command){
        whenReleased(command);
        return this;
    }

}
