import utils.Checker;
import utils.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {
    private static Application instance;
    private String ip;
    private List<String> blackList;

    private Application() {}

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    //Run application.
    public void run() {
        try {
            processing();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Draws Main Menu until the user has entered the phrase "quit".
    private void processing() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Enter IP address or 'quit' to exit");
            ip = bf.readLine();
            ip = ip.trim();

            if (ip.equals("quit")) {
                System.exit(0);
            } else {
                checkIP();
            }
        }
    }

    //Validates IP and checks IP from blacklist.
    private void checkIP() {
        Checker checker = new Checker();
        FileUtils fileUtils = new FileUtils("blacklist.txt");
        blackList = fileUtils.ReadDataFromFile();
        if (!checker.validateIp(ip)) {
            System.out.println("Invalid IP address");
        } else if(!checker.checkFromBL(ip, blackList)){
            System.out.println("Access disallowed");
        } else {
            System.out.println("Access allowed");
        }
    }
}
