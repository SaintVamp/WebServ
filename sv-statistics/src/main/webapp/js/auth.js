function formatDate(n) {
    return n < 10 ? '0' + n : n;
}

function Reg() {
    let regDate = new Date();
    let sTime = "" + regDate.getFullYear() + formatDate(regDate.getMonth() + 1) + formatDate(regDate.getDate())+"000000";
    let etime = FormatMyDate(sTime, parseInt($("#cMouth").val()) * 30)+"235959";
    $.ajax({
        url: "/Serv/ctrl/Reg",
        type: "POST",
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        dataType: 'text',
        async: false,
        data: {
            qqNum: $("#CqqNum").val(),
            authCode: $("#sAuthCode").val().toUpperCase(),
            startDt: sTime,
            endDt: etime,
            price: $("#cPrice").val(),
            game: $("#Game").val()
        },
        beforeSend: function (request) {
            request.setRequestHeader("sv", $("#SVCode").val());
        },
        success: function (result) {
            temp=JSON.parse(result)
            if (temp.retCode === "00000") {
                $("#CauthCode").val(temp.data);
                $("#sAuthCode").val(temp.data);
                $("#eAuthCode").val(temp.data);
                $("#dAuthCode").val(temp.data);
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

function UnReg() {
    $.ajax({
        url: '/Serv/ctrl/UnReg',
        type: "POST",
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        dataType: 'text',
        async: false,
        data: {
            authCode: $("#dAuthCode").val().toUpperCase(),
        },
        beforeSend: function (request) {
            request.setRequestHeader("sv", $("#SVCode").val());
        },
        success: function (result) {
            temp=JSON.parse(result)
            if (temp.retCode === "00000") {
                $("#Dresult").val(temp.data);
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

function SeaRegK() {
    $.ajax({
        url: '/Serv/ctrl/SeaRegK',
        type: "POST",
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        dataType: 'text',
        async: false,
        data: {
            qqNum: "",
            authCode: $("#sAuthCode").val().toUpperCase(),
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
            temp=JSON.parse(result)
            if (temp.retCode === "00000") {
                let sAuthCode = $("#sAuthCode").val()
                $("#SqqNum").val(temp.data.qqNum);
                $("#SstartDt").val(temp.data.startDt.substr(0, 8));
                $("#SendDt").val(temp.data.endDt.substr(0, 8));
                $("#Sprice").val(temp.data.price);
                $("#sUpdateDt").val(temp.data.updateDt);
                $("#sDevice").val(temp.data.device);
                $("#sLocalIp").val(temp.data.localIp);
                $("#eAuthCode").val(sAuthCode);
                $("#EqqNum").val(temp.data.qqNum);
                $("#eStartDt").val(temp.data.startDt.substr(0, 8));
                $("#eEndDt").val(temp.data.endDt.substr(0, 8));
                $("#eDevice").val(temp.data.device);
                $("#eLocalIp").val(temp.data.localIp);
                $("#Sdate").val(temp.data.endDt.substr(0, 8));
                $("#dAuthCode").val(sAuthCode);
                $("#eDate1").val(FormatMyDate(temp.data.endDt.substr(0, 8), 30));
                $("#eDate3").val(FormatMyDate(temp.data.endDt.substr(0, 8), 90));
                $("#eDate6").val(FormatMyDate(temp.data.endDt.substr(0, 8), 180));
                $("#eDate12").val(FormatMyDate(temp.data.endDt.substr(0, 8), 360));
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

function RegEdit() {
    $.ajax({
        url: '/Serv/ctrl/RegEdit',
        type: "POST",
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        dataType: 'text',
        async: false,
        data: {
            authCode: $("#eAuthCode").val().toUpperCase() ,
            device: $("#eDevice").val(),
            startDt: $("#eStartDt").val()+"000000",
            endDt: $("#eEndDt").val()+"235959",
            localIp: $("#eLocalIp").val(),
            price: $("#ePrice").val(),
        },
        beforeSend: function (request) {
            request.setRequestHeader("sv", $("#SVCode").val());
        },
        success: function (result) {
            temp=JSON.parse(result)
            if (temp.retCode === "00000") {
                $("#eResult").val(temp.data);
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

function FormatMyDate(data, aDay) {
    let tempDate = new Date();
    tempDate.setFullYear(parseInt(data.substr(0, 4)));
    tempDate.setMonth(parseInt(data.substr(4, 2)) - 1);
    tempDate.setDate(parseInt(data.substr(6, 2)));
    tempDate.setDate(tempDate.getDate() + parseInt(aDay));
    return "" + tempDate.getFullYear() + formatDate(tempDate.getMonth() + 1) + formatDate(tempDate.getDate());
}

function AutoCountDate() {
    let SData = $("#Sdate").val()
    $("#eDate1").val(FormatMyDate(SData, 30));
    $("#eDate3").val(FormatMyDate(SData, 90));
    $("#eDate6").val(FormatMyDate(SData, 180));
    $("#eDate12").val(FormatMyDate(SData, 360));

}

function CountDate() {
    $("#AddResult").val(FormatMyDate($("#Sdate").val(), $("#AddDay").val()));
}

function CleanAll() {
    $("#sAuthCode").val("");
    $("input.sv").val("");
}