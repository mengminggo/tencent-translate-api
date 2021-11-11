
##  一个简单的腾讯云机器翻译接口api
## 使用方法
   参数：source 待翻译语言代码
   
         sourceText 待翻译的单词或句子
         
         target 译文语言代码
         
         targetText 译文，需设置为null
         
   调用：http://ip:port/translate?source=zh&sourceText=你好&target=en&targetText=
   
   结果: Hello
### 项目结构src/main:

   java/cn/buulog/fanyi/pojo: 有一个Word类，包含上述参数。
   
   java/cn/buulog/fanyi/control：提供访问接口，使用http协议，获取get/post参数
   
   java/cn/buulog/fanyi/service: 转换 Word 与 译文
   
   java/cn/buulog/fanyi/dao：简单封装将Word拆分参数，与tencent-api进行交互，获取Word结果
   
   resources:
   
      applicaton.yml用于port信息，springboot相关配置
      
      tencent-api.properties: 配置tecent-api相关参数，秘钥
      
      language.code: 包含可接收的语言代码，可翻译的语言代码
