// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.math.filter.LinearFilter;

// user created files for import
import frc.robot.Subsystems.DriveBaseSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.SensorSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;

public class Robot extends TimedRobot {
  /* The VM is configured to automatically run this class, and to call the functions corresponding to each mode, as described in the TimedRobot documentation. 
  If you change the name of this class or the package after creating this project, you must also update the build.gradle file in the project. */

  // Declarining Instances of Subsystems
  DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();
  IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  SensorSubsystem sensorSubsystem = new SensorSubsystem();
    
  // Declaring Input Variables
  double xAxisValue;
  double yAxisValue;
  double zAxisValue;
  double[] acceleration;
  double distance;
  public static double currentIntakeMotorSpeed;

  // "robotInit()" is called during robot operation initiilzation regardless of mode
  @Override
  public void robotInit() {
    // Defining Initial Input Varaibles
    currentIntakeMotorSpeed = Constants.initialIntakeMotorSpeed;

    // Running Subsystem Initilization Methods
    sensorSubsystem.cameraInit();
  }

  // "robotPeriodic()" is called periodically, every 20ms, during robot operation regardless of mode
  @Override
  public void robotPeriodic() {
    // Updating Input Variables
    xAxisValue = Constants.mainJoystick.getRawAxis(0);
    yAxisValue = Constants.mainJoystick.getRawAxis(1);
    zAxisValue = Constants.mainJoystick.getRawAxis(2);
  
    // Running Subsystem Methods
    // SensorSubsystem
    acceleration = sensorSubsystem.accelerometerPeriodic();
    distance = sensorSubsystem.distanceSensorValuePeriodic();
  }

  /* This autonomous (along with the chooser code above) shows how to select between different autonomous modes using the dashboard. 
  The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box below the Gyro.  
  You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings. If using the SendableChooser make sure to add them to the chooser code above as well. */

  // "autonomousInit()" is called during autonomous mode initilization
  @Override
  public void autonomousInit() {}

  // "autonomousPeriodic" is called periodically during autonomous mode
  @Override
  public void autonomousPeriodic() {}

  // "teleopInit()" is called during teleoperation mode initilization
  @Override
  public void teleopInit() {}

  // "teleopPeriodic()" called periodically during teleoperation mode
  @Override
  public void teleopPeriodic() {
    // Running Command Methods: DriveBaseSubsystem 
    if(Constants.driveModeIndex == 0) {
      driveBaseSubsystem.drivePercentArcade(xAxisValue, yAxisValue, true);
    }

    if(Constants.driveModeIndex == 1) {
      driveBaseSubsystem.drivePercentCurvature(xAxisValue, yAxisValue, true);
    }
  
    if(Constants.driveModeIndex == 2) {
      driveBaseSubsystem.drivePercentTank(xAxisValue * yAxisValue, xAxisValue * yAxisValue * -1, true);
    }
  
    // Running Command Methods: IntakeSubsystem 
    if(Constants.mainJoystick.getRawButton(0)) {
      intakeSubsystem.activateIntake(Constants.initialIntakeMotorSpeed);
    }
    
    if(Constants.mainJoystick.getRawButton(1)) {
      intakeSubsystem.increaseIntakeSpeed(currentIntakeMotorSpeed);
    }

    if(Constants.mainJoystick.getRawButton(2)) {
      intakeSubsystem.decreaseIntakeSpeed(currentIntakeMotorSpeed);
    }
  }

  // "disabledInit()" is called during disabled mode initilization
  @Override
  public void disabledInit() {}

  // "disabledPeriodic()" is called periodically during disabled mode 
  @Override
  public void disabledPeriodic() {}

  // "testInit()" is called during test mode initilization
  @Override
  public void testInit() {}

  // "testPeriodic()" is called periodically during test mode
  @Override
  public void testPeriodic() {}

  // "simulationInit()" is called during simulation mode initilization
  @Override
  public void simulationInit() {}

  // "simulationPeriodic()" is called during periodic mode initilization
  @Override
  public void simulationPeriodic() {}
}
