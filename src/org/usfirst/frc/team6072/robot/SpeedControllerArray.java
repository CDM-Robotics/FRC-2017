package org.usfirst.frc.team6072.robot;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * A SpeedController implementation that wraps an array of one or more
 * SpeedController objects so they look like a single SpeedController (a
 * software version of a PWM splitter cable).
 * 
 * Courtesty of pblankenbaker of team 868
 */
public class SpeedControllerArray implements SpeedController {
	
	// Array of motors to control like one
	private SpeedController[] motors;

	public SpeedControllerArray(SpeedController[] motors) {
		if (motors.length < 1) {
			throw new IllegalArgumentException("You must pass an array of at least one SpeedController");
		}
		this.motors = motors;
	}

	@Override
	public void pidWrite(double output) {
		set(output);
	}

	@Override
	public double get() {
		// Since all motors have same value, return value from first one
		return motors[0].get();
	}

/*	@Override
	public void set(double speed, byte syncGroup) {
		for (SpeedController motor : motors) {
			motor.set(speed, syncGroup);
		}
	}
*/
	@Override
	public void set(double speed) {
		for (SpeedController motor : motors) {
			motor.set(speed);
		}
	}

	@Override
	public void setInverted(boolean isInverted) {
		for (SpeedController motor : motors) {
			motor.setInverted(isInverted);
		}
	}

	@Override
	public boolean getInverted() {
		// Since all motors have same value, return value from first one
		return motors[0].getInverted();
	}

	@Override
	public void disable() {
		for (SpeedController motor : motors) {
			motor.disable();
		}
	}

	@Override
	public void stopMotor() {
		for (SpeedController motor : motors) {
			motor.stopMotor();
		}
	}

}