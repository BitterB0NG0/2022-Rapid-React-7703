package frc.robot.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
    
    private final Drivetrain DriveBaseSubsystem;


    private Joystick leftJoystick = RobotContainer.getInstance().getJoystick1();
    private Joystick rightJoystick = RobotContainer.getInstance().getJoystick2();



    public TankDrive(Drivetrain subsystem) {
        m_drivetrain = DriveBaseSubsystem;
        addRequirements(m_drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drivetrain.drive(leftJoystick.getY(), rightJoystick.getY());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_drivetrain.drive(0.0, 0.0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }

}

//if going to crash: 
    //    don't 