function osStart() {
    let vid = $("#vid").val()
    if (vid === "") {
        $("#SimCtrR").val("vid is null");
    } else {
        $.ajax({
            url: "/Serv/local/start",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            async: false,
            data: JSON.stringify({
                vid: vid
            }),
            success: function (results) {
                let result = JSON.parse(results);
                if (result.retCode === "00000") {
                    $("#SimCtrR").val(result.data);
                }
            },
            error: function (results) {
                console.error(results);
            }
        });
    }
}

function osReboot() {
    let vid = $("#vid").val()
    if (vid === "") {
        $("#SimCtrR").val("vid is null");
    } else {
        $.ajax({
            url: "/Serv/local/reboot",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            async: false,
            data: JSON.stringify({
                vid: vid
            }),
            success: function (results) {
                let result = JSON.parse(results);
                if (result.retCode === "00000") {
                    $("#SimCtrR").val(result.data);
                }
            },
            error: function (result) {
                console.error(result);
            }
        });
    }
}

function osStop() {
    let vid = $("#vid").val()
    if (vid === "") {
        $("#SimCtrR").val("vid is null");
    } else {
        $.ajax({
            url: "/Serv/local/stop",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            async: false,
            data: JSON.stringify({
                vid: vid
            }),
            success: function (results) {
                let result = JSON.parse(results);
                if (result.retCode === "00000") {
                    $("#SimCtrR").val(result.data);
                }
            },
            error: function (result) {
                console.error(result);
            }
        });
    }
}

function osSort() {
    $.ajax({
        url: "/Serv/local/sort",
        type: "GET",
        contentType: 'application/json',
        dataType: 'text',
        async: false,
        success: function (results) {
            let result = JSON.parse(results);
            if (result.retCode === "00000") {
                $("#SimCtrR").val(result.data);
            }
        },
        error: function (result) {
            console.error(result);
        }
    });
}

function bT() {
    $.ajax({
        url: "/Serv/bT",
        type: "GET",
        contentType: 'application/json',
        dataType: 'text',
        async: false,
        success: function (results) {
            let result = JSON.parse(results);
            if (result.retCode === "00000") {
                $("#ResultTool").val(result.data);
            }
        },
        error: function (result) {
            console.error(result);
        }
    });
}

function wol() {
    let mac = $("#computerStart").val();
    $.ajax({
        url: "/Serv/wol?mac=" + mac,
        type: "GET",
        contentType: 'application/json',
        dataType: 'text',
        async: false,
        success: function (results) {
            let result = JSON.parse(results);
            if (result.retCode === "00000") {
                $("#ResultTool").val(result.data);
            }
        },
        error: function (result) {
            console.error(result);
        }
    });
}

function sendGift() {
    let simID = $("#simID").val()
    let result = $("#sendVal").val()
    if (simID === "") {
        $("#sendResult").val("ID is null");
    } else if (result === "") {
        $("#sendResult").val("value is null");
    } else {
        $.ajax({
            url: "/Serv/megapolis/sendGift",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            async: false,
            data: JSON.stringify({
                id: simID,
                result: result
            }),
            success: function (results) {
                let result = JSON.parse(results);
                if (result.retCode === "00000") {
                    $("#sendResult").val(result.data);
                }
            },
            error: function (result) {
                console.error(result);
            }
        });
    }
}

function getSwitchAll() {
    $.ajax({
        url: "/Serv/megapolis/getSwitchAll",
        type: "POST",
        contentType: 'application/json',
        dataType: 'text',
        async: false,
        success: function (results) {
            let result = JSON.parse(results);
            if (result.retCode === "00000") {
                $("#getSwitchAllR").val(result.data);
            }
        },
        error: function (result) {
            console.error(result);
        }
    });
}

function getSwitch() {
    let nameK = $("#nameK").val()
    if (nameK === "") {
        $("#getSwitchAllR").val("name is null");
    } else {
        $.ajax({
            url: "/Serv/megapolis/getSwitch",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            async: false,
            data: {
                switchStatus: null,
                switchId: nameK
            },
            success: function (results) {
                let result = JSON.parse(results);
                if (result.retCode === "00000") {
                    $("#getSwitchAllR").val(result.data);
                }
            },
            error: function (result) {
                console.error(result);
            }
        });
    }
}

function setSwitch() {
    let nameK = $("#nameK").val()
    let valK = $("#valK").val()
    if (nameK === "") {
        $("#getSwitchAllR").val("switch is null");
    } else if (valK === "") {
        $("#getSwitchAllR").val("value is null");
    } else {
        $.ajax({
            url: "/Serv/megapolis/setSwitch",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            async: false,
            data: {
                switchId: nameK,
                switchStatus: valK
            },
            success: function (results) {
                let result = JSON.parse(results);
                if (result.retCode === "00000") {
                    $("#getSwitchAllR").val(result.data);
                }
            },
            error: function (result) {
                console.error(result);
            }
        });
    }
}

function addSwitch() {
    let nameK = $("#nameK").val()
    let jkg_value = $("#jkg_value").val()
    let jkg_remark = $("#jkg_remark").val()
    if (nameK === "") {
        $("#getSwitchAllR").val("switch is null");
    } else if (jkg_value === "") {
        $("#getSwitchAllR").val("value is null");
    } else if (jkg_remark === "") {
        $("#getSwitchAllR").val("remark is null");
    } else {
        $.ajax({
            url: "/Serv/megapolis/addSwitch",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            async: false,
            data: {
                switchId: nameK,
                switchStatus: jkg_value,
                remark: jkg_remark
            },
            success: function (results) {
                let result = JSON.parse(results);
                if (result.retCode === "00000") {
                    $("#getSwitchAllR").val(result.data);
                }
            },
            error: function (result) {
                console.error(result);
            }
        });
    }
}

