package io.javabrains.springbootstarter.topics;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topics> topicsList= new ArrayList<>(Arrays.asList(
            new Topics( "Spring","Spring Framework","Spring Framework Desc"),
            new Topics( "Java","My Java","Java Spring Framework Desc")

            ));

    public List<Topics> getTopics() {
        return topicsList;
    }

    public Topics getTopic ( String id){
        return topicsList.stream().filter(t-> t.getId().equals(id)).findFirst().get();

    }

    public void addTopic(Topics topic){
        topicsList.add(topic);
    }
    public  void updateTopic(Topics topic,String id){

        for(int i=0;i<topicsList.size();i++){

            Topics t  = topicsList.get(i);

            if(t.getId().equals(id)){
                topicsList.set(i,topic);
                return;
            }else{
                System.out.println(t.getId());
            }
        }
    }
   public void deleteTopic(String  id){
        topicsList.removeIf(topics -> topics.getId().equals(id));
   }

}
