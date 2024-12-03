/*
 * PageController.java
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
 * Created: 11/4/2024
 */
package net.factor3.ai.server.serverai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
  * PageController --<br>
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
@Controller
public class PageController 
{
    /*
     * ChatController.indexDisplay --<br>
     *
     * CHANGE HISTORY:
     * ---------------
     * Created: November 4, 2024
     */
    /**
     * <p>
     * </p>
     *
     * @param
     * @return
     */
    @GetMapping("/")
    public String indexDisplay()
    {
        return("/index.html");
    }
}
