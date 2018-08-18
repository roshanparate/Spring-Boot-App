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

import com.chetan.springbootstarter.model.Topic;
import com.chetan.springbootstarter.services.TopicServices;

@RestController
@RequestMapping("/springboot/webapi")
public class TopicController {
	
	@Autowired
	private TopicServices topicService;
	
	@RequestMapping("/topic")
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable String id){
		return topicService.getTopic(id);
	}
		
	@RequestMapping(method=RequestMethod.POST,value="/topic")
	//@PostMapping("/topic")
	public void addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
	}
	
	@PutMapping("/topic/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
		topicService.updateTopic(id, topic);
	}
	
	@DeleteMapping("/topic/{id}")
	public void deleteTopic(@PathVariable String id){
		topicService.removeTopic(id);
	}

}
