// 指定图表的配置项和数据


option = {
    title: {
        text: '用户特点',
        link: '#',
        x: 'center',
        textStyle: {
            fontSize: 23
        }
    },
    backgroundColor: '#F7F7F7',
    tooltip: {
        show: true
    },
    toolbox: {
        feature: {
            saveAsImage: {
                iconStyle: {
                    normal: {
                        color: '#FFFFFF'
                    }
                }
            }
        }
    },
    series: [{
        name: '用户特点',
        type: 'wordCloud',
        //size: ['9%', '99%'],
        sizeRange: [6, 66],
        //textRotation: [0, 45, 90, -45],
        rotationRange: [-45, 90],
        //shape: 'circle',
        textPadding: 0,
        autoSize: {
            enable: true,
            minSize: 16
        },
        textStyle: {
            normal: {
                color: function() {
                    return 'rgb(' + [
                        Math.round(Math.random() * 160),
                        Math.round(Math.random() * 160),
                        Math.round(Math.random() * 160)
                    ].join(',') + ')';
                }
            },
            emphasis: {
                shadowBlur: 10,
                shadowColor: '#333'
            }
        },
        data: []
    }]
};

/**
 var JosnList = [];
 JosnList.push({
            name: "Jayfee",
            value: 666
        }, {
            name: "Nancy",
            value: 520
        }, {
            name: "生活资源",
            value: "999"
        });
 option.series[0].data = JosnList;
 **/
//myChart.setOption(option);
/* myChart.on('click', function (params) {
     //alert((params.name));
     window.open('https://www.baidu.com/s?wd=' + encodeURIComponent(params.name));

 });*/
var myChart;

$(function(){
    //setEchartData("/user/getUserPersona/13302340995");

    // 基于准备好的dom，初始化echarts实例
    myChart = echarts.init(document.getElementById('content'));
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    //myChart.hidden;
});

function setEchartData(url){
    $.getJSON(url, function(result) { //返回的是json数组
        if (result) {
            var echarTitle="";
            var JosnList = [];
            $.each(result, function(i, field){
                echarTitle=field.acc_nbr;
                JosnList=field.personaValue;
            });
            //myChart.hideLoading();
            option.series[0].data = JosnList;
            option.title.text=echarTitle;
            myChart.setOption(option);
        }
        else
            alert(result);
    });
};

function searchNbr(){
    var bashUrl="/user/getUserPersona/";
    var nbr=$("#acc_nbr").val();
    if(nbr.length>11){
        alert("手机号超长");
        return ;
    }else if(nbr.length<11){
        if(getNbr(nbr))
            setEchartData(bashUrl+nbr);
    }else{
        setEchartData(bashUrl+nbr);
    }
}

function  getNbr(nbr) {
    url="/user/getUserNbr/"+nbr;
 /*   $.get(url,'',function(result) {
        alert(result);
    },"json");*/

    $.getJSON(url, function(result) { //返回的是json数组
        if (result) {
            strNbr="";
            $.each(result, function(i, field){
                strNbr=strNbr+", "+field.acc_nbr;
                if(i % 5==0)
                    strNbr+="<br> "
            });
            $("#nbrDiv").html(strNbr);
            return true;
        }else{
            alert("获取手机号出错！");
            return false;
        }
    });
    return false;
}

