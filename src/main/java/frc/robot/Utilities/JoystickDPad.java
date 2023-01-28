// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Utilities;

import edu.wpi.first.wpilibj.GenericHID;

/** Add your docs here. */
public class JoystickDPad extends Dpad {
    private final GenericHID m_joystick;
    private final int m_dpadangle;
    public JoystickDPad (GenericHID joystick, int dpadangle){
        m_joystick = joystick;
        m_dpadangle = dpadangle;
    }
    public int getPOV(){
        return m_joystick.getPOV();
    }

    @Override
    public boolean get(){
        return(getPOV()==m_dpadangle);
    }
}
