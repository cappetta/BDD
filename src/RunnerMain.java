

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import util.sharedData;
import util.general.tools;
import Runner.TestRunner;

public class RunnerMain {

	public static void main(String[] args) {
		System.out.println("---------- STARTING before testing ---------------------------------------");
		System.out.println("browserUnderTest :" + util.sharedData.browserUnderTest + ":");
		System.out.println("util.sharedData.URLUnderTest : " + util.sharedData.URLUnderTest);
		System.out.println("pomSheetInstance : " + sharedData.pomSheetInstance);
		System.out.println("autPosition : " + sharedData.autPosition);
		System.out.println("---------- STARTING Testing---------------------------------------");
		try {
			Result result = JUnitCore.runClasses(TestRunner.class);
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
			System.out.println(result.wasSuccessful());

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		System.out.println("From Main : " + util.general.tools.copyFile(sharedData.parentReportDir + sharedData.jsonReportName, sharedData.backupReportDir, true));
		List<String> jsonFiles = new ArrayList<String>();
//		reportFiles.add(util.general.tools.copyFile(sharedData.parentReportDir + sharedData.jsonReportName, sharedData.backupReportDir, true));
		jsonFiles.add(sharedData.parentReportDir + sharedData.jsonReportName);
		String message = util.general.ReportUtil.generateJSONReport( jsonFiles );
		System.out.println("-------------------------------------------------");
		System.out.println("parent Report Dir: " + sharedData.parentReportDir);
		System.out.println("json files : " + message );
		System.out.println("-------------------------------------------------");

	}
	
	
}
