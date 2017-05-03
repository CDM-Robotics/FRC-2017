package org.usfirst.frc.team6072.robot;

import org.usfirst.frc.team6072.robot.commands.*;
import org.usfirst.frc.team6072.robot.subsystems.*;
import org.usfirst.frc.team6072.robot.triggers.*;

import edu.wpi.first.wpilibj.GamepadBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public Joystick stick;
	public JoystickButton[] buttons = new JoystickButton [12];
	public LimitSwitch gearLimitZero, gearLimitMax;	
	
	public Joystick gamepad;
	public JoystickButton[] gamepadButtons = new JoystickButton[7];
	
	
	public OI(){
		stick = new Joystick(0);
		gamepad = new Joystick(1);
		
		for (int i = 0; i<12; i++){
			buttons[i] = new JoystickButton(stick,i+1);
		}
		for (int i = 0; i<6; i++){
			gamepadButtons[i] = new JoystickButton(gamepad,i+1);
		}
		gearLimitZero = new LimitSwitch(RobotMap.GEAR_LIMIT_ZERO_CHANNEL);
		gearLimitMax = new LimitSwitch(RobotMap.GEAR_LIMIT_MAX_CHANNEL);
		
		buttons[RobotMap.SHIFT_DRIVE_LOW_BUTTON].whenActive(new ShiftDriveGear(0));
		buttons[RobotMap.SHIFT_DRIVE_HIGH_BUTTON].whenActive(new ShiftDriveGear(1));
		buttons[0].whenActive(new UpdateDashboard());
		//buttons[1].whenActive(new Turn(30));
		//buttons[2].whenActive(new Turn(-30));
//		buttons[1].whenActive(new DriveDistance(5000));
//		buttons[1].whenActive(new PositionGear(4096));
//		buttons[2].whenActive(new Turn());
//		buttons[3].whenActive(new DriveDistance(24));
		
		//gamepadButtons[RobotMap.TOGGLE_MANUAL_GEAR_SLIDE_BUTTON].toggleWhenActive(new ManualGearSlide());
		gamepadButtons[RobotMap.ACTUATE_GEAR_SLIDER_UP_BUTTON].whenActive(new ActuateGear(1));
		gamepadButtons[RobotMap.ACTUATE_GEAR_SLIDER_DOWN_BUTTON].whenActive(new ActuateGear(0));
		gamepadButtons[RobotMap.CLIMBER_UP_BUTTON].whileActive(new SpinClimber(1)); //backwards
		gamepadButtons[RobotMap.RESET_GEAR_SLIDER_BUTTON].whenActive(new ResetGearSlider());
		//gamepadButtons[RobotMap.CLIMBER_DOWN_BUTTON].whenActive(new SpinClimber(1));
		//gamepadButtons[RobotMap.CLIMBER_STOP_BUTTON].whenActive(new SpinClimber(0));
		
		/*gamepadButtons[6].toggleWhenActive(new ManualGearSlide());
		gamepadButtons[1].whenActive(new ActuateGear(2));
		gamepadButtons[8].toggleWhenActive(new SpinClimber(0));
		gamepadButtons[9].toggleWhenActive(new SpinClimber(1));
		*/
		//buttons[0].toggleWhenPressed(new PositionGear(0));
		//buttons[1].whenActive(new ResetGearSlider());
		//buttons[7].whenActive(new UpdateDashboard());
		
		//Limit switches for gear slider
		//gearLimitZero.whileActive(new StopGearSlider(0));
		//gearLimitZero.whileActive(new StopGearSlider(1));
		//buttons[3].whileHeld(new PositionGear(3));
	}
	public Joystick getStick() {
		return stick;
	}
	
	public JoystickButton getStickButton(int i) {
		return buttons[i];
	}
	
	public LimitSwitch getGearLimitZero(){
		return gearLimitZero;
	}
	
	public LimitSwitch getGearLimitMax(){
		return gearLimitMax;
	}
}