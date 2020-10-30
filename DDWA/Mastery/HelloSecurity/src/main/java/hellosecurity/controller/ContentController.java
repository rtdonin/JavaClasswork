/*
Created by: Margaret Donin
Date created: 10/13/20
Date revised:
*/

package hellosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/content")
    public String displayContentPage() {
        return "content";
    }
}
