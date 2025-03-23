/*
 * ChatController.java
 * 
 *                           Written By Robert Brown III
 *                           Factor Three Webworks, LLC
 * 
 * CONFIDENTIALITY NOTICE
 * ----------------------
 * The code in this file is CONFIDENTIAL and is the property of Factor Three
 * Webworks. No one may read, copy, run, or otherwise use this code in any
 * way or using any means, electronic or otherwise, without permission from an
 * authorized agent of Factor Three Webworks, LLC.
 * ------------------------------------------------
 * CHANGE HISTORY:
 * ---------------
 * Created: 10/8/2024
 */
package net.factor3.ai.server.serverai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
  * ChatController --<br>
  *
  * <p>
  * </p>
  *
  * <p>
  * This class has the following methods:
  * </p>
  * <ul>
  * <li></li>
  * </ul>
  */
@RestController
@RequestMapping
public class ChatController 
{
    private static final String MARKDOWN        = " Format your answer using Markdown";
    private final ChatClient chatClient;

    /*
     * ChatController.ChatController --<br>
     *
     * CHANGE HISTORY:
     * ---------------
     * Created: October 8, 2024
     */
    /**
     * <p>
     * </p>
     *
     * @param
     * @return
     */
    public ChatController(ChatClient.Builder theClient)
    {
        chatClient = theClient.build();
    }

    /*
     * ChatController.doChat --<br>
     *
     * CHANGE HISTORY:
     * ---------------
     * Created: October 8, 2024
     */
    /**
     * <p>
     * </p>
     *
     * @param
     * @return
     */
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/chat")
    public String doChat(@RequestParam("theQuery") String theQuery)
    {
        String query = theQuery + MARKDOWN;

        return(chatClient.prompt()
                         .user(query)
                         .call()
                         .content());
    }


    /*
     * ChatController.doStreamChat --<br>
     *
     * CHANGE HISTORY:
     * ---------------
     * Created: October 9, 2024
     */
    /**
     * <p>
     * </p>
     *
     * @param
     * @return
     */
    @GetMapping("/fastchat")
    public Flux<String> doStreamChat(@RequestParam("theQuery") String theQuery)
    {
        String query = theQuery + MARKDOWN;

        return(chatClient.prompt()
                         .user(query)
                         .stream()
                         .content());
    }
}