$(function () {
    "use strict";
    //This is for the Notification top right
    Morris.Area({
        element: 'morris-area-chart2',
        data: [{
            period: '2010',
            iMac: 0,
            iPhone: 0,
            
        }, {
            period: '2011',
            iMac: 130,
            iPhone: 100,
            
        }, {
            period: '2012',
            iMac: 30,
            iPhone: 60,
            
        }, {
            period: '2013',
            iMac: 30,
            iPhone: 200,
            
        }, {
            period: '2014',
            iMac: 200,
            iPhone: 150,
            
        }, {
            period: '2015',
            iMac: 105,
            iPhone: 90,
            
        },
         {
            period: '2016',
            iMac: 250,
            iPhone: 150,
           
        }],
        xkey: 'period',
        ykeys: ['iMac', 'iPhone'],
        labels: ['iMac', 'iPhone'],
        pointSize: 0,
        fillOpacity: 0.7,
        pointStrokeColors:['#b4becb', '#0178fa'],
        behaveLikeLine: true,
        gridLineColor: '#e0e0e0',
        lineWidth: 0,
        smooth: true,
        hideHover: 'auto',
        lineColors: ['#b4becb', '#0178fa'],
        resize: true
        
    });

 // Morris donut chart
        
    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "Orders",
            value: 8500,

        }, {
            label: "Panding",
            value: 3630,
        }, {
            label: "Delivered",
            value: 4870
        }],
        resize: true,
        colors:['#0acf97', '#0178fa', '#4F5467']
    });
 
});    