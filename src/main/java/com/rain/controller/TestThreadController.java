package com.rain.controller;

import com.irdstudio.sdk.beans.core.threadpool.ApplicationThreadPool2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class TestThreadController {



    @RequestMapping(value = "/bpa/start", method = RequestMethod.GET)
    public void startSimpleBpmProcess(@RequestParam("bpaSerialNo") String bpaSerialNo, @RequestParam("bpaId") String bpaId, @RequestParam("batchAction") String batchAction) {

        try {

            MyCallable batchEngine = new MyCallable(batchAction, bpaId, bpaSerialNo);
//            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//            ApplicationThreadPool2 threadPool2 = (ApplicationThreadPool2)context.getBean("applicationThreadPool");
            //batchEngine.start();
           // threadPool2.add(batchEngine);

        } catch(Exception e) {
           e.printStackTrace();
        }

    }
}
