// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

// "Constants" holds robot-wide numerical or boolean constants
public final class Constants {
    /* The CAN IDs are set up from first device to last, even if the said last device is not powered up, or even used by the code (I'm looking at you PDP).
    These motor names SHOULD be changed depending on their purpose in the final code! */

    // Defining Port Numbers or CAN Order for MotorControllers
    public static int frontLeftDriveMotorControllerPort = 4;
    public static int backLeftDriveMotorControllerPort = 5;
    public static int frontRightDriveMotorControllerPort = 6;
    public static int backRightDriveMotorControllerPort = 7;

    public static int floppaShooterMotorControllerPort = 9;
    public static int bingusShooterMotorControllerPort = 3;
    public static int quadingleLoadingMotorControllerPort = 2;
    
    public static int intakeMotorControllerPort = 8;

    // Defining IntakeSubsystem Variables
    public static double initialIntakeMotorSpeed = 0;
    public static int intakeDeployTime = 100; // Deploy Time in Number of 20ms within the deploy interval

    // Defining Sensors Ports
    public static int ultrasonicPort = 0;
    public static int cameraPorts = 0;
    public static int mainjoystickPort = 0;

    // logic, and yes I realize this is commiting blasphamy, but there is no other way to do it with how a Command base works
    public static double[] accel;
    public static double distance;

    // Defining ShooterSystemVariables
    public static Color detectedColor;

    public static double quadinglePower = .6;
    public static double floppaPower;
    public static double bingusPower;

    // public static String driveMode = "curvature";

    public static I2C.Port i2cPort = I2C.Port.kOnboard;
}
