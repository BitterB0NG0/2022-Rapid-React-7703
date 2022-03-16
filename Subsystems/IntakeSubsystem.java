package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class IntakeSubsystem extends SubsystemBase {

    /** Creates a new ExampleSubsystem. */
    public IntakeSubsystem() {}

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    double intakeMotorSpeed;

    // public static void main(String[] args) {

    // }

    public void activateIntake() {
        Constants.intakeMotorController.set(intakeMotorSpeed);
    }

    public void deactivateIntake() {
        Constants.intakeMotorController.set(0);
    }

    public void increaseIntakeSpeed(double intakeMotorSpeed) {
        intakeMotorSpeed += 0.05;
    }

    public void decreaseIntakeSpeed(double intakeMotorSpeed) {
        intakeMotorSpeed -= 0.05;
    }
}
