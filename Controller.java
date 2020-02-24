package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    @FXML
    Circle circle;
    Timer timer;
    boolean stage1 = false;
    boolean stage2 = false;
    boolean stage3 = false;
    boolean stage4 = false;

    @FXML
    public void start() {
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (stage1) {
                        if (stage2) {
                            if (stage3) {
                                if (stage4) {
                                    timer.cancel();
                                } else {
                                    if (circle.getLayoutX() != 75 && circle.getLayoutY() != 925) {
                                        circle.setLayoutY(circle.getLayoutY() + 1);
                                        circle.setLayoutX(circle.getLayoutX() - 1);
                                    } else {
                                        stage4 = true;
                                        circle.setFill(Color.DODGERBLUE);
                                    }
                                }
                            } else {
                                if (circle.getLayoutX() != 925) {
                                    circle.setLayoutX(circle.getLayoutX() + 1);
                                } else {
                                    stage3 = true;
                                    circle.setFill(Color.CYAN);
                                }
                            }
                        } else {
                            if (circle.getLayoutX() != 75 && circle.getLayoutY() != 75) {
                                circle.setLayoutY(circle.getLayoutY() - 1);
                                circle.setLayoutX(circle.getLayoutX() - 1);
                            } else {
                                stage2 = true;
                                circle.setFill(Color.RED);
                            }
                        }
                    } else {
                        if (circle.getLayoutX() != 925) {
                            circle.setLayoutX(circle.getLayoutX() + 1);
                        } else {
                            stage1 = true;
                            circle.setFill(Color.YELLOW);
                        }
                    }
                });
            }
        }, 0, 1);
    }
}
