package com.manduo;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

/**
 * Created by manduo dong on 10/10/16.
 *
 */
public class LightsController {
    void Off(int[] IDs) throws JSONException{
        JSONObject json = new JSONObject();
        json.put("on", false);
        call(IDs, json);
    }

    void On(int[] IDs) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("on", true);
        call(IDs, json);
    }

    void setColor(int[] IDs, int color) throws JSONException {
        setColor(IDs, color, 254, 254);
    }

    void setColor(int[] IDs, int color, int saturation, int bright) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("on", true);
        json.put("hue", color);
        json.put("sat", saturation);
        json.put("bri", bright);
        call(IDs, json);
    }

    void setColor(int[] IDs, double x, double y, int saturation, int bright) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("on", true);
        json.put("xy", new double[] {x, y});
        json.put("sat", saturation);
        json.put("bri", bright);
        call(IDs, json);
    }

    void setColor(int[] IDs, double x, double y) throws JSONException {
        setColor(IDs, x, y, 254, 254);
    }

    void setBri(int[] IDs, int bri) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("on", true);
        json.put("bri", bri);
        call(IDs, json);
    }

    void blink(int[] IDs, int color, int times, long delay) throws JSONException, InterruptedException {
        for (int i = 1; i <= times; i++) {
            setColor(IDs, color);
            Thread.sleep(delay);
            Off(IDs);
            Thread.sleep(delay);
        }
    }

    void blink(int[] IDs, double x, double y, int times, long delay1, long delay2) throws JSONException, InterruptedException {
        for (int i = 1; i <= times; i++) {
            setColor(IDs, x, y);
            Thread.sleep(delay1);
            Off(IDs);
            Thread.sleep(delay2);
        }
    }

    void colorTransition(int[] IDs, double x, double y, double new_x, double new_y, long total, long delay) throws JSONException, InterruptedException {
        for(long i = delay; i <= total; i += delay) {
            setColor(IDs, Double.parseDouble(new DecimalFormat("#.####").format((x * (total - i) + new_x * i)/total)),
                    Double.parseDouble(new DecimalFormat("#.####").format((y * (total - i) + new_y * i) / total)));
            Thread.sleep(delay);
        }
    }

    void briChange(int[] IDs, int times, long delay, int initial, int amount) throws JSONException, InterruptedException {
        int temp = initial;
        for (int i = 1; i <= times; i++) {
            setBri(IDs, temp);
            temp -= amount;
            Thread.sleep(delay);
        }
    }

    void pureBlink(int[] IDs, long delays, int times) throws InterruptedException {
        try {
            for (int i = 1; i <= times; i++) {
                On(IDs);
                Thread.sleep(delays);
                Off(IDs);
                Thread.sleep(delays);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void call(int[] IDs, JSONObject json)
    {
        APIRequest apiRequest = new APIRequest(IDs, json);
        apiRequest.call();
    }
}
