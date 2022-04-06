<!DOCTYPE html>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="/styles/common.css"/>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
</head>
<body>
<#include 'common/top.ftl'>
<div class="page-body">
    <#include 'common/leftMenu.ftl'>
    <div class="page-content">
        <div class="content-nav">
            人员管理 > 部门管理
        </div>
        <form action="/admin/addDepartment" method="post">
            <fieldset>
                <legend>添加部门</legend>
                部门名称:
                <input type="text" name="departmentname" id="departmentname" maxlength="20"/>
                <input type="submit" class="clickbutton" value="添加"/>
                <div style="color: red">${error!''}</div>
            </fieldset>
        </form>
        <table class="listtable">
            <caption>所有部门:</caption>
            <tr class="listheader">
                <th>部门编号</th>
                <th>部门名称</th>
                <th>操作</th>
            </tr>
            <#if deps??>
                <#list deps as dep>
                    <tr>
                        <td>${dep.departmentid}</td>
                        <td id="depname${dep.departmentid}">${dep.departmentname}</td>
                        <td>
                            <a class="clickbutton"
                               href="#"
                               id="edit${dep.departmentid}" onclick="editdep(${dep.departmentid})
                                    ">编辑</a>
                            <a class="clickbutton"
                               style="display: none"
                               href="#"
                               id="cancel${dep.departmentid}"
                               onclick="canceldep(${dep.departmentid})
                                       ">取消</a>
                            <a class="clickbutton"
                               href="/admin/deleteDep?departmentid=${dep.departmentid}">删除</a>
                        </td>
                    </tr>
                </#list>
            </#if>
        </table>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="/images/footer.png" alt="CoolMeeting"/>
</div>
<script>
    //取消按钮
    let depname;
    function canceldep(depid) {
        let cancelBtn = $('#cancel' + depid);
        let editBtn = $('#edit' + depid);
        let ele = $('#depname' + depid);
        cancelBtn.css('display', 'none');
        editBtn.html('编辑');
        ele.html(depname);
        console.log('我不改了')
    }

    //编辑按钮
    function editdep(depid) {
        let cancelBtn = $('#cancel' + depid);
        let editBtn = $('#edit' + depid);
        let ele = $('#depname' + depid);
        depname=ele.html();
        console.log('我要修改数据了')
        if (cancelBtn.css('display') == 'none') {
            console.log(111)
            cancelBtn.css('display', 'inline');
            editBtn.html('确定');
            let depName = ele.text();
            ele.html('<input type="text" value="' + depName + '"/>');
        } else {//确认按钮
            console.log(cancelBtn.css('display'), '此时取消按钮的样式为none，不显示')
            console.log('要进行上传数据了')
            let children = ele.children('input')
            let val = children.val();
            console.log('这是修改之后的数据', val)
            console.log('发送ajax请求上传数据到服务端了。。。')
            $.ajax({
                type: 'POST',
                url: '/admin/updateDep',
                data: {id: depid, name: val},
                success:function (msg){
                    console.log('服务端传过来的', msg)
                    if (msg == 'success') {
                        console.log('把数据上传到服务端了')
                        cancelBtn.css('display', 'none');
                        editBtn.html('编辑');
                        ele.html(val);
                    }
                }
            })
            // $.post('/admin/updateDep', {
            //         id: depid,
            //         name: val,
            //     }
            // ), function (msg) {
            //     console.log('服务端传过来的', msg)
            //     if (msg == 'success') {
            //         console.log('把数据上传到服务端了')
            //         cancelBtn.css('display', 'none');
            //         editBtn.html('编辑');
            //         ele.html(val);
            //     }
            // }
        }
    }
</script>
</body>
</html>
