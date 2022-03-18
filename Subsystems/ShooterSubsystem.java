package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class ShooterSubsystem extends SubsystemBase { 
    // Stating ShooterSubsystem Variables
    public double distanceToTarget;

    // Stating and Defining ShooterSubsystem Objects
    public static WPI_VictorSPX floppaShooterMotorController = new WPI_VictorSPX(Constants.floppaShooterMotorControllerPort);
    public static WPI_VictorSPX bingusShooterMotorController = new WPI_VictorSPX(Constants.bingusShooterMotorControllerPort);
    public static WPI_VictorSPX quadingleLoadingMotorController = new WPI_VictorSPX(Constants.quadingleLoadingMotorControllerPort);

    public static boolean shooterFlywheelActive = true;
    public static boolean loadWheelActive;
    public static boolean manualPowerSetting = true;

    // "ShooterSubsystem()" creates a ShooterSubsystem
    public ShooterSubsystem() {}

    // "periodic()" is called periodically, once per scheduler run
    @Override
    public void periodic() {

        if (shooterFlywheelActive) {
            setFlyWheelSpeeds((RobotContainer.mainJoystick.getRawAxis(2) -
             1) / 2);
            floppaShooterMotorController.set(ControlMode.PercentOutput, Constants.floppaPower);
            bingusShooterMotorController.set(ControlMode.PercentOutput, -Constants.bingusPower);
        }
        if (loadWheelActive == true) {
            quadingleLoadingMotorController.set(ControlMode.PercentOutput, Constants.quadinglePower);
        } else {
            quadingleLoadingMotorController.set(ControlMode.PercentOutput, 0);
        }

        if (RobotContainer.mainJoystick.getRawButtonPressed(1)) {
            loadWheelActive = true;
        } 
        if (RobotContainer.mainJoystick.getRawButtonReleased(1)) {
            loadWheelActive = false;
        }

        if (RobotContainer.mainJoystick.getRawButtonPressed(6)) {
            manualPowerSetting = true;
        }
        if (RobotContainer.mainJoystick.getRawButtonPressed(7)) {
            manualPowerSetting = false;
        }

        if (RobotContainer.mainJoystick.getRawButtonPressed(9)) {
            if (shooterFlywheelActive) {
                shooterFlywheelActive = false;
            } else {
                shooterFlywheelActive = true;
            }
        }
    }

    // This method will be called once per scheduler run during simulation
    @Override
    public void simulationPeriodic() {
    }

    // "setFlyWheelSpeeds()" sets the power of the shootingFlyWheelsSpeeds
    public void setFlyWheelSpeeds(double powerSetting) {
        if (manualPowerSetting = true) {
            Constants.floppaPower = powerSetting;
            Constants.bingusPower = powerSetting;
        } else {
            //Constants.floppaPower = ;
            //Constants.bingusPower =;
        }
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
    public void activateShootingFlyWheels() {
        shooterFlywheelActive = true;
    }

    // "deactivateShootingFlyWheels()" commands the shooting flywheels to halt
    public void deactivateShootingFlyWheels() {
        shooterFlywheelActive = false;
    }
}
