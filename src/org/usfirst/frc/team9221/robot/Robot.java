package org.usfirst.frc.team9221.robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Timer;


public class Robot extends IterativeRobot {
	public VictorSP VSP1sol1 = new VictorSP(8);
	public VictorSP VSP2sol2 = new VictorSP(9);
	public VictorSP VSP3sag1 = new VictorSP(7);
	public VictorSP VSP4sag2 = new VictorSP(6);
	public VictorSP VSPf1 = new VictorSP(0);
	public VictorSP VSPf2 = new VictorSP(1);
	public VictorSP VSPf3 = new VictorSP(2);
	public Joystick logitech = new Joystick(5);
	public Joystick logitech2 = new Joystick(0);
	double leftStickValue;
	double rightStickValue;
	double rtrigger,ltrigger;
	boolean lbutton, rbutton;
	boolean Ybutton;
	double scontrol;
	Timer timer;
	@Override
	public void robotInit() {
		timer = new Timer();

	}

	@Override
	public void autonomousInit() {
		timer.reset();
		timer.start();
		
	}

	@Override
	public void autonomousPeriodic() {
		if(timer.get() < 7.59221)
		{
			VSP1sol1.set(0.32);
			VSP2sol2.set(0.32);
			VSP3sag1.set(-0.33);
			VSP4sag2.set(-0.33);
		}
		else
		{
			VSP1sol1.set(0.0);
			VSP2sol2.set(0.0);
			VSP3sag1.set(-0.0);
			VSP4sag2.set(-0.0);
		}
		
		
		
	 
	}

	
	@Override
	public void teleopPeriodic() {
		if (Ybutton = false)
		{
		scontrol = 0.7;
		}
		else
		{
		scontrol = 1.0;
		}
		
		leftStickValue = logitech.getRawAxis(1);
		rightStickValue = logitech.getRawAxis(5);
		ltrigger = logitech.getRawAxis(2);
		rtrigger = logitech.getRawAxis(3);
		lbutton = logitech.getRawButton(5);
		rbutton = logitech.getRawButton(6);
	
		VSP1sol1.set(-leftStickValue*scontrol);
		VSP2sol2.set(-leftStickValue*scontrol);
		VSP3sag1.set(rightStickValue*scontrol);
		VSP4sag2.set(rightStickValue*scontrol);
		
		/*if(ltrigger > 0.2)
		{
			VSPf1.set(1.0);
		}
		
		else if(rtrigger > 0.2)
		{
			VSPf1.set(-1.0);
		}
		
		else
		{
			VSPf1.set(0.0);
		}
        
		
		if(lbutton == true) 
		{
			VSPf2.set(0.7);
			VSPf3.set(0.7);
		}
		
		else if(rbutton == true)
		{
			VSPf2.set(-0.7);
			VSPf3.set(-0.7);
		}
		
		else
		{
			VSPf2.set(0.0);
			VSPf3.set(0.0);
		}*/	
	}

	@Override
	public void testPeriodic() {
	}
}