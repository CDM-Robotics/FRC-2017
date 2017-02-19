package org.usfirst.frc.team6072.robot.triggers;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Trigger;

//Use NO3 port on the limit switches
public class LimitSwitch extends Trigger {
	private DigitalInput limit;
	public LimitSwitch(int channel){
		super();
		limit = new DigitalInput(channel);
	}
    public boolean get() {
        return !limit.get();
    }
}
