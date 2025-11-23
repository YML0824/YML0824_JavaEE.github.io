package com.yml.com.springlog.facade;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-22
 * Time: 20:54
 */
public class FacadeClient {

    private  LivingRoomLight livingRoomLight = new LivingRoomLight();
    private HallLight hallLight = new HallLight();
    private BedRoomLight bedRoomLight = new BedRoomLight();
    public void on() {
        livingRoomLight.on();
        hallLight.on();
        bedRoomLight.on();
    }

    public void off() {
        livingRoomLight.off();
        hallLight.off();
        bedRoomLight.off();
    }
}
