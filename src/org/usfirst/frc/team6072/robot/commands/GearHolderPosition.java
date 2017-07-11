package org.usfirst.frc.team6072.robot.commands;
import org.usfirst.frc.team6072.robot.Robot;
import org.usfirst.frc.team6072.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class GearHolderPosition extends Command {

	public GearHolderPosition() {
		requires(Robot.gearSlider);
		Robot.gearSlider.setSpeed(10);
		Robot.gearSlider.setPosition(50);
	}
	
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.gearSlider.setPosition(50);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }
}
