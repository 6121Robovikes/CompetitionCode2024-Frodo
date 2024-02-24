package frc.robot.subsystems;


import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.VelocityVoltage;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.OperatorConstants;

public class ClimberSubsystem extends SubsystemBase{

    Talon m_leftClimb; 
    Talon m_rightClimb;

    public ClimberSubsystem() {
    
    m_leftClimb = new Talon(OperatorConstants.ClimberLeftMotorID); 
    m_rightClimb = new Talon(OperatorConstants.ClimberRigtMotorID);

        //factory default both motors
   

  //add Position control

  }

    @Override
  public void periodic() {


  }

  public void shoot() {

    //Set velocity to 8rps, add 0.5 V to overcome gravity


 }
 
  public void stop(){
  
  }

  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

}
