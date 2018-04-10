package com;

import java.util.concurrent.TimeUnit;



public class Main {


    public static void main(String[] args) throws InterruptedException {

        UI app = null;
        LoginDialog loginDialog = null;

        loginDialog = new LoginDialog();
        loginDialog.setVisible(true);
        while(!loginDialog.isReadyToFinish()) {
            TimeUnit.SECONDS.sleep(1);
        }
        if(loginDialog.isLogged()) {
            loginDialog.setVisible(false);
            loginDialog.setEnabled(false);
            app = new UI();
            app.setVisible(true);

            while (app.getrunning()) {
                TimeUnit.SECONDS.sleep(1);
            }
        }
            System.exit(0);

    }
}
