package com.yml.com.springlog.facade;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-22
 * Time: 21:02
 */
public class Main {


    public static void main(String[] args) {

          FacadeClient facadeClient=new FacadeClient();
          facadeClient.on();
          facadeClient.off();
    }
}