function setState() {
    let vResult = 0;
    let name = $("#nameS").val()
    let status = $("#flag").val()
    if (name === "") {
        $("#setStateR").val("name is null");
    } else if (status === "") {
        $("#setStateR").val("flag is null");
    } else {
        $.ajax({
            url: "/Serv/megapolis/setSwitch",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            async: false,
            data: {
                switchStatus: name,
                switchId: "stateName"
            },
            success: function () {
                vResult = vResult + 1;
            },
            error: function (result) {
                console.error(result);
            }
        });
        $.ajax({
            url: "/Serv/megapolis/setSwitch",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            async: false,
            data: {
                switchStatus: status,
                switchId: "isChange"
            },
            success: function () {
                vResult = vResult + 1;
            },
            error: function (result) {
                console.error(result);
            }
        });
    }
    $("#setStateR").val(vResult);
}

function getHeart() {
    let key = $("#key").val()
    if (key === "") {
        $("#RHeart").val("key is null");
    } else {
        $.ajax({
            url: "/Serv/zuk/getToolHeart",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            data: {
                code: key,
                toolName: $('#packageName option:selected').val(),
                status: null
            },
            success: function (results) {
                let result = JSON.parse(results);
                if (result.retCode === "00000") {
                    $("#RHeart").val(result.data);
                }
            },
            error: function (result) {
                console.error(result);
            }
        });
    }
}

function setContractOperation() {
    let name = $("#nameC").val()
    let operation = $("#operate").val().replace(/{/g, "(").replace(/}/g, ")")
    if (name === "") {
        $("#setContractOperateR").val("name is null");
    } else if (operation === "") {
        $("#setContractOperateR").val("operate is null");
    } else {
        $.ajax({
            url: "/Serv/zuk/setContractOperation",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            data: {
                name: name,
                operation: operation
            },
            success: function (results) {
                let result = JSON.parse(results);
                if (result.retCode === "00000") {
                    $("#setContractOperateR").val(result.data);
                }
            },
            error: function (result) {
                console.error(result);
            }
        });
    }
}

function getContractOperation() {
    let name = $("#nameC").val()
    if (name === "") {
        $("#getContractOperateR").val("name is null");
    } else {
        $.ajax({
            url: "/Serv/zuk/getContractOperation",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            data: {
                name: name
            },
            success: function (results) {
                let result = JSON.parse(results);
                if (result.retCode === "00000") {
                    $("#getContractOperateR").val(result.data.operate);
                    $("#updateDt").val(result.data.updateDt);
                }
            },
            error: function (result) {
                console.error(result);
            }
        });
    }
}

function setContractTime() {
    let nameC = $("#nameC").val()
    let timeV = $("#timeV").val()
    if (nameC === "") {
        $("#setContractTimeR").val("name is null");
    } else if (timeV === "") {
        $("#setContractTimeR").val("time is null");
    } else {
        $.ajax({
            url: "/Serv/zuk/setContractTime",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            data: {
                name: nameC,
                time: timeV
            },
            success: function (results) {
                let result = JSON.parse(results);
                if (result.retCode === "00000") {
                    $("#setContractTimeR").val(result.data);
                }
            },
            error: function (result) {
                console.error(result);
            }
        });
    }
}

function getContractTime() {
    let name = $("#nameC").val()
    if (name === "") {
        $("#getContractTimeR").val("name is null");
    } else {
        $.ajax({
            url: "/Serv/zuk/getContractTime",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded;charset=utf-8',
            dataType: 'text',
            data: {
                name: name
            },
            success: function (results) {
                let result = JSON.parse(results);
                if (result.retCode === "00000") {
                    $("#getContractTimeR").val(result.data);
                }
            },
            error: function (result) {
                console.error(result);
            }
        });
    }
}


function pauseASS() {
    $.ajax({
        url: "/Serv/megapolis/setSwitch",
        type: "POST",
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        dataType: 'text',
        async: false,
        data: {
            switchId: "stop_tool",
            switchStatus: "2"
        },
        success: function (results) {
            let result = JSON.parse(results);
            if (result.retCode === "00000") {
                if (parseInt(result.data) > 0) {
                    $("#ResultTool").val("暂停辅助命令已发出");
                } else {
                    $("#ResultTool").val("暂停辅助失败");
                }
            }
        },
        error: function (result) {
            console.error(result);
        }
    });
}

function stopASS() {
    $.ajax({
        url: "/Serv/megapolis/setSwitch",
        type: "POST",
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        dataType: 'text',
        async: false,
        data: {
            switchId: "stop_tool",
            switchStatus: "1"
        },
        success: function (results) {
            let result = JSON.parse(results);
            if (result.retCode === "00000") {
                if (parseInt(result.data) > 0) {
                    $("#ResultTool").val("停止辅助命令已发出");
                } else {
                    $("#ResultTool").val("停止辅助失败");
                }
            }
        },
        error: function (result) {
            console.error(result);
        }
    });
}

function stopDeamon() {
    $.ajax({
        url: "/Serv/megapolis/setSwitch",
        type: "POST",
        contentType: 'application/x-www-form-urlencoded;charset=utf-8',
        dataType: 'text',
        async: false,
        data: {
            switchId: "stop_zuk_tool",
            switchStatus: "1"
        },
        success: function (results) {
            let result = JSON.parse(results);
            if (result.retCode === "00000") {
                if (parseInt(result.data) > 0) {
                    $("#ResultTool").val("停止守护命令已发出");
                } else {
                    $("#ResultTool").val("停止守护失败");
                }
            }
        },
        error: function (result) {
            console.error(result);
        }
    });
}