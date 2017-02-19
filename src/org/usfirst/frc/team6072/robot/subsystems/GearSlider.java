package org.usfirst.frc.team6072.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6072.robot.Robot;
import org.usfirst.frc.team6072.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
/**
 *
 */
public class GearSlider extends Subsystem {
	CANTalon talon;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public GearSlider(){
		super();
		talon = new CANTalon(5);
		
		/* grab the 360 degree position of the MagEncoder's absolute position */
		int absolutePosition = talon.getPulseWidthPosition() & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */
        /* use the low level API to set the quad encoder signal */
        talon.setEncPosition(absolutePosition);
        /* choose the sensor and sensor direction */
        talon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        talon.reverseSensor(false);
       
        /* set the peak and nominal outputs, 12V means full */
        talon.configNominalOutputVoltage(+0f, -0f);
        talon.configPeakOutputVoltage(+4f, -4f);
        /* set the allowable closed-loop error,
         * Closed-Loop output will be neutral within this range.
         * See Table in Section 17.2.1 for native units per rotation. 
         */
        talon.setAllowableClosedLoopErr(0); /* always servo */
        /* set closed loop gains in slot0 */
        
        //GLORIOUS PERFECT PID FOR 7:1 GEARING
        talon.setProfile(0);
        talon.setF(0.0);
        talon.setP(0.75);
        talon.setI(0.0); 
        talon.setD(5.5);       
        talon.changeControlMode(TalonControlMode.Position);
       
	}
	public void reset(){
        talon.changeControlMode(TalonControlMode.Position);
		talon.setPosition(Robot.oi.getStick().getThrottle());
	}
	public void moveToPosition(double pos){
        talon.changeControlMode(TalonControlMode.Position);
		talon.set(pos);
	}
	public int getPosition(){
		return talon.getEncPosition();
	} 
	public int getSpeed(){
		return talon.getEncVelocity();
	}
	public void stop(){
//		talon.disable();
		talon.changeControlMode(TalonControlMode.Speed);
		talon.set(0);
		talon.changeControlMode(TalonControlMode.Position);
		talon.set(getPosition());
 //       talon.enable();
	}
	public void setPosition(double pos){
		talon.setPosition(RobotMap.GEAR_SLIDER_LOAD_POSITION);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}