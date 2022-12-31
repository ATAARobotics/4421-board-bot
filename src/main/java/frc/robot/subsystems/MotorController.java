// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorController extends SubsystemBase {
  VictorSPX motorController;
  CANCoder encoder;

  public MotorController(int motorControllerPort, int encoderPort) {
    this.encoder = new CANCoder(encoderPort);
    this.motorController = new VictorSPX(motorControllerPort);
  }

  public void startMotor() {
    motorController.set(ControlMode.PercentOutput, 0.2);
    //Current gearbox 100:1
  }

  public void stopMotor() {
    motorController.set(ControlMode.PercentOutput, 0.0);
  }

  public double getEncoderTicks() {
    return this.encoder.getPosition();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Rotations", this.getEncoderTicks());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
