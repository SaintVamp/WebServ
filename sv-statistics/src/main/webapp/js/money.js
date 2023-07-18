const grid = $("#mainGrid").ligerGrid({
    columns: [
        // { display: 'QQ号', name: 'qqNum', align: 'center', width: 100 },
        {display: 'QQ号', name: 'qqNum', align: 'center'},
        {display: '认证码', name: 'authCode', align: 'center', width: 300},
        {display: '起始日期', name: 'startDt', align: 'center'},
        {display: '结束日期', name: 'endDt', align: 'center'},
        {display: '金额', name: 'price', align: 'center'},
        {display: '更新日期', name: 'updateDt', align: 'center'},
        {display: '绑定设备', name: 'device', align: 'center'},
        {display: '绑定IP', name: 'localIp', align: 'center'},
        {display: '辅助版本', name: 'version', align: 'center'},
        {display: '游戏名', name: 'game', align: 'center'}
    ],
    usePager: false,
    pageSize:
        20,
    pageSizeOptions:
        [20],
    data:
        $.extend(true, {}, []),
    width:
        '100%',
    height:
        '100%',
    enabledSort:
        false
});

function SeaRegQ() {
    $.ajax({
        url: '/Serv/ctrl/SeaRegQ',
        type: "POST",
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        dataType: 'text',
        async: false,
        data: {
            qqNum: $("#qqNum").val(),
            authCode: "",
            device: "",
            startDt: "",
            endDt: "",
            localIp: "",
            price: 999999,
            updateDt: "",
            version: "",
            game: ""
        },
        beforeSend: function (request) {
            request.setRequestHeader("sv", $("#SVCode").val());
        },
        success: function (result) {
            let temp = JSON.parse(result)
            if (temp.retCode === "00000") {
                layer.closeAll();
                initTable({Rows: temp.data});
                let num = 0;
                for (let i = 0; i < temp.data.length; i++) {
                    num = num + parseInt(temp.data[i].price);
                }
                $("#used").html("收入总额：" + num)
            } else {
                $("#used").html(temp.retInfo)
            }
        },
        error: function (msg) {
            layer.closeAll();
            if (msg.status === '403') {
                parent.window.location.href = "../login.html";
            }
        }
    });
}

function CouA() {
    $.ajax({
        url: "/Serv/ctrl/CouA",
        type: "POST",
        contentType: 'application/json',
        dataType: 'json',
        beforeSend: function (request) {
            request.setRequestHeader("sv", $("#SVCode").val());
        },
        success: function (result) {
            if (result.retCode === "00000") {
                layer.closeAll();
                $("#used").html("收入总额：" + result.data)
            } else {
                $("#used").html(result.retInfo)
            }
        },
        error: function (msg) {
            layer.closeAll();
            if (msg.status === '403') {
                parent.window.location.href = "../login.html";
            }
        }
    });
}

function initTable(data) {
    if (!data) {
        return;
    }
    grid.options.data = $.extend(true, {}, data);
    grid.loadData();
}


