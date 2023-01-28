// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Utilities;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;

/** Add your docs here. */
public class JoystickAxis extends Trigger {
    private final GenericHID m_joystick;
    private final int m_axisnumber;
    public JoystickAxis(GenericHID joystick, int axisNumber){
        m_joystick = joystick;
        m_axisnumber = axisNumber;
    }
    public double getAxis(){
        return m_joystick.getRawAxis(m_axisnumber);
    }
    public boolean get(){
        return(getAxis()<-Constants.AXIS_THRESHOLD||getAxis()>Constants.AXIS_THRESHOLD);
    }
}
