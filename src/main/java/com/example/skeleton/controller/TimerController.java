package com.example.skeleton.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.skeleton.common.basicMethod.*;
import com.example.skeleton.common.util.DateUtils;
import com.example.skeleton.common.util.HttpUtil;
import com.example.skeleton.domain.OnlineBugDTO;
import com.example.skeleton.domain.timer.wechat.RequestEntity;
import com.example.skeleton.domain.timer.wechat.RequestMarkdown;
import com.example.skeleton.service.OnlineBugService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author yebing
 */
@RestController
@Api("定时统计BUG数")
@RequestMapping("/timer")
public class TimerController  extends BasicController<OnlineBugService, OnlineBugDTO> {
    @Value("${wechatUrl}")
    private String wechatUrl;
    /**
     * @return
     */
    @GetMapping("/wechatRobot/statisticsBug")
    public Wrapper<?> executeStatisticsBug(){
        return WrapMapper.ok();
    }

    /**
     * 周一至周五17:00执行
     * @return
     */
    @Scheduled(cron = "0 30 09 ? * MON-FRI")
    public Wrapper<?> statisticsBug(){
        /** 数据库查询需要机器人发送的统计BUG数 */
        OnlineBugDTO record = new OnlineBugDTO();
        List<String> statusList = new ArrayList<>();
        statusList.add("new");
        statusList.add("erified");
        statusList.add("in_progress");
        record.setStatusList(statusList);

        Pager pager = new Pager();
        pager.setPage(1);
        pager.setRows(100);
        ExecuteResult<DataUtil<OnlineBugDTO>> executeResult = basicService.selectList(record,pager);

        if(!executeResult.isSuccess()){
            return WrapMapper.error().result(executeResult);
        }
        List<OnlineBugDTO> list = executeResult.getResult().getList();
        if(!CollectionUtils.isEmpty(list) && list.size() != 0){
            /** 构建HTTP请求企业微信接口*/
            String dateTime = DateUtils.getCurrentDate(DateUtils.YDM_DASH);
            StringBuffer contentBuffer = new StringBuffer("### 提醒：<font color=#FFA500>预计交付时间  </font>"+dateTime+" 且未流转至 <font color=#FFA500>待验收</font>的需求\n");
            for (OnlineBugDTO onlineBugDTO : list) {
                contentBuffer.append("<font color=#0099ff size=4 face=\"宋体\">当前处理人："+onlineBugDTO.getCurrentOwner()+
                        "====》["+onlineBugDTO.getTitle()+"]("+onlineBugDTO.getUrl()+")</font>\n");
            }
            RequestMarkdown requestMarkdown = new RequestMarkdown();
            requestMarkdown.setContent(contentBuffer.toString());
            RequestEntity requestEntity = new RequestEntity();
            requestEntity.setMsgtype("markdown");
            requestEntity.setMarkdown(requestMarkdown);
            String param = JSONObject.toJSONString(requestEntity);
            String doPostJSON = HttpUtil.doPostJSON(wechatUrl, new HashMap<>(16), param);
            logger.info("doPostJSON:{}",doPostJSON);
        }
        return WrapMapper.ok().result(executeResult);
    }
}
