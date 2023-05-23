package org.lakers.service;

import com.lakers.anno.ElapsedTime;
import org.springframework.stereotype.Component;

/**
 * Created on 2023/3/21 14:46
 *
 * @author lakers
 */
@Component
//@ElapsedTime
public class ElapsedTimeService {

    @ElapsedTime
    public void testA() {
        try {
            System.out.println("testA方法");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void testB() {
        try {
            System.out.println("testB方法");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
