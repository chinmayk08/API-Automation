package Tests;

import Base.TestBase;
import TestData.data;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class APITest extends TestBase {

    public static final Logger logger= LogManager.getLogger(APITest.class);

    @Severity(SeverityLevel.NORMAL)
    @Description("check user created")
    @Test(alwaysRun = true, priority = 1)
    public void createUserWithTestData() {
        String name = data.getUserName();
        String job = data.getUserJob();

        TestBase.createuser();
        System.out.println(Response);
        Assert.assertEquals(RS1, name);
        Assert.assertEquals(RS2, job);
        logger.info("createUserWithTestData test case passed successfully");

    }
}

