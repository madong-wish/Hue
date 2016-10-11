package com.manduo;

import org.json.JSONException;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        LightsController lightsController = new LightsController();

        MediaPlayerUtil mediaPlayer = new MediaPlayerUtil();
        Thread.sleep(2750);
        new Thread(() -> mediaPlayer.play("File", "data/taste_the_feeling.mp3")).start();

        TimeUnit.MILLISECONDS.sleep(180);
        //Thread.sleep(210);
        //lightsController.On(new int[] {3}); //, 5, 6, 7, 8});

        //TODO 6. Desk Top
        new Thread(() -> {
            try {
                lightsController.blink(new int[]{6, 7, 8}, 0, 15, 265);
                lightsController.On(new int[]{6});
                Thread.sleep(5000);
                lightsController.blink(new int[]{1, 6}, 0, 12, 265);
                Thread.sleep(15500);
                lightsController.setColor(new int[]{6}, 0.5562,0.4084);
                lightsController.pureBlink(new int[]{6}, 265, 11);
                lightsController.setColor(new int[]{3}, 0.5562,0.4084);
                lightsController.pureBlink(new int[]{3, 6}, 265, 11);
                lightsController.setColor(new int[]{1}, 0.5488,0.3112);
                lightsController.pureBlink(new int[]{1, 3, 6}, 265, 11);
                lightsController.setColor(new int[]{5}, 0.2437,0.0895);
                lightsController.pureBlink(new int[]{1, 3, 5, 6}, 265, 14);
                Thread.sleep(2500);
                lightsController.setColor(new int[]{3}, 0.674,0.322);
                Thread.sleep(1050);
                lightsController.setColor(new int[]{1}, 0.674,0.322);
                Thread.sleep(1050);
                lightsController.setColor(new int[]{5}, 0.674,0.322);
                Thread.sleep(1050);
                lightsController.setColor(new int[]{6}, 0.674,0.322);

                lightsController.colorTransition(new int[]{1,3,5,6,7,8}, 0.674,0.322, 0.251,0.1056, 1200, 200);
                Thread.sleep(50);
                lightsController.colorTransition(new int[]{1,3,5,7,8}, 0.251,0.1056, 0.5562,0.4084, 1200, 200);
                Thread.sleep(50);
                lightsController.colorTransition(new int[]{1,3,6,7,8}, 0.5562,0.4084, 0.3882,0.4777, 1200, 200);
                Thread.sleep(50);
                lightsController.colorTransition(new int[]{3,5,6,7,8}, 0.3882, 0.4777, 0.4682, 0.2452, 1200, 200);
                Thread.sleep(50);
                lightsController.colorTransition(new int[]{1,3,5,6,7,8}, 0.4682, 0.2452, 0.408,0.517, 1200, 200);

                lightsController.blink(new int[]{1,3,5,6,7,8}, 0.408,0.517,5,270,270);

                new Thread(() -> {
                    try {
                        lightsController.blink(new int[]{1,3,6}, 0.3882, 0.4777, 5 , 270, 270);
                        lightsController.blink(new int[]{1,3,6}, 0.5562,0.4084, 5 , 270, 270);
                        lightsController.blink(new int[]{1,3,6}, 0.251,0.1056, 5 , 270, 270);
                    } catch (JSONException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
                lightsController.blink(new int[]{5,7,8}, 0.4682, 0.2452, 5 , 270, 270);
                lightsController.blink(new int[]{5,7,8}, 0.3882, 0.4777, 5 , 270, 270);
                lightsController.blink(new int[]{5,7,8}, 0.5562, 0.4084, 5 , 270, 270);




            } catch (JSONException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //TODO 7. Strip
//        new Thread(() -> {
//            try {
//                Thread.sleep(20000);
//                lightsController.blink(new int[]{7}, 0.4871,0.4618, 10, 150, 150);
//
//
//            } catch (InterruptedException | JSONException e) {
//                e.printStackTrace();
//            }
//        }).start();


//        Thread.sleep(2900);

        //TODO 5.DESK light
        new Thread(() -> {
            try {
                Thread.sleep(2700);
                lightsController.blink(new int[]{1}, 0.5763, 0.3486, 5, 265, 265);
                lightsController.blink(new int[]{1, 5}, 0.5763, 0.3486, 11, 265, 265);
                lightsController.colorTransition(new int[]{5}, 0.5763, 0.3486, 0.408, 0.517, 2000, 265);
                Thread.sleep(5700);
                lightsController.briChange(new int[]{5}, 5, 270, 230, 40);
                lightsController.Off(new int[]{1, 5});
            } catch (JSONException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        //TODO bedroom lamp
        new Thread(() -> {
            try {
                lightsController.Off(new int[]{1, 3, 5, 7, 8});
                Thread.sleep(8000);
                lightsController.blink(new int[]{3}, 0.5763, 0.3486, 9, 280, 280);
                lightsController.setColor(new int[]{3}, 0.408, 0.517, 240, 240);
                Thread.sleep(7500);
                lightsController.briChange(new int[]{3}, 5, 270, 230, 40);
                lightsController.Off(new int[]{3});
                lightsController.blink(new int[]{7, 8}, 0.4871,0.4618, 7, 240, 300);
                Thread.sleep(140);
                lightsController.colorTransition(new int[]{1,3,5,6,8}, 0.674,0.322, 0.4859,0.4599, 1200, 200);
                Thread.sleep(50);
                lightsController.colorTransition(new int[]{1,3,5,6,8}, 0.4859,0.4599, 0.408,0.517, 1200, 200);
                Thread.sleep(50);
                lightsController.colorTransition(new int[]{1,3,5,6,8}, 0.408,0.517, 0.2206,0.1484, 1200, 200);
                Thread.sleep(50);
                lightsController.colorTransition(new int[]{1,3,5,6,8}, 0.2206,0.1484, 0.3833,0.1591, 1200, 200);
                Thread.sleep(50);
                lightsController.colorTransition(new int[]{1,3,5,6,8}, 0.3833,0.1591, 0.674,0.322, 1200, 200);

            } catch (JSONException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
