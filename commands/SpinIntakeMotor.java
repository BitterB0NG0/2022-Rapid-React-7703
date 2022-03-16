package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class SpinIntakeMotor extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final IntakeSubsystem m_subsystem;
    private double motorPower;
    
    public SpinIntakeMotor(IntakeSubsystem intakeSubsystem, double power) {
        m_subsystem = intakeSubsystem;
        m_subsystem.intakeMotorSpeed = power;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(intakeSubsystem);
    }

    // "intialize()" called when the command is initially scheduled
    @Override
    public void initialize() {}

    // "execture()" called every time the scheduler runs while the command is scheduled
    @Override
    public void execute() {
        Constants.runningIntake = true;
    }

    // "end" called when the command ends or is interrupted
    @Override
    public void end(boolean interrupted) {}

    // "isFinished()" called when the command should end
    @Override
    public boolean isFinished() {
        return false;
    }
}