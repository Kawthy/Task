<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kawthy
  Date: 2019/3/24
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<main>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-lg-12 firm">
                <a class="firm-left" href="./1.html">首页</a>
                <a class="firm-center"></a>
                <a class="firm-right" href="./3.html">职业</a>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="post">
                <div class="col-md-12 col-sm-12 col-lg-12 branch">
                    <div class="kind">
                        <p>方向：</p>
                    </div>
                    <div class="kind-right">
                        <a href="">
                            全&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部
                        </a>
                        <a href="">
                            前端开发
                        </a>
                        <a href="">
                            后端开发
                        </a>
                        <a href="">
                            移动开发
                        </a>
                        <a href="">
                            整站开发
                        </a>
                        <a href="">
                            运营维护
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="chief-full">
                <div class="col-md-12 col-sm-12 col-lg-12 chief">
                    <b>前端开发方向</b>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
<c:forEach items="${professions}" var="p">
            <div class="col-sm-12 col-md-4 col-lg-4 undo">
                <div class="inner">
                    <div class="premise">
                        <div class="sky">
                            <img class="premise-img" src="./images/task-9.png" alt="">
                        </div>
                        <div class="sky">
                            <b><c:out value="${p.name}"></c:out></b>
                            <p>
                                <c:out value="${p.jobDescription}"></c:out>
                            </p>
                        </div>
                    </div>
                    <div class="sill">
                        <div class="rid">
                            <p>门槛</p>
                            <img src="./images/<c:out value="${p.threshold}"></c:out>.png" alt="">
                        </div>
                        <div class="rid-right">
                            <p>难易程度</p>
                            <img src="./images/<c:out value="${p.threshold}"></c:out>.png" alt="">
                            <img src="./images/<c:out value="${p.threshold}"></c:out>.png" alt="">
                        </div>
                    </div>
                    <div class="sill-top">
                        <div class="month">
                            <p class="age">成长周期</p>
                            <samp class="red"><c:out value="${p.growthCycle}"></c:out></samp>
                        </div>
                        <div class="month-right">
                            <p class="age">稀缺程度</p>
                            <samp class="red"><c:out value="${p.need}"></c:out></samp>
                            <samp>家公司需要</samp>
                        </div>
                    </div>
                    <div class="money">
                        <div class="money-left">
                            <p class="pay">薪资待遇</p>
                        </div>
                        <div class="money-right">
                            <p class="sun">
                                <span>0-1年</span>
                                <span>8k-<c:out value="${p.salary01}"></c:out>k/月</span>
                            </p>
                            <p class="sun">
                                <span>1-2年</span>
                                <span><c:out value="${p.salary01}"></c:out>k-<c:out value="${p.salary02}"></c:out>k/月</span>
                            </p>
                            <p class="sun-bottom">
                                <span>2-3年</span>
                                <span><c:out value="${p.salary02}"></c:out>k-<c:out value="${p.salary03}"></c:out>k/月</span>
                            </p>
                        </div>
                    </div>
                    <div class="man">
                        <b>有</b>
                        <b class="larn">286</b>
                        <b>人正在学</b>
                    </div>
                    <div class="voice">
                        <p class="pay">
                            提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                        </p>
                    </div>

            </div>
        </div>
