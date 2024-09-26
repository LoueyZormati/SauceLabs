package utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.Collections;

public class GenerateReport {
    public static void main(String[] args) {
        File reportOutputDirectory = new File("target/cucumber-reports");
        java.util.List<String> jsonFiles = Collections.singletonList("target/cucumber-reports/Cucumber.json");

        Configuration configuration = new Configuration(reportOutputDirectory, "SauceLabs");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}

