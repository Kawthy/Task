
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags" prefix="date"%>
<%@ page isELIgnored="false" %>
<html>
<body>
<main style="background-color: #fafafa">
    <div class="container">
        <div class="row full">
            <div class="col-md-3 col-sm-6 col-xs-12 idea">
                <div class="map-left"></div>
                <b class="mind">高效</b>
                <p class="state">将五到七年的成长时间，缩短到一年到三年。</p>
            </div>

            <div class="col-md-3 col-sm-6  col-xs-12 idea">
                <div class="map-center"></div>
                <b class="mind">规范</b>
                <p class="state">标准的实战教程，不会走弯路。</p>
            </div>
            <div class="col-md-3 col-sm-6  col-xs-12 idea">
                <div class="map-right"></div>
                <b class="mind">人脉</b>
                <p class="state">同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路。</p>
            </div>
            <div class="col-md-3 col-sm-6  col-xs-12 idea-right">
                <div class="digit">
                    <img src="../images/task7.png" alt="">
                    <p class="datd">12400</p>
                </div>
                <p class="state-right">累计在线学习人数</p>
                <div class="digit">
                    <img src="../images/task7.png" alt="">
                    <p class="datd">12400</p>
                </div>
                <p class="jok">学院已经找到满意工作</p>
            </div>
        </div>
    </div>
    <b class="study">如何学习</b>
    <div class="container leam">
        <div class="row wed-full">
            <div class="col-md-6 col-sm-6 col-lg-3 wed">
                <div class="circle">
                    <div class="tab">
                        1
                    </div>
                </div>
                <p class="mate">匹配你现在的个人情况 寻找适合自己的岗位</p>
                <div class="botle"></div>
            </div>
            <div class="col-md-6 col-sm-6 col-lg-3 wed wed">
                <div class="circle">
                    <div class="tab">
                        2
                    </div>
                </div>
                <p class="mate">了解职业前景薪金待遇、 竞争压力等</p>
                <div class="botle"></div>
            </div>
            <div class="col-md-6 col-sm-6 col-lg-3 wed wed">
                <div class="circle">
                    <div class="tab">
                        3
                    </div>
                </div>
                <p class="mate">掌握行业内顶级技能</p>
                <div class="botle"></div>
            </div>
            <div class="col-md-6 col-sm-6 col-lg-3 wed">
                <div class="circle">
                    <div class="tab">
                        4
                    </div>
                </div>
                <p class="mate">查看职业目标任务</p>
                <div class="botle-none"></div>
            </div>
            <div class="col-md-6 col-sm-6 col-lg-3 wed">
                <div class="circle">
                    <div class="tab">
                        5
                    </div>
                </div>
                <p class="mate">参考学习资源，掌握 技能点，逐个完成任务</p>
                <div class="botle"></div>
            </div>
            <div class="col-md-6 col-sm-6 col-lg-3 wed">
                <div class="circle">
                    <div class="tab">
                        6
                    </div>
                </div>
                <p class="mate">加入班级，和小伙伴们 互帮互助，一块学习</p>
                <div class="botle"></div>
            </div>
            <div class="col-md-6 col-sm-6 col-lg-3 wed">
                <div class="circle">
                    <div class="tab">
                        7
                    </div>
                </div>
                <p class="mate">选择导师，一路引导， 加速自己成长</p>
                <div class="botle"></div>
            </div>
            <div class="col-md-6 col-sm-6 col-lg-3  wed">
                <div class="circle">
                    <div class="tab">
                        8
                    </div>
                </div>
                <p class="mate">加入班级，和小伙伴们 互帮互助，一块学习</p>
            </div>
        </div>
    </div>
    <b class="study">优秀学员展示</b>
    <div class="container">
        <div class="row show-boss">
            <c:forEach items="${students}" var="s" varStatus="studentStatus">
                <div class="col-md-3 col-sm-6 col-xs-12 ide">
                    <div class="box">
                        <div class="show-man"></div>
                        <b class="show-name">学员:<c:out value="${s.name}"></c:out></b>
                        <p class="state-bat">职位:<c:out value="${pname.get(studentStatus.index)}"></c:out></p>
                        <p class="state-bat">入学时间:<date:date value="${s.createAt}"/></p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="circle-dot">
        <div class="circle-left"></div>
        <div class="circle-left"></div>
        <div class="circle-left"></div>
        <div class="circle-left"></div>
    </div>
    <b class="study">战略合作企业</b>
    <div class="container firm">
        <div class=" firm-one">
            <div class="bag">
                <img src="../images/alibaba.png" alt="">
            </div>
        </div>
        <div class=" firm-one">
            <div class="bag">
                <img src="../images/js.png" alt="">
            </div>
        </div>
        <div class=" firm-one">
            <div class="bag">
                <img src="../images/hx.png" alt="">
            </div>
        </div>
        <div class=" firm-one">
            <div class="bag">
                <img src="../images/rl.png" alt="">
            </div>
        </div>
        <div class=" firm-one">
            <div class="bag">
                <img src="../images/qiniu.png" alt="">
            </div>
        </div>
    </div>
    <b class="study">友情链接</b>
    <div class="container">
        <div class="row link-boss">
            <div class="link">
                <a href="">
                    <li>
                        手机软件
                    </li>
                </a>
                <a href="">
                    <li>
                        手机软件
                    </li>
                </a>
            </div>
            <div class="link">
                <a href="">
                    <li>
                        找工作
                    </li>
                </a>
                <a href="">
                    <li>
                        找工作
                    </li>
                </a>
            </div>
            <div class="link">
                <a href="">
                    <li>
                        找工作
                    </li>
                </a>
                <a href="">
                    <li>
                        找工作
                    </li>
                </a>
            </div>
            <div class="link">
                <a href="">
                    <li>
                        教师招聘
                    </li>
                </a>
                <a href="">
                    <li>
                        教师招聘
                    </li>
                </a>
            </div>
            <div class="link">
                <a href="">
                    <li>
                        手机软件
                    </li>
                </a>
                <a href="">
                    <li>
                        手机软件
                    </li>
                </a>
            </div>
            <div class="link">
                <a href="">
                    <li>
                        教师招聘
                    </li>
                </a>
                <a href="">
                    <li>
                        教师招聘
                    </li>
                </a>
            </div>
            <div class="link">
                <a href="">
                    <li>
                        找工作
                    </li>
                </a>
                <a href="">
                    <li>
                        找工作
                    </li>
                </a>
            </div>
            <div class="link">
                <a href="">
                    <li>
                        手机软件
                    </li>
                </a>
                <a href="">
                    <li>
                        手机软件
                    </li>
                </a>
            </div>
            <div class="link">
                <a href="">
                    <li>
                        手机软件
                    </li>
                </a>
                <a href="">
                    <li>
                        手机软件
                    </li>
                </a>
            </div>
            <div class="link">
                <a href="">
                    <li>
                        找工作
                    </li>
                </a>
                <a href="">
                    <li>
                        找工作
                    </li>
                </a>
            </div>
        </div>
    </div>
</main>
</body>

</html>
