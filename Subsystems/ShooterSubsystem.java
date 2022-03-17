package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ShooterSubsystem extends SubsystemBase { 
    // Stating ShooterSubsystem Variables
    public double distanceToTarget;

    // Stating and Defining ShooterSubsystem Objects
    public static WPI_VictorSPX floppaShooterMotorController = new WPI_VictorSPX(Constants.floppaShooterMotorControllerPort);
    public static WPI_VictorSPX bingusShooterMotorController = new WPI_VictorSPX(Constants.bingusShooterMotorControllerPort);
    public static WPI_VictorSPX quadingleLoadingMotorController = new WPI_VictorSPX(Constants.quadingleLoadingMotorControllerPort);

    public static boolean shooterFlywheelActive;
    public static boolean loadWheelActive;

    // "ShooterSubsystem()" creates a ShooterSubsystem
    public ShooterSubsystem() {}

    // "periodic()" is called periodically, once per scheduler run
    @Override
    public void periodic() {
        if (shooterFlywheelActive) {
            floppaShooterMotorController.set(ControlMode.PercentOutput, Constants.shooterFlywheelPower);
            bingusShooterMotorController.set(ControlMode.PercentOutput, Constants.shooterFlywheelPower);
        }
        if (loadWheelActive) {
            quadingleLoadingMotorController.set(ControlMode.PercentOutput, Constants.loaderMotorPower);
        }
        if (RobotContainer.mainJoystick.getRawButtonPressed(1)) {
            loadWheelActive = true;
        } else if (RobotContainer.mainJoystick.getRawButtonReleased(1)) {
            loadWheelActive = false;
        }
    }

    // This method will be called once per scheduler run during simulation
    @Override
    public void simulationPeriodic() {
    }

    // "calculateFlyWheelSpeeds()" calculates the velocity requirements for hitting the target
    public double calculateFlyWheelSpeeds(double distanceToTarget) {
        double flyWheelSpeeds = distanceToTarget * Constants.gravitationalFieldStrengthOnBall / (Constants.terminalVelocityOfBall * Math.cos(Constants.angleOfShooter));
        return flyWheelSpeeds;
    }

    // "loadShooter()" commands the loading wheel to rotate slightly and load the shooting mechanism
    public void loadShooter() {

    }

    // "activateShooter()" commands the shooter system to shoot
    public void activateShooter() {
        loadWheelActive = true;
    }

    // "deactivateShooter()" commands the shooter system to shoot
    public void deactivateShooter() {
        loadWheelActive = false;
    }

    // "activateShootingFlyWheels()" commands the shooting flywheels to spool up to the required veolcities
    public void activateShootingFlyWheels(double power) {
        shooterFlywheelActive = true;
    }

    // "deactivateShootingFlyWheels()" commands the shooting flywheels to halt
    public void deactivateShootingFlyWheels() {
        shooterFlywheelActive = false;
    }
}
