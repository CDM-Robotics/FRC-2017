package org.usfirst.frc.team6072.robot.commands;

import org.usfirst.frc.team6072.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ActuateGear extends Command {
	public int gearLevel;
    public ActuateGear(int gear) {//0 = high gear, 1 = low gear
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	gearLevel = gear;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (gearLevel==0){
    		Robot.gearSlider.solenoidsOff();
    	} else if (gearLevel==1){
    		Robot.gearSlider.solenoidsOn();
    	} 
    	 else {
    		//If the solenoids somehow got screwed up, this should fix them
    		Robot.gearSlider.solenoidsOff();
    	}
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
