package org.usfirst.frc.team6072.robot.commands;

import org.usfirst.frc.team6072.robot.Robot;
import org.usfirst.frc.team6072.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShakeGear extends Command {
	private long time;
	private double endTime=400;
	private double speed=.65;
	private int count=0;
    public ShakeGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearSlider);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	time = System.currentTimeMillis();
    	Robot.gearSlider.setSpeed(speed*RobotMap.MANUAL_GEAR_SLIDE_SPEED);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (System.currentTimeMillis()-time>endTime){
    		endTime=800;
    		speed *= -1;
    		Robot.gearSlider.setSpeed(speed*RobotMap.MANUAL_GEAR_SLIDE_SPEED);

        	count++;
        	time = System.currentTimeMillis();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.oi.getGearLimitMax().get()||Robot.oi.getGearLimitZero().get()||count>12;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gearSlider.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
