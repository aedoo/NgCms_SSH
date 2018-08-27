<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/27
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>授信申请信息管理</title>
    <%@include file="../../common/head.jsp" %>
    <script type="text/javascript">
        function confirmMsgDel()
        {
            if(confirm("删除授信申请信息,您确定要删除吗?"))
                window.close();
        }

    </script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>

</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">授信申请信息管理</a></li>
    </ul>
</div>
<form action="" method="post">
    <div class="formbody">
        <ul class="seachform">
            <li><label>客户编号</label><input name="" type="text" class="scinput" /></li>
            <li><label>客户名称</label><input name="" type="text" class="scinput" /></li>
            <li><label>授信申请日期</label><input name="" type="text" class="scinput" /></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/></li>
        </ul>
    </div>

    <div class="rightinfo">
        <div class="tools">
            <ul class="toolbar1">
                <li><a href="clCreditApplyAdd.html"><span><img src="/images/t01.png" /></span>添加</a></li>
                <li><a href="clCreditApplyUpdate.html"><span><img src="/images/t02.png" /></span>修改</a></li>
                <li><a href="javascript:confirmMsgDel()" ><span><img src="/images/t03.png"/></span>删除</a></li>
            </ul>
        </div>
        <table class="tablelist">
            <thead>
            <tr class="tablehead"><td colspan="11">授信申请信息列表</td></tr>
            </thead>
            <thead>
            <tr>
                <th><input name="" type="checkbox" value=""/></th>
                <th>客户编号</th>
                <th>客户名称</th>
                <th>业务类型</th>
                <th>金额(元)</th>
                <th>币种</th>
                <th>期限(月)</th>
                <th>使用方式</th>
                <th>主担保方式</th>
                <th>授信申请起始日期</th>
                <th>主办客户经理</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>2000003715</td>
                <td>臧彦英</td>
                <td>个人经营贷款</td>
                <td>500000.00</td>
                <td>人民币</td>
                <td>70月</td>
                <td>一次性</td>
                <td>抵押</td>
                <td>2015-07-08</td>
                <td>旭旭</td>
            </tr>
            <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>2000003711</td>
                <td>王小明</td>
                <td>个人消费贷款</td>
                <td>50000.00</td>
                <td>人民币</td>
                <td>36月</td>
                <td>一次性</td>
                <td>担保</td>
                <td>2011-07-08</td>
                <td>旭旭</td>
            </tr>
            <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>2000003111</td>
                <td>李四</td>
                <td>个人住房贷款</td>
                <td>200000.00</td>
                <td>人民币</td>
                <td>120月</td>
                <td>循环</td>
                <td>担保</td>
                <td>2013-07-08</td>
                <td>王经理</td>
            </tr>
            <tr>
            </tbody>
        </table>
        <div class="pagin">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td class="STYLE4"><div class="message">共<i class="blue">260</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
                    </td>
                    <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="45"><img src="/images/first.gif" width="33" height="20" style="cursor:hand" onclick="firstPage()"/></td>
                            <td width="50"><img src="/images/back.gif" width="43" height="20" style="cursor:hand" onclick="priviousPage()"/></td>
                            <td width="50"><img src="/images/next.gif" width="43" height="20" style="cursor:hand" onclick="nextPage()"/></td>
                            <td width="40"><img src="/images/last.gif" width="33" height="20" style="cursor:hand" onclick="lastPage()"/></td>
                            <td width="100"><div align="center"><span class="STYLE1">转到第
	                    <input name="textfield" type="text" size="4" style="height:16px; width:35px; border:1px solid #999999;" /> 
	                    页 </span></div></td>
                            <td width="40"><img src="/images/go.gif" width="33" height="17" style="cursor:hand" onclick="goPage()"/></td>
                        </tr>
                    </table>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</form>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>
</html>
