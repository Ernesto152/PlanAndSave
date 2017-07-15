// Load the Visualization API and the corechart package.
google.charts.load('current', {'packages':['corechart']});

// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChart);

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart() {

    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Topping');
    data.addColumn('number', 'Slices');
    data.addRows([
        ['Gasto',   1800],
        ['Deuda',   3000],
        ['Saldo',   4700]
    ]);

    //Set Format
    var formatter = new google.visualization.NumberFormat({
        prefix: 'S/.'
    });
    formatter.format(data, 1);

    // Set chart options
    var options = {'title':'Resumen de Ingresos',
        fontName: 'Arial',
        colors:['#CC0000', '#FF8C00', '#1E90FF'],
        pieSliceText: 'value',
        'height': 600};

    var chart = new google.visualization.PieChart(document.getElementById('chart_div1'));
    chart.draw(data, options);
}

$(window).resize(function(){
    drawChart();
});