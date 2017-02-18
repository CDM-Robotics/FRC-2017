package org.usfirst.frc.team6072.robot.commands;

import org.usfirst.frc.team6072.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PositionGear extends Command {

	int position;
    public PositionGear(int pos) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super();
    	requires(Robot.gearslider);
    	position = pos;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearslider.moveToPosition(position);
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
