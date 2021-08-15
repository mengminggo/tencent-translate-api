package cn.buulog.fanyi.controller;

import cn.buulog.fanyi.pojo.Word;
import cn.buulog.fanyi.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: TranslateController
 * @Description:
 * @Author: mengminggo
 * @Github: github.com/mengminggo
 * @Date: 2020/10/21  0:10
 **/
@Controller
@RequestMapping("/")
public class TranslateController {
    @Autowired
    TranslateService translateService;

    @ResponseBody
    @RequestMapping("translate")
    public String getTargetText(Word word, Model model) throws Exception {
        return translateService.getTranslateTarget(word);
    }
    @ResponseBody
    @RequestMapping("translatezh")
    public String getTargetText(String zh, Model model) throws Exception {
        Word word = new Word();
        word.setSource("auto");
        word.setSourceText(zh);
        word.setTarget("en");
        return translateService.getTranslateTarget(word);
    }
}
