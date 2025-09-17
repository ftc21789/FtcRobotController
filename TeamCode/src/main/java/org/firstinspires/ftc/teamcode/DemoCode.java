package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class DemoCode extends LinearOpMode {
    private Auton auton = new Auton();
    @Override
    public void runOpMode() throws InterruptedException {
        auton.init(this);

        auton.turnRight(360, 1);
        auton.left(12,1);
        auton.turnLeft(360, 1);
        auton.right(12,1);
        auton.turnRight(360,1);
        auton.forward(12,.75);
        auton.turnRight(360,1);
        auton.backward(12,.75);
        auton.turnRight(360,1);

    }
}
