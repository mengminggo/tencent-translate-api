package cn.buulog.fanyi.service;

import cn.buulog.fanyi.pojo.Word;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class TranslateServiceTest {
    @Autowired
    TranslateService translateService;
    @Test
    void getTranslateTarget() throws Exception {
        Word word = new Word();
        word.setSource("en");
        word.setSourceText("apple");
        word.setTarget("zh");
        System.out.println(translateService.getTranslateTarget(word));
    }
}