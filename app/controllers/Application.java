package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void settings(Date dob, int hours) {
        // String username = Security.connected();
        render();
    }

}