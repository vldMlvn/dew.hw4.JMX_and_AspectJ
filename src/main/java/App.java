import mbean.LoggingController;
import transformer.StringTransformer;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("LoggingControl:type=mbean.LoggingController");
        LoggingController loggingController = new LoggingController();
        mBeanServer.registerMBean(loggingController, objectName);

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        StringTransformer transformer = new StringTransformer();

        while (flag) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                flag = false;
            }
            String transformed = transformer.transformString(input);
        }
    }
}