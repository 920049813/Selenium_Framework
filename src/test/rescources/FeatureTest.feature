#language:zh-CN

功能:测试163登录功能
    测试163登录功能
    @p0  @Automation
    场景: 用正确的账号登录163邮箱
      假如我打开"http://mail.163.com"网站
      当我用"zhoujun_boyan"账号,用"zhoujun123"密码
      当点击登录按钮
      那么登录成功

    @p1  @unAutomation
    场景大纲: 用各种账号登录163邮箱
      假如我打开"http://mail.163.com"网站
      当我用"<email>"账号,用"<password>"密码
      当点击登录按钮
      那么登录成功
      例子:
        | email |password|
        | zhoujun_boyan |zhoujun123|
        | zhoujun_boyan |zhoujun123456|
        | zhoujun_boyan | |
        |  |zhoujun123|
        | zhoujun_boyan |zhoujun123|