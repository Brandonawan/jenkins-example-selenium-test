package com.planetbrandon.seleniumtest;

import com.planetbrandon.seleniumtest.abstracts.AbstractJenkinsHomepage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JenkinsHomepageTest extends AbstractJenkinsHomepage {
  @BeforeAll
  static void setupClass() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  void setupTest() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    driver = new ChromeDriver(options);
  }
}
