function loadChartForSentiment(id, title, data, yaxisTitle) {
	console.log(data);
	
    $('#'+id).highcharts({
	
	    chart: {
	        type: 'gauge',
	        plotBackgroundColor: null,
	        plotBackgroundImage: null,
	        plotBorderWidth: 0,
	        plotShadow: true
	    },
	    
	    title: {
	        text: title
	    },
	    
	    pane: {
	        startAngle: -150,
	        endAngle: 150,
	        background: [{
	            backgroundColor: {
	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	                stops: [
	                    [0, '#FFF'],
	                    [1, '#333']
	                ]
	            },
	            borderWidth: 0,
	            outerRadius: '109%'
	        }, {
	            backgroundColor: {
	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	                stops: [
	                    [0, '#333'],
	                    [1, '#FFF']
	                ]
	            },
	            borderWidth: 1,
	            outerRadius: '107%'
	        }, {
	            // default background
	        }, {
	            backgroundColor: '#DDD',
	            borderWidth: 0,
	            outerRadius: '105%',
	            innerRadius: '103%'
	        }]
	    },
	       
	    // the value axis
	    yAxis: {
	        min: 0,
	        max: 100,
	        
	        minorTickInterval: 'auto',
	        minorTickWidth: 1,
	        minorTickLength: 10,
	        minorTickPosition: 'inside',
	        minorTickColor: '#666',
	
	        tickPixelInterval: 30,
	        tickWidth: 2,
	        tickPosition: 'inside',
	        tickLength: 10,
	        tickColor: '#666',
	        labels: {
	            step: 2,
	            rotation: 'auto'
	        },
	        title: {
	            text: yaxisTitle
	        },
	        plotBands: [{
	            from: 0,
	            to: 50,
	            color: '#55BF3B' // green
	        }, {
	            from: 50,
	            to: 80,
	            color: '#DDDF0D' // yellow
               
	        }, {
	            from: 80,
	            to: 100,
	            color: '#DF5353' // red
	        }]        
	    },
	
	    series: [{
	        name: 'Score',
	        data: [Math.round(data)],
	        tooltip: {
	            valueSuffix: '%'
	        }
	    }]
	
	});
}


function plotData (clas, title, subtitle, yaxistitle, series, plotBand, pointItvalms, startTime) {
    $('.'+clas).highcharts({
        chart: {
            type: 'spline'
        },
        title: {
            text: title
        },
        subtitle: {
            text: subtitle
        },
        xAxis: {
            type: 'datetime',
            labels: {
                overflow: 'justify'
            }
        },
        yAxis: {
            title: {
                text: yaxistitle
            },
            min: 0,
            minorGridLineWidth: 0,
            gridLineWidth: 0,
            alternateGridColor: null,
            plotBands: plotBand
        },
        tooltip: {
            valueSuffix: ''
        },
        plotOptions: {
            spline: {
                lineWidth: 1,
                states: {
                    hover: {
                        lineWidth: 2
                    }
                },
                marker: {
                    enabled: false
                },
                pointInterval: pointItvalms, // one hour
                pointStart: startTime
            }
        },
        series: series
        ,
        navigation: {
            menuItemStyle: {
                fontSize: '10px'
            }
        }
    });
}