package com.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// bdd with data provider and excel sheet 

@RunWith(Cucumber.class)                           // asking runner to run with cucumber
@CucumberOptions(                                  // runner needs which files to run
		features = "src/main/java/com/feature",    // giving feature file folder as address
		glue = "com.Stepdefination",               // giving address of step defination
		plugin = "html:target",                    // where to save report in which format
	    dryRun = false,
	    monochrome = true,
	    tags={"@test1, @test2"}
		
		)

public class TestRunner {

}