</c:forEach>
    </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="chief-full">
                <div class="col-md-12 col-sm-12 col-lg-12 chief">
                    <b>后端开发方向</b>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-4 col-lg-4 undo">
                <div class="inner">
                    <div class="premise">
                        <div class="sky">
                            <img class="premise-img" src="./images/task-9.png" alt="">
                        </div>
                        <div class="sky">
                            <b>Web前端工程师</b>
                            <p>
                                Web前端开发工程师，主要职责是
                                利用（X）HTML/CSS/JavaScript/
                                flash等各种Web技术进行产品的开发。
                            </p>
                        </div>
                    </div>
                    <div class="sill">
                        <div class="rid">
                            <p>门槛</p>
                            <img src="./images/bit.png" alt="">
                        </div>
                        <div class="rid-right">
                            <p>难易程度</p>
                            <img src="./images/bit.png" alt="">
                            <img src="./images/bit.png" alt="">
                        </div>
                    </div>
                    <div class="sill-top">
                        <div class="month">
                            <p class="age">成长周期</p>
                            <samp class="red">1-3</samp>
                            <samp>年</samp>
                        </div>
                        <div class="month-right">
                            <p class="age">稀缺程度</p>
                            <samp class="red">365</samp>
                            <samp>家公司需要</samp>
                        </div>
                    </div>
                    <div class="money">
                        <div class="money-left">
                            <p class="pay">薪资待遇</p>
                        </div>
                        <div class="money-right">
                            <p class="sun">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                            <p class="sun">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                            <p class="sun-bottom">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                        </div>
                    </div>
                    <div class="man">
                        <b>有</b>
                        <b class="larn">286</b>
                        <b>人正在学</b>
                    </div>
                    <div class="voice">
                        <p class="pay">
                            提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                        </p>
                    </div>
                    <div class="ios">
                        <h5>iOS工程师</h5>
                        <p>
                            iOS是由苹果公司开发的移动操作统，
                            iOS与苹果的MacOSX操作系统一样，也是
                            以Darwin为基础的，因此同样属
                            于类Unix的商业操作系统。国内iOS开
                            发起步相对较晚，人才培养机制更是远
                            远跟不上市场发展速度。有限的iOS开
                            发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制
                            更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-4 col-lg-4 undo">
                <div class="inner">
                    <div class="premise">
                        <div class="sky">
                            <img class="premise-img" src="./images/task-9.png" alt="">
                        </div>
                        <div class="sky">
                            <b>Web前端工程师</b>
                            <p>
                                Web前端开发工程师，主要职责是
                                利用（X）HTML/CSS/JavaScript/
                                flash等各种Web技术进行产品的开发。
                            </p>
                        </div>
                    </div>
                    <div class="sill">
                        <div class="rid">
                            <p>门槛</p>
                            <img src="./images/bit.png" alt="">
                        </div>
                        <div class="rid-right">
                            <p>难易程度</p>
                            <img src="./images/bit.png" alt="">
                            <img src="./images/bit.png" alt="">
                        </div>
                    </div>
                    <div class="sill-top">
                        <div class="month">
                            <p class="age">成长周期</p>
                            <samp class="red">1-3</samp>
                            <samp>年</samp>
                        </div>
                        <div class="month-right">
                            <p class="age">稀缺程度</p>
                            <samp class="red">365</samp>
                            <samp>家公司需要</samp>
                        </div>
                    </div>
                    <div class="money">
                        <div class="money-left">
                            <p class="pay">薪资待遇</p>
                        </div>
                        <div class="money-right">
                            <p class="sun">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                            <p class="sun">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                            <p class="sun-bottom">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                        </div>
                    </div>
                    <div class="man">
                        <b>有</b>
                        <b class="larn">286</b>
                        <b>人正在学</b>
                    </div>
                    <div class="voice">
                        <p class="pay">
                            提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                        </p>
                    </div>
                    <div class="ios">
                        <h5>iOS工程师</h5>
                        <p>
                            iOS是由苹果公司开发的移动操作统，
                            iOS与苹果的MacOSX操作系统一样，也是
                            以Darwin为基础的，因此同样属
                            于类Unix的商业操作系统。国内iOS开
                            发起步相对较晚，人才培养机制更是远
                            远跟不上市场发展速度。有限的iOS开
                            发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制
                            更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-4 col-lg-4 undo">
                <div class="inner">
                    <div class="premise">
                        <div class="sky">
                            <img class="premise-img" src="./images/task-9.png" alt="">
                        </div>
                        <div class="sky">
                            <b>Web前端工程师</b>
                            <p>
                                Web前端开发工程师，主要职责是
                                利用（X）HTML/CSS/JavaScript/
                                flash等各种Web技术进行产品的开发。
                            </p>
                        </div>
                    </div>
                    <div class="sill">
                        <div class="rid">
                            <p>门槛</p>
                            <img src="./images/bit.png" alt="">
                        </div>
                        <div class="rid-right">
                            <p>难易程度</p>
                            <img src="./images/bit.png" alt="">
                            <img src="./images/bit.png" alt="">
                        </div>
                    </div>
                    <div class="sill-top">
                        <div class="month">
                            <p class="age">成长周期</p>
                            <samp class="red">1-3</samp>
                            <samp>年</samp>
                        </div>
                        <div class="month-right">
                            <p class="age">稀缺程度</p>
                            <samp class="red">365</samp>
                            <samp>家公司需要</samp>
                        </div>
                    </div>
                    <div class="money">
                        <div class="money-left">
                            <p class="pay">薪资待遇</p>
                        </div>
                        <div class="money-right">
                            <p class="sun">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                            <p class="sun">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                            <p class="sun-bottom">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                        </div>
                    </div>
                    <div class="man">
                        <b>有</b>
                        <b class="larn">286</b>
                        <b>人正在学</b>
                    </div>
                    <div class="voice">
                        <p class="pay">
                            提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                        </p>
                    </div>
                    <div class="ios">
                        <h5>iOS工程师</h5>
                        <p>
                            iOS是由苹果公司开发的移动操作统，
                            iOS与苹果的MacOSX操作系统一样，也是
                            以Darwin为基础的，因此同样属
                            于类Unix的商业操作系统。国内iOS开
                            发起步相对较晚，人才培养机制更是远
                            远跟不上市场发展速度。有限的iOS开
                            发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制
                            更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-4 col-lg-4 undo">
                <div class="inner">
                    <div class="premise">
                        <div class="sky">
                            <img class="premise-img" src="./images/task-9.png" alt="">
                        </div>
                        <div class="sky">
                            <b>Web前端工程师</b>
                            <p>
                                Web前端开发工程师，主要职责是
                                利用（X）HTML/CSS/JavaScript/
                                flash等各种Web技术进行产品的开发。
                            </p>
                        </div>
                    </div>
                    <div class="sill">
                        <div class="rid">
                            <p>门槛</p>
                            <img src="./images/bit.png" alt="">
                        </div>
                        <div class="rid-right">
                            <p>难易程度</p>
                            <img src="./images/bit.png" alt="">
                            <img src="./images/bit.png" alt="">
                        </div>
                    </div>
                    <div class="sill-top">
                        <div class="month">
                            <p class="age">成长周期</p>
                            <samp class="red">1-3</samp>
                            <samp>年</samp>
                        </div>
                        <div class="month-right">
                            <p class="age">稀缺程度</p>
                            <samp class="red">365</samp>
                            <samp>家公司需要</samp>
                        </div>
                    </div>
                    <div class="money">
                        <div class="money-left">
                            <p class="pay">薪资待遇</p>
                        </div>
                        <div class="money-right">
                            <p class="sun">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                            <p class="sun">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                            <p class="sun-bottom">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                        </div>
                    </div>
                    <div class="man">
                        <b>有</b>
                        <b class="larn">286</b>
                        <b>人正在学</b>
                    </div>
                    <div class="voice">
                        <p class="pay">
                            提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                        </p>
                    </div>
                    <div class="ios">
                        <h5>iOS工程师</h5>
                        <p>
                            iOS是由苹果公司开发的移动操作统，
                            iOS与苹果的MacOSX操作系统一样，也是
                            以Darwin为基础的，因此同样属
                            于类Unix的商业操作系统。国内iOS开
                            发起步相对较晚，人才培养机制更是远
                            远跟不上市场发展速度。有限的iOS开
                            发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制
                            更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-sm-12 col-md-4 col-lg-4 undo">
                <div class="inner">
                    <div class="premise">
                        <div class="sky">
                            <img class="premise-img" src="./images/task-9.png" alt="">
                        </div>
                        <div class="sky">
                            <b>Web前端工程师</b>
                            <p>
                                Web前端开发工程师，主要职责是
                                利用（X）HTML/CSS/JavaScript/
                                flash等各种Web技术进行产品的开发。
                            </p>
                        </div>
                    </div>
                    <div class="sill">
                        <div class="rid">
                            <p>门槛</p>
                            <img src="./images/bit.png" alt="">
                        </div>
                        <div class="rid-right">
                            <p>难易程度</p>
                            <img src="./images/bit.png" alt="">
                            <img src="./images/bit.png" alt="">
                        </div>
                    </div>
                    <div class="sill-top">
                        <div class="month">
                            <p class="age">成长周期</p>
                            <samp class="red">1-3</samp>
                            <samp>年</samp>
                        </div>
                        <div class="month-right">
                            <p class="age">稀缺程度</p>
                            <samp class="red">365</samp>
                            <samp>家公司需要</samp>
                        </div>
                    </div>
                    <div class="money">
                        <div class="money-left">
                            <p class="pay">薪资待遇</p>
                        </div>
                        <div class="money-right">
                            <p class="sun">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                            <p class="sun">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                            <p class="sun-bottom">
                                <span>0-1年</span>
                                <span>5k-10k/月</span>
                            </p>
                        </div>
                    </div>
                    <div class="man">
                        <b>有</b>
                        <b class="larn">286</b>
                        <b>人正在学</b>
                    </div>
                    <div class="voice">
                        <p class="pay">
                            提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                        </p>
                    </div>
                    <div class="ios">
                        <h5>iOS工程师</h5>
                        <p>
                            iOS是由苹果公司开发的移动操作统，
                            iOS与苹果的MacOSX操作系统一样，也是
                            以Darwin为基础的，因此同样属
                            于类Unix的商业操作系统。国内iOS开
                            发起步相对较晚，人才培养机制更是远
                            远跟不上市场发展速度。有限的iOS开
                            发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制
                            更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                        </p>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="chief-full">
                        <div class="col-md-12 col-sm-12 col-lg-12 chief">
                            <b>运维方向</b>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-md-4 col-lg-4 undo">
                        <div class="inner">
                            <div class="premise">
                                <div class="sky">
                                    <img class="premise-img" src="./images/task-9.png" alt="">
                                </div>
                                <div class="sky">
                                    <b>Web前端工程师</b>
                                    <p>
                                        Web前端开发工程师，主要职责是
                                        利用（X）HTML/CSS/JavaScript/
                                        flash等各种Web技术进行产品的开发。
                                    </p>
                                </div>
                            </div>
                            <div class="sill">
                                <div class="rid">
                                    <p>门槛</p>
                                    <img src="./images/bit.png" alt="">
                                </div>
                                <div class="rid-right">
                                    <p>难易程度</p>
                                    <img src="./images/bit.png" alt="">
                                    <img src="./images/bit.png" alt="">
                                </div>
                            </div>
                            <div class="sill-top">
                                <div class="month">
                                    <p class="age">成长周期</p>
                                    <samp class="red">1-3</samp>
                                    <samp>年</samp>
                                </div>
                                <div class="month-right">
                                    <p class="age">稀缺程度</p>
                                    <samp class="red">365</samp>
                                    <samp>家公司需要</samp>
                                </div>
                            </div>
                            <div class="money">
                                <div class="money-left">
                                    <p class="pay">薪资待遇</p>
                                </div>
                                <div class="money-right">
                                    <p class="sun">
                                        <span>0-1年</span>
                                        <span>5k-10k/月</span>
                                    </p>
                                    <p class="sun">
                                        <span>0-1年</span>
                                        <span>5k-10k/月</span>
                                    </p>
                                    <p class="sun-bottom">
                                        <span>0-1年</span>
                                        <span>5k-10k/月</span>
                                    </p>
                                </div>
                            </div>
                            <div class="man">
                                <b>有</b>
                                <b class="larn">286</b>
                                <b>人正在学</b>
                            </div>
                            <div class="voice">
                                <p class="pay">
                                    提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                                </p>
                            </div>
                            <div class="ios">
                                <h5>iOS工程师</h5>
                                <p>
                                    iOS是由苹果公司开发的移动操作统，
                                    iOS与苹果的MacOSX操作系统一样，也是
                                    以Darwin为基础的，因此同样属
                                    于类Unix的商业操作系统。国内iOS开
                                    发起步相对较晚，人才培养机制更是远
                                    远跟不上市场发展速度。有限的iOS开
                                    发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制
                                    更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-4 col-lg-4 undo">
                        <div class="inner">
                            <div class="premise">
                                <div class="sky">
                                    <img class="premise-img" src="./images/task-9.png" alt="">
                                </div>
                                <div class="sky">
                                    <b>Web前端工程师</b>
                                    <p>
                                        Web前端开发工程师，主要职责是
                                        利用（X）HTML/CSS/JavaScript/
                                        flash等各种Web技术进行产品的开发。
                                    </p>
                                </div>
                            </div>
                            <div class="sill">
                                <div class="rid">
                                    <p>门槛</p>
                                    <img src="./images/bit.png" alt="">
                                </div>
                                <div class="rid-right">
                                    <p>难易程度</p>
                                    <img src="./images/bit.png" alt="">
                                    <img src="./images/bit.png" alt="">
                                </div>
                            </div>
                            <div class="sill-top">
                                <div class="month">
                                    <p class="age">成长周期</p>
                                    <samp class="red">1-3</samp>
                                    <samp>年</samp>
                                </div>
                                <div class="month-right">
                                    <p class="age">稀缺程度</p>
                                    <samp class="red">365</samp>
                                    <samp>家公司需要</samp>
                                </div>
                            </div>
                            <div class="money">
                                <div class="money-left">
                                    <p class="pay">薪资待遇</p>
                                </div>
                                <div class="money-right">
                                    <p class="sun">
                                        <span>0-1年</span>
                                        <span>5k-10k/月</span>
                                    </p>
                                    <p class="sun">
                                        <span>0-1年</span>
                                        <span>5k-10k/月</span>
                                    </p>
                                    <p class="sun-bottom">
                                        <span>0-1年</span>
                                        <span>5k-10k/月</span>
                                    </p>
                                </div>
                            </div>
                            <div class="man">
                                <b>有</b>
                                <b class="larn">286</b>
                                <b>人正在学</b>
                            </div>
                            <div class="voice">
                                <p class="pay">
                                    提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                                </p>
                            </div>
                            <div class="ios">
                                <h5>iOS工程师</h5>
                                <p>
                                    iOS是由苹果公司开发的移动操作统，
                                    iOS与苹果的MacOSX操作系统一样，也是
                                    以Darwin为基础的，因此同样属
                                    于类Unix的商业操作系统。国内iOS开
                                    发起步相对较晚，人才培养机制更是远
                                    远跟不上市场发展速度。有限的iOS开
                                    发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制
                                    更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-4 col-lg-4 undo">
                        <div class="inner">
                            <div class="premise">
                                <div class="sky">
                                    <img class="premise-img" src="./images/task-9.png" alt="">
                                </div>
                                <div class="sky">
                                    <b>Web前端工程师</b>
                                    <p>
                                        Web前端开发工程师，主要职责是
                                        利用（X）HTML/CSS/JavaScript/
                                        flash等各种Web技术进行产品的开发。
                                    </p>
                                </div>
                            </div>
                            <div class="sill">
                                <div class="rid">
                                    <p>门槛</p>
                                    <img src="./images/bit.png" alt="">
                                </div>
                                <div class="rid-right">
                                    <p>难易程度</p>
                                    <img src="./images/bit.png" alt="">
                                    <img src="./images/bit.png" alt="">
                                </div>
                            </div>
                            <div class="sill-top">
                                <div class="month">
                                    <p class="age">成长周期</p>
                                    <samp class="red">1-3</samp>
                                    <samp>年</samp>
                                </div>
                                <div class="month-right">
                                    <p class="age">稀缺程度</p>
                                    <samp class="red">365</samp>
                                    <samp>家公司需要</samp>
                                </div>
                            </div>
                            <div class="money">
                                <div class="money-left">
                                    <p class="pay">薪资待遇</p>
                                </div>
                                <div class="money-right">
                                    <p class="sun">
                                        <span>0-1年</span>
                                        <span>5k-10k/月</span>
                                    </p>
                                    <p class="sun">
                                        <span>0-1年</span>
                                        <span>5k-10k/月</span>
                                    </p>
                                    <p class="sun-bottom">
                                        <span>0-1年</span>
                                        <span>5k-10k/月</span>
                                    </p>
                                </div>
                            </div>
                            <div class="man">
                                <b>有</b>
                                <b class="larn">286</b>
                                <b>人正在学</b>
                            </div>
                            <div class="voice">
                                <p class="pay">
                                    提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                                </p>
                            </div>
                            <div class="ios">
                                <h5>iOS工程师</h5>
                                <p>
                                    iOS是由苹果公司开发的移动操作统，
                                    iOS与苹果的MacOSX操作系统一样，也是
                                    以Darwin为基础的，因此同样属
                                    于类Unix的商业操作系统。国内iOS开
                                    发起步相对较晚，人才培养机制更是远
                                    远跟不上市场发展速度。有限的iOS开
                                    发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制
                                    更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="chief-full">
                        <div class="col-md-12 col-sm-12 col-lg-12 chief">
                            <b>运维方向</b>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-sm-12 col-md-4 col-lg-4 undo">
                        <div class="inner">
                            <div class="premise">
                                <div class="sky">
                                    <img class="premise-img" src="./images/task-9.png" alt="">
                                </div>
                                <div class="sky">
                                    <b>Web前端工程师</b>
                                    <p>
                                        Web前端开发工程师，主要职责是
                                        利用（X）HTML/CSS/JavaScript/
                                        flash等各种Web技术进行产品的开发。
                                    </p>
                                </div>
                            </div>
                            <div class="sill">
                                <div class="rid">
                                    <p>门槛</p>
                                    <img src="./images/bit.png" alt="">
                                </div>
                                <div class="rid-right">
                                    <p>难易程度</p>
                                    <img src="./images/bit.png" alt="">
                                    <img src="./images/bit.png" alt="">
                                </div>
                            </div>
                            <div class="sill-top">
                                <div class="month">
                                    <p class="age">成长周期</p>
                                    <samp class="red">1-3</samp>
                                    <samp>年</samp>
                                </div>
                                <div class="month-right">
                                    <p class="age">稀缺程度</p>
                                    <samp class="red">365</samp>
                                    <samp>家公司需要</samp>
                                </div>
                            </div>
                            <div class="money">
                                <div class="money-left">
                                    <p class="pay">薪资待遇</p>
                                </div>
                                <div class="money-right">
                                    <p class="sun">
                                        <span>0-1年</span>
                                        <span>5k-10k/月</span>
                                    </p>
                                    <p class="sun">
                                        <span>0-1年</span>
                                        <span>5k-10k/月</span>
                                    </p>
                                    <p class="sun-bottom">
                                        <span>0-1年</span>
                                        <span>5k-10k/月</span>
                                    </p>
                                </div>
                            </div>
                            <div class="man">
                                <b>有</b>
                                <b class="larn">286</b>
                                <b>人正在学</b>
                            </div>
                            <div class="voice">
                                <p class="pay">
                                    提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                                </p>
                            </div>
                            <div class="ios">
                                <h5>
                                    iOS工程师
                                </h5>
                                <p>
                                    iOS是由苹果公司开发的移动操作统，
                                    iOS与苹果的MacOSX操作系统一样，也是
                                    以Darwin为基础的，因此同样属
                                    于类Unix的商业操作系统。国内iOS开
                                    发起步相对较晚，人才培养机制更是远
                                    远跟不上市场发展速度。有限的iOS开
                                    发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制
                                    更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
</html>
