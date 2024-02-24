package frc.robot.subsystems;


import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.OperatorConstants;

public class ClimberSubsystem extends SubsystemBase{

    TalonFX m_leftClimb; 
    TalonFX m_rightClimb;

    public ClimberSubsystem() {

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
