package com.example.task_11_07.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.task_11_07.model.Topic;
import com.example.task_11_07.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
//	@RequestMapping("/topics")
//	public String getAllTopics(){
//		return "all Topics";
//		
//	}
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.gelAllService();
	}
	
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method= RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		
	}
	
	@RequestMapping(method= RequestMethod.PUT, value="/topics/{id}")
	public void updateTopics(@RequestBody Topic topic,@PathVariable String id) {
		
		topicService.updateTopic(topic,id);
		
	}
	@RequestMapping(method= RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopics(@PathVariable String id) {
		
		topicService.deleteTopic(id);
		
	}
}
