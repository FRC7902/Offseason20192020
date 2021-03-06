/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class WristJoystick extends Command {
  public WristJoystick() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.wristSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.wristSubsystem.displayInfo();

    if(Robot.m_oi.getDriverStick().getRawButton(RobotMap.S)){// Start Button
      Robot.wristSubsystem.resetPos();
    }
    if(Robot.m_oi.getDriverStick().getRawButton(RobotMap.A)){//A button
      //Robot.wristSubsystem.detectPresetButton();//constantly detect if button is pressed
      Robot.wristSubsystem.setWristPositionPID(RobotMap.wristCargoPos);//for cargo
    }else{
      Robot.wristSubsystem.moveWrist((Robot.m_oi.getDriverStick().getRawAxis(3)-Robot.m_oi.getDriverStick().getRawAxis(2))*RobotMap.wristSpeed+ Robot.wristSubsystem.counterGrav(RobotMap.wristGrav));
    } 
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.wristSubsystem.stopWrist();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
