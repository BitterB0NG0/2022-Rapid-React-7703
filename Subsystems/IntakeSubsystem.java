package frc.robot.Subsystems;

import frc.robot.Constants;
import frc.robot.Robot;

public class IntakeSubsystem {
    public static void main(String[] args) {

    }

    public void activateIntake(double intakeMotorSpeed) {
        Constants.intakeMotorController.set(intakeMotorSpeed);
    }

    public void deacrivateIntake(double intakeMotorSpeed) {
        Constants.intakeMotorController.stopMotor();
    }

    public void increaseIntakeSpeed(double intakeMotorSpeed) {
        Robot.currentIntakeMotorSpeed = Robot.currentIntakeMotorSpeed + 0.05;
        Constants.intakeMotorController.set(intakeMotorSpeed);
    }

    public void decreaseIntakeSpeed(double intakeMotorSpeed) {
        intakeMotorSpeed = intakeMotorSpeed - 0.05;
        Constants.intakeMotorController.set(intakeMotorSpeed);
    }
}
