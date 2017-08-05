// Load the Visualization API and the corechart package.
google.charts.load('current', {'packages':['corechart']});

// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChart);

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.

function drawChart() {

    var var1 = document.getElementById("sumIncome").value;
    var var2 = document.getElementById("sumExpense").value;
    var var3 = document.getElementById("sumDebt").value;
    var var4 = var1-var2-var3;

    var1 = eval(var1)
    var2 = eval(var2)
    var3 = eval(var3)
    var4 = eval(var4)

    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Tipo');
    data.addColumn('number', 'Monto');
    data.addRows([
        ['Gastos', var2],
        ['Deudas', var3],
        ['Saldo',  var4],
    ]);

    //Set Format
    var formatter = new google.visualization.NumberFormat({
        prefix: 'S/.'
    });
    formatter.format(data, 1);

    // Set chart options
    var options = {'title':'Resumen',
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