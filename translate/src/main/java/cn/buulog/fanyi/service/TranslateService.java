package cn.buulog.fanyi.service;

import cn.buulog.fanyi.pojo.Word;
import cn.buulog.fanyi.dao.TencentTranslateDao;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TranslateService
 * @Description:
 * @Author: mengminggo
 * @Github: github.com/mengminggo
 * @Date: 2020/10/20  20:59
 **/
@Service
@NoArgsConstructor
public class TranslateService {

    private static TencentTranslateDao tencentTranslateDao = new TencentTranslateDao();

    public String getTranslateTarget(Word word) throws Exception {
        return getTranslateWord(word).getTargetText();
    }
    public Word getTranslateWord(Word word) throws Exception {
        return tencentTranslateDao.Translate(word);
    }

}
