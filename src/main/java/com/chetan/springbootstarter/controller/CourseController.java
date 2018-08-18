package com.chetan.springbootstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chetan.springbootstarter.model.Course;
import com.chetan.springbootstarter.model.Topic;
import com.chetan.springbootstarter.services.CourseServices;

@RestController
@RequestMapping("/springboot/webapi")
public class CourseController {
	
	@Autowired
	private CourseServices courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourse(@PathVariable String id){
		return courseService.getAllCourse(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id){
		return courseService.getCourse(id);
	}
		
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicId}/courses")
	//@PostMapping("/topic")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@PutMapping("/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@DeleteMapping("/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id){
		courseService.removeTopic(id);
	}

}
