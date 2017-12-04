package com.minipa.sbd.rabbitmq.rabbitmq;

import com.minipa.sbd.rabbitmq.rabbit.many.MiniSender1;
import com.minipa.sbd.rabbitmq.rabbit.many.MiniSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {

	@Autowired
	private MiniSender1 miniSender1;

	@Autowired
	private MiniSender2 miniSender2;

  /**
   * 1对多测试
   * @throws Exception
   */
  @Test
	public void oneToMany() throws Exception {
		for (int i=0;i<100;i++){
			miniSender1.send(i);
		}
	}

  /**
   * 多对多测试
   * @throws Exception
   */
  @Test
	public void manyToMany() throws Exception {
		for (int i=0;i<100;i++){
			miniSender1.send(i);
			miniSender2.send(i);
		}
	}

}