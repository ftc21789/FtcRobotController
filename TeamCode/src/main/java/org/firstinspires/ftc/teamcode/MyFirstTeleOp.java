package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.configuration.annotations.ServoTypes;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.ServoConfigurationType;

@TeleOp
public class MyFirstTeleOp extends OpMode {

    //Variables for motors
    private DcMotor frontLeft, frontRight, backLeft, backRight;
    private DcMotor arm, wrist;

    private Servo claw;

    private Servo intake;

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
        intake = hardwareMap.get(Servo.class, "intake");

    }

    @Override
    public void loop() {

        //this takes the values from the sticks and assigns them to the variables wee will use to determine the speed each motor will run.
        double y_command = -gamepad1.left_stick_y;
        double x_command = gamepad1.left_stick_x;
        double z_command = gamepad1.right_stick_x;

        //This part of the code takes the values from the sticks and adds and subtracts them together to create the correct values.
        double frontLeftCommand = y_command - x_command + z_command;
        double frontRightCommand = y_command + x_command - z_command;
        double backLeftCommand = y_command + x_command + z_command;
        double backRightCommand = y_command - x_command - z_command;

        //this makes it so all values are within the motors range (-1 to 1)
        double max = Math.max(1,frontLeftCommand);
        max = Math.max(max,frontRightCommand);
        max = Math.max(max,backLeftCommand);
        max = Math.max(max,backRightCommand);

        frontLeftCommand = frontLeftCommand/max;
        frontRightCommand = frontRightCommand/max;
        backLeftCommand = backLeftCommand/max;
        backRightCommand = backRightCommand/max;

        //This sets the power to the correct speed that you defined above
        frontLeft.setPower(frontLeftCommand);
        frontRight.setPower(frontRightCommand);
        backLeft.setPower(backLeftCommand);
        backRight.setPower(backRightCommand);


        //Arm code
        double armCommand = -gamepad2.left_stick_y;
        double wristCommand =-gamepad2.right_stick_y;

        arm.setPower(armCommand);
        wrist.setPower(wristCommand);

        //this says "if you press a the claw opens" and "if you press b the claw closes."
        if (gamepad2.a) {
            claw.setPosition(clawOpen);
        }

        if (gamepad2.b) {
            claw.setPosition(clawClosed);
        }

        //this is the code to control the arm
        if (gamepad2.dpad_up) {
            arm.setPower(0.5);
        }else if (gamepad2.dpad_down) {
            arm.setPower(-0.2);
        }else {
            arm.setPower(0);
        }


        //Telemetry code,
        telemetry.addData("frontLeft", frontLeft.getCurrentPosition());
        telemetry.addData("frontRight", frontRight.getCurrentPosition());
        telemetry.addData("backLeft", backLeft.getCurrentPosition());
        telemetry.addData("backRight", backRight.getCurrentPosition());
        telemetry.addData("arm", arm.getCurrentPosition());
        telemetry.addData("wrist", wrist.getCurrentPosition());
        telemetry.update();


    }
}
