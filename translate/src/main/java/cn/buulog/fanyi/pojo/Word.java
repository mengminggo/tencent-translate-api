package cn.buulog.fanyi.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Word
 * @Description:
 * @Author: mengminggo
 * @Github: github.com/mengminggo
 * @Date: 2020/10/20  20:24
 **/
@Data
@Component
public class Word {
    private String source;
    private String sourceText;
    private String target;
    private String targetText;

    public Word() {

    }

    public Word(String source, String sourceText, String target) {
        this.source = source;
        this.sourceText = sourceText;
        this.target = target;
    }
}
