/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class WristAutoCommand extends Command {
  double runTime;
  double power;
  public final Timer m_timer = new Timer();

  public WristAutoCommand(double time, double speed) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires (Robot.wristSubsystem);
    runTime = time;
    power = speed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.wristSubsystem.moveWrist(power);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return m_timer.get() > runTime;
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
