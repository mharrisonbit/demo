package com.example.demo.topics;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

  private List<Topic> topics = new ArrayList<>(Arrays.asList(
      new Topic("test 1", "new test 1", "more testing 1"),
      new Topic("test 2", "new test 2", "more testing 2"),
      new Topic("test 3", "new test 3", "more testing 3"),
      new Topic("test 4", "new test 4", "more testing 4")
  ));



  public List<Topic> getAllTopics(){
    return topics;
  }

  public Topic getTopic(String id){
    return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
  }

  public void addTopic(Topic topic) {
    topics.add(topic);
  }

  public void updateTopic(String id, Topic topic) {
    for (int z = 0; z < topics.size(); z++) {
      Topic t = topics.get(z);
      if (t.getId().equals(id)){
        topics.set(z, topic);
        return;
      }
    }
  }

  public void deleteTopic(String id) {
    topics.removeIf(t -> t.getId().equals(id));
  }
}
