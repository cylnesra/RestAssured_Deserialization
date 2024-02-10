package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public int successfulStatusCode = 200;

    public Map requestBodyMapCreate(){

        Map<String,Object> reqBodyMap = new HashMap<>();

        reqBodyMap.put("title","Json");
        reqBodyMap.put("body","Hi");
        reqBodyMap.put("userId",10.0);
        reqBodyMap.put("id",70.0);

      return reqBodyMap;

    }
}
