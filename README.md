# Hello struts2

## struts2概述

    ·struts2是一个用来开发MVC应用程序的框架。
     它提供了Web应用程序开发过程中一些常见问题的解决方案：
        -对来自用户的输入数据进行合法性验证
        -统一的布局
        -可扩展想
        -国际化和本地化
        -支持Ajax
        -阻止表单重复提交
        -文件的上传和下载
        ...
        
### struts2 VS struts1

    ·在体系结构方面更优秀
        -类更少，更高效：
            在struts2中无需使用“ActionForm”来封装请求参数
        -扩展更容易：
            struts2通过拦截器完成了框架的大部分工作。
            在struts2中插入一个拦截器对象箱单简单易行。
    ·更容易测试
        -即使不使用浏览器也可以对基于struts2的应用进行测试
        
### 从struts1升级到struts2

    ·struts2从本质上讲已经不是从从struts1扩展而来的，说它是一个换了品牌标签的WebWork更合适
    
    ·从struts1升级到struts2
        -struts1里使用了ActionServlet作为控制器，struts2使用了一个过滤器作为控制器
        -struts1中每个表单都对应一个ActionForm实例，struts2中，HTML表单将被直接映射到一个POJO
        -struts1的验证逻辑编写在ActionForm中，struts2中的验证逻辑编写在Action中
        -struts1中，Action类必须继承org.apache.struts.action.Action类，
         struts2中任何一个POJO都可以是一个Action类
        -struts2在页面里使用OGNL来显示各种对象模型，可以不再使用EL和JSTL
        
### 搭建struts2的环境

    -加入jar包
    -在web.xml文件中配置struts2
        ※复制struts/apps/struts2-blank1/WEB-INF/web.xml中过滤器的配置到当前的web.xml中
    -在当前的web应用的classpath下添加struts2的配置文件struts.xml
        ※记得添加DTD约束以便IDE可以在编写struts.xml时提供自动联想
        
### struts2 VS 传统实现Controller

    1. 需要搭建struts2环境
    2. 不需要显式定义Filter，而是使用struts2的配置文件
    3. detail.jsp比之前变得简单了
        ${requestScope.product.productName} => ${productName}
        
### 示例的工作步骤

    1. 由product-input.action转到/WEB-INF/pages/input.jsp
        ·在struts.xml中配置一个action
            <action name="product-input">
                <result>/WEB-INF/pages/input.jsp</result>
            </action>
             
    2. 由input.jsp页面的action: product-save.action到Product's save，
       再到/WEB-INF/pages/detail.jsp
        ·在Product中定义一个save()方法，且返回值为"detail"
        ·在struts.xml中配置一个action
            <action name="product-save" class="pt.domain.Product" method="save">
                <result name="detail">/WEB-INF/pages/detail.jsp</result>
            </action>

## struts2 Action

### action VS Action类

    1. action： 代表一个struts2的请求，一个action元素就对应一个servletPath
    
    2. Action类： 能够处理struts2请求的类，就称为一个Action类。如：之前的Product
        > 属性名按照JavaBean的命名规则进行，类型可以是任何类型。
          基本类型的转换可以自动进行。
        > 必须有一个无参的构造器。
        > 至少有一个供struts调用的方法。
        > 同一个Action可以包含多个调用方法。
        > struts2会为每一个HTTP请求创建一个Action实例，因而是线程安全的。
        
#### 在Action中访问Web资源

    1. 什么是Web资源？
        > HttpServletRequest, HttpSession, ServletContext等原生的Servlet API
        
    2. 为什么访问Web资源？
        > B/S应用的Controller中，必然存在访问Web资源的需求
            如：向域对象中读写属性、读写Cookie、获取realPath...
        
    3. 如何访问？
        > 1) 和ServletAPI解耦的方式
            特点：只能访问有限的ServletAPI对象的有限的方法（读取请求参数、读写域对象属性、控制Session）
                ·使用ActoinContext
                ·实现XxxAware接口
                
            选用建议：
                若一个Action类中有多个action方法，且多个方法都要使用域对象的Map或Parameters，则建议使用Aware接口的方式
                
            细节：
                Session对应的Map实际上是SessionMap类型的，转型后若调用其invalidate()方法，可以使Session失效

        > 2) 和ServletAPI耦合的方式
            特点：可以访问更多的ServletAPI对象，且可以调用其原生的方法
                ·使用ServletActionContext
                ·实现ServletXxxAware接口
                
