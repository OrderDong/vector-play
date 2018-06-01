package cn.com.vector.play.controller;

import cn.com.vector.play.entity.War;
import cn.com.vector.play.response.RestResponseCode;
import cn.com.vector.play.response.RestResultModel;
import cn.com.vector.play.service.ContractService;
import cn.com.vector.play.service.WarService;
import cn.com.vector.play.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by liuwd on 2018/5/30.
 */
@Slf4j
@RestController
@RequestMapping("/admin/card")
public class TokenCardController {

    private static  final int CARD_MAX=1000;
    private static final int CARD_MIN=1;
    private static final int TOKEN_MAX=100;
    private static Map<String,String> storeRes = new HashMap<String,String>();
    @Autowired
    private ContractService contractService;
    @Autowired
    private WarService warService;

    @Value("${pro.cardkey}")
    private String cardKey;
    @Value("${pro.cardval}")
    private String cardVal;
    @Value("${pro.tokenkey}")
    private String tokenKey;
    @Value("${pro.tokenval}")
    private String tokenVal;

    //@RequestMapping("/open")
    @PostMapping("/open")
    public RestResultModel openAward(HttpServletRequest request,String txHash,String addr){

        if(StringUtils.isBlank(txHash) || StringUtils.isBlank(addr)){
            return new RestResultModel(RestResponseCode.REQUEST_PARAM_ERROR,"请求参数为空！"+RestResponseCode.REQUEST_PARAM_ERROR,"");
        }
        //TODO 校验addr有效性
        ServiceResult verifyAddrRes = contractService.verifyAddr(addr);
        //TODO 验证是否已发放奖励
        if(StringUtils.isNotEmpty(storeRes.get(txHash)) && storeRes.get(txHash).equals("Y")) {
			return new RestResultModel(RestResponseCode.SUCCESS, RestResponseCode.SUCCESS_DESC, storeRes.get(txHash));
		}
        storeRes.put(txHash, "Y");
        
        //TODO 查询tx的交易有效性，查询事件的有效性
        ServiceResult verifyTransactionRes = contractService.verifyTransaction(txHash, addr);
        if(!ServiceResult.isSuccess(verifyTransactionRes)){
            return new RestResultModel(RestResponseCode.FAILED,"调用服务失败！"+RestResponseCode.FAILED_DESC,"");
        }
        

        //TODO 如果都没有问题，那么开奖，计算获取奖励
        String cardAward = getCardAward(cardKey,cardVal,1);
        String tokenAward = getCardAward(tokenKey,tokenVal,0);
        //TODO 调用服务送奖励
        ServiceResult result = contractService.openAward(txHash,addr,cardAward,tokenAward);
        if(!ServiceResult.isSuccess(result)){
            return new RestResultModel(RestResponseCode.FAILED,"调用服务失败！"+RestResponseCode.FAILED_DESC,"");
        }
        //TODO storeRes 缓存奖励
        storeRes.put(addr,cardAward+","+tokenAward);
        storeRes.remove(txHash);
        return new RestResultModel(RestResponseCode.SUCCESS, RestResponseCode.SUCCESS_DESC, storeRes.get(addr));
    }

    private String getCardAward(String dataKey,String dataVal,int flag){
        String award = "";
        String[] keys = dataKey.split("\\/");
        int max=0;
        if(1 == flag){
            max = CARD_MAX;
        }else{
            max = TOKEN_MAX;
        }
        Random random = new Random();
        int s = random.nextInt(max)%(max-CARD_MIN+1) + CARD_MIN;
        String[] values = dataVal.split("\\/");
        for(int i=0; i<keys.length; i++){
            if(i == 0){
                if(CARD_MIN <= s && s < Integer.parseInt(keys[i])){
                    award = values[i+1];
                    break;
                }
            }
            if(i == keys.length-1){
                if(Integer.parseInt(keys[i]) <= s && s <= max){
                    award = values[i+1];
                    break;
                }
            }
            if(Integer.parseInt(keys[i]) <= s && s <= Integer.parseInt(keys[i+1])){
                award = values[i+1];
                break;
            }
        }
        log.info("open award data,keylength;"+keys.length+",valueLength:"+values.length+",random:"+s+",value:"+award);
        return award;
    }
    /**
     * 开奖结果查询
     * @param request
     * @param account
     * @return
     */
    @RequestMapping("/retdata")
    public RestResultModel openData(HttpServletRequest request,String account){
    	//TODO 校验账户
    	
    	//TODO 获取结果数据，通过账户查询
    	War war = warService.selectByAwardUser(account);
    	
        return new RestResultModel(RestResponseCode.SUCCESS, RestResponseCode.SUCCESS_DESC,JSON.toJSON(war));
    }
    @RequestMapping("/test")
    public RestResultModel test(HttpServletRequest request){
        return new RestResultModel(RestResponseCode.SUCCESS, RestResponseCode.SUCCESS_DESC,null);
    }
}
