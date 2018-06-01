package cn.com.vector.service;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.com.vector.SpringUtil;
import cn.com.vector.play.entity.War;
import cn.com.vector.play.service.WarService;
import cn.com.vector.play.util.ServiceResult;


public class WarServiceTest {
	WarService warService = SpringUtil.warService;

/*	@Test
	public void createWarTest() {
		War war = new War();
		war.setTxHash("0x2bdbdfcf59b661a77dc1252f45db62ed1195d8a7baf26e75476db6bd2239857e2");
		war.setAwardUser("0x339177a6a2b21a8b7ce76811c86d3a2c99301355");
		war.setCardId("123123");
		war.setCardHash("0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef");
		war.setStatusCard(1);
		war.setTokenCount(4);
		war.setTokenHash("0x7aab8c0bd3d4afd47e471ac30c0c2df7e1cefe87cd3d42a5715341597b094d1c");
		war.setStatusDdc(1);
		ServiceResult res = warService.createWar(war, "add");
		System.out.println(JSON.toJSON(res));
	}
	
	@Test
	public void selectByTxHash() {
		War war = warService.selectByTxHash("0x2bdbdfcf59b661a77dc1252f45db62ed1195d8a7baf26e75476db6bd2239857e1");
		System.out.println(JSON.toJSON(war));
	}*/
	
	@Test
	public void selectByAwardUser() {
		War war = warService.selectByAwardUser("0x339177a6a2b21a8b7ce76811c86d3a2c99301355");
		System.out.println(JSON.toJSON(war));
	}
}
