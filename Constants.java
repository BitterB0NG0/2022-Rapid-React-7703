// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
<<<<<<< Updated upstream

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {}
=======

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    /* The CAN IDs are set up from first device to last, even if the said last device is not powered up, or even used by the code (I'm looking at you PDP).
    These motor names SHOULD be changed depending on their purpose in the final code! */

    // VictorSPX motor1 = new VictorSPX(1); 
    // VictorSPX motor2 = new VictorSPX(2);
    // VictorSPX motor3 = new VictorSPX(3);
    // VictorSPX motor4 = new VictorSPX(4);
    VictorSPX motor5 = new VictorSPX(5);
    VictorSPX motor6 = new VictorSPX(6);
    VictorSPX motor7 = new VictorSPX(7);
    VictorSPX motor8 = new VictorSPX(8);


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
    // public static WPI_VictorSPX intakeMotorController = new WPI_VictorSPX(4);

    public static double initialIntakeMotorSpeed = 0;

    // Defining ShooterSubsystem Objects/Variables
    public static WPI_VictorSPX floppaMotorController = new WPI_VictorSPX(4);
    public static WPI_VictorSPX bingusMotorController = new WPI_VictorSPX(5);
    public static WPI_VictorSPX quadingleMotorController = new WPI_VictorSPX(6);

    // Defining IntakeSubsystem Objects/Variables
    public static WPI_VictorSPX intakeMotorController = new WPI_VictorSPX(9);
    
    // Defining IO & Sensors
    public static Joystick mainJoystick = new Joystick(0);
    public static JoystickButton trigger = new JoystickButton(mainJoystick, 1);
    public static AnalogInput ultrasonic = new AnalogInput(0);
    public static Accelerometer accelerometer = new BuiltInAccelerometer();
    public static int cameraPorts = 0;
}
>>>>>>> Stashed changes
