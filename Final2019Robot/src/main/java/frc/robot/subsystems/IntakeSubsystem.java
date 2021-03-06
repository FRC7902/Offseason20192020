/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/



//Imports all the library necessary
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
  

public class IntakeSubsystem extends Subsystem {
  
  //Create Motors
  public WPI_VictorSPX topMotor = new WPI_VictorSPX(RobotMap.intakeTop);
  public WPI_VictorSPX bottomMotor = new WPI_VictorSPX(RobotMap.intakeBottom);

  public IntakeSubsystem(){

    //Invert Motors
    topMotor.setInverted(false);
    bottomMotor.setInverted(true);
  }

  public void moveIntakeJoystick(Joystick joystick, double inSpeed, double outSpeed){//moves the intake in and out
    boolean trig1 = joystick.getRawButton(RobotMap.RB);
    boolean trig2 = joystick.getRawButton(RobotMap.RB);
    if(trig1 && !trig2){//if only right
      topMotor.set(inSpeed);
      bottomMotor.set(inSpeed);
    }else if(trig2 && !trig1){//if only left
      topMotor.set(outSpeed);
      bottomMotor.set(outSpeed);
    }else{
      topMotor.set(0);
      bottomMotor.set(0);
    }

  }

  public void displayInfo(){
    SmartDashboard.putNumber("Intake Output", topMotor.get());
  }

  public void moveIntake(double speed){
    topMotor.set(speed);
    bottomMotor.set(speed);
  }

  public void stopIntake(){//stops the intake
    topMotor.stopMotor();
    bottomMotor.stopMotor();
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
