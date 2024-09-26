package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

        Properties prop;



        public ConfigReader( ) {

        }

        public Properties ConfigurationManager() {
            this.prop = new Properties();
            File proFile = new File("src/test/resources/Config/ConfigFile.properties");

            try {
                FileInputStream fis = new FileInputStream(proFile);
                this.prop.load(fis);
            } catch (Throwable var3) {
                var3.printStackTrace();
            }

            return this.prop;
        }

        public String getBrowserName() {
            String browsername = this.prop.getProperty("browsername");
            return browsername;
        }

        public String getUrl() {
            String url = this.prop.getProperty("url");
            return url;
        }

        public String getusername() {
            String email = this.prop.getProperty("username");
            return email;
        }


        public String getPassword() {
            String Password = this.prop.getProperty("Password");
            return Password;
        }



    }


