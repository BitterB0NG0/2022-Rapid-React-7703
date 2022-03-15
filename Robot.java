// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.math.filter.LinearFilter;

// user created files for import
import frc.robot.Constants;
import frc.robot.Subsystems.DriveBaseSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.SensorSybsystem;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  // Declarining Instances of Subsystems
  DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();
  IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  // Accelerometer
  LinearFilter xAccelFilter = LinearFilter.movingAverage(10);
  Thread m_visionThread;

  double prevXAccel = 0;
  double prevYAccel = 0;

  // *NOTE: This should get the current position of the joystick

  // for Joysticks
  double xAxisValue = 0;
  double yAxisValue = 0;
  double zAxisValue = 0.05;

  SensorSybsystem sensors = new SensorSybsystem();
  double[] acceleration;
  double distance;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    sensors.cameraInit(Constants.cameraPorts);
  }

  // This function is called every 20 ms, no matter the mode. Use this for items like diagnostics that you want ran during disabled, autonomous, teleoperated and test.
  @Override
  public void robotPeriodic() {

    yAxisValue = Constants.mainJoystick.getRawAxis(1);
    xAxisValue = Constants.mainJoystick.getRawAxis(0);
    zAxisValue = Constants.mainJoystick.getRawAxis(2);



    acceleration = sensors.accelerometerPeriodic();

    distance = sensors.distanceSensorValue();

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {}

  // This function is called periodically during autonomous.
  @Override
  public void autonomousPeriodic() {}

  // This function is called once when teleop is enabled.
  @Override
  public void teleopInit() {}

  // This function is called periodically during operator control.
  @Override
  public void teleopPeriodic() {
    
    // Drive Subsystem Method Selections
    driveBaseSubsystem.drivePercentArcade(xAxisValue, yAxisValue, true);
    // driveBaseSubsystem.drivePercentCurvature(xAxisValue, yAxisValue, true);
    // driveBaseSubsystem.drivePercentTank(xAxisValue * yAxisValue, xAxisValue * yAxisValue * -1, true);

    // Calling Intake Subsystem
    // *NOTE: USE OF THE zAxis is incorrect and temporary
    intakeSubsystem.activateIntake(zAxisValue);
  }

  // This function is called once when the robot is disabled.
  @Override
  public void disabledInit() {}

  // This function is called periodically when disabled.
  @Override
  public void disabledPeriodic() {}

  // This function is called once when test mode is enabled.
  @Override
  public void testInit() {}

  // This function is called periodically during test mode.
  @Override
  public void testPeriodic() {}

  // This function is called once when the robot is first started up.
  @Override
  public void simulationInit() {}

  // This function is called periodically whilst in simulation.
  @Override
  public void simulationPeriodic() {}
}
