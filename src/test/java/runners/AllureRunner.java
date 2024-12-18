package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features", // Feature dosyalarının yolu
        glue = "stepdefinitions",                // Step Definitions'ın yolu
        plugin = {
                "pretty",                         // Konsolda okunabilir loglar
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure raporları için plugin
        },
        monochrome = true,                         // Konsol çıktısını daha okunabilir hale getirir
        tags = "@Allure"                           // Yalnızca belirtilen etiketli senaryolar çalıştırılır
)
public class AllureRunner {

}