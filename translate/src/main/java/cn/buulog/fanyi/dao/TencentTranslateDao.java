package cn.buulog.fanyi.dao;

import cn.buulog.fanyi.pojo.Word;
import com.alibaba.fastjson.JSONObject;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.tmt.v20180321.TmtClient;
import com.tencentcloudapi.tmt.v20180321.models.TextTranslateRequest;
import com.tencentcloudapi.tmt.v20180321.models.TextTranslateResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class TencentTranslateDao {
    private static TmtClient client = null;

    static {
        //配置各项参数

        InputStream in = TencentTranslateDao.class.getClassLoader().getResourceAsStream("tencent-api.properties");
        Properties p = new Properties();
        try {
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sercretId =p.getProperty("sercretId");
        String sercretKey=p.getProperty("sercretKey");;
        String region=p.getProperty("region");


        Credential cred = new Credential(sercretId, sercretKey);
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("tmt.tencentcloudapi.com");
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        client = new TmtClient(cred, region, clientProfile);
    }

    public Word Translate(Word word) throws Exception {
        /* String params = "{\"ProjectId\":0,\"UntranslatedText\":\"0\",";
        params = params + "\"SourceText\":\"" + word.getSourceText() + "\",\"Source\":" + word.getSource() + ",\"Target\":" + word.getTarget() + "}";
       */
        /*将word数据局封装到json*/
        JSONObject json = new JSONObject();
        json.put("ProjectId", 0);
        json.put("UntranslatedText", 0);
        json.put("SourceText", word.getSourceText());
        json.put("Source", word.getSource());
        json.put("Target", word.getTarget());
        TextTranslateRequest req = (TextTranslateRequest) TextTranslateRequest.fromJsonString(json.toJSONString(), TextTranslateRequest.class);
        //访问api获取json结果，包含完整的word信息
        TextTranslateResponse resp = client.TextTranslate(req);
        word.setTargetText(resp.getTargetText());
        //将获取的json结果数据转化为str数据
        /*String targetTextJson = TextTranslateRequest.toJsonString((AbstractModel) resp);*/
        //只需要单个targetText，再次转化成json提取
        /*JSONObject targetObjectJson = JSONObject.parseObject(targetTextJson);
        word.setTargetText(targetObjectJson.getString("TargetText"));*/

        return word;
    }
}