// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import frc.robot.subsystems.DrivebaseG;

import frc.robot.Constants;
import frc.robot.Controls;


import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class XboxMove extends CommandBase {

  private final DrivebaseG driveBase = new DrivebaseG();
  double Throttle; 
  boolean brake;
  boolean rotate; 
  boolean precision;  
  double turn;
  double reverse;
  double left;
  double right;
  /**   
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public XboxMove() {
    // Use addRequirements() here to declare subsystem dependencies.
    
    addRequirements(driveBase);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.print("Starting XboxMove");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Throttle = Controls.xboxAxis(Controls.driver, "RT").getAxis();
    reverse = Controls.xboxAxis(Controls.driver, "LT").getAxis();
    turn = Controls.xboxAxis(Controls.driver, "LS-X").getAxis();
    precision = Controls.xboxButton(Controls.driver, "RB").get();
    brake = Controls.xboxButton(Controls.driver, "LB").get();
    rotate = Controls.xboxAxis(Controls.driver, "LS").get();

    if(brake){
      left = 0;
      right = 0;
    }
    if(rotate){
      //If the joystick is pushed passed the threshold. 
    if(Math.abs(turn) > Constants.AXIS_THRESHOLD){
        //Sets it to spin the desired direction.
      left = Constants.SPIN_SENSITIVITY * turn;
      right = Constants.SPIN_SENSITIVITY * (turn * -1);
    }
      //If its not past the threshold stop spinning
    else if(Math.abs(turn) < Constants.AXIS_THRESHOLD){
      left = 0;
      right = 0;
    }
  }
  else{
    //Turning right
  if(turn > Constants.AXIS_THRESHOLD){
      //Makes left slow down by a factor of how far the axis is pushed. 
    left = (Throttle - reverse);
    right = (Throttle - reverse) * (1 - turn);
  }
    //Turning left
  else if(turn < (-1 * Constants.AXIS_THRESHOLD)){
      //Makes right speed up by a factor of how far the axis is pushed. 
    left = (Throttle - reverse) * (1 + turn);
    right = (Throttle - reverse);
  }
    //Driving straight 
  else{
      //No joystick manipulation. 
    left = (Throttle - reverse);
    right = (Throttle - reverse);
  }
  DrivebaseG.drive(left, right);
}
}



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DrivebaseG.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
