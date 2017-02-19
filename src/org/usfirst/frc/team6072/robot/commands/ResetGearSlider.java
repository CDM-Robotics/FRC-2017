package org.usfirst.frc.team6072.robot.commands;

import org.usfirst.frc.team6072.robot.Robot;
import org.usfirst.frc.team6072.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetGearSlider extends Command {

    public ResetGearSlider() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearSlider);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearSlider.slideDirection(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.gearslider.setPosition(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.gearSlider.stop();
    }
}
