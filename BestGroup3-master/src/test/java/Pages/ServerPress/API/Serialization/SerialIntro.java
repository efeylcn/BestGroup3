package Pages.ServerPress.API.Serialization;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SerialIntro {


    @Test
    public void serializeStudent() throws IOException {

        Student student1 = new Student("John","Smith",001,17,'M');

        ObjectMapper objectMapper = new ObjectMapper();
       // objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);
        objectMapper.writeValue(new File("src\\test\\java\\API\\Serialization\\Student.json"), student1);
    }

    @Test
    public void statics() throws IOException {
        pojoStatics pojoStatics1= new pojoStatics("jan","Kyrgyz",26,"left Winger",
                10000,"Arsenal",99);
        ObjectMapper objectMapper = new ObjectMapper();
        // objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);
        objectMapper.writeValue(new File("src\\test\\java\\API\\Serialization\\statics.json"), pojoStatics1);


        String staticsJson = objectMapper.writeValueAsString(pojoStatics1);
        System.out.println(staticsJson);
    }



}
