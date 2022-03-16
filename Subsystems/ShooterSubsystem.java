package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Constants;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase { 
    
    public static WPI_VictorSPX floppaShooterMotorController = new WPI_VictorSPX(Constants.floppaShooterMotorControllerPort);
    public static WPI_VictorSPX bingusShooterMotorController = new WPI_VictorSPX(Constants.bingusShooterMotorControllerPort);
    public static WPI_VictorSPX quadingleLoadingMotorController = new WPI_VictorSPX(Constants.quadingleLoadingMotorControllerPort);

    /** Creates a new ShooterSubsystem. */
    public ShooterSubsystem() {}

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    public void calculateFlyWheelSpeeds() {

    }

    public void loadShooter() {

    }

    public void loadShootingFlyWheels() {

    }

    public void activateShootingFlyWheels() {

    }

    public void deactivateShootingFlyWheels() {

    }
}
