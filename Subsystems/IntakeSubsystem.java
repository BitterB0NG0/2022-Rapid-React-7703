package frc.robot.Subsystems;

import frc.robot.Constants;

public class IntakeSubsystem {
    public static void main(String[] args) {
        
    }

    public void activateIntake(double intakeMotorSpeed) {
        Constants.intakeMotorController.set(intakeMotorSpeed);
    }

    public void increaseIntakeSpeed() {

    }

    public void decreaseIntakeSpeed() {
        
    }



}
