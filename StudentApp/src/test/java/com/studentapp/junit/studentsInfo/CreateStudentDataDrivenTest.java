package com.studentapp.junit.studentsInfo;

import java.util.ArrayList;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.TestBase;

@Concurrent
@UseTestDataFrom("testdata/studentsinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentDataDrivenTest extends TestBase{
	private String firstName;
	private String lastName;
	private String email;
	private String programme;
	private String courses;
	
	/*public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}*/

	@Steps
	StudentSerenitySteps steps;
	
	@Title("Datadriven test for creating multiple students")
	@Test
	public void createMultipleStudents(){
		ArrayList<String> course = new ArrayList<String>();
		course.add(courses);
		steps.createStudent(firstName, lastName, email, programme, course);
	}

}