#### 和ServletAPI解耦的访问方式
       
    struts2对
        HttpServletRequest
        HttpSession
        ServletContext
    这3个对象进行了封装，构造了3个Map对象来代替它们，
    在Action中可以直接使用这些Map对象来读取和保存数据。
    
    1. 通过ActionContext访问Web资源
    
        ·ActionContext是Action执行的上下文对象，
         在ActionContext中保存了Action执行需要的所有对象
         包括parameters, request, session, application
         
    2. 实装XxxxAware接口
    
        ·实装setXxxx(Map..)方法之后，struts2会在调用action方法时把对应域的对象作为参数传入，
          在方法中记录该对象即可。
          
#### 和ServletAPI耦合的访问方式

    1. 通过ServletActionContext获取对象
        > HttpServletRequest
            ServletActionContext.getRequest()
        > HttpSession
            ServletActionContext.getRequest().getSession()
        > ServletContext
            ServletActionContext.getServletContext()
        
    2. 实装ServletXxxxAware接口
        > HttpServletRequest
            ServletRequstAware => setServletRequest()
        > HttpSession
            ServletRequstAware => setServletRequest()
            使用时从request处获得session对象
        > ServletContext
            ServletContextAware => getServletContext()
        > HttpServletResponse
            ServletResponseAware => setServletResponse()
        
### 配置struts可以受理请求的扩展名

    1. 默认
        struts2-core
            > org.apache.struts2/default.properties
                struts.action.extension=action,,
                
    2. 配置
        <constant name="struts.action.extension" value="action,do"></constant>
        即可设置扩展名为.action和.do的请求由struts受理                
        
### ActionSupport类

    com.opensymphony.xwork2.ActionSupport类是默认的Action类。
        > action节点没有配置class时则执行ActionSupport类
    execute是默认的action执行方法。
        > action节点没有配置method时则呼叫execute()方法
    success是默认的响应结果。
        > result节点没有配置name时则action返回success时被呼出
    
#### ActionSupport继承的几个接口：
    ·Action 几个常量和execute()方法声明
    ·Validateable 用于form字段校验、显示错误消息
    ·ValidationAware 用于form字段校验、显示错误消息
    ·TextProvider 国际化
    ·LocaleProvider 国际化
    
## struts2 result

    1. result是action节点的子节点
    
    2. result代表action方法执行后，可能去的一个目的地
    
    3. 一个action节点可以配置多个result子节点
    
    4. result的name属性对应action方法的一个返回值
    
    5. result的type属性对应下一个页面的呼叫方式，常用的由4种：
        > dispatcher 转发
        > chain 转发到一个Action
            - 通过dispatcher不可以实现chain的功能
        > redirect 重定向
        > redirectAction 重定向到一个Action
            - 通过redirect也可以实现redirectAction的功能
        > stream 输入输出流
        
        ※在struts-default的result-types中定义
        
### 通配符映射

    ·一个Web应用可能由成百上千个action声明。
     可以利用struts提供的通配符映射机制把多个彼此相似的映射关系简化为一个映射关系。
       
    ·通配符映射规则
      - 若找到多个匹配，没有通配符的那个将胜出
      - 若指定的动作不存在，struts将会尝试把这个URI与任何一个包含着通配符*的动作名进行匹配
      - 被通配符匹配到的URI字符串的子串可以用{1}，{2}来引用
      - {0}匹配整个URI
      - 若struts找到的带有通配符的匹配不止一个，则按先后顺序进行匹配
      - *可以匹配零个或多个字符，但不包括/字符。**可以包括/在内。转义使用\
      
