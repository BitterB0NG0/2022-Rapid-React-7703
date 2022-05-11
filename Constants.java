// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
    
package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

// "Constants" holds robot-wide numerical or boolean constants
public final class Constants {

    // Defining IntakeSubsystem Variables
    public static double initialIntakeMotorSpeed = 0;
    public static int intakeDeployTime = 100; // Deploy Time in Number of 20ms within the deploy interval

    // Defining Sensors Ports & Varaibles
    public static int ultrasonicPort = 0;
    public static int cameraPorts = 0;
    public static int mainjoystickPort = 0;
    public static I2C.Port i2cPort = I2C.Port.kOnboard;

    public static Color detectedColor;
    public static double[] accel;
    public static double distance;

    // Defining ShooterSystemVariables
    public static double quadinglePower = 1;
    public static double floppaPower;
    public static double bingusPower;

    public static double shooterAngle = 1.309; // Angle in Radians (75 Degrees)
    public static double gravitationalFieldStrenth = 9.80665; // Gravitational Field Stregnth in Meters per Second per Second
    public static double maximumHeight = 8; // Maximym Height in Meters
}
