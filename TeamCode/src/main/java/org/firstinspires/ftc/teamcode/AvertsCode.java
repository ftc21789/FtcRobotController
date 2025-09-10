package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class AvertsCode extends OpMode {

    //Variables for motors
    private DcMotor frontLeft, frontRight, backLeft, backRight;
    private DcMotor arm, wrist;

    private Servo claw;

    //private Servo intake;

    //Variables for arm and claw positions
    private final double clawOpen = 1;

    private final double clawClosed = 0;

    @Override
    public void init() {
        //This gets the motors from the robot controller and assigns them to our variables.
        frontLeft = hardwareMap.get(DcMotor.class,"Frontleft");
        frontRight = hardwareMap.get(DcMotor.class,"Frontright");
        backLeft = hardwareMap.get(DcMotor.class,"Backleft");
        backRight = hardwareMap.get(DcMotor.class,"Backright");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        arm = hardwareMap.get(DcMotor.class, "tower");
        wrist = hardwareMap.get(DcMotor.class, "hinge");

        claw = hardwareMap.get(Servo.class, "pincer");
        //intake = hardwareMap.get(Servo.class, "intake");

    }

    @Override
    public void loop() {
        frontLeft.setPower(-gamepad1.left_stick_y);
        frontRight.setPower(-gamepad1.right_stick_y);
        backLeft.setPower(-gamepad1.left_stick_y);
        backRight.setPower(-gamepad1.right_stick_y);
        //Telemetry code
        telemetry.addData("frontLeft", frontLeft.getCurrentPosition());
        telemetry.addData("frontRight", frontRight.getCurrentPosition());
        telemetry.addData("backLeft", backLeft.getCurrentPosition());
        telemetry.addData("backRight", backRight.getCurrentPosition());
        telemetry.addData("arm", arm.getCurrentPosition());
        telemetry.addData("wrist", wrist.getCurrentPosition());
        telemetry.update();


    }
}