### 动态方法调用

    ·通过URI动态调用Action中的方法
    ·action声明：
        <action name="Product" class="pt.action.ProductAction">
     URI:
        /Project/Product.action => 调用execute()方法
        /Project/Product!save.action => 调用save()方法
        
    ·动态方法调用默认处于禁用状态
        struts-core
            > default.properties
                struts.enable.DynamicMethodInvocation=false
                
        > 设置启用：
            <constant name="struts.enable.DynamicMethodInvocation" value="true"></constant>
            
## OGNL

    在struts中，对象可以不从域中直接获取。
    而是通过struts的包装类StrutsRequstWrapper的getAttribut()方法来从值栈中取值。
    
### ValueStack（值栈）

    贯穿整个Action的生命周期（每个Action实例都有一个ValueStack对象）。
    struts把ValueStack对象保存在名为struts.valueStack的请求属性中。
    
    在ValueStack中有两个逻辑部分：
        ContextMap（context属性）:
            struts把各种各样的映射关系压入ContextMap中，实际上就是对ActionContext的一个引用。
            struts会把下面这些映射压入ContextMap中：
                -parameters 请求参数
                -request 当前request的所有属性
                -session 当前session的所有属性
                -application 当前application的所有属性
                -attr 检索以上各Map，顺序为：request -> session -> application
        ObjectStack（root属性）:
            struts把Action和相关对象压入ObjectStack中
        
### OGNL介绍

    ·在JSP页面上可以利用OGNL（Object-Graph Navigation Language：对象-导航图语言）
     访问到值栈里对象的属性
     
    ·若希望访问值栈里ContextMap中的数据，需要给OGNL表达式加上一个前缀字符串#。
     如果没有#号，搜索将在ObjectStack里进行。
     
### property标签

    struts2利用s:property标签和OGNL表达式来读取值栈中的属性值
    
#### 值栈中的属性值：
    
    > 对于对象栈：
        对象栈中某一对象的属性值
    > 对于Map栈：
        request, session, application的一个属性值或一个请求参数的值
        
#### ObjectStack里的属性值
        
    1. 读取ObjectStack里的对象属性
        ·object.propertyName
        ·object['propertyName']
        ·object["propertyName"]
    2. ObjectStack里的对象可以通过一个从零开始的下标来引用
        [0].name => 栈顶对象的name属性
    3. 若在指定对象中未找到该属性，在下一个对象里继续搜索。[n] : [>=n]的所有对象
    4. 若从栈顶对象开始搜索，则可以省略下标
        <s:property value="[0].message" />
        <s:property value="message" />
        
    > 默认情况下，Action对象会被struts2自动放到值栈的栈顶
    
#### Map对象中的属性值
    
    1. 读取Map对象总的属性值
        #object.propertyName
        #object['propertyName']
        #object["propertyName"]
    2. 如
        #session.user
        #request.product.name
        
### OGNL还可以访问：
    
    ·数组对象
        list[0]
    ·Map对象
        map[key]
        
### EL表达式也可以访问值栈中的值！

    ·单个值的访问仍然是EL表达式更加简便
    
    ·原理：
        StrutsRequestWrapper重写了getAttribute()方法，重写后的方法的查询对象包括值栈
        
## Struts2的运行流程

    HttpServletRequest
    ↓
    StrutsPreparedAndExecutorFilter
    ↓                               ↓ ↑     
    ActionProxy → ActionInvocation  ActionMapper
    ↓ ↑                         |
    ConfigurationManager        |→Interceptor1
    ↓ ↑                         |→Interceptor2
    struts.xml                  |→Interceptor3  TagSystem
                                |→Action         ↓
                                |→Result → Template, JSP, FreeMarker...
                                |→Interceptor3
                                |→Interceptor2
                                |→Interceptor1
                                   ↓
                                   HttpServletResponse
           
## Struts2 输入验证

    ToDo: Maybe some other day