package org.usfirst.frc.team6072.robot.commands;

import org.usfirst.frc.team6072.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UpdateDashboard extends Command {

    public UpdateDashboard() {
//    	requires(Robot.gearslider);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("position", Robot.gearSlider.getPosition());
    	SmartDashboard.putNumber("Speed", Robot.gearSlider.getSpeed());
    	SmartDashboard.putBoolean("Limit Switch status", Robot.oi.getGearLimitZero().get());
    	
    	if (Robot.oi.getStickButton(11).get()){
    		Robot.gearSlider.setPosition(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
