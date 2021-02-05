# Huindata Integration WhHealth Covid19 Sdk
## 介绍
java项目快速整合武汉核酸管理平台封装实现。

## 使用教程
1. 下载代码
2. 使用mvn

### with out spring
```java
AppConfig config = new AppConfig();
config.setApiRoot("http://localhost:9080/"); //武汉核酸检测平台
config.setAppId("5rc6t7vyb8u9nimpo");  //授信应用id
config.setAppSecret("q3zw4xe5cr68vt79by80un9ie5r6ctv7yb8uio"); //授信应用密钥
config.setSysCode("ECARD"); //系统编号
config.setLoginName("ECARD_zhangsan"); //平台登录账号
config.setLoginPwd("123456"); //平台密码
config.setKey("NG7P3TCTHINLHNUS"); //过密sm4加密，密钥由平台分配

ICovid19Service service = new Covid19Service(config);

CYXXRequestBody requestBody = new CYXXRequestBody();  //武汉核酸检测平台的接口中，请求中应该包含了很多固定值（重复使用的值），
                                                      // 建议使用时，使用工厂方法构造本对象以减少代码开发
//TODO : 数据设置
Response r = service.importCYXXResult(requestBody);
```

### with spring
```java
@Bean
@ConfigurationProperties("huindata.integration.whhealth.covid19") //使用zk进行属性注入，或其他
public AppConfing(){
    return new AppConfig();
}

@Bean
public ICovid19Service covid19Service(AppConfig config){
    return new Covid19Service(config)
}
```

### 特殊说明
默认token过期时间为半小时，可在AppConfig中通过tokenExist（单位毫秒）调整token的刷新周期