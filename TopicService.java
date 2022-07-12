package com.example.task_11_07.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.task_11_07.model.Topic;

@Service
public class TopicService {

	List <Topic> topicList =  new ArrayList<>( Arrays.asList(new Topic("123","Topic 1 ","Topic description 1"),
			new Topic("456","Topic 2","Topic description 2")));
	public List<Topic> gelAllService() {
		return topicList;
	}

	public Topic getTopic(String id) {
		return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicList.add(topic);

	}
	public void updateTopic(Topic topic, String id) {
		for(int i=0;i<topicList.size();i++) {
			Topic t = topicList.get(i);
			if(t.getId().equals(id)) {
				topicList.set(i, topic);
			}
		}
		
	}

	public void deleteTopic(String id) {
		topicList.removeIf(t -> t.getId().equals(id));
		
	}

}
