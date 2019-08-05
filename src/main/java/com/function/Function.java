package com.function;

import com.microsoft.azure.serverless.functions.annotation.*;

import java.util.Map;

import javax.tools.JavaFileObject;

import com.microsoft.azure.serverless.functions.ExecutionContext;
import com.microsoft.azure.serverless.functions.HttpRequestMessage;
import com.microsoft.azure.serverless.functions.HttpResponseMessage;

/**
 * Hello function with HTTP Trigger.
 */
public class Function {
    @FunctionName("hello")
    public HttpResponseMessage hello(@HttpTrigger(name = "req", methods = {"get", "post"}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage req,
                        ExecutionContext context) {
        

        context.getLogger().info("hello was invoked");
        Map<String, String> headers = req.getHeaders();
        Object body = req.getBody();
        String originText = "";

        String contentType = (String) headers.get("content-type");
        
        // how to check contentType
        /*
        switch (contentType) {
            case "application/json":
                //originText = getTextFromJSon((LinkedHashMap) body);
                break;
            case "text/plain":
                originText = (String) body;
                break;
            default:
                break;
        }*/

        //String jsonBody = createJSonMessage(originText,...);

        HttpResponseMessage response = req.createResponse(200, "hello jerry");

        return response;
        
    }
}
