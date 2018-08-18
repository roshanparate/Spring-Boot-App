package com.chetan.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chetan.springbootstarter.model.Topic;
import com.chetan.springbootstarter.repository.TopicRepository;

@Service
public class TopicServices {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
		
	}
	
	public Topic getTopic(String id){
		 //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		
	}

	public void removeTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.delete(id);
	}
	
}
