package frc.robot.subsystems;

//import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/* This import probabily is not nessessary
import edu.wpi.first.wpilibj.MotorSafety;
*/
import edu.wpi.first.wpilibj.motorcontrol.*;
import frc.robot.Constants;

public class DriveSubsystem {
    // Establishing the Motor Controllers Object
    private final PWMVictorSPX leftMaster = new PWMVictorSPX(Constants.leftMasterPort);
    private final PWMVictorSPX rightMaster = new PWMVictorSPX(Constants.leftMasterPort);

    // Establishing the Drive Differential Object
    private final DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);
    
    // Manual Drive Method
    public void manualDrive(double xSpeed, double zRotationRate) {
        drive.arcadeDrive(xSpeed, zRotationRate);
    }
}
