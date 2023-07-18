package com.svt.task;


import com.svt.common.MailUtil;
import com.svt.controller.Local;
import com.svt.entity.ToolAlive;
import com.svt.service.MegapolisServ;
import com.svt.service.SvDataServ;
import com.svt.service.SwitchServ;
import com.svt.service.ZukServ;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.svt.common.SVUtil.tabletOnLan;

@Component
public class Schedule {
    @Autowired
    MegapolisServ megapolisServ;
    @Autowired
    SvDataServ svDataServ;
    @Autowired
    ZukServ zukServ;
    @Autowired
    SwitchServ switchServ;

    private static final Logger log = LogManager.getLogger("common");

//    @Autowired
//    public Schedule(SwitchServ switchServ, MegapolisServ megapolisServ, SvDataServ svDataServ, ZukServ zukServ) {
//        this.megapolisServ = megapolisServ;
//        this.svDataServ = svDataServ;
//        this.zukServ = zukServ;
//        this.switchServ = switchServ;
//    }

    @Scheduled(cron = "0 1 1 * * ?") // 每天01:01执行
    public void job1() {
        try {
            svDataServ.syncDb();
            log.error("syncDb success");
        } catch (Exception e) {
            log.error("syncDb has error " + e.getMessage());
        }
    }

    @Scheduled(cron = "0 0/10 * * * ?") // 间隔10分钟执行
    public void job2() {
        try {
            if (!switchServ.getCheckRunning()) {
                return;
            }
            if (switchServ.checkGiftSending()) {
                log.info("i'm running");
                return;
            }
            String ids = megapolisServ.getUnsentDay();
            if (switchServ.checkRemainSim(ids)) {
                new Local().os_reboot();
                log.info("reboot");
            }
        } catch (Exception e) {
            log.error("check sending has error " + e.getMessage());
        }
    }

    @Scheduled(cron = "0 1 0 * * ?") // 每天00:01执行
    public void job3() {
        try {
            if (switchServ.getWakeUpTablet()) {
                tabletOnLan("0862664c59cb");
                log.info("Start PC");
            }
        } catch (Exception e) {
            log.info("Start PC has error " + e.getMessage());
        }
    }

    @Scheduled(cron = "0 0/15 * * * ?") // 间隔15分钟执行
    public void job4() {
        try {
            if (!switchServ.getCheckZuk()) {
                return;
            }
            if (System.currentTimeMillis() / 1000 - Long.parseLong(zukServ.getToolHeart(new ToolAlive("com.sv.mp.shc", "SV", "1", ""))) > 900) {
                MailUtil.sendEmail("Zuk停止了", "Zuk停止了");
            }
        } catch (Exception e) {
            log.error("getToolAlive has error " + e.getMessage());
        }
    }
}