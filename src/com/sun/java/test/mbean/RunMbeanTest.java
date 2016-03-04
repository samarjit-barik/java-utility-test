package com.sun.java.test.mbean;


import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;


/**
 * Created by sam on 9/30/15.
 */
public class RunMbeanTest {

    public static void main(String args[])  {

        try {
            MBeanServer ms = ManagementFactory.getPlatformMBeanServer();
            Demo demo = new Demo();
            ObjectName objName = new ObjectName("com.sun.java.test.mbean.xyz:name=xyz");
            ms.registerMBean(demo, objName);

            Thread thread = new Thread(demo);
            thread.start();
        } catch(MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        }
    }

}
