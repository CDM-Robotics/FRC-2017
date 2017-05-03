package org.usfirst.frc.team6072.robot.commands;

import org.usfirst.frc.team6072.robot.Robot;
import org.usfirst.frc.team6072.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ResetGearSlider extends Command {
	boolean stop=false;
    public ResetGearSlider() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearSlider);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.gearSlider.slideDirection(0);
		Robot.gearSlider.solenoidsOn();
    	Robot.gearSlider.setSpeed(-1*RobotMap.MANUAL_GEAR_SLIDE_SPEED);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.gearSlider.moveToPosition((Robot.gearSlider.getPosition()/4096)+.5);
    	if (Robot.oi.getGearLimitZero().get()){
    		Robot.gearSlider.setSpeed(0);
    		stop=true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stop;
    }

    // Called once after isFinished returns true
    protected void end() {
		Robot.gearSlider.solenoidsOff();
    	//Robot.gearSlider.setPosition((int)RobotMap.GEAR_SLIDER_LOAD_POSITION);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//Robot.gearSlider.stop();
    }
}
