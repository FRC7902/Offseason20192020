/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {
 
  //CAN IDs for motor controller outputs
  //Drive motors
  public static final int frontRight = 1;
  public static final int backRight = 2;
  public static final int frontLeft = 3;
  public static final int backLeft = 4;

  //wrist motors
  public static final int wristMotor = 5;
  public static final int wristMotor2 = 6;

  //intake motors
  public static final int intakeTop = 7;
  public static final int intakeBottom = 8;

  //Solenoid Valves (PCM Port Values)
  public static final int frontValve = 0;
  public static final int backValve = 1;

  //Magnetic Switch
  // Check Values
  public static final int magSwitch = 9;
  
  //COMMAND CENTER

  //Drive

  public static final double driveSpeedLimiter = 0.6;

  public static final double driveFBSpeed = 1;
  public static final double driveTurnSpeed = 0.75;

  public static final int driveMicroFBButton = 9;
  public static final int driveMicroTurnButton = 10;

  //Wrist

  public static final int wristCargoPos = -650;
  public static final double wristCargoMult = 0.3;
  public static final double wristCargoGrav = 0.041;

  public static final int wristHatchPos = -100;
  public static final double wristHatchMult = 0.3;
  public static final double wristHatchGrav = 0.041;

  public static final double wristSpeed = 0.5;
  public static final double wristGrav = 0.0002;

  // Triple check whether maps are correct
  // Joystick - Button
  public static final int A = 1,
                          B = 2,
                          X = 3,
                          Y = 4,
                          LB = 5, // Bumper
                          RB = 6, // Bumper
                          M = 7, // menu
                          S = 8, // start
                          LA = 9, // Press Left axis
                          RA = 10; // Press right axis

  // Joystick - Axis
  public static final int LX = 1,
                          LY = 2,
                          LT = 3, // Tigger
                          RT = 4, // Tigger
                          RX = 5,
                          RY = 6, 
                          PX = 7, // D-Pad
                          PY = 8; // D-Pad

  // public static final int wristBottomPos = 2048;
  // public static final int wristBackLimit = 0;//the backmost position the wrist can reach
  // public static final int wristFrontLimit = 1024;//the frontmost position the wrist can reach
  //PID Wrist
  public static final double Pmult = 0.001;
  public static final double Imult = 0.0008;

  public static final double Pweight = 1;
  public static final double Iweight = 1;

  //Intake
  public static final double intakeSpeed = 0.75;
  public static final double outtakeSpeed = -1;

  //a method for removing an element from an array
  // We could just use ArrayList<>
  public static float[] removeTheElement(float[] arr, int index){
    if (arr == null || index < 0 || index >= arr.length){
      return arr;
    }

    float[] anotherArray = new float[arr.length -1];

    for (int i = 0, k = 0; i < arr.length; i++) {
      if (i == index){
        continue;
      }

      anotherArray[k++] = arr[i];
    }

    return anotherArray;
  }

  

}

