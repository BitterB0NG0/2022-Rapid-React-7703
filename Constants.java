// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

// "Constants" holds robot-wide numerical or boolean constants
public final class Constants {
    /* The CAN IDs are set up from first device to last, even if the said last device is not powered up, or even used by the code (I'm looking at you PDP).
    These motor names SHOULD be changed depending on their purpose in the final code! */

    // Defining DriveBaseSubsystem Objects/Variables
    public static WPI_VictorSPX frontLeftDriveMotorController = new WPI_VictorSPX(2);
    public static WPI_VictorSPX backLeftDriveMotorController = new WPI_VictorSPX(3);
    static MotorControllerGroup leftDriveMotorControllerGroup = new MotorControllerGroup(frontLeftDriveMotorController, backLeftDriveMotorController);
    public static WPI_VictorSPX frontRightDriveMotorController = new WPI_VictorSPX(8);
    public static WPI_VictorSPX backRightDriveMotorController = new WPI_VictorSPX(9);
    static MotorControllerGroup rightDriveControllerGroup = new MotorControllerGroup(frontRightDriveMotorController, backRightDriveMotorController);
    public static DifferentialDrive differentialDrive = new DifferentialDrive(leftDriveMotorControllerGroup, rightDriveControllerGroup);

    public static int driveModeIndex = 1; //"0" corresponds to arcadeDrive; "1", to curvatureDrive; and "2", to tankDrive

    // Defining IntakeSubsystem Objects/Variables
    public static double initialIntakeMotorSpeed = 0;

    // Defining ShooterSubsystem Objects/Variables
    public static WPI_VictorSPX floppaShooterMotorController = new WPI_VictorSPX(4);
    public static WPI_VictorSPX bingusShooterMotorController = new WPI_VictorSPX(5);
    public static WPI_VictorSPX quadingleLoadingMotorController = new WPI_VictorSPX(6);

    // Defining IntakeSubsystem Objects/Variables
    public static WPI_VictorSPX intakeMotorController = new WPI_VictorSPX(9);
    
    // Defining Sensors
    public static AnalogInput ultrasonic = new AnalogInput(0);
    public static Accelerometer accelerometer = new BuiltInAccelerometer();
    public static int cameraPorts = 0;

    public static Joystick mainJoystick = new Joystick(0);

    // logic, and yes I realize this is commiting blasphamy, but there is no other way to do it with how a Command base works
    public static boolean runningIntake = false;
}
