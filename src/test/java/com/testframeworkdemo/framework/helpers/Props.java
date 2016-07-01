//package com.testframeworkdemo.framework.helpers;
//
//import static java.lang.System.out;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class Props {
//    private static final Logger LOG = LoggerFactory.getLogger(Props.class);
//    private static Properties environmentProps;
//    private static Properties properties;
//
//
//    /**
//     * Gets the key from Config.properties related to chosen profile
//     *
//     * @param key
//     **/
//
//    public static String getProp(String key) {
//        if ((key == null) || key.isEmpty()) {
//            return "";
//        } else {
//            return properties.getProperty(key);
//
//        }
//    }
//
//    public static void loadRunConfigProps(String configPropertyFileLocation) {
//        environmentProps = new Properties();
//        try (InputStream inputStream = Props.class.getResourceAsStream(configPropertyFileLocation)) {
//            environmentProps.load(inputStream);
//            environmentProps.list(out);
//        } catch (IOException e) {
//            LOG.error(e.getMessage());
//        }
//        properties = new Properties();
//        try (InputStream inputStream = Props.class.getResourceAsStream(environmentProps.getProperty("profile.path"))) {
//            properties.load(inputStream);
//            properties.list(out);
//        } catch (IOException e) {
//            LOG.error(e.getMessage());
//        }
//    }
//}
