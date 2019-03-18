package com.studentapp.junit.studentsInfo;

import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReusableSpecifications;
import com.studentapp.utils.TestUtils;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCRUDTest extends TestBase{
	
	@Steps
	StudentSerenitySteps steps;
	
	static String firstName = "Diti"+TestUtils.getRandomValue();
	static String lastName = "Gogoi"+TestUtils.getRandomValue();
	static String email = "ditipinak11233@gmail.com"+TestUtils.getRandomValue();
	static String programme = "Mathematics";
	static int studentId;
	
	@Title("This test will create a student")
	@Test
	public void test001(){
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Pure");
		courses.add("Applied");
		steps.createStudent(firstName, lastName, email, programme, courses)
		.statusCode(201).spec(ReusableSpecifications.getGenericResponseSpec());
	}
	
	@Title("Verify if the student is added in the application")
	@Test
	public void test002(){
		HashMap<String, Object> value = steps.getStudentsInfoByFirstName(firstName);
		studentId = (int) value.get("id");
		assertThat(value, hasValue(firstName));
	}
	
	@Title("Update the student information and Verify updated information")
	@Test
	public void test003(){
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("Fluid Dynamics");
		courses.add("Astronomy");
		firstName = firstName + "_Updated";
		steps.updateStudentInformation(studentId, firstName, lastName, email, programme, courses);
		
		HashMap<String, Object> value = steps.getStudentsInfoByFirstName(firstName);
		System.out.println("Extracted Value :::"+value);
		assertThat(value,hasValue(firstName));
	}
	
	@Title("This test will delete the student and verify whether student is deleted or not")
	@Test
	public void test004(){
		steps.deleteStudent(studentId);
		steps.getResponseById(studentId).statusCode(404);
		
	}
	
}
