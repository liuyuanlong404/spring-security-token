package org.lakers;

import org.junit.jupiter.api.Test;
import org.lakers.domain.User;
import org.lakers.service.UserService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2023/2/27 11:30
 *
 * @author lakers
 */
@SpringBootTest
public class DigestStarterTest {


    @Resource
    private UserService userService;

    List<User> userList = Collections.synchronizedList(new ArrayList<>());

    @SuppressWarnings("unused")
    @Test
    public void digestTest() {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Task1 task1 = new Task1();
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(task1, threadPool);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(task1, threadPool);
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(task1, threadPool);
        CompletableFuture<Void> future4 = CompletableFuture.runAsync(task1, threadPool);
        CompletableFuture<Void> future5 = CompletableFuture.runAsync(task1, threadPool);
        CompletableFuture.allOf(future1, future2, future3, future4, future5).join();

        userService.saveBatch(userList);
    }

    public class Task1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                User user = new User();
                user.setUserName("Lakers");
                user.setEmail("111@qq.com");
                user.setAvatar("111111sfdasfd");
                user.setDelFlag(2);
                user.setSex("nan");
                user.setCreateTime(LocalDateTime.now());
                user.setCreateBy(2L);
                user.setUserType("huiyuan");
                user.setPhoneNumber("1787878787787");
                userList.add(user);
            }
            System.out.println("添加结束" + userList.size());
        }
    }
}
