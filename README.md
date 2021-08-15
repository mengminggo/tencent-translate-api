
# 一个简单的腾讯云机器翻译接口api
## 使用方法
   调用：http://ip/translate?source=zh&sourceText=你好&target=en&targetText=
   
   结果: Hello
### 本项目使用三层结构
   control：提供访问接口
   
   service: 实现业务逻辑
   
   dao：简单封装了tencent-api
