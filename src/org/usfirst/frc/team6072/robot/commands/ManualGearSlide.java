package org.usfirst.frc.team6072.robot.commands;

import org.usfirst.frc.team6072.robot.Robot;
import org.usfirst.frc.team6072.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualGearSlide extends Command {

    public ManualGearSlide() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearSlider);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = Robot.oi.gamepad.getRawAxis(0);
    	if (speed<0 && !Robot.oi.getGearLimitMax().get()){
    		Robot.gearSlider.setSpeed((int) (speed*RobotMap.MANUAL_GEAR_SLIDE_SPEED));    		
    	} else if (speed>0 && !Robot.oi.getGearLimitZero().get()){
    		Robot.gearSlider.setSpeed((int) (speed*RobotMap.MANUAL_GEAR_SLIDE_SPEED));
    	} else {
    		Robot.gearSlider.setSpeed((int) (speed*RobotMap.MANUAL_GEAR_SLIDE_SPEED));
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
