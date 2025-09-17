package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Auton{

    private DcMotor frontLeft, frontRight, backLeft, backRight;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.get(DcMotor.class,"Frontleft");
        frontRight = hardwareMap.get(DcMotor.class,"Frontright");
        backLeft = hardwareMap.get(DcMotor.class,"Backleft");
        backRight = hardwareMap.get(DcMotor.class,"Backright");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        backLeft.setMode(DcMotor.RunMode.RUN_WITH_ENCODER);

    }

    public void forward(double distance, double speed){


    }
}
