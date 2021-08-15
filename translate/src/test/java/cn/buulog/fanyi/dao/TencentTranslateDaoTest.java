package cn.buulog.fanyi.dao;

import cn.buulog.fanyi.pojo.Word;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TencentTranslateDaoTest {


    @Test
    void translate() throws Exception {
        TencentTranslateDao tencentTranslateDao = new TencentTranslateDao();
        Word word = new Word();
        word.setSource("en");
        word.setSourceText("apple");
        word.setTarget("zh");
        System.out.println(tencentTranslateDao.Translate(word));
    }

    @Test
    void tt() {
        JSONObject json = new JSONObject();
        /*String params = "{\"ProjectId\":0,\"UntranslatedText\":\"0\",";
        params = params + "\"SourceText\":\"" + word.getSourceText() + "\",\"Source\":" + word.getSource() + ",\"Target\":" + word.getTarget() + "}";
*/
        json.put("ProjectID", 0);
        json.put("UntranslatedText",0);
        json.put("SourceText","a");
        System.out.println(json.toJSONString());
    }
}